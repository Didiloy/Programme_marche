import javax.swing.*;
import java.io.*;

import frame.frameReg.*;
import frame.frameUnreg.*;

public class Main{

	public static void main (String[] args) {
		File f = new File("programme_papy/donnee/utilisateur.txt");
		if(f.isFile()) //Si un fichier utilisateur existe
		{
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					FrameReg frame = new FrameReg();
				}
			});
		}else { //Si le fichier existe pas lancer la page pour s'enregistrer
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					FrameUnreg frame = new FrameUnreg();
				}
			});
		}
	}
}
