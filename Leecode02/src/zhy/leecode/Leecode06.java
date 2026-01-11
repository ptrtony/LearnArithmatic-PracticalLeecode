package zhy.leecode;

public class Leecode06 {
		public static void main(String[] args) {
			System.out.println(convert("A", 1));
		}
	 public static String convert(String s, int numRows) {
		 	if(numRows == 1 || numRows >= s.length()) {
		 		return s;
		 	}
	        String[][] a = new String[s.length()][numRows];
	        int row = -1;
	        boolean down = true;
	        int col = 0;
	        int index = 0;
	        while(true) {
	            if(index >= s.length()) {
	                break;
	            }
	            if(row < numRows - 1 && down) {
	            	row++;
	                a[col][row] = String.valueOf(s.charAt(index));
	                index++;
	            } else if(row == numRows - 1) {
	                down = false;
	                col++;
	                row--;
	                a[col][Math.max(0, row)] = String.valueOf(s.charAt(index));
	                index++;
	            } else if(row > 0 && !down) {
	                col++;
	                row--;
	                a[col][row] = String.valueOf(s.charAt(index));
	                index++;
	            } else if(row == 0) {
	                down = true;
	                row++;
	                a[col][row] = String.valueOf(s.charAt(index));
	                index++;
	            }
	        }
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < numRows; i ++) {
	            for(int j = 0; j <= col; j++) {
	                if(a[j][i] != null) {
	                    sb.append(a[j][i]);
	                }
	            }
	        }
	        return sb.toString();
	    }
}
