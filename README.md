DATE DE DEBUT: 08/03/2021

# Important
Pendant les test n'enregistrez pas plusieurs poids, marches ou tour de taille le meme jour. C'est un bug déjà connu. 
Si vous le faite la courbe ne s'affichera pas et pour la faire s'afficher il faut modifier les fichier `.txt` 
`donnee/tourTaille.txt`, `donnee/marche.txt` et `donnee/ancienPoids.txt` de façon a ce qu'il n'y ai pas 2 fois la meme date.
___

### Fait
- Premiere page change en fonction de si il y a déjà un utilisateur enregistré ou pas.
- Enregistrer une nouvelle marche
- enregistrer poid
- enregistrer un nouveau tour de taille et sauvegarder l'ancien
- Afficher la dernière marche.
- afficher poid
- afficher tour de taille
- ajouter bordures aux panels de la droite
- Les listeners pour boutons visible panel centre
- Moyenne des kilometres marchés par marche.
- Total des kilomètres marchés
- Total du temps marché
- Cliqué sur les images font la meme chose que clique sur les boutons dans le panel centre de frame reg
- Graphique pour les dernières marches, trouver un moyen de mettre la date en x Axis
- Graphique pour les derniers poids
- moyenne poids est développée mais n'est pas encore utilisée dans l'application.
- fermer fenetre unreg apres s'etre enregistré.
- update les marches sans fermer l'app (JFrame.updateUI();)
- revenir au menu quand on enregistre une marche poids taille
- date pour le poids (localDate)
- date pour la taille

### A faire
- bug lors de l'enregistrement la date ne se met pas dans ancienPoids.txt 
- bug supprime les marches sans supprimer le fichier
- essayer de faire les 2 courbes de marche en une seule
- bug si deux dates sont les meme dans la courbe pour le poids elle n'est ajouté qu'une seule fois et donc la courbe n'est pas bonne
- meme bug que pour la courbe du poids avec la courbe du tour de taille  
- Meme bug si deux marches sont a la meme date.
- Latex  pour manuel d'utilisation du logiciel.
