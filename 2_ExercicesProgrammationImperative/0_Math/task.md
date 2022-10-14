Implémentez les fonctions suivantes en utilisant la programmation impérative et les notions vues dans les cours. Vous pouvez implémenter toute fonction supplémentaire que vous considérez comme nécessaire.

# Exercice 1

Écrivez une fonction `estPair` qui prend en paramètre un entier `n` et qui retourne `true` si `n` est pair et `false` sinon.

# Exercice 2

Écrivez une fonction `estPremier` qui prend en paramètre un entier `n` et qui retourne `true` si `n` est premier et `false` sinon. Un nombre est premier s'il n'est divisible que par 1 et par lui-même.

# Exercice 3

Écrivez une fonction `primorielle` qui prend en paramètre un entier `n` et qui retourne la somme des nombres premiers inférieurs ou égaux à `n`. Par exemple, `primorielle(10)` doit retourner `17` car `17 = 2 + 3 + 5 + 7`.

# Exercice 4

Écrivez une fonction `nombreDeDiviseurs` qui prend en paramètre un entier `n` et qui retourne le nombre de diviseurs de `n`. Par exemple, `nombreDiviseurs(6)` doit retourner `4` car `6` est divisible par `1`, `2`, `3` et `6`.

# Exercice 5

Écrivez une fonction `nombreOr` qui prend en paramètre un entier `n` et qui renvoie la valeur du nombre d'or calculé avec `n` itérations. Le nombre d'or est défini comme suit:

$$\varphi = \frac{1 + \sqrt{5}}{2}$$

$$\varphi = \frac{1}{\varphi} + \varphi$$

$$\varphi = \frac{1}{\frac{1}{\varphi} + \varphi} + \frac{1}{\varphi} + \varphi$$

$$\varphi = \frac{1}{\frac{1}{\frac{1}{\varphi} + \varphi} + \frac{1}{\varphi} + \varphi} + \frac{1}{\frac{1}{\varphi} + \varphi} + \frac{1}{\varphi} + \varphi$$

$$\vdots$$

# Exercice 6

Écrivez une fonction `estParfait` qui prend en paramètre un entier `n` et qui retourne `true` si `n` est parfait et `false` sinon. Un nombre est parfait s'il est égal à la somme de ses diviseurs (hors lui-même). Par exemple, `6` est parfait car `6 = 1 + 2 + 3`.

# Exercice 7

Écrivez une fonction `estPalindrome` qui prend en paramètre une chaîne de caractères `s` et qui retourne `true` si `s` est un palindrome et `false` sinon. Un palindrome est une chaîne de caractères qui est identique si on la lit de gauche à droite ou de droite à gauche. Par exemple, `estPalindrome("radar")` doit retourner `true` et `estPalindrome("radars")` doit retourner `false`.

# Exercice 8

Écrivez une fonction `estAnagramme` qui prend en paramètre deux chaînes de caractères `s1` et `s2` et qui retourne `true` si `s1` et `s2` sont des anagrammes et `false` sinon. Deux chaînes de caractères sont des anagrammes si elles contiennent les mêmes caractères dans le même nombre. Par exemple, `estAnagramme("radar", "rader")` doit retourner `true` et `estAnagramme("radar", "radars")` doit retourner `false`.
