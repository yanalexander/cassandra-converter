package br.com.cassandraconverter.repository;

import br.com.cassandraconverter.model.InvoiceCassandra;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CassandraInvoiceRepository extends CassandraRepository<InvoiceCassandra, UUID> {
}
