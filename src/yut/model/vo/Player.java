package yut.model.vo;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    // 송편 수
    private int songP = 2;
    // 말 수
    private Mal[] mals = {new Mal(1), new Mal(2),
            new Mal(3), new Mal(4)};
    // 플레이어 별명
    private String nick;
    // 플레이어 특수능력 사용여부
    private boolean specialty = true;
    // 던진 윷 결과들.
    private ArrayList moves = new ArrayList();
    // 남은 던질 수 있는 윷.
    private int yutCount = 1;
    // 플레이어 순서 정하는 용도. 이 시연에선 우선은 미구현
    private int turn;


    public Player(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "Player{" +
                "songP=" + songP +
                ", mals=" + Arrays.toString(mals) +
                ", nick='" + nick + '\'' +
                ", specialty=" + specialty +
                ", moves=" + moves +
                ", yutCount=" + yutCount +
                ", turn=" + turn +
                '}';
    }

    public int getSongP() {
        return songP;
    }

    public void setSongP(int songP) {
        this.songP = songP;
    }

    public Mal[] getMals() {
        return mals;
    }

    public void setMals(Mal[] mals) {
        this.mals = mals;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public boolean isSpecialty() {
        return specialty;
    }

    public void setSpecialty(boolean specialty) {
        this.specialty = specialty;
    }
}
