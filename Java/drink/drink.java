import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

/**
 * This creates the drink application.
 *
 * @author Evan Vicidomini
 * @version May 23, 2019
 * Last Updated: August 11, 2024
 */
public class drink extends JFrame
{   
    //Define the private variables for the program.
    private String usCur; //String value of the user currency.
    private double userCurrency; //The actual value of the user currency.
    private double totalCost; //The total cost of all drinks selected.
    private int drinkCount = 0; //The amount of drinks bought
    private JCheckBox[] cb1 = new JCheckBox[5]; //Check boxes for sodas.
    private JCheckBox[] cb2 = new JCheckBox[5]; //Check boxes for other drinks.
    private Color c1 = new Color(182, 199, 236); //Very Light Blue
    private Color c2 = new Color(63, 86, 122); //Very Dark Blue
    
    public static void main(String[] args)
    {
        new drink();
    }
    
    /**
     * This is the main constructor for the drink program. Creates the main frame.
     */
    public drink()
    {
        //Creates the intro JOptionPane windows. Gets the amount of money the user is willing to spend.
        moneyInput();
        
        //Creates frame 1, or the main frame for the program.
        JFrame f1 = new JFrame();
        f1.setSize(1150, 650);
        f1.setTitle("Drink Store");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(new GridLayout(3, 0));

        //Creates panel 1, or the title panel of the frame.
        JPanel p1 = new JPanel();
        p1.setSize(40, 40);
        p1.setBackground(c1);
        
        //Creates label 1, or the title text.
        JLabel l1 = new JLabel("Please select a drink to purchase.");
        l1.setFont(new Font("Arial",Font.BOLD, 40));
        l1.setForeground(c2);
        
        //Create button 1, or the confirm button when selecting drinks.
        JButton b1 = new JButton("OK");
        b1.setForeground(Color.GREEN);
        b1.addActionListener(new confirmation());
        
        //Creates button 2, or the exit button for the program.
        JButton b2 = new JButton("Exit");
        b2.setForeground(Color.GREEN);
        b2.addActionListener(new exit());
        
        //Creates button 3, or the help button for instructions.
        JButton b3 = new JButton("Help");
        b3.setForeground(Color.GREEN);
        b3.addActionListener(new help());
        
        //Creates label 2, or the small text with simple instructions.
        JLabel l2 = new JLabel("Click OK to confirm purchases. Select the drinks with the checkboxes.");
        l2.setFont(new Font("Arial", Font.ITALIC, 20));
        l2.setForeground(c2);
        
        //Creates label uc, or the label that displays the starting currency.
        JLabel uc = new JLabel("Starting Money: $" + userCurrency);
        uc.setFont(new Font("Arial", Font.BOLD, 10));
        uc.setForeground(Color.RED);
        
        //Adds the items to the title panel.
        p1.add(l1);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(l2);
        p1.add(uc);
        
        //Adds the first panel to the frame.
        f1.add(p1);
      
        //Creates panel 2, or the section containing the sodas.
        JPanel p2 = new JPanel();
        p2.setBackground(c1);
        
        //Creates label 3, or the title text for the sodas section. 
        JLabel l3 = new JLabel("Sodas: $1.05");
        l3.setFont(new Font("Arial",Font.BOLD, 25));
        l3.setForeground(c2);
        
        //Creates all 5 soda names, checkboxes, and images.
        JLabel pic1 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/Coke.png"));
        cb1[0] = new JCheckBox("Coca Cola");
        JLabel pic2 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/Pepsi.jpg"));
        cb1[1] = new JCheckBox("Pepsi Cola");
        JLabel pic3 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/MountainDew.png"));
        cb1[2] = new JCheckBox("Mountain Dew");
        JLabel pic4 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/DrPepper.png"));
        cb1[3] = new JCheckBox("Dr. Pepper");
        JLabel pic5 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/RootBeer.png"));
        cb1[4] = new JCheckBox("Barq's Root Beer");
        
        //Adds the items to panel 2.
        p2.add(l3);
        p2.add(pic1);
        p2.add(cb1[0]);
        p2.add(pic2);
        p2.add(cb1[1]);
        p2.add(pic3);
        p2.add(cb1[2]);
        p2.add(pic4);
        p2.add(cb1[3]);
        p2.add(pic5);
        p2.add(cb1[4]);
        
        //Adds panel 2 to the frame.
        f1.add(p2);
        
        //Creates panel 3, or the section displaying the other drinks.
        JPanel p3 = new JPanel();
        p3.setBackground(c1);
        
        //Creates label 4, or the title text for the other drinks.
        JLabel l4 = new JLabel("Other Drinks: $1");
        l4.setFont(new Font("Arial",Font.BOLD, 20));
        l4.setForeground(c2);
        
        //Creates all 5 drink names, checkboxes, and images.
        JLabel pic6 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/Gatorade.jpeg"));
        cb2[0] = new JCheckBox("Gatorade");
        JLabel pic7 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/Lemonade.jpg"));
        cb2[1] = new JCheckBox("Lemonade");
        JLabel pic8 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/Water.jpg"));
        cb2[2] = new JCheckBox("Water");
        JLabel pic9 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/FruitPunch.jpg"));
        cb2[3] = new JCheckBox("Fruit Punch");
        JLabel pic10 = new JLabel(new ImageIcon("Java/Drink/DrinkImages/IceTea.png"));
        cb2[4] = new JCheckBox("Ice Tea");
        
        //Adds the items to panel 3.
        p3.add(l4);
        p3.add(pic6);
        p3.add(cb2[0]);
        p3.add(pic7);
        p3.add(cb2[1]);
        p3.add(pic8);
        p3.add(cb2[2]);
        p3.add(pic9);
        p3.add(cb2[3]);
        p3.add(pic10);
        p3.add(cb2[4]);
        
        //Adds panel 3 to the frame.
        f1.add(p3);
        
        //Makes the main frame visible after everything is added.
        f1.setVisible(true);
    }

