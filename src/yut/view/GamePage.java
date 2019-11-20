package yut.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import yut.controller.GameManager;
import yut.model.vo.Apeach;
import yut.model.vo.Frodo;
import yut.model.vo.Item;
import yut.model.vo.Mission;
import yut.model.vo.Neo;
import yut.model.vo.Player;
import yut.model.vo.Ryan;
import yut.model.vo.Store;
import yut.model.vo.Mal;

public class GamePage {
    public static int YUTGAP;//YutMadeByCho에서 윷값 받을 수 있는 전역변수

    public Player[] players;

    // 현재 턴인 플레이어
    public Player player;

    // 현재 어떤게 클릭된 상태인가?
    public static int SELECTED_BUTTON = 0;
    // 선택된 말
    public int selected_mal = -1;

    public JTextField show_ryan_name;
    public JTextField show_ryan_songP;
    public JTextField show_apeach_songP;
    public JTextField show_frodo_songP;
    public JTextField show_neo_songP;

    // 라이언 말 1
    public JLabel ryan_body_label1;
    public JLabel ryan_body_label2;
    public JLabel ryan_body_label3;
    public JLabel ryan_body_label4;
    public JLabel apeach_body_label1;
    public JLabel apeach_body_label2;
    public JLabel apeach_body_label3;
    public JLabel apeach_body_label4;
    public JLabel frodo_body_label1;
    public JLabel frodo_body_label2;
    public JLabel frodo_body_label3;
    public JLabel frodo_body_label4;
    public JLabel neo_body_label1;
    public JLabel neo_body_label2;
    public JLabel neo_body_label3;
    public JLabel neo_body_label4;


    public JLabel[][] mals = new JLabel[4][4];
    //말 배열


    //게임 패널생성
    public JPanel gamePanel;


    public GamePage(MainFrame mf, JPanel panel, JPanel lo, Player[] players/*,Player player*/) {
        this.players = players;

        System.out.println("entering GamePage");
        //로딩 패널 제거
        mf.remove(lo);
        //게임 패널생성
        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 1500, 800);
        gamePanel.setLayout(null);

        Mission ms = new Mission(mf, gamePanel);
        //도움말 버튼  생성
        Image help = new ImageIcon("mini/도움말 게임.PNG").getImage().getScaledInstance(60, 60, 0);
        JButton helpBtn = new JButton();
        helpBtn = new JButton(new ImageIcon(help));
        //도움말 버튼 크기,위치 조정
        helpBtn.setSize(60, 60);
        helpBtn.setLocation(1130, 450);

        //종료 버튼  생성
        Image end = new ImageIcon("mini/창버튼.PNG").getImage().getScaledInstance(40, 40, 0);
        JButton endBtn = new JButton();
        endBtn = new JButton(new ImageIcon(end));
        endBtn.setSize(40, 40);
        endBtn.setLocation(1445, 0);
        gamePanel.setComponentZOrder(endBtn, 0);

        //스토어 라벨생성
        Image store = new ImageIcon("mini/스토어.PNG").getImage().getScaledInstance(370, 220, 0);
        JLabel store1 = new JLabel();
        store1 = new JLabel(new ImageIcon(store));
        store1.setSize(370, 220);
        store1.setLocation(1110, 530);

        //스킬 2번 생성 예시
        Image skil2 = new ImageIcon("mini/모도스킬.PNG").getImage().getScaledInstance(80, 80, 0);
        JButton skilBtn2 = new JButton();
        skilBtn2 = new JButton(new ImageIcon(skil2));
        skilBtn2.setSize(80, 80);
        skilBtn2.setLocation(1370, 660);


        //스킬 3번 생성 예시
        Image skil3 = new ImageIcon("mini/벽.PNG").getImage().getScaledInstance(80, 80, 0);
        JButton skilBtn3 = new JButton();
        skilBtn3 = new JButton(new ImageIcon(skil3));
        skilBtn3.setSize(80, 80);
        skilBtn3.setLocation(1260, 660);

        //스킬 4번 생성 예시
        Image skil4 = new ImageIcon("mini/폭탄.PNG").getImage().getScaledInstance(80, 80, 0);
        JButton skilBtn4 = new JButton();
        skilBtn4 = new JButton(new ImageIcon(skil4));
        skilBtn4.setSize(80, 80);
        skilBtn4.setLocation(1150, 660);

        //스킬 5번 생성 예시
        Image skil5 = new ImageIcon("mini/빽도스킬.PNG").getImage().getScaledInstance(80, 80, 0);
        JButton skilBtn5 = new JButton();
        skilBtn5 = new JButton(new ImageIcon(skil5));
        skilBtn5.setSize(80, 80);
        skilBtn5.setLocation(1150, 560);

        //게임 화면에 백그라운드 배경
        Image mainGround = new ImageIcon("mini/판떼기.PNG").getImage().getScaledInstance(1500, 800, 0);
        JLabel mainBackGround = new JLabel(new ImageIcon(mainGround));
        mainBackGround.setSize(1500, 800);

        //윷 백그라운드
        Image yutGround = new ImageIcon("mini/윷판.PNG").getImage().getScaledInstance(300, 300, 0);
        JLabel yutBackGround = new JLabel(new ImageIcon(yutGround));
        yutBackGround.setSize(300, 300);
        yutBackGround.setLocation(1170, 150);


        //윷던지기 버튼
        Image yutThrow = new ImageIcon("mini/윷던지기.PNG").getImage().getScaledInstance(250, 60, 0);
        JButton yutThrow1 = new JButton(new ImageIcon(yutThrow));
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
        grid1.setLocation(970, 490);
        //흰색송편 grid =2
        JLabel grid2 = new JLabel(new ImageIcon(white));
        grid2.setSize(140, 140);
        grid2.setLocation(970, 380);
        //흰색송편 grid =3
        JLabel grid3 = new JLabel(new ImageIcon(white));
        grid3.setSize(140, 140);
        grid3.setLocation(970, 270);
        //흰색송편 grid =4
        JLabel grid4 = new JLabel(new ImageIcon(white));
        grid4.setSize(140, 140);
        grid4.setLocation(970, 160);
        //콘 grid =5
        Image con = new ImageIcon("mini/con1.PNG").getImage().getScaledInstance(220, 220, 0);
        JLabel grid5 = new JLabel(new ImageIcon(con));
        grid5.setSize(220, 220);
        grid5.setLocation(930, 0);

        //분홍송편 grid =6
        Image pink = new ImageIcon("mini/분홍송편.PNG").getImage().getScaledInstance(190, 190, 0);
        JLabel grid6 = new JLabel(new ImageIcon(pink));
        grid6.setSize(190, 190);
        grid6.setLocation(810, 30);
        //분홍송편 grid =7
        JLabel grid7 = new JLabel(new ImageIcon(pink));
        grid7.setSize(190, 190);
        grid7.setLocation(690, 30);
        //분홍송편 grid =8
        JLabel grid8 = new JLabel(new ImageIcon(pink));
        grid8.setSize(190, 190);
        grid8.setLocation(570, 30);
        //분홍송편 grid =9
        JLabel grid9 = new JLabel(new ImageIcon(pink));
        grid9.setSize(190, 190);
        grid9.setLocation(450, 30);

