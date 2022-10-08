# Exercice

On veut écrire un programme pour simuler les effets des précipitations au sol. On
suppose que le terrain est découpé en zones, qui chacune possède un nom

Chaque zone a aussi un niveau d'eau présente en surface (en mm). 

Chaque zone dispose implémente une interface qui permet de verser de l'eau sur cette zone, cette méthode a comme paramètre la quantité de pluie tombée sur la zone, en millimètres. 

```kotlin
interface Waterable {
    fun addWater(waterQuantity: Double)
}
```

De plus, chaque zone doit pouvoir s'afficher en utilisant l'interface suivante :

```kotlin
interface Printable {
    fun retrieveZoneName() : String
    fun retrieveWaterLevel() : Double
    fun retrieveWaterCapacity() : Double
}
```

### 1. Écrire du code pour représenter les zones.

Il existe deux types de zones (pour simplifier) :
- les zones construites, qui s'affichent en gris et n'absorbent pas du tout la pluie : quand elles
  reçoivent x millimètres de pluie, le niveau de l'eau sur la zone augmente de x.
- les zones humides, qui s'affichent en vert, ont une certaine capacité de stockage de la pluie
  dans le sol (en mm). Quand une zone humide reçoit x millimètres de pluie, l'eau commence par remplir le sol. Puis quand la capacité de stockage de la zone est atteinte, l'eau s'accumule alors à la surface et le niveau d'eau de la zone humide augmente.
- les zones herbeuses, qui absorbent immédiatement 50% de la pluie tombée sur elles.

### 2. Écrire du code objet pour représenter les zones construites et les zones humides.

### 3. Complétez les fonctions permettant de retourner une instance de vos classes

