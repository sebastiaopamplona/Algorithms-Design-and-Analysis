import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import util.Robotruck;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input = reader.readLine();
		input += " " + reader.readLine();

		Robotruck rt = new Robotruck(Integer.parseInt(input.split(" ")[0]), Integer.parseInt(input.split(" ")[1]));

		int packetsAdded = 0;

		while (packetsAdded < rt.getnPackets()) {
			input = reader.readLine();
			rt.addPacket(packetsAdded, 
						 Integer.parseInt(input.split(" ")[0]),
						 Integer.parseInt(input.split(" ")[1]),
						 Integer.parseInt(input.split(" ")[2]));

			packetsAdded++;
		}

		rt.solveRobotruck();
		
		System.out.println(rt.getBestWay());
		
	}
 
}

