package org.system.invoice;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.system.util.ResourceReader;

import java.util.List;

@Repository
public class InvoiceRepository {

    private static final String RESOURCE_PATH = "sql/invoice/";
    private static final String GET_INVOICES_BY_ACCOUNT_ID = getSql("get_invoices_by_account_id.sql");

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<InvoiceDto> invoiceDtoRowMapper;

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }

    public InvoiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        invoiceDtoRowMapper = new BeanPropertyRowMapper<>(InvoiceDto.class);
    }

    public List<InvoiceDto> getInvoicesByAccountId(int id) {
        return jdbcTemplate.query(GET_INVOICES_BY_ACCOUNT_ID, new Object[]{id}, invoiceDtoRowMapper);
    }
}
