package br.com.cassandaconverter.repository;

import br.com.cassandaconverter.model.cassandra.InvoiceCassandra;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CassandraInvoiceRepository extends CassandraRepository<InvoiceCassandra,UUID> {
}
