package controller;

import model.InsertIntoDB;
import model.Item;
import model.XMLReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {

    public static void main(String[] args) {
        Queue<Item> itemQueue=null;

        Connection connection=null;

        ExecutorService executor = Executors.newFixedThreadPool(10);


        XMLReader xmlReader = new XMLReader();

       itemQueue = xmlReader.getItemQueueFromXML("C:\\Price.xml");

        InsertIntoDB insertIntoDB = new InsertIntoDB();
        Queue<Item> finalItemQueue = itemQueue;
        executor.submit(()->{
          for (Item item : finalItemQueue){
              insertIntoDB.createPreparedStatement(item.getCart(),item.getItemCatNumber(), item.getNameRus(),
                      item.getNameUkr(),item.getBrand(),item.getPriceIn(),item.getPriceOut(),item.getPriceStruck(),
                      item.getWeight(),item.isStock());
          }
      });
        executor.shutdown();

    }
    }

