package zhy.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leecode20 {

	public boolean isValid(String s) {
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.charAt(i));
			if(c.equals("(")) {
				stack.add(c);
			} else if (c.equals("{")) {
				stack.add(c);
				stack.push(c);
			} else if (c.equals("[")) {
				stack.add(c);
			} else if(c.equals(")")) {
				String str = stack.peek();
				if("(".equals(str)) {
					stack.pop();
				}
			} else if(c.equals("}")) {
				String str = stack.peek();
				if("{".equals(str)) {
					stack.pop();
				}
			} else if(c.equals("]")) {
				String str = stack.peek();
				if("[".equals(str)) {
					stack.pop();	
				}
			}
		}
		return stack.isEmpty();
    }
}
