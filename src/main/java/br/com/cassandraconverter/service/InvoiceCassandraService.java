package br.com.cassandraconverter.service;

import br.com.cassandraconverter.model.InvoiceCassandra;
import br.com.cassandraconverter.repository.InvoiceCassandraRepository;
import br.com.cassandraconverter.utils.MySqlConnect;
import com.datastax.driver.core.utils.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class InvoiceCassandraService {

    @Autowired
    private InvoiceCassandraRepository invoiceCassandraRepository;

    public void convertMySqlDataToCassanda(){
        try {
            final Connection conn = MySqlConnect.getConnect();

            String query = "select c.name       customer_name,\n" +
                    "    c.address               customer_address,\n" +
                    "    c.country               customer_country,\n" +
                    "    i.number                invoice_number,\n" +
                    "    i.emission_date         invoice_date,\n" +
                    "    i.value                 invoice_value,\n" +
                    "    it.quantity             item_quantity,\n" +
                    "    it.unit_value           item_unit_value,\n" +
                    "    it.tax_percent          item_tax_percent,\n" +
                    "    it.discount_percent     item_discount_percent,\n" +
                    "    it.subtotal             item_subtotal,\n" +
                    "    s.service_description   service_description,\n" +
                    "    d.name_department       department_name,\n" +
                    "    r.name                  resource_name,\n" +
                    "    rq.qualificatin_name as qualification_name\n" +
                    "    from customer c\n" +
                    "    join invoice i on i.customer_id = c.id_customer\n" +
                    "    join invoice_item it on it.invoice_id = i.number\n" +
                    "    join service s on s.service_id = it.service_id\n" +
                    "    join resource r on r.id_resource = it.resource_id\n" +
                    "    join department d on r.department = d.id_department\n" +
                    "    join resource_qualification_assignement rqa on rqa.resource_id = r.id_resource\n" +
                    "    join resource_qualification rq on rq.id_resource_qualification = rqa.qualification_id\n" +
                    "    order by c.id_customer, i.number";

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            invoiceCassandraRepository.deleteAll();

            while(rs.next()){
                InvoiceCassandra invoice = new InvoiceCassandra();

                invoice.setCostumer_name(rs.getString("customer_name"));
                invoice.setCostumer_address(rs.getString("customer_address"));
                invoice.setCostumer_country(rs.getString("customer_country"));
                invoice.setInvoice_number(rs.getLong("invoice_number"));
                invoice.setInvoice_date(rs.getDate("invoice_date"));
                invoice.setInvoice_value(rs.getDouble("invoice_value"));
                invoice.setItem_quantity(rs.getInt("item_quantity"));
                invoice.setItem_unit_value(rs.getDouble("item_unit_value"));
                invoice.setItem_tax_percent(rs.getDouble("item_tax_percent"));
                invoice.setItem_discount_percent(rs.getDouble("item_discount_percent"));
                invoice.setItem_subtotal(rs.getDouble("item_subtotal"));
                invoice.setService_description(rs.getString("service_description"));
                invoice.setDepartment_name(rs.getString("department_name"));
                invoice.setResource_name(rs.getString("resource_name"));
                invoice.setQualification_name(rs.getString("qualification_name"));

                this.saveInvoice(invoice);
            }

        }catch (SQLException exc){
            System.out.println(exc.getMessage());
        }
    }

    private void saveInvoice(InvoiceCassandra invoice){
        invoice.setId(UUIDs.timeBased());
        invoiceCassandraRepository.save(invoice);
    }
}
