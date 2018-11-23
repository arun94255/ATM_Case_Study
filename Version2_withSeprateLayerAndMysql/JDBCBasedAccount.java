package working.horrorisnotnecessary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class ForMysql{		
	Statement smt;
	Connection con;	
	public void MakeConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");		
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmcasestudy?characterEncoding=latin1","root","cdacacts");
	//System.out.println("connected to data base for prepared statement");
		this.smt = con.createStatement();
		
	}
	public Account select(int accountNumber) throws SQLException {
		Account account = null;
		String q1 = "select * from accinfo where AccountNO=?";		
		PreparedStatement psmt = con.prepareStatement(q1);
		psmt.setInt(1, accountNumber);		
		    ResultSet rs =psmt.executeQuery();		
		
		while(rs.next())
		{
			//System.out.println(rs.getInt(1) +"  "+ rs.getString(2));
			if (rs.getInt(1) ==accountNumber) {
				account=new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
		}
		return account;
	}
	
	public void UpdateDb(int accountNumber,int balance) throws SQLException {
		Account account = null;
		String q1 = "UPDATE accinfo SET balance=? where AccountNO=?";		
		PreparedStatement psmt = con.prepareStatement(q1);
		psmt.setInt(1, balance);
		psmt.setInt(2, accountNumber);		
		 int no=   psmt.executeUpdate();	 	
	}
    public void closeDb() throws SQLException {
		con.close();
	}
	public void UpdatePin(int accountNumber, int pin) throws SQLException {
		String q1 = "UPDATE accinfo SET pin=? where AccountNO=?";		
		PreparedStatement psmt = con.prepareStatement(q1);
		psmt.setInt(1, pin);
		psmt.setInt(2, accountNumber);		
		 int no=   psmt.executeUpdate();	 	
		
	}
}
public class JDBCBasedAccount implements AccountInfo {
	
	@Override
	public int getAccount(Account c) {
		ForMysql fm=new ForMysql();
		Account x=null;
		try {
			fm.MakeConnection();
			 x = fm.select(c.getAccountNumber());
			 fm.closeDb();
			
		} catch (ClassNotFoundException e) {
			
			return 1;
		} catch (SQLException e) {
			
			return 1;
		}
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
		ForMysql fm=new ForMysql();
		Account x=null;
		try {
			fm.MakeConnection();
			 fm.UpdateDb(c.getAccountNumber(),(int) c.getTotalBalance());
			 x = fm.select(c.getAccountNumber());
			 fm.closeDb();
			
		} catch (ClassNotFoundException e) {
			
			return false;
		} catch (SQLException e) {
			
			return false;
		}
		//x.setTotalBalance(c.getTotalBalance());
		return true; //everything is ok
	}

	@Override
	public boolean updatePin(Account c) {
		ForMysql fm=new ForMysql();
		Account x=null;
		try {
			 fm.MakeConnection();
			 fm.UpdatePin(c.getAccountNumber(),(int) c.getPin());
			// x = fm.select(c.getAccountNumber());
			 fm.closeDb();
			
		} catch (ClassNotFoundException e) {
			
			return false;
		} catch (SQLException e) {
			
			return false;
		}
		//x.setTotalBalance(c.getTotalBalance());
		return true; //everything is ok
		
	}
}
