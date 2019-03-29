package br.com.cassandraconverter.repository;

import br.com.cassandraconverter.model.InvoiceCassandra;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceCassandraRepository extends CrudRepository<InvoiceCassandra, UUID> {

    @Query("Select * from invoice_cassandra where invoice_number=?0 allow filtering")
    List<InvoiceCassandra> findByInvoice_number(long invoice_number);

}
