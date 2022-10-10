# Gestion des défibrillateurs

## Exercice 1

Créer un programme qui recense les défibrillateurs d'une ville.

Par défibrillateur, stocker son Id et, position (latitude et longitude) et son modèle (FRED PA-1, SAMARITAN PAD ou FRED EASYLIFE).

Créer un jeu de données de test de 10 défibrillateurs et afficher leurs informations.

## Exercice 2

Créez une fonction de génération aléatoire de défibrillateurs. La fonction prend en paramètre le nombre de défibrillateurs à générer et retourne un tableau de défibrillateurs.

Les défibrillateurs doivent être générés aléatoirement entre les bornes suivantes :

- latitude : 48.0 et 49.0
- longitude : 6.0 et 7.0

Testez-la avec 1000 défibrillateurs.

<div class="hint">
Rappel, la génération aléatoire d'un nombre décimal entre 2 bornes est possible avec la formule suivante :

```kotlin
val min = 48.0
val max = 49.0
val random = min + (max - min) * Math.random()
```

La génération d'un nombre entier aléatoire est possible avec la formule suivante :

```kotlin
val min = 0
val max = 10
val random = (min..max).random()
```
</div>

## Exercice 3

Créer une fonction qui prend en paramètre une position (latitude et longitude) et qui retourne le défibrillateur le plus proche.

Testez-la

## Exercice 4

Créer une fonction qui prend en paramètre une position (latitude et longitude) et qui retourne un défibrillateur par modèle les plus proches. Il doit y avoir un défibrillateur par modèle.

Testez-la

## Exercice 5

Utilisez la formule de Haversine pour calculer la distance en mètres entre 2 points étant donné leurs coordonnées GPS.

Rappel : [https://en.wikipedia.org/wiki/Haversine_formula](https://en.wikipedia.org/wiki/Haversine_formula)

Puis créez une fonction qui calcule la distance en mètres entre un défibrillateur et la position de l'utilisateur.

Testez-la

## Exercice 6

Etant donné une vitesse de déplacement approximative de 5 km/h, créez une fonction qui calcule le temps de trajet en minutes entre un défibrillateur et la position de l'utilisateur.

Testez-la