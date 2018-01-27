package investmentAnalysisSystem;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args){
		
		InvestmentManagementSystem bs = new InvestmentManagementSystem();
		
		
		Bond b1 = new Bond(5,5,1,"UK Government",103);
		Bond b2 = new Bond(10, 4,1, "US Treasuries",95);
		Bond b3 = new Bond(20,3, 1,"JGBs",92);
		Bond b4 = new Bond(15,2,1,"OATs",120);
		
		Investor investor1 = new Investor("Kevin Nejad","+44(0)7654140143");
		investor1.investSum(5000);
	
		
		investor1.purchase(b1);
		
		bs.addBond(b1);
		
		bs.getPayments();
		bs.getPayouts();
		bs.getValues(0.05);
		bs.getValues(0.02);
		bs.getMacaulayDuration(0.05);
		bs.getMacaulayDuration(0.02);
		bs.getInternalRate();
		
		
	}
	
	
	
}
