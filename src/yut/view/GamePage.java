package yut.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import yut.model.vo.Item;
import yut.model.vo.Player;
import yut.model.vo.Store;
import yut.model.vo.Mal;

public class GamePage {
public static int yutgap;//YutMadeByCho에서 윷값 받을 수 있는 전역변수


    public GamePage(MainFrame mf, JPanel panel, JPanel lo, Player player/*,Player player*/) {
        System.out.println("entering GamePage");
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


        //*********다영**********
        //*** 미션 랜덤으로 띄우기 ***
        int random = ((int) (Math.random() * 4)) + 1;

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

        if (random == 1) {
            System.out.println("미션1");
            gamePanel.add(ms1);
        } else if (random == 2) {
            System.out.println("미션2");
            gamePanel.add(ms2);
        } else if (random == 3) {
            System.out.println("미션3");
            gamePanel.add(ms3);
        } else if (random == 4) {
            System.out.println("미션4");
            gamePanel.add(ms4);
        }

        //플레이어 상태창 배경
        //ryan 배경
        //보라색>노란색으로 변경
        Image purple1 = new ImageIcon("mini/pan.PNG").getImage().getScaledInstance(300, 197, 0);
        JLabel backgroundPurple1 = new JLabel(new ImageIcon(purple1));
        backgroundPurple1.setSize(300, 186);
        backgroundPurple1.setLocation(0, 0);
        //apeach 배경
        JLabel backgroundPurple2 = new JLabel(new ImageIcon(purple1));
        backgroundPurple2.setSize(300, 186);
        backgroundPurple2.setLocation(0, 189);
        //frodo 배경
        JLabel backgroundPurple3 = new JLabel(new ImageIcon(purple1));
        backgroundPurple3.setSize(300, 186);
        backgroundPurple3.setLocation(0, 378);
        //neo 배경
        JLabel backgroundPurple4 = new JLabel(new ImageIcon(purple1));
        backgroundPurple4.setSize(300, 186);
        backgroundPurple4.setLocation(0, 567);

        //정보 헤드
        Image getGreen = new ImageIcon("mini/정보1.PNG").getImage().getScaledInstance(70, 95, 0);
        JLabel info1 = new JLabel(new ImageIcon(getGreen));
        info1.setSize(100, 100);
        info1.setLocation(100, 10);
        JLabel info2 = new JLabel(new ImageIcon(getGreen));
        info2.setSize(100, 100);
        info2.setLocation(100, 199);
        JLabel info3 = new JLabel(new ImageIcon(getGreen));
        info3.setSize(100, 100);
        info3.setLocation(100, 388);
        JLabel info4 = new JLabel(new ImageIcon(getGreen));
        info4.setSize(100, 100);
        info4.setLocation(100, 577);


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
        JLabel ryan_body_label1 = new JLabel(new ImageIcon(ryan_body1));
        ryan_body_label1.setSize(100, 100);
        ryan_body_label1.setLocation(300, 159);//1 99
        Image ryan_body2 = new ImageIcon("mini/2번라이언말.PNG").getImage().getScaledInstance(80, 80, 0);
        JLabel ryan_body_label2 = new JLabel(new ImageIcon(ryan_body2));
        ryan_body_label2.setSize(100, 100);
        ryan_body_label2.setLocation(71, 99);
        Image ryan_body3 = new ImageIcon("mini/3번라이언말.PNG").getImage().getScaledInstance(80, 80, 0);
        JLabel ryan_body_label3 = new JLabel(new ImageIcon(ryan_body3));
        ryan_body_label3.setSize(100, 100);
        ryan_body_label3.setLocation(141, 99);
        Image ryan_body4 = new ImageIcon("mini/4번라이언말.PNG").getImage().getScaledInstance(80, 80, 0);
        JLabel ryan_body_label4 = new JLabel(new ImageIcon(ryan_body4));
        ryan_body_label4.setSize(100, 100);
        ryan_body_label4.setLocation(211, 99);
        //라이언 출발 몸통
        Image ryan_body1_s = new ImageIcon("mini/1번라이언말출격.PNG").getImage().getScaledInstance(80, 80, 0);
        JLabel ryan_body_label1_s = new JLabel(new ImageIcon(ryan_body1_s));
        ryan_body_label1_s.setSize(100, 100);
        ryan_body_label1_s.setLocation(1, 99);
        Image ryan_body2_s = new ImageIcon("mini/2번라이언말출격.PNG").getImage().getScaledInstance(80, 80, 0);
        JLabel ryan_body_label2_s = new JLabel(new ImageIcon(ryan_body2_s));
        ryan_body_label2_s.setSize(100, 100);
        ryan_body_label2_s.setLocation(71, 99);
        Image ryan_body3_s = new ImageIcon("mini/3번라이언말출격.PNG").getImage().getScaledInstance(80, 80, 0);
        JLabel ryan_body_label3_s = new JLabel(new ImageIcon(ryan_body3_s));
        ryan_body_label3_s.setSize(100, 100);
        ryan_body_label3_s.setLocation(141, 99);
        Image ryan_body4_s = new ImageIcon("mini/4번라이언말출격.PNG").getImage().getScaledInstance(80, 80, 0);
        JLabel ryan_body_label4_s = new JLabel(new ImageIcon(ryan_body4_s));
        ryan_body_label4_s.setSize(100, 100);
        ryan_body_label4_s.setLocation(211, 99);

        

        //=======================================> 윷판 말 좌표 찾기 - 다영
        // JLabel testmal = new JLabel(new ImageIcon(ryan_body));
        // testmal.setSize(100, 100);
        //그리드 0일때
        //testmal.setLocation(990, 640);
        //그리드 1일때
        //testmal.setLocation(990, 510);
        //그리드 2일때
        //testmal.setLocation(990, 390);
        //그리드 3일떄
        //testmal.setLocation(990, 280);
        //그리드 4일때
        //testmal.setLocation(990, 170);
        //그리드 5일때
        //testmal.setLocation(990, 65);

        //그리드 6일때
        //testmal.setLocation(855, 65);
        //그리드 7일때
        //testmal.setLocation(735, 65);
        //그리드 8일때
        //testmal.setLocation(615, 65);
        //그리드 9일때
        //testmal.setLocation(495, 65);
        //그리드 10일때
        //testmal.setLocation(350, 65);

        //그리드 11일때
        //testmal.setLocation(350, 180);
        //그리드 12일때
        //testmal.setLocation(350, 290);
        //그리드 13일때
        //testmal.setLocation(350, 400);
        //그리드 14일때
        //testmal.setLocation(350, 510);
        //그리드 15일때
        //testmal.setLocation(350, 640);

        //그리드 16일때
        //testmal.setLocation(475, 640);
        //그리드 17일때
        //testmal.setLocation(605, 640);
        //그리드 18일때
        //testmal.setLocation(735, 640);
        //그리드 19일때
        //testmal.setLocation(865, 640);

        //그리드 25일때
        //testmal.setLocation(475, 188);
        //그리드 26일때
        //testmal.setLocation(560, 245);
        //그리드 27일때
        //testmal.setLocation(790, 435);
        //그리드 28일때
        //testmal.setLocation(865, 510);

        //그리드 20일때
        //testmal.setLocation(860, 188);
        //그리드 21일때
        //testmal.setLocation(790, 245);
        //그리드 22일때
        //testmal.setLocation(685, 350);
        //그리드 23일때
        //testmal.setLocation(565, 435);
        //그리드 24일때
        //testmal.setLocation(495, 510);


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
        JLabel apeach_body_labelx2 = new JLabel(new ImageIcon(apeach_bodyx));
        apeach_body_labelx2.setSize(100, 100);
        apeach_body_labelx2.setLocation(71, 288);
        JLabel apeach_body_labelx3 = new JLabel(new ImageIcon(apeach_bodyx));
        apeach_body_labelx3.setSize(100, 100);
        apeach_body_labelx3.setLocation(141, 288);
        JLabel apeach_body_labelx4 = new JLabel(new ImageIcon(apeach_bodyx));
        apeach_body_labelx4.setSize(100, 100);
        apeach_body_labelx4.setLocation(211, 288);
        //어피치 몸통
        Image apeach_body1 = new ImageIcon("mini/1번어피치말.PNG").getImage().getScaledInstance(120, 120, 0);
        JLabel apeach_body_label1 = new JLabel(new ImageIcon(apeach_body1));
        apeach_body_label1.setSize(100, 100);
        apeach_body_label1.setLocation(1, 288);
        Image apeach_body2 = new ImageIcon("mini/2번어피치말.PNG").getImage().getScaledInstance(120, 120, 0);
        JLabel apeach_body_label2 = new JLabel(new ImageIcon(apeach_body2));
        apeach_body_label2.setSize(100, 100);
        apeach_body_label2.setLocation(71, 288);
        Image apeach_body3 = new ImageIcon("mini/3번어피치말.PNG").getImage().getScaledInstance(120, 120, 0);
        JLabel apeach_body_label3 = new JLabel(new ImageIcon(apeach_body3));
        apeach_body_label3.setSize(100, 100);
        apeach_body_label3.setLocation(141, 288);
        Image apeach_body4 = new ImageIcon("mini/4번어피치말.PNG").getImage().getScaledInstance(120, 120, 0);
        JLabel apeach_body_label4 = new JLabel(new ImageIcon(apeach_body4));
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
        JLabel frodo_body_labelx2 = new JLabel(new ImageIcon(frodo_bodyx));
        frodo_body_labelx2.setSize(100, 100);
        frodo_body_labelx2.setLocation(71, 477);
        JLabel frodo_body_labelx3 = new JLabel(new ImageIcon(frodo_bodyx));
        frodo_body_labelx3.setSize(100, 100);
        frodo_body_labelx3.setLocation(141, 477);
        JLabel frodo_body_labelx4 = new JLabel(new ImageIcon(frodo_bodyx));
        frodo_body_labelx4.setSize(100, 100);
        frodo_body_labelx4.setLocation(211, 477);
        //프로도 몸통
        Image frodo_body1 = new ImageIcon("mini/1번프로도말.PNG").getImage().getScaledInstance(100, 100, 0);
        JLabel frodo_body_label1 = new JLabel(new ImageIcon(frodo_body1));
        frodo_body_label1.setSize(100, 100);
        frodo_body_label1.setLocation(1, 477);
        Image frodo_body2 = new ImageIcon("mini/2번프로도말.PNG").getImage().getScaledInstance(100, 100, 0);
        JLabel frodo_body_label2 = new JLabel(new ImageIcon(frodo_body2));
        frodo_body_label2.setSize(100, 100);
        frodo_body_label2.setLocation(71, 477);
        Image frodo_body3 = new ImageIcon("mini/3번프로도말.PNG").getImage().getScaledInstance(100, 100, 0);
        JLabel frodo_body_label3 = new JLabel(new ImageIcon(frodo_body3));
        frodo_body_label3.setSize(100, 100);
        frodo_body_label3.setLocation(141, 477);
        Image frodo_body4 = new ImageIcon("mini/4번프로도말.PNG").getImage().getScaledInstance(100, 100, 0);
        JLabel frodo_body_label4 = new JLabel(new ImageIcon(frodo_body4));
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
        JLabel neo_body_labelx2 = new JLabel(new ImageIcon(neo_bodyx));
        neo_body_labelx2.setSize(100, 100);
        neo_body_labelx2.setLocation(71, 666);
        JLabel neo_body_labelx3 = new JLabel(new ImageIcon(neo_bodyx));
        neo_body_labelx3.setSize(100, 100);
        neo_body_labelx3.setLocation(141, 666);
        JLabel neo_body_labelx4 = new JLabel(new ImageIcon(neo_bodyx));
        neo_body_labelx4.setSize(100, 100);
        neo_body_labelx4.setLocation(211, 666);
        //네오 몸통
        Image neo_body1 = new ImageIcon("mini/1번네오말.png").getImage().getScaledInstance(100, 100, 0);
        JLabel neo_body_label1 = new JLabel(new ImageIcon(neo_body1));
        neo_body_label1.setSize(100, 100);
        neo_body_label1.setLocation(1, 666);
        Image neo_body2 = new ImageIcon("mini/2번네오말.png").getImage().getScaledInstance(100, 100, 0);
        JLabel neo_body_label2 = new JLabel(new ImageIcon(neo_body2));
        neo_body_label2.setSize(100, 100);
        neo_body_label2.setLocation(71, 666);
        Image neo_body3 = new ImageIcon("mini/3번네오말.png").getImage().getScaledInstance(100, 100, 0);
        JLabel neo_body_label3 = new JLabel(new ImageIcon(neo_body3));
        neo_body_label3.setSize(100, 100);
        neo_body_label3.setLocation(141, 666);
        Image neo_body4 = new ImageIcon("mini/4번네오말.png").getImage().getScaledInstance(100, 100, 0);
        JLabel neo_body_label4 = new JLabel(new ImageIcon(neo_body4));
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


        //송편,아이디 표시 필드
        //후에 setText 변경

        //jtextfield 글꼴 변경하는 객체 생성
        Font font = new Font("arian", Font.BOLD, 20);
        Font font2 = new Font("arian", Font.BOLD, 20);

        //송편 text 표시
        //라이언 송편표시
        JTextField show_ryan_songP = new JTextField(15);
        String str1 = Integer.valueOf(player.getSongP()).toString();
        show_ryan_songP.setEditable(false);
        panel.add(show_ryan_songP);
        show_ryan_songP.setText(str1);
        show_ryan_songP.setSize(110, 40);
        show_ryan_songP.setLocation(190, 55);
        show_ryan_songP.setFont(font);
        //어피치 송편표시
        JTextField show_apeach_songP = new JTextField(15);
        String str2 = Integer.valueOf(player.getSongP()).toString();
        show_apeach_songP.setEditable(false);
        panel.add(show_apeach_songP);
        show_apeach_songP.setText(str2);
        show_apeach_songP.setSize(110, 40);
        show_apeach_songP.setLocation(190, 244);
        show_apeach_songP.setFont(font);
        //프로도 송편표시
        JTextField show_frodo_songP = new JTextField(15);
        String str3 = Integer.valueOf(player.getSongP()).toString();
        show_frodo_songP.setEditable(false);
        panel.add(show_ryan_songP);
        show_frodo_songP.setText(str3);
        show_frodo_songP.setSize(110, 40);
        show_frodo_songP.setLocation(190, 433);
        show_frodo_songP.setFont(font);
        //네오 송편표시
        JTextField show_neo_songP = new JTextField(15);
        String str4 = Integer.valueOf(player.getSongP()).toString();
        show_neo_songP.setEditable(false);
        panel.add(show_ryan_songP);
        show_neo_songP.setText(str4);
        show_neo_songP.setSize(110, 40);
        show_neo_songP.setLocation(190, 622);
        show_neo_songP.setFont(font);
        
        //닉네임 표시
        //라이언 닉네임 표시
        JTextField show_ryan_name = new JTextField(15);
        String str1_n = "라이언";
        show_ryan_name.setEditable(false);
        panel.add(show_ryan_songP);
        show_ryan_name.setText(str1_n);
        show_ryan_name.setSize(110, 40);
        show_ryan_name.setLocation(190, 5);
        show_ryan_name.setFont(font2);
        //어피치 닉네임 표시
        JTextField show_apeach_name = new JTextField(15);
        String str2_n = "어피치";
        show_apeach_name.setEditable(false);
        panel.add(show_ryan_songP);
        show_apeach_name.setText(str2_n);
        show_apeach_name.setSize(110, 40);
        show_apeach_name.setLocation(190, 194);
        show_apeach_name.setFont(font2);
        //프로도 닉네임 표시
        JTextField show_frodo_name = new JTextField(15);
        String str3_n = "프로도";
        show_frodo_name.setEditable(false);
        panel.add(show_ryan_songP);
        show_frodo_name.setText(str3_n);
        show_frodo_name.setSize(110, 40);
        show_frodo_name.setLocation(190, 383);
        show_frodo_name.setFont(font2);
        //네오 닉네임 표시
        JTextField show_neo_name = new JTextField(15);
        String str4_n = "네오";
        show_neo_name.setEditable(false);
        panel.add(show_ryan_songP);
        show_neo_name.setText(str4_n);
        show_neo_name.setSize(110, 40);
        show_neo_name.setLocation(190, 572);
        show_neo_name.setFont(font2);
        

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

        // gamePanel.add(testmal); //============테스트용=============== 좌표찾기 - 다영
        // gamePanel.setComponentZOrder(testmal, 0); //==========테스트용============ 좌표찾기 - 다영


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
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        gamePanel.add(yutBackGround);
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
                if (e.getButton() == 1) {
                    gamePanel.remove(ryan_body_label1);
                    gamePanel.repaint();
                }
            }
        });
        ryan_body_label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(ryan_body_label2);
                    gamePanel.repaint();
                }
            }
        });
        ryan_body_label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(ryan_body_label3);
                    gamePanel.repaint();
                }
            }
        });
        ryan_body_label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(ryan_body_label4);
                    gamePanel.repaint();
                }
            }
        });
        apeach_body_label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(apeach_body_label1);
                    gamePanel.repaint();
                }
            }
        });
        apeach_body_label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(apeach_body_label2);
                    gamePanel.repaint();
                }
            }
        });
        apeach_body_label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(apeach_body_label3);
                    gamePanel.repaint();
                }
            }
        });
        apeach_body_label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(apeach_body_label4);
                    gamePanel.repaint();
                }
            }
        });
        frodo_body_label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(frodo_body_label1);
                    gamePanel.repaint();
                }
            }
        });
        frodo_body_label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(frodo_body_label2);
                    gamePanel.repaint();
                }
            }
        });
        frodo_body_label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(frodo_body_label3);
                    gamePanel.repaint();
                }
            }
        });
        frodo_body_label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(frodo_body_label4);
                    gamePanel.repaint();
                }
            }
        });
        neo_body_label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(neo_body_label1);
                    gamePanel.repaint();
                }
            }
        });
        neo_body_label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(neo_body_label2);
                    gamePanel.repaint();
                }
            }
        });
        neo_body_label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(neo_body_label3);
                    gamePanel.repaint();
                }
            }
        });
        neo_body_label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gamePanel.remove(neo_body_label4);
                    gamePanel.repaint();
                }
            }
        });
        ////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        
        
        /*     임시주석@@@@@@ 합칠때 풀어주시거나 무시@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  
  * 	//스킬 2번 사용시 반응 예시
        skilBtn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Store shop = new Store();
                    shop.buy(mf, gamePanel, player, show, 2);
                }
            }
        });


        //스킬 3번 사용시 반응 예시
        skilBtn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Store shop = new Store();
                    shop.buy(mf, gamePanel, player, show, 3);
                }
            }
        });

        //스킬 4번(폭탄) 사용시 반응 예시
        skilBtn4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    
                    ryan_body_label1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                             int x = ryan_body_label1.getX();
                             int y = ryan_body_label1.getY();
                             Store shop = new Store();
                             shop.buy(mf, gamePanel, player, show, 4,x,y);
                        }
                    });
                    
                  
                }
            }
        });

        //스킬 5번(빽도) 사용시 반응
        skilBtn5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Store shop = new Store();
                    shop.buy(mf, gamePanel, player, show, 5);
                }
            }
        });*/

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
                    //종료버튼 생성
                    Image end1 = new ImageIcon("mini/창버튼.PNG").getImage().getScaledInstance(100, 100, 0);
                    JButton endBtn1 = new JButton();
                    endBtn1 = new JButton(new ImageIcon(end1));
                    //도움말 버튼 크기,위치 조정
                    endBtn1.setSize(100, 100);
                    endBtn1.setLocation(300, 200);
                    //체크 버튼 생성
                    Image check = new ImageIcon("mini/체크1.PNG").getImage().getScaledInstance(100, 100, 0);
                    JButton checkBtn = new JButton();
                    checkBtn = new JButton(new ImageIcon(check));
                    checkBtn.setSize(100, 100);
                    checkBtn.setLocation(100, 200);
                    //버튼 부착
                    ed.add(endBtn1);
                    ed.add(checkBtn);
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
        
        yutThrow1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList alist=new ArrayList();//조지연 윷값저장할 배열
                Mal mal=new Mal(0);//임의로 0을 넣음
                if(player.getYutCount() > 0) {
                if (e.getButton() == 1) {
                    //윷 gif 파일 적용
                    //========조지연===========
                    //todo:버튼을 누르면 값을 저장할 arraylist를 생성하고 거기에 윷값을 넣어줘야함!!!!!!!!
                    //윷던지기 버튼 던질때 YutMadeByCho클래스 객체생성
                    YutMadeByCho thorwYut = new YutMadeByCho();
                    yutgap=thorwYut.mainYut(1, player);
                  
                    yutgap = thorwYut.throwYut(player);
                    //윷값이 낙이 나왔을때
                   
                    if (yutgap == 0) {
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
                    }//윷값이 도가 나왔을때
                    else if (yutgap == 1) {
                        Image yut1 = new ImageIcon("mini/도.GIF").getImage().getScaledInstance(300, 300, 0);
                        JLabel yut = new JLabel(new ImageIcon(yut1));
                        yut.setSize(300, 300);
                        yut.setLocation(1170, 150);
                        alist.add(yutgap);
                        
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
                                        mal.move(yutgap);
                                        System.out.println(mal.getGrid());
                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();
                                        
                                    }});

                            }
                        };
                        ts.schedule(tk, 2400);

                    }//윷값이 개가 나왔을때
                    else if (yutgap == 2) {
                        Image yut1 = new ImageIcon("mini/개.GIF").getImage().getScaledInstance(300, 300, 0);
                        JLabel yut = new JLabel(new ImageIcon(yut1));
                        yut.setSize(300, 300);
                        yut.setLocation(1170, 150);
                        alist.add(yutgap);
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
                                        mal.move(yutgap);
                                        System.out.println(mal.getGrid());
                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();
                                    }});

                            }
                        };
                        ts.schedule(tk, 3400);
                    }//윷값이 걸이 나왔을때
                    else if (yutgap == 3) {
                        Image yut1 = new ImageIcon("mini/걸.gif.GIF").getImage().getScaledInstance(300, 300, 0);
                        JLabel yut = new JLabel(new ImageIcon(yut1));
                        yut.setSize(300, 300);
                        yut.setLocation(1170, 150);
                        alist.add(yutgap);
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
                                        mal.move(yutgap);
                                        System.out.println(mal.getGrid());
                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();
                                    }});

                            }
                        };
                        ts.schedule(tk, 3400);
                    }//윷값이 윷이 나왔을때
                    else if (yutgap == 4) {
                        Image yut1 = new ImageIcon("mini/윷gir.GIF").getImage().getScaledInstance(300, 300, 0);
                        JLabel yut = new JLabel(new ImageIcon(yut1));
                        yut.setSize(300, 300);
                        yut.setLocation(1170, 150);
                        player.setYutCount(player.getYutCount()+1);
                        alist.add(yutgap);
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
                                        mal.move(yutgap);
                                        System.out.println(mal.getGrid());
                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();
                                    }});


                            }
                        };
                        ts.schedule(tk, 3600);
                    }//윷값이 모일때
                    else if (yutgap == 5) {
                        Image yut1 = new ImageIcon("mini/모.GIF").getImage().getScaledInstance(300, 300, 0);
                        JLabel yut = new JLabel(new ImageIcon(yut1));
                        yut.setSize(300, 300);
                        yut.setLocation(1170, 150);
                        player.setYutCount(player.getYutCount()+1);
                        alist.add(yutgap);
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
                                       mal.move(yutgap);
                                        System.out.println(mal.getGrid());
                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();
                                    }});


                            }
                        };
                        ts.schedule(tk, 3400);
                    } else if (yutgap == -1) {
                        Image yut1 = new ImageIcon("mini/백도.GIF").getImage().getScaledInstance(300, 300, 0);
                        JLabel yut = new JLabel(new ImageIcon(yut1));
                        yut.setSize(300, 300);
                        yut.setLocation(1170, 150);
                        alist.add(yutgap);
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
                                        mal.move(yutgap);
                                        System.out.println(mal.getGrid());
                                        gamePanel.remove(dodoBtn);
                                        gamePanel.revalidate();
                                        gamePanel.repaint();
                                    }});


                            }
                        };
                        ts.schedule(tk, 3600);
                    }
                    //윷값저장할 arrayList
                     
                     
                    
               
                    for(int i=0;i<alist.size();i++) {
                        System.out.println(alist);
                    }
                    
                    
                }
            }}
        });
    }

}
