package yut.model.vo;

import java.util.ArrayList;

public class MapGrid {

    public static ArrayList<MapGrid> GRIDS = new ArrayList<>();

    public int x;
    public int y;
    static {
        // 0
        GRIDS.add(new MapGrid(990, 640));
        GRIDS.add(new MapGrid(990, 510));
        GRIDS.add(new MapGrid(990, 390));
        GRIDS.add(new MapGrid(990, 280));
        GRIDS.add(new MapGrid(990, 170));
        GRIDS.add(new MapGrid(990, 65));
        // 6
        GRIDS.add(new MapGrid(855, 65));
        GRIDS.add(new MapGrid(735, 65));
        GRIDS.add(new MapGrid(615, 65));
        GRIDS.add(new MapGrid(495, 65));
        GRIDS.add(new MapGrid(350, 65));
        // 11
        GRIDS.add(new MapGrid(350, 180));
        GRIDS.add(new MapGrid(350, 290));
        GRIDS.add(new MapGrid(350, 400));
        GRIDS.add(new MapGrid(350, 510));
        GRIDS.add(new MapGrid(350, 640));
        // 16
        GRIDS.add(new MapGrid(475, 640));
        GRIDS.add(new MapGrid(605, 640));
        GRIDS.add(new MapGrid(735, 640));
        GRIDS.add(new MapGrid(865, 640));
        GRIDS.add(new MapGrid(860, 188));
        // 21
        GRIDS.add(new MapGrid(790, 245));
        GRIDS.add(new MapGrid(685, 350));
        GRIDS.add(new MapGrid(565, 435));
        GRIDS.add(new MapGrid(495, 510));
        GRIDS.add(new MapGrid(475, 188));
        // 26
        GRIDS.add(new MapGrid(560, 245));
        GRIDS.add(new MapGrid(790, 435));
        GRIDS.add(new MapGrid(865, 510));
    }

    public MapGrid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        System.out.println("MapGrid.GRIDS.size() " + MapGrid.GRIDS.size());
        for (int i = 0; i < MapGrid.GRIDS.size(); i++) {
            System.out.println("x: " + MapGrid.GRIDS.get(i).x + " y: " + MapGrid.GRIDS.get(i).y);
        }
        
    }
}
