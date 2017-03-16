package a3final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addProductPanel extends JPanel implements ActionListener{
    
    private addProductPanel addProductPanel;
   
 /*
This constructor just calls the addBookPanel
*/   
    public addProductPanel(){
        addBookPanel();
    } 
/*
This method retrives the info given by the user and passes it to the addBook method 
*/    
    public void addBookPanel(){
        
        Dimension size = getPreferredSize();
        setPreferredSize(size);
        
        setSize(600,550);
        setBackground(Color.GRAY);
                    
        setBorder(BorderFactory.createTitledBorder("Add Book"));
        setVisible(true);

        String[] actionStrings = { "electronic", "book" };
        JComboBox petList = new JComboBox(actionStrings);
        petList.setSelectedIndex(1);
        petList.addActionListener(this);
        
        JLabel type = new JLabel("type: ");
        JLabel productID = new JLabel("                             productID: ");
        JLabel name = new JLabel("name: ");
        JLabel price = new JLabel("price: ");
        JLabel year = new JLabel("year: ");
        JLabel author = new JLabel("author: ");
        JLabel publisher = new JLabel("publisher: ");
        JLabel blank = new JLabel("         ");
        
        JTextField productIDField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JTextField yearField = new JTextField(10);
        JTextField authorField = new JTextField(10);
        JTextField publisherField = new JTextField(10);

        JButton rst = new JButton ("Reset");
        JButton Btn = new JButton ("Add");

        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.GRAY);

        JPanel bp = new JPanel();
        bp.setLayout(new GridBagLayout());
        bp.setBackground(Color.GRAY);

        setLayout(new BorderLayout(1,2));
        GridBagConstraints gc = new GridBagConstraints();
      
        Btn.setVisible(true);
        rst.setVisible(true);
        type.setVisible(true);
        productID.setVisible(true);
        name.setVisible(true);
        price.setVisible(true);
        year.setVisible(true);
        author.setVisible(true);
        publisher.setVisible(true);
        petList.setVisible(true);
        productIDField.setVisible(true);
        nameField.setVisible(true);
        priceField.setVisible(true);
        yearField.setVisible(true);
        authorField.setVisible(true);
        publisherField.setVisible(true);
        p.setVisible(true);
        bp.setVisible(true);
        setVisible(true);            
        
        //-----------------------FIRST COLUMN--------------------------------
        
        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        
        gc.gridx = 0;
        gc.gridy = 0;
        p.add(type, gc);

        gc.gridx =0;
        gc.gridy = 1;
        p.add(productID,gc);
        
        gc.gridx =0;
        gc.gridy = 2;
        p.add(name,gc);
        
        gc.gridx =0;
        gc.gridy = 3;
        p.add(price,gc);

        gc.gridx =0;
        gc.gridy = 4;
        p.add(year,gc);

        gc.gridx =0;
        gc.gridy = 5;
        p.add(author,gc);

        gc.gridx =0;
        gc.gridy = 6;
        p.add(publisher,gc);
                
        //-----------------------FIRST COLUMN--------------------------------
        
        gc.anchor = GridBagConstraints.LINE_START;
        
        gc.gridx = 1;
        gc.gridy = 0;        
        p.add(petList, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        p.add(productIDField,gc);
        
        gc.gridx =1;
        gc.gridy = 2;
        p.add(nameField,gc);
        
        gc.gridx =1;
        gc.gridy = 3;
        p.add(priceField,gc);

        gc.gridx =1;
        gc.gridy = 4;
        p.add(yearField,gc);

        gc.gridx =1;
        gc.gridy = 5;
        p.add(authorField,gc);

        gc.gridx =1;
        gc.gridy = 6;
        p.add(publisherField,gc);
        
        add(p,BorderLayout.WEST);
        
        //-----------------------FINAL ROW--------------------------------
                
        gc.gridx =0;
        gc.gridy = 0;
        bp.add(rst,gc);

        gc.gridx =0;
        gc.gridy = 1;
        bp.add(Btn,gc);

        gc.gridx =0;
        gc.gridy = 0;
        bp.add(new JLabel("                                                 "),gc);

        //bp.add(Btn,BorderLayout.CENTER);       
        //bp.add(rst,BorderLayout.CENTER);
        add(bp,BorderLayout.EAST);
        
        
        Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String productID = productIDField.getText();
                String name = nameField.getText();
                String price = priceField.getText();
                String year = yearField.getText();
                String author = authorField.getText();
                String publisher = publisherField.getText();

                EStoreSearch frame = new EStoreSearch();
                frame.addBook( productID,name,price, year,author ,publisher);
                
            }
        });
        
        rst.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            productIDField.setText("");
            nameField.setText("");
            priceField.setText("");
            yearField.setText("");
            authorField.setText("");
            publisherField.setText("");

            }
        });
        
        petList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox cb = (JComboBox)e.getSource();
                String choice = (String)cb.getSelectedItem();
                
                if(choice.equalsIgnoreCase("electronic")){
                    Btn.setVisible(false);
                    rst.setVisible(false);
                    type.setVisible(false);
                    productID.setVisible(false);
                    name.setVisible(false);
                    price.setVisible(false);
                    year.setVisible(false);
                    author.setVisible(false);
                    publisher.setVisible(false);
                    petList.setVisible(false);
                    productIDField.setVisible(false);
                    nameField.setVisible(false);
                    priceField.setVisible(false);
                    yearField.setVisible(false);
                    authorField.setVisible(false);
                    publisherField.setVisible(false);
                    p.setVisible(false);
                    bp.setVisible(false);
                    setVisible(false);
                    addElectronicPanel();
                }
            }
        });
        
    }
    public void actionPerformed(ActionEvent e) {
        
    }    
