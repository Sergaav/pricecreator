package controller;

import model.Item;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Controller {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Item item = context.getBean("myItem",Item.class);
    }
}
