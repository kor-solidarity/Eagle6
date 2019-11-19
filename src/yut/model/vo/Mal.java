package yut.model.vo;

import yut.view.GamePage;

import java.util.ArrayList;

public class Mal {
    // 이 말 주인 누구?
    private Player owner;
    private int grid;
    private int num;  // 몇번째말
    // 말이 여태 지나온 길.
    private ArrayList<Integer> routes = new ArrayList();

    private MapGrid mapGrid;

    // 그리드 -1일때 위치할 곳.
    private int init_x;
    private int init_y;


   // { 2, 3, 4, 5}
    // Integer[] route = new Integer[];

    public Mal(int num) {
        this.grid = -1;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Mal{" +
                "grid=" + grid +
                ", num=" + num +
                ", routes=" + routes +
                '}';
    }

    public int getInit_x() {
        return init_x;
    }

    // init_x, init_y 설정
    public void setInit_xy(int x, int y) {
        this.init_x = x;
        this.init_y = y;
    }

    public int getInit_y() {
        return init_y;
    }


    public int getGrid() {
        return grid;
    }

    public void setGrid(int grid) {
        this.grid = grid;
    }

    public Player getOwner() {
        return owner;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    // routes 에 숫자 추가:
    public void addRoutes(int num) {
        this.routes.add(num);
    }

    // routes 초기화. 완주 또는 먹혀서 출발 또는 끝 지점으로 도달할 시 사용
    public void clearRoutes(int num) {
        this.routes = new ArrayList<>();
    }

    // 빽도일 경우 뒤로 가기위한 그리드값 반환.
    // 그리고 반환 후 그걸 삭제한다.
    public int getLastRoute() {
        int return_grid = this.routes.get(this.routes.size() - 1);
        this.routes.remove(this.routes.size() - 1);
        return return_grid;
    }

    public ArrayList getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList routes) {
        this.routes = routes;
    }

    /**
     * @param move_num : 윷의 결과값
     */
    public void move(int move_num, GamePage gp){
            // num 값 만큼 움직여야함.
            // 와일문을 써서 한번에 한칸씩 움직인다.
            // 한칸 움직인 후에는 그 위치에 벽이 있나 확인한다. 있으면 그대로 종료.

            // num이

        if (move_num <= 0) {
            return;
        }



        // 말이 움직이기 시작한 최초위치.
        int start_grid = this.getGrid();
        System.out.println("출발위치 " + start_grid);

        // move_num 이 0이 아니면 계속 갈 수 있다는 소리
        while (move_num > 0) {
            System.out.println("moving");
            // 처음 출발하는 말.
            if (this.getGrid() == -1) {
                this.setGrid(1);
                gp.ryan_body_label1.setLocation(MapGrid.GRIDS.get(1).x, MapGrid.GRIDS.get(1).y);

            } else if (this.getGrid() == 5) {
                // 우측상단에 있으니 대각 진입
                this.setGrid(20);
                gp.ryan_body_label1.setLocation(MapGrid.GRIDS.get(20).x, MapGrid.GRIDS.get(20).y);
            } else if (this.getGrid() == 10) {
                // 좌측상단에 있으니 대각 진입
                this.setGrid(25);
                gp.ryan_body_label1.setLocation(MapGrid.GRIDS.get(25).x, MapGrid.GRIDS.get(25).y);

            } else if (this.getGrid() == 26) {
                // 정가운데 좌측상단 바로 옆에 있으니 정가운데로
                this.setGrid(22);
                gp.ryan_body_label1.setLocation(MapGrid.GRIDS.get(22).x, MapGrid.GRIDS.get(22).y);
            } else if (this.getGrid() == 22 && start_grid == 22) {
                // 정가운데에 위치하고 있고 정가운데에서 출발한 경우
                // 우측하단으로 내려간다.
                this.setGrid(27);
                gp.ryan_body_label1.setLocation(MapGrid.GRIDS.get(27).x, MapGrid.GRIDS.get(27).y);
            } else if (this.getGrid() == 24) {
                // 대각에 나와서 좌측하단 모서리 도착
                this.setGrid(15);
                gp.ryan_body_label1.setLocation(MapGrid.GRIDS.get(15).x, MapGrid.GRIDS.get(15).y);
            } else if (this.getGrid() == 19 || this.getGrid() == 28) {
                // 19 || 28 걸렸다면 마지막 칸이라는거.
                this.setGrid(0);
                gp.ryan_body_label1.setLocation(MapGrid.GRIDS.get(0).x, MapGrid.GRIDS.get(0).y);
            } else if (this.getGrid() == 0) {
                // 0까지 왔으면 도착했다는 소리.
                this.setGrid(29);
                gp.ryan_body_label1.setLocation(MapGrid.GRIDS.get(29).x, MapGrid.GRIDS.get(29).y);
            } else {
                // 위에 해당사항 없으면 그냥 1추가
                this.setGrid(this.getGrid() + 1);
                gp.ryan_body_label1.setLocation(MapGrid.GRIDS.get(this.getGrid() ).x,
                        MapGrid.GRIDS.get(this.getGrid()).y);
            }

            System.out.println(" 최종위치 " + this.getGrid());
            System.out.println("x "+gp.ryan_body_label1.getX() + " y " + gp.ryan_body_label1.getY());
            System.out.println();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            move_num--;
        }
            // do {
            //     // 주사위 굴릴때 시작위치
            //     int start_loc = grid;
            //     System.out.println("현위치: " + grid);
            //     // Scanner sc = new Scanner(System.in);
            //     System.out.println("몇칸감: " + num);
            //     // int num = sc.nextInt();
            //
            //     // grid += num;
            //     while (num > 0){
            //         if (grid == -1) {
            //             System.out.println("grid == -1");
            //             grid = 1;
            //             // 우측상단
            //         }else if (start_loc == 5){
            //             System.out.println("start_loc == 5");
            //             grid = 20;
            //             // 좌측상단
            //         } else if ( start_loc == 10) {
            //             System.out.println("start_loc == 10");
            //             grid = 25;
            //             // 정가운데로
            //         }else if (start_loc == 26){
            //             System.out.println("정가운데 시작");
            //             grid = 22;
            //             start_loc = 0;
            //             // 정가운데
            //         }else if (start_loc == 22 && start_loc != 26) {
            //             System.out.println("정가운데 시작");
            //             grid = 27;
            //         }else if (grid == 26) {
            //             System.out.println("정가운데로 이동");
            //             grid = 22;
            //             start_loc = 26;
            //         } else if (grid == 24) {
            //             System.out.println("grid == 24");
            //             grid = 15;
            //         } else if (grid == 19||grid == 28) {
            //             System.out.println("grid == 19||grid == 28");
            //             grid = 0;
            //         } else if (grid == 0) {
            //             System.out.println("도착!");
            //             break;
            //         } else {
            //             grid++;
            //         }
            //         // 초기화 용도. 위에 중복으로 걸리면 곤란하니.
            //         if (start_loc != 0 && start_loc != 26){
            //             start_loc = 0;
            //         }
            //         num--;
            //     }
            // }while (true);

    }


    public void backDo(){

    }

}
