package com.bankofparis.banky.Operations;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.Date;

@PrimaryKeyClass
@Data
public class OperationPrimaryKey implements Serializable {
    @PrimaryKeyColumn(name = "iban", type = PrimaryKeyType.PARTITIONED)
    private String iban;

    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    @PrimaryKeyColumn(name = "date_operation", type = PrimaryKeyType.CLUSTERED)
    private Date date_operation;
}
