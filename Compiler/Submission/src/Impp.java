import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
public class Impp extends JPanel implements ActionListener{
	JButton go;
	JFileChooser chooser;
	String choosertitle;
	JFrame frame2;
	static JTextArea impt;
	
	 public Impp(){
		    go = new JButton("select destination");
		    go.addActionListener(this);
		    add(go);
		   }

	 public void actionPerformed(ActionEvent e) {            
		    chooser = new JFileChooser(); 
		    chooser.setCurrentDirectory(new java.io.File("."));
		    chooser.setDialogTitle(choosertitle);
		    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

	 if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
	     File filedirect=chooser.getCurrentDirectory();
	     File filename=chooser.getSelectedFile();
	     imporrt(filename);
	          }
	 else {
		 JOptionPane.showMessageDialog(frame2,"No Selection");		

	 }  
}
public String fileRead(File fl)
{
	  FileInputStream fin = null;
	  String p = null;
	  
	  try {
		fin=new FileInputStream(fl);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(fin);
			 p=(String)ois.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
}
public Dimension getPreferredSize(){
    return new Dimension(600, 600);
    }
  
  public void imporrt(File loc)
  {
	  
		String tim=fileRead(loc);
		impt.setText(tim);
		
  }
  public static void ImportFile(JTextArea j){
	    JFrame frame = new JFrame("");
	    Impp panel = new Impp();
	    frame.addWindowListener(
	      new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	          System.exit(0);
	          }
	        }
	      );
	    frame.getContentPane().add(panel,"Center");
	    frame.setSize(panel.getPreferredSize());
	    frame.setVisible(true);
	    impt=j;
	    }
	}


