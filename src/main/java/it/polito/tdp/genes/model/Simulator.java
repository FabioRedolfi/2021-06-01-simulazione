package it.polito.tdp.genes.model;

import java.util.*;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Simulator {
	
	int numIng;
	PriorityQueue<Event> queue;
	List<GenesIng> genesIng = new ArrayList<GenesIng>();
	Graph<Genes, DefaultWeightedEdge> grafo;
	Genes partenza;
	
	public Simulator(int numIng, Graph<Genes, DefaultWeightedEdge> grafo, Genes partenza) {
		super();
		this.numIng = numIng;
		this.grafo = grafo;
		genesIng = new ArrayList<>();
		this.partenza = partenza;
	}


	public void run() {
		this.queue = new PriorityQueue<Event>();
		
		Event e = null;
		
		while(!this.queue.isEmpty()) {
			e = queue.poll();
			
			processEvent(e);
		}
	
		
	}


	private void processEvent(Event e) {
		
		
		
	}
	
	
	

}
