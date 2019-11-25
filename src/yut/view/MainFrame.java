package yut.view;

import java.awt.Image;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

import yut.model.vo.Player;

public class MainFrame extends JFrame {
    //메인 화면 출력
    private MainFrame mf;
    private HashMap hmap;
    public static Clip clip;
   
   

    public MainFrame() {

        //게임 이름
        super("윷 나오면 더블로 가!!");
        //창 사이즈
        this.setSize(1500, 800);
        //컨테이너 레이아웃 설정
        this.setLayout(null);
        try {
            this.setIconImage(ImageIO.read(new File("mini/윷타이틀.PNG")));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        audioPlayer("sound/시작메인음악.WAV");


        //메인 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(1500, 800);
        mainPanel.setLayout(null);

        //메인 패널 배경 라벨 생성
        Image main = new ImageIcon("mini/바탕화면 기본.PNG").getImage().getScaledInstance(1500, 770, 0);
        JLabel mainLb = new JLabel();
        mainLb = new JLabel(new ImageIcon(main));
        //메인 라벨 크기 조정
        mainLb.setSize(1500, 770);

        //메인 로고 라벨 생성
        Image main1 = new ImageIcon("mini/로고.GIF").getImage().getScaledInstance(550, 300, 0);
        JLabel mainLb1 = new JLabel();
        mainLb1= new JLabel(new ImageIcon(main1));
        //메인 로고크기 조정
        mainLb1.setSize(550, 300);
        mainLb1.setLocation(370,50);

        //게임 시작 버튼  생성
        Image start = new ImageIcon("mini/뉴게임스타트.PNG").getImage().getScaledInstance(370, 180, 0);
        JLabel startBtn = new JLabel();
        startBtn = new JLabel(new ImageIcon(start));
        //메인 라벨 크기 ,위치 조정
        startBtn.setSize(370, 180);
        startBtn.setLocation(70, 468);

        //음량 음소거 버튼  생성
        Image audioStop = new ImageIcon("mini/음소거버튼.PNG").getImage().getScaledInstance(70, 70, 0);
        JLabel audioStopBtn = new JLabel(new ImageIcon(audioStop));
        audioStopBtn.setSize(70, 70);
        audioStopBtn.setLocation(20, 680 );
        //음량 시작 버튼  생성
        Image audioStart = new ImageIcon("mini/음향버튼.PNG").getImage().getScaledInstance(150, 100, 0);
        JLabel audioStartBtn = new JLabel(new ImageIcon(audioStart));
        audioStartBtn.setSize(120, 110);
        audioStartBtn.setLocation(0, 660 );


        //도움말 버튼  생성
        Image help = new ImageIcon("mini/뉴도움말.PNG").getImage().getScaledInstance(100, 100, 0);
        JButton helpBtn = new JButton();
        helpBtn = new JButton(new ImageIcon(help));
        //도움말 버튼 크기,위치 조정
        helpBtn.setSize(100, 100);
        helpBtn.setLocation(700, 400);

        Image rank4 = new ImageIcon("mini/랭킹버튼3.jpg").getImage().getScaledInstance(70, 70, 0);
        JButton rankBtn = new JButton();
        rankBtn = new JButton(new ImageIcon(rank4));
        rankBtn.setLocation(450,500);
        rankBtn.setSize(70,70);


        //패널에 메인 배경 부착
        mainPanel.add(mainLb);
        mainPanel.add(helpBtn);
        mainPanel.add(startBtn);
        mainPanel.add(mainLb1);
        mainPanel.add(audioStopBtn);
        mainPanel.add(rankBtn);



        //메인 라벨 우선 순위 마지막 배치
        mainPanel.setComponentZOrder(mainLb, 2);
        mainPanel.setComponentZOrder(startBtn, 0);
        mainPanel.setComponentZOrder(mainLb1, 0);
        mainPanel.setComponentZOrder(audioStopBtn, 0);
        mainPanel.setComponentZOrder(rankBtn, 1);

        //컨터이너에 패널 부착
        this.add(mainPanel);

        mf = this;


        //화면 출력 및 종료 버튼 클릭 반응
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //오디오 음소거 버튼 추가
        audioStopBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stopAudio();
                mainPanel.remove(audioStopBtn);
                mainPanel.add(audioStartBtn);
                mainPanel.revalidate();
                mainPanel.repaint();
                mainPanel.setComponentZOrder(audioStartBtn, 0);
            }
        });

        audioStartBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startAudio();
                mainPanel.remove(audioStartBtn);
                mainPanel.add(audioStopBtn);
                mainPanel.revalidate();
                mainPanel.repaint();
                mainPanel.setComponentZOrder(audioStopBtn, 0);
            }
        });


        //도움말 클릭시 반응 추가
        startBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //마우스 왼쪽 클릭만 입력 될 시
              
                if (e.getButton() == 1) {
                  
                    //시작오디오 종료
                    stopAudio();
                    
                    //체크소리
                    File file = new File("sound/클릭사운드.WAV");
                    System.out.println(file.exists()); //true
                    try {
                        AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(stream);
                        clip.flush();
                        clip.start();


                    } catch(Exception e1) {

                        e1.printStackTrace();
                    }

                    //로딩화면 패널 생성
                    JPanel subPanel1 = new JPanel();
                    subPanel1.setBounds(0, 0, 1500, 800);
                    subPanel1.setLayout(null);
                    //로딩 라벨 생성
                    Image yut1 = new ImageIcon("mini/로딩.GIF").getImage().getScaledInstance(300, 300, 0);
                    JLabel yut = new JLabel(new ImageIcon(yut1));
                    yut.setSize(300, 300);
                    yut.setLocation(600, 180);

                    //========== 다영 ==========
                    //캐릭터를 준비중입니다 gif 삽입
                    Image low = new ImageIcon("mini/캐릭터준비중.GIF").getImage().getScaledInstance(650, 200, 0);
                    JLabel loword = new JLabel(new ImageIcon(low));
                    loword.setSize(650, 200);
                    loword.setLocation(420, 450);

                    //로딩 배경 라벨 생성
                    Image lodingBackGround = new ImageIcon("mini/선택창 배경.PNG").getImage().getScaledInstance(1500, 800, 0);
                    JLabel lo = new JLabel(new ImageIcon(lodingBackGround));
                    lo.setSize(1500, 800);
                    //lo.setLocation(1170, 150);


                    //메인 라벨 제거
                    mf.remove(mainPanel);

                    subPanel1.add(lo);
                    subPanel1.add(yut);
                    subPanel1.add(loword); //추가 - 다영
                    subPanel1.revalidate();
                    subPanel1.repaint();
                    subPanel1.setComponentZOrder(yut, 0);
                    subPanel1.setComponentZOrder(loword, 1); //추가 - 다영

                    mf.add(subPanel1);
                    mf.revalidate();
                    mf.repaint();
                    
                    Timer ts = new Timer();
                    TimerTask tk = new TimerTask() {

                        @Override
                        public void run() {
                           
                            //선택창 배경음악 시작
                            audioPlayer("sound/배경음악.WAV");
                            PlayerPage page = new PlayerPage(mf, mainPanel, subPanel1);

                        }
                    };
                    ts.schedule(tk, 100); //원래 4000

                    //PlayerPage page = new PlayerPage(mf, mainPanel);

                }
            }

        });

        helpBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //마우스 왼쪽 클릭만 입력 될 시
                if (e.getButton() == 1) {
                    Help hp = new Help(mf);

                }
            }

        });

        rankBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                  //마우스 왼쪽 클릭만 입력 될 시
                  if (e.getButton() == 1) {
                     Ranking rk = new Ranking(mf);

                  }
              }

          });




    }

    //메인 오디오 실행 메소드
    public static void audioPlayer(String file) {
        //오디오 프로그램 실행
        File file1 = new File(file);
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(file1);
            clip = AudioSystem.getClip();
            clip.open(stream);
            clip.flush();
            clip.start();
            clip.loop(50);



        } catch(Exception e1) {

            e1.printStackTrace();
        }
    }
    
    
    //메인 오디오 정지 메소드
    public static void stopAudio() {

        clip.stop();


    }


    //메인 오디오 스타트 메소드
    public static void startAudio() {
        clip.start();

        
    }



}