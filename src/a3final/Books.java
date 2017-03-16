package a3final;

/*******************
Michal Chorobik
0937145
Assignment 2
November 7, 2016
*******************/

import java.util.*;

public class Books extends Product {
    /*
    a book element is created here. Values that it uses are passed on from main. It also usess the variables from the product class
    */
    public Books(int productID,String name,double price,int year,String author,String publisher) {
        
        super.makeElement(productID, name, price, year);
        this.author = author;
        this.publisher = publisher;
        
    }
    /*
    paramiters added to this object can be checked with this function
    */
    public int errorCheck(String a){
        for(int i=0;i<a.length();i++){
            if(!Character.isDigit(a.charAt(i))){
                System.out.println("wrong input");
                return 1;
            }
        }
            return 0;

    } 
    /*
    here the id is printed for the use of EStoreSearch
    */
    public int getproductID(){
        return productID;
    }
    /*
    here the name of the product is returned
    */
    public String getName(){
        return name;
    }
    /*
    here the year is printed for the use of EStoreSearch
    */
    public int getYear(){
        return year;
    }
    /*
    here all the items in the object are printed for the use of EStoreSearch
    */
    public void print(){
        
        System.out.println("");
        System.out.println("book found ");
        System.out.println("product ID: "+productID);
        System.out.println("name of the book: "+name);
        System.out.println("price: "+price);
        System.out.println("year: "+year);
        System.out.println("author: "+author);
        System.out.println("publisher: "+publisher);
        System.out.println("");

        //String printLine = "\n"+"book found "+"\nproduct ID: "+productID+"\nelsectronics name: "+name+"\nprice: "+price+"\nyear: "+year+"\nauthor: "+author +"\npublisher: "+publisher+"\n"; 
        //return printLine;
    }
    /*
    here product type is returned
    */
    public String getType(){
        String printLine = "book"; 
        return printLine;
    }
    /*
    this function writes into a file its objects parameters
    */
    public String writeFile(){
        String printLine = "book"+";"+productID+";"+name+";"+price+";"+year+";"+author+";"+publisher; 
        return printLine;
    }
}
