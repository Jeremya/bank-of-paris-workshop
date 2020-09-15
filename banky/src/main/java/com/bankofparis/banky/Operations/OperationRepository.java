package com.bankofparis.banky.Operations;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends CassandraRepository<Operation, OperationPrimaryKey> {
    List<Operation> findByIban(String iban);

}
