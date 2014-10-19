package interview;

import java.util.Calendar;
import java.util.HashSet;

public class DuplicateNodeRemove {

	public static void main(String[] args) {
		
		Calendar initialTime = Calendar.getInstance();
		long initialTimeMillis = initialTime.getTimeInMillis();
		
		int linkedListLength = Integer.parseInt(args[0]);		
		Node headNode = new UnsortedLinkedList().getHeadNode(linkedListLength);
		
		DuplicateNodeRemove dup = new DuplicateNodeRemove();
		
		System.out.println("Original Linked List");
		dup.displayList(headNode);		

		//Without Buffer
		Node newHeadNode = dup.removeDuplicates(headNode);
		
		//Using Hash Set
		//Node newHeadNode = dup.removeDuplicatesHash(headNode);
		
		System.out.println("New Linked List");
		dup.displayList(newHeadNode);
		
		Calendar endTime = Calendar.getInstance();
		long endTimeMillis = endTime.getTimeInMillis();
		
		System.out.println("Time elapsed: "+(endTimeMillis-initialTimeMillis));
	}

	public void displayList(Node headNode){
		
		Node currNode = headNode;
		
		while(currNode!=null){
			
			System.out.println(currNode.getData());
			currNode = currNode.getNextNode();
		}
	}
	
	public Node removeDuplicates (Node headNode){
		
		if(headNode==null)
			return null;
		
		Node node = headNode.getNextNode();
		headNode.setNextNode(null);
		Node prevNode = headNode;
		
		while(node!=null){
			
			Node nextNode = node.getNextNode();
			
			if(!nodePresent(headNode,node)){
				
				node.setNextNode(null);
				prevNode.setNextNode(node);
				prevNode = node;
			}
			else{				
				node = null;
			}
			
			node = nextNode;
		}
		
		return headNode;
	}
	
	public Boolean nodePresent(Node headNode, Node node){
		
		Node currNode = headNode;
		
		while(currNode!=null){
			
			if(node.getData() == currNode.getData()){
				return true;
			}
			else{
				currNode = currNode.getNextNode();
			}
		}
		return false;
	}
	
	public Node removeDuplicatesHash (Node headNode){
		
		if(headNode==null)
			return null;
		
		Node node = headNode.getNextNode();
		Node prevNode = headNode;
		prevNode.setNextNode(null);
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(headNode.getData());
		
		while(node!=null){
			
			Node next = node.getNextNode();
			
			if(set.contains(node.getData()))				
				node = null;
			else{
				set.add(node.getData());
				node.setNextNode(null);
				prevNode.setNextNode(node);
				prevNode = node;
			}
			
			node = next;
		}
		return headNode;
	}
}
