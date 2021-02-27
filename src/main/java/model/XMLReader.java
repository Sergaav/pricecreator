package model;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class XMLReader {

    private final SAXParser parser;
    public static Queue<Item> itemQueue = new ConcurrentLinkedQueue<>();


    public XMLReader() throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();


    }

    public Queue<Item> getItemQueueFromXML(String fileName) throws IOException, SAXException {
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
        return itemQueue;

    }

    private static class XMLHandler extends DefaultHandler {
        String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("Прайс"))
                lastElementName = qName;


//
//                item.setItemCatNumber(attributes.getValue("KODKAT"));
//                item.setNameRus(attributes.getValue("NAIM"));
//                item.setNameUkr(attributes.getValue("NAIMUKR"));
//                item.setBrand(attributes.getValue("PROIZVODIT"));
//                item.setPriceIn(Double.parseDouble(attributes.getValue("CENAPART")));
//                item.setWeight(Double.parseDouble(attributes.getValue("MASSA")));
//                itemQueue.add(item);
            System.out.println(attributes.getType("KART"));
            System.out.println(attributes.getType("KODKAT"));
            System.out.println(attributes.getType("NAIM"));
        }


        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ((name != null && !name.isEmpty()) && (job != null && !job.isEmpty())) {
                employees.add(new Employee(name, job));
                name = null;
                job = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            Item item = context.getBean("myItem", Item.class);

            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("KART"))
                    item.setCart(Integer.parseInt(information));
                if (lastElementName.equals("KODKAT"))
                    item.setItemCatNumber(information);

            }
        }

    }

}

