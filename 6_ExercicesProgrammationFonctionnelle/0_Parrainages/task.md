# Parrainages présidentiels

Le fichier `parrainagestotal.json` contient les données des parrainages pour les candidats à la présidentielle de 2022. Chaque parrainage est représenté par un objet JSON contenant les informations suivantes :

* la civilité du parrain
* le nom du parrain
* le prénom du parrain
* le mandat du parrain (maire, etc...)
* la circonscription du parrain
* le département du parrain
* le candidat (nom + prénom)
* La date de publication du parrainage

Le programme fourni permet de lire le fichier et de le convertir en une liste d'objets `Parrainage`.

## Exercice 1

Écrire une fonction d'extension de List<Parrainage> `parrainageCountByCandidat` qui retourne un dictionnaire dont les clés sont les noms des candidats et les valeurs sont le nombre des parrainages correspondants.

Vous affichez ensuite le résultat de cette fonction, ordonné par nombre décroissant de parrainages, sous la forme :

CANDIDAT1 : nombre de parrainages

CANDIDAT2 : nombre de parrainages

...

<div class="hint">
Un dictionnaire est une structure de données qui permet de stocker des paires clé/valeur. 

En Kotlin, on peut créer un dictionnaire vide avec `mutableMapOf()` et ajouter des paires clé/valeur avec `dictionnaire[cle] = valeur`. On peut aussi récupérer une valeur avec `dictionnaire[cle]`.

Attention, les clés d'un dictionnaire doivent être uniques. Si on ajoute une paire clé/valeur avec une clé déjà présente, la valeur associée à la clé est remplacée.

</div>

## Exercice 2

Écrire une fonction d'extension de List<Parrainage> `statisticsByDepartment` qui prend en paramètre le nom d'un département et qui retourne les parrainages de ce département sous forme d'un dictionnaire dont les clés sont les noms des candidats et les valeurs est le pourcentage de parrainages obtenus par ce candidat dans ce département. La somme des pourcentages de tous les candidats doit être égale à 100.

Vous affichez ensuite le résultat de cette fonction, ordonné par pourcentage décroissant avec deux chiffres décimaux, sous la forme :

CANDIDAT1 : XX.XX% 

CANDIDAT2 : XX.XX%

...

<div class="hint">

Utilisez la méthode String.format() pour formater un nombre avec deux chiffres décimaux.

`String.format("%.2f", 1.2345)` retourne "1.23".

</div>

## Exercice 3

Écrire une fonction d'extension de List<Parrainage> `statisticsByCandidat` qui prend en paramètre le nom d'un candidat et qui retourne les parrainages de ce candidat sous forme d'un dictionnaire dont les clés sont les noms des départements et les valeurs est le pourcentage de parrainages obtenus par ce candidat dans ce département. La somme des pourcentages de tous les départements doit être égale à 100.

Vous affichez ensuite le résultat de cette fonction, ordonné par pourcentage décroissant avec deux chiffres décimaux, sous la forme :

DEPARTEMENT1 : XX.XX%

DEPARTEMENT2 : XX.XX%

...


