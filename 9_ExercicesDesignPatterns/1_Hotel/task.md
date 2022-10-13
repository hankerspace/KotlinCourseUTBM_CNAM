# Énoncé

Le gérant d'un hôtel veut mettre en place un site de réservation pour ses chambres.   

L'hôtel compte trois catégories de chambres à trois tarifs différents, selon les prestations disponibles : 
1. des chambres éco qui partagent une salle de bains commune sur le palier
2. des chambres confort avec une salle de bains privative et une télévision 
3. des chambres confort plus munies d'une salle de bains avec baignoire et de la climatisation. 

Chaque chambre porte un numéro unique et peut accueillir un nombre de personnes fixé. 
Une chambre ne peut pas accueillir plus de personnes que sa capacité, à l'exception d'un enfant de moins de 2 ans par chambre. 
La capacité d'une chambre n'est pas déterminée par sa catégorie. 

Une personne souhaitant réserver une chambre dans cet hôtel doit indiquer ses dates d'arrivée et de départ, ainsi que la catégorie de chambre désirée et le nombre d'occupants prévu de la chambre (en indiquant s'il y a un enfant de moins de 2 ans). 

Une réservation compte toujours au moins une nuit. Le prix d'une réservation est égal au tarif de la catégorie demandée multiplié par le nombre de nuits. 

Pour enregistrer sa réservation, il faut ensuite que la personne indique un nom et une adresse e-mail. 
Lorsque toutes ces informations sont saisies, la réservation est enregistrée et un numéro unique lui est attribué. 
Elle est alors en attente de validation par le gérant. 
Un e-mail est envoyé au client récapitulant sa réservation et contenant un lien vers son historique de réservations (c'est-à-dire les réservations correspondant à cette adresse e-mail). 

Une réservation ne concerne qu'une chambre à la fois. 
Pour réserver plusieurs chambres, le client doit enregistrer plusieurs réservations. 

Depuis le lien contenu dans l'e-mail de confirmation de réservation, un client peut annuler une réservation jusqu'à la veille de la date d'arrivée (comprise). 
Après, elle ne peut plus être annulée. 

Le gérant veut pouvoir gérer lui-même l'attribution des chambres à ses clients. 
Il va consulter tous les jours les nouvelles demandes de réservation. 
Pour chaque réservation en attente, il va décider d'accepter ou de refuser cette réservation. 
Il accepte une réservation en lui attribuant une chambre précise correspondant à la catégorie de chambre demandée par le client, s'il en existe une disponible aux dates voulues et d'une capacité su sante. 
Si plus aucune chambre de la catégorie demandée n'est disponible, le gérant a le choix de refuser la réservation ou de lui attribuer une chambre d'une catégorie supérieure à celle demandée (c'est-à-dire dont le prix est plus élevé). 
Dans ce dernier cas, le prix de la réservation n'est pas modifié, le client paiera le prix calculé au moment de la réservation. 

Que la demande soit acceptée ou refusée, le client est informé de la décision du gérant par e-mail. 
Le numéro de chambre attribué et la décision de surclassement ne sont cependant pas communiqués au client. 
Le gérant peut en effet, suite à l'annulation d'une réservation par exemple, revenir sur sa décision de surclassement et attribuer une chambre de la catégorie demandée initialement. 
De manière générale, il peut changer l'attribution des chambres jusqu'au jour de début des réservations concernées, pour des raisons logistiques. 
Il peut également surclasser une réservation qui ne l'était pas initialement. 

Le paiement est effectué à l'hôtel directement, le site ne permettant pas le paiement en ligne. Le client paie sa réservation lorsqu'il arrive à l'hôtel pour prendre les clés de la chambre qu'il a réservée. 
Le gérant enregistre le paiement des réservations dans le système au fur et à mesure de l'arrivée des clients. 
Afin de faire ses comptes, le gérant imprime tous les jours depuis le système un récapitulatif des chambres occupées, réservées mais non payées (le client ne s'est pas présenté), et non réservées, pour la nuit précédente. 

# Questions 

1. Donner les acteurs et les cas d'utilisation du système sous forme de diagramme de cas d'utilisation. Préciser le vocabulaire utilisé et expliquer les choix d'organisation des cas (justifier les extend, les include et les généralisations).  
2. Donner un scénario concret, sous forme de diagramme de séquence, illustrant les différents cas d'acceptation, de surclassement, de refus et d'annulation d'une réservation. On considérera qu'il reste seulement deux chambres disponibles dans l'hôtel à une certaine date, une confort et une confort plus, et que trois personnes ont demandé une réservation pour la catégorie confort à cette date. Dans un premier temps, on montrera les décisions du gérant pour ces trois réservations : acceptation, surclassement et refus. On montrera ensuite l'annulation de la réservation acceptée sans surclassement et son impact sur l'autre réservation acceptée. Enfin la personne dont la réservation avait été refusée fera une nouvelle demande de réservation pour la même catégorie, qui sera cette fois acceptée. On rappelle que dans un scénario concret, les arguments des opérations doivent prendre des valeurs réelles.   
3. En utilisant au moins les classes Client, Réservation, Catégorie et Chambre, donner la  structure du système sous forme de diagramme de classes. On s'assurera entre autres qu'on peut connaître facilement l'ensemble des chambres pour chaque catégorie. On doit pouvoir savoir quelle chambre est finalement attribuée à une réservation. Enfin, on doit pouvoir suivre les différentes statuts d'une réservation (en attente, acceptée, refusée. . .). On pourra utiliser le type de données prédéfini Date.  
4. Donner un diagramme d'objets correspondant à l'état du système à la fin du diagramme  de séquence donné en question 2. On rappelle que ce diagramme d'objets doit être une instance du diagramme de classes donné en question 3. On ne fera figurer que les attributs dont la valeur est significative pour cette question.  
5. Donner un diagramme états-transitions représentant le cycle de vie d'une réservation.  On s'assurera de la cohérence entre les différents états du diagramme et les différents statuts possibles d'une réservation. On étiquettera les transitions du diagramme par des opérations liées aux cas d'utilisation. 

# Exercice

Implémenter le programme de l'hotel en Kotlin.

Un main de test est fourni.

*Vous veillerez à implémenter les classes nécessaires. Si vous avez réalisé les diagrammes UML il faut vous en servir et les respecter lors de l'implémentation.*
