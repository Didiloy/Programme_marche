import java.io.*;//Librairie pour les erreurs et plein d'autre trucs
import java.util.Scanner;//Librairie pour le scanner
import javax.swing.JFrame;//Librairie pour creer des fenetres
import javax.swing.SwingUtilities;

public class Main{

	public static void main (String[] args) {
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
