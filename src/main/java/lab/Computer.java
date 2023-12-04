package lab;

import java.util.*;

public class Computer {
    private String manufacturer;
    private String id;
    private String processer;
    private String yearBought;
    private ArrayList<Montior> montiorList;

    public Computer(String manufacturer, String id, String processor, String yearBought, ArrayList<Montior> montiorList)
    {
        this.manufacturer = manufacturer;
        this.id = id;
        this.processer = processor;
        this.yearBought = yearBought;
        this.montiorList = montiorList;
    }
    @Override
    public String toString()
    {
        String montiors = "";
        for(int i = 0; i < montiorList.size(); i++)
        {
           montiors += montiorList.get(i).toString();
        }
        return "Computer: " + "\n\tManufacturer: " + manufacturer + " ID: " + id + " Processor: " + processer + " Year Bought: " + yearBought + "\n Montiors: " + montiors;
    }
}
