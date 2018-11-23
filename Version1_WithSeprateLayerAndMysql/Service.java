package working.horrorisnotnecessary;

public class Service {
	
	private BankDatabase bankDatabase; // account information database

	public Service() throws Exception {
		// TODO Auto-generated constructor stub
		
			bankDatabase = new BankDatabase();
		
	}

	public int authenticateUser(Account c) {
		// TODO Auto-generated method stub
		int ret = bankDatabase.authenticateUser(c);
		//ret will be zero if database problems
		//ret will be 1 if accountnumber does not match
		//ret will be 2 if everything is ok.
		
		return ret;
	}
	
	
	    

	public boolean updateLayer(Account c) {
		// TODO Auto-generated method stub
		boolean x =bankDatabase.updateDb(c);
		
		return x;
	}

	public boolean updatePin(Account c) {
		// TODO Auto-generated method stub
		boolean y =bankDatabase.updatePin(c);
		return y;
	}

    
	
}
