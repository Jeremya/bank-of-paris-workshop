package com.bankofparis.banky.operations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;

@Controller
public class OperationController {

    /** Logger for the class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationController.class);

    @Autowired
    OperationServices operationServices;

    @GetMapping("/operations")
    public String operations(Model model) {
        model.addAttribute("operations", operationServices.findAllOperations());
        return "operations";
    }

    @GetMapping("/operation/{iban}")
    public String findByIban(Model model, @PathVariable("iban") String iban) {
        model.addAttribute("operations",  operationServices.findAllOperationsByIban(iban));
        return "operations";
    }

    @GetMapping("operation/{iban}/{dateOperation}")
    public String findByIbanAndDateOperation(Model model, @PathVariable("iban") String iban, @PathVariable("dateOperation") String dateOperation) {
        model.addAttribute("operations", operationServices.findAllOperationByIbanAndDateOperation(iban, dateOperation));
        return "operations";
    }

    @GetMapping("operation/{iban}/after/{dateOperation}")
    public String findByIbanAfterDateOperation(Model model, @PathVariable("iban") String iban, @PathVariable("dateOperation") String dateOperation) {
        model.addAttribute("operations", operationServices.findAllOperationByIbanAfterDateOperation(iban, dateOperation));
        return "operations";
    }

    /**
     * Add operation mecanism. Get will populate empty form and post will submit the new operation to save.
     */
    @GetMapping("/operation/add")
    public String add(Model model) {
        model.addAttribute("operation", new OperationEntity());
        return "add-operation";
    }

    @PostMapping("/operation/add")
    public String addOperation(@Valid @ModelAttribute("operation") OperationEntity operation) {
        operation.setDate_operation(Instant.now());
        System.out.println("operation a sauvegarder " + operation.toString());
        operationServices.addOperation(operation);
        return "redirect:/operations";
    }
}
