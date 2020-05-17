package org.system.invoice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceDto> getInvoicesByAccountId(int id) {
        return invoiceRepository.getInvoicesByAccountId(id);
    }
}
