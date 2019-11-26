package yut.view;

import java.util.Random;

import yut.model.vo.Item;
import yut.model.vo.Player;

public class YutMadeByCho {

    int yutNum = 0;//윷결과값저장하는 변수

    public int mainYut(int num, Player player) {


        switch (num) {
            case 1:
                yutNum = throwYut(player);
                break;
            case 2:
                yutNum = moOrDo(player);

                break;

            case 3:
                yutNum = neoIncreaseYut(player);
                break;
            /*case 4:
                yutNum = ryanMoveDouble(player);
                break;*/
            case 5:
                yutNum = mustBackDo(player);
                break;
        }
        return yutNum;

    }

    //윷확률, 결과값 받을 메소드
    // 기본 윷던지기
    public int throwYut(Player player) {
        //랜덤값으로 윷확률 받기
        int finished_horses = 0;
        boolean finished = false;
        // 말 다 돌았는지 확인.

        for (int i = 0; i < player.getMals().length; i++) {
            if (player.getMals()[i].getGrid() >= 0 && player.getMals()[i].getGrid() <= 29) {
                finished = true;
            }
        }

        if (finished) {
            int yutRate = new Random().nextInt(20) + 1;
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
                    yutNum = gul();
                    break;//모
                case 10:
                    yutNum = backDo();
                    break;//백도
                case 11:
                    yutNum = gea();
                    break;//낙나왔을때
                case 12:
                    yutNum = Do();
                    break;//도
                case 13:
                    yutNum = gea();
                    break;//개
                case 14:
                    yutNum = gea();
                    break;//개
                case 15:
                    yutNum = gul();
                    break;//걸
                case 16:
                    yutNum = gul();
                    break;//걸
                case 17:
                    yutNum = Do();
                    break;//윷
                case 18:
                    yutNum = gul();
                    break;//윷
                case 19:
                    yutNum = mo(player);
                    break;//모
                case 20:
                    yutNum = backDo();
                    break;//백도


            }


        } else {
            int yutRate = new Random().nextInt(20) + 1;
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
                    yutNum = gul();
                    break;//걸
                case 10:
                    yutNum = gea();
                    break;//백도
                case 11:
                    yutNum = gea();
                    break;//낙나왔을때
                case 12:
                    yutNum = Do();
                    break;//도
                case 13:
                    yutNum = gea();
                    break;//개
                case 14:
                    yutNum = gea();
                    break;//개
                case 15:
                    yutNum = gul();
                    break;//걸
                case 16:
                    yutNum = gul();
                    break;//걸
                case 17:
                    yutNum = gea();
                    break;//개
                case 18:
                    yutNum = gul();
                    break;//걸
                case 19:
                    yutNum = mo(player);
                    break;//모
                case 20:
                    yutNum = Do();
                    break;//백도

            }
        }
        return yutNum;
    }

    public int nak() {
        return 0;
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

        return 4;
    }

    public int mo(Player player) {

        return 5;
    }

    public int backDo() {
        return -1;
    }

    // 모아니면 도 아이템
    public int moOrDo(Player player) {

        // 랜덤값 1 또는 0, 0이면 모 1이면 도
        if ((int) (Math.random() * 2) == 0) {
            return 5;
        } else {
            return 1;
        }
    }

    // Neo 패시브 윷 확률 올리기
    public int neoIncreaseYut(Player player) {

        // 랜덤값 1 또는 0, 0,1이면 윷 2면 낙
        int random = (int) (Math.random() * 3);
        if (random == 0 || random == 1) {
            return 4;
        } else {
            return 4;
        }
    }


    //아이템 무조건 백도 메소드
    public int mustBackDo(Player player) {

        return -1;
    }

    public static void main(String[] args) {


    }
}
