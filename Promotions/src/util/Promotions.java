package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Promotions {

	private int aPromotions;
	private int bPromotions;
	private int nEmployees;
	private int nPrecedences;

	
	private List<Integer>[] outNodes;
	private List<Integer>[] inNodes;
	
	private int[] antecessors;
	private int[] successors;

	@SuppressWarnings("unchecked")
	public Promotions(int aPromotions, int bPromotions, int nEmployees, int nPrecedences) {
		this.aPromotions = aPromotions;
		this.bPromotions = bPromotions;
		this.nEmployees = nEmployees;
		this.nPrecedences = nPrecedences;

		outNodes = new List[nEmployees];
		inNodes = new List[nEmployees];
		for (int i = 0; i < nEmployees; i++) {
			outNodes[i] = new LinkedList<Integer>();
			inNodes[i] = new LinkedList<Integer>();
		}
		
		antecessors = new int[nEmployees];
		successors = new int[nEmployees];
		
	}

	public int getPromoted(int nPromotions){
		int nPromoted = 0;
		
		for(int i = 0; i < nEmployees; i++){
			if(nEmployees - successors[i] <= nPromotions){
				nPromoted++;
			}
		}
		
		return nPromoted;
	}
	
	public int getNotPromoted(int nPromotions){
		int nNotPromoted = 0;
		
		for(int i = 0; i < nEmployees; i++){
			if(nPromotions <= antecessors[i]){
				nNotPromoted++;
			}
		}
		
		return nNotPromoted;
	}
	
	private int dfsExploreDown(int root){
		int successors = -1;
		boolean[] processed = new boolean[nEmployees];
		Stack<Integer> foundUnprocessed = new Stack<Integer>();
		foundUnprocessed.push(root);
		
		do{
			int node = foundUnprocessed.pop();
			if(!processed[node]){
				processed[node] = true;
				successors++;
				for(int v : outAdjacentNodes(node)){
					if(!processed[v])
						foundUnprocessed.push(v);
				}
			}
		}
		while(!foundUnprocessed.isEmpty());
		
		return successors;
	}
	
	private int dfsExploreUp(int root){
		int successors = -1;
		boolean[] processed = new boolean[nEmployees];
		Stack<Integer> foundUnprocessed = new Stack<Integer>();
		foundUnprocessed.push(root);
		
		do{
			int node = foundUnprocessed.pop();
			if(!processed[node]){
				processed[node] = true;
				successors++;
				for(int v : inAdjacentNodes(node)){
					if(!processed[v])
						foundUnprocessed.push(v);
				}
			}
		}
		while(!foundUnprocessed.isEmpty());
		
		return successors;
	}
	
	private List<Integer> inAdjacentNodes(int node){
		return inNodes[node];
	}
	
	private List<Integer> outAdjacentNodes(int node){
		return outNodes[node];
	}
	
	public void setAntSuc(){
		for(int i = 0; i < nEmployees; i++){
			antecessors[i] = dfsExploreUp(i);
			successors[i] = dfsExploreDown(i);
		}
	}
	
	public void addEdge(int vertex, int child){
		outNodes[vertex].add(child);
		inNodes[child].add(vertex);
	}
	
	public int getAPromotions() {
		return aPromotions;
	}

	public int getBPromotions() {
		return bPromotions;
	}
	
	public int getNPrecedences() {
		return nPrecedences;
	}

}
