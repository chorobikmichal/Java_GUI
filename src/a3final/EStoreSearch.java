package a3final;

/*******************
Michal Chorobik
0937145
Assignment 3
November 30, 2016
*******************/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/*
This class creates the jframe for all the panels
*/
public class EStoreSearch extends JFrame implements ActionListener{
    
     int check;
     boolean valid;
     String productIDStr,yearStr,priceStr;
     String name;
     String author;
     String publisher;
     String maker;
     String keywords;
     String yearFormStr;
     String yearToStr;
     int productID=0;
     int year=0;
     int yearForm=0;
     int yearTo=0;
     double price=0;
    
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    static ArrayList <Product> products = new ArrayList <Product>();

    JTextArea memoDisplay;
    JScrollPane scrolledText;

    public addProductPanel addProductPanel;
    public SearchMenuPanel SearchMenuPanel;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 600;
        
/*
EStroreSearch creates multiple panels that are then added to the jframe
*/
    public EStoreSearch(){
        super();
        
        addProductPanel = new addProductPanel();
//--------------------------------SearchMenuPanel-------------------------------------------------------------------------------------
        SearchMenuPanel = new SearchMenuPanel();
//--------------------------------SearchMenuPanel-------------------------------------------------------------------------------------

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("eStore");
        setLayout(new BorderLayout(3,1));
           
        
        String[] actionStrings = { "Add a prduct", "Search for a product", "Exit" };
        JComboBox petList = new JComboBox(actionStrings);
        petList.setSelectedIndex(2);
        petList.addActionListener(this);

        add(petList, BorderLayout.NORTH);
       
        JTextArea blank = new JTextArea();
        blank.setSize(600,550);
        //blank.setHorizontalAlignment(JLabel.CENTER);
        blank.setText("\n\n\n\n\n\n\n\n          Welcome to eStore\n\n "+"          Choose a command from the â€œCommandsâ€� menu above\n "
                + "          for adding a product, searching products, or quitting the program");
        add(blank, BorderLayout.CENTER);
        
        memoDisplay = new JTextArea(10,1);
        memoDisplay.setLineWrap(true);
        memoDisplay.setEditable(false);
        memoDisplay.setBackground(Color.gray);
        scrolledText = new JScrollPane(memoDisplay);
        scrolledText.setBorder(BorderFactory.createTitledBorder("Messages"));
        scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrolledText,BorderLayout.SOUTH);

        petList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox cb = (JComboBox)e.getSource();
                String choice = (String)cb.getSelectedItem();
                
                if(choice.equalsIgnoreCase("Exit")){
                    System.exit(0);
                }else if(choice.equalsIgnoreCase("Add a prduct")){

                    blank.setVisible(false);
                    SearchMenuPanel.setVisible(false);
                    addProductPanel.setVisible(true);
                    scrolledText.setBorder(BorderFactory.createTitledBorder("Messages"));
                    add(addProductPanel, BorderLayout.CENTER);
                      
                }else if (choice.equalsIgnoreCase("Search for a product")){
                    blank.setVisible(false);
                    addProductPanel.setVisible(false);
                    SearchMenuPanel.setVisible(true);
                    scrolledText.setBorder(BorderFactory.createTitledBorder("Search Results"));
                    SearchMenuPanel.setSize(600,550);
                    SearchMenuPanel.setBackground(Color.gray);
                    add(SearchMenuPanel, BorderLayout.CENTER);                 }
            }
        });
        
              memoDisplay.setText("I work");

    }

    public void actionPerformed(ActionEvent e) {
        //memoDisplay.setText("hhjfjh");
    }    
/*
This method adds strings and the index of the product form the product linked list to the hash map
*/
    public void addToHashMap(String toAdd,int index){
 
        toAdd=toAdd.toLowerCase();
        
        //System.out.println("word added is "+toAdd);
        if(map.containsKey(toAdd)){//add to existing key
            //System.out.println("and it elready exists in the hashmap");
            map.get(toAdd).add(index);
        }
        else {//add new key
            //System.out.println("and it added to the hashmap");
            map.put(toAdd, new ArrayList<Integer>());
            map.get(toAdd).add(index);
            //Integer g = map.get(toAdd).get(0);
        }
    }
