package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;
    private final Stack<Integer> maxStack;

    MinMaxStackImpl(){
        stack = new Stack<>();
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    @Override
    public void push(int value) {
        stack.push(value);
        pushMinStack(value);
        pushMaxStack(value);
    }

    @Override
    public int pop() {
        if(stack.isEmpty())
        {
            throw new IllegalStateException("Stack is empty");
        }
        minStack.pop();
        return stack.pop();
    }

    @Override
    public int peek() {
        if(stack.isEmpty())
        {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }

    @Override
    public int getMin() {
        if(minStack.isEmpty())
        {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

    @Override
    public int getMax() {
        if(maxStack.isEmpty())
        {
            throw new IllegalStateException("Stack is empty");
        }
        return maxStack.peek();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    private void pushMinStack(int value){
        if(minStack.isEmpty() || value < minStack.peek()){
            minStack.push(value);
        }
        else{
            minStack.push(minStack.peek());
        }
    }

    private void pushMaxStack(int value){
        if(maxStack.isEmpty() || value > maxStack.peek()){
            maxStack.push(value);
        }
        else{
            maxStack.push(maxStack.peek());
        }
    }
}
