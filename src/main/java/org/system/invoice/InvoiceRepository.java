package org.system.invoice;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.system.exception.NoRowUpdatedException;
import org.system.user.UserRepository;
import org.system.util.ResourceReader;

import java.time.LocalDate;
import java.util.List;

@Repository
public class InvoiceRepository {

    private static final String RESOURCE_PATH = "sql/invoice/";
    private static final String GET_INVOICES_BY_ACCOUNT_ID = getSql("get_invoices_by_account_id.sql");
    private static final String GET_INVOICES_BY_USER_ID = getSql("get_invoices_by_user_id.sql");
    private static final String GET_INVOICES_BY_STATE_ID = getSql("get_invoices_by_state_id.sql");
    private static final String GET_INVOICES_BY_CITY_ID = getSql("get_invoices_by_city_id.sql");
    private static final String ADD_INVOICE = getSql("add_invoice.sql");

    private final JdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;
    private final BeanPropertyRowMapper<InvoiceDto> invoiceDtoRowMapper;

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }

    public InvoiceRepository(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
        invoiceDtoRowMapper = new BeanPropertyRowMapper<>(InvoiceDto.class);
    }

    public List<InvoiceDto> getInvoicesByAccountId(int id) {
        return jdbcTemplate.query(GET_INVOICES_BY_ACCOUNT_ID, new Object[]{id}, invoiceDtoRowMapper);
    }

    public List<InvoiceDto> getAllInvoicesByUserLogin(String login) {
        int userId = userRepository.getUserIdByLogin(login);
        return jdbcTemplate.query(GET_INVOICES_BY_USER_ID, new Object[]{userId}, invoiceDtoRowMapper);
    }

    public List<InvoiceDto> getAllInvoicesByStateId(int id) {
        return jdbcTemplate.query(GET_INVOICES_BY_STATE_ID, new Object[]{id}, invoiceDtoRowMapper);
    }

    public List<InvoiceDto> getAllInvoicesByCityId(int id) {
        return jdbcTemplate.query(GET_INVOICES_BY_CITY_ID, new Object[]{id}, invoiceDtoRowMapper);
    }

    public void addInvoice(InvoiceDto invoiceDto) {
        int rowsUpdated = jdbcTemplate.update(ADD_INVOICE, invoiceDto.getAccountId(), invoiceDto.getElectricityUnits(),
                LocalDate.now());
        if (rowsUpdated != 1) {
            throw new NoRowUpdatedException("Could not add invoice");
        }
    }
}
