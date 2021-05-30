DATE DE DEBUT: 08/03/2021

# Important
Pour compiler le programme en ligne de commande utilisez cette commande: `javac -d out/ -cp lib/jfreechart-1.5.3.jar  -sourcepath programme_papy **/*.java`
puis pour le lancer utilisez celle ci: `java -cp out/:lib/jfreechart-1.5.3.jar Main`

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
- bug lors de l'enregistrement la date ne se met pas dans ancienPoids.txt
- bug si deux dates sont les meme dans la courbe pour le poids elle n'est ajouté qu'une seule fois et donc la courbe n'est pas bonne
- meme bug que pour la courbe du poids avec la courbe du tour de taille
- Meme bug si deux marches sont a la meme date.
- Changer le panel du centre
- système d'onglet pour les graphs ?

### A faire

- bug supprime les marches sans supprimer le fichier
- essayer de faire les 2 courbes de marche en une seule
- bug quand on est déja allé sur enregistrer une nouvelle donnée puis qu'on revient a l'acceuil et qu'on va sur poids ou taille et qu'on revient sur enregistrer une nouvelle donnée les placeholder disparaissent  
- Latex  pour manuel d'utilisation du logiciel.
- trouver un moyen d'installer le logiciel sur windows
- Faire un panel pour changer son nom, prenom, taille

