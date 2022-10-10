# Numeros de taxi

Un numéro de taxi ([taxicab number](https://en.wikipedia.org/wiki/Hardy%E2%80%93Ramanujan_number)) est un entier naturel qui peut être écrit comme la somme de deux cubes de nombres entiers naturels différents **de plus d'une façon**.

La formule mathématique est la suivante :

$$
n = a^3 + b^3 = c^3 + d^3
$$

où $a$, $b$, $c$ et $d$  sont quatre entiers naturels différents.

Par exemple, $1729 = 9^3 + 10^3 = 1^3 + 12^3$. Il existe 206 numéros de taxi inférieurs à $10^6$.

![img.png](img.png)

Par exemple, 1729 est un numéro de taxi car 1^3 + 12^3 = 9^3 + 10^3. Les premiers numéros de taxi sont : 

- 1729 car 1^3 + 12^3 = 9^3 + 10^3
- 4104 car 2^3 + 16^3 = 9^3 + 15^3
- 13832 car 2^3 + 24^3 = 18^3 + 20^3
- 20683 car 3^3 + 19^3 = 12^3 + 22^3
- 32832 car 4^3 + 33^3 = 14^3 + 31^3
- 39312 car 6^3 + 27^3 = 21^3 + 25^3
- ...

Les numéros de taxi sont aussi appelés nombres de Fermat.

## Exercice

Écrire une fonction `taxi` qui prend en paramètre un entier naturel `n` et qui renvoie un tableau contenant les `n` premiers numéros de taxi.

Écrire une fonction `afficheTaxi` qui prend en paramètre un entier naturel `n` et qui affiche les `n` premiers numéros de taxi sous format lisible ainsi que les nombres constituant les cubes.

## Exemple

```
> taxi(5)
[1729, 4104, 13832, 20683, 32832]

> afficheTaxi(5)
   1:       1729  =   10^3 +   9^3  =   12^3 +   1^3
   2:       4104  =   15^3 +   9^3  =   16^3 +   2^3
   3:      13832  =   20^3 +  18^3  =   24^3 +   2^3
   4:      20683  =   24^3 +  19^3  =   27^3 +  10^3
   5:      32832  =   30^3 +  18^3  =   32^3 +   4^3
```

L'algorithme de vérification de l'exercice testera pour récupérer les 20 premiers numéros de taxi.