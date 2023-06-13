
package mypack;

public class Salary {
	private double basic;
	private double da; // 10% of basic
	private double pf; // 5% of basic
	private double gross; // b+da+pf
	private double net; // gross - pf
	
	public Salary(double basic) {
		// TODO Auto-generated constructor stub
		this.basic = basic;
		this.da = basic * (0.10); 
		this.pf = basic * (0.05); 
		this.gross = basic + da + pf;
		this.net = this.gross - this.pf;
	}
	public double getBasic() {
		return basic;
	}

//	public void setBasic(double basic) {
//		this.basic = basic;
//	}

	public double getDa() {
		return da;
	}

	

	public double getPf() {
		return pf;
	}


	public double getGross() {
		return gross;
	}

	
	public double getNet() {
		return net;
	}
	@Override
	public String toString() {
		return "Salary [basic=" + basic + ", da=" + da + ", pf=" + pf + ", gross=" + gross + ", net=" + net + "]";
	}

	
}
