package lab;

import java.util.ArrayList;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ComputerLab {
   private ArrayList<Computer> computeList;
   private ArrayList<Montior> montiorList; 

   public ComputerLab()
   {

   }
   public static Document readXMLDocumentFromFile(String fileNameWithPath) throws Exception {

    //Get Document Builder
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    //Build Document
    Document document = builder.parse(new File(fileNameWithPath));

    return document;
}
   

   public ArrayList<Montior> MontiorList(Document d1)
   {
        NodeList nList2 = d1.getElementsByTagName("montior");
                    for( int mID = 0; mID < nList2.getLength(); mID++)
                    {
                        Node mNode = nList2.item(mID);
                        if (mNode.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element mElement = (Element) mNode;
                            String montiorID = mElement.getAttribute("mID");
                            String manufacturer = mElement.getElementsByTagName("manufacturer").item(0).getTextContent();
                            String resolution = mElement.getElementsByTagName("resolution").item(0).getTextContent();
                            Montior m1 = new Montior(montiorID, manufacturer, resolution);
                            montiorList.add(m1);

                        }
                        
                            
                    }
                    return montiorList;
   }

   public ArrayList<Computer> Parse(Document d1) throws Exception
   {
    NodeList nList = d1.getElementsByTagName("computer");
     Document document = readXMLDocumentFromFile("C:/Users/mm1049079/Desktop/GitHub/computelab/src/main/java/lab/lab.xml");
    ArrayList<Montior> montiorList = MontiorList(document);

        for (int idNUM = 0; idNUM < nList.getLength(); idNUM++) {
            Node node = nList.item(idNUM);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String computeID = eElement.getAttribute("id");
                String manufacturer = eElement.getElementsByTagName("manufacturer").item(0).getTextContent();
                String yearBought = eElement.getElementsByTagName("yearbought").item(0).getTextContent();
                String processor = eElement.getElementsByTagName("processor").item(0).getTextContent();
                
                Computer compute1 = new Computer(computeID, manufacturer, yearBought, processor, montiorList);
                computeList.add(compute1);
                
            }
        }
        return computeList;
   }
}
