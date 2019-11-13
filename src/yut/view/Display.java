package yut.view;

import yut.model.vo.Player;

public class Display {
    // private Player[] players;
    // private GameMap map;

    // public Display(Player[] players, GameMap map) {
    //     this.players = players;
    //     this.map = map;
    // }

    // 현재 시각화 포기함. 그냥 텍스트로 뭐가 어딨는지만 본다.

    public Display() {
    }

    public void display(GameMap map){
        // 각 맵에 아이템 파악
        for (int i = 0; i < map.getItemGrid().length; i++) {

        }


        // NULLIFIED - no time
        // 게임 맵과 플레이어 현황 등 모든걸 표기.


        // 송편: S
        // 벽: W
        // 지뢰: M
        // 순간이동: X - 출발, O - 도착
        // 말: 플레이어 캐릭명 첫글자 (R/F/N/A)
        //
        // ○       ○       ○       ○       ○       ○
        // ○                                       ○
        //         ○                       ○
        //             ○               ○
        // ○                   ○                   ○
        //             ○               ○
        // ○                                       ○
        //         ○                       ○
        // ○                                       ○
        // ○       ○       ○       ○       ○       ○
        // 플레이어명(캐릭)
        // 송편:
        // 남은 말:
        // 고유스킬 썼는가: 불리언

        // ...뭐지이게??
        // Object ten = map.itemGrid[10];
        //
        // // 플레이어 하나씩 돌려서 위치 파악.
        // for (int i = 0; i < players.length; i++) {
        //
        // }
        //
        // // 첫줄 10 9 8 7 6 5
        // System.out.printf("○%-7s○%-7s○%-7s○%-7s○%-7s○%-7s\n");
        // // 둘째줄 11 4
        // System.out.printf("○%-19s○%-7s\n");
        // // 25 20
        // System.out.printf("%-8s○%-13s○%-7s\n");
        // // 26 21
        // System.out.printf("%-12s○%-15s○%-7s\n");
        // // 12 22 3
        // System.out.printf("○%-19s○%-19s○%-7s\n");
        // // 23 27
        // System.out.printf("%-12s○%-15s○%-7s\n");
        // // 13 2
        // System.out.printf("○%-39s○%-7s\n");
        // // 24 28
        // System.out.printf("%-8s○%-23s○%-7s\n");
        // // 14 1
        // System.out.printf("○%-39s○%-7s\n");
        // // 15 16 17 18 19 0
        // System.out.printf("○%-7s○%-7s○%-7s○%-7s○%-7s○%-7s");
        // // 🥮 🚧
    }
    
    public void show_mals(Player[] players){
        // 각 플레이어 말 현황 보여주기.
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                continue;
            }
            System.out.println(players[i].getNick() + " 차례");
            for (int j = 0; j < players[i].getMals().length; j++) {
                System.out.println(players[i].getMals()[j].getNum() +
                        "번 말의 위치: " + players[i].getMals()[j].getGrid());


            }
        }
        System.out.println();
    }

}
