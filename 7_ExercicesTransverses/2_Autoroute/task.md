# Autoroute

## Description

On désire réaliser la simulation du fonctionnement d'une autoroute.

Une autoroute est composée d'un ensemble de péages. Il y a différents types de péages (ceux qui permettent d'entrer sur l'autoroute et ceux qui permettent d'en sortir).

Chaque péage est caractérisé par un nom et un point kilométrique (PK) sur l'autoroute. Ce point kilométrique permet de facilement calculer la distance entre 2 péages.

Un véhicule voyageant sur une autoroute va traverser les péages les uns après les autres. Chaque fois qu'un véhicule traverse un péage de l'autoroute, il conserve le ticket du dernier péage d'entrée traversé.
A chaque traversée d'un péage de sortie, le véhicule paye une contribution qui dépend de la distance parcourue depuis le dernier péage d'entrée franchi et des caractéristiques du véhicule.

Il existe différents types de véhicules (motos, voitures, camions, etc...). Les véhicules sont caractérisés par leur plaque d'immatriculation.

Le prix du parcours entre deux péages est égal à la distance parcourue (en Km) multipliée par un taux dépendant du type de véhicule (0.1 pour une moto, 0.2 pour une voiture, 0.3 pour un camion...). Cependant ce prix est majoré par le nombre de passagers d'une voiture multiplié par 10, et par le nombre de tonnes de marchandises d'un camion multiplié par 5.
Le gérant de la société autoroutière veut pouvoir modifier à tout moment les taux des véhicules et les taux de majoration.

## Exercice 1

* Implémenter les classes `Toll`, `Vehicule` et `Highway`.
* Implémenter les méthodes `addToll` pour ajouter un péage et `addTravel` pour faire faire un voyage à un véhicule dans la classe `Highway`.
* La méthode `addTravel` doit prendre un PK d'entrée, un PK de sortie et un véhicule. Si le PK est invalide (sortie entre un péage entrée et un péage sortie ou entrée entre un péage entrée et un péage sortie) la méthode doit lever une exception `IllegalArgumentException`.

Exemple de main :

```kotlin
val highwayA6 = Highway("A6")
highwayA6.addToll(InToll("Paris", 0.0))
highwayA6.addToll(OutToll("Lyon nord", 600.0))
highwayA6.addToll(InToll("Lyon sud", 650.0))
highwayA6.addToll(OutToll("Marseille", 1000.0))

highwayA6.addTravel(Motorcycle("AB-123-CD"), 0.0, 600.0)
highwayA6.addTravel(Car("DD-234-GD", 2), 0.0, 620.0)
highwayA6.addTravel(Truck("GF-231-AB", 2.0), 0.0, 1200.0)
highwayA6.addTravel(Car("EE-234-GD", 5), 630.0, 1200.0)
```

Sortie attendue :

```text
Le véhicule AB-123-CD est entré sur l'autoroute A6 au PK 0.0, il a pris un ticket au péage Paris, il a payé 60.0 euros lors du passage au péage Lyon nord, et il est sorti au PK 600.0.
Le véhicule DD-234-GD est entré sur l'autoroute A6 au PK 0.0, il a pris un ticket au péage Paris, il a payé 140.0 euros lors du passage au péage Lyon nord, et il est sorti au PK 620.0.
Le véhicule GF-231-AB est entré sur l'autoroute A6 au PK 0.0, il a pris un ticket au péage Paris, il a payé 190.0 euros lors du passage au péage Lyon nord, il a pris un ticket au péage Lyon sud, il a payé 115.0 euros lors du passage au péage Marseille, et il est sorti au PK 1200.0.
Le véhicule EE-234-GD est entré sur l'autoroute A6 au PK 630.0, il a pris un ticket au péage Lyon sud, il a payé 120.0 euros lors du passage au péage Marseille, et il est sorti au PK 1200.0.

```

## Exercice 2

On désire introduire les péages ecotaxe. Ce type de péage est placé sur l'autoroute et n'est ni considéré comme un péage d'entrée ni comme un péage de sortie. Il est caractérisé par un PK et un taux de contribution. 

Le véhicule qui traverse ce péage doit payer une contribution égale au montant enregistré dans le péage. Ce péage ne fonctionne que pour les camions.

Exemple de main :

```kotlin
val highwayA6 = Highway("A6")
highwayA6.addToll(InToll("Paris", 0.0))
highwayA6.addToll(EcotaxToll("Ecotaxe 1", 100.0, 50.0))
highwayA6.addToll(EcotaxToll("Ecotaxe 2", 400.0, 50.0))
highwayA6.addToll(OutToll("Lyon nord", 600.0))
highwayA6.addToll(InToll("Lyon sud", 650.0))
highwayA6.addToll(EcotaxToll("Ecotaxe 3", 800.0, 50.0))
highwayA6.addToll(OutToll("Marseille", 1000.0))

highwayA6.addTravel(Motorcycle("AB-123-CD"), 0.0, 600.0)
highwayA6.addTravel(Car("DD-234-GD", 2), 0.0, 620.0)
highwayA6.addTravel(Truck("GF-231-AB", 2.0), 0.0, 1200.0)
highwayA6.addTravel(Car("EE-234-GD", 5), 630.0, 1200.0)

```

Sortie attendue :

```text
Le véhicule AB-123-CD est entré sur l'autoroute A6 au PK 0.0, il a pris un ticket au péage Paris, il a payé 60.0 euros lors du passage au péage Lyon nord, et il est sorti au PK 600.0.
Le véhicule DD-234-GD est entré sur l'autoroute A6 au PK 0.0, il a pris un ticket au péage Paris, il a payé 140.0 euros lors du passage au péage Lyon nord, et il est sorti au PK 620.0.
Le véhicule GF-231-AB est entré sur l'autoroute A6 au PK 0.0, il a pris un ticket au péage Paris, il a payé 50.0 euros lors du passage au péage Ecotaxe 1, il a payé 50.0 euros lors du passage au péage Ecotaxe 2, il a payé 190.0 euros lors du passage au péage Lyon nord, il a pris un ticket au péage Lyon sud, il a payé 50.0 euros lors du passage au péage Ecotaxe 3, il a payé 115.0 euros lors du passage au péage Marseille, et il est sorti au PK 1200.0.
Le véhicule EE-234-GD est entré sur l'autoroute A6 au PK 630.0, il a pris un ticket au péage Lyon sud, il a payé 120.0 euros lors du passage au péage Marseille, et il est sorti au PK 1200.0.
```