package model;

import java.sql.*;
import java.util.Properties;

public class InsertIntoDB {
    private Connection connection = null;

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/pricecreator";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "123456789");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");


        connection = DriverManager.getConnection(url, properties);

        return connection;
    }

    public void createPreparedStatement(String cart, String kodKat, String nameRus, String nameUkr, String brand, double priceIn, double priceOut, double priceStruck, double weight, boolean stock) {


        String sql = "INSERT INTO items(cart,kodKat,nameRus,nameUkr,brand,priceIn,priceOut,priceStruck,weight,stock) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cart);
            preparedStatement.setString(2, kodKat);
            preparedStatement.setString(3, nameRus);
            preparedStatement.setString(4, nameUkr);
            preparedStatement.setString(5, brand);
            preparedStatement.setDouble(6, priceIn);
            preparedStatement.setDouble(7, priceOut);
            preparedStatement.setDouble(8, priceStruck);
            preparedStatement.setDouble(9, weight);
            preparedStatement.setBoolean(10, stock);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }


}
