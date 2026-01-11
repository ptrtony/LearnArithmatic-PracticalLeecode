package zhy.arithmatic.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	
	public static List<int[]> readFile(String filePath, String fileName) {
		return readFile(filePath + "/" + fileName);
	}
	
	public static List<int[]> readFile(String fileName) {
		List<int[]> data = new ArrayList<int[]>();
		FileReader r = null;
		BufferedReader br = null;
		try {
			r = new FileReader(fileName);
			br = new BufferedReader(r);
			String line = null;
			while((line = br.readLine()) != null) {
				   if(line.startsWith("#") || line.trim().isEmpty() || !line.contains(" ")) {
					   continue;
				   }
				   String[] lineData = line.split(" ");
				   if(lineData.length == 2) {
					   String v = lineData[0];
					   String w = lineData[1];
					   if(isOnlyDigits(v) && isOnlyDigits(w)) {
						   data.add(new int[] {Integer.valueOf(v), Integer.valueOf(w)});         
					   }
				   }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(r != null) {
				try {
					r.close();
				} catch (IOException e) {
				}
			}
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					
				}
			}
		}
		return data;
	}
	
	public static boolean isOnlyDigits(String str) {
	    return str != null && !str.isEmpty() && str.chars().allMatch(Character::isDigit);
	}
	
}
