package yut.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class changePage {

	public static void changePanel(JFrame jf, JPanel ob, SupPage nb) {
		jf.remove(ob);
		jf.add(nb);
	    jf.repaint();
	    
	}
	    
	    public static void changePanel2(JFrame jf, JPanel ob, Suppage1 nb) {
			jf.remove(ob);
			jf.add(nb);
		    jf.repaint();
	    
	   
	   
	}

}
