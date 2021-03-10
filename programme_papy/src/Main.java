import java.io.*;//Librairie pour les erreurs et plein d'autre trucs
import java.util.Scanner;//Librairie pour le scanner
import javax.swing.JFrame;//Librairie pour creer des fenetres
import javax.swing.SwingUtilities;

public class Main{

	public static void main (String[] args) {

		//Scanner scan = new Scanner(System.in);//Démarrer le scanner qui permet de récup ce qu'on écrit en terminal

		////////////Créer une personne/////////////////:
		// System.out.println("entre nom,  prenom, age");
		// String nom = scan.nextLine();//Scanner les infos
		// String prenom = scan.nextLine();
		// int age = scan.nextInt();
		// // scan.close();
		// Personne p1;
		// p1 = new Personne(nom, prenom, age);//Mettre les infos scannées dans une personne
		// System.out.println(p1.toString());
		// System.out.println("\n Maintenant on modifie le tour de taille: entre ton tour de taille \n");
		// double tourTaille = scan.nextDouble();
		// p1.setTourTaille(tourTaille);
		// System.out.println(p1.toString());
		//////////////////////////////////////////////

		//////////Créer une marche///////////////////
		// // Scanner scan = new Scanner(System.in);
		// System.out.println("Entre la distance marchée en km (ex: 5,2), le temps en minutes (ex:130) et la date au format dd/mm/yyyy");
		// double distance = scan.nextDouble();//Scanner les infos
		// int temps = scan.nextInt();
		// String date = scan.next();
		// date += scan.nextLine();
		// // scan.close();
		// Marche m1;
		// m1 = new Marche( distance, temps, date);//Mettre les infos dans une marche
		// System.out.println(m1.toString());
		/////////////////////////////////////////////

		/////////////////Écrire dans un fichier////////
		// try {
		//     BufferedWriter bw = new BufferedWriter(new FileWriter("donnee/utilisateur.txt"));//On choisi le fichier dans lequel on écrit
		//     bw.write(p1.getNom());//On écrit
		//     bw.write("\n");
		//     bw.write(p1.getPrenom());
		//     bw.write("\n");
		//     bw.write(p1.getAge());
		//     bw.write("\n");
		//     bw.write("karen");
		//     bw.close();
		// }
		// catch (IOException e)//Si il y a une erreur on la récupère.
		// {
		//     //Print the error message
		//     System.out.print(e.getMessage());
		// }
		/////////////////////////////////////////////

		///////////Lire dans un fichier/////////////
		// try {
		//     BufferedReader br = new BufferedReader(new FileReader("donnee/utilisateur.txt"));//On choisi le fichier à lire
		//     String s;
		//     while((s = br.readLine()) != null){//tant que la ligne n'est pas null on continue
		//         System.out.println(s);
		//     }
		//     br.close();
		// } catch(IOException e) {
		//     System.out.println(e.getMessage());
		// }
		/////////////////////////////////////////////
		//
		//        SwingUtilities.invokeLater(new Runnable(){
		//            public void run(){
		////                Frame frame = new Frame("Programme de Marche");
		//                new Gui();
		//            }
		//        });

		////////////////Première page en fonction de si l'utilisateur est connu ou pas///////
		File f = new File("donnee/utilisateur.txt");
		if(f.isFile()) //Si un fichier utilisateur existe
		{ 
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					//Frame frame = new Frame("Programme de Marche");
					new FrameReg();
				}
			});
		}else { //Si le fichier existe pas lancer la page pour s'enregistrer
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					FrameUnreg frame = new FrameUnreg("Programme de Marche");
				}
			});
		}
		////////////////////////////////////////////////////////////////////////////
	}
}
