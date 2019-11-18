package yut.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.org.glassfish.gmbal.GmbalException;

import yut.model.vo.Item;
import yut.model.vo.Player;
import yut.model.vo.Store;

public class GamePage {

	public GamePage(MainFrame mf,JPanel panel, JPanel lo, Player player/*,Player player*/) {

		//로딩 패널 제거
		mf.remove(lo);
		//게임 패널생성
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

		//종료 버튼  생성
		Image end = new ImageIcon("mini/창버튼.PNG").getImage().getScaledInstance(60, 60, 0);
		JButton endBtn = new JButton();
		endBtn = new JButton(new ImageIcon(end));
		//도움말 버튼 크기,위치 조정
		endBtn.setSize(60,60);
		endBtn.setLocation(1130, 50);

		//스킬 3번 생성 예시
		Image skil3 = new ImageIcon("mini/벽.PNG").getImage().getScaledInstance(80, 80, 0);
		JButton skilBtn3 = new JButton();
		skilBtn3 = new JButton(new ImageIcon(skil3));
		//도움말 버튼 크기,위치 조정
		skilBtn3.setSize(80,80);
		skilBtn3.setLocation(1290, 650);

		//스킬 4번 생성 예시
		Image skil1 = new ImageIcon("mini/폭탄.PNG").getImage().getScaledInstance(80, 80, 0);
		JButton skilBtn4 = new JButton();
		skilBtn4 = new JButton(new ImageIcon(skil1));
		//도움말 버튼 크기,위치 조정
		skilBtn4.setSize(80,80);
		skilBtn4.setLocation(1200, 650);




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


		//*********다영**********
		//*** 미션 랜덤으로 띄우기 ***
		int random = ((int) Math.random() * 4 ) + 1;

		//미션1
		Image m1 = new ImageIcon("mini/Mission_1.PNG").getImage().getScaledInstance(330, 140, 0);
		JLabel ms1 = new JLabel(new ImageIcon(m1));
		ms1.setLocation(1150, 10);
		ms1.setSize(330, 140);

		//미션2
		Image m2 = new ImageIcon("mini/Mission_2.PNG").getImage().getScaledInstance(330, 140, 0);
		JLabel ms2 = new JLabel(new ImageIcon(m2));
		ms2.setLocation(1150, 10);
		ms2.setSize(330, 140);

		//미션3
		Image m3 = new ImageIcon("mini/Mission_3.PNG").getImage().getScaledInstance(330, 140, 0);
		JLabel ms3 = new JLabel(new ImageIcon(m3));
		ms3.setLocation(1150, 10);
		ms3.setSize(330, 140);

		//미션4
		Image m4 = new ImageIcon("mini/Mission_4.PNG").getImage().getScaledInstance(330, 140, 0);
		JLabel ms4 = new JLabel(new ImageIcon(m4));
		ms4.setLocation(1150, 10);
		ms4.setSize(330, 140);

		if(random == 1) {
			System.out.println("미션1");
			gamePanel.add(ms1);
		} else if(random == 2) {
			System.out.println("미션2");
			gamePanel.add(ms2);
		} else if(random == 3) {
			System.out.println("미션3");
			gamePanel.add(ms3);
		} else if(random == 4) {
			System.out.println("미션4");
			gamePanel.add(ms4);
		}



		//게임패널에 부착
		gamePanel.add(skilBtn3);
		gamePanel.add(skilBtn4);
		gamePanel.add(endBtn);
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
		gamePanel.add(yutThrow1);
		gamePanel.add(mainBackGround);
		gamePanel.revalidate();
		gamePanel.repaint();

		mf.add(gamePanel);
		mf.revalidate();
		mf.repaint();

		//스킬 3번 사용시 반응 예씨
		skilBtn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Store shop = new Store();
					shop.buy(mf, gamePanel, player, 3);
				}
			}
		});

		//스킬 4번(폭탄) 사용시 반응 예시
		skilBtn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					Store shop = new Store();
					shop.buy(mf, gamePanel, player, 4);
				}
			}
		});

		//종료버튼 클릭시 메인 화면으로 복귀
		endBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					//종료 팝업창 다이얼로그 생성
					JDialog ed = new JDialog();
					ed.setSize(600,600);
					ed.setLocation(400,400);
					ed.setLayout(null);
					//종료버튼 생성
					Image end1 = new ImageIcon("mini/창버튼.PNG").getImage().getScaledInstance(100, 100, 0);
					JButton endBtn1 = new JButton();
					endBtn1 = new JButton(new ImageIcon(end1));
					//도움말 버튼 크기,위치 조정
					endBtn1.setSize(100,100);
					endBtn1.setLocation(300, 200);
					//체크 버튼 생성
					Image check = new ImageIcon("mini/체크1.PNG").getImage().getScaledInstance(100, 100, 0);
					JButton checkBtn = new JButton();
					checkBtn = new JButton(new ImageIcon(check));
					checkBtn.setSize(100,100);
					checkBtn.setLocation(100, 200);
					//버튼 부착
					ed.add(endBtn1);
					ed.add(checkBtn);
					ed.setVisible(true);

					endBtn1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(e.getButton()==1) {
								//종료 버튼 클릭시 다이얼로그창만 꺼준다
								ed.dispose();
							}
						}
					});

					//체크 버튼 클릭시 다이얼로그를 종료하고 메인 화면으로 복귀
					checkBtn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(e.getButton()==1) {
								mf.remove(gamePanel);
								mf.add(panel);
								mf.revalidate();
								mf.repaint();
								ed.dispose();
							}
						}
					});
				}
			}
		});

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
