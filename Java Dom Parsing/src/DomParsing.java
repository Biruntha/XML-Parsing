import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParsing {
    public static void main(String[] args){

        try {
            File inputFile = new File("customer.xml");
            // DocumentBuilderFactory class defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            //The normalize() method merges adjacent text() nodes and removes empty ones in the whole document.
            doc.getDocumentElement().normalize();
            // Returns the root element of the document
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Customer");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Company Name : " + eElement.getElementsByTagName("CompanyName").item(0).getTextContent());
                    System.out.println("Contact Name : " + eElement.getElementsByTagName("ContactName").item(0).getTextContent());
                    System.out.println("FullAddress : " + eElement.getElementsByTagName("Address").item(0).getTextContent() +" "+ eElement.getElementsByTagName("City").item(0).getTextContent()+" "+ eElement.getElementsByTagName("Country").item(0).getTextContent());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}