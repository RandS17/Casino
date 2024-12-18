import java.util.Scanner;
import java.util.Random;

/**
 * A class that has casino games and tracks account data.
 * @author Rand Smith
 */

public class Gambler {
    
    private String name;
    private double balance;
    public boolean accountExists;
    
    private static int slotMachinePulls;
    private static double moneySpent;
    private static double moneyEarned;
    
    Scanner in = new Scanner(System.in);
    
    /**
     * Constructor
     */
    public Gambler()
    {
        balance = 0.0;
        slotMachinePulls = 0;
        moneySpent = 0.0;
        moneyEarned = 0.0;
    }
    
    /**
     * Creates data for an account.
     * @param name the user's name
     * @param balance the amount of money the user has
     */
    public void create(String name, double balance)
    {
        this.name = name;
        balance = ((int) (balance*100)) / 100.0;
        this.balance = balance;
        accountExists = true;
    }
    
    /**
    * Returns the user's name.
    * @return the name, as a String
    */
    public String getName()
    { return name; }
    
    /**
    * Returns the user's balance.
    * @return the balance, as a double
    */
    public double getBalance()
    { return balance; }
    
    /**
     * Determines if the name is a valid name.
     * @param name the user's name, beginning with a capital letter
     * @return true only if the starts with a capital letter and has no special characters besides spaces
     */
    public static boolean validateName(String name)
    {
        if (name.length() <= 1)
        { return false; }
        
        for (int i = 0; i < name.length(); i++)
        {
            char ch = name.charAt(i);
            
            if (!(Character.isLetterOrDigit(ch)) && !(Character.isSpaceChar(ch)))
            { return false; }
            
            if (i == 0 && !(Character.isUpperCase(ch)))
            { return false; }
        }
        
        return true;
    }
    
    /**
     * Adds to the user's balance.
     * @param prize the amount added
     */
    public void add(double prize)
    {
        balance += prize;
        moneyEarned += prize;
    }
    
    /**
     * Subtracts from the user's balance.
     * @param cost the amount subtracted
     */
    public void subtract(double cost)
    {
        balance -= cost;
        moneySpent += cost;
    }
    
    /**
     * Edits the data of an account.
     * @param newName the updated name
     * @param newBalance the updated balance
     */
    public void editAccount(String newName, double newBalance)
    {
        this.name = newName;
        newBalance = ((int) (newBalance*100)) / 100.0;
        this.balance = balance;
    }
    
    /**
     * Creates a new user account.
     */
    public void createAccount()
    {
        Scanner in = new Scanner(System.in);
        
        
        System.out.println("Enter your name:");
        String name = in.nextLine();
        while (!Gambler.validateName(name))
        {
            System.out.println("Name does not match format. Name must have at least 2 characters, start with a capital letter, and use no special symbols.");
            name = in.nextLine();
        }
        
        System.out.println("Enter your balance:");
        double balance = in.nextDouble();
        while (balance <= 0.0)
        {
            System.out.println("broke ass loser. you have more money than that");
            balance = in.nextDouble();
        }
        
        create(name, balance);
    }
    
    /**
     * Displays the player's account info.
     */
    public void viewAccount()
    {
        if (accountExists)
        { System.out.println(toString()); }
        else
        { System.out.println("You don't have an account!"); }
    }
    
