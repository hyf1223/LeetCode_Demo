import java.util.Stack;

/**
 * @author: heyifeng
 * @time: 2020/9/24 10:08
 * @description:已经通过
 */
public class JZ_用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        } else {
            while ( !stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
