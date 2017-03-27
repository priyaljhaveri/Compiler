

class Add extends Program implements Command
{
	int flag=1;
	@Override
	public void checkSyntax(String s) throws Exception 
	{
		s=s.substring(3);
		//eliminating the key word
		
		String add[];//to get the variables to be added
		add=s.trim().split("\\+");
		double d[]=new double[5];
		int l=0;
		double a=0;
	try //if add[] contains numbers directly convert to double
	{	
		for(l=0;l<add.length;l++)
		{
			d[l]=Double.parseDouble(add[l]);//Add exception for type mismathc
			a+=d[l];
		}
	
		ex[i]="Add,"+a; //a is  the answer of the addition
		i++;
		flag=0;
	}
	catch(NumberFormatException e)// if they are variables
		{
		String j="";	
		for(int k=0;k<add.length;k++)
		{	
			if(var.containsKey(add[k])) 
			{
				j+=".";
				j+=add[k];
			}
			else
				try{
				throw new RunError("Invalid variable in Add");
				}
			catch(RunError r)
			{
				
			}
		}
		
		j=j.substring(1);
		
		ex[i]="Add,"+j; 	//j is a string of variable1,variable2 type string
		i++;
		}
	}

	@Override
	public void executeCommand(String s) {
		float add =0;
		if(flag==0)//if flag=0,it is of type numbers
			text2.append("\n"+s);
		else //retrieves value of variable and adds and prints
		{	
			
			int f=0;
			String t[]=s.split("\\.");
			
			while(var.containsKey(t[f]))
			{
				
				Float g=getValue(t[f]);
				
				add+=g;
				f++;
				
				if(f==t.length)
					break;
			}	
			
			text2.append("\n"+add);
		}
		
	}
	
}


