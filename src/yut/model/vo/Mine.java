package yut.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import yut.view.GameMap;

public class Mine extends Item {
    private JLabel sogplb;
    
    public Mine(int price, int grid, JPanel panel) {
       // super(price, sogplb,"폭탄");

        //마인 객체 생성 및 ui 생성
        int x = MapGrid.GRIDS.get(grid).x;
        int y = MapGrid.GRIDS.get(grid).y;

        //송편 표시 라벨
        Image sogp = new ImageIcon("mini/폭탄.PNG").getImage().getScaledInstance(20, 20, 0);
        JLabel sogplb = new JLabel(new ImageIcon(sogp));
        sogplb.setSize(20, 20);
        sogplb.setLocation(x, y);

        System.out.println("호출");

        panel.add(sogplb);
        panel.revalidate();
        panel.repaint();
        panel.setComponentZOrder(sogplb, 0);


    }

}
