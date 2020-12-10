package com.bankofparis.banky.operations;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.*;

import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * Operation DAO
 */
@Dao
public interface OperationDao {
    /**
     * Never implement this one in production, it will retrieve everything from table.
     * @return
     */
    @Select
    PagingIterable<OperationEntity> all();

    @Select
    PagingIterable<OperationEntity> findByIban(@NotNull String iban);

    @Select
    OperationEntity findByIbanAndDateOperation(@NotNull String iban, @NotNull Instant dateOperation);

    @Select(customWhereClause = "iban = :iban AND date_operation > :dateOperation")
    PagingIterable<OperationEntity> findByIbanAfterDateOperation(@NotNull String iban, @NotNull Instant dateOperation);

    @Insert
    void save(@NotNull OperationEntity operation);

    @Update
    void update(OperationEntity operationEntity);

    @Delete
    void delete(OperationEntity operationEntity);
}
