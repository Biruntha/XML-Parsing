import java.io.FileNotFoundException;
import java.io.FileReader;


import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXParserDemo {
    public static void main(String[] args) {
        boolean CompanyName = false;
        boolean ContactName = false;
        boolean Address = false;
        boolean Country = false;
        boolean City = false;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =factory.createXMLEventReader(new FileReader("customer.xml"));

            while(eventReader.hasNext()){
                XMLEvent event = eventReader.nextEvent();
                switch(event.getEventType()){
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase("Customer")) {
                            System.out.println("Start Element : Customer");
                        } else if (qName.equalsIgnoreCase("CompanyName")) {
                            CompanyName = true;
                        } else if (qName.equalsIgnoreCase("ContactName")) {
                            ContactName = true;
                        } else if (qName.equalsIgnoreCase("FullAddress")) {
                            System.out.print("Full Address : ");
                        }
                        else if (qName.equalsIgnoreCase("Address")) {
                            Address = true;
                        }
                        else if (qName.equalsIgnoreCase("City")) {
                            City = true;
                        }
                        else if (qName.equalsIgnoreCase("Country")) {
                            Country = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(CompanyName){
                            System.out.println("Company Name: " + characters.getData());
                            CompanyName = false;
                        }
                        if(ContactName){
                            System.out.println("Contact Name: " + characters.getData());
                            ContactName = false;
                        }
                        if(Address){
                            System.out.print(characters.getData()+" ");
                            Address = false;
                        }
                        if(City){
                            System.out.print(characters.getData()+" ");
                            City = false;
                        }
                        if(Country){
                            System.out.println(characters.getData());
                            Country = false;
                        }
                        break;
                    case  XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if(endElement.getName().getLocalPart().equalsIgnoreCase("Customer")){
                            System.out.println("End Element : Customer");
                            System.out.println();
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}