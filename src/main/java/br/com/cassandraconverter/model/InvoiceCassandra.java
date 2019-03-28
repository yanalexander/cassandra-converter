package br.com.cassandraconverter.model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Table("invoice_cassandra")
public class InvoiceCassandra implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private String costumer_name;
    private String costumer_address;
    private String costumer_country;
    private Long invoice_number;
    private Date invoice_date;
    private Double invoice_value;
    private Integer item_quantity;
    private Double item_unit_value;
    private Double item_tax_percent;
    private Double item_discount_percent;
    private Double item_subtotal;
    private String service_description;
    private String department_name;
    private String qualification_name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Integer getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(Integer item_quantity) {
        this.item_quantity = item_quantity;
    }

    public Double getItem_unit_value() {
        return item_unit_value;
    }

    public void setItem_unit_value(Double item_unit_value) {
        this.item_unit_value = item_unit_value;
    }

    public Double getItem_tax_percent() {
        return item_tax_percent;
    }

    public void setItem_tax_percent(Double item_tax_percent) {
        this.item_tax_percent = item_tax_percent;
    }

    public Double getItem_discount_percent() {
        return item_discount_percent;
    }

    public void setItem_discount_percent(Double item_discount_percent) {
        this.item_discount_percent = item_discount_percent;
    }

    public Double getItem_subtotal() {
        return item_subtotal;
    }

    public void setItem_subtotal(Double item_subtotal) {
        this.item_subtotal = item_subtotal;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getQualification_name() {
        return qualification_name;
    }

    public void setQualification_name(String qualification_name) {
        this.qualification_name = qualification_name;
    }
}