    /**
     * Rolls a slot machine, with a chance of winning a prize.
     */
    public void epicSlotMachine()
    {
        System.out.println("Playing the Epic Slot Machine!");
        balance -= 10.0;
        slotMachinePulls++;
        moneySpent += 10.0;
        
        Random slot = new Random();
        
        String slotFirst = "0";
        String slotSecond = "0";
        String slotThird = "0";
        
        int slotRandomizer = slot.nextInt(10);
        if (slotRandomizer == 1 || slotRandomizer == 2 || slotRandomizer == 3)
        { slotFirst = "A"; }
        else if (slotRandomizer == 4 || slotRandomizer == 5 || slotRandomizer == 6)
        { slotFirst = "B"; }
        else if (slotRandomizer == 7 || slotRandomizer == 8 || slotRandomizer == 9)
        { slotFirst = "C"; }
        else { slotFirst = "7"; }
        
        slotRandomizer = slot.nextInt(10);
        if (slotRandomizer == 1 || slotRandomizer == 2 || slotRandomizer == 3)
        { slotSecond = "A"; }
        else if (slotRandomizer == 4 || slotRandomizer == 5 || slotRandomizer == 6)
        { slotSecond = "B"; }
        else if (slotRandomizer == 7 || slotRandomizer == 8 || slotRandomizer == 9)
        { slotSecond = "C"; }
        else { slotSecond = "7"; }
        
        slotRandomizer = slot.nextInt(10);
        if (slotRandomizer == 1 || slotRandomizer == 2 || slotRandomizer == 3)
        { slotThird = "A"; }
        else if (slotRandomizer == 4 || slotRandomizer == 5 || slotRandomizer == 6)
        { slotThird = "B"; }
        else if (slotRandomizer == 7 || slotRandomizer == 8 || slotRandomizer == 9)
        { slotThird = "C"; }
        else { slotThird = "7"; }
        
        if ((slotFirst.equals("A") && slotSecond.equals("A") && slotThird.equals("A")) ||
            (slotFirst.equals("B") && slotSecond.equals("B") && slotThird.equals("B")) ||
            (slotFirst.equals("C") && slotSecond.equals("C") && slotThird.equals("C")))
        {
            System.out.println("          *************");
            System.out.println("          #############");
            System.out.println("          ##         ##");
            System.out.println("          ##  " + slotFirst + " " + slotSecond + " " + slotThird + "  ##   You got a match!");
            System.out.println("          ##         ##   +$50.00");
            System.out.println("          #############");
            System.out.println("          | S L O T $ |");
            System.out.println("          *************");
            
            balance += 50; 
            moneyEarned += 50; 
            
        }
        else if (slotFirst.equals("C") && slotSecond.equals("A") && slotThird.equals("7"))
        {
            System.out.println("          *************");
            System.out.println("          #############");
            System.out.println("          ##         ##");
            System.out.println("          ##  " + slotFirst + " " + slotSecond + " " + slotThird + "  ##   You got the Cat Bonus!");
            System.out.println("          ##         ##   +$300.00");
            System.out.println("          #############");
            System.out.println("          | S L O T $ |");
            System.out.println("          *************");
            
            balance += 300;
            moneyEarned += 300;
            
        }
        else if (slotFirst.equals("7") && slotSecond.equals("7") && slotThird.equals("7"))
        {
            System.out.println(" * * * *  *************  * * * * * * * * * * * * *");
            System.out.println("* * * * * ############# * * * * * * * * * * * * * ");
            System.out.println(" * * * *  ##         ##  * * * * * * * * * * * * *");
            System.out.println("* * * * * ##  " + slotFirst + " " + slotSecond + " " + slotThird + "  ## * YOU WON THE JACKPOT * * ");
            System.out.println(" * * * *  ##         ##  * * +$5000.00 * * * * * *");
            System.out.println("* * * * * ############# * * * * * * * * * * * * * ");
            System.out.println(" * * * *  | S L O T $ |  * * * * * * * * * * * * *");
            System.out.println("* * * * * ************* * * * * * * * * * * * * * ");
            
            balance += 5000;
            moneyEarned += 5000;
            
        }
        else
        {
            System.out.println("          *************");
            System.out.println("          #############");
            System.out.println("          ##         ##");
            System.out.println("          ##  " + slotFirst + " " + slotSecond + " " + slotThird + "  ##");
            System.out.println("          ##         ##");
            System.out.println("          #############");
            System.out.println("          | S L O T $ |");
            System.out.println("          *************");
        }
        
        System.out.println("Type Enter to play again. Anything else to quit.");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        if (choice.equals(""))
        { epicSlotMachine(); }
    }
    
    /**
     * Removes $55 from the player's account.
     */
    public void superMoneyWaster()
    {
        System.out.println("PREPARE TO BE AMAZED!!");
        System.out.println("GET READY FOR THE GREATEST MOMENT OF YOUR LIFE!!!");
        System.out.println();
        System.out.println("-$55.00\n( ͡º ꒳ ͡º)");
        System.out.println();
        subtract(55); 
        
        System.out.println("Type Enter to play again. Anything else to quit.");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        if (choice.equals(""))
        { superMoneyWaster(); }
    }
    
    /**
     * Displays some hidden data.
     */
    public void viewStats()
    {
        System.out.println("Slot machine pulls: " + slotMachinePulls);
        System.out.println("Money spent: " + moneySpent);
        System.out.println("Money earned: " + moneyEarned);
        System.out.println("Net: " + (moneyEarned - moneySpent));
    }
    
    /**
     * Converts an account to a String.
     * @return a String containing the player's name and balance
     */
    public String toString()
    {
        return name + "'s stats:\nCurrent balance: " + balance;
    }
}
