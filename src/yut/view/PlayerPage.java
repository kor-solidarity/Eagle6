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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import yut.model.vo.Player;

public class PlayerPage {
    private Player player = new Player("김성준", "라이언");//플레이어 예시로 넘길려고 해놓은 것
    TextField n1;
    TextField n2;
    TextField n3;
    TextField n4;

    public PlayerPage(MainFrame mf, JPanel panel, JPanel sb) {
        player.setSongP(100);//임의로 테스트용


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
        Image main2 = new ImageIcon("mini/선택창 배경.PNG").getImage().getScaledInstance(1500, 770, 0);
        JLabel mainLb2 = new JLabel();
        mainLb2 = new JLabel(new ImageIcon(main2));
        //메인 라벨 크기 조정
        mainLb2.setSize(1500, 770);

        //윷놀이 게임 시작 버튼  생성
        Image game = new ImageIcon("mini/스타트 선택창.PNG").getImage().getScaledInstance(220, 220, 0);
        JButton gameBtn = new JButton();
        gameBtn = new JButton(new ImageIcon(game));
        //도움말 버튼 크기,위치 조정
        gameBtn.setSize(220, 220);
        gameBtn.setLocation(1270, 530);


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
        ryanBtn.setLocation(600, 430);
        //어피치 캐릭터
        Image apeach = new ImageIcon("mini/어피치.PNG").getImage().getScaledInstance(230, 230, 0);
        JLabel apeachBtn = new JLabel(new ImageIcon(apeach));
        apeachBtn.setSize(230, 230);
        apeachBtn.setLocation(600, 50);
        //네오 캐릭터
        Image neo = new ImageIcon("mini/네오.PNG").getImage().getScaledInstance(230, 230, 0);
        JLabel neoBtn = new JLabel(new ImageIcon(neo));
        neoBtn.setSize(230, 230);
        neoBtn.setLocation(1050, 200);
        //프로도 캐릭터
        Image prodo = new ImageIcon("mini/프로도.PNG").getImage().getScaledInstance(230, 230, 0);
        JLabel prodoBtn = new JLabel(new ImageIcon(prodo));
        prodoBtn.setSize(230, 230);
        prodoBtn.setLocation(100, 200);

        //체크버튼
        Image icon4 = new ImageIcon("mini/체크.PNG").getImage().getScaledInstance(100, 100, 0);
        JButton user1c = new JButton(new ImageIcon(icon4));
        user1c.setSize(100, 100);
        user1c.setLocation(290, 420);

        Image icon5 = new ImageIcon("mini/체크.PNG").getImage().getScaledInstance(100, 100, 0);
        JButton user2c = new JButton(new ImageIcon(icon4));
        user2c.setSize(100, 100);
        user2c.setLocation(880, 170);

        Image icon6 = new ImageIcon("mini/체크.PNG").getImage().getScaledInstance(100, 100, 0);
        JButton user3c = new JButton(new ImageIcon(icon4));
        user3c.setSize(100, 100);
        user3c.setLocation(1360, 420);

        Image icon7 = new ImageIcon("mini/체크.PNG").getImage().getScaledInstance(100, 100, 0);
        JButton user4c = new JButton(new ImageIcon(icon4));
        user4c.setSize(100, 100);
        user4c.setLocation(880, 630);

        //유저닉네임 텍스트
        JTextField n1 = new JTextField("user1(eng plz)");
        n1.setBounds(60, 450, 230, 50);
        n1.setFont(new Font("Serif", Font.BOLD, 35));
        n1.setHorizontalAlignment(JTextField.LEFT);
        //텍스트 누르면 text안에 value 사라지게하는
        n1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                n1.setText("");
            }
        });


        JTextField n2 = new JTextField("user2(eng plz)");
        n2.setBounds(650, 200, 230, 50);
        n2.setFont(new Font("Serif", Font.BOLD, 35));
        n2.setHorizontalAlignment(JTextField.LEFT);
        n2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                n2.setText("");
            }
        });


        JTextField n3 = new JTextField("user3(eng plz)");
        n3.setBounds(1130, 450, 230, 50);
        n3.setFont(new Font("Serif", Font.BOLD, 35));
        n3.setHorizontalAlignment(JTextField.LEFT);
        n3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                n3.setText("");
            }
        });

        JTextField n4 = new JTextField("user4(eng plz)");
        n4.setBounds(650, 650, 230, 50);
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


        //진혁 체크버튼이벤트
        user1c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                try {
                    String s;
                    String[] array;
                    boolean idCheck = false;
                    BufferedReader bo = new BufferedReader(new FileReader("회원명단.txt"));
                    while ((s = bo.readLine()) != null) {
                        array = s.split("/");
                        for (int i = 0; i < array.length; i++) {
                            if (n1.getText().equals(array[i])) {
                                JOptionPane.showMessageDialog(null, "중복입니다.");
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "사용가능한아이디입니다.");
                                idCheck = true;
                                break;

                            }

                        }
                        BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt", true));
                        if (idCheck) {
                            bos.write(n1.getText() + "/");
                        }
                    }


                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        });

        user2c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                try {
                    String s;
                    String[] array;
                    boolean idCheck = false;
                    BufferedReader bo = new BufferedReader(new FileReader("회원명단.txt"));
                    while ((s = bo.readLine()) != null) {
                        array = s.split("/");
                        for (int i = 0; i < array.length; i++) {
                            if (n2.getText().equals(array[i])) {
                                JOptionPane.showMessageDialog(null, "중복입니다.");
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "사용가능한아이디입니다.");
                                idCheck = true;
                                break;

                            }

                        }
                        BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt", true));
                        if (idCheck) {
                            bos.write(n2.getText() + "/");
                        }
                    }


                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        });

        user3c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                try {
                    String s;
                    String[] array;
                    boolean idCheck = false;
                    BufferedReader bo = new BufferedReader(new FileReader("회원명단.txt"));
                    while ((s = bo.readLine()) != null) {
                        array = s.split("/");
                        for (int i = 0; i < array.length; i++) {
                            if (n3.getText().equals(array[i])) {
                                JOptionPane.showMessageDialog(null, "중복입니다.");
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "사용가능한아이디입니다.");
                                idCheck = true;
                                break;

                            }

                        }
                        BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt", true));
                        if (idCheck) {
                            bos.write(n3.getText() + "/");
                        }
                    }


                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        });

        user4c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String s;
                    String[] array;
                    boolean idCheck = false;
                    BufferedReader bo = new BufferedReader(new FileReader("회원명단.txt"));
                    while ((s = bo.readLine()) != null) {
                        array = s.split("/");
                        for (int i = 0; i < array.length; i++) {
                            if (n4.getText().equals(array[i])) {
                                JOptionPane.showMessageDialog(null, "중복입니다.");
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "사용가능한아이디입니다.");
                                idCheck = true;
                                break;

                            }

                        }
                        BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt", true));
                        if (idCheck) {
                            bos.write(n4.getText() + "/");
                        }
                    }


                } catch (IOException e1) {
                    e1.printStackTrace();
                }

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
                    prodo2.setLocation(100, 200);

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
                    neno2.setLocation(1060, 210);

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
                    apeach2.setLocation(610, 60);

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
                    ryan2.setLocation(600, 430);

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
                }
            }
        });

        //게임시작 버튼 활성
        gameBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
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

                            GamePage gm = new GamePage(mf, panel, lo, player);
                        }
                    };
                    ts.schedule(tk, 100); //원래 4000


                }
            }
        });


    }
}
