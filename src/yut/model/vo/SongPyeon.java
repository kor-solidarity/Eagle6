package yut.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SongPyeon extends Item {
private static JLabel sogplb;

    public SongPyeon(int price, int grid, JPanel panel) {
        
        
        super(price, sogplb, "송편",panel);

        int x = MapGrid.GRIDS.get(grid).x;
        int y = MapGrid.GRIDS.get(grid).y;

        //송편 표시 라벨
        Image sogp = new ImageIcon("mini/송편접시.PNG").getImage().getScaledInstance(50, 50, 0);
        sogplb = new JLabel(new ImageIcon(sogp));
        sogplb.setSize(50, 50);
        sogplb.setLocation(x+10, y+20);

        System.out.println("호출");

        panel.add(sogplb);
        panel.revalidate();
        panel.repaint();
   


    }


}
