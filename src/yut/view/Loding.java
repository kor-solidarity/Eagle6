package yut.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Loding extends JPanel {
        private MainFrame mf;
		private JPanel mainPage;
	
		public Loding(MainFrame mf) {
			
		
		
			JPanel panel1 = new JPanel();
			panel1.setLayout(null);
			panel1.setSize(1500,800);

			Image icon2 = new ImageIcon("mini/����.PNG").getImage().getScaledInstance(100, 100, 0);
			JLabel lb3 = new JLabel(new ImageIcon(icon2));
			lb3.setLocation(500,500);
			lb3.setSize(200,200);

			panel1.add(lb3);
			
			mf.add(panel1);
			

		
	
		
		
		
		
}
}

