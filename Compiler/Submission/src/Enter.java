import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

class Enter extends Program implements Command
{
	int flag=0;
	String q[];
	static int tempo,n;
	String h,pl;
	
	
	@Override
	public void checkSyntax(String s) throws Exception {
		
		
		s=s.substring(6);
		//Eliminating the keyword "Enter"

		q=s.split(",");
		//q is a string array which contains entered variable names
		
		for(int p=0;p<s.length();p++)
		{
			if(s.charAt(p)==',')
				flag=1;
		}
		/*The for loop checks if there are one or more elements
		flag=1 implies that there is one element only
		flag=0 implies that there is more than one element
		*/
		
		if(flag==0)
		{
		
			v[count]=new Variables(s);
			//create a new variable in the array of objects of the type Variable 
			
			insert(s);
			//put the key value in the hashtable,along with its position no in the variable array
			
			count++;
			
		}
	
		else //If the no of variables are more than one
		{
			for(int k=0;k<q.length;k++)
			{
			 v[count]=new Variables(q[k]);
			 
			 insert(q[k]);
			 
			 count++;
			}
		}
		int m;
		m=q.length;
		ex[i]="Enter,"+m;
		i++;
		//m=no of variables 
	}

	@Override
	public void executeCommand(String s) throws Exception {
		h=s;
String str = (String)JOptionPane.showInputDialog(frame2,"Enter the values", "Enter command", JOptionPane.PLAIN_MESSAGE);
		//A dialog box to enter values
		Integer y=Integer.parseInt(h);
		//y is no of values
				
		float[] l=new float[y];
		
		
		String temp[]=str.split(",");
		
		try{
			for(int i=0;i<y;i++)
					l[i]=(float)Float.parseFloat(temp[i]);
		//float array l has the converted float values
		}
		catch(Exception e1)
		//If there is a type-mismatch
		{
			throw new RunError("Invalid Input");
		}
		
		
		for(int g=0;g<y;g++)
		{
			//Assign the value to the variables
			v[count].value=l[g];
			count++;
		}
		if(temp.length!=y)
		{
			//when less no of values are entered
			try{
			throw new RunError("Run-Time Error");
			}
			catch(RunError r)
			{
				
			}
		}
	}
	
	
	
	
	public  void insert(String s)
	{
		if(var.containsKey(s)==false)
			//if not part of the repeat loop, i.e no duplicate exists
			var.put(s, count+"");
		/*if the element is not duplicated, put it in the HashTable
		with the name of the variable as the key and position of that in the array 'v' as value*/
		
		else
		{
			pl=var.get(s);
			var.put(s,pl+","+count);	
		}
		/*else if part of the repeat loop,the count of every object having same string name is saved in the value 
		/of the hashmap*/
		
		

	}
	
}
	
	
	
	
	


	

