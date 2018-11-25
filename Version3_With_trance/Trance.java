package working.horrorisnotnecessary;

public class Trance {
int accno;
int balance;
String accTypeString;
String date;
public Trance(int accno, int balance, String accTypeString, String date) {
	this.accno = accno;
	this.balance = balance;
	this.accTypeString = accTypeString;
	this.date = date;
}
public int getAccno() {
	return accno;
}
public int getBalance() {
	return balance;
}
public String getAccTypeString() {
	return accTypeString;
}
public String getDate() {
	return date;
}

}
