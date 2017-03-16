package a3final;

/*******************
Michal Chorobik
0937145
Assignment 2
November 7, 2016
*******************/

public class Product {
    
    public int productID;
    public String name;
    public double price;
    public int year;
    public String maker;
    public String author;
    public String publisher;
    
    public void Product(){
    }
    /*
    here the values that are common in both electronics and books class are assigned their values in order to be passed down
    */
    public void makeElement(int productID,String name,double price,int year){
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.year = year;
        
    }
    /*
    //here the id is printed for the use of EStoreSearch
    */
    public int getproductID(){
        return productID;
    }
    /*
    the print fuction is empty, but it overridden by the books and electronics classes
    */
    public void print(){
    }
    /*
    here the year is printed for the use of EStoreSearch
    */
    public int getYear(){
        return year;
    }
    /*
    here the name of the product is returned
    */
    public String getName(){
        return name;
    }    
    /*
    here product type is returned. this function is used by books and electronics classes. Here it is not used
    */
    public String getType(){
        String printLine = "product"; 
        return printLine;
    }
    /*
    this function writes into a file. this function is used by books and electronics classes. Here it is not used
    */
    public String writeFile(){
        String printLine = "empty"; 
        return printLine;
    }
}
