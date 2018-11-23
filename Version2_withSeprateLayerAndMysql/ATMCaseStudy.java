package working.horrorisnotnecessary;
// ATMCaseStudy.java
// Driver program for the ATM case study

public class ATMCaseStudy
{
   // main method creates and runs the ATM
   public static void main( String[] args )
   {
      try {
		ATM theATM = new ATM();    
		theATM.run();
	} catch (Exception e) {
		System.out.println("system too busy try after sometime");
		e.printStackTrace();
	}
   } // end main
} // end class ATMCaseStudy 

