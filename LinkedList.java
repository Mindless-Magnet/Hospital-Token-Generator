
public class LinkedList {

	Node head;
	LinkedList()
	{
		head = null;
	}
	
	/*
	 * Adding the at the end of the list
	 */
	public void add(Node node)
	{
		if(head == null)
			head = node;
		else {
		Node temp = head;
		
		while(temp.next!=null)
			temp=temp.next;
		
		temp.next = node;
		
		}
	}
	
	/*
	 * Number of nodes
	 */
	public int size()
	{
		if(head == null)
			return 0;
		
		Node temp = head;
		
		int count = 0 ;
		
		while(temp!=null)
		{
			count++;
			temp = temp.next;
		}
		
		return count;
		
	}
	
	/*
	 * Remove the node indicated by the index
	 */
	public Node remove(int index)
	{
		Node temp;
		if(index == 0)
		{
			temp = head;
			head = head.next;
			return temp;
		}
		Node cur = head;
		
		for(int i = 0 ;i<index-1;i++)
		{
			cur = cur.next;
			
			
		}
		 temp = cur.next;
		 cur.next = cur.next.next;
		 return temp;
		
		
	}
	
	/*
	 * retrieve the Node indicated by the index
	 */
	public Node get(int index)
	{
		if(index == 0)
		{
			
			return head;
		}
		Node cur = head;
		
		for(int i = 0 ;i<index;i++)
		{
			cur = cur.next;
			
			
		}
		 
		 return cur;
	}
	
	
	
	
}
