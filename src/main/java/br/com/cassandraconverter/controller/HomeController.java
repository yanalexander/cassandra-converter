package br.com.cassandraconverter.controller;

import br.com.cassandraconverter.model.InvoiceCassandra;
import br.com.cassandraconverter.model.InvoiceHeader;
import br.com.cassandraconverter.repository.InvoiceCassandraRepository;
import br.com.cassandraconverter.service.InvoiceCassandraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Scope("session")
public class HomeController
{
    @Autowired
    private InvoiceCassandraRepository cassandraInvoiceRepository;

    @Autowired
    private InvoiceCassandraService invoiceCassandraService;

    @GetMapping("/")
    public String index(ModelMap model)
    {
        return "/index";
    }

    @GetMapping("/reimport")
    public String reimport()
    {
        invoiceCassandraService.convertMySqlDataToCassanda();
        return "/index";
    }

    @RequestMapping(value="/select", method = RequestMethod.GET)
    public String select(@RequestParam("invoiceNumber") Integer invoiceNumber, RedirectAttributes attr, ModelMap model){
        List<InvoiceCassandra> listInvoice = cassandraInvoiceRepository.findByInvoice_number(invoiceNumber);

        if(listInvoice.size() > 0){
            attr.addFlashAttribute("success", "Total de itens da nota "+listInvoice.size());
        }else{
            attr.addFlashAttribute("fail", "Invoice number "+invoiceNumber+" is not valid.");
        }

        InvoiceHeader header = new InvoiceHeader();
        header.setCostumer_name(listInvoice.get(0).getCostumer_name());
        header.setCostumer_address(listInvoice.get(0).getCostumer_address());
        header.setCostumer_country(listInvoice.get(0).getCostumer_country());
        header.setInvoice_date(listInvoice.get(0).getInvoice_date());
        header.setInvoice_number(listInvoice.get(0).getInvoice_number());
        header.setInvoice_value(listInvoice.get(0).getInvoice_value());

        model.addAttribute("invoices", listInvoice);
        model.addAttribute("header", header);

        return "/index";
    }

    @RequestMapping(value="/print/{invoiceId}", method = RequestMethod.GET)
    public String print(@PathVariable("invoiceId") Integer invoiceId, ModelMap model){
        System.out.println("Invoice "+invoiceId);
        return "/index";
    }

}

