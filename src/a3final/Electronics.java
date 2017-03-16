package a3final;

/*******************
Michal Chorobik
0937145
Assignment 2
November 7, 2016 
*******************/
import java.util.*;

public class Electronics extends Product {
    /*
    a electronic element is created here. Values that it uses are passed on from main. It also usess the variables from the product class
    */
    public Electronics(int productID,String name,double price,int year,String maker) {
        
        super.makeElement(productID, name, price, year);
        this.maker = maker;
        
    }
    /*
    here the year is printed for the use of EStoreSearch
    */
    public void printYear(){
       System.out.println(year);
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
    here all the items in the object are printed for the use of EStoreSearch
    */
    public void print(){
        
        System.out.println("");
        System.out.println("electronic found ");
        System.out.println("product ID: "+productID);
        System.out.println("elsectronics name: "+name);
        System.out.println("price: "+price);
        System.out.println("year: "+year);
        System.out.println("maker: "+maker);
        System.out.println("");
        
        //String printLine = "\n"+"\nelectronic found "+"\nproduct ID: "+productID+"\nelsectronics name: "+name+"\nprice: "+price+"\nyear: "+year+"\nmaker: "+maker +"\n"; 
        //return printLine;

    }
    /*
    here product type is returned
    */
    public String getType(){
        String printLine = "electronic"; 
        return printLine;
    }
    /*
    this function writes into a file its objects parameters
    */
    public String writeFile(){
        String printLine = "electronic"+";"+productID+";"+name+";"+price+";"+year+";"+maker; 
        return printLine;
    }
}
