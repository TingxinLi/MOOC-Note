package q021to040;

public class Q36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int count;
    	for (int i = 0; i < 9; i++){
        	count = 0;
        	java.util.HashSet<Character> hs = new java.util.HashSet<Character>();
        	for (int j = 0; j < 9; j++){
        		if ( board[i][j] != '.' ) {
        			hs.add(board[i][j]);
        			count++;
        		}
        	}
        	if ( hs.size() != count) return false;
        }
    	for (int i = 0; i < 9; i++){
        	count = 0;
        	java.util.HashSet<Character> hs = new java.util.HashSet<Character>();
        	for (int j = 0; j < 9; j++){
        		if ( board[j][i] != '.' ) {
        			hs.add(board[j][i]);
        			count++;
        		}
        	}
        	if ( hs.size() != count) return false;
        }
    	for (int i = 0; i < 3; i++){
        	for (int j = 0; j < 3; j++){
        		count = 0;
        		java.util.HashSet<Character> hs = new java.util.HashSet<Character>();
        		for (int k = 0; k < 3; k++){
        			for ( int l = 0; l < 3; l++){
        				if ( board[3 * i + k][3 * j + l] != '.' ) {	
        					hs.add(board[3 * i + k][3 * j + l]);
        					count++;
        				}
        			}
        		}
        		if ( hs.size() != count) return false;
        	}
        }
    	return true;
    }
    public static void main(String[] args) {
		
	}
}
