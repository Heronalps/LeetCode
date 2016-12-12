public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int counter = 0;
        int height  = grid.length;
        int width = grid[0].length;
        int wrappedgrid[][] = new int[height + 2][width + 2];
        for (int i = 1; i < height + 1; i++) {
        	for (int j = 1; j < width + 1; j++ ) {
        		wrappedgrid[i][j] = grid[i - 1][j - 1]; 	
        	}	
        }

        for (int i = 0; i < height + 2; i++) {
        	for (int j = 0; j < width + 2; j++){
        		if(wrappedgrid[i][j] == 1) {
        			counter += 4;
        			if (wrappedgrid[i - 1][j] == 1) {
        				counter -= 1;
        			} 
        			if(wrappedgrid[i + 1][j] == 1) {
        				counter -= 1;
        			} 
        			if (wrappedgrid[i][j - 1] == 1) {
        				counter -= 1;
        			} 
        			if (wrappedgrid[i][j + 1] == 1) {
        				counter -= 1;
        			}
        		}
        	}
        }

        return counter;
    }

    public static int islandPerimeter2(int[][] grid) {
    	int counter = 0;
    	int height = grid.length;
    	int width = grid[0].length;
    	for(int i = 0; i < height; i++) {
    		for(int j = 0; j < width; j++) {
    			if(grid[i][j] == 1) {
    				counter += 4;
	    			if(i < height - 1 && grid[i + 1][j] == 1) {
	    				counter -= 2;
	    			}
	    			if (j < width - 1 && grid[i][j + 1] == 1) {
	    				counter -= 2;
	    			}
	    		}
    		}
    	}
    	return counter;
    }

    public static void main(String[] args) {
    	int[][] grid = { {0 ,1, 0, 0},
    					 {1, 1, 1, 0},
    					 {0, 1, 0, 0},
    					 {1, 1, 0, 0} };

    	int[][] grid2 = {{0},
    					 {1}};
    	System.out.println(islandPerimeter2(grid));
    	System.out.println(islandPerimeter2(grid2));
    }
}
