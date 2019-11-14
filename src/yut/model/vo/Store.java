package yut.model.vo;

import yut.model.vo.*;

public class Store {
    // 상점 클래스.
    // 여기서 각 템들이
    public boolean buy(Player player, int itemNum) {
        UpgoDouble ud = new UpgoDouble();
        MoOrDo mod = new MoOrDo();
        Wall w = new Wall();
        Mine m = new Mine();
        BackDo bd = new BackDo();
        Exchange e = new Exchange();
        int[] itemNumArr = {ud.getPrice(), mod.getPrice(), w.getPrice(), m.getPrice(), bd.getPrice(), e.getPrice()};


        if (player.getSongP() >= itemNumArr[itemNum - 1]) {
            player.setSongP(player.getSongP() - itemNumArr[itemNum - 1]);
            // 구매까진 완료, 이제 생성.
            // 생성을 ???????????????????????????????
            // TODO: 2019-11-12 이 메소드로 새 아이템 생성은 곤란한걸로 판단. 별도 방법 강구요망.
            return true;
        }
        return false;
    }

    ;

}
