# Nombres de Smith

Un nombre de Smith est un nombre entier naturel qui peut être écrit sous la forme $n = p_1 \times p_2 \times \ldots \times p_k$ où $p_1, p_2, \ldots, p_k$ sont des nombres premiers et où la somme des chiffres de $p_1, p_2, \ldots, p_k$ est égale à la somme des chiffres de $n$.

Par exemple, $378 = 2 \times 3 \times 3 \times 3 \times 7$ et $2 + 3 + 3 + 3 + 7 = 18$.

## Exercice

Ecrivez une fonction `isSmith` qui prend en paramètre un nombre entier naturel et qui renvoie `true` si ce nombre est un nombre de Smith et `false` sinon.

Ecrivez un programme qui affiche tous les nombres de Smith inférieurs à $1000$.
