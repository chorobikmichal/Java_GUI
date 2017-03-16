package a3final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchMenuPanel extends JPanel {
    
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    
/*
This method and class creates a panel for the search
*/  
    public SearchMenuPanel(){
        
       
        Dimension size = getPreferredSize();
        setPreferredSize(size);
        
        setSize(600,550);
        setBackground(Color.GRAY);
        
        setBorder(BorderFactory.createTitledBorder("Personal Details"));
        
        JLabel productID = new JLabel("productID: ");
        JLabel name = new JLabel("name keywords: ");
        JLabel startYear = new JLabel("start year: ");
        JLabel endYear = new JLabel("end year: ");

        JTextField productIDField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField startYearField = new JTextField(10);
        JTextField endYearField = new JTextField(10);

        JButton rst = new JButton ("Reset");
        JButton searchBtn = new JButton ("Search");
        
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.GRAY);

        JPanel bp = new JPanel();
        bp.setLayout(new GridBagLayout());
        bp.setBackground(Color.GRAY);

        setLayout(new BorderLayout(1,2));
        GridBagConstraints gc = new GridBagConstraints();
      
        
        //-----------------------FIRST COLUMN--------------------------------
        
        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        p.add(productID, gc);

        gc.gridx =0;
        gc.gridy = 1;
        p.add(name,gc);
        
        gc.gridx =0;
        gc.gridy = 2;
        p.add(startYear,gc);
        
        gc.gridx =0;
        gc.gridy = 3;
        p.add(endYear,gc);
                
        //-----------------------FIRST COLUMN--------------------------------
        
        gc.anchor = GridBagConstraints.LINE_START;
        
        p.add(new JLabel("                                            "),gc);
        
        gc.gridx =1;
        gc.gridy = 0;
        p.add(productIDField,gc);
        
        gc.gridx = 1;
        gc.gridy = 1;        
        p.add(nameField, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        p.add(startYearField,gc);
        
        gc.gridx =1;
        gc.gridy = 3;
        p.add(endYearField,gc);
        
        add(p,BorderLayout.WEST);
        
        //-----------------------FINAL ROW--------------------------------
        
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridx =2;
        gc.gridy = 0;
        bp.add(rst,gc);

        gc.gridx =2;
        gc.gridy = 1;
        bp.add(searchBtn,gc);

        gc.gridx =2;
        gc.gridy = 0;
        bp.add(new JLabel("                                                 "),gc);
        
        add(bp,BorderLayout.EAST);
        
        
        searchBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String productID = productIDField.getText();
                String name = nameField.getText();
                String startYearStr = startYearField.getText();
                String endYearStr = endYearField.getText();
                
                if(productID.length()==0){
                    productID="0";
                }
                if(name.length()==0){
                    name="";
                }
                if(startYearStr.length()==0){
                    startYearStr="0";
                }
                if(endYearStr.length()==0){
                    endYearStr="9999";
                }

                EStoreSearch frame = new EStoreSearch();
                frame.search(productID,name,startYearStr,endYearStr);
                
            }
        });
        
        rst.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            productIDField.setText("");
            nameField.setText("");
            startYearField.setText("");
            endYearField.setText("");

            }
        });
    }
}