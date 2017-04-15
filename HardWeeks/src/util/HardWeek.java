package util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sebastiao Rangel Pamplona
 *
 */
public class HardWeek {

	private int nTasks;
	private int hwLimit;
	private int tasksLeft;
	private int maxHardWeek;
	private int nHardWeeks;
	
	private int[] inDegree;
	private List<Integer>[] outNodes;
	
	@SuppressWarnings("unchecked")
	public HardWeek(int nTasks, int hwLimit){
		
		this.nTasks = nTasks;
		this.hwLimit = hwLimit;
		this.tasksLeft = nTasks;
		this.maxHardWeek = 1;
		this.nHardWeeks = 0;
		
		inDegree = new int[nTasks];
		outNodes = new List[nTasks];
		
		for(int i = 0; i < nTasks; i++){
			
			outNodes[i] = new LinkedList<Integer>();
			
		}
		 
	}

	public Deque<Integer> getFirstWeek(){
		Deque<Integer> week = new ArrayDeque<>(nTasks);
		
		for(int i = 0; i < inDegree.length; i++){
			if(inDegree[i] == 0){
				week.push(i);
				inDegree[i]--;
				tasksLeft--;
			}
		}
			
		if(week.size() > maxHardWeek)
			maxHardWeek = week.size();
		
		if(week.size() > hwLimit)
			nHardWeeks++;
		
		return week;
	}
	
	
	public void solveHardWeeks(Deque<Integer> previousWeek){
		Deque<Integer> week = new ArrayDeque<>(nTasks);
		
		while(previousWeek.size() > 0){
			for(Integer node : outNodes[previousWeek.pop()])
				inDegree[node]--;
		}
		
		for(int i = 0; i < inDegree.length; i++){
			if(inDegree[i] == 0){
				week.push(i);
				inDegree[i]--;
				tasksLeft--;
			}
		}
		
		if(week.size() > maxHardWeek)
			maxHardWeek = week.size();
		
		if(week.size() > hwLimit)
			nHardWeeks++;
		
		if(tasksLeft == 0)
			return;
		else
			solveHardWeeks(week);
	}
	
	public void addEdge(int before, int after){
		outNodes[before].add(after);
		inDegree[after]++;
	}
	
	public int getMaxHardWeek() {
		return maxHardWeek;
	}

	public int getnHardWeeks() {
		return nHardWeeks;
	}

}
