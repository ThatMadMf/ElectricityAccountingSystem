package org.system.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.system.invoice.InvoiceService;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final InvoiceService invoiceService;

    public AdminController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public String getAdminPanel(Model model) {
        return "admin";
    }

    @GetMapping("invoices-state/{id}")
    public String getAllInvoicesByState(@PathVariable("id") int id, Model model) {
        model.addAttribute("message", "All invoices in state with id " + id);
        model.addAttribute("link", "admin");
        model.addAttribute("linkText", "Back to admin");
        model.addAttribute("invoices", invoiceService.getAllInvoicesByStateId(id));
        return "invoices";
    }

    @GetMapping("invoices-city/{id}")
    public String getAllInvoicesByCity(@PathVariable("id") int id, Model model) {
        model.addAttribute("message", "All invoices in city with id " + id);
        model.addAttribute("link", "admin");
        model.addAttribute("linkText", "Back to admin");
        model.addAttribute("invoices", invoiceService.getAllInvoicesByCityId(id));
        return "invoices";
    }
}
