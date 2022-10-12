# Parcours d'arbre

En programmation, un arbre est une structure de données qui permet de représenter des données hiérarchiques. Par exemple, un arbre peut représenter une famille, avec des parents et des enfants. Chaque personne est un noeud de l'arbre, et chaque personne peut avoir plusieurs enfants.

Nous allons nous concentrer sur un arbre binaire. Un arbre binaire est un arbre où chaque noeud a au plus deux enfants. Chaque noeud a un fils gauche et un fils droit. 

```text
        A
       / \
      B   C
     / \   \
    D   E   F
```

Dans cet arbre, A est la racine, B et C sont les fils de A, D et E sont les fils de B, et F est le fils de C.

La programmation orientée objet va nous aider à représenter un arbre binaire. 

## Exercice

1. Créez une classe `Node` qui représente un noeud de l'arbre. Chaque noeud a une valeur (entier naturel), et optionnellement un fils gauche et un fils droit.
2. Construisez manuellement l'arbre suivant en utilisant votre classe `Node`:
```text
        1
       / \
      2   3
     / \   \
    4   5   6
```
3. Créez une fonction `sumTree` qui prend en paramètre un noeud et qui retourne la somme des valeurs de tous les noeuds de l'arbre en partant de ce noeud. Par exemple, si on appelle `sumTree(node1)`, on doit retourner `21`.
4. Créez une fonction `maxTree` qui prend en paramètre un noeud et qui retourne la valeur maximale de tous les noeuds de l'arbre en partant de ce noeud. Par exemple, si on appelle `maxTree(node1)`, on doit retourner `6`.
5. Créez une fonction `minTree` qui prend en paramètre un noeud et qui retourne la valeur minimale de tous les noeuds de l'arbre en partant de ce noeud. Par exemple, si on appelle `minTree(node1)`, on doit retourner `1`.
6. Créez une fonction `heightTree` qui prend en paramètre un noeud et qui retourne la hauteur de l'arbre en partant de ce noeud. Par exemple, si on appelle `heightTree(node1)`, on doit retourner `3`.
7. Créez une fonction `countTree` qui prend en paramètre un noeud et qui retourne le nombre de noeuds de l'arbre en partant de ce noeud. Par exemple, si on appelle `countTree(node1)`, on doit retourner `6`.
8. Créez une fonction `countLeaves` qui prend en paramètre un noeud et qui retourne le nombre de feuilles de l'arbre en partant de ce noeud. Par exemple, si on appelle `countLeaves(node1)`, on doit retourner `3`.
9. Créez une fonction `printTree` qui prend en paramètre un noeud et qui affiche tous les noeuds de l'arbre en partant de ce noeud. Par exemple, si on appelle `printTree(node1)`, on doit afficher 
```text
\-- 1
    |-- 2
    |   |-- 4
    |   \-- 5
    \-- 3
```
10. Générez automatiquement un arbre de hauteur 20 et testez vos fonctions