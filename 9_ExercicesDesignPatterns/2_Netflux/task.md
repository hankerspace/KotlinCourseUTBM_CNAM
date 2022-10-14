# Énoncé

On souhaite gérer un système de vidéo à la demande en ligne. D’après les entretiens réalisés avec la société Netflux, on sait que :
- Netflux propose différents médias au sein d’une bibliothèque
 - Un média peut être soit un épisode de série, soit un film
 - Une série a un nom et une liste de saisons. Il ne peut pas exister deux séries ayant le même nom.
 - Une saison à un numéro, une année et une liste d’épisodes. Une saison doit contenir au moins 2 épisodes et au plus 26 épisodes.
 - Un média est ouvert au visionnage et refermé sur ordre de Netflux, et est lié à une catégorie (Action, Aventure, Horreur, Documentaire, Musique, Animation)
 - Un abonné peut visionner un ou plusieurs médias
 - Un visionnage de série contient les informations sur la progression de l’abonné dans cette série, la saison et l’épisode en cours de lecture, l’avancement actuel de l’épisode et la liste d’épisodes et de saisons déjà visionnés en entier.
 - Un visionnage de film contient les informations sur l’avancement actuel du film et si le film a déjà été visionné en entier.
 - L’avancement actuel d’un visionnage doit être inférieur à la longueur en minutes de ce média.
 - Un épisode à un numéro, un nom et une longueur en minutes.
 - Un film à un nom, une année et une longueur en minutes.

# Questions

1.	A partir des éléments qui vous sont fournis ci-dessus, élaborez le diagramme de classes (en y ajoutant tout attribut que vous jugez pertinent et qui n’a pas été décrit ci-dessus). *Vous spécifierez également les contraintes OCL nécessaires pour spécifier certaines des informations données ci-dessus.*
2.	Afin de présenter à la société Netflux le fonctionnement de son système de reprise de lecture, vous devez réaliser le diagramme de séquence qui présente la lecture d’un épisode par l’abonné. 
*Vous distinguerez le cas où l’abonné visionne ce média pour la première fois, et également le cas où l’abonné souhaite reprendre la lecture de ce média à l’endroit où il s’était arrêté la dernière fois.*

# Exercice

Implémentez le système de vidéo à la demande en ligne en utilisant la programmation orientée objet. Le programme doit permettre de :
- Créer une bibliothèque
- Ajouter un média à la bibliothèque
- Créer un abonné
- Créer un visionnage pour un abonné
- Afficher les informations d’un visionnage
- Afficher les informations d’un média
- Afficher les informations d’un abonné
