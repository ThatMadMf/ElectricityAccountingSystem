package org.system.invoice;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("user/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("account/{id}")
    public List<InvoiceDto> getInvoicesByAccount(@PathVariable("id") int id) {
        return invoiceService.getInvoicesByAccountId(id);
    }

    @GetMapping
    public List<InvoiceDto> getAllUserInvoices(@AuthenticationPrincipal Principal principal) {
        return invoiceService.getAllUserInvoices(principal.getName());
    }

}
