package yut.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;







public class SupPage extends JPanel {

	private JPanel panel2;
	private MainFrame mf;
	private JPanel mainPage;
	
	public SupPage(MainFrame mf) {
         mainPage = this;
		this.mf = mf;
		this.setSize(1500,800);
        panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setSize(1500,800);
		
		
		
		Image icon2 = new ImageIcon("mini/선택창 배경.PNG").getImage().getScaledInstance(1500, 800, 0);
		JLabel lb1 = new JLabel(new ImageIcon(icon2));
		lb1.setSize(1500,800);
		
		Image icon3 = new ImageIcon("mini/스타트 선택창.PNG").getImage().getScaledInstance(200, 200, 0);
		JLabel lb2 = new JLabel(new ImageIcon(icon3));
		lb2.setSize(200,200);
		lb2.setLocation(1280, 560);
		
		panel2.add(lb2);
		
		panel2.add(lb1);
		
		this.add(panel2);
		
		
		lb2.addMouseListener(new MyMouseAdapter());
		
	
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
