package yut.model.vo;

import javax.imageio.ImageIO;
import javax.swing.*;

import yut.view.GamePage;
import yut.view.MainFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Mission {
    // 미션번호
    int missionNum;
    // 미션 완수 여부
    boolean finished = false;
    // 미션 완수한 플레이어 이름
    String winner;

    // 미션에 플레이어가 있는 이유??
    public Mission(/*Player player,*/MainFrame mf, JPanel panel) {

        // 미션번호 무작위로 생성
        missionNum = ((int) (Math.random() * 1)) + 3; //4, 1

        // 미션 번호에 따라 미션 이미지 삽입
        switch (missionNum) {
            case 1:
                //미션 1 - 1등으로 들어오기
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
                //미션 2 - 처음으로 윷 나오기
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
                //미션 3 - 정중앙에 1등으로 가기
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
                //미션 4 - 빽도로 플레이어 잡기
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

    public void confirmMission(MainFrame mf) {

        System.out.println("미션호출");        
        //players[a].setSongP(players[a].getSongP()+10);
        //미션 완수 시 나올 미션 성공 이미지 삽입
        Image endm = new ImageIcon("mini/MissionC.PNG").getImage().getScaledInstance(600, 580, 0);
        JLabel endml = new JLabel(new ImageIcon(endm));
        endml.setSize(600, 580);

        //다이얼로그 창 생성
        JDialog jd = new JDialog(mf, "빰빠바밤빰빰빰빰바바밤");
        jd.setSize(600, 600);
        jd.setLocation(500, 500);
        
        //체크 버튼 생성
        Image check = new ImageIcon("mini/MissionB.PNG").getImage().getScaledInstance(100, 80, 0);
        JLabel checkBtn = new JLabel(new ImageIcon(check));
        checkBtn.setSize(100, 80);
        checkBtn.setLocation(235, 450);

        
        jd.add(checkBtn);
        jd.add(endml);
       
        jd.setVisible(true);
        
        //카운트 증가 시켜서 첫번째로 미션 완수할때만 보상을 줄 수 있게 설정
        if(missionNum == 1) {
            Mal.cou++;
            GamePage.currentPlayer1.setSongP(GamePage.currentPlayer1.getSongP()+10);
            System.out.println("*********************현재 송편 갯수!!!!!" + GamePage.currentPlayer1.getSongP());
            //reload 메소드 불러야됨
            
         
        } else if(missionNum == 2) {
            Mal.cou2++;
            GamePage.currentPlayer1.setSongP(GamePage.currentPlayer1.getSongP()+10);
            System.out.println("*********************현재 송편 갯수!!!!!" + GamePage.currentPlayer1.getSongP());
        } else if(missionNum == 3) {
            Mal.cou3++;
            GamePage.currentPlayer1.setSongP(GamePage.currentPlayer1.getSongP()+10);
            System.out.println("*********************현재 송편 갯수!!!!!" + GamePage.currentPlayer1.getSongP());
            
        } else if(missionNum == 4){
            Mal.cou4++;
            GamePage.currentPlayer1.setSongP(GamePage.currentPlayer1.getSongP()+10);
            System.out.println("*********************현재 송편 갯수!!!!!" + GamePage.currentPlayer1.getSongP());
        }
        
        checkBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if(e.getButton() == 1) {
                    jd.dispose();
                }
            }

        });


        //=====================================================
      
        //미션 완수 보상 (송편 10개 증정)
        //players[].setSongP(//players[].getSongP() + 10);
        
        //미션 완수한 플레이어 이름
        //return //players[].getNick();

    }

}