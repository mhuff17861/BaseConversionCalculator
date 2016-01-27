/*
Micah Huff
CIS 160
Assignment 7
10-22-2015

Creates a GUI used to convert numbers between binary, octal, decimal and hex
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NumberSystemCalc extends JFrame implements ActionListener {
    //class level vars
    //radio buttons
    JRadioButton rbtnBin = new JRadioButton("Bin", true);
    JRadioButton rbtnOct = new JRadioButton("Oct");
    JRadioButton rbtnDec = new JRadioButton("Dec");
    JRadioButton rbtnHex = new JRadioButton("Hex");
    //text box
    JTextField txtInput = new JTextField();
    //check for which is checked
    int previousCheck = 0;
    
    public static void main(String[] args) {
        NumberSystemCalc app = new NumberSystemCalc();
    }
    
    public NumberSystemCalc() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
        
    }
    
    public void createGUI() {
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        
        //build containers
        JPanel conSouth = new JPanel();
        JPanel conNorth= new JPanel();
        
        conSouth.setLayout(new GridLayout(1, 4));
        conNorth.setLayout(new GridLayout(1, 1));
        
        add(conNorth);
        add(conSouth);
        
        //adding radio buttons to gui
        ButtonGroup grpRbtn = new ButtonGroup();
        
        grpRbtn.add(rbtnBin);
        grpRbtn.add(rbtnOct);
        grpRbtn.add(rbtnDec);
        grpRbtn.add(rbtnHex);
        
        //action!
        rbtnBin.addActionListener(this);
        rbtnOct.addActionListener(this);
        rbtnDec.addActionListener(this);
        rbtnHex.addActionListener(this);
        
        //add to JFrame
        conNorth.add(txtInput);
        conSouth.add(rbtnBin);
        conSouth.add(rbtnOct);
        conSouth.add(rbtnDec);
        conSouth.add(rbtnHex);
    }
    //checks to see the previous radio button checked for correct conversion
    public long previousRbtn(String input) {
        long out;
        switch (previousCheck) {
            case 0: out = Long.parseLong(input, 2);
            break;
            case 1: out = Long.parseLong(input, 8);
            break;
            case 2: out = Long.parseLong(input, 10);
            break;
            default: out = Long.parseLong(input, 16);
        }
        return out;
    }
    
    public void actionPerformed(ActionEvent e) {
        String input = txtInput.getText();
        long con;
        //does calculation based on radio button selection
        if (rbtnBin.isSelected()) {
            try {
                con = previousRbtn(input);
                input = Long.toString(con, 2);
                txtInput.setText(input);
                previousCheck = 0;
            } catch (NumberFormatException n) {
                previousCheck = 0;
            }
        } else if (rbtnOct.isSelected()) {
            try {
                con = previousRbtn(input);
                input = Long.toString(con, 8);
                txtInput.setText(input);
                previousCheck  = 1;
            } catch (NumberFormatException n) {
                previousCheck  = 1;
            }
        } else if (rbtnDec.isSelected()) {
            try {
                con = previousRbtn(input);
                input = Long.toString(con, 10);
                txtInput.setText(input);
                previousCheck  = 2;
            } catch (NumberFormatException n) {
                previousCheck  = 2;
            }
        } else {
            try {
                con = previousRbtn(input);
                input = Long.toString(con, 16);
                txtInput.setText(input);
                previousCheck  = 3;
            } catch (NumberFormatException n) {
                previousCheck  = 3;
            }
        }
   }
}
