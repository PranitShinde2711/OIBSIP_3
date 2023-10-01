import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


class LoginSystem
{
    public Map<String,String> userDatabase;
    public LoginSystem()
    {
        userDatabase=new HashMap<>();
        userDatabase.put("user1","12345");
        userDatabase.put("user2","54321");
        userDatabase.put("user3","23415");
        userDatabase.put("user4","54123");
    }

    public boolean AuthenticateUser(String loginId,String Password)
    {
        if(userDatabase.containsKey(loginId))
        {
            String StoredPasswordHash =userDatabase.get(loginId);
            String EnteredPasswordHash =hashPassword(Password);
            return StoredPasswordHash.equals(EnteredPasswordHash);

        }
        return false;
    }

    private String hashPassword(String Password)
    {
        return Password;
    }
}


class checkBalance
{
   
    static double bal=AtmInterface.updatedbalance;
    

    public checkBalance(double initialBalance)
    {
         this.bal = initialBalance;
    }
    public void checkBalance() 
    {
        System.out.println("Your balance is: $" + bal);
    }
}

class DepositMoney
{
   double BaLance=AtmInterface.balance;
    
    public void deposit(double amount) {
         if (amount > 0) {
            BaLance+=amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

class WithdrawMoney
{
    double BALANCE=AtmInterface.balance;
     public void withdraw(double amount) {
        if (amount > 0 && amount <= BALANCE) {
            BALANCE -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

}

public class AtmInterface{

   
    static double balance=1000;
    static double updatedbalance=balance;
    
    
    

   
    public static void main(String[] args) 
    {
            
            System.out.println("******************Welcome to ATM******************* !");
            String loginid,password;  
            
            
            LoginSystem login=new LoginSystem();
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your login id: ");
            loginid=sc.nextLine();
            System.out.println("Enter your password:");
            password=sc.nextLine();
            if(login.AuthenticateUser(loginid,password))
                System.out.println("login Successful!!!");
            else
                System.out.println("Login failed");
            System.out.println("------------------------------------------");

           
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit\n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    checkBalance Balance=new checkBalance(updatedbalance);
                    Balance.checkBalance();
                    break;
                case 2:
                
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    DepositMoney depo=new DepositMoney();
                    depo.deposit(depositAmount);
                    updatedbalance+=depositAmount;
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: $");
                    WithdrawMoney Withdraw=new WithdrawMoney();
                    double withdrawalAmount = scanner.nextDouble();
                    Withdraw.withdraw(withdrawalAmount);
                    updatedbalance-=withdrawalAmount;
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
       
    }
}
