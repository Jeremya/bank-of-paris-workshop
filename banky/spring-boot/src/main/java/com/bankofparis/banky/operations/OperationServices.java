package com.bankofparis.banky.operations;

import com.bankofparis.banky.utils.DateUtils;
import com.datastax.oss.driver.api.core.PagingIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of services for Operations.
 */
@Service
public class OperationServices {

    @Autowired
    OperationDao operationDao;

    public PagingIterable<OperationEntity> findAllOperations() {
        return operationDao.all();
    }

    /**
     * Find all operations for with the partition key only
     */
    public PagingIterable<OperationEntity> findAllOperationsByIban(String iban) {
        return operationDao.findByIban(iban);
    }

    public void addOperation(OperationEntity operation) {
        operationDao.save(operation);
    }

    /**
     * Find all operations for with the primary key
     */
    public OperationEntity findAllOperationByIbanAndDateOperation(String iban, String dateOperation) {
        return operationDao.findByIbanAndDateOperation(iban, DateUtils.convertStringToInstantDate(dateOperation));
    }

    /**
     * Find all operations for with the partition key after a given date
     */
    public PagingIterable<OperationEntity> findAllOperationByIbanAfterDateOperation(String iban, String dateOperation) {
        return operationDao.findByIbanAfterDateOperation(iban, DateUtils.convertStringToInstantDate(dateOperation));
    }
}
