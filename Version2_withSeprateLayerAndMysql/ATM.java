package working.horrorisnotnecessary;

import java.util.ResourceBundle;
// ATM.java
// Represents an automated teller machine

public class ATM 
{
   private ResourceBundle r;
   private int userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private Screen screen; // ATM's screen
   private Keypad keypad; // ATM's keypad
    private Service serviceObject;
      // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int CHANGE_PIN = 4;
   private static final int EXIT = 0;
   private Account c;

   // no-argument ATM constructor initializes instance variables
   public ATM() throws Exception 
   {
	   serviceObject=new Service();
	   r = ResourceBundle.getBundle("hello");
      currentAccountNumber = 0; // no current account number to start
      screen = new Screen(); // create screen
      keypad = new Keypad(); // create keypad 
          // create acct info database
   } // end no-argument ATM constructor

   // start ATM 
   public void run()
   {
      // welcome and authenticate user; perform transactions
      while ( true )
      {
         // only good thing about ATM case study it is working
    	  //everythign else is bad.
         while ( userAuthenticated != 2  ) 
         {
            screen.displayMessageLine( r.getString("greeting") );       
            authenticateUser(); // authenticate user
         } // end while
         
         performTransactions(); // user is now authenticated 
         userAuthenticated = 1; // reset before next ATM session
         currentAccountNumber = 0; // reset before next ATM session 
         screen.displayMessageLine( "\nThank you! Goodbye!" );
      } // end while   
   } // end method run

   // attempts to authenticate user against database
   private void authenticateUser() 
   {
      screen.displayMessage( "\nPlease enter your account number: " );
      int accountNumber = keypad.getInput(); // input account number
      screen.displayMessage( "\nEnter your PIN: " ); // prompt for PIN
      int pin = keypad.getInput(); // input PIN
      
      // set userAuthenticated to boolean value returned by database
       c =new Account(accountNumber,pin,0);
      
      
      userAuthenticated = 
         serviceObject.authenticateUser( c );
      
      // check whether authentication succeeded
      if ( userAuthenticated  ==2 )
      {
         currentAccountNumber = accountNumber; // save user's account #
      } // end if
      else
         screen.displayMessageLine( 
             "Invalid account number or PIN. Please try again." );
   } // end method authenticateUser

   // display the main menu and perform transactions
   private void performTransactions() 
   {
      // local variable to store transaction currently being processed
    
      
      boolean userExited = false; // user has not chosen to exit
      int mainMenuSelection=10;
      // loop while user has not chosen option to exit system
      while (true )
      {     
         // show main menu and get user selection
          mainMenuSelection = displayMainMenu();

         // decide how to proceed based on user's menu selection
         switch ( mainMenuSelection )
         {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY:
            			screen.displayMessage("balance is " + c.getTotalBalance());
            			break;            	
            	
            case WITHDRAWAL:
            		screen.displayMessage("enter amt to withdraw");
            		int withdrawal = keypad.getInput();
            		if(withdrawal > c.getTotalBalance())
            		{
            			screen.displayMessage("insufficient fundds");            			
            		}
            		else
            		{
            			 c.debit(withdrawal);
            			 boolean status = serviceObject.updateLayer(c);
            			 screen.displayMessage("withdrawal successful" ); //fm   			 
            		}
            		break;
            case DEPOSIT:
            	screen.displayMessage("enter amt to deposit");
        		withdrawal = keypad.getInput();
        		c.credit(withdrawal);
        		boolean status = serviceObject.updateLayer(c);
        		screen.displayMessage("deposit successful" ); //fm
        		break;
            case CHANGE_PIN:
            	screen.displayMessage("Enter New Pin");
            	int newPin = keypad.getInput();
            	c.setPin(newPin);
            	 status = serviceObject.updatePin(c);
            case EXIT: // user chose to terminate session
               screen.displayMessageLine( "\nExiting the system..." );
               userExited = true; // this ATM session should end
               break;
            default: // user did not enter an integer from 1-4
               screen.displayMessageLine( 
                  "\nYou did not enter a valid selection. Try again." );
               break;
         } // end switch
      } // end while
   } // end method performTransactions
   
   // display the main menu and return an input selection
   private int displayMainMenu()
   {
      screen.displayMessageLine( "\nMain menu:" );
      screen.displayMessageLine( "1 - View my balance" );
      screen.displayMessageLine( "2 - Withdraw cash" );
      screen.displayMessageLine( "3 - Deposit funds" );
      screen.displayMessageLine( "4 - Change Pin" );
      screen.displayMessageLine( "0 - Exit\n" );
      screen.displayMessage( "Enter a choice: " );
      return keypad.getInput(); // return user's selection
   } // end method displayMainMenu
         
   // return object of specified Transaction subclass
   } // end class ATM
