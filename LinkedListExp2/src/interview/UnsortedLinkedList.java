package interview;

import java.util.Random;

public class UnsortedLinkedList {

	Node headNode = new Node();
	Node prevNode;
	Node currNode;
	
	public Node getHeadNode(int linkedListLength){
		
		if(linkedListLength<=0){
			return null;
		}
		
		headNode.setData(randomIntData());
		headNode.setNextNode(null);
		prevNode = headNode;
		
		for(int i=2;i<=linkedListLength;i++){
			
			currNode = new Node();
			currNode.setData(randomIntData());
			currNode.setNextNode(null);
			prevNode.setNextNode(currNode);
			prevNode = currNode;
		}
		
		return headNode;
	}

	public int randomIntData(){
		
		Random random = new Random();
		int randData = random.nextInt(20);
		return randData;
	}
}
