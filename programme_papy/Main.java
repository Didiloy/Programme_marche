import frame.frameReg.FrameReg;
import frame.frameUnreg.FrameUnreg;

import javax.swing.*;
import java.io.File;

public class Main{
	//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

	public Main(){}
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
