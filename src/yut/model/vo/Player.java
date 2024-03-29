package yut.model.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import yut.view.GamePage;

public class Player {
	private boolean specialty = true;

	
	
	// 송편 수
    private int songP = 52;
    // 말 수
    private Mal[] mals = new Mal[4];
    // 플레이어 별명
    private String nick;
    // 플레이어 특수능력 사용여부
    
    
    
    
    
    
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

    public Player() {} //미션 때문에 추가 -------- 다영



    public Player(String nick, String charName) {
        this.nick = nick;
        this.charName = charName;
        this.mals[0] = new Mal(0, this.nick);
        this.mals[1] = new Mal(1, this.nick);
        this.mals[2] = new Mal(2, this.nick);
        this.mals[3] = new Mal(3, this.nick);
    }


    @Override
    public String toString() {
        return "Score [nick=" + nick + ", songP=" + songP + "]";
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

    public void resetYutCount() {
        this.yutCount = 1;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean getSpecialty() {
        return specialty;
    }

    public ArrayList getMoves() {
        return moves;
    }

    // 윷의 값을 목록에 하나 추가함. 이게 사실상의 setMoves
    public void addMoves(Integer yutResult) {

        this.moves.add(yutResult);
    }

    // (이동을 다 하면) 윷의 값 빼내기.
    public void useMoves(Integer moveInt) {
        this.moves.remove(this.moves.indexOf(moveInt));
        System.out.println("Player.userMoves()안의 윷값넘겨받을때"+GamePage.TRUEYUTGAP);
        GamePage.TRUEYUTGAP=0;
        System.out.println("Player.useMoves() 안의 윷값 초기화= "+GamePage.TRUEYUTGAP );
    }




    //arrayList moves사이즈 한칸




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

    public void skill(GamePage gm) {
 
    }
}
