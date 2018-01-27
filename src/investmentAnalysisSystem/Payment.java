package investmentAnalysisSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {

	private double paymentAmount = 0;
	private final String paymentTransaction;
	
	public final int paymentID;
	private static int numberOfPayments = 0;  
	
	public Payment(){
		paymentID = ++numberOfPayments;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String transaction =dateFormat.format(date) + paymentID;
		transaction = transaction.replaceAll("\\s+","");
		transaction = transaction.replaceAll("\\/","");
		transaction = transaction.replaceAll("\\:","");
		paymentTransaction = transaction;
	}
	
	public double getPaymentAmount() {
		return paymentAmount;
	}
	
	public void setPaymentAmount(double price) {
		paymentAmount = price;
	}
	
	public String getPaymentTransaction(){
		return paymentTransaction;
	}
	
}
