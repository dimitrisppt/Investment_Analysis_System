package investmentAnalysisSystem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Investor {

	private final String fullName; // Fullname of investor 
	private static int numberOfInvestors; // Number of investors
	private final int id; // unique ID for each investors
	private String contactNo;
	
	private double currentBalance; // amount of money in their account
	private Portfolio portfolio; //
	
	public Investor(String fullName, String contactNo){
		this.fullName = fullName;
		this.contactNo = contactNo;
		id = ++numberOfInvestors ;
		portfolio = new Portfolio(this);
	}
	
	
	public String getName(){
		return fullName;
	}
	
	public String getContactNo(){
		return contactNo;
	}
	
	public double getBalace(){
		return currentBalance;
	}
	
	public Portfolio getPortfolio(){
		return portfolio;
	}

	
	public int getID(){
		return id;
	}
	
	public int getTotalNumberOfInvestors(){
		return numberOfInvestors;
	}
	
	ArrayList<Bond> getBonds(){
		return portfolio.getBonds();
	}
	
	public void investSum(double sum){
		currentBalance += sum;
	}

	
	public void purchase(Bond bond){
		
		if(currentBalance >= bond.getPrice()){
			currentBalance -= bond.getPrice();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			bond.setDate(date);
			portfolio.addBondToPorfolio(bond);
			System.out.println(fullName + " with the ID:" + id + " just purchased the bond with the ID: "
					+ bond.getID() + " at: " + bond.getDate());
			
			System.out.println("The Current Balance: " + currentBalance);
		}
		else{
			System.out.println("Purchase failed because of insufficient fund");
		}
			
	}
	
	public String toString(){
		return "Fullname: " + fullName + " | Investor ID:" + id;
	}
	
}
