# Regex

Les regex sont des expressions rationnelles. Elles permettent de rechercher des motifs dans des chaînes de caractères.

Elles sont utilisées dans de nombreux langages de programmation, mais aussi dans des logiciels comme `grep` ou `sed`.

## Syntaxe

Les regex sont composées de caractères spéciaux et de caractères littéraux. Les caractères spéciaux sont des métacaractères qui ont un sens particulier. Les caractères littéraux sont des caractères qui ont un sens littéral.

### Caractères spéciaux

Les caractères spéciaux sont les suivants :

- `.` : n'importe quel caractère
- `*` : 0 ou plusieurs occurrences du caractère précédent
- `+` : 1 ou plusieurs occurrences du caractère précédent
- `?` : 0 ou 1 occurrence du caractère précédent
- `^` : début de la chaîne
- `$` : fin de la chaîne
- `|` : ou
- `()` : groupe
- `{}` : quantificateur
- `[]` : classe de caractères
- `\` : échappement
- `#` : commentaire
- `!` : négation
- `&` : correspondance
- `:` : séparateur

### Caractères littéraux

Les caractères littéraux sont les caractères qui n'ont pas de sens particulier dans une regex. Ils correspondent à eux-mêmes.

### Groupes

Les groupes permettent de regrouper des caractères. Ils sont utilisés pour les quantificateurs et les classes de caractères.

### Quantificateurs

Les quantificateurs permettent de définir le nombre d'occurrences d'un caractère ou d'un groupe.

- `{n}` : n occurrences
- `{n,}` : n occurrences ou plus
- `{n,m}` : entre n et m occurrences
- `{,m}` : m occurrences ou moins
- `{}` : 0 ou 1 occurrence
- `{2}` : 2 occurrences

### Classes de caractères

Les classes de caractères permettent de définir un ensemble de caractères.

- `[abc]` : a, b ou c
- `[a-z]` : toutes les lettres minuscules
- `[A-Z]` : toutes les lettres majuscules
- `[0-9]` : tous les chiffres
- `[a-zA-Z0-9]` : toutes les lettres et tous les chiffres
- `[^abc]` : tout sauf a, b ou c
- `[^a-z]` : tout sauf une lettre minuscule
- `[^A-Z]` : tout sauf une lettre majuscule
- `[^0-9]` : tout sauf un chiffre

### Échappement

L'échappement permet d'utiliser un caractère spécial comme caractère littéral.

- `\.` : le caractère `.`
- `\*` : le caractère `*`
- `\+` : le caractère `+`


## Exemples

### Rechercher un caractère

Pour rechercher un caractère, il suffit de le mettre dans la regex.

```regex
a
```

### Rechercher une chaîne de caractères

Pour rechercher une chaîne de caractères, il suffit de la mettre dans la regex.

```regex
abc
```

### Rechercher un caractère spécial

Pour rechercher un caractère spécial, il faut l'échapper avec le caractère `\`.

```regex
\.
```

### Rechercher un caractère optionnel

Pour rechercher un caractère optionnel, il faut utiliser le caractère `?`.

```regex
a?
```

### Rechercher un caractère ou un autre

Pour rechercher un caractère ou un autre, il faut utiliser le caractère `|`.

```regex
a|b
```

### Rechercher un caractère ou plusieurs autres

Pour rechercher un caractère ou plusieurs autres, il faut utiliser le caractère `+`.

```regex
a+
```

### Rechercher un caractère ou aucun autre

Pour rechercher un caractère ou aucun autre, il faut utiliser le caractère `*`.

```regex
a*
```

### Rechercher un caractère précédé d'un autre

Pour rechercher un caractère précédé d'un autre, il faut utiliser le caractère `*`.

```regex
a.*
```

## Utilisation en Koltin

### Fonction `matches`

La fonction `matches` permet de tester si une chaîne de caractères correspond à une regex.

```kotlin
fun main() {
    val regex = Regex("a")
    println(regex.matches("a")) // true
    println(regex.matches("b")) // false
}
```

### Fonction `find`

La fonction `find` permet de trouver la première occurrence d'une regex dans une chaîne de caractères.

```kotlin
fun main() {
    val regex = Regex("a")
    println(regex.find("abc")) // MatchResult(a, 0..1)
    println(regex.find("bcd")) // null
}
```

### Fonction `findAll`

La fonction `findAll` permet de trouver toutes les occurrences d'une regex dans une chaîne de caractères.

```kotlin
fun main() {
    val regex = Regex("a")
    println(regex.findAll("abc")) // [MatchResult(a, 0..1), MatchResult(a, 2..3)]
    println(regex.findAll("bcd")) // []
}
```

### Fonction `replace`

La fonction `replace` permet de remplacer toutes les occurrences d'une regex dans une chaîne de caractères par une autre chaîne de caractères.

```kotlin
fun main() {
    val regex = Regex("a")
    println(regex.replace("abc", "b")) // bbc
    println(regex.replace("bcd", "b")) // bcd
}
```

## Exemple

### Vérification numéro de téléphone

```kotlin
fun main() {
    val regex = Regex("^0[1-9]([-. ]?[0-9]{2}){4}$")
    println(regex.matches("0123456789")) // true
    println(regex.matches("012345678")) // false
    println(regex.matches("01234567890")) // false
    println(regex.matches("0123456789a")) // false
}
```

### Vérification d'un code postal

```kotlin
fun main() {
    val regex = Regex("^[0-9]{5}$")
    println(regex.matches("75000")) // true
    println(regex.matches("7500")) // false
    println(regex.matches("750000")) // false
    println(regex.matches("7500a")) // false
}
```

### Vérification d'un mot de passe

```kotlin
fun main() {
    val regex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})")
    println(regex.matches("Password1!")) // true
    println(regex.matches("password1!")) // false
    println(regex.matches("PASSWORD1!")) // false
    println(regex.matches("PASSWORD1")) // false
    println(regex.matches("password!")) // false
    println(regex.matches("password1")) // false
    println(regex.matches("PASSWORD!")) // false
    println(regex.matches("PASSWORD1!")) // false
}
```


Cette regex permet de vérifier que le numéro de téléphone commence par un 0, qu'il y a 10 chiffres et qu'il n'y a pas de caractères spéciaux.

## Exercices

Réalisez les fonctions suivantes : 

- `isEmail` : vérifie si une chaîne de caractères est un email
- `isMobilePhoneNumber` : vérifie si une chaîne de caractères est un numéro de téléphone mobile (07 ou 06 au début)
- `isIBAN` : vérifie si une chaîne de caractères est un IBAN (commence par FR et contient 27 caractères)
- `isDate` : vérifie si une chaîne de caractères est une date (format JJ/MM/AAAA)
- `isTime` : vérifie si une chaîne de caractères est une heure (format HH:MM:SS)

## Références

- [Regex101](https://regex101.com/)
- [Regexr](https://regexr.com/)
- [RegexOne](https://regexone.com/)
- [Regex Crossword](https://regexcrossword.com/)
- [Regex Golf](https://alf.nu/RegexGolf)