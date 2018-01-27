package investmentAnalysisSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvestmentManagementSystem {

	private ArrayList<Bond> bonds;
	private ArrayList<Payment> payments;

	
	
	public InvestmentManagementSystem(){
		bonds = new ArrayList<Bond>();
		payments = new ArrayList<Payment>();
		//setPayments();
		
	}
	
	public void addBond(Bond bond){
		bonds.add(bond);
	}
	
	public boolean removeBond(Bond b){
		for( Bond bond : bonds){
			if(bond.equals(b)){
				bonds.remove(b);
				return true;
			}
		}
		return false;
	}
	
	public void getPayments(){
		
		for(Bond bond : bonds){
			
			for (int i = 1; i <= bond.getTerm() - 1; i++) {
				
				Payment payment = new Payment();
				payment.setPaymentAmount(bond.getCoupon());
				payments.add(payment);
				
				}
			
			Payment payment = new Payment();
			payment.setPaymentAmount(bond.getPrice() + (bond.getCoupon()));
			payments.add(payment);
			
			System.out.println("The payments for the bond => " + bond + " are as follows:");
			for (Payment p : payments) {
				System.out.print("The payment amount is: " + p.getPaymentAmount() + " | The transaction number is: " + p.getPaymentTransaction() + "\n");
			}
		}
		
		
	}
	
	
	public void getPayouts(){
		
		for(Bond bond : bonds){
			
			double totalPayout = 0.0;
			
			for (int i = 1; i <= bond.getTerm(); i++) {
				totalPayout += bond.getCoupon();
				
			}
			
			totalPayout += 100;
			
			System.out.println("The total payout is for the bond : " + bond + " is : " + totalPayout);
			
		}
				
	}
	
	
	
	public void getValues(double inflationRate){
		
		for(Bond bond : bonds){
			
			double totalValue = 0;
			for(int i = 1; i <= bond.getTerm() - 1; i++){
				totalValue += computeDiscount(i, inflationRate, bond);
			}
			totalValue += computeDiscount(bond.getTerm(), inflationRate, bond);
			
			System.out.println("The value for the bond: " + bond + " is:" + (double)Math.round(totalValue*1000)/1000);
			
		}
		
		
		
	}
	
	
	private double helperValues(Bond bond,double inflationRate){
		double totalValue = 0;
		for(int i = 1; i <= bond.getTerm() - 1; i++){
			totalValue += computeDiscount(i, inflationRate, bond);
		}
		totalValue += computeDiscount(bond.getTerm(), inflationRate, bond);
		
		return (double)Math.round(totalValue*1000)/1000 ;
		
	}
	
	public double computeDiscount(int yearOfPayment,double inflationRate, Bond bond){
		
		if(yearOfPayment == bond.getTerm()) return (bond.getCoupon() + 100) / Math.pow(( 1 + inflationRate ), bond.getTerm());
		
		else return (bond.getCoupon()) / Math.pow(( 1 + inflationRate ), yearOfPayment);
		
	}
	
	public void getMacaulayDuration(double inflationRate){
		
		for(Bond bond : bonds){
			double macaulayDuration = 0;
			double dividend = 0;
			double helper = 0;
			
			for(int i = 1; i <= bond.getTerm(); i++){
				helper += (i * bond.getCoupon()) / Math.pow((1 + inflationRate), i);
			}
			
			dividend = helper + bond.getTerm() * 100 / Math.pow(1 + inflationRate, bond.getTerm());
			
			double totalValue = 0;
			for(int i = 1; i <= bond.getTerm() - 1; i++){
				totalValue += computeDiscount(i, inflationRate, bond);
			}
			totalValue += computeDiscount(bond.getTerm(), inflationRate, bond);
			
			macaulayDuration =  dividend / totalValue;
			
			System.out.println("The Macaulay Duration for the bond: " + bond + " is: " +(double)Math.round(macaulayDuration*1000)/1000);
		}
		
		
	}
	
	public void getInternalRate(){
		
		for(Bond bond: bonds){
			
			double irr = 0;
			double upperBound = 1;
			double lowerBound = 0;
			
			while((double)Math.round(helperValues(bond,irr)*10)/10 != bond.getPrice()){
				irr = (upperBound + lowerBound) / 2;
				if((double)Math.round(helperValues(bond,irr)*100)/100 > bond.getPrice() ) lowerBound = irr;
				else upperBound = irr;	
			}
			
			System.out.println("The Internal Rate of Return of the bond " + bond + " is: " + (double)Math.round(irr*10000)/10000);
					
		}
		
	}
	
	
}
