# Bank of Paris Workshop

## Introduction

Bienvenue chez **Bank of Paris** ! Vous avez été embauché ici pour concevoir et mettre en place la base de données derrière la future célèbre **Banky**, la meilleure application de consultation de comptes bancaire imaginable !

Dans ce workshop nous allons mettre en place un système de stockage et de recherche de transactions bancaires. 

## Before starting

Tout d'abord il est nécessaire de récupérer les sources de ce TP sur votre machine. 
Dans le Eclipse Theia que vous venez d'ouvrir, ouvrez le menu `Terminal > New terminal`.

Un Terminal apparaît en bas de votre fenêtre. Copiez-y cette ligne de commande afin de récupérer les sources du projet :

```shell script
git clone https://github.com/Jeremya/bank-of-paris-workshop
```

Vous avez désormais un répertoire `bank-of-paris-workshop` créé dans votre machine virtuelle.
Placez-vous dans ce répertoire pour faire les exercices grâce à la commande :

```shell script
cd bank-of-paris-workshop
```

## Exerçons-nous

### Exercice 1 — Cassandra en pratique
[01.01 — Cqlsh](exercises/01.01.CQLSH.md)

[01.02 — Jouons avec CQL](exercises/01.02.CQL_basis.md)

[01.03 — Il faut toujours une partition](exercises/01.03.Partitions.md)

[01.04 — Les clefs de regroupement](exercises/01.04.Clustering.md)

### Exercice 2 — L'importance du modèle de données
[02.01 — Le data modelling](exercises/02.01.Data_modelling.md)


### Exercice 3 — De nouveaux horizons avec DSE Search
[03.01 — Découverte de DSE Search](exercises/03.01.Search_introduction.md)

[03.02 — Recherches sur des dates](exercises/03.02.Date_search.md)

[03.03 — Recherches sur du texte](exercises/03.03.Text_Search.md)

## TODO

* Exercise 1 add text, explain more.
* virer les champs suffix de l'exercice 3



