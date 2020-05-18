package org.system.invoice;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("user/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("account/{id}")
    public String getInvoicesByAccount(@PathVariable("id") int id, Model model) {
        model.addAttribute("message", "Invoices of account with id" + id);
        model.addAttribute("link", "user/accounts");
        model.addAttribute("linkText", "back to accounts");
        model.addAttribute("invoices", invoiceService.getInvoicesByAccountId(id));
        return "invoices";
    }

    @GetMapping
    public String getAllUserInvoices(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("message", "All invoices given to your profile");
        model.addAttribute("link", "user");
        model.addAttribute("linkText", "Back to profile");
        model.addAttribute("invoices", invoiceService.getAllUserInvoices(principal.getName()));
        return "invoices";
    }

}