    /**
     * This asks the user to type a number greater than 0 to buy drinks. The value must also not be a string.
     */
    public void moneyInput() {
        while(userCurrency <= 0){
            try {
                usCur = JOptionPane.showInputDialog(null, "Type the amount of money you have.");
                userCurrency = Double.parseDouble(usCur);
                if (userCurrency <= 0) {
                    JOptionPane.showMessageDialog(null, "You must type a number greater than 0.");
                } else {
                    JOptionPane.showMessageDialog(null, "Your total cash is $" + userCurrency + ". You will only be able to buy drinks until the cash runs out.");
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "You must type a number greater than 0.");
            }
        }
    }
    
    public class exit implements ActionListener
    {
        /**
         * This confirms if the user wants to exit the program.
         * 
         * @param e The action event used for the button.
         */
        public void actionPerformed(ActionEvent e)
        {
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Pane",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if(input == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null,"Total drinks bought: " + drinkCount);
                System.exit(0);
            }
        }
    }
    
    public class confirmation implements ActionListener
    {
        /**
         * This confirms the drinks bought by the user and subtracts the money.
         * 
         * @param e  The action event used for the button.
         */
        public void actionPerformed(ActionEvent e)
        {
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            for(int i = 0; i < cb1.length; i++) {
                if(cb1[i].isSelected()) {
                    totalCost += 1.05;
                    drinkCount += 1;
                }
            }
            
            for(int i = 0; i < cb2.length; i++) {
                if(cb2[i].isSelected()) {
                    totalCost += 1.00;
                    drinkCount += 1;
                }
            }
            
            JOptionPane.showMessageDialog(null, "Total: " + df.format(totalCost), "Confirmation", JOptionPane.OK_OPTION);
            userCurrency -= totalCost;
            JOptionPane.showMessageDialog(null,"Money left: " + userCurrency);
            
            if(userCurrency == 0) {
                JOptionPane.showMessageDialog(null,"You have no more money. Thanks for shopping.");
                JOptionPane.showMessageDialog(null,"Total drinks bought: " + drinkCount);
                System.exit(0);
            }
            else if(userCurrency < 0) {
                JOptionPane.showMessageDialog(null,"You have insufficient funds. Thanks for shopping.");
                drinkCount -= 1;
                JOptionPane.showMessageDialog(null,"Total drinks bought: " + drinkCount);
                System.exit(0);
            }
            
            totalCost = 0;
        }
    }  
    
    public class help implements ActionListener
    {
        /**
         * This displays more information to the user.
         * 
         * @param e  The action event used for the button.
         */
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "Click on a checkbox to select a drink. To buy one, click OK. You can buy drinks until you have no more money.");
        }
    }
}
