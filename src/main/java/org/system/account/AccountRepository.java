package org.system.account;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.system.user.UserRepository;
import org.system.util.ResourceReader;

import java.util.List;

@Repository
public class AccountRepository {

    private static final String RESOURCE_PATH = "sql/account/";
    private static final String GET_ALL_USER_ACCOUNTS = getSql("get_all_user_accounts_by_id.sql");

    private final JdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;
    private final BeanPropertyRowMapper<AccountDto> accountDtoBeanPropertyRowMapper;

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }

    public AccountRepository(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
        this.accountDtoBeanPropertyRowMapper = new BeanPropertyRowMapper<>(AccountDto.class);
    }

    public List<AccountDto> getAllAccountsByLogin(String name) {
        int userId = userRepository.getUserIdByLogin(name);
        return jdbcTemplate.query(GET_ALL_USER_ACCOUNTS, new Object[]{userId}, accountDtoBeanPropertyRowMapper);
    }
}
