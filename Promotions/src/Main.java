import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.Promotions;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		Promotions p = new Promotions(Integer.parseInt(line[0]),
									  Integer.parseInt(line[1]), 
									  Integer.parseInt(line[2]),
									  Integer.parseInt(line[3]));
		
		int nPrecedences = p.getNPrecedences();
		
		while(nPrecedences > 0){
			line = reader.readLine().split(" ");
			
			p.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			
			nPrecedences--;
		}

		p.setAntSuc();
		
		System.out.println(p.getPromoted(p.getAPromotions()));
		System.out.println(p.getPromoted(p.getBPromotions()));
		System.out.println(p.getNotPromoted(p.getBPromotions()));
	}

}
