package investmentAnalysisSystem;
import java.util.ArrayList;

public class Portfolio {
	
	ArrayList<Bond> bonds;
	Investor investor;
	
	public Portfolio(Investor investor){
		this.investor = investor;
		bonds = new ArrayList<Bond>();
	}
	
	void addBondToPorfolio(Bond bond){
		bonds.add(bond);
	}
	
	ArrayList<Bond> getBonds(){
		return bonds;
	}
	
	
}
