package working.horrorisnotnecessary;

import java.util.HashMap;
import java.util.Map;

public class MapBasedAccount implements AccountInfo {
	
	private Map<Integer, Account> m;
	
	
	

	public MapBasedAccount() {
		// TODO Auto-generated constructor stub
		m = new HashMap<>();
		Account c = new Account( 12345, 13, 1000.0 );
		m.put(c.getAccountNumber(), c);
		c = new Account( 98765, 31, 200.0 );
		m.put(c.getAccountNumber(), c);
		
		
		
		
		
		
	}




	@Override
	public int  getAccount(Account c) {
		// TODO Auto-generated method stub
		Account x = m.get(c.getAccountNumber());  // theory tells you that if accountnumber is not
		//found return will be null.
		if( x != null)
		{		
				if(x.validatePIN(c.getPin()))
				{
					
					c.setTotalBalance(x.getTotalBalance());
					return 2; //everything is ok
					
				}
			
		}
		
		return 1; // pin was wrong
		
	}




	@Override
	public boolean updateAccount(Account c) {
		// TODO Auto-generated method stub
		Account x = m.get(c.getAccountNumber());  // theory tells you that if accountnumber is not
		//found return will be null.
		x.setTotalBalance(c.getTotalBalance());
		return true; //everything is ok
					
			
			
		
		
		
		
	

		
	
		
		
		

	}
	
}


