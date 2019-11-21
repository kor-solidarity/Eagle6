package yut.view;

import java.awt.Panel;

import javax.swing.JPanel;

import yut.model.vo.Item;
import yut.model.vo.SongPyeon;

public class GameMap {


    // 놀이판 좌표, 안에 실제로 들어가야 하는건 템들.
    private Item[] itemGrid = new Item[29];

    // 생성되면 송편위치 무작위로 넷 찍는걸로
    public GameMap(/*Object[] itemGrid*/JPanel panel) {
        add_or_refresh_songPyeon(panel);
        
    }

    /**
     * 송편을 추가시키는 메소드.
     * 송편은 항상 맵상에 4개가 뜨기 때문에 이를 유지시키기 위함.
     */
    public void add_or_refresh_songPyeon(JPanel panel) {
        // 먼저 송편이 판에 얼마나 있는지부터 확인
        int songPyeons = 0;

        for (int i = 0; i < this.itemGrid.length; i++) {
            // null 이 아닌 경우 뭔가가 있다는 소리.
            if (this.itemGrid[i] != null) {
                songPyeons++;
            }
        }

        // 송편은 무조건 4개여야 한다.
        while (songPyeons < 4) {
            int randomNum = (int) (Math.random() * 28 + 1);
            // 혹시나 1-28 외 것이 나오면 안됨.
            if (1 <= randomNum && randomNum <= 28) {
                // 송편이 이미 있는가? 있으면 안됨
                if (this.itemGrid[randomNum] != null) {
                    continue;
                }
                // 송편이 없으면 만든다. 양은... 우선 1-5
                this.itemGrid[randomNum] = new SongPyeon((int) (Math.random() * 5 + 1), randomNum, panel);
                songPyeons++;
                for(int i=0; i<29;i++) {
                    
                     }
                    
            }
        }


    }

    public Item[] getItemGrid() {
        System.out.println();
        return this.itemGrid;
    }

    public void setItemGrid(Item itemGrid,int indexNum) {
        this.itemGrid[indexNum] = itemGrid;
    }

    // 그리드에 아이템 배치.
    public int setItemOnGrid(Item item, int gridNum) {
        return 0;
    }
    
    public void removeGrid(int grid) {
        System.out.println("제거호출");

        System.out.println(itemGrid[grid].getGrid());
       // itemGrid[grid]= null;
        
        
    }

}
