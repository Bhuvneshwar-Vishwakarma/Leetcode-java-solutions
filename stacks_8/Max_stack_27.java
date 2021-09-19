package stacks_8;
import java.io.*;
import java.util.*;

public class Max_stack_27 {
  public static class MaxStack {
	  
	  private static class Node{
		  int data;
		  Node pre , next;
		  
		  Node(int data){
			  this.data = data;
		  }
	  }
	  private final Node head;
	  private final Node tail;
	  
	  private TreeMap<Integer, ArrayList<Node>> treeMap;
	  
	  private Node addTop(int x) {
		  Node temp = new Node(x);
		  Node pre = tail.pre;
		  
		  temp.next = tail;
		  tail.pre = temp;
		  
		  temp.pre = pre;
		  pre.next = temp;
		  
		  return temp;
		  
	  }
	  private Node getTop() {
		  return tail.pre;
	  }
	  public void remove(Node temp) {
		  Node next = temp.next;
		  Node pre = temp.pre;
		  
		  pre.next = next;
		  next.pre = pre;
	  }

    public MaxStack() {
    	treeMap = new TreeMap<>();
    	head = new Node(-1);
    	tail = new Node(-1);
    	head.next = tail;
    	tail.pre = head;
    }

    public void push(int x) {
    	Node temp = addTop(x);// add on doubly linked list
    	
    	ArrayList<Node> al = new ArrayList<>();
    	if(treeMap.containsKey(x)) { // tmap == treeMap
    		al = treeMap.get(x);
    	}else {
    		treeMap.put(x, al);
    	}
    	al.add(temp);
    }

    public int pop() {
    	Node high = getTop();// form linked-list
    	remove(high);
    	ArrayList<Node> al = treeMap.get(high.data);
    	al.remove(al.size() - 1);
    	if(al.size() == 0) {  
    		treeMap.remove(high.data);
    	}
    	
    	return high.data;
    }

    public int top() {
    	Node high = getTop();
    	return high.data;
    }

    public int peekMax() {
    	Integer x = treeMap.lastKey();
    	return x;
    }

    public int popMax() {
    	Integer x = treeMap.lastKey();
    	ArrayList<Node> al = treeMap.get(x);
    	Node temp = al.remove(al.size() - 1);
    	remove(temp);
    	if(al.size() == 0) {
    		treeMap.remove(x);
    	}
    	return x;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MaxStack maxst = new MaxStack();

    while (read.ready()) {
      String []inp = read.readLine().split(" ");

      switch (inp[0]) {
        case "pop":
          System.out.println(maxst.pop());
          break;
        case "top":
          System.out.println(maxst.top());
          break;
        case "popMax":
          System.out.println(maxst.popMax());
          break;
        case "peekMax":
          System.out.println(maxst.peekMax());
          break;
        case "push":
          maxst.push(Integer.parseInt(inp[1]));
          break;
      }

    }

  }
}
