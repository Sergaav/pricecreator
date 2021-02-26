package model;


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadCSV {
    private String fileName;
    private CSVReader reader;
    private static Queue<Item> queue = new ConcurrentLinkedQueue<>();

    public ReadCSV(String line) throws FileNotFoundException {
        this.fileName = line;
        reader = new CSVReader(new FileReader(line), ',', '"', 1);

    }

    public void readFileCSV (Queue<Item> queue){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(()->{
            try {
                while ()
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    private static ColumnPositionMappingStrategy setColumnMapping()
    {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Item.class);
        String[] columns = new String[] {"id", "firstName", "lastName", "country", "age"};
        strategy.setColumnMapping(columns);
        return strategy;
    }








}
