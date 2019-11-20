package yut.model.vo;

import yut.view.GamePage;

public class Ryan extends Player {
    public Ryan(String nick) {
        super(nick, "Ryan");
    }
    //첫턴 첫번째 윷 2배로 이동
    @Override
    public void skill() {
        if(getSpecialty()==true) {
            GamePage.SELECTED_BUTTON=4;
            setSpecialty(false);
        }
    }
}
