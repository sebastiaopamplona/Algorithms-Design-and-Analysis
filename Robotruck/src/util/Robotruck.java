package util;

public class Robotruck {

	private int capacity;
	private int nPackets;
	private int[] bestWay;
	private Packet[] packets;

	public Robotruck(int capacity, int nPackets) {
		this.capacity = capacity;
		this.nPackets = nPackets;
		bestWay = new int[nPackets];
		packets = new Packet[nPackets];
	}
	
	public void solveRobotruck(){
		packets[0].setDistanceToLast(packets[0].getDistanceToOffice());
		bestWay[0] = packets[0].getDistanceToOffice() * 2;
		int carrying = packets[0].getWeight();
		
		for(int i = 1; i < nPackets; i++){
			if(carrying + packets[i].getWeight() <= capacity){
				carrying += packets[i].getWeight();
				bestWay[i] = bestWay[i - 1] 
							 + manhattan(i - 1, i) 
							 + packets[i].getDistanceToOffice() 
							 - packets[i - 1].getDistanceToOffice();
			}
			else{
				calculateBackwards(i);
				break;
			}
		}
		
	}
	
	public void addPacket(int index, int coordX, int coordY, int weight){
		packets[index] = new Packet(coordX, coordY, weight);
		if(index > 0)
			packets[index].setDistanceToLast(manhattan(index, index - 1));
	}

	private void calculateBackwards(int from){
		
		for(int i = from; i < nPackets; i++){
			
			int currentDistance = packets[i].getDistanceToOffice() * 2;
			
			bestWay[i] = bestWay[i - 1] + currentDistance;
			
			int carrying = packets[i].getWeight();
			
			for(int j = i - 1; j >= 0; j--){
				if(carrying + packets[j].getWeight() <= capacity){
					
					carrying += packets[j].getWeight();
					
					currentDistance = currentDistance
									- packets[j + 1].getDistanceToOffice()
									+ packets[j + 1].getDistanceToLast()
									+ packets[j].getDistanceToOffice();
					
					bestWay[i] = Math.min(bestWay[j - 1] + currentDistance, bestWay[i]);
					
				}
				else
					break;
				
			}
		}
		
	}
	
	private int manhattan(int p1, int p2){
		return manhattanDistance(packets[p1].getPacketX(),
								 packets[p1].getPacketY(),
								 packets[p2].getPacketX(),
								 packets[p2].getPacketY());
	}
	
	private int manhattanDistance(int fromX, int fromY, int toX, int toY){
		return (Math.abs(toX - fromX) + Math.abs(toY - fromY));
	}
	
	public int getnPackets() {
		return nPackets;
	}
	
	public int getBestWay(){
		return bestWay[nPackets - 1];
	}
}
