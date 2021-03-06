package org.system.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.system.account.AccountDto;
import org.system.exception.NoRowUpdatedException;
import org.system.exception.RowNotFoundException;
import org.system.user.dtos.LoginDto;
import org.system.user.dtos.UserDto;
import org.system.util.ResourceReader;

@Repository
public class UserRepository {

    private static final String RESOURCE_PATH = "sql/user/";
    private static final String GET_LOGIN_DATA = getSql("get_login_data_by_email.sql");
    private static final String GET_ALL_DATA_BY_LOGIN = getSql("get_all_user_data_by_login.sql");
    private static final String GET_USER_ID_BY_LOGIN = getSql("get_user_id_by_login.sql");
    private static final String ADD_ACCOUNT = getSql("add_account.sql");

    private final BeanPropertyRowMapper<LoginDto> loginRowMapper;
    private final BeanPropertyRowMapper<UserDto> userDtoRowMapper;
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        loginRowMapper = new BeanPropertyRowMapper<>(LoginDto.class);
        userDtoRowMapper = new BeanPropertyRowMapper<>(UserDto.class);
    }

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }

    public UserDetails findByLogin(String login) {
        LoginDto loginDto = jdbcTemplate.queryForObject(GET_LOGIN_DATA, new Object[]{login}, loginRowMapper);
        User.UserBuilder builder;
        builder = User.withUsername(loginDto.getLogin());
        builder.password(loginDto.getPassword());
        builder.roles(loginDto.getRole());
        return builder.build();
    }

    public UserDto getUserInfoByLogin(String name) {
        return jdbcTemplate.queryForObject(GET_ALL_DATA_BY_LOGIN, new Object[]{name}, userDtoRowMapper);
    }

    public int getUserIdByLogin(String login) {
        Integer integer = jdbcTemplate.queryForObject(GET_USER_ID_BY_LOGIN, new Object[]{login}, Integer.class);
        if (integer == null) {
            throw new RowNotFoundException("Could not find user with this login");
        }

        return integer;
    }

    public void addAccount(AccountDto accountDto) {
        int rowNum = jdbcTemplate.update(ADD_ACCOUNT, accountDto.getUserId(), accountDto.getStreet(), accountDto.getHouse(),
                accountDto.getApartment(), accountDto.getCity(), accountDto.getTariffName());
        if(rowNum != 1) {
            throw new NoRowUpdatedException("No rows updated");
        }
    }
}
