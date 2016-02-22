package min_stack;

import java.util.Stack;

/**
 * Complexity: Time: O(1), Extra Space: O(n)
 */
public class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }

  public void push(int number) {
    stack.push(number);
    if (minStack.isEmpty()) {
      minStack.push(number);
    } else {
      minStack.push(Math.min(number, minStack.peek()));
    }
  }

  public int pop() {
    minStack.pop();
    return stack.pop();
  }

  public int min() {
    return minStack.peek();
  }
}

