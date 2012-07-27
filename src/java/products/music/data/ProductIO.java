/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliantais
 */
package products.music.data;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import products.music.business.*;

public class ProductIO {
    
    private static ArrayList<Product> products;

    public static void main(String [] args) throws IOException {
        String path = "/Users/juliantais/Dropbox/shop/build/web/WEB-INF/items.txt";
        
        /*products = getProducts(path);
        for (Product s : products) {
            System.out.println(s.getPrice() + s.getDescription() + s.getSKU());
        }*/
        Product p = new Product("fddadaddsa","rewq","1212.00");
        products = getProducts(path);
        add(p, path);
        //add(p, path);
    }
    public static ArrayList<Product> getProducts(String path) throws IOException {
        
        products = new ArrayList<Product>();
        File file = new File(path);
        
        try {
            
            BufferedReader in = new BufferedReader(new FileReader(file));
            
            String eachLine;
           
           while((eachLine = in.readLine()) != null) {
                
               StringTokenizer t = new StringTokenizer(eachLine, "|");
                
                if(t.countTokens() >= 3){
                    String sku = t.nextToken();
                    String description = t.nextToken();
                    String money = t.nextToken();
                    double price = Double.parseDouble(money);
                    
                    
                    Product p = new Product();
                    p.setSKU(sku);
                    p.setDescription(description);
                    p.setPrice(price);
                    
                    products.add(p);
                    
                    
                }
            }
           
            in.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
      
    }
    public static void saveProducts(ArrayList<Product> products, String path) throws IOException {
        
           File file = new File(path);
           PrintWriter out = new PrintWriter(new FileWriter(file));
           
           for (Product p : products) {
               out.println(p.getSKU() + "|" 
                       + p.getDescription() + "|"
                       + p.getPriceFormat());
           }
           
           out.close();
    }
    
    
    public static boolean add(Product product, String filepath) throws IOException {
        products = getProducts(filepath);
        for(Product p : products) {
            
            //if product is not null and it exists in database then do not add
            if (product != null && product.getSKU().equalsIgnoreCase(p.getSKU())) {
                System.out.println("add failed");
                return false;
            }
        }
        products.add(product);
        saveProducts(products, filepath);
        return true;
    }
    public static void delete(Product product, String filepath) throws IOException {
        products = getProducts(filepath);
        for(int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            
            if (product != null && product.getSKU().equalsIgnoreCase(p.getSKU()))
                products.remove(i);
            
            saveProducts(products, filepath);
        }
    }
    public static void update(Product product, String filepath) throws IOException {
        products = getProducts(filepath);
        for(int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            
            if (product != null && product.getSKU().equalsIgnoreCase(p.getSKU()))
                products.set(i, product);
                
            saveProducts(products, filepath);
        }
    }
    public static boolean exists(Product product, String filepath) throws IOException {
        products = getProducts(filepath);
        for(int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            
            if (product != null && product.getSKU().equalsIgnoreCase(p.getSKU()))
                return true;
        }
        System.out.println("Does not exist");
        return false;
    }
    public static Product exists(String sku, String filepath) throws IOException {
        
        products = getProducts(filepath);
        
        Product prod = new Product();
        for(Product p : products) {
            
            //if product is not null and it exists in database then do not add
            if (sku != null && sku.equalsIgnoreCase(p.getSKU())) {
                prod.setSKU(p.getSKU());
                prod.setDescription(p.getDescription());
                prod.setPrice(p.getPrice());
            }
        }
        return prod;
    }
    
    
}
