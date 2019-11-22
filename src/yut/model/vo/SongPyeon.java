package yut.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SongPyeon extends Item {


    public SongPyeon(int price, int grid, JPanel panel) {
        super(price, "송편");

        int x = MapGrid.GRIDS.get(grid).x;
        int y = MapGrid.GRIDS.get(grid).y;

        //송편 표시 라벨
        Image sogp = new ImageIcon("mini/송편접시.PNG").getImage().getScaledInstance(80, 80, 0);
        JLabel sogplb = new JLabel(new ImageIcon(sogp));
        sogplb.setSize(80, 80);
        sogplb.setLocation(x, y);

        System.out.println("호출");

        panel.add(sogplb);
        panel.revalidate();
        panel.repaint();
        panel.setComponentZOrder(sogplb, 0);


    }


}
