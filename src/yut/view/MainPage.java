package yut.view;

import java.awt.Color;

import java.awt.Dialog;
import java.awt.Image;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainPage extends JPanel {

    private MainFrame mf;
    private JPanel mainPage;
    private Dialog sd;


    public MainPage(MainFrame mf) {
        this.mf = mf;
        mainPage = this;

        this.setLayout(null);

        this.setSize(1500, 800);
        Image icon = new ImageIcon("mini/로고수정.PNG").getImage().getScaledInstance(1500, 770, 0);
        JLabel lb1 = new JLabel(new ImageIcon(icon));
        lb1.setSize(1500, 770);
        Image icon1 = new ImageIcon("mini/게임시작.PNG").getImage().getScaledInstance(350, 140, 0);
        JLabel lb2 = new JLabel(new ImageIcon(icon1));
        lb2.setLocation(170, 440);
        lb2.setSize(350, 140);

        Image icon2 = new ImageIcon("mini/도움말.PNG").getImage().getScaledInstance(100, 100, 0);
        JLabel lb3 = new JLabel(new ImageIcon(icon2));
        lb3.setLocation(1380, 650);
        lb3.setSize(100, 100);

        this.add(lb3);
        this.add(lb2);
        this.setVisible(true);


        this.add(lb1);

        mf.add(this);


        lb2.addMouseListener(new MyMouseAdapter());


        lb3.addMouseListener(new MyMouseAdapter1());

    }


    class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            boolean ys = false;

            if (e.getButton() == 1) {
				/*System.out.println("���콺 ���� Ŭ��");
             if(ys !=true) {
				JPanel panel1 = new JPanel();
				panel1.setLayout(null);
				panel1.setSize(1500,800);

				Image icon2 = new ImageIcon("mini/����.PNG").getImage().getScaledInstance(100, 100, 0);
				JLabel lb3 = new JLabel(new ImageIcon(icon2));
				lb3.setLocation(500,500);
				lb3.setSize(200,200);

				panel1.add(lb3);
				mf.remove(mainPage);

				mf.add(panel1);

				mf.repaint();
				ys =true;
				
*/
                changePage.changePanel(mf, mainPage, new SupPage(mf));


                int i = 1;
			
				/*	for(i=1; i<3;i++) {
					
					if(i == 1) {
						changePage.changePanel2(mf, mainPage, new Suppage1(mf));
						System.out.println("ùȭ��");
						
					}
					if(i ==2) {
						mf.remove(mainPage);
						changePage.changePanel(mf, new Suppage1(mf), new SupPage(mf));
						System.out.println("�ι�°ȭ��");
					}*/
					/*
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}*/
                //}


            }
        }
    }

    class MyMouseAdapter1 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) {
                sd = new Dialog(mf, "도움말");
                sd.setBounds(1000, 550, 1500, 800);
                Image icon2 = new ImageIcon("mini/도움말1.PNG").getImage().getScaledInstance(1500, 800, 0);
                JLabel lb3 = new JLabel(new ImageIcon(icon2));
                Image icon3 = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(80, 80, 0);
                JLabel lb4 = new JLabel(new ImageIcon(icon3));
                lb4.setSize(80, 80);
                lb4.setLocation(1380, 40);
                sd.add(lb4);
                sd.add(lb3);
                sd.setVisible(true);

                lb4.addMouseListener(new MyMouseAdapter2());

            }
        }

    }

    class MyMouseAdapter2 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) {

                Image icon = new ImageIcon("mini/도움말2.PNG").getImage().getScaledInstance(1500, 800, 0);
                JLabel lb1 = new JLabel(new ImageIcon(icon));
                Image icon3 = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(80, 80, 0);
                JLabel lb4 = new JLabel(new ImageIcon(icon3));
                lb4.setSize(80, 80);
                lb4.setLocation(1380, 40);

                lb1.setSize(1500, 800);
                sd.removeAll();
                ;
                sd.add(lb4);
                sd.add(lb1);
                sd.setVisible(true);

                lb4.addMouseListener(new MyMouseAdapter3());

            }
        }
    }

    class MyMouseAdapter3 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) {
                Image icon = new ImageIcon("mini/도움말3.PNG").getImage().getScaledInstance(1500, 800, 0);
                JLabel lb1 = new JLabel(new ImageIcon(icon));
                Image icon3 = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(80, 80, 0);
                JLabel lb4 = new JLabel(new ImageIcon(icon3));
                lb4.setSize(80, 80);
                lb4.setLocation(1380, 40);

                sd.removeAll();
                ;
                sd.add(lb4);
                sd.add(lb1);
                sd.setVisible(true);

                lb4.addMouseListener(new MyMouseAdapter4());

            }
        }
    }

    class MyMouseAdapter4 extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) {
                Image icon = new ImageIcon("mini/도움말4.PNG").getImage().getScaledInstance(1500, 800, 0);
                JLabel lb1 = new JLabel(new ImageIcon(icon));
                Image icon3 = new ImageIcon("mini/창버튼.PNG").getImage().getScaledInstance(120, 80, 0);
                JLabel lb4 = new JLabel(new ImageIcon(icon3));
                lb4.setSize(120, 80);
                lb4.setLocation(1375, 40);

                sd.removeAll();
                ;
                sd.add(lb4);
                sd.add(lb1);
                sd.setVisible(true);
                lb4.addMouseListener(new MyMouseAdapter5());
            }
        }
    }

    class MyMouseAdapter5 extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) {
                sd.dispose();
            }
        }

    }

}