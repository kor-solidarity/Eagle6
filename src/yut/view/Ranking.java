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
        this.hmap = hmap;  //파일에서 ㅇㄺ어온다음다운캐스팅후 집어넣기

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
        JTextArea ra = new JTextArea();
       /* for(int i = 0; i < hmap.size(); i++){
           Player p = (Player) hmap.get(i);
           ra.append((i+1) + "닉네임" + p.getNick() + " 점    "+ p.getSongP() + "\n");
           if(i >= 9){
              break;
           }
        }*/


        ra.setBounds(430, 270, 500, 430);
      ra.setFont(new Font("Sanscerif", Font.BOLD, 30));
      rankLb.add(ra);


    }
    
}
