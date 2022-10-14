# Énoncé

Le jeu du morpion est un jeu de réflexion se jouant à deux joueurs. Chaque joueur possède un pion qu'il place sur une grille de 3x3 cases. Le but du jeu est de réussir à aligner 3 de ses pions horizontalement, verticalement ou en diagonale. Le premier joueur qui réussit à aligner 3 de ses pions gagne la partie.

Nous allons implémenter le jeu du morpion en utilisant les concepts de programmation orientée objet.

Le jeu se joue sur une grille de 3x3 cases. Chaque case est identifiée par un numéro de 1 à 9. Voici un exemple de grille de jeu :

```
 1 | 2 | 3
---+---+---
 4 | 5 | 6
---+---+---
 7 | 8 | 9
```

Le jeu se joue à deux joueurs. Chaque joueur possède un pion qu'il place sur la grille. Le premier joueur qui réussit à aligner 3 de ses pions gagne la partie.
 
## Menu

Le jeu possède un menu. Ce menu permet de choisir entre plusieurs options :
1. Pour commencer une nouvelle partie
2. Pour afficher les règles du jeu
3. Pour quitter le jeu

Vous utiliserez un attribut `gameState ` de la classe `Game` pour stocker l'état du jeu. Ce dernier peut prendre les valeurs suivantes :
- `GameState::INTRO_SCREEN` : le menu est affiché
- `GameState::GAME_SCREEN` : une partie est en cours
- `GameState::HELP_SCREEN` : la partie est terminée

## Affichage de la grille

La grille de jeu est affichée à l'écran. Elle est composée de 9 cases. Chaque case est identifiée par un numéro de 1 à 9. Voici un exemple de grille de jeu :

```
 O | X | X 
---+---+---
 O | X | O 
---+---+---
 X |   |   
```

## Déroulement d'une partie

Le jeu se joue à deux joueurs. Chaque joueur possède un pion qu'il place sur la grille. Le premier joueur qui réussit à aligner 3 de ses pions gagne la partie.

Le jeu doit détecter si un joueur a gagné la partie. Si c'est le cas, le jeu affiche un message de félicitation au joueur gagnant.

Si aucun joueur n'a gagné la partie, le jeu affiche un message indiquant que la partie est terminée sans vainqueur.

Utilisez les symboles `X` et `O` pour représenter les pions des joueurs.