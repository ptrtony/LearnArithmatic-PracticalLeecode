package zhy.leecode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Leecode739 {
	
	public static void main(String[] args) {
		int[] temperatures  = new int[] {73,74,75,71,69,72,76,73};
		int[] dailys = dailyTemperatures(temperatures);
		System.out.println("dailys 1 = " + Arrays.toString(dailys));
		
		int[] temperatures1 = new int[] {30,40,50,60};
		int[] dailys2 = dailyTemperatures(temperatures1);
		System.out.println("dailys 2  = " + Arrays.toString(dailys2));
		
		int[] temperatures2   = new int[] {30,60,90};
		int[] dailys3 = dailyTemperatures(temperatures2);
		System.out.println("dailys 3  = " + Arrays.toString(dailys3));
	}
	
	public static int[] dailyTemperatures(int[] temperatures) {
        int[] dailys = new int[temperatures.length];
        Stack<Item> stack = new Stack<Item>();
        for(int i = 0; i < temperatures.length; i++) {
        	if(stack.isEmpty()) {
        		stack.push(new Item(i, temperatures[i]));
        	}
        	if (i + 1 < temperatures.length) {
        		int next = temperatures[i + 1];
        		while(true) {
        			if (stack.isEmpty()) {
        				break;
        			}
        			Item item = stack.peek();
        			if(item.getTemperature() < next) {
        				dailys[item.getIndex()] = (i + 1 - item.getIndex());
        				stack.pop();
        			} else {
        				stack.push(new Item(i + 1, next));
        				break;
        			}
        		}
        	}
        }
        return dailys;
    }
	
	private static class Item {
		private int index;
		private int temperature;
		public Item(int index, int temperature) {
			this.index = index;
			this.temperature = temperature;
		}
		
		public int getIndex() {
			return index;
		}
		
		public int getTemperature() {
			return temperature;
		}
	}
}
