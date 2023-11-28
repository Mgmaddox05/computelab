package lab;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        Document document = readXMLDocumentFromFile("C:/Users/mm1049079/Desktop/GitHub/computelab/src/main/java/lab/lab.xml");
        Element root1 = getRootElement(document);
        System.out.println(root1);
        getComputerDetail(document);

    }

    public static Document readXMLDocumentFromFile(String fileNameWithPath) throws Exception {

        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
    
        //Build Document
        Document document = builder.parse(new File(fileNameWithPath));
    
        return document;
    }

    public static Element getRootElement(Document doc1)
    {
        Element root = doc1.getDocumentElement();
        return root;
    }

    public static void getComputerDetail(Document d1) 
    {
        NodeList nList = d1.getElementsByTagName("computer");

        for (int idNUM = 0; idNUM < nList.getLength(); idNUM++) {
            Node node = nList.item(idNUM);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("\nComputer id : " + eElement.getAttribute("id"));
                System.out.println("Manufacturer : " + eElement.getElementsByTagName("manufacturer").item(0).getTextContent());
                System.out.println("Year Bought : " + eElement.getElementsByTagName("yearbought").item(0).getTextContent());
                System.out.println("Processor : " + eElement.getElementsByTagName("processor").item(0).getTextContent());
                
                //Accessing the Montior Node
                NodeList nList2 = eElement.getElementsByTagName("montior");
                for( int mID = 0; mID < nList2.getLength(); mID++)
                {
                    Node mNode = nList2.item(mID);
                    if (mNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element mElement = (Element) mNode;
                        System.out.println("\nMontior ID : " + mElement.getAttribute("mID"));
                        System.out.println("Manufacturer : " + mElement.getElementsByTagName("manufacturer").item(0).getTextContent());
                        System.out.println("Resolution : " + mElement.getElementsByTagName("resolution").item(0).getTextContent());
                    }
                    
                        
                }
                
               
                
            }
        }
    }


}
