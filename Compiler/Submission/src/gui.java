

import java.util.Hashtable;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

class gui implements MouseListener{
	int comp=0;
	Main m=new Main();
	public static JTextArea text2; //text2 frame 2 is of the run-console
	JFrame frame,frame2;			//text and frame is of code editor
	JButton com,run,Save,Import;
	JPanel panel;
	JTextArea text;
	public void go()
	{
		RunError.GetArea(frame);
		frame= new JFrame();
		 com= new JButton("Compile");
		 run=new JButton("Run");
		 Save=new JButton("Save");
		 Import=new JButton("Import");
		com.addMouseListener(this);
		run.addMouseListener(this);
		Save.addMouseListener(this);
		Import.addMouseListener(this);
		text= new JTextArea();
		Font f= text.getFont();
		text.setFont(f.deriveFont(f.getSize2D()+15));
		com.setSize(20,20);
		run.setSize(20,20);
		Import.setSize(20,20);
		panel=new JPanel();
		panel.add(com);
		panel.add(run);
		panel.add(Save);
		panel.add(Import);
		frame.getContentPane().add(BorderLayout.PAGE_END, panel);
		frame.getContentPane().add(BorderLayout.CENTER,text);
		frame.setSize(700,700);
		frame.setVisible(true);
		
	}
	
	

		@Override
		public void mouseClicked(MouseEvent e){
			// TODO Auto-generated method stub
			if(e.getSource()==com)
			{
					try {
						comp=m.compile();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
			else if(e.getSource()==run)
			{
				if(comp!=0)
				{
					frame2=new JFrame();
					frame2.setSize(500,500);
					text2=new JTextArea();
					frame2.getContentPane().add(text2);
					frame2.setVisible(true);
					Font f= text2.getFont();
					text2.setFont(f.deriveFont(f.getSize2D()+10));
				
						try {
					m.run();
							}
					catch (Exception e1) {
					// TODO Auto-generated catch block
					
						}
			
				}
				
				else
					
					JOptionPane.showMessageDialog(frame,"Compilation failure");
				
			}
			
			
			else if(e.getSource()==Save)
			{
				save.Savefile(text.getText());
			}
			
			else if(e.getSource()==Import)
			{
				Impp.ImportFile(text);
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	
	}