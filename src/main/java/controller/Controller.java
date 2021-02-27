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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Item item = context.getBean("myItem",Item.class);
        Queue<Item> itemQueue=null;

        ExecutorService executor = Executors.newFixedThreadPool(10);


        try {
            XMLReader xmlReader = new XMLReader();
            itemQueue = xmlReader.getItemQueueFromXML("C:\\Price.xml");

        }catch (ParserConfigurationException | SAXException e){
            System.out.println("Some problems with XML file or parsing!!");
        }catch (IOException e){
            System.out.println("Some problem with reading file!");
        }

      if (itemQueue!=null) {
          for (Item items : itemQueue) {
              System.out.println(items.toString());
          }

      }






    }
}
