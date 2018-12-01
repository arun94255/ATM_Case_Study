package working.horrorisnotnecessary;

import java.util.List;
import java.util.ResourceBundle;
// BankDatabase.java
// Represents the bank account information database 

public class BankDatabase
{
   
   private AccountInfo x;
   
   // no-argument BankDatabase constructor initializes accounts
   public BankDatabase() throws Exception
   {
	   /*x =new MapBasedAccount();  //bad idea becuase this is coding. coding always leads
	   //recompilation , recompilation is expensive
*/	   
	   
	  ResourceBundle r = ResourceBundle.getBundle("hello");  //configuration, does not lead
	  //to recompilation, hence advantageous although code looks big.
	  
	  String cn = r.getString("cn");
	  System.out.println(cn);
	  //tell the mirror which classname object you want
	  
	try {
		Class c= Class.forName(cn);
		  Object o = c.newInstance();
		  
		  x = (AccountInfo) o;
	} catch (Exception e) //very bad but some times good.
	{
		// secretly dying, in any project if we have to die, we should
		//die screaming
		throw e;
		
	}
	  
	  
	  
	   
	   
	//  x= new MapBasedAccount();
      
   } // end no-argument BankDatabase constructor
   
 

   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public int authenticateUser( Account c )
   {
      // attempt to retrieve the account with the account number
      int status  = x.getAccount( c );

      return status;
   } // end method authenticateUser

   

public boolean updateDb(Account c) {
	// TODO Auto-generated method stub
	
	boolean status = x.updateAccount(c);
	
	return status;
}



public boolean updatePin(Account c) {
	boolean status = x.updatePin(c);
	return status;
}



public List<Trance> miniSmt(String string, String string1, Account c) {
	List<Trance> lt = x.miniSmt(string,string1,c);
	return lt;
}



} // end class BankDatabase
