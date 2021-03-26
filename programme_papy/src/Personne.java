public class Personne{
    private String nom;
    private String prenom;
    private int age;
    private int poids;
    private double tourTaille =0.;

    public Personne(String nom, String prenom, int age, int poids){
        this.nom = nom;
        this.prenom = prenom;
        this.age= age;
        this.poids = poids;
    }
    
    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public int getAge(){
        return this.age;
    }

    public void setTourTaille(double tourTaille){
        this.tourTaille = tourTaille;
    }

    public double getTourTaille(){
        return this.tourTaille;
    }
    
    public int getPoids(){
        return this.poids;
    }
    
    public void setPoids(int poids){
        this.poids = poids;
    }
    
    public String toString(){
        return (this.nom + "," + this.prenom + "," + this.age + "," + this.poids);
    }
    
    public String toString(int etendu){
        return ("Nom: " + this.nom + "\n" + "Prénom: " + this.prenom + "\n" + "age: " + this.age + "\n" + "Tour de taille " + this.tourTaille + "\nPoids: " + this.poids);
    }
}
