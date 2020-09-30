package interfaces;

import structures.StackNode;

public interface InterfaceStack <V> {
	
	public boolean isEmpty();
	
	public void push (V value);
	
	public StackNode<V> top();
	
	public StackNode<V> pop();
}