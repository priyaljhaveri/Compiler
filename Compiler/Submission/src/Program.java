
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;

import javax.swing.plaf.synth.SynthSeparatorUI;
class Program extends gui implements Command
{
	Enter e;
	Print pr;
	Add a;
	
	static int z,i=0,count=0,ln,f;
	//count is a counter for the array of objects of variables
	//z is a counter for the line no.
	//i is  Counter for the execution array 
	
	static Variables v[]=new Variables[30];
	//array of objects of the type 'Variables'
	
	static Hashtable<String,String> var = new Hashtable<String,String>();
	//Hashtable with object name as the key andd position no of the resp object in the array v[]
	
	static String ex[]=new String[100];
	//Execution array used later for reference of order to execute commands during run-time
	
	String ab[];
	final String k1="Enter",k2="Print",k3="Repeat",k4="Add";	
	//Keywords valid in the user input

	public void checkSyntax(String s,int c) throws Exception {
		e=new Enter();
		pr=new Print();
		a=new Add();
		z++;
		
		
		int index=s.indexOf(' ');
		
		String p=s.substring(0, index);
		//p is the keyword of the command
		
				
			if(p.equalsIgnoreCase(k1))
			{
				e.checkSyntax(s); 			//calls checkSyntax() of Enter
			}
			else if(p.equalsIgnoreCase(k2))	//calls checkSyntax() of Print
			{
		
				pr.checkSyntax(s);
			}
			else if(p.equalsIgnoreCase(k4)) //calls checkSyntax() of Add
			{
				a.checkSyntax(s);
			}
		
			else 
			{
				try{
				throw new RunError("Invalid Syntax On Command Line "+z);}
				catch(RunError r)
				{
					
				}
			}
		
         }

	
	public void executeCommand() throws Exception {
		count=0;//reset count to 0 and continue adding variables in order as they are accepted in order
	
		for(int k=0;k<i;k++)	//traverses the exeecution array ex[] and calls the resp executeCommand() of the classes
		{
			String r[]=ex[k].split(",");
			
			if(r[0].equalsIgnoreCase(k1))
			{
				e.executeCommand(r[1]);
			}
			
			else if(r[0].equalsIgnoreCase(k2))
			{
				pr.executeCommand(r[1]);
				
			}
			
			else if(r[0].equalsIgnoreCase(k4))
			{
				a.executeCommand(r[1]);
			}
	
		}
		
}
	
		
	public Float getValue(String s)	//uses the hashtable and variable array to get the 
									//entered value for the variable name I.E. String s that is passed
	{
		Float f=null;
		int counter=0;
		//counter to detect comma 
		String h=var.get(s);
		for(int g=0;g<h.length();g++)
		{
			if(h.charAt(g)==',')
				counter++;
		}
		if(counter==0)
			f=v[Integer.parseInt(h)].value;
		else
		{
			String ne ="";
			ab=h.split(",");
			f=v[Integer.parseInt(ab[0])].value;
			for(int g=1;g<ab.length;g++)
				ne=ne+ab[g]+",";
		
			ne=ne.substring(0,ne.length()-1);
			
			var.put(s,ne);
			/*on the first time it is executed for a duplicated variable 
			 * the first counter position is taken and then taken out of the hashtable value 
			 * the remaining string is for the count positions for all the positions where duplicate variables with varying values exist
			 */
		}
		return f;
	}


	@Override
	public void checkSyntax(String s) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void executeCommand(String s) throws Exception {
		// TODO Auto-generated method stub
		
	}


	
	
}