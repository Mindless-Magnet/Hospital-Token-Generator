
public class Stack {

	LinkedList list = new LinkedList();
	
	
	public void push(Node node)
	{
	
		list.add(node);
		
		
	}
	
	public Node pop()
	{
		return list.remove(list.size()-1);
		
		
	}
	
	public boolean isEmpty()
	{
		return list.size() == 0;
	}
}
