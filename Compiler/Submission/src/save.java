

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.*;
import java.util.*;
import java.io.*;

public class save extends JPanel
   implements ActionListener {
   JButton go;
   static String t;
   JFileChooser chooser;
   String choosertitle;
JFrame frame2;
JTextArea text2;

  public save() {
    go = new JButton("select destination");
    go.addActionListener(this);
    add(go);
   }

  public void actionPerformed(ActionEvent e) {            
    chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    
    
    
   /* 
chooser.addChoosableFileFilter(new FileFilter() {

    public String getDescription() {
        return "Javaplus docs (*.javaplus)";
        
    }

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        } else {
            return f.getName().toLowerCase().endsWith(".javaplus");
        }
    }
});*/
    //    
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
     File filedirect=chooser.getCurrentDirectory();
     File filename=chooser.getSelectedFile();
    	makefile(filedirect,filename);
 
      }
    else {
    	JOptionPane.showMessageDialog(frame2,"No Selection");
      }
    
  }

  
  public void makefile(File loc,File n)
  {
	int l=loc.toString().length();
	String name=n.toString().substring(l+1);
	File fl=new File(n.toString());
	FileOutputStream fos;
	

	try {
		fos=new FileOutputStream(fl);
		ObjectOutputStream o=new ObjectOutputStream(fos);
		o.writeObject(t);
		
	} catch (FileNotFoundException e) {
		
	} catch (IOException e) {
		
	}
	
  }
  
 
  
  
  public Dimension getPreferredSize(){
    return new Dimension(600, 600);
    }
  
  
  public static void Savefile(String textt)
  {
	  t=textt; //t is the text on the code editor console
    JFrame frame = new JFrame("");
    save panel = new save();
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
    
    }
}



