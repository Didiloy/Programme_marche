public class Personne{
    private String nom;
    private String prenom;
    private int age;
    private double tourTaille =0.;

    public Personne(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age= age;
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
    
    public String toString(){
        return (this.nom + "\n" + this.prenom + "\n" + this.age);
    }
    
    public String toString(int etendu){
        return ("Nom: " + this.nom + "\n" + "Prénom: " + this.prenom + "\n" + "age: " + this.age + "\n" + "Tour de taille " + this.tourTaille + "\n");
    }
}
