// @author Krishm Patel
// @date February 10, 2022
// @course CS160 - Section 02
// Description - The code basically creates a QR Code of a dimension passed by the command line - 
//with a seed passed by the cmmnd line.


import java.util.Random;

public class QRCode {

	private int[][] grid;
	final int DEFAULT_DIMENSION = 30;
	final int DEFAULT_SEED = 160;
	
	public static void main(String[] args)
	   {
		QRCode myObj = new QRCode();
		int myDim = 30;
		int mySeed = 160;
		if (args.length > 0) {
			myDim = Integer.parseInt(args[0]);
			mySeed = Integer.parseInt(args[1]);
		}
		myObj.setGrid(myDim, myObj.createPattern(myDim, mySeed));
		myObj.setFinder(0, 0);
		myObj.setFinder(0, myDim - 15);
		myObj.setFinder(myDim - 15, 0);
		myObj.print();

	   }
	
	public QRCode() {
		
	}
	
	public int[] createPattern(int dim, int seed) {
		Random rand = new Random();
		rand.setSeed(seed);
		
		int reso[] = new int[dim*dim];
		for (int i = 0; i < reso.length; i++) {
			reso[i] = rand.nextInt(2);
		}
		return reso;
	}
	
	public void setGrid(int dim, int[] pattern) {
		int count = 0;
		this.grid = new int[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < this.grid[0].length; j++) {
				this.grid[i][j] = pattern[count];
				count++;
			}
			
		}
	}
	
	public int[][] getGrid(){
		return this.grid;
	}
	
	public void setFinder(int xPos, int yPos) {
		this.fillSquare(xPos, yPos, 15, 1);
		this.fillSquare(xPos + 2, yPos + 2, 11, 0);
		this.fillSquare(xPos + 4, yPos + 4, 7, 2);
		this.fillSquare(xPos + 6, yPos + 6, 3, 3);
	}
	
	public void fillSquare(int startX, int startY, int width, int color) {
		for (int i = startY; i < startY + width; i++) {
			for (int j = startX; j < startX + width; j++) {
				this.grid[i][j] = color;
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[i].length; j++) {
				System.out.print(this.grid[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void print(int[] pattern) {
		int size = (int) Math.sqrt(pattern.length);
		for(int i = 0; i < pattern.length; i++) {
			for (int j = 0; i < size; j++) {
				System.out.print(pattern[(i * size) + j]);
			}
			System.out.println("");
		}
	}
	
	public void print(int [][] matrix) {
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println("");
		}
	}
	
}
