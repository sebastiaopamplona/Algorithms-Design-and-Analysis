import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.LegoMosaic;


/**
 * @author Sebastiao Rangel Pamplona
 *
 */
public class Main {
	
	private static LegoMosaic lm;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		
		String[] inputl1 = line.split(" ");
		
		lm = new LegoMosaic(Integer.parseInt(inputl1[0]), Integer.parseInt(inputl1[1]));
		
		int rows = lm.getRows();
		
		while(rows > 0){
			line = reader.readLine();
			lm.solveLegoMosaics(line);
			
			rows--;
		}
		
		System.out.println(lm.getTotalDifferentWays());
		
	}
	
}