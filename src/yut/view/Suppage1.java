package yut.view;

import java.awt.Dialog;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Suppage1 extends JPanel {


	private JPanel panel2;
	private JDialog gd;
	private MainFrame mf;

	public Suppage1(MainFrame mf) {

		this.mf = mf;
		this.setSize(1500,800);
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setSize(1500,800);



		Image ic1 = new ImageIcon("mini/판떼기.PNG").getImage().getScaledInstance(1500, 800, 0);
		JLabel lb1 = new JLabel(new ImageIcon(ic1));
		lb1.setSize(1500,800);
		Image ic2 = new ImageIcon("mini/도움말 게임.PNG").getImage().getScaledInstance(50, 50, 0);
		JLabel lb3 = new JLabel(new ImageIcon(ic2));
		lb3.setLocation(1400, 670);
		lb3.setSize(50,50);

		//����ȭ�� ĳ���� ���� �κ�                                                                                                                         //����  ����
		Image icon = new ImageIcon("mini/pan.PNG").getImage().getScaledInstance(360, 800, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setSize(500, 800);
		label.setLocation(-118,0);

		//�̼�
		Image icon2 = new ImageIcon("mini/content.PNG").getImage().getScaledInstance(280, 80, 0);
		JLabel labelm = new JLabel(new ImageIcon(icon2));
		labelm.setSize(500, 800);
		labelm.setLocation(1050, -300);

		//�� ������ ����
		Image icon3 = new ImageIcon("mini/content.PNG").getImage().getScaledInstance(280, 350, 0);
		JLabel labely = new JLabel(new ImageIcon(icon3));
		labely.setSize(500, 800);
		labely.setLocation(1050, -50);

		//������
		Image icon4 = new ImageIcon("mini/content.PNG").getImage().getScaledInstance(280, 110, 0);
		JLabel labelt = new JLabel(new ImageIcon(icon4));
		labelt.setSize(500, 800);
		labelt.setLocation(1050, 220);

		//���� 0
		Image muji = new ImageIcon("mini/muji.PNG").getImage().getScaledInstance(180, 180, 0);
		JLabel label0 = new JLabel(new ImageIcon(muji));
		label0.setSize(180, 180);
		label0.setLocation(950, 600);


		//������ 10
		Image jayg = new ImageIcon("mini/jayg.PNG").getImage().getScaledInstance(180, 180, 0);
		JLabel label10 = new JLabel(new ImageIcon(jayg));
		label10.setSize(180, 180);
		label10.setLocation(300, 0);


		//���̾�
		Image ryan = new ImageIcon("mini/ryan.PNG").getImage().getScaledInstance(280, 280, 0);
		JLabel label22 = new JLabel(new ImageIcon(ryan));
		label22.setSize(280, 280);
		label22.setLocation(560, 270);

		//�ʷϼ��� 11
		Image gr1 = new ImageIcon("mini/초록송편.PNG").getImage().getScaledInstance(120, 120, 0);
		JLabel label11 = new JLabel(new ImageIcon(gr1));
		label11.setSize(120, 120);
		label11.setLocation(340,170);

		//�ʷϼ��� 12
		JLabel label12 = new JLabel(new ImageIcon(gr1));
		label12.setSize(120, 120);
		label12.setLocation(340,280);

		//�ʷϼ��� 13
		JLabel label13 = new JLabel(new ImageIcon(gr1));
		label13.setSize(120, 120);
		label13.setLocation(340,390);

		//�ʷϼ��� 14
		JLabel label14 = new JLabel(new ImageIcon(gr1));
		label14.setSize(120, 120);
		label14.setLocation(340,500);

		//Ʃ�� 15
		Image tube = new ImageIcon("mini/tube.PNG").getImage().getScaledInstance(180, 180, 0);
		JLabel label15 = new JLabel(new ImageIcon(tube));
		label15.setSize(180, 180);
		label15.setLocation(300, 600);

		//������� 16
		Image bo1 = new ImageIcon("mini/보라송편.PNG").getImage().getScaledInstance(110, 110, 0);
		JLabel label16 = new JLabel(new ImageIcon(bo1));
		label16.setSize(110, 110);
		label16.setLocation(470,630);

		//������� 17
		JLabel label17 = new JLabel(new ImageIcon(bo1));
		label17.setSize(110, 110);
		label17.setLocation(590,630);

		//������� 18
		JLabel label18 = new JLabel(new ImageIcon(bo1));
		label18.setSize(110, 110);
		label18.setLocation(710,630);

		//������� 19
		JLabel label19 = new JLabel(new ImageIcon(bo1));
		label19.setSize(110, 110);
		label19.setLocation(830,630);



		//������� 1
		Image hw1 = new ImageIcon("mini/흰색송편.PNG").getImage().getScaledInstance(140, 140, 0);
		JLabel label1 = new JLabel(new ImageIcon(hw1));
		label1.setSize(140, 140);
		label1.setLocation(970,500);
		//������� 2
		JLabel label2 = new JLabel(new ImageIcon(hw1));
		label2.setSize(140, 140);
		label2.setLocation(970,390);
		//������� 3
		JLabel label3 = new JLabel(new ImageIcon(hw1));
		label3.setSize(140, 140);
		label3.setLocation(970,280);
		//������� 4
		JLabel label4 = new JLabel(new ImageIcon(hw1));
		label4.setSize(140, 140);
		label4.setLocation(970,170);

		//�� 5
		Image con = new ImageIcon("mini/con1.PNG").getImage().getScaledInstance(220, 220, 0);
		JLabel label5 = new JLabel(new ImageIcon(con));
		label5.setSize(220, 220);
		label5.setLocation(950, 0);

		//������� 6
		Image yw1 = new ImageIcon("mini/노랑송편.PNG").getImage().getScaledInstance(120, 120, 0);
		JLabel label6 = new JLabel(new ImageIcon(yw1));
		label6.setSize(120, 120);
		label6.setLocation(850,60);

		//������� 7
		JLabel label7 = new JLabel(new ImageIcon(yw1));
		label7.setSize(120, 120);
		label7.setLocation(720,60);

		//������� 8
		JLabel label8 = new JLabel(new ImageIcon(yw1));
		label8.setSize(120, 120);
		label8.setLocation(590,60);
		//������� 9
		JLabel label9 = new JLabel(new ImageIcon(yw1));
		label9.setSize(120, 120);
		label9.setLocation(460,60);

		//��ȫ����20
		Image bh1 = new ImageIcon("mini/분홍송편.PNG").getImage().getScaledInstance(190, 190, 0);
		JLabel label20 = new JLabel(new ImageIcon(bh1));
		label20.setSize(190, 190);
		label20.setLocation(820, 150);

		//��ȫ����21
		JLabel label21 = new JLabel(new ImageIcon(bh1));
		label21.setSize(220, 220);
		label21.setLocation(720, 200);

		//��ȫ����23
		JLabel label23 = new JLabel(new ImageIcon(bh1));
		label23.setSize(220, 220);
		label23.setLocation(470, 400);

		//��ȫ����24
		JLabel label24 = new JLabel(new ImageIcon(bh1));
		label24.setSize(220, 220);
		label24.setLocation(390, 450);

		//��ȫ����25
		Image bh2 = new ImageIcon("mini/분홍송편반대.PNG").getImage().getScaledInstance(190, 190, 0);
		JLabel label25 = new JLabel(new ImageIcon(bh2));
		label25.setSize(220, 220);
		label25.setLocation(400, 120);
		//��ȫ����26
		JLabel label26 = new JLabel(new ImageIcon(bh2));
		label26.setSize(220, 220);
		label26.setLocation(480, 190);

		//��ȫ����27
		JLabel label27 = new JLabel(new ImageIcon(bh2));
		label27.setSize(220, 220);
		label27.setLocation(720, 390);
		
		//��ȫ����28
		JLabel label28 = new JLabel(new ImageIcon(bh2));
		label28.setSize(220, 220);
		label28.setLocation(800, 450);

		panel2.add(label28);
		panel2.add(label27);
		panel2.add(label26);
		panel2.add(label25);
		panel2.add(label24);
		panel2.add(label23);
		panel2.add(label21);
		panel2.add(label20);
		panel2.add(label22);
		panel2.add(label8);
		panel2.add(label10);
		panel2.add(label6);
		panel2.add(label19);
		panel2.add(label18);
		panel2.add(label17);
		panel2.add(label16);
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label14);
		panel2.add(label13);
		panel2.add(label12);
		panel2.add(label11);
		panel2.add(label4);
		panel2.add(label0);
		panel2.add(label);
		panel2.add(label15);
		panel2.add(label7);
		panel2.add(label5);
		panel2.add(label9);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(lb1);

		/*panel2.add(lb3);*/





		this.add(panel2);


	}

}








