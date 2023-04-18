import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Task2 {

    public static void main(String[] args) {
        try {
            // Specify the path to the input XML file
            File inputFile = new File("data.xml");

            // Create a DocumentBuilderFactory object to create a DOM parser
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder object to parse the input XML file
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input XML file and create a Document object
            Document doc = dBuilder.parse(inputFile);

            // Normalize the Document object to remove empty text nodes and combine adjacent text nodes
            doc.getDocumentElement().normalize();

            // Get a list of all record elements in the XML file
            NodeList recordList = doc.getElementsByTagName("record");

            // Loop through each record element
            for (int i = 0; i < recordList.getLength(); i++) {
                Node recordNode = recordList.item(i);

                if (recordNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element recordElement = (Element) recordNode;

                    // Get the value of the name, postalZip, region, country, address, and list fields for this record
                    String name = recordElement.getElementsByTagName("name").item(0).getTextContent();
                    String postalZip = recordElement.getElementsByTagName("postalZip").item(0).getTextContent();
                    String region = recordElement.getElementsByTagName("region").item(0).getTextContent();
                    String country = recordElement.getElementsByTagName("country").item(0).getTextContent();
                    String address = recordElement.getElementsByTagName("address").item(0).getTextContent();
                    String list = recordElement.getElementsByTagName("list").item(0).getTextContent();

                    // Print out the values of the fields for this record
                    System.out.println("Name: " + name);
                    System.out.println("Postal Zip: " + postalZip);
                    System.out.println("Region: " + region);
                    System.out.println("Country: " + country);
                    System.out.println("Address: " + address);
                    System.out.println("List: " + list);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
