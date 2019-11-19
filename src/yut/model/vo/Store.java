package yut.model.vo;

import java.awt.Image;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import yut.model.vo.*;
import yut.view.GamePage;
import yut.view.MainFrame;
import yut.view.YutMadeByCho;

public class Store {
    // 상점 클래스.
    // 여기서 각 템들이

    public boolean buy(MainFrame mf, JPanel panel, Player player, JTextField show, int itemNum,int x, int y) {
        if(itemNum ==4) {
            if(player.getSongP()>=10) {
                //플레이어 말의 위치에 있는 grid값을 변수에 저장
                int mine = player.getMals()[0].getGrid();

                //폭탄 이미지를 grid를 *좌표(아직 안만들어짐)으로 해당위치에 폭탄 라벨 생성
                Image mm = new ImageIcon("mini/폭탄.PNG").getImage().getScaledInstance(50, 50, 0);
                JLabel mine1 = new JLabel(new ImageIcon(mm));
                mine1.setSize(50, 50);
                mine1.setLocation(x+50, y);

                //폭탄 설치시 문구 생성
                Image pop = new ImageIcon("mini/폭탄설치로고.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel pop1 = new JLabel(new ImageIcon(pop));
                pop1.setSize(200, 80);
                pop1.setLocation(900, 400);
                //폭탄 설치모션 생성
                Image motion1 = new ImageIcon("mini/라이언모션.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel motion = new JLabel(new ImageIcon(motion1));
                motion.setSize(300, 200);
                motion.setLocation(1000, 480);


                //마인클래스에 해당 grid값을 매개변수로 보냄
                Mine m = new Mine(mine,mine1);
                //플레이어 송편을 가격만큼 감소
                player.setSongP(player.getSongP()-m.getPrice());

                String str1 = Integer.valueOf(player.getSongP()).toString();

                show.setText(str1);
                show.revalidate();
                show.repaint();

                panel.add(motion);
                panel.add(pop1);
                panel.add(mine1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(mine1, 2);
                panel.setComponentZOrder(pop1, 0);
                panel.setComponentZOrder(motion, 0);

                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(motion);
                        panel.remove(pop1);
                        panel.revalidate();
                        panel.repaint();

                    }
                };
                ts.schedule(tk, 1300);
            }else {
                //플레이어 송편 부족시 라벨 생성
                Image lack = new ImageIcon("mini/송편부족.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel lack1 = new JLabel(new ImageIcon(lack));
                lack1.setSize(200, 80);
                lack1.setLocation(900, 400);
                //플레이어 송편 부족시 모션라벨 생성
                Image lack2 = new ImageIcon("mini/실패라이언.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel lack3 = new JLabel(new ImageIcon(lack2));
                lack3.setSize(300, 200);
                lack3.setLocation(1000, 480);

                panel.add(lack3);
                panel.add(lack1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(lack1, 0);
                panel.setComponentZOrder(lack3, 0);

                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(lack3);
                        panel.remove(lack1);
                        panel.revalidate();
                        panel.repaint();

                    }

                };
                ts.schedule(tk, 1300);

            }return true;
        }return false;

    }

    public boolean buy(MainFrame mf, JPanel panel, Player player, JTextField show,int itemNum) {
        UpgoDouble ud = new UpgoDouble();


        Exchange e = new Exchange();

        if(itemNum == 2) {
            if(player.getSongP()>=5) {
                //모or도 임펙트 생성
                Image mo = new ImageIcon("mini/슬롯머신.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel mo1 = new JLabel(new ImageIcon(mo));
                mo1.setSize(300, 200);
                mo1.setLocation(1000, 480);
                //모or도  문구 생성
                Image pop = new ImageIcon("mini/모or도.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel pop1 = new JLabel(new ImageIcon(pop));
                pop1.setSize(200, 80);
                pop1.setLocation(1200, 500);
                //플레이어 송편 감소
                player.setSongP(player.getSongP()-5);
                String str1 = Integer.valueOf(player.getSongP()).toString();

                panel.add(mo1);
                panel.add(pop1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(mo1, 0);
                panel.setComponentZOrder(pop1, 0);

                show.setText(str1);
                show.revalidate();
                show.repaint();

                YutMadeByCho yut = new YutMadeByCho();
               GamePage.yutgap1= yut.mainYut(2, player);//윷값보내기
               System.out.println("스토어 : " + GamePage.yutgap1);
               
                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(mo1);
                        panel.remove(pop1);
                        panel.revalidate();
                        panel.repaint();

                    }
                };
                ts.schedule(tk, 1300);

            }else {
                //플레이어 송편 부족시 라벨 생성 
                Image lack = new ImageIcon("mini/송편부족.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel lack1 = new JLabel(new ImageIcon(lack));
                lack1.setSize(200, 80);
                lack1.setLocation(900, 400);
                //플레이어 송편 부족시 모션라벨 생성
                Image lack2 = new ImageIcon("mini/실패라이언.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel lack3 = new JLabel(new ImageIcon(lack2));
                lack3.setSize(300, 200);
                lack3.setLocation(1000, 480);

                panel.add(lack3);
                panel.add(lack1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(lack1, 0);
                panel.setComponentZOrder(lack3, 0);

                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(lack3);
                        panel.remove(lack1);
                        panel.revalidate();
                        panel.repaint();

                    }

                };
                ts.schedule(tk, 1300);
            }

        }


        if(itemNum ==3) {
            if(player.getSongP()>=10) {
                int wall = player.getMals()[1].getGrid();
                //벽 이미지를 grid를 *좌표(아직 안만들어짐)으로 해당위치에 벽 라벨 생성
                Image ww = new ImageIcon("mini/벽.PNG").getImage().getScaledInstance(70, 70, 0);
                JLabel wall1 = new JLabel(new ImageIcon(ww));
                wall1.setSize(70, 70);
                wall1.setLocation(300, 280);
                //벽 설치시 문구 생성
                Image pop = new ImageIcon("mini/벽생성.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel pop1 = new JLabel(new ImageIcon(pop));
                pop1.setSize(200, 80);
                pop1.setLocation(900, 400);
                //벽 생성 모션 
                Image ww1 = new ImageIcon("mini/어피치모션.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel wall2 = new JLabel(new ImageIcon(ww1));
                wall2.setSize(300, 200);
                wall2.setLocation(1000, 480);

                //벽 클래스에 객체 생성
                Wall w = new Wall(wall,wall1);
                //플레이어 송편 감소
                player.setSongP(player.getSongP()-w.getPrice());
                String str1 = Integer.valueOf(player.getSongP()).toString();

                show.setText(str1);
                show.revalidate();
                show.repaint();



                panel.add(wall1);
                panel.add(wall2);
                panel.add(pop1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(wall1, 0);
                panel.setComponentZOrder(wall2, 0);
                panel.setComponentZOrder(pop1, 0);

                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(pop1);
                        panel.remove(wall2);
                        panel.revalidate();
                        panel.repaint();

                    }
                };
                ts.schedule(tk, 1300);


            }else {
                //플레이어 송편 부족시 라벨 생성 
                Image lack = new ImageIcon("mini/송편부족.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel lack1 = new JLabel(new ImageIcon(lack));
                lack1.setSize(200, 80);
                lack1.setLocation(900, 400);
                //플레이어 송편 부족시 모션라벨 생성
                Image lack2 = new ImageIcon("mini/실패라이언.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel lack3 = new JLabel(new ImageIcon(lack2));
                lack3.setSize(300, 200);
                lack3.setLocation(1000, 480);

                panel.add(lack3);
                panel.add(lack1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(lack1, 0);
                panel.setComponentZOrder(lack3, 0);

                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(lack3);
                        panel.remove(lack1);
                        panel.revalidate();
                        panel.repaint();

                    }

                };
                ts.schedule(tk, 1300);

            }
        }




        if(itemNum ==4) {
            if(player.getSongP()>=10) {
                //플레이어 말의 위치에 있는 grid값을 변수에 저장
                int mine = player.getMals()[0].getGrid();

                //폭탄 이미지를 grid를 *좌표(아직 안만들어짐)으로 해당위치에 폭탄 라벨 생성
                Image mm = new ImageIcon("mini/폭탄.PNG").getImage().getScaledInstance(50, 50, 0);
                JLabel mine1 = new JLabel(new ImageIcon(mm));
                mine1.setSize(50, 50);
                mine1.setLocation(300, 300);

                //폭탄 설치시 문구 생성
                Image pop = new ImageIcon("mini/폭탄설치로고.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel pop1 = new JLabel(new ImageIcon(pop));
                pop1.setSize(200, 80);
                pop1.setLocation(900, 400);
                //폭탄 설치모션 생성
                Image motion1 = new ImageIcon("mini/라이언모션.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel motion = new JLabel(new ImageIcon(motion1));
                motion.setSize(300, 200);
                motion.setLocation(1000, 480);

                //마인클래스에 해당 grid값을 매개변수로 보냄
                Mine m = new Mine(mine,mine1);
                //플레이어 송편을 가격만큼 감소
                player.setSongP(player.getSongP()-m.getPrice());

                String str1 = Integer.valueOf(player.getSongP()).toString();

                show.setText(str1);
                show.revalidate();
                show.repaint();

                panel.add(motion);
                panel.add(pop1);
                panel.add(mine1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(mine1, 0);
                panel.setComponentZOrder(pop1, 0);
                panel.setComponentZOrder(motion, 0);

                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(motion);
                        panel.remove(pop1);
                        panel.revalidate();
                        panel.repaint();

                    }
                };
                ts.schedule(tk, 1300);
            }else {
                //플레이어 송편 부족시 라벨 생성 
                Image lack = new ImageIcon("mini/송편부족.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel lack1 = new JLabel(new ImageIcon(lack));
                lack1.setSize(200, 80);
                lack1.setLocation(900, 400);
                //플레이어 송편 부족시 모션라벨 생성
                Image lack2 = new ImageIcon("mini/실패라이언.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel lack3 = new JLabel(new ImageIcon(lack2));
                lack3.setSize(300, 200);
                lack3.setLocation(1000, 480);

                panel.add(lack3);
                panel.add(lack1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(lack1, 0);
                panel.setComponentZOrder(lack3, 0);

                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(lack3);
                        panel.remove(lack1);
                        panel.revalidate();
                        panel.repaint();

                    }

                };
                ts.schedule(tk, 1300);

            }
        }



        if(itemNum==5) {
            if(player.getSongP()>=20) {
                //빽도 사용시 문구 생성
                Image pop = new ImageIcon("mini/빽도이미지.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel pop1 = new JLabel(new ImageIcon(pop));
                pop1.setSize(200, 80);
                pop1.setLocation(900, 400);
                //빽도 실행모션 생성
                Image motion1 = new ImageIcon("mini/빽도모션.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel motion = new JLabel(new ImageIcon(motion1));
                motion.setSize(300, 200);
                motion.setLocation(1000, 480);

                BackDo bd = new BackDo();
                YutMadeByCho yut = new YutMadeByCho();
                GamePage.yutgap1=yut.mainYut(5, player);

                player.setSongP(player.getSongP()-bd.getPrice());

                String str1 = Integer.valueOf(player.getSongP()).toString();

                show.setText(str1);
                show.revalidate();
                show.repaint();

                panel.add(pop1);
                panel.add(motion);
                panel.revalidate();
                panel.repaint();

                panel.setComponentZOrder(pop1, 0);
                panel.setComponentZOrder(motion, 0);

                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(pop1);
                        panel.remove(motion);
                        panel.revalidate();
                        panel.repaint();

                    }

                };
                ts.schedule(tk, 1300);



            }else {
                //플레이어 송편 부족시 라벨 생성 
                Image lack = new ImageIcon("mini/송편부족.PNG").getImage().getScaledInstance(200, 80, 0);
                JLabel lack1 = new JLabel(new ImageIcon(lack));
                lack1.setSize(200, 80);
                lack1.setLocation(900, 400);
                //플레이어 송편 부족시 모션라벨 생성
                Image lack2 = new ImageIcon("mini/실패라이언.GIF").getImage().getScaledInstance(300, 200, 0);
                JLabel lack3 = new JLabel(new ImageIcon(lack2));
                lack3.setSize(300, 200);
                lack3.setLocation(1000, 480);

                panel.add(lack3);
                panel.add(lack1);
                panel.revalidate();
                panel.repaint();
                panel.setComponentZOrder(lack1, 0);
                panel.setComponentZOrder(lack3, 0);

                Timer ts = new Timer();
                TimerTask tk = new TimerTask() {

                    @Override
                    public void run() {
                        panel.remove(lack3);
                        panel.remove(lack1);
                        panel.revalidate();
                        panel.repaint();

                    }

                };
                ts.schedule(tk, 1300);
            }

            return true;
        }
        return false; 













    }



}
