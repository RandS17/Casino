import java.util.Scanner;
import java.util.Random;

public class Casino {
    public static void main(String[] args)
    {
        System.out.println("LET'S GO GAMBLING!!!");
        
        Scanner in = new Scanner(System.in);
        
        Gambler player = new Gambler();
        
        String choice = "";
        
        while (!choice.equals("I am a quitter"))
        {
            System.out.println("Choose an activity: ");
            System.out.println("(1) Play the Epic Slot Machine - $10");
            System.out.println("(2) Play THE SUPER MONEY WASTER 3000 - $55");
            
            if (player.accountExists)
            { System.out.println("(0) View account"); }
            else
            { 
                System.out.println("(0) Create account");
                System.out.println("(9) View balance");
            }
            
            System.out.println("(\"I am a quitter\") Quit");
            choice = in.nextLine();
            
            if (choice.equals("1"))
            { player.epicSlotMachine(); }
            else if (choice.equals("2"))
            { player.superMoneyWaster(); }
            else if (choice.equals("0"))
            { 
                if (player.accountExists)
                { player.viewAccount(); }
                else
                { player.createAccount(); }
            }
            else if (choice.equals("9"))
            { System.out.println("Your current balance is $" + player.getBalance() + "0."); }
            else if (choice.equals("viewstats"))
            { player.viewStats(); }
        }
    }
}
