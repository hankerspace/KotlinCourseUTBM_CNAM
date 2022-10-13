Le jeu de Nim est un jeu où deux joueurs s'affrontent, ils jouent à tour de rôle.

Le jeu ne contient que trois règles :
- Le jeu démarre avec 12 bâtons
- Chaque joueur prend 1, 2 ou 3 bâtons par tour
- Le joueur qui prend le dernier bâton gagne.

Le but de cet exercice est de créer un programme qui permet de jouer au jeu de Nim.

Pour gagner la partie à chaque fois, il faut que le second joueur prenne 4 bâtons moins le nombre que le premier joueur a pris au tour précédent.

Ainsi, si le premier joueur prend 1 bâton, le second joueur doit prendre 3 bâtons, si le premier joueur prend 2 bâtons, le second joueur doit prendre 2 bâtons, etc.

# Exercice

Implémentez le jeu de Nim en utilisant la programmation impérative. Le programme doit demander à l'utilisateur de saisir le nombre de bâtons qu'il souhaite prendre.

Le second joueur doit être contrôlé par l'ordinateur. Il doit prendre le nombre de bâtons nécessaire pour gagner la partie à chaque fois.

<div class="hint">
Pour demander à l'utilisateur de saisir un nombre, la fonction Kotlin `readLine()` peut être utilisée. Elle retourne une chaîne de caractères, il faut donc convertir cette chaîne en nombre avec la fonction `toInt()`.

Vous devez vous assurer que l'utilisateur ne puisse pas saisir un nombre de bâtons supérieur au nombre de bâtons restants. Si l'utilisateur saisit un nombre de bâtons supérieur, vous devez lui demander de saisir un nouveau nombre de bâtons.
</div>

