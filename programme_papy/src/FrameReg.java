import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameReg implements ActionListener{
	private JFrame frame;
	private JPanel panel;
	private JButton bouton;
	private JLabel label;
	public int count = 0;
	
	public FrameReg() {
		frame = new JFrame("Programme de Marche");
		frame.setSize(1200, 700);//dimensionnement de la fenetre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//quand on ferme la fenetre le programme se ferme
		frame.setLocationRelativeTo(null);//afficher la fenetre au milieu pour les non tiling WM
		frame.setVisible(true);//afficher la fenetre
		Image icon = new ImageIcon("image/marche.jpg").getImage(); // J'ajoute l'icone de l'app
		frame.setIconImage(icon);//Je met l'icone
		frame.setLayout(new GridBagLayout());
		GridBagConstraints contraintes = new GridBagConstraints();
		
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		
		panel = new JPanel();
		bouton= new JButton("Clique moi :");
		bouton.addActionListener(this);
		label = new JLabel("Nombre de cliques: 0");
		panel.add(bouton);
		panel.add(label);
		frame.add(panel, contraintes);
		
	}
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Nombre de cliques: " + count);
	}
 }