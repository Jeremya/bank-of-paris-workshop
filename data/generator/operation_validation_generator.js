//run with node: node operations_generator.js
var faker = require('faker');
var fs = require('fs');
var spacer = ";"
var fileName = '100iban_operations_with_validation_date';

// Setup variables
var numberOfOperations = 100;
var numberOfOperationsOnExistingIban = 500;

var operationsFinal = [];
var operationsStart = [];

generateCsvWithFakeData(fileName);

function generateCsvWithFakeData(fileName) {
    
    var tableFileName = fileName + ".csv"
    var tableFile = fs.createWriteStream(tableFileName, {
        flags: 'a'
    })
    
    for (j = 0; j < numberOfOperations; j ++) {
        var operation = {};
        operation.iban = faker.finance.iban("FR");
        operationsStart.push(operation);
        generateOperation(operation);

        operationsFinal.push(operation);
    }   

    // add operations on existing iban
    for (k = 0; k < numberOfOperationsOnExistingIban; k ++) {
        var operation = {};
        generateOperation(operation);
        var index = Math.floor(Math.random() * operationsStart.length);
        operation.iban = operationsStart[index].iban;

        operationsFinal.push(operation);
    }

    var keys = Object.keys(operationsFinal[0]);
    var operation_csv = jsonArrayToCsv(keys);
    console.log(operation_csv);
    tableFile.write(operation_csv);
}

function generateOperation(operation) {
        operation.operation_id = faker.random.uuid();
        operation.label = faker.lorem.words(4);
        operation.date_operation = faker.date.past().toISOString(); // timestamp
        operation.date_validation = faker.date.between(operation.date_operation, new Date()).toISOString(); // timestamp
        operation.amount = faker.finance.amount(0.10,10000.00,2);
}

function jsonArrayToCsv(keys) {
    var csv = "";
    // write header
    csv += keys.join(';') + '\n';

    for(var line of operationsFinal) {
        csv += keys.map(key => line[key]).join(spacer) + '\n';
    }
    return csv;
}

