package implement_queue_by_two_stacks;

import java.util.Stack;

public class Queue {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  public Queue() {
    stack1 = new Stack<Integer>();
    stack2 = new Stack<Integer>();
  }

  public void push(int element) {
    stack1.push(element);
  }

  public int pop() {
    if (stack2.size() == 0) {
      while (stack1.size() > 0) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  public int top() {
    if (stack2.size() == 0) {
      while (stack1.size() > 0) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }
}
