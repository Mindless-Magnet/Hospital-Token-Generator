import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;



public class PriorityQueue {

	LinkedList list = new LinkedList();
	
    public void insert(Node node,int doctorNumber) throws IOException  {
    	
    	Stack<Node> stack = new Stack<Node>();
    	
    
    	
        if(doctorNumber == 1)
        {

        	if(new File("dr1.txt").length() >= 1)
        	{
        		Scanner scan = new Scanner(new File("dr1.txt"));
        		
        		while(scan.hasNext())
        		{
        			
        		String temp[] = scan.nextLine().split(" ");
        	
        		list.add(new Node(temp[0].split(".").length!=1?temp[0].replace('.',' '):temp[0],temp[3].charAt(0),Integer.parseInt(temp[1]),Float.parseFloat(temp[2]),temp[4]));
        	
        		}
        		list.add(node);
        	}
        		
        	else 
        	{
        		list.add(node);
        	}
        	
        	FileWriter dr1 = new FileWriter(new File("dr1.txt"));
        	
        
        	
        	
        	for(int i =  list.size()-1; i>=0 ;i--)
        	{
        		if(list.get(i).status == 'N')
        		{
        			stack.push(list.get(i));
        			list.remove(i);
        			
        		}
        	}
        	
        	
        	
        	for(int i =  list.size()-1; i>=0 ;i--)
        	{
        		
        			stack.push(list.get(i));
        			
        		
        	}
        	
        	while(!stack.isEmpty()) {
        		Node temp = stack.pop();
        		String condition = (temp.status=='S'?"Serious":"Normal");
        		String tempName = temp.name.split(" ").length!=1?temp.name.replace(' ', '.'):temp.name;
        		dr1.write(tempName+" "+temp.age+" "+temp.weight+" "+condition+" "+temp.time+"\n");
        	}
        	
        	dr1.close();
       
        }
        else if(doctorNumber == 2)
        {
        	
        	if(new File("dr2.txt").length() >= 1)
        	{
        		Scanner scan = new Scanner(new File("dr2.txt"));
        		
        		while(scan.hasNext())
        		{
        			
        		String temp[] = scan.nextLine().split(" ");
        	
        		list.add(new Node(temp[0].split(".").length!=1?temp[0].replace('.',' '):temp[0],temp[3].charAt(0),Integer.parseInt(temp[1]),Float.parseFloat(temp[2]),temp[4]));
        	
        		}
        		list.add(node);
        	}
        		
        	else 
        	{
        		list.add(node);
        	}
        	
        	FileWriter dr2 = new FileWriter(new File("dr2.txt"));
        	
        
        	
        	
        	for(int i =  list.size()-1; i>=0 ;i--)
        	{
        		if(list.get(i).status == 'N')
        		{
        			stack.push(list.get(i));
        			list.remove(i);
        			
        		}
        	}
        	
        	
        	
        	for(int i =  list.size()-1; i>=0 ;i--)
        	{
        		
        			stack.push(list.get(i));
        			
        		
        	}
        	
        	while(!stack.isEmpty()) {
        		Node temp = stack.pop();
        		String condition = (temp.status=='S'?"Serious":"Normal");
        		String tempName = temp.name.split(" ").length!=1?temp.name.replace(' ', '.'):temp.name;
        		dr2.write(tempName+" "+temp.age+" "+temp.weight+" "+condition+" "+temp.time+"\n");
        	}
        	
        	dr2.close();
        }
        else if(doctorNumber == 3)
        {

        	if(new File("dr3.txt").length() >= 1)
        	{
        		Scanner scan = new Scanner(new File("dr3.txt"));
        		
        		while(scan.hasNext())
        		{
        		
        		String temp[] = scan.nextLine().split(" ");
        	
        		list.add(new Node(temp[0].split(".").length!=1?temp[0].replace('.',' '):temp[0],temp[3].charAt(0),Integer.parseInt(temp[1]),Float.parseFloat(temp[2]),temp[4]));
        	
        		}
        		list.add(node);
        	}
        		
        	else 
        	{
        		list.add(node);
        	}
        	
        	FileWriter dr3 = new FileWriter(new File("dr3.txt"));
        	
        
        	
        	
        	for(int i =  list.size()-1; i>=0 ;i--)
        	{
        		if(list.get(i).status == 'N')
        		{
        			stack.push(list.get(i));
        			list.remove(i);
        			
        		}
        	}
        	
        	
        	
        	for(int i =  list.size()-1; i>=0 ;i--)
        	{
        		
        			stack.push(list.get(i));
        			
        		
        	}
        	
        	while(!stack.isEmpty()) {
        		Node temp = stack.pop();
        		String condition = (temp.status=='S'?"Serious":"Normal");
        		String tempName = temp.name.split(" ").length!=1?temp.name.replace(' ', '.'):temp.name;
        		dr3.write(tempName+" "+temp.age+" "+temp.weight+" "+condition+" "+temp.time+"\n");
        	}
        	
        	dr3.close();
        }
        	
    	

    }

  
  
  
}
