package lab;

import java.util.ArrayList;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ComputerLab {
   
    

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
   

   public ArrayList<Montior> MontiorList(Element cElement)
   {
        
        ArrayList<Montior> montiorList = new ArrayList<Montior>();
        NodeList nList2 = cElement.getElementsByTagName("montior");
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

    ArrayList<Computer> computeList = new ArrayList<Computer>();
    NodeList nList = d1.getElementsByTagName("computer");
        for (int idNUM = 0; idNUM < nList.getLength(); idNUM++) {
            Node node = nList.item(idNUM);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                ArrayList<Montior> montiorList = MontiorList(eElement);
                String computeID = eElement.getAttribute("id");
                String manufacturer = eElement.getElementsByTagName("manufacturer").item(0).getTextContent();
                String yearBought = eElement.getElementsByTagName("yearbought").item(0).getTextContent();
                String processor = eElement.getElementsByTagName("processor").item(0).getTextContent();
                
                Computer compute1 = new Computer(manufacturer, computeID, yearBought, processor, montiorList);
                computeList.add(compute1);
                
            }
        }
        return computeList;
   }
}
