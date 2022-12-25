package ExceptionHandling;

import javax.swing.JOptionPane;

public class RPSGame
{
    public static void main(String args[])
    {
        int yourChoice=0, computerChoice; //choice of user and computer
        String yourInput;
        int yourScore=0, computerScore=0;

        // Welcome screen that shows the basic rules to the user
        JOptionPane.showMessageDialog(null,"Welcome to Rock, Paper, Scissors Game");
        JOptionPane.showMessageDialog(null,"Let me remind you the rules first:\nScissor cuts paper \nPaper covers rock \nRock breaks scissors ");

        do {
            try {
                JOptionPane.showMessageDialog(null,"Enter: \n0: Rock\n1: Paper\n2: Scissor\n3: Exit");

                // Get your choice
                yourInput = JOptionPane.showInputDialog("Now tell me your choice: ");
                yourChoice = Integer.parseInt(yourInput);

                if(yourChoice<0 || yourChoice>3)
                    throw new NumberFormatException("");
                //Get computer choice
                computerChoice = (int)(Math.random()*10); // Random number generator
                computerChoice %= 3;

                //Case I: Both you and computer pick the same choice, then it’s a tie!
                if (yourChoice == computerChoice){
                    JOptionPane.showMessageDialog(null,"It’s a TIE!");
                }

                //Case II: You WIN :)
                if((yourChoice==1 && computerChoice==0) ||(yourChoice==2 && computerChoice==1)||(yourChoice==0 && computerChoice==2)) {
                    JOptionPane.showMessageDialog(null,"You WIN!");
                    yourScore++;
                }

                //Case III: You lose :(
                if((yourChoice==0 && computerChoice==1) ||(yourChoice==1 && computerChoice==2)||(yourChoice==2 && computerChoice==0)) {
                    JOptionPane.showMessageDialog(null,"You LOSE!");
                    computerScore++;
                }
            }catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Invalid option! Please try again");
            }
        }while(yourChoice!=3);
        JOptionPane.showMessageDialog(null,"Your score: "+yourScore+"\n"+"Computer's score: "+computerScore);
    }
}