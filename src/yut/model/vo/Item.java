package yut.model.vo;

import javax.swing.JLabel;

public class Item {
    // 아이템은 맵상에 올라갈 템, 그리고 바로 사용될 일회성 스킬 둘로 나눠진다.
    // 올라갈 템: 송편, 벽, 순간이동, 지뢰
    // 일회성 스킬:

    // 템 가격. 송편인 경우 얻는 양
    private int price;
    // 템이름
    private String name;
    //해당 아이템의 grid 값
    private int grid;

    public Object[] item_num = new Object[6];


    public Item() {
    }

    public Item(int price) {
        this.price = price;
    }

    public Item(int price,/*int grid,JLabel lb,*/ String name) {
        this.price = price;
        //this.grid = grid;
        this.name = name;

    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
	/*public int getGrid() {
		return grid;
	}
	public void setGrid(int grid) {
		this.grid = grid;
	}*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param player
     * @param itemNum
     * @return
     */


}
