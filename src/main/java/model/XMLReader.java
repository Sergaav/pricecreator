package model;

import org.jdom2.*;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.StAXEventBuilder;
import org.jdom2.input.StAXStreamBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class XMLReader {


    public static Queue<Item> itemQueue = new ConcurrentLinkedQueue<>();


    public XMLReader() {

    }

    public Queue<Item> getItemQueueFromXML(String fileName) {
        try {
            org.jdom2.Document document = createJDOMusingSAXParser(fileName);
            Element root = document.getRootElement();

            List<Element> ItemElements = root.getChildren("Прайс");
            for (Element element : ItemElements) {
                Item item = new Item();

                item.setCart(element.getChild("KART").getValue().trim());

                item.setNameRus(element.getChild("NAIM").getValue().trim());
                item.setNameUkr(element.getChild("NAIMUKR").getValue().trim());
                item.setItemCatNumber(element.getChild("KODKAT").getValue().trim());

                item.setPriceIn(Double.parseDouble(element.getChild("CENAPART").getValue().trim().replace(',','.')));

                item.setBrand(element.getChild("PROIZVODIT").getValue().trim());
                item.setWeight(Double.parseDouble(element.getChild("MASSA").getValue().trim().replace(',','.')));

                itemQueue.add(item);
            }


        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }

        return itemQueue;
    }

    private static org.jdom2.Document createJDOMusingDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //создаем DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build((Document) doc);

    }

    private static org.jdom2.Document createJDOMusingSAXParser(String fileName)
            throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        return saxBuilder.build(new File(fileName));
    }

    // получаем экземпляр JDOM Document с помощью STAX Stream Parser или STAX Event Parser
    private static org.jdom2.Document createJDOMusingSTAXParser(String fileName, String type)
            throws FileNotFoundException, XMLStreamException, JDOMException {
        if (type.equalsIgnoreCase("stream")) {
            StAXStreamBuilder staxBuilder = new StAXStreamBuilder();
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader =
                    xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
            return staxBuilder.build(xmlStreamReader);
        }
        StAXEventBuilder staxBuilder = new StAXEventBuilder();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(
                new FileInputStream(fileName));
        return staxBuilder.build(xmlEventReader);

    }


}

