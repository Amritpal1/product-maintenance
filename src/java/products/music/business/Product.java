/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliantais
 */
package products.music.business;

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {
    
    private String sku;
    private String description;
    private double price;
    
    public Product() {
        
        sku = "";
        description = "";
        price = 0;
    }
    
    public Product(String sku, String description, String price) {
        
        
        this.sku = sku;
        this.description = description;
        if (price == null || "".equals(price))
            this.price = 0;
        else
            this.price = Double.parseDouble(price);
    }
    
    public void setSKU(String sku) {
        this.sku = sku;
    }

    public String getSKU() {
        return this.sku;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public String getPriceFormat() {
        NumberFormat n = NumberFormat.getNumberInstance();
        n.setMinimumFractionDigits(2);
       
        if (price == 0)
            return "";
        else
            return n.format(price).replace(",", "");
    }

    public String getPriceCurrencyFormat() {
        NumberFormat c = NumberFormat.getCurrencyInstance();
        return c.format(price);
    }
}
