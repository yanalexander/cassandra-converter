package br.com.cassandraconverter.model;

import java.util.Date;

public class InvoiceHeader {

    private String costumer_name;
    private String costumer_address;
    private String costumer_country;
    private Long invoice_number;
    private Date invoice_date;
    private Double invoice_value;

    public String getCostumer_name() {
        return costumer_name;
    }

    public void setCostumer_name(String costumer_name) {
        this.costumer_name = costumer_name;
    }

    public String getCostumer_address() {
        return costumer_address;
    }

    public void setCostumer_address(String costumer_address) {
        this.costumer_address = costumer_address;
    }

    public String getCostumer_country() {
        return costumer_country;
    }

    public void setCostumer_country(String costumer_country) {
        this.costumer_country = costumer_country;
    }

    public Long getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(Long invoice_number) {
        this.invoice_number = invoice_number;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public Double getInvoice_value() {
        return invoice_value;
    }

    public void setInvoice_value(Double invoice_value) {
        this.invoice_value = invoice_value;
    }
}
