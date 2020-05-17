package org.system.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.invoice.InvoiceDto;
import org.system.invoice.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    private final InvoiceService invoiceService;

    public AdminController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("invoices-state/{id}")
    public List<InvoiceDto> getAllInvoicesByState(@PathVariable("id") int id) {
        return invoiceService.getAllInvoicesByStateId(id);
    }
}
