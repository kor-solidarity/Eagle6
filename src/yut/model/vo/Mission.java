package yut.model.vo;

public class Mission {

    public void mission(Player player, Mal mal) {

        int random = ((int) Math.random() * 4) + 1;
        int counter = 0;

        switch(random) {
            case 1 : firstArrive(null, null); break;

            case 2 : firstCatch(null, null); break;

            case 3 : firstCenter(null, null); break;

            case 4 : firstBackDoCatch(); break;
        }



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