        //제이지 grid =10
        Image jayg = new ImageIcon("mini/jayg.PNG").getImage().getScaledInstance(180, 180, 0);
        JLabel grid10 = new JLabel(new ImageIcon(jayg));
        grid10.setSize(180, 180);
        grid10.setLocation(310, 10);
        //초록송편 grid =11
        Image green = new ImageIcon("mini/초록송편.PNG").getImage().getScaledInstance(130, 130, 0);
        JLabel grid11 = new JLabel(new ImageIcon(green));
        grid11.setSize(130, 130);
        grid11.setLocation(340, 170);
        //초록송편 grid =12
        JLabel grid12 = new JLabel(new ImageIcon(green));
        grid12.setSize(130, 130);
        grid12.setLocation(340, 280);
        //초록송편 grid =13
        JLabel grid13 = new JLabel(new ImageIcon(green));
        grid13.setSize(130, 130);
        grid13.setLocation(340, 390);
        //초록송편 grid =14
        JLabel grid14 = new JLabel(new ImageIcon(green));
        grid14.setSize(130, 130);
        grid14.setLocation(340, 500);

        //튜브 grid =15
        Image tube = new ImageIcon("mini/tube.PNG").getImage().getScaledInstance(180, 180, 0);
        JLabel grid15 = new JLabel(new ImageIcon(tube));
        grid15.setSize(180, 180);
        grid15.setLocation(300, 600);
        //보라송편 grid =16
        Image purple = new ImageIcon("mini/보라송편.PNG").getImage().getScaledInstance(110, 110, 0);
        JLabel grid16 = new JLabel(new ImageIcon(purple));
        grid16.setSize(110, 110);
        grid16.setLocation(470, 640);
        //보라송편 grid =17
        JLabel grid17 = new JLabel(new ImageIcon(purple));
        grid17.setSize(110, 110);
        grid17.setLocation(600, 640);
        //보라송편 grid =18
        JLabel grid18 = new JLabel(new ImageIcon(purple));
        grid18.setSize(110, 110);
        grid18.setLocation(730, 640);
        //보라송편 grid =19
        JLabel grid19 = new JLabel(new ImageIcon(purple));
        grid19.setSize(110, 110);
        grid19.setLocation(860, 640);

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


        //jtextfield 글꼴 변경하는 객체 생성
        Font font = new Font("arian", Font.BOLD, 20);
        Font font2 = new Font("arian", Font.BOLD, 20);


        //플레이어 상태창 배경
        //ryan 배경
        //보라색>노란색으로 변경
        Image purple1 = new ImageIcon("mini/pan.PNG").getImage().getScaledInstance(300, 197, 0);
        JLabel backgroundPurple1 = new JLabel(new ImageIcon(purple1));
        backgroundPurple1.setSize(300, 186);
        backgroundPurple1.setLocation(0, 0);
        //정보 헤드
        Image getGreen = new ImageIcon("mini/정보1.PNG").getImage().getScaledInstance(70, 95, 0);
        JLabel info1 = new JLabel(new ImageIcon(getGreen));
        info1.setSize(100, 100);
        info1.setLocation(100, 10);
        //송편,아이디 표시 필드
        //후에 setText 변경
        //송편 text 표시

