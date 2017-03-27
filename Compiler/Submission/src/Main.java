

public class Main {
	static gui g=new gui();
	public static String t[],d;
	static Program b=new Program();
	public static void main(String[] args) throws Exception {
		g.go();
	}
		
		public int compile() throws Exception
		{
			int com=0,k=0;			//com is an integer to check if compilation was a success
			t=g.text.getText().split("\\n");
			//t is a string array saving each command line seperately
	
	for(int l=0;l<t.length-1;l++)
	//traversing the entire user-input to check the syntax
	{
		
		if(t[l].charAt(0)=='R'||t[l].charAt(0)=='r')
				//if repeat loop is present
		{

			int j=t[l].indexOf(' ');
			String c=t[l].substring(0,j);
			
			d=t[l].substring(j+1);
			
			int jump=0;
				if(c.equals("Repeat"))
					jump=repeat(l);
					//int jump sets the value of l to the next line of the code after the loop
				l=jump;
		}
			
				
		else
				b.checkSyntax(t[l].substring(0, t[l].length()-1),l);
		//calls the check syntax of the Program class which checks if the keywords entered are correct
			
		k=l;
		  }
	
		if(k==t.length-2)
			com=3;
		return com;
	      }
		
		
		public void run() throws Exception
		{
		
				b.executeCommand();
			
		}

	public int repeat(int o) throws Exception
	{
		// o is the line no of Repeat command
		String a[]=d.split(" ");
		//how many times the part of the program has to be repeated
		
		int m=o;
		
		while(!t[m].equals("Exit;"))
		{
			m++;
		}
		//line no of the last line of the loop 
		int copy=m;

		int n=0;
		try{
			
			n=Integer.parseInt(a[0]);
			
			}
		catch(NumberFormatException e)
		{
			try{
			throw new RunError("Syntax Error in Repeat");
			}
			catch(RunError r)
			{
				
			}
		}
		
		for(int k=1;k<=n;k++)
		{
			for(int x=o+1;x<m;x++)
			{
				b.checkSyntax(t[x].substring(0, t[x].length()-1),x);
			}
			//runs just like a mini-program, hence calls check syntax of Program class for keywords and then of the
			//respective class
		}
		return copy;
	
	}
	
	}


