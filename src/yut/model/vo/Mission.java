package yut.model.vo;

import javax.swing.*;

import yut.view.GamePage;
import yut.view.MainFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mission {
   
    public Mission(/*Player player,*/ MainFrame mf, JPanel panel) {
        
        //미션 보기 라벨 생성
        Image m0 = new ImageIcon("mini/MC.PNG").getImage().getScaledInstance(250, 80, 0);
        JLabel ms0 = new JLabel(new ImageIcon(m0));
        ms0.setLocation(1195, 0);
        ms0.setSize(250, 80);
        panel.add(ms0);
        panel.revalidate();
        panel.repaint();
        panel.setComponentZOrder(ms0, 0);
        
        ms0.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
              //미션 도움말 생성
                //도움말 다이얼로그 창 생성
                JDialog helpSd = new JDialog(mf, "미션 도움말");
                helpSd.setSize(1300, 700);
                helpSd.setLocation(500, 500);
                
                //첫번째 미션 보기
                Image m1 = new ImageIcon("mini/M1.PNG").getImage().getScaledInstance(1300, 700, 0);
                JLabel ms1 = new JLabel(new ImageIcon(m1));
                ms1.setSize(1300, 700);
                
                //뒤로 가기 버튼  생성
                Image back = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(140, 140, 0);
                JLabel backBtn = new JLabel(new ImageIcon(back));
                
                //버튼 크기,위치 조정
                backBtn.setSize(140, 140);
                backBtn.setLocation(1170, -20);

                helpSd.add(backBtn);
                helpSd.add(ms1);

                //도움말 화면 출력
                helpSd.setVisible(true);

                //뒤로 가는 버튼 클릭시 반응
                backBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        //위에 코드 내용 반복 이미지 파일만 교체
                        Image m2 = new ImageIcon("mini/M2.PNG").getImage().getScaledInstance(1300, 700, 0);
                        JLabel ms2 = new JLabel(new ImageIcon(m2));
                        ms2.setSize(1300, 700);

                        Image back = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(140, 140, 0);

                        JLabel backBtn1 = new JLabel(new ImageIcon(back));
                        backBtn1.setSize(140, 140);
                        backBtn1.setLocation(1170, -20);

                        helpSd.remove(backBtn);
                        helpSd.remove(ms1);
                        helpSd.add(backBtn1);
                        helpSd.add(ms2);
                        helpSd.revalidate();
                        helpSd.repaint();

                        backBtn1.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {

                                Image m3 = new ImageIcon("mini/M3.PNG").getImage().getScaledInstance(1300, 700, 0);
                                JLabel ms3 = new JLabel(new ImageIcon(m3));
                                ms3.setSize(1300, 700);

                                Image back = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(140, 140, 0);

                                JLabel backBtn2 = new JLabel(new ImageIcon(back));
                                backBtn2.setSize(140, 140);
                                backBtn2.setLocation(1170, -20);

                                helpSd.remove(backBtn1);
                                helpSd.remove(ms2);
                                helpSd.add(backBtn2);
                                helpSd.add(ms3);
                                helpSd.revalidate();
                                helpSd.repaint();

                                backBtn2.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        Image m4 = new ImageIcon("mini/M4.PNG").getImage().getScaledInstance(1300, 700, 0);
                                        JLabel ms4 = new JLabel(new ImageIcon(m4));
                                        ms4.setSize(1300, 700);

                                        Image back = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(140, 140, 0);

                                        JLabel backBtn3 = new JLabel(new ImageIcon(back));
                                        backBtn3.setSize(140, 140);
                                        backBtn3.setLocation(1170, -20);

                                        helpSd.remove(backBtn2);
                                        helpSd.remove(ms3);
                                        helpSd.add(backBtn3);
                                        helpSd.add(ms4);
                                        helpSd.revalidate();
                                        helpSd.repaint();

                                        backBtn3.addMouseListener(new MouseAdapter() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {

                                                Image m5 = new ImageIcon("mini/M5.PNG").getImage().getScaledInstance(1300, 700, 0);
                                                JLabel ms5 = new JLabel(new ImageIcon(m5));
                                                ms5.setSize(1300, 700);

                                                Image end1 = new ImageIcon("mini/창버튼.PNG").getImage().getScaledInstance(120, 80, 0);

                                                JButton end = new JButton(new ImageIcon(end1));
                                                end.setSize(120, 80);
                                                end.setLocation(1155, 0);

                                                helpSd.remove(backBtn3);
                                                helpSd.remove(ms4);
                                                helpSd.add(end);
                                                helpSd.add(ms5);
                                                helpSd.revalidate();
                                                helpSd.repaint();

                                                end.addMouseListener(new MouseAdapter() {
                                                    @Override
                                                    public void mouseClicked(MouseEvent e) {
                                                        helpSd.dispose();
                                                    }
                                                });


                                            }
                                        });
                                    }
                                });
                            }
                        });

                    }
                });
                
            }
        });

    }

 
        /*// 미션번호 무작위로 생성
        int missionNum = ((int) (Math.random() * 5)) + 1;

        // 미션 번호에 따라 미션 이미지 삽입
        switch (missionNum) {
            case 1:
                //이미지 바꿔야 함
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
                //미션 2 - 다른 플레이어 말 1등으로 잡기
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
                
            case 5:
                //미션 5 - 처음으로 윷 나오기
                Image m5 = new ImageIcon("mini/Mission_5.PNG").getImage().getScaledInstance(330, 140, 0);
                JLabel ms5 = new JLabel(new ImageIcon(m5));
                ms5.setLocation(1150, 10);
                ms5.setSize(330, 140);
                panel.add(ms5);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(ms5, 0);
                break;
  
        }*/


    public void confirmMission(MainFrame mf) {

      System.out.println("미션 확인 메소드 호출");
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
      
     
      
      
      /*//카운트 증가 시켜서 첫번째로 미션 완수할때만 보상을 줄 수 있게 설정
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
      }*/
      
      checkBtn.addMouseListener(new MouseAdapter() {
          
          @Override
          public void mouseClicked(MouseEvent e) {
              
              if(e.getButton() == 1) {
                  jd.dispose();
              }
          }
    });
  
    }
}