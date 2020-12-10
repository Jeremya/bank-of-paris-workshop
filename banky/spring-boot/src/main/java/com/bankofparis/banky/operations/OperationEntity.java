package com.bankofparis.banky.operations;

import com.datastax.oss.driver.api.mapper.annotations.ClusteringColumn;
import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@CqlName(OperationEntity.OPERATION_TABLE)
public class OperationEntity implements Serializable {

    public static final String OPERATION_TABLE  = "operations_by_iban";

    /** Serial. */
    private static final long serialVersionUID = 7407715795842376538L;

    public OperationEntity() {
    }

    public OperationEntity(String iban) {
        this.iban = iban;
    }

    @PartitionKey
    private String iban;

    @ClusteringColumn
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Instant date_operation;

    @CqlName("operation_id") // use this annotation if Cassandra column names does not match java attribute name
    private UUID id;

    private String label;

    /**
     *  A CQL Date is mapped as java LocalDate
     * - Date      <-> java.time.LocalDate
     * - Timestamp <-> java.time.Instant
     * - Time      <-> java.time.LocalTime
     *
     * @see https://docs.datastax.com/en/developer/java-driver/4.9/manual/core/#cql-to-java-type-mapping
     */
    private Instant date_validation;

    private Float amount;

    private String firstname;

    private String lastname;

    private String city;

    private String country;

    /**
     * Getters and Setters
     */
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Instant getDate_operation() {
        return date_operation;
    }

    public void setDate_operation(Instant date_operation) {
        this.date_operation = date_operation;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Instant getDate_validation() {
        return date_validation;
    }

    public void setDate_validation(Instant date_validation) {
        this.date_validation = date_validation;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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
