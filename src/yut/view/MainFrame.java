package yut.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

import yut.model.vo.Player;

public class MainFrame extends JFrame{
	//메인 화면 출력
	private MainFrame mf;

	public MainFrame() {

		super("NullLayout");
		//창 사이즈
		this.setSize(1500,800);
		//컨테이너 레이아웃 설정
		this.setLayout(null);

		//메인 패널 생성
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(1500,800);
		mainPanel.setLayout(null);

		//메인 패널 배경 라벨 생성
		Image main = new ImageIcon("mini/로고수정.PNG").getImage().getScaledInstance(1500, 770, 0);
		JLabel mainLb = new JLabel();
		mainLb = new JLabel(new ImageIcon(main));
		//메인 라벨 크기 조정
		mainLb.setSize(1500,770);

		//게임 시작 버튼  생성
		Image start = new ImageIcon("mini/게임스타트버튼.PNG").getImage().getScaledInstance(350, 140, 0);
		JButton startBtn = new JButton();
		startBtn = new JButton(new ImageIcon(start));
		//메인 라벨 크기 ,위치 조정
		startBtn.setSize(350,140);
		startBtn.setLocation(170,440);

		//도움말 버튼  생성
		Image help = new ImageIcon("mini/도움말.PNG").getImage().getScaledInstance(100, 100, 0);
		JButton helpBtn = new JButton();
		helpBtn = new JButton(new ImageIcon(help));
		//도움말 버튼 크기,위치 조정
		helpBtn.setSize(100,100);
		helpBtn.setLocation(1380, 650);

		//패널에 메인 배경 부착
		mainPanel.add(mainLb);
		mainPanel.add(helpBtn);
		mainPanel.add(startBtn);
        
		
		//메인 라벨 우선 순위 마지막 배치
		mainPanel.setComponentZOrder(mainLb, 2);

		//컨터이너에 패널 부착
		this.add(mainPanel);

		mf=this;


		//화면 출력 및 종료 버튼 클릭 반응
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//도움말 클릭시 반응 추가
		startBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//마우스 왼쪽 클릭만 입력 될 시
				if(e.getButton()==1) { 
					JPanel subPanel1 = new JPanel();
					subPanel1.setBounds(0, 0, 1500, 800);
					subPanel1.setLayout(null);
					
					Image yut1 = new ImageIcon("mini/움직 라이언.GIF").getImage().getScaledInstance(300, 300, 0);
					JLabel yut = new JLabel(new ImageIcon(yut1));
					yut.setSize(300, 300);
					yut.setLocation(1170, 150);
					

					mf.remove(mainPanel);
					
					subPanel1.add(yut);
					subPanel1.revalidate();
				    subPanel1.repaint();
					subPanel1.setComponentZOrder(yut, 0);
					
					mf.add(subPanel1);
					mf.revalidate();
					mf.repaint();

					Timer ts = new Timer();
					TimerTask tk = new TimerTask() {

						@Override
						public void run() {

							subPanel1.remove(yut);
							subPanel1.revalidate();
							subPanel1.repaint();
							PlayerPage page = new PlayerPage(mf, mainPanel, subPanel1);

						}
					};
					ts.schedule(tk, 3000);
					
					//PlayerPage page = new PlayerPage(mf, mainPanel);
					
				}
			}

		});

		helpBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//마우스 왼쪽 클릭만 입력 될 시
				if(e.getButton()==1) { 
					Help hp = new Help(mf);
				
				}
			}

		});



	}


}
