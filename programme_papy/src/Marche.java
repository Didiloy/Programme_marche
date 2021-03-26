public class Marche{
    private int distance;
    private int temps;
    private String date;
    private double distanceKm;

    public Marche( int distance, int temps, String date){
        this.distance = distance;
        this.temps = temps;
        this.date = date;
        this.distanceKm= distanceToKm(this.distance);
    }
    
    public double distanceToKm(int distance) {
    	return ((double)distance)/1000;
    }

    public void setDistance(int distance) {
    	this.distance = distance;
    }
    
	public void setTemps(int temps) {
		this.temps = temps;
	}
	
	 public void setDate(String date) {
	    	this.date = date;
	    }
	 
	 public int getDistance() {
		 return this.distance;
	 }	 
	
	 public int getTemps() {
		 return this.temps;
	 }
    
	 public String getDate() {
		 return this.date;
	 }
	 
    public String toString(){
        return ("distance :" + distanceKm + "km\n" + "Durée de la marche: " + temps + "min\n" + "Date: " + date);
    }
    
    public String toString(int n) {
    	return (distance + "," + temps + "," + date);
    }
} 
