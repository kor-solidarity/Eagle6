package yut.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import yut.model.vo.Player;

public class Ranking {
    private HashMap hmap;
    private MainFrame mf;
    JLabel rankLb;
    

    public Ranking(MainFrame mf, HashMap hmap) {
        this.mf = mf;
        this.hmap = hmap;

        Image rank1 = new ImageIcon("mini/랭킹메인.jpg").getImage().getScaledInstance(1400, 700, 0);
        rankLb = new JLabel(new ImageIcon(rank1));
        rankLb.setSize(1400, 700);

        JDialog rankJd = new JDialog(mf, "랭크");
        rankJd.setSize(1400, 700);
        rankJd.setLocation(20, 20);

        Image end1 = new ImageIcon("mini/창버튼.PNG").getImage().getScaledInstance(120, 80, 0);
        JButton endBtn = new JButton(new ImageIcon(end1));
        endBtn.setSize(120, 80);
        endBtn.setLocation(1155, 0);


        rankJd.add(rankLb);
        rankLb.add(endBtn);
        printRankm(hmap);
        rankJd.setVisible(true);

        endBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    rankJd.dispose();
                }
            }
        });


    }

    public void printRankm(HashMap Hmap) {
        JTextArea ra = new JTextArea("간다ㅏ라마");
        
        Collection values = hmap.values();
        int sum = 0;
       /* Iterator keyIter=hmap.keySet().iterator();
        while(keyIter.hasNext()) {
        	String key = (String) keyIter.next();
			int vaule = (int) hmap.get(key);
			if(key.equals("Plyer")) {
				sum += vaule;
			}
        }
        for(int i = 0; i < ; i++) {*/
        	
        
    }
    
}
