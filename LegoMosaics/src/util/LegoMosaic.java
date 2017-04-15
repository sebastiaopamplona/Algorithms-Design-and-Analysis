package util;

/**
 * @author Sebastiao Rangel Pamplona
 *
 */
public class LegoMosaic {

	private static int[] pieces = { 1, 2, 3, 4, 6, 8, 10, 12, 16 };
	private int[] ways;
	private int totalDifferentWays;
	private String ignoredLine;

	private int rows;
	private int columns;

	public LegoMosaic(int rows, int collumns) {
		this.ways = new int[collumns + 1];
		this.totalDifferentWays = 1;
		this.rows = rows;
		this.columns = collumns;
		this.ignoredLine = "";

		this.ways[0] = 1;
		
		fillWays();
		createIngoredLine();

	}

	public void solveLegoMosaics(String line) {
		
		if( ! line.equals(this.ignoredLine)){
			
			char color = '\0';
			int nColor = 0;
			char[] blocks = line.toCharArray();
			
			for(int j = 0;j < blocks.length; j++){ 
				//Found a '.'
				if(blocks[j] == '.'){ 
					totalDifferentWays *= ways[nColor];
					color = '\0';
					nColor = 0;
				}
				// Same color
				else if(blocks[j] == color) 
					nColor++;
				// New color
				else{
					totalDifferentWays *= ways[nColor]; 
					color = blocks[j];
					nColor = 1; 

				}
			}
		
			totalDifferentWays *= ways[nColor]; 
		}
		
	}

	private void createIngoredLine() {
		for (int h = 0; h < columns; h++)
			ignoredLine += ".";
	}

	private void fillWays() {
		// Go through all the possibilities
		for (int i = 1; i <= columns; i++) {
			// Go through all the available pieces
			for (int k = 0; k < pieces.length; k++) {
				// Check if the piece "pieces[k]" fits at the end
				if ((i - pieces[k]) >= 0) {
					ways[i] += ways[i - pieces[k]];
				}
			}
		}
	}

	public int getTotalDifferentWays() {
		return totalDifferentWays;
	}

	public int getRows() {
		return rows;
	}
	
	

}
