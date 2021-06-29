package it.polito.tdp.genes.model;

public class Interaction {
	
	String g1;
	String g2;
	double corr;
	
	public Interaction(String g1, String g2, double corr) {
		super();
		this.g1 = g1;
		this.g2 = g2;
		this.corr = corr;
	}
	public String getG1() {
		return g1;
	}
	public void setG1(String g1) {
		this.g1 = g1;
	}
	public String getG2() {
		return g2;
	}
	public void setG2(String g2) {
		this.g2 = g2;
	}
	public double getCorr() {
		return corr;
	}
	public void setCorr(double corr) {
		this.corr = corr;
	}
	
	

}
