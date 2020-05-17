package org.system.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.system.util.ResourceReader;

@Repository
public class UserRepository {

    private static final String RESOURCE_PATH = "sql/user/";
    private static final String GET_LOGIN_DATA = getSql("get_login_data_by_email.sql");

    private final BeanPropertyRowMapper<LoginDto> loginRowMapper;
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        loginRowMapper = new BeanPropertyRowMapper<>(LoginDto.class);
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

}
