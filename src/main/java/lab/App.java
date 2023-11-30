package lab;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

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
        
        // Make a loop to add each element to computeList
        ArrayList<Computer> computeList = Parse(document);
        /*for(int i = 0; i < computeList.size(); i++)
        {
            System.out.println(computeList.get(i));
        }*/
        System.out.println(computeList.size());
    }

    private static ArrayList<Computer> Parse(Document document) {
        return null;
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

    


}
