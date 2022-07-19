package stack;

import java.util.*;

public class Balancedparanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "{}()))(()()({}}{}" ;
		System.out.println(isbalanced(str));

	}

	public static boolean isbalanced(String str) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
				s.push(str.charAt(i));
			} else if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')') {
				if (s.isEmpty()) {
					return false;
				}
				if (str.charAt(i) == '}') {
					if (s.peek() == '{') {
						s.pop();
					} else {
						return false;
					}
				}
				else if (str.charAt(i) == ']') {
					if (s.peek() == '[') {
						s.pop();
					} else {
						return false;
					}
				}
				else if (str.charAt(i) == ')') {
					if (s.peek() == '(') {
						s.pop();
					} else {
						return false;
					}
				}
			}else {
				
			}

		}  if(s.isEmpty()) {
			return true;
		}else {
		return false;
		}
	}

}
