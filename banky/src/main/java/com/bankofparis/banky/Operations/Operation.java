package com.bankofparis.banky.Operations;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@Table("operations_by_iban")
public class Operation {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String iban;

    @Column("operation_id")
    private UUID id;

    private String label;

    @CassandraType(type = Name.TIMESTAMP)
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Date date_operation;

    @CassandraType(type = Name.TIMESTAMP)
    private Date date_validation;

    private Float amount;
    private String firstname;
    private String lastname;
    private String city;
    private String country;

    @Override
    public String toString() {
        return "Operation{" +
                "iban='" + iban + '\'' +
                ", id=" + id +
                ", label='" + label + '\'' +
                ", date_operation=" + date_operation +
                ", date_validation=" + date_validation +
                ", amount=" + amount +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
