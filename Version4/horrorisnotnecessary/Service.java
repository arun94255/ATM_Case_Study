package working.horrorisnotnecessary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

	public List<Trance> miniSmt(String string, String string1, Account c) {
		 List<Trance> lTrances=bankDatabase.miniSmt(string,string1,c);
		return lTrances;
	}

	public String dateValidation(int date, int month, int year, int date1,
			int month1, int year1) {
		String res=null;
		if(year>year1){
			res="Starting Year Should be less as compare to ending year ";
		}
		else if (year==year1 && month>month1) {
			res="Starting month Should be less as compare to ending month ";
		}
		else if (year==year1 && month==month1 && date>date) {
			res="Starting date Should be less as compare to ending date ";
		}else{
			res="ok";
		}
		
		return res;
	}

	
    
	
}
