package controller;

import model.Item;
import model.XMLReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {

    public static void main(String[] args) {
        Queue<Item> itemQueue=null;
        ExecutorService executor = Executors.newFixedThreadPool(10);


        XMLReader xmlReader = new XMLReader();
       itemQueue = xmlReader.getItemQueueFromXML("C:\\Price2.xml");

        if (itemQueue!=null) {
          for (Item items : itemQueue) {
              System.out.println(items.toString());
          }

      }






    }
}
