package yut.model.vo;

import javax.swing.*;
import java.awt.*;

public class Mission {
    // 미션번호
    int random_mission_num;
    // 미션 완수 여부
    boolean finished = false;
    // 미션 완수한 플레이어 이름
    String winner;

    public Mission(Player player, Mal mal) {

        // 미션번호 무작위로 생성.
        random_mission_num = ((int) (Math.random() * 4)) + 1;
        // 미션 내용 들어갈 사진 위치
        String fileName = "mini/";

        // 번호에 따라 파일명 기입
        switch (random_mission_num){
            case 1:
                System.out.println("미션1");
                fileName += "Mission_1.PNG";break;
            case 2:
                System.out.println("미션2");
                fileName += "Mission_2.PNG";break;
            case 3:
                System.out.println("미션3");
                fileName += "Mission_3.PNG";break;
            case 4:
                System.out.println("미션4");
                fileName += "Mission_4.PNG";break;
        }

        Image missionImg = new ImageIcon(fileName)
                .getImage().getScaledInstance(330, 140, 0);

        // 미션이 표시될 라벨
        JLabel mission_label = new JLabel(new ImageIcon(missionImg));

        mission_label.setLocation(1150, 10);
        mission_label.setSize(330, 140);

        // 미션
        // super();



        // switch(random_mission_num) {
        //     case 1 : firstArrive(null, null); break;
        //
        //     case 2 : firstCatch(null, null); break;
        //
        //     case 3 : firstCenter(null, null); break;
        //
        //     case 4 : firstBackDoCatch(); break;
        // }



    }

    public void firstArrive(Player player, Mal mal) {

        if (mal.getGrid() == -1) {

            player.setSongP(player.getSongP() + 10);
        }



    }

    public void firstCatch(Player player, Mal mal) {


    }

    public void firstCenter(Player player, Mal mal) {

         /*if(mal.getGrid() == 22) {

         //여기다 GUI 미션 완수 팝업창 뜨게?

         player.setSongP(player.getSongP() + 10);*/

    }

    public void firstBackDoCatch() {

    }



}