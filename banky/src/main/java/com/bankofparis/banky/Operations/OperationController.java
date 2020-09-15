package com.bankofparis.banky.Operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationController {

    @Autowired
    OperationRepository operationRepository;

    @GetMapping("/operations")
    public List<Operation> findAll() {
        return operationRepository.findAll();
    }
}
