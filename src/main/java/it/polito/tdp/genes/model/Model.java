package it.polito.tdp.genes.model;

import java.util.*;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;

public class Model {
	
	GenesDao dao;
	TreeMap<String, Genes> genes;
	List<Interaction> interactions;
	
	SimpleWeightedGraph<Genes, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new GenesDao();
		genes = new TreeMap<String, Genes>();
		interactions = new ArrayList<Interaction>();
	}
	
	public void inizializza() {
		for(Genes g: dao.getAllGenes()) {
			genes.put(g.getGeneId(), g);
		}
		List<Interaction> result = dao.getAllInteractions();
		for(Interaction i: result) {
			if(!i.getG1().equals(i.getG2()) ) {
				if(genes.get(i.getG1()) != null && genes.get(i.getG2()) != null) {
					interactions.add(i);
				}
			}
		}
	}
	
	public void creaGrafo() {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		inizializza();
		
		Graphs.addAllVertices(this.grafo, genes.values());
		
		for(Interaction i: interactions) {
			Genes g1 = genes.get(i.getG1());
			Genes g2 = genes.get(i.getG2());
			if(g1.getChromosome() == g2.getChromosome()) {
				this.grafo.addEdge(g1, g2);
				DefaultWeightedEdge e = this.grafo.getEdge(g1, g2);
				this.grafo.setEdgeWeight(e, Math.abs(i.getCorr())*2);
			}
			else if(g1.getChromosome() != g2.getChromosome()) {
				this.grafo.addEdge(g1, g2);
				DefaultWeightedEdge e = this.grafo.getEdge(g1, g2);
				this.grafo.setEdgeWeight(e, Math.abs(i.getCorr()));
			}
		}
		
		
		System.out.println("Vertici: "+grafo.vertexSet().size()+"\nArchi: "+grafo.edgeSet().size());
		
	}

	public GenesDao getDao() {
		return dao;
	}

	public void setDao(GenesDao dao) {
		this.dao = dao;
	}

	public TreeMap<String, Genes> getGenes() {
		return genes;
	}

	public void setGenes(TreeMap<String, Genes> genes) {
		this.genes = genes;
	}

	public List<Interaction> getInteractions() {
		return interactions;
	}

	public void setInteractions(List<Interaction> interactions) {
		this.interactions = interactions;
	}

	public SimpleWeightedGraph<Genes, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}

	public void setGrafo(SimpleWeightedGraph<Genes, DefaultWeightedEdge> grafo) {
		this.grafo = grafo;
	}
	
	
	
	
	
}
