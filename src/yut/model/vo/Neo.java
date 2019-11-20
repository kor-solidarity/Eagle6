package yut.model.vo;

import yut.view.GamePage;

public class Neo extends Player{
    public Neo(String nick) {
        super(nick, "Neo");
    }
    //첫 턴 윷 확률 올리기
    @Override
    public void skill() {
        //카운트 적용 = 첫턴
        if(getSpecialty()==true) {
            GamePage.SELECTED_BUTTON=8;
            setSpecialty(false);
        }
    } 
}
