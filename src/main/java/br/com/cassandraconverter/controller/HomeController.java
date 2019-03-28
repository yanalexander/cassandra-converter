package br.com.cassandraconverter.controller;

import br.com.cassandraconverter.repository.CassandraInvoiceRepository;
import br.com.cassandraconverter.service.InvoiceCassandraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope("session")
public class HomeController
{
    @Autowired
    private CassandraInvoiceRepository cassandraInvoiceRepository;

    @Autowired
    private InvoiceCassandraService invoiceCassandraService;

    @GetMapping("/")
    public String index(ModelMap model)
    {
        invoiceCassandraService.convertMySqlDataToCassanda();
        return "index";
    }

}

