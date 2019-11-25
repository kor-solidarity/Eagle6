package yut.model.vo;

import java.awt.Image;
import java.util.TimerTask;

import javax.management.timer.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import yut.view.GamePage;

public class Ryan extends Player {
    public Ryan(String nick) {
        super(nick, "Ryan");
        super.setSongP(999);
    }
    //첫턴 첫번째 윷 2배로 이동
    @Override
    public void skill(GamePage gm) {
        if(getSpecialty()==true) {
            GamePage.SELECTED_BUTTON=4;
          
            
           
            setSpecialty(false);
            
        }
    }
}

