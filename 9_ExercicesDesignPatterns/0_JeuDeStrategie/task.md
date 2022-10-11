# Enoncé

Le but de cet exercice est de créer un jeu de stratégie inspiré de Warcraft.

Nous allons utiliser des factions et des unités. Chaque unité appartient à une faction. Les unités peuvent être de type bâtiment ou personnage.

Les différentes factions sont :

- Les humains
- Les orcs
- Les elfes

Les bâtiments sont construits par le joueur. Les personnage sont créés par les bâtiments.

Les unités de chaque faction sont :

- Bâtiments
  - La caserne : permet de créer des unités de type soldat
  - La forge : permet de créer des unités de type archer
  - L'autel des héros : permet de créer des unités de type héros
  - La tour des mages : permet de créer des unités de type mage
- Personnages
  - Le soldat : attaque au corps à corps
  - L'archer : attaque à distance
  - Le mage : attaque avec de la magie
  - Le héros : attaque au corps à corps, à distance et avec de la magie

Toutes les unités possèdent une position sur la carte. Les unités de type bâtiment ne peuvent pas se déplacer. Les unités de type personnage peuvent se déplacer sur la carte.

Cette position dans l'espace 2D est caractérisée par une position X et une position Y.

Les unités peuvent être créées par les bâtiments de leur faction. Certaines des unités peuvent attaquer les unités ennemies. Toutes les unités peuvent mourir.

# Exercices

*Conseil 1 : n'hésitez pas à séparer votre code dans plusieurs fichiers.*

*Conseil 2 : l'utilisation de design patterns est nécessaire pour ces exercices.*

## Exercice 1

Créez les différentes classes nécessaires au fonctionnement du jeu. Créez la hiérarchie de classes et d'interfaces nécessaires. 

Une classe `Game` devra gérer le jeu. Cette classe devra contenir la liste des joueurs, des unités, etc. Cette classe gèrera également l'initialisation de la partie, ainsi que la boucle de jeu.

Le main suivant doit fonctionner :

```kotlin

