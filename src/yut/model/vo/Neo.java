package yut.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import yut.view.GamePage;

public class Neo extends Player{
    public Neo(String nick) {
        super(nick, "Neo");
    }
    //첫 턴 윷 확률 올리기
    @Override
    public void skill(GamePage gm) {
        //카운트 적용 = 첫턴
        if(getSpecialty()==true) {
            GamePage.SELECTED_BUTTON=8;

            setSpecialty(false);
        }
    }
}