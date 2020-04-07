# Workshop Opérations Bancaires

## Introduction
Dans ce workshop nous allons mettre en place un système de stockage et de recherche de transactions bancaires. 

## Exercice 1
[01.01 - Cqlsh](exercises/01.01.CQLSH.md)

[01.02 - Les clefs de partition](exercises/01.02.CQL_basis.md)






CREATE TABLE tp_bnp.operations_by_date (
    iban text,
    operation_id uuid,
    account_code text,
    label text,
    date_operation timestamp,
    date_validation timestamp,
    date_correction timestamp,
    amount float,
    original_operation_id uuid,
    PRIMARY KEY (iban, date_operation)
);

COPY TO AAA

Afficher 10 lignes pour vérifier que la table n'est pas vide :
select * from tp_bnp.operations limit 10;

select account_code from tp_bnp.operations where iban='FR75 5900 1110 7290 2F4S D214 546';




CREATE SEARCH INDEX on tp_bnp.operations WITH COLUMNS amount, label, date_operation;


