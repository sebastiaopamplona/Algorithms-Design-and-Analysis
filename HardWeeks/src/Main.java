import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.HardWeek;

/**
 * @author Sebastiao Rangel Pamplona
 *
 */
public class Main {

	private static HardWeek hw;
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = reader.readLine();
		String[] separatedLine = line.split(" ");
		
		int nDirectPrecedences = Integer.parseInt(separatedLine[1]);
		
		hw = new HardWeek(Integer.parseInt(separatedLine[0]), Integer.parseInt(separatedLine[2]));
		
		while(nDirectPrecedences > 0){
			line = reader.readLine();
			separatedLine = line.split(" ");
			
			hw.addEdge(Integer.parseInt(separatedLine[0]), Integer.parseInt(separatedLine[1]));
			nDirectPrecedences--;
		}
		
		hw.solveHardWeeks(hw.getFirstWeek());
	
		System.out.println(hw.getMaxHardWeek() + " " + hw.getnHardWeeks());
		
	}

}
