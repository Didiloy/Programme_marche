public class Marche{
    private double distance;
    private int temps;
    private String date;

    public Marche( double distance, int temps, String date){
        this.distance = distance;
        this.temps = temps;
        this.date = date;
    }

    public String toString(){
        return ("distance :" + distance + "km\n" + "Durée de la marche: " + temps + "min\n" + "Date: " + date);
    }
} 
