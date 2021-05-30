package frame.frameReg.fonctions;

import java.awt.*;

public class CalculIMC {
    float imc = 0;
    Color couleurImc;
    int poids = 0;
    int taille = 0;
    float tailleMetre = 0.F;
    public CalculIMC(){
        ///////Poids////////////////////
        DerniereLigneFichier dlf = new DerniereLigneFichier();
        String poidsString[] = new String[2];
        String tmp = dlf.derniereLigne("programme_papy/donnee/ancienPoids.txt");
        poidsString = tmp.split(",");
        poids = Integer.parseInt(poidsString[0]);
        ///////////////////////////////
        //////Taille//////////////////
        DerniereLigneFichier dlf2 = new DerniereLigneFichier();
        String tailleString[] = new String[4];
        String tmp2 = dlf2.derniereLigne("programme_papy/donnee/utilisateur.txt");
        tailleString = tmp2.split(",");
        taille = Integer.parseInt(tailleString[2]);
        //////////////////////////////

        tailleMetre = (float) taille / 100;
        imc = poids / (tailleMetre * tailleMetre);
    }

    public float getImc(){ return imc;}

    public Color getColorImc(){
        if(imc>= 18.5 && imc <= 25) couleurImc = new Color(62, 199, 78);
        else couleurImc = new Color(192, 56, 56);
        return couleurImc;
    }

//    public static void main(String[] args) {
//        CalculIMC imc = new CalculIMC();
//        System.out.println(imc.getImc());
//    }
}
