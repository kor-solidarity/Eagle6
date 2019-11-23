package yut.model.vo;

import java.awt.Image;
import java.util.TimerTask;

import javax.management.timer.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import yut.view.GamePage;

public class Ryan extends Player {
    public Ryan(String nick) {
        super(nick, "Ryan");
    }
    //첫턴 첫번째 윷 2배로 이동
    @Override
    public void skill(GamePage gm) {
        if(getSpecialty()==true) {
            GamePage.SELECTED_BUTTON=4;
         /*   try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //벽 생성 모션 
            Image ww1 = new ImageIcon("mini/어피치모션.GIF").getImage().getScaledInstance(300, 200, 0);
            JLabel wall2 = new JLabel(new ImageIcon(ww1));
            wall2.setSize(300, 200);
            wall2.setLocation(1000, 480);

            gm.gamePanel.add(wall2);
            gm.gamePanel.revalidate();
            gm.gamePanel.repaint();
            gm.gamePanel.setComponentZOrder(wall2, 0);
            
           
            Timer ts = new Timer();
            TimerTask tk = new TimerTask() { 
                
                @Override
                public void run() {
                    gm.gamePanel.remove(wall2);
                    gm.gamePanel.revalidate();
                    gm.gamePanel.repaint();
                    
                }
            };
            */
           
            setSpecialty(false);
            
        }
    }
}
