package yut.model.vo;

import javax.swing.*;

import yut.view.MainFrame;

import java.awt.*;

public class Mission {
    // 미션번호
    int missionNum;
    // 미션 완수 여부
    boolean finished = false;
    // 미션 완수한 플레이어 이름
    String winner;

    // 미션에 플레이어가 있는 이유??
    public Mission(/*Player player,*/ MainFrame mf, JPanel panel) {

        // 미션번호 무작위로 생성
        missionNum = ((int) (Math.random() * 4)) + 1;

        // 미션 번호에 따라 미션 이미지 삽입
        switch (missionNum) {
            case 1:
                //미션 1
                Image m1 = new ImageIcon("mini/Mission_1.PNG").getImage().getScaledInstance(330, 140, 0);
                JLabel ms1 = new JLabel(new ImageIcon(m1));
                ms1.setLocation(1150, 10);
                ms1.setSize(330, 140);
                panel.add(ms1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(ms1, 0);
                break;

            case 2:
                //미션 2
                Image m2 = new ImageIcon("mini/Mission_2.PNG").getImage().getScaledInstance(330, 140, 0);
                JLabel ms2 = new JLabel(new ImageIcon(m2));
                ms2.setLocation(1150, 10);
                ms2.setSize(330, 140);
                panel.add(ms2);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(ms2, 0);
                break;

            case 3:
                //미션 3
                Image m3 = new ImageIcon("mini/Mission_3.PNG").getImage().getScaledInstance(330, 140, 0);
                JLabel ms3 = new JLabel(new ImageIcon(m3));
                ms3.setLocation(1150, 10);
                ms3.setSize(330, 140);
                panel.add(ms3);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(ms3, 0);
                break;

            case 4:
                //미션 4
                Image m4 = new ImageIcon("mini/Mission_4.PNG").getImage().getScaledInstance(330, 140, 0);
                JLabel ms4 = new JLabel(new ImageIcon(m4));
                ms4.setLocation(1150, 10);
                ms4.setSize(330, 140);
                panel.add(ms4);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(ms4, 0);
                break;

        }

    }

    public String confirmMission (Player[] player, Mal[] mal) {

        int i = 0;
        
        //미션 완수 보상 (송편 10개 증정)
        player[i].setSongP(player[i].getSongP() + 10);

        //미션 완수한 플레이어 이름
        return player[i].getNick();

    }




}