/*
This method is meant to search for products by comparing integer strings given to it by the hash map and the retriving them from the linked list
*/
    public void search (String productIDStr,String keywords,String yearFormStr,String yearToStr){
             
        int productID;
        int yearForm;
        int yearTo;
        
        try{
            productID = Integer.parseInt(productIDStr); 
        }catch (NumberFormatException e){
            System.out.println("wrong input1");
            return;
        }         
        
        try{
            yearForm = Integer.parseInt(yearFormStr); 
        }catch (NumberFormatException e){
            System.out.println("wrong input2");
            return;
        }     
        
        try{
            yearTo = Integer.parseInt(yearToStr); 
        }catch (NumberFormatException e){
            System.out.println("wrong input3");
            return;
        }             
        
        keywords=keywords.toLowerCase();
        
        StringTokenizer find = new StringTokenizer(keywords, " ");
        
        if(!find.hasMoreElements()){
            for(int i=0;i<products.size();i++){
                Product b = products.get(i);
                    if((b.getYear()>= yearForm)&&(b.getYear()<= yearTo)){
                        if(b.getproductID()== productID){
                            b.print();
                        }else if(productID==0){
                            b.print();
                        }
                    } else if ((0 == yearForm)&&(0 == yearTo)){
                        if(b.getproductID()== productID){
                            b.print();
                        }else if(productID==0){
                            b.print();
                        }
                }
            }
        }
                         
        ArrayList<Integer> index1 = new ArrayList<Integer>();
        ArrayList<Integer> index2 = new ArrayList<Integer>();
        int firstLoop=0,siz;
        String oldKey;
        
        while(find.hasMoreElements()){

            oldKey =  find.nextToken();
            index2 = map.get(oldKey);
            
            if((find.hasMoreElements())&&(firstLoop==0)&&(index2!=null)){
                firstLoop++;
                String key =  find.nextToken();
                index1 = map.get(key);
                if(index1!=null){
                    index1.retainAll(index2);
                }else{
                    firstLoop--;
                    index2.clear();
                }  
            }else if((firstLoop!=0)&&(index2!=null)&&(index1!=null)){
                index1.retainAll(index2); 
            }

            if(!find.hasMoreElements()){
                
                if(firstLoop>0){
                    siz=index1.size();
                }else{
                    index1=index2;
                    siz=index1.size();
                }
                

                for(int i=0;i<siz;i++){
                    
                    int indx = index1.get(i);
                    Product b = products.get((indx));
                                        
                        if((b.getYear()>= yearForm)&&(b.getYear()<= yearTo)){
                            if(b.getproductID()== productID){
                                b.print();
                            }else if(productID==0){
                                b.print();
                            }
                        } else if ((0 == yearForm)&&(0 == yearTo)){
                            if(b.getproductID()== productID){
                                b.print();
                            }else if(productID==0){
                                b.print();
                            }
                        }
                }
            }//if statement to sun on last word
        }

    }
/*
This method recieves strings that are organized and added to the linked list
*/
    public void addBook(String productIDStr,String name,String priceStr,String yearStr,String author ,String publisher){
        
                        check=0;
                        
                        //This line does not do what it should for unknown reasons
                        memoDisplay.setText("I work as well");

                        valid = true;
                        
                            try{
                                productID = Integer.parseInt(productIDStr); 
                            }catch (NumberFormatException e){
                                System.out.println("wrong input");
                                return;
                            }         
                            
                            if(productID<0){
                                valid=false;
                                System.out.println("wrong input");
                                return;
                            }
                        //-------------------Making the book and checking if it doent already exist---------------------------------------------
                        

                        for(int x=0;x<products.size();x++){
                                int str1 = products.get(x).getproductID();
                                if(str1==productID){
                                    check++;
                                }  
                        }  
                        
                        if(check!=0){
                            System.out.println("Product Already Exists");
                            valid=false;
                            return;
                        }     

                        StringTokenizer moreWords = new StringTokenizer(name, " ");
                        while(!moreWords.hasMoreElements()){
                            addToHashMap(moreWords.nextToken(),products.size());
                        }
                                            
                            try{
                                price = Double.parseDouble(priceStr);
                            }catch (NumberFormatException e){
                                System.out.println("wrong input");
                                valid=false;
                                return;
                            }          
                            if(price<0){
                                valid=false;
                                System.out.println("wrong input");
                                return;
                            }
                                                
                            try{
                                year = Integer.parseInt(yearStr); 
                            }catch (NumberFormatException e){
                                valid=false;
                                System.out.println("wrong input");
                                return;
                            }       
                            
                            if((year<=1000)||(year>9999)){
                                System.out.println("wrong input");
                                valid = false;
                                return;
                            }
                                             
                        if(valid ==  true){
                            products.add(new Books(productID,name,price,year,author,publisher));
                            System.out.println("book added");
                        }else{
                                System.out.println("wrong input");
                                return;
                        }
                        
    }
/*
This method recieves strings that are organized and added to the linked list
*/
    public void addElectronic(String productIDStr,String name,String priceStr,String yearStr,String maker){
        
                        check=0;
                        valid = true;

                        try{
                                productID=Integer.parseInt(productIDStr);
                            }catch (NumberFormatException e){
                            }          
                            if(productID<0){
                                valid=false;
                                System.out.println("wrong input");
                                return;
                            }
                            
                        for(int x=0;x<products.size();x++){
                            int str1 = products.get(x).getproductID();
                                if(str1==productID){
                                    check++;
                            }  
                        }  
                        
                        if(check!=0){
                            System.out.println("Product Already Exists");
                            valid=false;
                            return;
                        }     

                        StringTokenizer moreWords = new StringTokenizer(name, " ");
                        while(!moreWords.hasMoreElements()){
                            addToHashMap(moreWords.nextToken(),products.size());
                        }
                        
                        
                            try{
                                price = Double.parseDouble(priceStr);
                            }catch (NumberFormatException e){
                                valid=false;
                                System.out.println("wrong input");
                                return;
                            }         
                            if(price<0){
                                valid=false;
                                System.out.println("wrong input");
                                return;
                            }
                               
                            try{
                                year = Integer.parseInt(yearStr);
                            }catch (NumberFormatException e){
                                valid=false;
                                System.out.println("wrong input");
                                return;
                            }          
                         
                        if((year<=1000)||(year>9999)){
                            System.out.println("wrong input");
                            valid=false;
                            return;
                        }

                        if(valid == true){
                            products.add(new Electronics(productID,name,price,year,maker));
                            System.out.println("electronic added");
                        }else{
                            System.out.println("wrong input");
                            return;
                        }
                        
                    }

}
