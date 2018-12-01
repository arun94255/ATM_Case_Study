package working.horrorisnotnecessary;

import java.util.List;

public interface AccountInfo {	
	
	int getAccount(Account c); // if we get null, account number is not found

	boolean updateAccount(Account c);

	boolean updatePin(Account c);

	List<Trance> miniSmt(String string, String string1, Account c);	
}
