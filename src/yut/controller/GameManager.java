package yut.controller;

import yut.view.*;
import yut.model.vo.*;

import java.util.Scanner;

public class GameManager {
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        Display disp = new Display();
        Yut yut = new Yut();

        Apeach apeach = null;
        Frodo frodo = null;
        Neo neo = null;
        Ryan ryan = null;
        int playerNums = 0;
        Player[] players = new Player[4];

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("name: ");
            String name = sc.nextLine();
            System.out.println("who will you pick");
            if (apeach == null) {
                System.out.println("0 Apeach");
            }
            if (frodo == null) {
                System.out.println("1 Frodo");
            }
            if (neo == null) {
                System.out.println("2 Neo");
            }
            if (ryan == null) {
                System.out.println("3 Ryan");
            }
            int pick = sc.nextInt();
            sc.nextLine();
            switch (pick) {
                case 0:
                    apeach = new Apeach(name);
                    break;
                case 1:
                    frodo = new Frodo(name);
                    break;
                case 2:
                    neo = new Neo(name);
                    break;
                case 3:
                    ryan = new Ryan(name);
                    break;
                default:
                    System.out.println("잘못쳤으니 처음부터 시작");
                    continue;
            }
            playerNums++;

            if (playerNums > 1) {
                System.out.print("will there be more players? (y/n)");
                char yn = sc.nextLine().charAt(0);

                if (yn == 'n' || yn == 'N') {
                    break;
                }
            }

        } while (true);

        players[0] = apeach;
        players[1] = frodo;
        players[2] = neo;
        players[3] = ryan;
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                System.out.println("players[" + i + "] " + players[i].toString());
            }
        }

        // 턴
        int turns = 1;
        GameMap gameMap = new GameMap();

        // 실제 게임플레이.
        do {
            /*
            * 절차:
            * 먼저 놀이판·플레이어 등 현황을 보여준다.
            * 1. 판 현황
            * 2. 플레이어 현황 - 집에 말 수, 송편, 던진 윷 결과들, 남은 던질 수 있는 윷.
            * 3. 샵
            *
            * "뭘 할것인가? " - 그리고 선택지.
            * 1. 윷 던지기
            * 2. 템 구매하기
            *   - 구매가능여부 확인. 이는
            *   - 가능하면 차감하고 배치시킴.
            * 3. 말 움직이기.
            *
            * 3 이 됬을 시 나올 경우의 수:
            *   1. 그냥 움직이고 끝 - 그냥 끝
            *   2. 다른 말을 먹었다 - 던질 찬스 추가
            *   3. 함정에 걸렸다
            *       - 어피치의 경우 개인스킬 안썼으면 발동.
            *       - 함정 걸려서 끝.
            *   4. 송편에 걸렸다.
            *       - 판에 송편 없애고 그만큼의 값을 플레이어 송편에 추가한다
            *   5. 완주.
            *       - 그리드 위치 맵값을 초과한다.
            *
            * 모든 플레이어 동일하게 반복.
            * 다 끝나면 GameMap 에 현황파악.
            * 1. 게임 맵에 송편 갱신.
            *
            *
            *
            * */

            // 놀이판 보여주기
            // gm.display(players, gameMap);
            // 각 말 현황
            disp.show_mals(players);

            // 보드 현황(템 어디 떨궈져있는지)
            disp.display(gameMap);

            // 플레이어 순서대로 턴 돌리기
            for (int i = 0; i < players.length; i++) {
                // 플레이어가 null 이면 없다는 소리, 다음.
                if (players[i] == null){
                    continue;
                }
                // 플레이어 선택지
                do {
                    System.out.println(players[i].getNick() + "(" + players[i].getCharName() + ") 의 차례");
                    // * 2. 플레이어 현황 - 집에 말 수, 송편, 던진 윷 결과들, 남은 던질 수 있는 윷.
                    // System.out.println("말 위치");
                    disp.show_mals(new Player[] {players[i]} );
                    // 윷던지기 남은 수
                    System.out.println("던질수있는 윷: " + players[i].getYutCount());
                    // 플레이어의 특수능력 및 사용가능여부.

                    // 말 위치 보여줬으면 이제 주사위를 던질지, 샵구매를 할지 움직일지 정한다.
                    System.out.println("선택지:");
                    System.out.println("1. 주사위 던지기");
                    System.out.println("2. 말 움직이기");
                    System.out.println("3. 아이템 구매");
                    // System.out.println("4. 현황 다시보기");

                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice){
                        case 1:
                            // 윷 던진다. 이때 우선: 고유스킬을 사용했는지,
                            // 사용을 안했으면 이 캐릭이 누구인지 확인을 먼저 해야하고 이를 반영한다.
                            System.out.println("윷 던진다. ");
                            // 또한 캐릭이 어피치인 경우도 고유스킬이 이동관련이 아니기 때문에 무시한다.
                            if (players[i].isSpecialty() && (players[i] instanceof Apeach)){
                                // 라이언이면 이동 두배

                            }
                    }




                    // debugging purpose
                    break;
                }while (true);


            }
            break;
        }while (true);
        // 선택 끝
        // 지도보이기.

        // 윷던지는 방법:
        //
    }


    /**
     * 디스플레이에 떠야할 것들:
     * 말, 템.
     *
     * @return 윷 결과값
     */
    // public int roll_yut(){}

    public void display(Player[] players, GameMap map){
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


        // Item ten = map.itemGrid[10];

        // 첫줄 10 9 8 7 6 5
        System.out.printf("○       ○       ○       ○       ○       ○\n");
        // 둘째줄 11 4
        System.out.printf("○                                       ○\n");
        // 25 20
        System.out.printf("        ○                       ○\n");
        // 26 21
        System.out.printf("            ○               ○\n");
        // 12 22 3
        System.out.printf("○                   ○                   ○\n");
        // 23 27
        System.out.printf("            ○               ○\n");
        // 13 2
        System.out.printf("○                                       ○\n");
        // 24 28
        System.out.printf("        ○                       ○\n");
        // 14 1
        System.out.printf("○                                       ○\n");
        // 15 16 17 18 19 0
        System.out.printf("○       ○       ○       ○       ○       ○");
        // 🥮 🚧
    }

}
