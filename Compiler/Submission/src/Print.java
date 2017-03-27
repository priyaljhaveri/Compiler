

import javax.swing.text.BadLocationException;

class Print extends Program implements Command
{

	@Override
	public void checkSyntax(String s) throws RunError {
	int f=s.indexOf(' ');
	s=s.substring(f).trim();
	String p="";
	int flag=0;
	//flag represents whether a user entered string or a variable has to be printed
		
	if(s.charAt(0)=='"')
	  {
		ex[i]="Print,"+s; 
		//later in execute command directly print what is passed along with the keyword
		i++;
		flag=1;
	}
		
	
	else if(s.charAt(0)!='"')
	{
		p=s.substring(0,s.length());
		
		
		if(var.containsKey(p)==true)//Only if the variable has been defined before
		{
		ex[i]="Print,"+p;	//later in execute command getValue of p and then print value 
		i++;
		flag=1;
		}
			}
		
		
	
	else 
		{
		if(flag==0)
			throw new RunError("Error in Print Syntax");
		}

	}

	@Override
	public void executeCommand(String s) throws BadLocationException
	{
		
		if(s.charAt(0)=='"')
		{
			//if a user enered string is to be printed
			s=s.substring(1,s.length()-1);
			String s1="";
			try{
				s1= text2.getText();
			
			}
			catch(NullPointerException e)
			{
				//if s1 is null i.e. text2 is empty and print is the first command
				
				text2.setText(s);
			}
			text2.setText(s1+"\n"+s);
		}
		else
		{
			//if a variable is to be printed
			Float f=getValue(s);
			text2.append("\n"+f);
			
		}
		
	}
	
}
