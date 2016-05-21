import java.io.File;
import java.io.IOException;
import java.util.List;

//import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

//import static sun.plugin.javascript.navig.JSType.Document;


public class JDomParserDemo {
    public static void main(String[] args) {
        try {
            File inputFile = new File("customer.xml");

            SAXBuilder saxBuilder = new SAXBuilder();

            Document document = saxBuilder.build(inputFile);

            System.out.println("Root element :" + document.getRootElement().getName());

            Element classElement = document.getRootElement();

            List<Element> studentList = classElement.getChildren();
            System.out.println("----------------------------");

            for (int temp = 0; temp < studentList.size(); temp++) {
                Element student = studentList.get(temp);
                System.out.println("\nCurrent Element :" + student.getName());
                System.out.println("Company Name : " + student.getChild("CompanyName").getText());
                System.out.println("Contact Name : " + student.getChild("ContactName").getText());
                System.out.println("FullAddress : "+ student.getChild("FullAddress").getChild("Address").getText()+" "+ student.getChild("FullAddress").getChild("City").getText()+" "+ student.getChild("FullAddress").getChild("Country").getText());
            }
        }catch(JDOMException e){
            e.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}