package working.horrorisnotnecessary;

public interface AccountInfo {	
	
	int getAccount(Account c); // if we get null, account number is not found

	boolean updateAccount(Account c);

	boolean updatePin(Account c);	
}
