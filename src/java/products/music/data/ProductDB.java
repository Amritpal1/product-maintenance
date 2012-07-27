/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products.music.data;

import products.data.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.sql.DataSource;
import products.music.business.Product;
import products.shop.ProductServlet;
import products.shop.ProductsAdd;

/**
 *
 * @author juliantais
 */
public class ProductDB {

    private static ArrayList<Product> products = null;
    //String sqlStatement = "";
    String sqlResult = "";

    public static void main(String[] args) throws SQLException, NamingException {
        Product prod = new Product("kakkdaka", "fdsa", "11.00");
        ProductDB.getOne("blah");
    }

    public static Product getOne(String sku) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/julian";
        String username = "root";
        String password = "password";
        Connection connection = DriverManager.getConnection(
                dbURL, username, password);

        Statement statement = connection.createStatement();

        String sqlStatement = "SELECT ProductCode, ProductDescription, ProductPrice "
                            + "FROM Product WHERE ProductCode = '" + sku.toLowerCase() + "';";

        System.out.println(sqlStatement);
        
        
        
        ResultSet resultSet = statement.executeQuery(sqlStatement);
        resultSet.next();
        Product p = new Product();
        p.setSKU(resultSet.getString(1));
        p.setDescription(resultSet.getString(2));
        p.setPrice(resultSet.getDouble(3));
        System.out.println(p.getSKU()+p.getDescription()+p.getPriceFormat());
                
        statement.close();
        connection.close();
        
        return p;
    }

    public static ArrayList<Product> getProducts() {
        try {
            products = new ArrayList<Product>();

            String dbURL = "jdbc:mysql://localhost:3306/julian";
            String username = "root";
            String password = "password";
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);

            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM Product;";

            System.out.println(sqlStatement);

            ResultSet resultSet = statement.executeQuery(sqlStatement);
            ResultSetMetaData metaData = resultSet.getMetaData();




            while (resultSet.next()) {
                Product p = new Product();


                p.setSKU(resultSet.getString(2));
                p.setDescription(resultSet.getString(3));
                p.setPrice(resultSet.getDouble(4));
                System.out.println(p.getSKU() + p.getDescription() + p.getPriceFormat());

                products.add(p);

            }

            statement.close();
            connection.close();

            /*
             * File file = new File(path);
             *
             * try {
             *
             * BufferedReader in = new BufferedReader(new FileReader(file));
             *
             * String eachLine;
             *
             * while((eachLine = in.readLine()) != null) {
             *
             * StringTokenizer t = new StringTokenizer(eachLine, "|");
             *
             * if(t.countTokens() >= 3){ String sku = t.nextToken(); String
             * description = t.nextToken(); String money = t.nextToken(); double
             * price = Double.parseDouble(money);
             *
             *
             * Product p = new Product(); p.setSKU(sku);
             * p.setDescription(description); p.setPrice(price);
             *
             * products.add(p);
             *
             *
             * }
             * }
             *
             * in.close();
             *
             *
             * } catch (FileNotFoundException ex) {
             * Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE,
             * null, ex); }
             */

        } catch (SQLException ex) {
            Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;

    }

    public static void insert(Product p) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/julian";
        String username = "root";
        String password = "password";
        Connection connection = DriverManager.getConnection(
                dbURL, username, password);

        Statement statement = connection.createStatement();

        String sqlStatement = "INSERT INTO Product VALUES (null, '"
                + p.getSKU().toLowerCase() + "', '"
                + p.getDescription() + "', " + p.getPriceFormat() + ");";
        System.out.println(sqlStatement);

        statement.executeUpdate(sqlStatement);

        statement.close();
        connection.close();
    }

    public static void update(Product p) throws NamingException, SQLException {

        String dbURL = "jdbc:mysql://localhost:3306/julian";
        String username = "root";
        String password = "password";
        Connection connection = DriverManager.getConnection(
                dbURL, username, password);

        Statement statement = connection.createStatement();

        String sqlStatement = "UPDATE Product SET ProductDescription = '" + p.getDescription()
                + "' , ProductPrice = " + p.getPriceFormat()
                + " WHERE ProductCode = '" + p.getSKU().toLowerCase() + "';";
        System.out.println(sqlStatement);

        statement.executeUpdate(sqlStatement);

        statement.close();
        connection.close();

    }

    public static void delete(String sku) throws NamingException, SQLException {

        String dbURL = "jdbc:mysql://localhost:3306/julian";
        String username = "root";
        String password = "password";
        Connection connection = DriverManager.getConnection(
                dbURL, username, password);

        Statement statement = connection.createStatement();


        String sqlStatement = "DELETE FROM Product"
                + " WHERE ProductCode = '" + sku.toLowerCase() + "';";
        System.out.println(sqlStatement);

        statement.executeUpdate(sqlStatement);

        statement.close();
        connection.close();


    }

    public static boolean skuExists(String sku) throws NamingException {
        try {
            String dbURL = "jdbc:mysql://localhost:3306/julian";
            String username = "root";
            String password = "password";
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);

            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT ProductCode FROM Product"
                    + " WHERE ProductCode = '" + sku.toLowerCase() + "';";

            System.out.println(sqlStatement);

            ResultSet resultSet = statement.executeQuery(sqlStatement);
            if (resultSet.next()) {
                statement.close();
                connection.close();
                System.out.println("HAHAH");
                return true;
            }


        } catch (SQLException ex) {
            Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static void connect() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/julian";
        String username = "root";
        String password = "password";
        Connection connection = DriverManager.getConnection(
                dbURL, username, password);
    }

    public static void log(DataSource d) {
        d.toString();
    }
}
