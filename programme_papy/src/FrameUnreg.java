import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FrameUnreg extends JFrame implements ActionListener{
	private  JLabel nom = new JLabel("Entrez votre nom: ");
	private  JTextField textFieldNom = new JTextField(20);
	private  JLabel prenom = new JLabel("Entrez votre prénom: ");
	private  JTextField textFieldPrenom = new JTextField(20);
	private  JLabel age = new JLabel("Entrez votre age: ");
	private  JTextField textFieldAge = new JTextField(3);
	private  JButton button = new JButton("OK");
	private static String userNom;
	private static String userPrenom;
	private static int userAge;
	private static Personne p1;
	private static final long serialVersionUID = 1L;

	public FrameUnreg(String nom_fenetre){
		setTitle(nom_fenetre);
		setSize(1200, 700);//dimensionnement de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//quand on ferme la fenetre le programme se ferme
		setLocationRelativeTo(null);//afficher la fenetre au milieu pour les non tiling WM
		setVisible(true);//afficher la fenetre
		Image icon = new ImageIcon("image/marche.jpg").getImage(); // J'ajoute l'icone de l'app
		setIconImage(icon);//Je met l'icone
		getContentPane().setBackground(Color.LIGHT_GRAY);
		button.addActionListener(this);
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(10, 10, 10, 10);
		
		constraint.gridx = 0;
		constraint.gridy = 0;
		add(nom, constraint);

		constraint.gridx = 1;
		add(textFieldNom, constraint);
		
		constraint.gridx = 0;
		constraint.gridy = 1;
		add(prenom, constraint);
		
		constraint.gridx = 1;
		constraint.gridy = 1;
		add(textFieldPrenom, constraint);
		
		constraint.gridx = 0;
		constraint.gridy = 2;
		add(age, constraint);
		
		constraint.gridx = 1;
		constraint.gridy = 2;
		add(textFieldAge, constraint);
		
		
		
		constraint.gridx = 1;
		constraint.gridwidth = 2;
		constraint.gridy = 3;
		add(button, constraint);
		
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		userNom = textFieldNom.getText();
		userPrenom = textFieldPrenom.getText();
		userAge = Integer.parseInt(textFieldAge.getText());
		p1 = new Personne(userNom, userPrenom, userAge);
		System.out.println(p1.toString(1)); //recup les infos. a changer
		ecrireFichier();
		
	}
	
	public String getNom() {
		return userNom;
	}
	
	public String getPrenom() {
		return userPrenom;
	}
	
	public int getAge() {
		return userAge;
	}
	public String getUser() {
		return p1.toString();
	}
	
	public void ecrireFichier() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("donnee/utilisateur.txt"));//On choisi le fichier dans lequel on écrit
			bw.write(p1.toString());//On écrit
			bw.close();
		}
		catch (IOException e)//Si il y a une erreur on la récupère.
		{
			//Print the error message
			System.out.print(e.getMessage());
		}
	}

}
