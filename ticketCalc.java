import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ticketCalc{
    
    //constructor for calculating ticket price
    public double ticketCalc(int ticketQuantity, int age, String isVet){
        
        //calculated total
        double total = 0;
        //if statment veteran discount
        if("yes".equals(isVet) && age > 55){
           total = 4.99*ticketQuantity;
        }
        //no veteran discount
        else{
           total = 9.99*ticketQuantity;
        }
        
        //returns total price
        return total;
    }
    
    //main setup GUI
    public static void main(String args[]){
        
        //components for GUI
        JButton Calc = new JButton("Calculate");
        JLabel ticketPrompt = new JLabel("How many tickets?");
        JLabel agePrompt = new JLabel("How old are you?");
        JLabel veteranPrompt = new JLabel("Are you a veteran?");
        JLabel isVet = new JLabel("no");
        JLabel totalPrice = new JLabel("Total $");
        JTextField numTickets = new JTextField(4);
        JTextField age = new JTextField(4);
        JRadioButton yes = new JRadioButton("yes");
        JRadioButton no = new JRadioButton("no", true);
        
        //Creates frame
        JFrame Frame = new JFrame("Ticket Calculator");
        Frame.setSize(640, 480);
        Frame.setLayout(new GridLayout(4, 1));
        
        //creates a portion to be added to main frame
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        //add components
        top.add(ticketPrompt);
        top.add(numTickets);
        //creates second portion for main frame
        JPanel row2 = new JPanel();
        row2.setLayout(new FlowLayout());
        //add componets
        row2.add(agePrompt);
        row2.add(age);
        //creates portion three for main frame
        JPanel row3 = new JPanel();
        row3.setLayout(new FlowLayout());
        //add components
        row3.add(veteranPrompt);
        row3.add(isVet);
        row3.add(yes);
        row3.add(no);
        //creates bottom portion of main frame
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        //add components
        bottom.add(Calc);
        bottom.add(totalPrice);
        //add action listener to 'yes' radio button
        yes.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        //sets label text to 'yes'
                       isVet.setText("yes");
                    }
                    });
        //adds action listener to 'no' radio button
        no.addItemListener(new ItemListener() {
                    @Override
                    //sets label text to 'no'
                    public void itemStateChanged(ItemEvent e) {
                         isVet.setText("no");
                    }
                    });
         //group the radio buttons       
        ButtonGroup vetButtons = new ButtonGroup();
        vetButtons.add(yes);
        vetButtons.add(no);
        
        //add action listener to calculate button
        Calc.addActionListener( 
                new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //gathers data toi be sent to ticketCalc class
                ticketCalc calc = new ticketCalc();
                int setTickets = Integer.parseInt(numTickets.getText());
                int setAge = Integer.parseInt(age.getText());
                String veteran = isVet.getText();
               //sends data to ticketCalc and returns result... prints on label
                totalPrice.setText(String.valueOf(calc.ticketCalc(setTickets, setAge, veteran)));
            }
                }
        );
        
        //add components from top to bottom
        Frame.add(top);
        Frame.add(row2);
        Frame.add(row3);
        Frame.add(bottom);
        //make frame visible
        Frame.setVisible(true);
        //set close operation
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}