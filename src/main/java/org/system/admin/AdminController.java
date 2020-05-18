package org.system.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.system.invoice.InvoiceDto;
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

    @GetMapping("new-invoice")
    public String getNewInvoiceForm(Model model) {
        model.addAttribute("invoice", new InvoiceDto());
        return "new-invoice";
    }

    @PostMapping("new-invoice")
    public String processNewInvoice(@ModelAttribute InvoiceDto invoiceDto, Model model) {
        invoiceService.addInvoice(invoiceDto);

        model.addAttribute("success", true);

        return "submission-result";
    }
}