        if (players[0] != null) {
            //라이언 송편표시
            show_ryan_songP = new JTextField(15);
            String str1 = Integer.valueOf(players[0].getSongP()).toString();
            show_ryan_songP.setEditable(false);
            panel.add(show_ryan_songP);
            show_ryan_songP.setText(str1);
            show_ryan_songP.setSize(110, 40);
            show_ryan_songP.setLocation(190, 55);
            show_ryan_songP.setFont(font);
            //닉네임 표시
            //라이언 닉네임 표시
            show_ryan_name = new JTextField(15);
            // String str1_n = "라이언";
            show_ryan_name.setEditable(false);
            panel.add(show_ryan_name);
            show_ryan_name.setText(players[0].getNick());
            show_ryan_name.setSize(110, 40);
            show_ryan_name.setLocation(190, 5);
            show_ryan_name.setFont(font2);
            //라이언 머리
            Image ryan_head = new ImageIcon("mini/ryan1.PNG").getImage().getScaledInstance(110, 110, 0);
            JLabel ryan_head_label = new JLabel(new ImageIcon(ryan_head));
            ryan_head_label.setSize(105, 105);
            ryan_head_label.setLocation(0, 10);
            //라이언 도착 몸통
            Image ryan_bodyx = new ImageIcon("mini/x라이언말.PNG").getImage().getScaledInstance(80, 80, 0);
            JLabel ryan_body_labelx1 = new JLabel(new ImageIcon(ryan_bodyx));
            ryan_body_labelx1.setSize(100, 100);
            ryan_body_labelx1.setLocation(1, 99);
            JLabel ryan_body_labelx2 = new JLabel(new ImageIcon(ryan_bodyx));
            ryan_body_labelx2.setSize(100, 100);
            ryan_body_labelx2.setLocation(71, 99);
            JLabel ryan_body_labelx3 = new JLabel(new ImageIcon(ryan_bodyx));
            ryan_body_labelx3.setSize(100, 100);
            ryan_body_labelx3.setLocation(141, 99);
            JLabel ryan_body_labelx4 = new JLabel(new ImageIcon(ryan_bodyx));
            ryan_body_labelx4.setSize(100, 100);
            ryan_body_labelx4.setLocation(211, 99);
            //라이언 몸통
            Image ryan_body1 = new ImageIcon("mini/1번라이언말.PNG").getImage().getScaledInstance(80, 80, 0);
            ryan_body_label1 = new JLabel(new ImageIcon(ryan_body1));
            System.out.println("ryan_body_label1 " + ryan_body_label1);
            System.out.println(mals[0]);
            System.out.println(mals[0][0] == ryan_body_label1);
            System.out.println(mals[0][0]);
            ryan_body_label1.setSize(100, 100);
            ryan_body_label1.setLocation(1, 99);
            Image ryan_body2 = new ImageIcon("mini/2번라이언말.PNG").getImage().getScaledInstance(80, 80, 0);
            ryan_body_label2 = new JLabel(new ImageIcon(ryan_body2));
            ryan_body_label2.setSize(100, 100);
            ryan_body_label2.setLocation(71, 99);
            Image ryan_body3 = new ImageIcon("mini/3번라이언말.PNG").getImage().getScaledInstance(80, 80, 0);
            ryan_body_label3 = new JLabel(new ImageIcon(ryan_body3));
            ryan_body_label3.setSize(100, 100);
            ryan_body_label3.setLocation(141, 99);
            Image ryan_body4 = new ImageIcon("mini/4번라이언말.PNG").getImage().getScaledInstance(80, 80, 0);
            ryan_body_label4 = new JLabel(new ImageIcon(ryan_body4));
            ryan_body_label4.setSize(100, 100);
            ryan_body_label4.setLocation(211, 99);
            //라이언 출발 몸통
            Image ryan_body1_s = new ImageIcon("mini/1번라이언말출격.PNG").getImage().getScaledInstance(80, 80, 0);
            JLabel ryan_body_label1_s = new JLabel(new ImageIcon(ryan_body1_s));
            ryan_body_label1_s.setSize(100, 100);
            ryan_body_label1_s.setLocation(1, 99);
            players[0].getMals()[0].setInit_xy(1, 99);
            Image ryan_body2_s = new ImageIcon("mini/2번라이언말출격.PNG").getImage().getScaledInstance(80, 80, 0);
            JLabel ryan_body_label2_s = new JLabel(new ImageIcon(ryan_body2_s));
            ryan_body_label2_s.setSize(100, 100);
            ryan_body_label2_s.setLocation(71, 99);
            players[0].getMals()[1].setInit_xy(71, 99);
            Image ryan_body3_s = new ImageIcon("mini/3번라이언말출격.PNG").getImage().getScaledInstance(80, 80, 0);
            JLabel ryan_body_label3_s = new JLabel(new ImageIcon(ryan_body3_s));
            ryan_body_label3_s.setSize(100, 100);
            ryan_body_label3_s.setLocation(141, 99);
            players[0].getMals()[2].setInit_xy(141, 99);
            Image ryan_body4_s = new ImageIcon("mini/4번라이언말출격.PNG").getImage().getScaledInstance(80, 80, 0);
            JLabel ryan_body_label4_s = new JLabel(new ImageIcon(ryan_body4_s));
            ryan_body_label4_s.setSize(100, 100);
            ryan_body_label4_s.setLocation(211, 99);
            players[0].getMals()[3].setInit_xy(211, 99);


            //종철 - 플레이어 정보 입력시 표시되도록 추후 수정(플레이어 이름, 말 상황변화, 송편수, 패널표시)
            //ryan
            gamePanel.add(ryan_head_label);
            gamePanel.add(info1);
            gamePanel.add(show_ryan_name);
            gamePanel.add(show_ryan_songP);
            //그리드값 조건으로 활성화
            // gamePanel.add(ryan_body_labelx1);
            // gamePanel.add(ryan_body_labelx2);
            // gamePanel.add(ryan_body_labelx3);
            // gamePanel.add(ryan_body_labelx4);
            gamePanel.add(ryan_body_label1);
            gamePanel.add(ryan_body_label2);
            gamePanel.add(ryan_body_label3);
            gamePanel.add(ryan_body_label4);
            gamePanel.add(ryan_body_label1_s);
            gamePanel.add(ryan_body_label2_s);
            gamePanel.add(ryan_body_label3_s);
            gamePanel.add(ryan_body_label4_s);
            gamePanel.add(backgroundPurple1);
            
            //@@@@@@@@@@@@@중복된주석 삭제해주세요@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            //@PlayerNum -플레이어 배열번호
            //@move_num - 이동해야할 값
            //@mals - 게임 내 모든 말의 라벨
            //@gp -게임페이지 그자체

            // 말 누르기.
            ryan_body_label1.addMouseListener(new MouseAdapter() {
                @Override
                // 클릭하는 경우:
                // 1. 윷버튼이 클릭된 경우 그 값에 맞게 이동한다.
                // 2. 클릭이 안된 경우 말만 선택된걸로 본다.
                public void mouseClicked(MouseEvent e) {
                    // 우선은 위 절차 무시하고 이동만.
                    if (e.getButton() == 1) {
                        // gamePanel.remove(ryan_body_label1);
                        // gamePanel.repaint();
                        // 시연이기에 개를 가정.

                        players[0].getMals()[0].move(0, YUTGAP, mals, Outer());
                        // players[0].getMals()[0].move(YUTGAP, Outer());

                    }
                }
            });
            ryan_body_label2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[0].getMals()[1].move(0, YUTGAP, mals, Outer());
                    }
                }
            });
            ryan_body_label3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[0].getMals()[2].move(0, YUTGAP, mals, Outer());
                    }
                }
            });
            ryan_body_label4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[0].getMals()[3].move(0, YUTGAP, mals, Outer());
                    }
                }
            });

        }

        if (players[1] != null) {

            //apeach 배경
            JLabel backgroundPurple2 = new JLabel(new ImageIcon(purple1));
            backgroundPurple2.setSize(300, 186);
            backgroundPurple2.setLocation(0, 189);
            JLabel info2 = new JLabel(new ImageIcon(getGreen));
            info2.setSize(100, 100);
            info2.setLocation(100, 199);
            //어피치 송편표시
            show_apeach_songP = new JTextField(15);
            String str2 = Integer.valueOf(players[1].getSongP()).toString();
            show_apeach_songP.setEditable(false);
            panel.add(show_apeach_songP);
            show_apeach_songP.setText(str2);
            show_apeach_songP.setSize(110, 40);
            show_apeach_songP.setLocation(190, 244);
            show_apeach_songP.setFont(font);
            //어피치 닉네임 표시
            JTextField show_apeach_name = new JTextField(15);
            // String str2_n = "어피치";
            show_apeach_name.setEditable(false);
            panel.add(show_apeach_songP);
            show_apeach_name.setText(players[1].getNick());
            show_apeach_name.setSize(110, 40);
            show_apeach_name.setLocation(190, 194);
            show_apeach_name.setFont(font2);
            //어피치 머리
            Image apeach_head = new ImageIcon("mini/apeach1.PNG").getImage().getScaledInstance(100, 100, 0);
            JLabel apeach_head_label = new JLabel(new ImageIcon(apeach_head));
            apeach_head_label.setSize(100, 100);
            apeach_head_label.setLocation(10, 199);
            //어피치 도착 몸통
            Image apeach_bodyx = new ImageIcon("mini/x어피치말.PNG").getImage().getScaledInstance(120, 120, 0);
            JLabel apeach_body_labelx1 = new JLabel(new ImageIcon(apeach_bodyx));
            apeach_body_labelx1.setSize(100, 100);
            apeach_body_labelx1.setLocation(1, 288);
            players[1].getMals()[0].setInit_xy(1, 288);
            JLabel apeach_body_labelx2 = new JLabel(new ImageIcon(apeach_bodyx));
            apeach_body_labelx2.setSize(100, 100);
            apeach_body_labelx2.setLocation(71, 288);
            players[1].getMals()[1].setInit_xy(71, 288);
            JLabel apeach_body_labelx3 = new JLabel(new ImageIcon(apeach_bodyx));
            apeach_body_labelx3.setSize(100, 100);
            apeach_body_labelx3.setLocation(141, 288);
            players[1].getMals()[2].setInit_xy(141, 288);
            JLabel apeach_body_labelx4 = new JLabel(new ImageIcon(apeach_bodyx));
            apeach_body_labelx4.setSize(100, 100);
            apeach_body_labelx4.setLocation(211, 288);
            players[1].getMals()[3].setInit_xy(211, 288);
            //어피치 몸통
            Image apeach_body1 = new ImageIcon("mini/1번어피치말.PNG").getImage().getScaledInstance(120, 120, 0);
            apeach_body_label1 = new JLabel(new ImageIcon(apeach_body1));
            apeach_body_label1.setSize(100, 100);
            apeach_body_label1.setLocation(1, 288);
            Image apeach_body2 = new ImageIcon("mini/2번어피치말.PNG").getImage().getScaledInstance(120, 120, 0);
            apeach_body_label2 = new JLabel(new ImageIcon(apeach_body2));
            apeach_body_label2.setSize(100, 100);
            apeach_body_label2.setLocation(71, 288);
            Image apeach_body3 = new ImageIcon("mini/3번어피치말.PNG").getImage().getScaledInstance(120, 120, 0);
            apeach_body_label3 = new JLabel(new ImageIcon(apeach_body3));
            apeach_body_label3.setSize(100, 100);
            apeach_body_label3.setLocation(141, 288);
            Image apeach_body4 = new ImageIcon("mini/4번어피치말.PNG").getImage().getScaledInstance(120, 120, 0);
            apeach_body_label4 = new JLabel(new ImageIcon(apeach_body4));
            apeach_body_label4.setSize(100, 100);
            apeach_body_label4.setLocation(211, 288);
            //어피치 출격 몸통
            Image apeach_body1_s = new ImageIcon("mini/1번어피치말출격.PNG").getImage().getScaledInstance(120, 120, 0);
            JLabel apeach_body_label1_s = new JLabel(new ImageIcon(apeach_body1_s));
            apeach_body_label1_s.setSize(100, 100);
            apeach_body_label1_s.setLocation(1, 288);
            Image apeach_body2_s = new ImageIcon("mini/2번어피치말출격.PNG").getImage().getScaledInstance(120, 120, 0);
            JLabel apeach_body_label2_s = new JLabel(new ImageIcon(apeach_body2_s));
            apeach_body_label2_s.setSize(100, 100);
            apeach_body_label2_s.setLocation(71, 288);
            Image apeach_body3_s = new ImageIcon("mini/3번어피치말출격.PNG").getImage().getScaledInstance(120, 120, 0);
            JLabel apeach_body_label3_s = new JLabel(new ImageIcon(apeach_body3_s));
            apeach_body_label3_s.setSize(100, 100);
            apeach_body_label3_s.setLocation(141, 288);
            Image apeach_body4_s = new ImageIcon("mini/4번어피치말출격.PNG").getImage().getScaledInstance(120, 120, 0);
            JLabel apeach_body_label4_s = new JLabel(new ImageIcon(apeach_body4_s));
            apeach_body_label4_s.setSize(100, 100);
            apeach_body_label4_s.setLocation(211, 288);


            //apeach
            gamePanel.add(apeach_head_label);
            gamePanel.add(info2);
            gamePanel.add(show_apeach_name);
            gamePanel.add(show_apeach_songP);
            //그리드값 조건으로 활성화
		/*		gamePanel.add(apeach_body_labelx1);
		gamePanel.add(apeach_body_labelx2);
		gamePanel.add(apeach_body_labelx3);
		gamePanel.add(apeach_body_labelx4);*/
            gamePanel.add(apeach_body_label1);
            gamePanel.add(apeach_body_label2);
            gamePanel.add(apeach_body_label3);
            gamePanel.add(apeach_body_label4);
            gamePanel.add(apeach_body_label1_s);
            gamePanel.add(apeach_body_label2_s);
            gamePanel.add(apeach_body_label3_s);
            gamePanel.add(apeach_body_label4_s);
            gamePanel.add(backgroundPurple2);


            apeach_body_label1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[1].getMals()[0].move(1, YUTGAP, mals, Outer());                    }
                }
            });
            apeach_body_label2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[1].getMals()[1].move(1, YUTGAP, mals, Outer()); 
                    }
                }
            });
            apeach_body_label3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[1].getMals()[2].move(1, YUTGAP, mals, Outer()); 
                    }
                }
            });
            apeach_body_label4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[1].getMals()[3].move(1, YUTGAP, mals, Outer()); 
                    }
                }
            });


        }
        if (players[2] != null) {
            //frodo 배경
            JLabel backgroundPurple3 = new JLabel(new ImageIcon(purple1));
            backgroundPurple3.setSize(300, 186);
            backgroundPurple3.setLocation(0, 378);
            JLabel info3 = new JLabel(new ImageIcon(getGreen));
            info3.setSize(100, 100);
            info3.setLocation(100, 388);
            //프로도 송편표시
            show_frodo_songP = new JTextField(15);
            String str3 = Integer.valueOf(players[2].getSongP()).toString();
            show_frodo_songP.setEditable(false);
            panel.add(show_frodo_songP);
            show_frodo_songP.setText(str3);
            show_frodo_songP.setSize(110, 40);
            show_frodo_songP.setLocation(190, 433);
            show_frodo_songP.setFont(font);
            //프로도 닉네임 표시
            JTextField show_frodo_name = new JTextField(15);
            // String str3_n = "프로도";
            show_frodo_name.setEditable(false);
            panel.add(show_frodo_name);
            show_frodo_name.setText(players[2].getNick());
            show_frodo_name.setSize(110, 40);
            show_frodo_name.setLocation(190, 383);
            show_frodo_name.setFont(font2);

            //프로도 머리
            Image frodo_head = new ImageIcon("mini/frodo1.PNG").getImage().getScaledInstance(100, 100, 0);
            JLabel frodo_head_label = new JLabel(new ImageIcon(frodo_head));
            frodo_head_label.setSize(100, 100);
            frodo_head_label.setLocation(10, 388);
            //프로도 도착 몸통
            Image frodo_bodyx = new ImageIcon("mini/x프로도말.PNG").getImage().getScaledInstance(100, 100, 0);
            JLabel frodo_body_labelx1 = new JLabel(new ImageIcon(frodo_bodyx));
            frodo_body_labelx1.setSize(100, 100);
            frodo_body_labelx1.setLocation(1, 477);
            players[2].getMals()[0].setInit_xy(1, 477);
            JLabel frodo_body_labelx2 = new JLabel(new ImageIcon(frodo_bodyx));
            frodo_body_labelx2.setSize(100, 100);
            frodo_body_labelx2.setLocation(71, 477);
            players[2].getMals()[1].setInit_xy(71, 477);
            JLabel frodo_body_labelx3 = new JLabel(new ImageIcon(frodo_bodyx));
            frodo_body_labelx3.setSize(100, 100);
            frodo_body_labelx3.setLocation(141, 477);
            players[2].getMals()[2].setInit_xy(141, 477);
            JLabel frodo_body_labelx4 = new JLabel(new ImageIcon(frodo_bodyx));
            frodo_body_labelx4.setSize(100, 100);
            frodo_body_labelx4.setLocation(211, 477);
            players[2].getMals()[3].setInit_xy(211, 477);
            //프로도 몸통
            Image frodo_body1 = new ImageIcon("mini/1번프로도말.PNG").getImage().getScaledInstance(100, 100, 0);
            frodo_body_label1 = new JLabel(new ImageIcon(frodo_body1));
            frodo_body_label1.setSize(100, 100);
            frodo_body_label1.setLocation(1, 477);
            Image frodo_body2 = new ImageIcon("mini/2번프로도말.PNG").getImage().getScaledInstance(100, 100, 0);
            frodo_body_label2 = new JLabel(new ImageIcon(frodo_body2));
            frodo_body_label2.setSize(100, 100);
            frodo_body_label2.setLocation(71, 477);
            Image frodo_body3 = new ImageIcon("mini/3번프로도말.PNG").getImage().getScaledInstance(100, 100, 0);
            frodo_body_label3 = new JLabel(new ImageIcon(frodo_body3));
            frodo_body_label3.setSize(100, 100);
            frodo_body_label3.setLocation(141, 477);
            Image frodo_body4 = new ImageIcon("mini/4번프로도말.PNG").getImage().getScaledInstance(100, 100, 0);
            frodo_body_label4 = new JLabel(new ImageIcon(frodo_body4));
            frodo_body_label4.setSize(100, 100);
            frodo_body_label4.setLocation(211, 477);
            //프로도 출격 몸통
            Image frodo_body1_s = new ImageIcon("mini/1번프로도말출격.PNG").getImage().getScaledInstance(100, 100, 0);
            JLabel frodo_body_label1_s = new JLabel(new ImageIcon(frodo_body1_s));
            frodo_body_label1_s.setSize(100, 100);
            frodo_body_label1_s.setLocation(1, 477);
            Image frodo_body2_s = new ImageIcon("mini/2번프로도말 출격.PNG").getImage().getScaledInstance(100, 100, 0);
            JLabel frodo_body_label2_s = new JLabel(new ImageIcon(frodo_body2_s));
            frodo_body_label2_s.setSize(100, 100);
            frodo_body_label2_s.setLocation(71, 477);
            Image frodo_body3_s = new ImageIcon("mini/3번프로도말출격.PNG").getImage().getScaledInstance(100, 100, 0);
            JLabel frodo_body_label3_s = new JLabel(new ImageIcon(frodo_body3_s));
            frodo_body_label3_s.setSize(100, 100);
            frodo_body_label3_s.setLocation(141, 477);
            Image frodo_body4_s = new ImageIcon("mini/4번프로도말출격.PNG").getImage().getScaledInstance(100, 100, 0);
            JLabel frodo_body_label4_s = new JLabel(new ImageIcon(frodo_body4_s));
            frodo_body_label4_s.setSize(100, 100);
            frodo_body_label4_s.setLocation(211, 477);


            //frodo
            gamePanel.add(frodo_head_label);
            gamePanel.add(info3);
            gamePanel.add(show_frodo_name);
            gamePanel.add(show_frodo_songP);
            //그리드값 조건으로 활성화
/*		gamePanel.add(frodo_body_labelx1);
		gamePanel.add(frodo_body_labelx2);
		gamePanel.add(frodo_body_labelx3);
		gamePanel.add(frodo_body_labelx4);*/
            gamePanel.add(frodo_body_label1);
            gamePanel.add(frodo_body_label2);
            gamePanel.add(frodo_body_label3);
            gamePanel.add(frodo_body_label4);
            gamePanel.add(frodo_body_label1_s);
            gamePanel.add(frodo_body_label2_s);
            gamePanel.add(frodo_body_label3_s);
            gamePanel.add(frodo_body_label4_s);
            gamePanel.add(backgroundPurple3);


            frodo_body_label1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                    }
                    players[2].getMals()[0].move(2, YUTGAP, mals, Outer()); 
                }
            });
            frodo_body_label2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[2].getMals()[1].move(2, YUTGAP, mals, Outer()); 
                        }
                }
            });
            frodo_body_label3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[2].getMals()[2].move(2, YUTGAP, mals, Outer()); 
                    }
                }
            });
            frodo_body_label4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[2].getMals()[3].move(2, YUTGAP, mals, Outer()); 
                    }
                    
                }
            });


        }
        if (players[3] != null) {
            //neo 배경
            JLabel backgroundPurple4 = new JLabel(new ImageIcon(purple1));
            backgroundPurple4.setSize(300, 186);
            backgroundPurple4.setLocation(0, 567);
            JLabel info4 = new JLabel(new ImageIcon(getGreen));
            info4.setSize(100, 100);
            info4.setLocation(100, 577);
            //네오 송편표시
            show_neo_songP = new JTextField(15);
            String str4 = Integer.valueOf(players[3].getSongP()).toString();
            show_neo_songP.setEditable(false);
            panel.add(show_neo_songP);
            show_neo_songP.setText(str4);
            show_neo_songP.setSize(110, 40);
            show_neo_songP.setLocation(190, 622);
            show_neo_songP.setFont(font);
            //네오 닉네임 표시
            JTextField show_neo_name = new JTextField(15);
            // String str4_n = "네오";
            show_neo_name.setEditable(false);
            panel.add(show_neo_name);
            show_neo_name.setText(players[3].getNick());
            show_neo_name.setSize(110, 40);
            show_neo_name.setLocation(190, 572);
            show_neo_name.setFont(font2);
            //네오 머리
            Image neo_head = new ImageIcon("mini/neo1.PNG").getImage().getScaledInstance(100, 100, 0);
            JLabel neo_head_label = new JLabel(new ImageIcon(neo_head));
            neo_head_label.setSize(100, 100);
            neo_head_label.setLocation(10, 577);
            //네오도착 몸통
            Image neo_bodyx = new ImageIcon("mini/x네오말.png").getImage().getScaledInstance(100, 100, 0);
            JLabel neo_body_labelx1 = new JLabel(new ImageIcon(neo_bodyx));
            neo_body_labelx1.setSize(100, 100);
            neo_body_labelx1.setLocation(1, 666);
            players[3].getMals()[0].setInit_xy(1, 666);
            JLabel neo_body_labelx2 = new JLabel(new ImageIcon(neo_bodyx));
            neo_body_labelx2.setSize(100, 100);
            neo_body_labelx2.setLocation(71, 666);
            players[3].getMals()[1].setInit_xy(71, 666);
            JLabel neo_body_labelx3 = new JLabel(new ImageIcon(neo_bodyx));
            neo_body_labelx3.setSize(100, 100);
            neo_body_labelx3.setLocation(141, 666);
            players[3].getMals()[2].setInit_xy(141, 666);
            JLabel neo_body_labelx4 = new JLabel(new ImageIcon(neo_bodyx));
            neo_body_labelx4.setSize(100, 100);
            neo_body_labelx4.setLocation(211, 666);
            players[3].getMals()[3].setInit_xy(211, 666);
            //네오 몸통
            Image neo_body1 = new ImageIcon("mini/1번네오말.png").getImage().getScaledInstance(100, 100, 0);
            neo_body_label1 = new JLabel(new ImageIcon(neo_body1));
            neo_body_label1.setSize(100, 100);
            neo_body_label1.setLocation(1, 666);
            Image neo_body2 = new ImageIcon("mini/2번네오말.png").getImage().getScaledInstance(100, 100, 0);
            neo_body_label2 = new JLabel(new ImageIcon(neo_body2));
            neo_body_label2.setSize(100, 100);
            neo_body_label2.setLocation(71, 666);
            Image neo_body3 = new ImageIcon("mini/3번네오말.png").getImage().getScaledInstance(100, 100, 0);
            neo_body_label3 = new JLabel(new ImageIcon(neo_body3));
            neo_body_label3.setSize(100, 100);
            neo_body_label3.setLocation(141, 666);
            Image neo_body4 = new ImageIcon("mini/4번네오말.png").getImage().getScaledInstance(100, 100, 0);
            neo_body_label4 = new JLabel(new ImageIcon(neo_body4));
            neo_body_label4.setSize(100, 100);
            neo_body_label4.setLocation(211, 666);
            //네오 출격 몸통
            Image neo_body1_s = new ImageIcon("mini/1번네오말출격.png").getImage().getScaledInstance(100, 100, 0);
            JLabel neo_body_label1_s = new JLabel(new ImageIcon(neo_body1_s));
            neo_body_label1_s.setSize(100, 100);
            neo_body_label1_s.setLocation(1, 666);
            Image neo_body2_s = new ImageIcon("mini/2번네오말출격.png").getImage().getScaledInstance(100, 100, 0);
            JLabel neo_body_label2_s = new JLabel(new ImageIcon(neo_body2_s));
            neo_body_label2_s.setSize(100, 100);
            neo_body_label2_s.setLocation(71, 666);
            Image neo_body3_s = new ImageIcon("mini/3번네오말출격.png").getImage().getScaledInstance(100, 100, 0);
            JLabel neo_body_label3_s = new JLabel(new ImageIcon(neo_body3_s));
            neo_body_label3_s.setSize(100, 100);
            neo_body_label3_s.setLocation(141, 666);
            Image neo_body4_s = new ImageIcon("mini/4번네오말출격.png").getImage().getScaledInstance(100, 100, 0);
            JLabel neo_body_label4_s = new JLabel(new ImageIcon(neo_body4_s));
            neo_body_label4_s.setSize(100, 100);
            neo_body_label4_s.setLocation(211, 666);

            //neo
            gamePanel.add(neo_head_label);
            gamePanel.add(info4);
            gamePanel.add(show_neo_name);
            gamePanel.add(show_neo_songP);
            //그리드값 조건으로 활성화
/*		gamePanel.add(neo_body_labelx1);
		gamePanel.add(neo_body_labelx2);
		gamePanel.add(neo_body_labelx3);
		gamePanel.add(neo_body_labelx4);*/
            gamePanel.add(neo_body_label1);
            gamePanel.add(neo_body_label2);
            gamePanel.add(neo_body_label3);
            gamePanel.add(neo_body_label4);
            gamePanel.add(neo_body_label1_s);
            gamePanel.add(neo_body_label2_s);
            gamePanel.add(neo_body_label3_s);
            gamePanel.add(neo_body_label4_s);
            gamePanel.add(backgroundPurple4);


            neo_body_label1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[3].getMals()[0].move(3, YUTGAP, mals, Outer()); 
                    }
                }
            });
            neo_body_label2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[3].getMals()[1].move(3, YUTGAP, mals, Outer()); 
                    }
                }
            });
            neo_body_label3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[3].getMals()[2].move(3, YUTGAP, mals, Outer()); 
                    }
                }
            });
            neo_body_label4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1) {
                        players[3].getMals()[3].move(3, YUTGAP, mals, Outer()); 
                    }
                }
            });
        }

        mals[0][0] =  ryan_body_label1;
        mals[0][1] =  ryan_body_label2;
        mals[0][2] =  ryan_body_label3;
        mals[0][3] =  ryan_body_label4;


        mals[1][0] =  apeach_body_label1;
        mals[1][1] =  apeach_body_label2;
        mals[1][2] =  apeach_body_label3;
        mals[1][3] =  apeach_body_label4;


        mals[2][0] =  frodo_body_label1;
        mals[2][1] =  frodo_body_label2;
        mals[2][2] =  frodo_body_label3;
        mals[2][3] =  frodo_body_label4;


        mals[3][0] =  neo_body_label1;
        mals[3][1] =  neo_body_label2;
        mals[3][2] =  neo_body_label3;
        mals[3][3] =  neo_body_label4;

        // {{ryan_body_label1, ryan_body_label2, ryan_body_label3, ryan_body_label4},
        //     {apeach_body_label1, apeach_body_label2, apeach_body_label3, apeach_body_label4},
        //     {frodo_body_label1, frodo_body_label2, frodo_body_label3, frodo_body_label4},
        //     {neo_body_label1, neo_body_label2, neo_body_label3, neo_body_label4}};


        //게임패널에 부착
        //스킬라벨

        gamePanel.add(skilBtn2);
        gamePanel.add(skilBtn3);
        gamePanel.add(skilBtn4);
        gamePanel.add(skilBtn5);
        gamePanel.add(store1);
        //종료 /도움말 라벨
        gamePanel.add(endBtn);
        gamePanel.add(helpBtn);

        //말판 라벨
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

        // gamePanel.add(testmal); //============테스트용=============== 좌표찾기 - 다영
        // gamePanel.setComponentZOrder(testmal, 0); //==========테스트용============ 좌표찾기 - 다영


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        gamePanel.add(yutBackGround);
        gamePanel.add(yutThrow1);
        gamePanel.add(mainBackGround);

        gamePanel.revalidate();
        gamePanel.repaint();

        mf.add(gamePanel);
        mf.revalidate();
        mf.repaint();

        //스킬 2번 사용시 반응 예시
        skilBtn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Store shop = new Store();
                    boolean buy_successful = shop.buy(mf, gamePanel, player, 2);
                    System.out.println(buy_successful);
                    if (buy_successful) {
                        SELECTED_BUTTON = 10;//moOrDo버튼번호
                        yutThrow1.doClick(50);
                    }
                    Outer().reload_songP(player);

                }
            }
        });


        //스킬 3번 사용시 반응 예시
        skilBtn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Store shop = new Store();

                    shop.buy(mf, gamePanel, player, 3);
                    Outer().reload_songP(player);
                }
            }
        });

        //스킬 4번(폭탄) 사용시 반응 예시
        // 이렇게 쓰면안됨
        // skilBtn4.addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //         if (e.getButton() == 1) {
        //
        //             ryan_body_label1.addMouseListener(new MouseAdapter() {
        //                 @Override
        //                 public void mouseClicked(MouseEvent e) {
        //                      int x = ryan_body_label1.getX();
        //                      int y = ryan_body_label1.getY();
        //                      Store shop = new Store();
        //                      shop.buy(mf, gamePanel, player,  4,x,y);
        //                 }
        //             });
        //
        //
        //         }
        //     }
        // });

        //스킬 5번(빽도) 사용시 반응
        skilBtn5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Store shop = new Store();
                    boolean buy_successful = shop.buy(mf, gamePanel, player, 5);
                    System.out.println(buy_successful);
                    if (buy_successful) {
                        SELECTED_BUTTON = 5;//backDo버튼번호
                        yutThrow1.doClick(50);
                    }
                    Outer().reload_songP(player);
                }
            }
        });

        //종료버튼 클릭시 메인 화면으로 복귀
        endBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    //종료 팝업창 다이얼로그 생성
                    JDialog ed = new JDialog();
                    ed.setSize(600, 600);
                    ed.setLocation(400, 400);
                    ed.setLayout(null);
                    try {
                        ed.setIconImage(ImageIO.read(new File("mini/윷타이틀.PNG")));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    Image end = new ImageIcon("mini/종료창.PNG").getImage().getScaledInstance(600, 600, 0);
                    JLabel endlb = new JLabel();
                    endlb = new JLabel(new ImageIcon(end));
                    //도움말 버튼 크기,위치 조정
                    endlb.setSize(600, 600);

                    //종료버튼 생성
                    Image end1 = new ImageIcon("mini/체크취소.PNG").getImage().getScaledInstance(100, 100, 0);
                    JLabel endBtn1 = new JLabel();
                    endBtn1 = new JLabel(new ImageIcon(end1));
                    //도움말 버튼 크기,위치 조정
                    endBtn1.setSize(100, 100);
                    endBtn1.setLocation(390, 430);
                    //체크 버튼 생성
                    Image check = new ImageIcon("mini/체크확인.PNG").getImage().getScaledInstance(100, 100, 0);
                    JLabel checkBtn = new JLabel();
                    checkBtn = new JLabel(new ImageIcon(check));
                    checkBtn.setSize(100, 100);
                    checkBtn.setLocation(100, 430);
                    //버튼 부착
                    ed.add(endBtn1);
                    ed.add(checkBtn);
                    ed.add(endlb);
                    ed.setVisible(true);

                    endBtn1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getButton() == 1) {
                                //종료 버튼 클릭시 다이얼로그창만 꺼준다
                                ed.dispose();
                            }
                        }
                    });

                    //체크 버튼 클릭시 다이얼로그를 종료하고 메인 화면으로 복귀
                    checkBtn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getButton() == 1) {
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
                if (e.getButton() == 1) {
                    Help hp = new Help(mf);
                }
            }
        });

        //윷 던지기 버튼을 눌럿을시 반응
        yutThrow1.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                if (player.getYutCount() > 0) {

                    System.out.println("클릭");
                    //윷 gif 파일 적용
                    //========조지연===========
                    //todo:버튼을 누르면 값을 저장할 arraylist를 생성하고 거기에 윷값을 넣어줘야함!!!!!!!!
                    //윷던지기 버튼 던질때 YutMadeByCho클래스 객체생성
                    YutMadeByCho throwYut = new YutMadeByCho();
//                        System.out.println("yutgap1이 값을 가지는지 확인"+yutgap1);

                    System.out.println("플레이어 남은 횟수 : " + player.getYutCount());
                    if (SELECTED_BUTTON == 10) {//아이템 moOrDo
                        System.out.println("모도아이템");
                        YUTGAP = throwYut.mainYut(2, player);
                        SELECTED_BUTTON = 0;
                        player.setYutCount(player.getYutCount() - 1);
                    } else if (SELECTED_BUTTON == 5) {//아이템백도
                        System.out.println("백도");
                        YUTGAP = throwYut.mainYut(5, player);
                        SELECTED_BUTTON = 0;
                        player.setYutCount(player.getYutCount() - 1);
                    } else if (SELECTED_BUTTON == 4) {//라이언패시브->버튼으로 받는거 아니라서 수정해야함
                        System.out.println("라이언 윷값*2패시브");
                        YUTGAP = throwYut.mainYut(4, player);
                        System.out.println("라이언패시브 확인");
                        SELECTED_BUTTON = 0;
                        player.setYutCount(player.getYutCount() - 1);
                    } else if (SELECTED_BUTTON == 8) {//네오윷값올리는 패시브->버튼으로 받는거 아니라서 수정해야함
                        System.out.println("네오 윷값올리는 패시브");
                        YUTGAP = throwYut.mainYut(3, player);
                        System.out.println("네오 확인");
                        SELECTED_BUTTON = 0;
                        player.setYutCount(player.getYutCount() - 1);
                    } else {
                        System.out.println("기본던지기");
                        YUTGAP = throwYut.mainYut(1, player);
                        SELECTED_BUTTON = 0;
                    }


                    //윷값이 낙이 나왔을때

                    System.out.println("yutgap " + YUTGAP);
                    // 낙인 경우 - 아무일 없이 끝
                    if (YUTGAP == 0) {
                        Image yut1 = new ImageIcon("mini/낙영상.GIF").getImage().getScaledInstance(300, 300, 0);
                        JLabel yut = new JLabel(new ImageIcon(yut1));
                        yut.setSize(300, 300);
                        yut.setLocation(1170, 150);

                        gamePanel.add(yut);
                        gamePanel.revalidate();
                        gamePanel.repaint();
                        gamePanel.setComponentZOrder(yut, 0);

                        Timer ts = new Timer();
                        // 타이머 관련 메소드 선언
                        TimerTask tk = new TimerTask() {

                            @Override
                            public void run() {

                                gamePanel.remove(yut);
                                gamePanel.revalidate();
                                gamePanel.repaint();

                            }
                        };
                        // delay 시간 이후 task 안 run() 수행
                        ts.schedule(tk, 2400);
                    }//윷값이 도가 나왔을때
                    else if (YUTGAP == 1) {
                        Image yut1 = new ImageIcon("mini/도.GIF").getImage().getScaledInstance(300, 300, 0);
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
                                Image dodo = new ImageIcon("mini/도버튼.PNG").getImage().getScaledInstance(50, 50, 0);
                                JButton dodoBtn = new JButton(new ImageIcon(dodo));

                                dodoBtn.setLocation(1170, 150);
                                dodoBtn.setSize(50, 50);


                                gamePanel.remove(yut);
                                gamePanel.add(dodoBtn);
                                gamePanel.revalidate();
                                gamePanel.repaint();
                                gamePanel.setComponentZOrder(dodoBtn, 0);

                                dodoBtn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        System.out.println("addMoves후: " + player.getMoves());//삭제할거
                                        System.out.println(" 윷카운트 감소안헀을때:" + player.getYutCount());//삭제할거

                                        System.out.println("아이템썼을때 윷카운트 감소되는지:" + player.getYutCount());//삭제할거

                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();

                                        System.out.println("useMoves한후:" + player.getMoves());//삭제할거

                                    }
                                });

                            }
                        };
                        ts.schedule(tk, 2400);

                    }//윷값이 개가 나왔을때
                    else if (YUTGAP == 2) {
                        Image yut1 = new ImageIcon("mini/개.GIF").getImage().getScaledInstance(300, 300, 0);
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

                                Image dodo = new ImageIcon("mini/개버튼.PNG").getImage().getScaledInstance(50, 50, 0);
                                JButton dodoBtn = new JButton(new ImageIcon(dodo));

                                dodoBtn.setLocation(1170, 150);
                                dodoBtn.setSize(50, 50);


                                gamePanel.remove(yut);
                                gamePanel.add(dodoBtn);
                                gamePanel.revalidate();
                                gamePanel.repaint();
                                gamePanel.setComponentZOrder(dodoBtn, 0);
                                dodoBtn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        System.out.println("addMoves후: " + player.getMoves());//삭제할거
                                        System.out.println(" 윷카운트 감소안헀을때:" + player.getYutCount());//삭제할거

                                        System.out.println("아이템썼을때 윷카운트 감소되는지:" + player.getYutCount());//삭제할거

                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();

                                        System.out.println("useMoves한후:" + player.getMoves());//삭제할거
                                    }
                                });

                            }
                        };
                        ts.schedule(tk, 3400);
                    }//윷값이 걸이 나왔을때
                    else if (YUTGAP == 3) {
                        Image yut1 = new ImageIcon("mini/걸.gif.GIF").getImage().getScaledInstance(300, 300, 0);
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

                                Image dodo = new ImageIcon("mini/걸버튼.PNG").getImage().getScaledInstance(50, 50, 0);
                                JButton dodoBtn = new JButton(new ImageIcon(dodo));
                                dodoBtn.setLocation(1170, 150);
                                dodoBtn.setSize(50, 50);


                                gamePanel.remove(yut);
                                gamePanel.add(dodoBtn);
                                gamePanel.revalidate();
                                gamePanel.repaint();
                                gamePanel.setComponentZOrder(dodoBtn, 0);
                                dodoBtn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        System.out.println("addMoves후: " + player.getMoves());//삭제할거
                                        System.out.println(" 윷카운트 감소안헀을때:" + player.getYutCount());//삭제할거
                                        System.out.println("getYutCount썼을때 윷카운트 감소되는지:" + player.getYutCount());//삭제할거

                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();

                                        System.out.println("useMoves한후:" + player.getMoves());//삭제할거
                                    }
                                });

                            }
                        };
                        ts.schedule(tk, 3400);
                    }//윷값이 윷이 나왔을때
                    else if (YUTGAP == 4) {
                        Image yut1 = new ImageIcon("mini/윷gir.GIF").getImage().getScaledInstance(300, 300, 0);
                        JLabel yut = new JLabel(new ImageIcon(yut1));
                        yut.setSize(300, 300);
                        yut.setLocation(1170, 150);
                        player.setYutCount(player.getYutCount() + 1);

                        gamePanel.add(yut);
                        gamePanel.revalidate();
                        gamePanel.repaint();
                        gamePanel.setComponentZOrder(yut, 0);


                        Timer ts = new Timer();
                        TimerTask tk = new TimerTask() {

                            @Override
                            public void run() {

                                Image dodo = new ImageIcon("mini/윷버튼.PNG").getImage().getScaledInstance(50, 50, 0);
                                JButton dodoBtn = new JButton(new ImageIcon(dodo));
                                dodoBtn.setLocation(1220, 150);
                                dodoBtn.setSize(50, 50);


                                gamePanel.remove(yut);
                                gamePanel.add(dodoBtn);
                                gamePanel.revalidate();
                                gamePanel.repaint();
                                gamePanel.setComponentZOrder(dodoBtn, 0);
                                dodoBtn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        System.out.println("addMoves후: " + player.getMoves());//삭제할거
                                        System.out.println(" 윷카운트 감소안헀을때:" + player.getYutCount());//삭제할거

                                        System.out.println("아이템썼을때 윷카운트 감소되는지:" + player.getYutCount());//삭제할거

                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();

                                        System.out.println("useMoves한후:" + player.getMoves());//삭제할거
                                    }
                                });


                            }
                        };
                        ts.schedule(tk, 3600);
                    }//윷값이 모일때
                    else if (YUTGAP == 5) {
                        Image yut1 = new ImageIcon("mini/모.GIF").getImage().getScaledInstance(300, 300, 0);
                        JLabel yut = new JLabel(new ImageIcon(yut1));
                        yut.setSize(300, 300);
                        yut.setLocation(1170, 150);
                        player.setYutCount(player.getYutCount() + 1);

                        gamePanel.add(yut);
                        gamePanel.revalidate();
                        gamePanel.repaint();
                        gamePanel.setComponentZOrder(yut, 0);

                        Timer ts = new Timer();
                        TimerTask tk = new TimerTask() {

                            @Override
                            public void run() {

                                Image dodo = new ImageIcon("mini/모버튼.PNG").getImage().getScaledInstance(50, 50, 0);
                                JButton dodoBtn = new JButton(new ImageIcon(dodo));
                                dodoBtn.setLocation(1220, 150);
                                dodoBtn.setSize(50, 50);


                                gamePanel.remove(yut);
                                gamePanel.add(dodoBtn);
                                gamePanel.revalidate();
                                gamePanel.repaint();
                                gamePanel.setComponentZOrder(dodoBtn, 0);
                                dodoBtn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        System.out.println("addMoves후: " + player.getMoves());//삭제할거

                                        System.out.println("아이템썼을때 윷카운트 감소되는지:" + player.getYutCount());//삭제할거

                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();

                                        System.out.println("useMoves한후:" + player.getMoves());//삭제할거
                                    }
                                });


                            }
                        };
                        ts.schedule(tk, 3400);
                    } else if (YUTGAP == -1) {
                        // 빽도인 경우
                        Image yut1 = new ImageIcon("mini/백도.GIF").getImage().getScaledInstance(300, 300, 0);
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

                                Image dodo = new ImageIcon("mini/백도버튼.PNG").getImage().getScaledInstance(50, 50, 0);
                                JButton dodoBtn = new JButton(new ImageIcon(dodo));
                                dodoBtn.setLocation(1170, 150);
                                dodoBtn.setSize(50, 50);


                                gamePanel.remove(yut);
                                gamePanel.add(dodoBtn);
                                gamePanel.revalidate();
                                gamePanel.repaint();
                                gamePanel.setComponentZOrder(dodoBtn, 0);
                                dodoBtn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        System.out.println("addMoves후: " + player.getMoves());//삭제할거

                                        System.out.println("아이템썼을때 윷카운트 감소되는지:" + player.getYutCount());//삭제할거

                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();

                                        System.out.println("useMoves한후:" + player.getMoves());//삭제할거
                                    }
                                });
                            }
                        };
                        ts.schedule(tk, 3600);
                    }
                    // 낙이 아닌 경우: move 에 값 추가
                    if (YUTGAP != 0) {
                        player.addMoves(YUTGAP);
                    }
                    // 윷 또는 모: yutCount +1
                    if (YUTGAP >= 4) {
                        player.setYutCount(player.getYutCount() + 1);
                    }
                    // 한번 던졌으니 무조건 yutCount 감소
                    player.setYutCount(player.getYutCount() - 1);


                }
            }
        });


        new GameManager(this);
    }

    /**
     * 게임 내 송편현황 갱신
     *
     * @param player - 갱신할 대상인 플레이어
     */
    public void reload_songP(Player player) {

        if (player instanceof Ryan) {
            show_ryan_songP.setText(Integer.valueOf(player.getSongP()).toString());
            show_ryan_songP.repaint();
        } else if (player instanceof Apeach) {
            show_apeach_songP.setText(Integer.valueOf(player.getSongP()).toString());
            show_apeach_songP.repaint();
        } else if (player instanceof Frodo) {
            show_frodo_songP.setText(Integer.valueOf(player.getSongP()).toString());
            show_frodo_songP.repaint();
        } else if (player instanceof Neo) {
            show_neo_songP.setText(Integer.valueOf(player.getSongP()).toString());
            show_neo_songP.repaint();
        }
    }

    /**
     *
     */
    // public void moveMal()
    public GamePage Outer() {
        return this;
    }

}
