package yut.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import yut.model.vo.*;


public class PlayerPage {

    //오디오 추가
    private Clip clip;

    // private Player player = new Player("김성준", "라이언");//플레이어 예시로 넘길려고 해놓은 것
    TextField n1;
    TextField n2;
    TextField n3;
    TextField n4;
    int playerNum;
    String[] nick = new String[4];
    //ArrayList arr=new ArrayList();

    public PlayerPage(MainFrame mf, JPanel panel, JPanel sb) {
        System.out.println("PlayerPage()");
        // player.setSongP(100);//임의로 테스트용


        n1 = new TextField(20);
        n2 = new TextField(20);
        n3 = new TextField(20);
        n4 = new TextField(20);


        //로딩화면 제거
        mf.remove(sb);

        //선택창 패널 제작
        JPanel subPanel = new JPanel();
        subPanel.setBounds(0, 0, 1500, 800);
        subPanel.setLayout(null);

        //유저 정보 입력 라벨로 변경
        Image main2 = new ImageIcon("mini/뉴선택창.PNG").getImage().getScaledInstance(1500, 770, 0);
        JLabel mainLb2 = new JLabel();
        mainLb2 = new JLabel(new ImageIcon(main2));
        //메인 라벨 크기 조정
        mainLb2.setSize(1500, 770);

        //윷놀이 게임 시작 버튼  생성
        Image game = new ImageIcon("mini/스타트1.PNG").getImage().getScaledInstance(170, 170, 0);
        JButton gameBtn = new JButton();
        gameBtn = new JButton(new ImageIcon(game));
        //도움말 버튼 크기,위치 조정
        gameBtn.setSize(170, 170);
        gameBtn.setLocation(1310, 580);


        //뒤로가기 버튼
        Image back = new ImageIcon("mini/뒤로가기.PNG").getImage().getScaledInstance(200, 200, 0);
        JLabel backBtn = new JLabel();
        backBtn = new JLabel(new ImageIcon(back));
        backBtn.setSize(200, 200);
        backBtn.setLocation(-50, 600);
        //라이언 캐릭터
        Image ryan = new ImageIcon("mini/라이언.PNG").getImage().getScaledInstance(200, 200, 0);
        JLabel ryanBtn = new JLabel(new ImageIcon(ryan));
        ryanBtn.setSize(200, 200);
        ryanBtn.setLocation(100, 30);
        //어피치 캐릭터
        Image apeach = new ImageIcon("mini/어피치.PNG").getImage().getScaledInstance(230, 230, 0);
        JLabel apeachBtn = new JLabel(new ImageIcon(apeach));
        apeachBtn.setSize(230, 230);
        apeachBtn.setLocation(380, 540);
        //네오 캐릭터
        Image neo = new ImageIcon("mini/네오.PNG").getImage().getScaledInstance(230, 230, 0);
        JLabel neoBtn = new JLabel(new ImageIcon(neo));
        neoBtn.setSize(230, 230);
        neoBtn.setLocation(1050, 550);
        //프로도 캐릭터
        Image prodo = new ImageIcon("mini/프로도.PNG").getImage().getScaledInstance(230, 230, 0);
        JLabel prodoBtn = new JLabel(new ImageIcon(prodo));
        prodoBtn.setSize(230, 230);
        prodoBtn.setLocation(810, 10);

        //체크버튼  //버튼변경
        Image icon1 = new ImageIcon("mini/버튼라이언1.PNG").getImage().getScaledInstance(70, 70, 0);
        JButton user1c = new JButton(new ImageIcon(icon1));
        user1c.setSize(50, 50);
        user1c.setLocation(250, 310);

        Image game1 = new ImageIcon("mini/스타트1.PNG").getImage().getScaledInstance(170, 170, 0);
        JButton gameBtn1 = new JButton(new ImageIcon(game1));
        
        //도움말 버튼 크기,위치 조정
        gameBtn1.setSize(170, 170);
        gameBtn1.setLocation(1310, 580);
        
        Image icon2 = new ImageIcon("mini/버튼어피치1.PNG").getImage().getScaledInstance(50, 50, 0);
        JButton user2c = new JButton(new ImageIcon(icon2));
        user2c.setSize(50, 50);
        user2c.setLocation(610, 310);

        Image icon3 = new ImageIcon("mini/버튼프로도1.PNG").getImage().getScaledInstance(70, 70, 0);
        JButton user3c = new JButton(new ImageIcon(icon3));
        user3c.setSize(50, 50);
        user3c.setLocation(970, 310);

        Image icon4 = new ImageIcon("mini/버튼네오1.PNG").getImage().getScaledInstance(77, 77, 0);
        JButton user4c = new JButton(new ImageIcon(icon4));
        user4c.setSize(50, 50);
        user4c.setLocation(1360, 310);

        //유저닉네임 텍스트 //텍스트 위치변경
        JTextField n1 = new JTextField("user1");
        n1.setBounds(18, 310, 230, 50);
        n1.setFont(new Font("Serif", Font.BOLD, 35));
        n1.setHorizontalAlignment(JTextField.LEFT);
        //텍스트 누르면 text안에 value 사라지게하는
        n1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                n1.setText("");
            }
        });


        JTextField n2 = new JTextField("user2");
        n2.setBounds(380, 310, 230, 50);
        n2.setFont(new Font("Serif", Font.BOLD, 35));
        n2.setHorizontalAlignment(JTextField.LEFT);
        n2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                n2.setText("");
            }
        });


        JTextField n3 = new JTextField("user3");
        n3.setBounds(740, 310, 230, 50);
        n3.setFont(new Font("Serif", Font.BOLD, 35));
        n3.setHorizontalAlignment(JTextField.LEFT);
        n3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                n3.setText("");
            }
        });

        JTextField n4 = new JTextField("user4");
        n4.setBounds(1130, 310, 230, 50);
        n4.setFont(new Font("Serif", Font.BOLD, 35));
        n4.setHorizontalAlignment(JTextField.LEFT);
        n4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                n4.setText("");
            }
        });


        subPanel.add(n1);
        subPanel.add(n2);
        subPanel.add(n3);
        subPanel.add(n4);

        subPanel.add(user3c);
        subPanel.add(user2c);
        subPanel.add(user1c);
        subPanel.add(user4c);


        //패널의 선택창 라벨 씌우기
        subPanel.add(backBtn);
        subPanel.add(prodoBtn);
        subPanel.add(neoBtn);
        subPanel.add(apeachBtn);
        subPanel.add(ryanBtn);
        subPanel.add(gameBtn1);
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


        //진혁 체크버튼이벤트 //수정
        user1c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //오디오 프로그램 실행
                File file = new File("sound/클릭사운드.WAV");
                System.out.println(file.exists()); //true
                try {
                    AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                    clip = AudioSystem.getClip();
                    clip.open(stream);
                    clip.start();

                } catch (Exception e1) {

                    e1.printStackTrace();
                }

                nick[0] = n1.getText();

                Image btn1 = new ImageIcon("mini/버튼라이언2.png").getImage().getScaledInstance(390, 390, 0);
                JLabel btn2 = new JLabel(new ImageIcon(btn1));
                btn2.setSize(390, 390);
                btn2.setLocation(0, 170);

                nick[0] = n1.getText();

                for (int i = 0; i < nick.length; i++) {
                    if (i == 0) {
                        continue;
                    }
                    if (nick[0].equals(nick[i])) {
                        JOptionPane.showMessageDialog(null, "중복입니다");
                        return;

                    }
                }
                JOptionPane.showMessageDialog(null, "생성되었습니다");
                subPanel.remove(n1);
                subPanel.remove(user1c);
                subPanel.add(btn2);
                subPanel.repaint();
                subPanel.setComponentZOrder(btn2, 1);
                playerNum++;


            }
        });

        user2c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //오디오 프로그램 실행
                File file = new File("sound/클릭사운드.WAV");
                System.out.println(file.exists()); //true
                try {
                    AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                    clip = AudioSystem.getClip();
                    clip.open(stream);
                    clip.start();


                } catch (Exception e1) {

                    e1.printStackTrace();
                }
                nick[1] = n2.getText();


                Image btn3 = new ImageIcon("mini/버튼어피치2.png").getImage().getScaledInstance(350, 350, 0);
                JLabel btn4 = new JLabel(new ImageIcon(btn3));
                btn4.setSize(350, 350);
                btn4.setLocation(350, 210);
                nick[1] = n2.getText();

                for (int i = 0; i < nick.length; i++) {
                    if (i == 1) {
                        continue;
                    }
                    if (nick[1].equals(nick[i])) {
                        JOptionPane.showMessageDialog(null, "중복입니다");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "생성되었습니다");
                subPanel.remove(n2);
                subPanel.remove(user2c);
                subPanel.add(btn4);
                subPanel.repaint();
                subPanel.setComponentZOrder(btn4, 1);
                playerNum++;

            }
        });

        user3c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //오디오 프로그램 실행
                File file = new File("sound/클릭사운드.WAV");
                System.out.println(file.exists()); //true
                try {
                    AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                    clip = AudioSystem.getClip();
                    clip.open(stream);
                    clip.start();


                } catch (Exception e1) {

                    e1.printStackTrace();
                }


                Image btn5 = new ImageIcon("mini/버튼프로도2.png").getImage().getScaledInstance(350, 350, 0);
                JLabel btn6 = new JLabel(new ImageIcon(btn5));
                btn6.setSize(350, 350);
                btn6.setLocation(700, 190);
                nick[2] = n3.getText();
                for (int i = 0; i < nick.length; i++) {
                    if (i == 2) {
                        continue;
                    }
                    if (nick[2].equals(nick[i])) {
                        JOptionPane.showMessageDialog(null, "중복입니다");
                        return;

                    }
                }
                JOptionPane.showMessageDialog(null, "생성되었습니다");
                subPanel.remove(n3);
                subPanel.remove(user3c);
                subPanel.add(btn6);
                subPanel.repaint();
                subPanel.setComponentZOrder(btn6, 1);
                playerNum++;

            }
        });

        user4c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //오디오 프로그램 실행
                File file = new File("sound/클릭사운드.WAV");
                System.out.println(file.exists()); //true
                try {
                    AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                    clip = AudioSystem.getClip();
                    clip.open(stream);
                    clip.start();


                } catch (Exception e1) {

                    e1.printStackTrace();
                }


                Image btn7 = new ImageIcon("mini/버튼네오2.png").getImage().getScaledInstance(230, 230, 0);
                JLabel btn8 = new JLabel(new ImageIcon(btn7));
                btn8.setSize(230, 230);
                btn8.setLocation(1150, 270);
                nick[3] = n4.getText();
                for (int i = 0; i < nick.length; i++) {
                    if (i == 3) {
                        continue;
                    }
                    if (nick[3].equals(nick[i])) {
                        JOptionPane.showMessageDialog(null, "중복입니다");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "생성되었습니다");
                subPanel.remove(n4);
                subPanel.remove(user4c);
                subPanel.add(btn8);
                subPanel.repaint();
                subPanel.setComponentZOrder(btn8, 1);
                playerNum++;
            }


        });


        //프로도 클릭시 모션 생성
        prodoBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Image prodo1 = new ImageIcon("mini/프로도캐릭.GIF").getImage().getScaledInstance(170, 170, 0);
                    JLabel prodo2 = new JLabel(new ImageIcon(prodo1));
                    prodo2.setSize(170, 170);
                    prodo2.setLocation(810, 10);

                    subPanel.remove(prodoBtn);
                    subPanel.add(prodo2);
                    subPanel.revalidate();
                    subPanel.repaint();
                    subPanel.setComponentZOrder(prodo2, 0);

                    Timer ts = new Timer();
                    TimerTask tk = new TimerTask() {

                        @Override
                        public void run() {
                            subPanel.remove(prodo2);
                            subPanel.add(prodoBtn);
                            subPanel.revalidate();
                            subPanel.repaint();
                            subPanel.setComponentZOrder(prodoBtn, 0);
                        }
                    };
                    ts.schedule(tk, 3000);

                }
            }
        });

        //네오 클릭시 모션 생성
        neoBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Image neno1 = new ImageIcon("mini/네오캐릭.GIF").getImage().getScaledInstance(170, 170, 0);
                    JLabel neno2 = new JLabel(new ImageIcon(neno1));
                    neno2.setSize(170, 170);
                    neno2.setLocation(1050, 550);

                    subPanel.remove(neoBtn);
                    subPanel.add(neno2);
                    subPanel.revalidate();
                    subPanel.repaint();
                    subPanel.setComponentZOrder(neno2, 0);

                    Timer ts = new Timer();
                    TimerTask tk = new TimerTask() {

                        @Override
                        public void run() {
                            subPanel.remove(neno2);
                            subPanel.add(neoBtn);
                            subPanel.revalidate();
                            subPanel.repaint();
                            subPanel.setComponentZOrder(neoBtn, 0);
                        }
                    };
                    ts.schedule(tk, 3000);

                }
            }
        });
        //어피치 클릭시 모션 생성
        apeachBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Image apeach1 = new ImageIcon("mini/어피치캐릭.GIF").getImage().getScaledInstance(150, 150, 0);
                    JLabel apeach2 = new JLabel(new ImageIcon(apeach1));
                    apeach2.setSize(150, 150);
                    apeach2.setLocation(380, 550);

                    subPanel.remove(apeachBtn);
                    subPanel.add(apeach2);
                    subPanel.revalidate();
                    subPanel.repaint();
                    subPanel.setComponentZOrder(apeach2, 0);

                    Timer ts = new Timer();
                    TimerTask tk = new TimerTask() {

                        @Override
                        public void run() {
                            subPanel.remove(apeach2);
                            subPanel.add(apeachBtn);
                            subPanel.revalidate();
                            subPanel.repaint();
                            subPanel.setComponentZOrder(apeachBtn, 0);
                        }
                    };
                    ts.schedule(tk, 3000);

                }
            }
        });
        //라이언 클릭시 모션 생성
        ryanBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    Image ryan1 = new ImageIcon("mini/라이언캐릭.GIF").getImage().getScaledInstance(200, 200, 0);
                    JLabel ryan2 = new JLabel(new ImageIcon(ryan1));
                    ryan2.setSize(200, 200);
                    ryan2.setLocation(100, 30);

                    subPanel.remove(ryanBtn);
                    subPanel.add(ryan2);
                    subPanel.revalidate();
                    subPanel.repaint();
                    subPanel.setComponentZOrder(ryan2, 0);

                    Timer ts = new Timer();
                    TimerTask tk = new TimerTask() {

                        @Override
                        public void run() {
                            subPanel.remove(ryan2);
                            subPanel.add(ryanBtn);
                            subPanel.revalidate();
                            subPanel.repaint();
                            subPanel.setComponentZOrder(ryanBtn, 0);
                        }
                    };
                    ts.schedule(tk, 3000);
                }
            }
        });

        //뒤로가기 버튼
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    mf.remove(subPanel);
                    mf.add(panel);
                    mf.revalidate();
                    mf.repaint();
                    //오디오 종료
                    MainFrame.stopAudio();
                    //오디오 실행
                    MainFrame.audioPlayer("sound/시작메인음악.WAV");
                }
            }
        });

        //게임시작 버튼 활성


        gameBtn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1 && playerNum>=2) { //입력2이상일시 스타트버튼가능

                    //로딩화면 패널 생성
                    JPanel lo = new JPanel();
                    lo.setBounds(0, 0, 1500, 800);
                    lo.setLayout(null);
                    //로딩 라벨 생성
                    Image yut1 = new ImageIcon("mini/로딩.GIF").getImage().getScaledInstance(300, 300, 0);
                    JLabel yut = new JLabel(new ImageIcon(yut1));
                    yut.setSize(300, 300);
                    yut.setLocation(600, 180);

                    //========== 다영 ==========
                    //게임을 준비중입니다 gif 삽입
                    Image low2 = new ImageIcon("mini/게임준비중.GIF").getImage().getScaledInstance(650, 200, 0);
                    JLabel loword2 = new JLabel(new ImageIcon(low2));
                    loword2.setSize(650, 200);
                    loword2.setLocation(420, 450);

                    //로딩 배경 라벨 생성
                    Image lodingBackGround = new ImageIcon("mini/선택창 배경.PNG").getImage().getScaledInstance(1500, 800, 0);
                    JLabel lo1 = new JLabel(new ImageIcon(lodingBackGround));
                    lo1.setSize(1500, 800);
                    //lo.setLocation(1170, 150);

                    //메인 라벨 제거
                    mf.remove(subPanel);

                    lo.add(lo1);
                    lo.add(yut);
                    lo.add(loword2); //--- 추가 : 다영
                    lo.revalidate();
                    lo.repaint();
                    lo.setComponentZOrder(yut, 0);
                    lo.setComponentZOrder(loword2, 1); //--- 추가  : 다영

                    mf.add(lo);
                    mf.revalidate();
                    mf.repaint();

                    Timer ts = new Timer();
                    TimerTask tk = new TimerTask() {

                        @Override
                        public void run() {
                            // 은석: 플레이어 생성
                            // 라이언, 어피치, 프로도, 네오
                            Player[] players = new Player[4];
                            if (nick[0] != null) {
                                players[0] = new Ryan(nick[0]);
                            }
                            if (nick[1] != null) {
                                players[1] = new Apeach(nick[1]);
                            }
                            if (nick[2] != null) {
                                players[2] = new Frodo(nick[2]);
                            }
                            if (nick[3] != null) {
                                players[3] = new Neo(nick[3]);
                            }


                            GamePage gm = new GamePage(mf, panel, lo, players);
                        }
                    };
                    ts.schedule(tk, 100); //원래 4000


                }
            }
        });

    }


}