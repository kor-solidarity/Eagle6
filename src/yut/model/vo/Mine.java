package yut.model.vo;

import javax.swing.JLabel;

import yut.view.GameMap;

public class Mine extends Item {
    public Mine(int grid, JLabel mine) {
        //아이템 부모 클래스에 가격 10송편과 설치 하는곳에 grid값과 이름을 보냄
        super(10,/* grid,*/ "지뢰");
       // GameMap gm = new GameMap();
       

}
}
