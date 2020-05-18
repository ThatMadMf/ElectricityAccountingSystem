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

    public List<InvoiceDto> getAllUserInvoices(String login) {
        return invoiceRepository.getAllInvoicesByUserLogin(login);
    }

    public List<InvoiceDto> getAllInvoicesByStateId(int id) {
        return invoiceRepository.getAllInvoicesByStateId(id);
    }

    public List<InvoiceDto> getAllInvoicesByCityId(int id) {
        return invoiceRepository.getAllInvoicesByCityId(id);
    }

    public void addInvoice(InvoiceDto invoiceDto) {
        invoiceRepository.addInvoice(invoiceDto);
    }
}
