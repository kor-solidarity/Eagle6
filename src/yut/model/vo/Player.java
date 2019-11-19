package yut.model.vo;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    // 송편 수
    private int songP = 52;
    // 말 수
    private Mal[] mals = {new Mal(1), new Mal(2),
            new Mal(3), new Mal(4)};
    // 플레이어 별명
    private String nick;
    // 플레이어 특수능력 사용여부
    private boolean specialty = true;
    // 특수능력 뭔지 표기. GUI 때 필요할진 모르겠음
    private String special_skill;
    // 던진 윷 결과들.
    private ArrayList<Integer> moves = new ArrayList<>();
    // 남은 던질 수 있는 윷.
    private int yutCount = 1;
    // 플레이어 순서 정하는 용도. 이 시연에선 우선은 미구현
    private int turn;
    // 케릭터의 고유 이름
    private String charName;

    public Player(String nick, String charName) {
        this.nick = nick;
        this.charName = charName;
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

    public String getCharName() {
        return charName;
    }

    public int getYutCount() {
        return yutCount;
    }

    public void setYutCount(int yutCount) {
        this.yutCount = yutCount;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public ArrayList getMoves() {
        return moves;
    }

    // 윷의 값을 목록에 하나 추가함. 이게 사실상의 setMoves
    public void addMoves(Integer yutResult) {
        this.moves.add(yutResult);
    }

    // 이동을 하면서 윷의 값 빼내기.
    public void useMoves(Integer moveInt) {
        this.moves.remove(this.moves.indexOf(moveInt));
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