/*
This method retrives the info given by the user and passes it to the addElectronic method 
*/  
    public void addElectronicPanel(){
                
        
        Dimension size = getPreferredSize();
        setPreferredSize(size);
        
        setSize(600,550);
        setBackground(Color.GRAY);
                    
        setBorder(BorderFactory.createTitledBorder("Add Elsectronic"));
        setVisible(true);

        String[] actionStrings = { "electronic", "book" };
        JComboBox petList = new JComboBox(actionStrings);
        petList.setSelectedIndex(1);
        petList.addActionListener(this);
        
        JLabel type = new JLabel("type: ");
        JLabel productID = new JLabel("                             productID: ");
        JLabel name = new JLabel("name: ");
        JLabel price = new JLabel("price: ");
        JLabel year = new JLabel("year: ");
        JLabel maker = new JLabel("maker: ");

        JTextField productIDField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JTextField yearField = new JTextField(10);
        JTextField makerField = new JTextField(10);

        JButton Btn = new JButton ("Add");
        JButton rst = new JButton ("Reset");

        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.GRAY);

        JPanel bp = new JPanel();
        bp.setLayout(new GridBagLayout());
        bp.setBackground(Color.GRAY);

        setLayout(new BorderLayout(1,2));
        GridBagConstraints gc = new GridBagConstraints();
      
        Btn.setVisible(true);
        rst.setVisible(true);
        type.setVisible(true);
        productID.setVisible(true);
        name.setVisible(true);
        price.setVisible(true);
        year.setVisible(true);
        maker.setVisible(true);
        petList.setVisible(true);
        productIDField.setVisible(true);
        nameField.setVisible(true);
        priceField.setVisible(true);
        yearField.setVisible(true);
        makerField.setVisible(true);
        p.setVisible(true);
        bp.setVisible(true);
        setVisible(true);            
        
        //-----------------------FIRST COLUMN--------------------------------
        
        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        
        gc.gridx = 0;
        gc.gridy = 0;
        p.add(type, gc);

        gc.gridx =0;
        gc.gridy = 1;
        p.add(productID,gc);
        
        gc.gridx =0;
        gc.gridy = 2;
        p.add(name,gc);
        
        gc.gridx =0;
        gc.gridy = 3;
        p.add(price,gc);

        gc.gridx =0;
        gc.gridy = 4;
        p.add(year,gc);

        gc.gridx =0;
        gc.gridy = 5;
        p.add(maker,gc);
                
        //-----------------------FIRST COLUMN--------------------------------
        
        gc.anchor = GridBagConstraints.LINE_START;
        
        gc.gridx = 1;
        gc.gridy = 0;        
        p.add(petList, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        p.add(productIDField,gc);
        
        gc.gridx =1;
        gc.gridy = 2;
        p.add(nameField,gc);
        
        gc.gridx =1;
        gc.gridy = 3;
        p.add(priceField,gc);

        gc.gridx =1;
        gc.gridy = 4;
        p.add(yearField,gc);

        gc.gridx =1;
        gc.gridy = 5;
        p.add(makerField,gc);
        
        add(p,BorderLayout.WEST);
        
        //-----------------------FINAL ROW--------------------------------
                
        gc.gridx =0;
        gc.gridy = 0;
        bp.add(rst,gc);

        gc.gridx =0;
        gc.gridy = 1;
        bp.add(Btn,gc);

        gc.gridx =0;
        gc.gridy = 0;
        bp.add(new JLabel("                                                 "),gc);

        //bp.add(Btn,BorderLayout.CENTER);       
        //bp.add(rst,BorderLayout.CENTER);
        add(bp,BorderLayout.EAST);
                    
Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String productID = productIDField.getText();
                String name = nameField.getText();
                String price = priceField.getText();
                String year = yearField.getText();
                String maker = makerField.getText();
                
                
                EStoreSearch frame = new EStoreSearch();
                frame.addElectronic( productID,name,price, year ,maker);
                
            }
        });
        
        rst.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            productIDField.setText("");
            nameField.setText("");
            priceField.setText("");
            yearField.setText("");
            makerField.setText("");

            }
        });        
        petList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox cb = (JComboBox)e.getSource();
                String choice = (String)cb.getSelectedItem();
                
                if(choice.equalsIgnoreCase("book")){
                    Btn.setVisible(false);
                    rst.setVisible(false);
                    type.setVisible(false);
                    productID.setVisible(false);
                    name.setVisible(false);
                    price.setVisible(false);
                    year.setVisible(false);
                    maker.setVisible(false);
                    petList.setVisible(false);
                    productIDField.setVisible(false);
                    nameField.setVisible(false);
                    priceField.setVisible(false);
                    yearField.setVisible(false);
                    makerField.setVisible(false);
                    p.setVisible(false);
                    bp.setVisible(false);
                    setVisible(false);
                    addBookPanel();
                }
            }
        });
        
    }
    
}
