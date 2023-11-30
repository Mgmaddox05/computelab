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

    public String ToString()
    {
        return "Manufacturer: " + manufacturer + "ID: " + id + "Processor: " + processer + "Year Bought: " + yearBought;
    }
}
