package yut.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Help {
//TODO:도움말 창 클래스입니다. 건들지 말아주세요.

	public Help(MainFrame mf) {

		//도움말 창 생성    
	    
		//도움말 배경 라벨 생성
		Image help_1 = new ImageIcon("mini/도움말 메인.PNG").getImage().getScaledInstance(1300, 700, 0);
		JLabel helpLb = new JLabel(new ImageIcon(help_1));
		helpLb.setSize(1300,700);

		//도움말 다이얼로그 창 생성
		JDialog helpSd = new JDialog(mf,"도움말");
		helpSd.setSize(1300,700);
		helpSd.setLocation(500, 500);


		//앞으로 가기 버튼  생성
		Image front = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(140, 140, 0);

		JLabel frontBtn = new JLabel(new ImageIcon(front));
		//앞으로 버튼 크기,위치 조정
		frontBtn.setSize(140,140);
		frontBtn.setLocation(1170,-20);

		helpSd.add(frontBtn);
		helpSd.add(helpLb);

		//도움말 화면 출력
		helpSd.setVisible(true);

		//앞으로 버튼 클릭시 반응
		frontBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

                //위에 코드 내용 반복 이미지 파일만 교체
				Image help_2 = new ImageIcon("mini/도움말2.PNG").getImage().getScaledInstance(1300, 700, 0);
				JLabel helpLb1 = new JLabel(new ImageIcon(help_2));
				helpLb1.setSize(1300,700);

				Image front = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(140,140, 0);

				JLabel frontBtn1 = new JLabel(new ImageIcon(front));
				frontBtn1.setSize(140,140);
				frontBtn1.setLocation(1170,-20);

				helpSd.remove(frontBtn);
				helpSd.remove(helpLb);
				helpSd.add(frontBtn1);
				helpSd.add(helpLb1);
				helpSd.revalidate();
				helpSd.repaint();

				frontBtn1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Image help_3 = new ImageIcon("mini/도움말3.PNG").getImage().getScaledInstance(1300, 700, 0);
						JLabel helpLb2 = new JLabel(new ImageIcon(help_3));
						helpLb2.setSize(1300,700);

						Image front = new ImageIcon("mini/앞으로.PNG").getImage().getScaledInstance(140,140, 0);

						JLabel frontBtn2 = new JLabel(new ImageIcon(front));
						frontBtn2.setSize(140,140);
						frontBtn2.setLocation(1170,-20);

						helpSd.remove(frontBtn1);
						helpSd.remove(helpLb1);
						helpSd.add(frontBtn2);
						helpSd.add(helpLb2);
						helpSd.revalidate();
						helpSd.repaint();

						frontBtn2.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

								Image help_4 = new ImageIcon("mini/도움말4.PNG").getImage().getScaledInstance(1300, 700, 0);
								JLabel helpLb3 = new JLabel(new ImageIcon(help_4));
								helpLb3.setSize(1300,700);

								Image end1 = new ImageIcon("mini/창버튼.PNG").getImage().getScaledInstance(120, 80, 0);

								JButton end = new JButton(new ImageIcon(end1));
								end.setSize(120,80);
								end.setLocation(1155,0);
								
								helpSd.remove(frontBtn2);
								helpSd.remove(helpLb2);
								helpSd.add(end);
								helpSd.add(helpLb3);
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

}
