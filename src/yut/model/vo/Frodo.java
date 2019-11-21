package yut.model.vo;

public class Frodo extends Player {
    public Frodo(String nick) {
        super(nick, "Frodo");
    }
    //송편 획득량 두배
    @Override
    public void skill() {
        //카운트 적용 = 먹어서 송편 획득시
    }
}
