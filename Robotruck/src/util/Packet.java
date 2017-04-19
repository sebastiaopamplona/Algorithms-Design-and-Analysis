package util;

public class Packet {

	private int packetX;
	private int packetY;
	private int weight;
	private int distanceToLast;

	public Packet(int packetX, int packetY, int weight) {
		this.packetX = packetX;
		this.packetY = packetY;
		this.weight = weight;
	}

	public int getPacketX() {
		return packetX;
	}

	public int getPacketY() {
		return packetY;
	}

	public int getWeight() {
		return weight;
	}
	
	public int getDistanceToOffice(){
		return packetX + packetY;
	}
	
	public void setDistanceToLast(int distance){
		this.distanceToLast = distance;
	}
	
	public int getDistanceToLast(){
		return distanceToLast;
	}

}
