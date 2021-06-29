package it.polito.tdp.genes.model;

public class GenesWeight implements Comparable<GenesWeight> {
	
	Genes gene;
	Double peso;
	
	public GenesWeight(Genes gene, Double peso) {
		super();
		this.gene = gene;
		this.peso = peso;
	}

	public Genes getGene() {
		return gene;
	}

	public void setGene(Genes gene) {
		this.gene = gene;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return gene + "    " + peso;
	}

	@Override
	public int compareTo(GenesWeight other) {
		return -this.getPeso().compareTo(other.getPeso());
	}
	
	
	
	
	

}
