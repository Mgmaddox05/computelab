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

    public String ToString()
    {
        return "Manufacturer: " + manufacturer + "Resolution: " + resolution;
    }
}
