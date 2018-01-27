package investmentAnalysisSystem;

import java.util.Date;

public class Bond {

	private final int term; // number of years to expire
	private final double coupon; // percentage of investment 
	private final int frequency; // frequency of payment per year
	private final String name; // name of bond 
	private final double price; // price of bond
	
	private Date date;
	
	public final int id;
	private static int numberOfBonds = 0;  

	// Based on the test file, we assume the coupon value is not in percentage and its the actual value 
	
	Bond(int term, double coupon, int frequency, String name, double price){
		this.term = term;
		this.coupon = coupon;
		this.frequency = frequency;
		this.name = name;
		this.price = price;
		id = ++numberOfBonds;
	}
	
	public int getTerm(){
		return term;
	}
	
	public double getCoupon(){
		return coupon;
	}
	
	public int getFrequency(){
		return frequency;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getID(){
		return id;
	}
	
	public String toString(){
		return "Name: " + name + " | Term: " + term + " | Coupon: " + coupon +
				" | Price: " + price + " | Frequency: " + frequency + " | Purchase date : " + date ;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public Date getDate(){
		return date;
	}
	
}
