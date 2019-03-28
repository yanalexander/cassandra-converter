package br.com.cassandraconverter.service;

import br.com.cassandraconverter.utils.MySqlConnect;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class InvoiceCassandraService {
    private MySqlConnect mySqlConnect = new MySqlConnect();

    public void convertMySqlDataToCassanda(){
        try {
            Connection conn = mySqlConnect.getConnect();



        }catch (SQLException exc){
            System.out.println(exc.getMessage());
        }
    }

    //Select Consulting
    /*select c.name                  customer_name,
    c.address               customer_address,
    c.country               customer_country,
    i.number                invoice_number,
    i.emission_date         invoice_date,
    i.value                 invoice_value,
    it.quantity             item_quantity,
    it.unit_value           item_unit_value,
    it.tax_percent          item_tax_percent,
    it.discount_percent     item_discount_percent,
    it.subtotal             item_subtotal,
    s.service_description   service_description,
    d.name_department       department_name,
    r.name                  resource_name,
    rq.qualificatin_name as qualification_name
    from customer c
    join invoice i on i.customer_id = c.id_customer
    join invoice_item it on it.invoice_id = i.number
    join service s on s.service_id = it.service_id
    join resource r on r.id_resource = it.resource_id
    join department d on r.department = d.id_department
    join resource_qualification_assignement rqa on rqa.resource_id = r.id_resource
    join resource_qualification rq on rq.id_resource_qualification = rqa.qualification_id
    *//*where i.number = 1242392*//*
    order by c.id_customer, i.number;*/

    /*
    Book javaBook = new Book(
            UUIDs.timeBased(), "Head First Java", "O'Reilly Media",
            ImmutableSet.of("Computer", "Software"));
bookRepository.save(ImmutableSet.of(javaBook));*/


}
