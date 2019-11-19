package yut.view;

import java.awt.Font;

import javax.swing.*;

public class Timer extends Thread {
    //=========== 다영 ============
    private JFrame mf;
    private JPanel panel;
    
    public Timer(JFrame mf, JPanel panel) {
        this.mf = mf;
        this.panel = panel;
    }
    
    @Override
    public void run() {
        
        //남아있는 시간이 얼마인지 표기
        JTextField label = new JTextField("남은 시간 : ");
        label.setFont(new Font("굴림", Font.BOLD, 20));
        panel.add(label);
        
        for(int i = 15; i >= 0; i--) {
           
            try {
                System.out.println(i);
                this.sleep(100);
                label.setText("남은 시간 : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
        //윷 던지기 버튼이 눌러지지 않을 경우 -> 턴 넘기기
        //윷 던지기 버튼이 눌러졌을 경우 -> 쓰레드 종료(타이머 사라지게) 
        
        
        
    }
    
    
    
}
