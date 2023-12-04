package lab;

public class Montior {
    private String mID;
    private String manufacturer;
    private String resolution;

    public Montior(String mID, String manufacturer, String resolution){
        this.mID = mID;
        this.manufacturer = manufacturer;
        this.resolution = resolution;
    }  
    @Override
    public String toString()
    {
        return "\n\tID: " + mID + " Manufacturer: " + manufacturer + " Resolution: " + resolution;
    }
}
