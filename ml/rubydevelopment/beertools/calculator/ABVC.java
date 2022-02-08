package ml.rubydevelopment.beertools.calculator;

public class ABVC {

	public double calculateABV(double og, double fg) {
		
		double ABV = (og-fg)*131.25;
		
		return ABV;
	}
	
}
