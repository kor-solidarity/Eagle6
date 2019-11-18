package yut.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import yut.model.vo.Player;

public class PlayerPage  {
	private Player player = new Player("ㄴㄴㄴ", "ㄴㄴㄴㄴ");

	
	public PlayerPage(MainFrame mf , JPanel panel,JPanel sb) {
		//메인 패널 부착 제거
		
		
		mf.remove(sb);
		
		//선택창 패널 제작 
		JPanel subPanel = new JPanel();
		subPanel.setBounds(0, 0, 1500, 800);
		subPanel.setLayout(null);
		
		
		
		
		//유저 정보 입력 라벨로 변경
	    Image main2 = new ImageIcon("mini/유저입력창.PNG").getImage().getScaledInstance(1500, 770, 0);
	    JLabel mainLb2 = new JLabel();
	    mainLb2 = new JLabel(new ImageIcon(main2));
	    //메인 라벨 크기 조정
	    mainLb2.setSize(1500,770);
	    
	    //윷놀이 게임 시작 버튼  생성
	    Image game = new ImageIcon("mini/스타트 선택창.PNG").getImage().getScaledInstance(220, 220, 0);
	    JButton gameBtn = new JButton();
	    gameBtn = new JButton(new ImageIcon(game));
	    //도움말 버튼 크기,위치 조정
	    gameBtn.setSize(220,220);
	    gameBtn.setLocation(1270, 530);
	    
	    Image back = new ImageIcon("mini/뒤로가기.PNG").getImage().getScaledInstance(200, 200, 0);
	    JLabel backBtn = new JLabel();
	    backBtn = new JLabel(new ImageIcon(back));
	    backBtn.setSize(200,200);
	    backBtn.setLocation(-50,600);
		
	   
		//패널의 선택창 라벨 씌우기
	    subPanel.add(backBtn);
	    subPanel.add(gameBtn);
	    subPanel.add(mainLb2);
		//데이터 새로고침
		subPanel.revalidate();
		//적용
		subPanel.repaint();
		
		
		//선택창 패널 부착
		mf.add(subPanel);
		mf.revalidate();
		mf.repaint();
		mf.setVisible(true);
		
		
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
	    	public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					mf.remove(subPanel);
					mf.add(panel);
					mf.revalidate();
					mf.repaint();
				}
			}
		});
		
		//게임시작 버튼 활성
		gameBtn.addMouseListener(new MouseAdapter() {
			@Override
	    	public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
					
					GamePage gm = new GamePage(mf, subPanel,player);
					
				}
			}
		});
		
		
		
		
	}
}
