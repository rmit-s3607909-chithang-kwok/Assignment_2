import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VirtualMenu extends Frame {
	
	VirtualMenu (){
		super ("Menu");
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
	
		
		Button b1 = new Button ("1. List everyone");
		Button b2 = new Button ("2. Add a person");
		Button b3 = new Button ("3. Add a family");
		Button b4 = new Button ("4. Update a person");
		Button b5 = new Button ("5. Delete select person");
		Button b6 = new Button ("6. List two people if they are friends?");
		Button b7 = new Button ("7. List Two people if they are family?");
		Button b8 = new Button ("0. Exit");
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		
		pack();
		
		setVisible(true);
		
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				try{
					FileReader file = new FileReader("/Users/gary/eclipse-workspace/Assignment/peoples.txt");
					
					FileReader file1 = new FileReader("/Users/gary/eclipse-workspace/Assignment/relation.txt");
				
				
					BufferedReader reader = new BufferedReader(file);
					BufferedReader reader1 = new BufferedReader(file1);
				
					String text = "";
					String text1 = "";
					
					String line = reader.readLine();
					String line1 = reader1.readLine();
					while (line != null)
						{
							text += line;
							line = reader.readLine();
							
						}
					while (line1 != null)
					{
						text1 += line1;
						line1 = reader1.readLine();
						
					}
					System.out.println(text);
					System.out.println(text1);
					
				}catch(IOException e) {
					System.out.println("");
					System.exit(0);
					}
			}
		});
		
		b8.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);	
			}
		});
	}    
}