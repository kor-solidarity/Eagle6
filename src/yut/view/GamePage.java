package yut.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.org.glassfish.gmbal.GmbalException;

import yut.model.vo.Player;

public class GamePage {

	public GamePage(MainFrame mf, JPanel panel, Player player) {
		//전 패널 화면 초기화
		mf.remove(panel);


		JPanel gamePanel = new JPanel();
		gamePanel.setBounds(0, 0, 1500, 800);
		gamePanel.setLayout(null);

		//도움말 버튼  생성
		Image help = new ImageIcon("mini/도움말 게임.PNG").getImage().getScaledInstance(60, 60, 0);
		JButton helpBtn = new JButton();
		helpBtn = new JButton(new ImageIcon(help));
		//도움말 버튼 크기,위치 조정
		helpBtn.setSize(60,60);
		helpBtn.setLocation(1130, 450);



		//게임 화면에 백그라운드 배경
		Image mainGround = new ImageIcon("mini/판떼기.PNG").getImage().getScaledInstance(1500, 800, 0);
		JLabel mainBackGround = new JLabel(new ImageIcon(mainGround));
		mainBackGround.setSize(1500,800);

		//윷던지기 버튼
		Image yutThrow = new ImageIcon("mini/닉네임.PNG").getImage().getScaledInstance(250, 60, 0);
		JLabel yutThrow1 = new JLabel(new ImageIcon(yutThrow));
		yutThrow1.setSize(250, 60);
		yutThrow1.setLocation(1200, 450);


		//무지 grid = 0
		Image muji = new ImageIcon("mini/muji.PNG").getImage().getScaledInstance(180, 180, 0);
		JLabel grid0 = new JLabel(new ImageIcon(muji));
		grid0.setSize(180, 180);
		grid0.setLocation(950, 590);

		//흰색송편 grid =1
		Image white = new ImageIcon("mini/흰색송편.PNG").getImage().getScaledInstance(180, 180, 0);
		JLabel grid1 = new JLabel(new ImageIcon(white));
		grid1.setSize(140, 140);
		grid1.setLocation(970,490);
		//흰색송편 grid =2
		JLabel grid2 = new JLabel(new ImageIcon(white));
		grid2.setSize(140, 140);
		grid2.setLocation(970,380);
		//흰색송편 grid =3
		JLabel grid3 = new JLabel(new ImageIcon(white));
		grid3.setSize(140, 140);
		grid3.setLocation(970,270);
		//흰색송편 grid =4
		JLabel grid4 = new JLabel(new ImageIcon(white));
		grid4.setSize(140, 140);
		grid4.setLocation(970,160);
		//콘 grid =5
		Image con = new ImageIcon("mini/con1.PNG").getImage().getScaledInstance(220, 220, 0);
		JLabel grid5 = new JLabel(new ImageIcon(con));
		grid5.setSize(220, 220);
		grid5.setLocation(930, 0);

		//분홍송편 grid =6
		Image pink = new ImageIcon("mini/분홍송편.PNG").getImage().getScaledInstance(190, 190, 0);
		JLabel grid6 = new JLabel(new ImageIcon(pink));
		grid6.setSize(190, 190);
		grid6.setLocation(810,30);
		//분홍송편 grid =7
		JLabel grid7 = new JLabel(new ImageIcon(pink));
		grid7.setSize(190, 190);
		grid7.setLocation(690,30);
		//분홍송편 grid =8
		JLabel grid8 = new JLabel(new ImageIcon(pink));
		grid8.setSize(190, 190);
		grid8.setLocation(570,30);
		//분홍송편 grid =9
		JLabel grid9 = new JLabel(new ImageIcon(pink));
		grid9.setSize(190, 190);
		grid9.setLocation(450,30);

		//제이지 grid =10
		Image jayg = new ImageIcon("mini/jayg.PNG").getImage().getScaledInstance(180, 180, 0);
		JLabel grid10 = new JLabel(new ImageIcon(jayg));
		grid10.setSize(180, 180);
		grid10.setLocation(310, 10);
		//초록송편 grid =11
		Image green = new ImageIcon("mini/초록송편.PNG").getImage().getScaledInstance(130, 130, 0);
		JLabel grid11 = new JLabel(new ImageIcon(green));
		grid11.setSize(130, 130);
		grid11.setLocation(340,170);
		//초록송편 grid =12
		JLabel grid12 = new JLabel(new ImageIcon(green));
		grid12.setSize(130, 130);
		grid12.setLocation(340,280);
		//초록송편 grid =13
		JLabel grid13 = new JLabel(new ImageIcon(green));
		grid13.setSize(130, 130);
		grid13.setLocation(340,390);
		//초록송편 grid =14
		JLabel grid14 = new JLabel(new ImageIcon(green));
		grid14.setSize(130, 130);
		grid14.setLocation(340,500);

		//튜브 grid =15
		Image tube = new ImageIcon("mini/tube.PNG").getImage().getScaledInstance(180, 180, 0);
		JLabel grid15 = new JLabel(new ImageIcon(tube));
		grid15.setSize(180, 180);
		grid15.setLocation(300, 610);
		//보라송편 grid =16
		Image purple = new ImageIcon("mini/보라송편.PNG").getImage().getScaledInstance(110, 110, 0);
		JLabel grid16 = new JLabel(new ImageIcon(purple));
		grid16.setSize(110, 110);
		grid16.setLocation(470,640);
		//보라송편 grid =17
		JLabel grid17 = new JLabel(new ImageIcon(purple));
		grid17.setSize(110, 110);
		grid17.setLocation(600,640);
		//보라송편 grid =18
		JLabel grid18 = new JLabel(new ImageIcon(purple));
		grid18.setSize(110, 110);
		grid18.setLocation(730,640);
		//보라송편 grid =19
		JLabel grid19 = new JLabel(new ImageIcon(purple));
		grid19.setSize(110, 110);
		grid19.setLocation(860,640);

		//노랑송편 grid =20
		Image yellow = new ImageIcon("mini/노랑송편1.PNG").getImage().getScaledInstance(110, 110, 0);
		JLabel grid20 = new JLabel(new ImageIcon(yellow));
		grid20.setSize(190, 190);
		grid20.setLocation(820, 150);
		//노랑송편 grid =21
		JLabel grid21 = new JLabel(new ImageIcon(yellow));
		grid21.setSize(190, 190);
		grid21.setLocation(750, 210);
		//라이언 grid =22
		Image ryan = new ImageIcon("mini/ryan.PNG").getImage().getScaledInstance(250, 250, 0);
		JLabel grid22 = new JLabel(new ImageIcon(ryan));
		grid22.setSize(250, 250);
		grid22.setLocation(610, 270);
		//노랑송편 grid =23
		JLabel grid23 = new JLabel(new ImageIcon(yellow));
		grid23.setSize(250, 250);
		grid23.setLocation(500, 370);
		//노랑송편 grid =23
		JLabel grid24 = new JLabel(new ImageIcon(yellow));
		grid24.setSize(250, 250);
		grid24.setLocation(430, 440);

		//노랑송편 grid =25
		Image yellow2 = new ImageIcon("mini/노랑송편2.PNG").getImage().getScaledInstance(110, 110, 0);
		JLabel grid25 = new JLabel(new ImageIcon(yellow2));
		grid25.setSize(190, 190);
		grid25.setLocation(440, 140);
		//노랑송편 grid =26
		JLabel grid26 = new JLabel(new ImageIcon(yellow2));
		grid26.setSize(190, 190);
		grid26.setLocation(520, 200);
		//노랑송편 grid =27
		JLabel grid27 = new JLabel(new ImageIcon(yellow2));
		grid27.setSize(190, 190);
		grid27.setLocation(750, 390);
		//노랑송편 grid =28
		JLabel grid28 = new JLabel(new ImageIcon(yellow2));
		grid28.setSize(190, 190);
		grid28.setLocation(820, 460);



		//플레이어 상태창 배경
		//ryan 배경
		//보라색>노란색으로 변경
		Image purple1 = new ImageIcon("mini/pan.PNG").getImage().getScaledInstance(300, 300, 0);
		JLabel backgroundPurple1 = new JLabel(new ImageIcon(purple1));
		backgroundPurple1.setSize(300,197);
		backgroundPurple1.setLocation(0,0);
		//apeach 배경
		JLabel backgroundPurple2 = new JLabel(new ImageIcon(purple1));
		backgroundPurple2.setSize(300,197);
		backgroundPurple2.setLocation(0,200);
		//frodo 배경
		JLabel backgroundPurple3 = new JLabel(new ImageIcon(purple1));
		backgroundPurple3.setSize(300,197);
		backgroundPurple3.setLocation(0,400);
		//neo 배경
		JLabel backgroundPurple4 = new JLabel(new ImageIcon(purple1));
		backgroundPurple4.setSize(300,197);
		backgroundPurple4.setLocation(0,600);

		//정보 헤드
		Image getGreen = new ImageIcon("mini/정보1.PNG").getImage().getScaledInstance(70, 95, 0);
		JLabel info1 = new JLabel(new ImageIcon(getGreen));
		info1.setSize(100, 100);
		info1.setLocation(100,10);
		JLabel info2 = new JLabel(new ImageIcon(getGreen));
		info2.setSize(100, 100);
		info2.setLocation(100,210);
		JLabel info3 = new JLabel(new ImageIcon(getGreen));
		info3.setSize(100, 100);
		info3.setLocation(100,410);
		JLabel info4 = new JLabel(new ImageIcon(getGreen));
		info4.setSize(100, 100);
		info4.setLocation(100,610);


		//라이언 머리
		Image ryan_head = new ImageIcon("mini/ryan1.PNG").getImage().getScaledInstance(110, 110, 0);
		JLabel ryan_head_label = new JLabel(new ImageIcon(ryan_head));
		ryan_head_label.setSize(105,105);
		ryan_head_label.setLocation(0,10);
		//라이언 몸통
		Image ryan_body = new ImageIcon("mini/라이언.png").getImage().getScaledInstance(80, 80, 0);		
		JLabel ryan_body_label1 = new JLabel(new ImageIcon(ryan_body));
		ryan_body_label1.setSize(100,100);
		ryan_body_label1.setLocation(1,110);
		JLabel ryan_body_label2 = new JLabel(new ImageIcon(ryan_body));
		ryan_body_label2.setSize(100,100);
		ryan_body_label2.setLocation(71,110);
		JLabel ryan_body_label3 = new JLabel(new ImageIcon(ryan_body));
		ryan_body_label3.setSize(100,100);
		ryan_body_label3.setLocation(141,110);
		JLabel ryan_body_label4 = new JLabel(new ImageIcon(ryan_body));
		ryan_body_label4.setSize(100,100);
		ryan_body_label4.setLocation(211,110);




		//어피치 머리
		Image apeach_head = new ImageIcon("mini/apeach1.PNG").getImage().getScaledInstance(100, 100, 0);
		JLabel apeach_head_label = new JLabel(new ImageIcon(apeach_head));
		apeach_head_label.setSize(100,100);
		apeach_head_label.setLocation(10,210);
		//어피치 몸통
		Image apeach_body = new ImageIcon("mini/KakaoTalk_20191107_141544937.png").getImage().getScaledInstance(120, 120, 0);		
		JLabel apeach_body_label1 = new JLabel(new ImageIcon(apeach_body));
		apeach_body_label1.setSize(100,100);
		apeach_body_label1.setLocation(1,310);
		JLabel apeach_body_label2 = new JLabel(new ImageIcon(apeach_body));
		apeach_body_label2.setSize(100,100);
		apeach_body_label2.setLocation(71,310);
		JLabel apeach_body_label3 = new JLabel(new ImageIcon(apeach_body));
		apeach_body_label3.setSize(100,100);
		apeach_body_label3.setLocation(141,310);
		JLabel apeach_body_label4 = new JLabel(new ImageIcon(apeach_body));
		apeach_body_label4.setSize(100,100);
		apeach_body_label4.setLocation(211,310);



		//프로도 머리
		Image frodo_head = new ImageIcon("mini/frodo1.PNG").getImage().getScaledInstance(100, 100, 0);
		JLabel frodo_head_label = new JLabel(new ImageIcon(frodo_head));
		frodo_head_label.setSize(100,100);
		frodo_head_label.setLocation(10,410);
		//프로도 몸통
		Image frodo_body = new ImageIcon("mini/KakaoTalk_20191107_141545047.png").getImage().getScaledInstance(100, 100, 0);		
		JLabel frodo_body_label1 = new JLabel(new ImageIcon(frodo_body));
		frodo_body_label1.setSize(100,100);
		frodo_body_label1.setLocation(1,510);
		JLabel frodo_body_label2 = new JLabel(new ImageIcon(frodo_body));
		frodo_body_label2.setSize(100,100);
		frodo_body_label2.setLocation(71,510);
		JLabel frodo_body_label3 = new JLabel(new ImageIcon(frodo_body));
		frodo_body_label3.setSize(100,100);
		frodo_body_label3.setLocation(141,510);
		JLabel frodo_body_label4 = new JLabel(new ImageIcon(frodo_body));
		frodo_body_label4.setSize(100,100);



		//네오 머리
		Image neo_head = new ImageIcon("mini/neo1.PNG").getImage().getScaledInstance(100, 100, 0);
		JLabel neo_head_label = new JLabel(new ImageIcon(neo_head));
		neo_head_label.setSize(100,100);
		neo_head_label.setLocation(10,610);
		//네오 몸통
		Image neo_body = new ImageIcon("mini/KakaoTalk_20191107_141544694.png").getImage().getScaledInstance(100, 100, 0);
		JLabel neo_body_label1 = new JLabel(new ImageIcon(neo_body));
		neo_body_label1.setSize(100,100);
		neo_body_label1.setLocation(1,710);
		JLabel neo_body_label2 = new JLabel(new ImageIcon(neo_body));
		neo_body_label2.setSize(100,100);
		neo_body_label2.setLocation(71,710);
		JLabel neo_body_label3 = new JLabel(new ImageIcon(neo_body));
		neo_body_label3.setSize(100,100);
		neo_body_label3.setLocation(141,710);
		JLabel neo_body_label4 = new JLabel(new ImageIcon(neo_body));
		neo_body_label4.setSize(100,100);
		neo_body_label4.setLocation(211,710);
		
		
		//송편,아이디 표시 필드
		//후에 setText 변경
		
		//jtextfield 글꼴 변경하는 객체 생성
		Font font = new Font("arian", Font.BOLD, 13);
		
		//text 표시
		JTextField show = new JTextField(15);
		String str = "테스트용@@";
		show.setEditable(false);
		panel.add(show);
		show.setText(str);
		show.setSize(110, 50);
		show.setLocation(190, 5);
		show.setFont(font);
		str += "@@";


		//게임패널에 부착 
		gamePanel.add(helpBtn); 
		gamePanel.add(grid28);
		gamePanel.add(grid27);
		gamePanel.add(grid26);
		gamePanel.add(grid25);
		gamePanel.add(grid24);
		gamePanel.add(grid23);
		gamePanel.add(grid22);
		gamePanel.add(grid21);
		gamePanel.add(grid20);
		gamePanel.add(grid19);
		gamePanel.add(grid18);
		gamePanel.add(grid17);
		gamePanel.add(grid16);
		gamePanel.add(grid15);
		gamePanel.add(grid14);
		gamePanel.add(grid13);
		gamePanel.add(grid12);
		gamePanel.add(grid11);
		gamePanel.add(grid10);
		gamePanel.add(grid9);
		gamePanel.add(grid8);
		gamePanel.add(grid7);
		gamePanel.add(grid6);
		gamePanel.add(grid5);
		gamePanel.add(grid4);
		gamePanel.add(grid3);
		gamePanel.add(grid2);
		gamePanel.add(grid1);
		gamePanel.add(grid0);
		//종철 - 플레이어 정보 입력시 표시되도록 추후 수정(플레이어 이름, 말 상황변화, 송편수, 패널표시)
		//ryan
		gamePanel.add(ryan_head_label);
		gamePanel.add(info1);
		gamePanel.add(show);

		gamePanel.add(ryan_body_label1);
		gamePanel.add(ryan_body_label2);
		gamePanel.add(ryan_body_label3);
		gamePanel.add(ryan_body_label4);
		gamePanel.add(backgroundPurple1);

		//apeach
		gamePanel.add(apeach_head_label);
		gamePanel.add(info2);

		gamePanel.add(apeach_body_label1);
		gamePanel.add(apeach_body_label2);
		gamePanel.add(apeach_body_label3);
		gamePanel.add(apeach_body_label4);
		gamePanel.add(backgroundPurple2);

		//frodo
		gamePanel.add(frodo_head_label);
		gamePanel.add(info3);
		gamePanel.add(frodo_body_label1);
		gamePanel.add(frodo_body_label2);
		gamePanel.add(frodo_body_label3);
		gamePanel.add(frodo_body_label4);
		gamePanel.add(backgroundPurple3);

		//neo
		gamePanel.add(neo_head_label);
		gamePanel.add(info4);
		gamePanel.add(neo_body_label1);
		gamePanel.add(neo_body_label2);
		gamePanel.add(neo_body_label3);
		gamePanel.add(neo_body_label4);
		gamePanel.add(backgroundPurple4);


		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		gamePanel.add(yutThrow1);
		gamePanel.add(mainBackGround);

		gamePanel.revalidate();
		gamePanel.repaint();

		mf.add(gamePanel);
		mf.revalidate();
		mf.repaint();

		ryan_body_label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		ryan_body_label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		ryan_body_label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		ryan_body_label4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		apeach_body_label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		apeach_body_label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		apeach_body_label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		apeach_body_label4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		frodo_body_label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		frodo_body_label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		frodo_body_label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		frodo_body_label4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		neo_body_label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		neo_body_label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		neo_body_label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		neo_body_label4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});
		////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

		//도움말 창 버튼 클릭시 반응
		helpBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Help hp = new Help(mf);
				}
			}
		});

		//윷 던지기 버튼을 눌럿을시 반응 
		yutThrow1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					//윷 gif 파일 적용
					Image yut1 = new ImageIcon("mini/낙영상.GIF").getImage().getScaledInstance(300, 300, 0);
					JLabel yut = new JLabel(new ImageIcon(yut1));
					yut.setSize(300, 300);
					yut.setLocation(1170, 150);

					gamePanel.add(yut);
					gamePanel.revalidate();
					gamePanel.repaint();
					gamePanel.setComponentZOrder(yut, 0);

					Timer ts = new Timer();
					TimerTask tk = new TimerTask() {

						@Override
						public void run() {

							gamePanel.remove(yut);
							gamePanel.revalidate();
							gamePanel.repaint();

						}
					};
					ts.schedule(tk, 2400);
				}
			}
		});

	}

}
