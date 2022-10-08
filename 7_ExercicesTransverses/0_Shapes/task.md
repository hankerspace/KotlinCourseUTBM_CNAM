# Exercice 

## Shapes

Le but de cet exercice est de créer une classe `Shape` qui sera la classe mère de toutes les formes géométriques. Cette classe devra implémenter l'interface `Drawable` qui permet de dessiner une forme sur la GUI.

L'interface Drawable contient la méthode getAllVertices qui retourne un tableau de points. Ces points sont les sommets de la forme. Il est possible de dessiner une forme à partir de ces points.

L'interface contient la méthode getShapeColor qui retourne la couleur de la forme.

## Conseils

N'hésitez pas à modifier le main pour tester votre code.

La méthode Renderer.render(shapes) permet de dessiner une liste de formes sur la GUI.

## Tests

L'exercice est considéré comme réussi lorsque les formes suivantes sont implémentées :
- Rectangle
- Square
- Circle
- Triangle
