package yut.model.vo;
import yut.model.vo.*;
public class Store {
    // ���� Ŭ����.
    // ���⼭ �� �۵���
    public boolean buy(Player player, int itemNum){
    	UpgoDouble ud = new UpgoDouble();
    	MoOrDo mod = new MoOrDo();
    	Wall w = new Wall();
    	Mine m = new Mine();
    	BackDo bd = new BackDo();
    	Exchange e = new Exchange();
    	int[] itemNumArr = {ud.getPrice(), mod.getPrice(), w.getPrice(), m.getPrice(), bd.getPrice(), e.getPrice()};
    	
    	
    	
        if (player.getSongP()>=itemNumArr[itemNum-1]){
            player.setSongP(player.getSongP()-itemNumArr[itemNum-1]);
            // ���ű��� �Ϸ�, ���� ����.
            // ������ ???????????????????????????????
            // TODO: 2019-11-12 �� �޼ҵ�� �� ������ ������ ����Ѱɷ� �Ǵ�. ���� ��� �������.
            return true;
        }
        return false;
    };
    
}
