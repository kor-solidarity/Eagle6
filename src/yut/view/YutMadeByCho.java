package yut.view;

import java.util.Random;

import yut.model.vo.Item;
import yut.model.vo.Player;

public class YutMadeByCho {

    int yutNum = 0;//윷결과값저장하는 변수

    public int mainYut(int num, Player player) {
       

        switch (1) {
            case 1:
                yutNum = throwYut(player);
                break;
            case 2:
                yutNum = moOrDo(player);
          
                break;

            case 3:
                yutNum = neoIncreaseYut(player);
                break;
            case 4:
                yutNum = ryanMoveDouble(player);
                break;
            case 5:
                yutNum = mustBackDo(player);
                break;
        }
        return yutNum;

    }

    //윷확률, 결과값 받을 메소드
    public int throwYut(Player player) {
        //랜덤값으로 윷확률 받기
        
        int yutRate = new Random().nextInt(10) + 1;

        switch (yutRate) {
            case 1:
                yutNum = nak();
                break;//낙나왔을때
            case 2:
                yutNum = Do();
                break;//도
            case 3:
                yutNum = gea();
                break;//개
            case 4:
                yutNum = gea();
                break;//개
            case 5:
                yutNum = gul();
                break;//걸
            case 6:
                yutNum = gul();
                break;//걸
            case 7:
                yutNum = yut(player);
                break;//윷
            case 8:
                yutNum = yut(player);
                break;//윷
            case 9:
                yutNum = mo(player);
                break;//모
            case 10:
                yutNum = backDo();
                break;//백도

        }
        return yutNum;
    }

    public int nak() {
        return 10;
    }

    public int Do() {
        return 1;
    }

    public int gea() {
        return 2;
    }

    public int gul() {
        return 3;
    }

    public int yut(Player player) {
        player.setYutCount(player.getYutCount() + 1);

        return 4;
    }

    public int mo(Player player) {
        player.setYutCount(player.getYutCount() + 1);
        return 5;
    }

    public int backDo() {
        return -1;
    }

    // 모아니면 도 아이템
    public int moOrDo(Player player) {
        player.setYutCount(player.getYutCount() + 1);
        //아이템 메소드에 가격과 이름 설정
        //Item item = new Item(5, "moOrDo");
        // 랜덤값 1 또는 0, 0이면 모 1이면 도
        if ((int) (Math.random() * 2) == 0) {
            return mo(player);
        } else {
            return Do();
        }
    }

    // Neo 패시브 윷 확률 올리기
    public int neoIncreaseYut(Player player) {

        // 랜덤값 1 또는 0, 0,1이면 윷 2면 낙
        int random = (int) (Math.random() * 3);
        if (random == 0 || random == 1) {
            return 4;
        } else {
            return nak();
        }
    }


    //ryan패시브 첫말*2로 이동
    public int ryanMoveDouble(Player player) {
        int num = throwYut(player);
        return 2 * num;
    }

    //아이템 무조건 백도 메소드
    public int mustBackDo(Player player) {
        //player.setYutCount(player.getYutCount() + 1);
        return -1;
    }

    public static void main(String[] args) {


    }
}
