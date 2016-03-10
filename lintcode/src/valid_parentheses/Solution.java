package valid_parentheses;

import java.util.Stack;

public class Solution {
  /**
   * @param s A string
   * @return whether the string is a valid parentheses
   */
  public boolean isValidParentheses(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    if (s.length() % 2 == 1) {
      return false;
    }
    char[] arr = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char c : arr) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.size() == 0) {
          return false;
        }
        char curr = stack.pop();
        if (c == ')' && curr != '(' || c == ']' && curr != '[' || c == '}' && curr != '{') {
          return false;
        }
      }
    }
    if (stack.size() > 0) {
      return false;
    }
    return true;
  }
}
