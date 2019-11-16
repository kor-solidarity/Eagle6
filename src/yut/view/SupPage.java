package yut.view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.io.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;






public class SupPage extends JPanel {

	private JPanel panel2;
	private MainFrame mf;
	private JPanel mainPage;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
    private ArrayList<String> list = new ArrayList<String>();
    private 
    
	
	TextField txtID1;
	TextField txtID2;
	TextField txtID3;
	TextField txtID4;
	
	
	
	
	public SupPage(MainFrame mf) {
        txtID1 = new TextField(20); 
        txtID2 = new TextField(20);
        txtID3 = new TextField(20);
        txtID4 = new TextField(20);
        
		mainPage = this;
         
		this.mf = mf;
		this.setSize(1500,800);
        panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setSize(1500,800);
		
		
		
		
		
		Image icon2 = new ImageIcon("mini/선택창 배경5.png").getImage().getScaledInstance(1500, 800, 0);
		JLabel lb1 = new JLabel(new ImageIcon(icon2));
		lb1.setSize(1500,800);
		
		Image icon3 = new ImageIcon("mini/스타트 선택창.PNG").getImage().getScaledInstance(200, 200, 0);
		JLabel lb2 = new JLabel(new ImageIcon(icon3));
		lb2.setSize(200,200);
		lb2.setLocation(1280, 560);
		
		Image icon4 = new ImageIcon("mini/체크.PNG").getImage().getScaledInstance(100, 100, 0);
		JButton user1c = new JButton(new ImageIcon(icon4));
		user1c.setSize(100,100);
		user1c.setLocation(290 , 420);
		
		Image icon5 = new ImageIcon("mini/체크.PNG").getImage().getScaledInstance(100, 100, 0);
		JButton user2c = new JButton(new ImageIcon(icon4));
		user2c.setSize(100,100);
		user2c.setLocation(880 , 170);
		
		Image icon6 = new ImageIcon("mini/체크.PNG").getImage().getScaledInstance(100, 100, 0);
		JButton user3c = new JButton(new ImageIcon(icon4));
		user3c.setSize(100,100);
		user3c.setLocation(1360 , 420);
		
		Image icon7 = new ImageIcon("mini/체크.PNG").getImage().getScaledInstance(100, 100, 0);
		JButton user4c = new JButton(new ImageIcon(icon4));
		user4c.setSize(100,100);
		user4c.setLocation(880 , 630);
		
		
		
		
	
	   
		
		
	
		 
		
		
		        JTextField n1 = new JTextField("user1");
	            n1.setBounds(60, 450, 230, 50);
	            n1.setFont(new Font("Serif", Font.BOLD, 35));
	            n1.setHorizontalAlignment(JTextField.LEFT);
	            this.setLayout(null);
	           
			
			    JTextField nick2 = new JTextField("user2");
		        nick2.setBounds(650, 200, 230, 50);
		        nick2.setFont(new Font("Serif", Font.BOLD, 35));
		        nick2.setHorizontalAlignment(JTextField.LEFT);
		        this.setLayout(null);
		        
		        JTextField nick3 = new JTextField("user3");
		        nick3.setBounds(1130, 450, 230, 50);
		        nick3.setFont(new Font("Serif", Font.BOLD, 35));
		        nick3.setHorizontalAlignment(JTextField.LEFT);
		        this.setLayout(null);
		        
		        JTextField nick4 = new JTextField("user4");
		        nick4.setBounds(650, 650, 230, 50);
		        nick4.setFont(new Font("Serif", Font.BOLD, 35));
		        nick4.setHorizontalAlignment(JTextField.LEFT);
		        this.setLayout(null);

		
	
		

		
	
		
		
		this.add(n1);
		this.add(nick2);
		this.add(nick3);
		this.add(nick4);
		
		panel2.add(user3c);
		panel2.add(user2c);
		panel2.add(user1c);
		panel2.add(user4c);
	    
	    
		panel2.add(lb2);
		panel2.add(lb1);
		
		
		this.add(panel2);
		

	   
		
		user1c.addMouseListener(new MyMouseAdapter1());
		user2c.addMouseListener(new MyMouseAdapter2());
		user3c.addMouseListener(new MyMouseAdapter3());
		user4c.addMouseListener(new MyMouseAdapter4());
		
		
		lb2.addMouseListener(new MyMouseAdapter());

		
		
		
	}
	
		
		
	


	

	 class MyMouseAdapter1 extends MouseAdapter{
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		if(e.getButton()== 1) {
	    			SupPage sp=new SupPage(mf);
	    			try {
						BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt" , true));
						bos.write(txtID1.getText()+"/");
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	    			try {
	    				String s;
	    				String[] array;
						BufferedReader bos = new BufferedReader(new FileReader("회원명단.txt"));
						try {
							while((s = bos.readLine()) !=null) {
								array = s.split("/");
								if(txtID1.getText().equals(array[1]));
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}


	    			
	    		}
	    	}
	 }
	 class MyMouseAdapter2 extends MouseAdapter{
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		if(e.getButton()== 1) {
	    		
	    			 
	    		}
	    	}
	 }
	 class MyMouseAdapter3 extends MouseAdapter{
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		if(e.getButton()== 1) {
	    			//여기다가 중복인지 아닌지 if else if 걸어서 확인
	    			JOptionPane.showMessageDialog(null, "확인댓당"); 
	    		}
	    	}
	 }
	 class MyMouseAdapter4 extends MouseAdapter{
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		if(e.getButton()== 1) {
	    			//여기다가 중복인지 아닌지 if else if 걸어서 확인
	    			JOptionPane.showMessageDialog(null, "확인댓당"); 
	    		}
	    	}
	 }

	
		
	
		
	
	    	
	
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton()== 1) {
				changePage.changePanel2(mf, mainPage , new Suppage1(mf));
				
			}
			
		}
	
     
     
    

				
								
				
			
			
			
	}
		
	}
