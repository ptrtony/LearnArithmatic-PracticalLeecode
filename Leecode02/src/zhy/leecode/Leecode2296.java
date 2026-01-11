package zhy.leecode;

import java.util.ArrayList;
import java.util.List;

public class Leecode2296 {
	class TextEditor {
		
		private List<String> prefix;
		private List<String> suffix;
	    public TextEditor() {
	    	prefix = new ArrayList<String>();
	    	suffix = new ArrayList<String>();
	    }
	    
	    
	    public void addText(String text) {
	    	for(int i = 0; i < text.length(); i++) {
	    		prefix.add(String.valueOf(text.charAt(i)));
	    	}
	    }
	    
	    public int deleteText(int k) {
	    	int count = 0;
	        while(!prefix.isEmpty() && k > 0) {
	        	k--;
	        	count++;
	        	prefix.removeLast();
	        }
	        return count;
	    }
	    
	    public String cursorLeft(int k) {
	        while(!prefix.isEmpty() && k > 0) {
	        	suffix.add(prefix.removeLast());
	        	k--;
	        }
	        int resLen = Math.min(10, prefix.size());
	        StringBuilder sb = new StringBuilder();
	        for(int i = prefix.size() - resLen; i < prefix.size(); i++) {
	        	sb.append(prefix.get(i));
	        }
	        return sb.toString();
	    }
	    
	    public String cursorRight(int k) {
	    	while(!suffix.isEmpty() && k > 0) {
	    		prefix.add(suffix.removeLast());
	        	k--;
	        }
	    	int resLen = Math.min(10, prefix.size());
	    	StringBuilder sb = new StringBuilder();
	    	for(int i = prefix.size() - resLen; i < prefix.size(); i ++) {
	    		sb.append(suffix.get(i));
	    	}
	    	return sb.toString();
	    }
	}
}
