package yut.model.vo;

import java.util.ArrayList;

public class Mal {
    // 이 말 주인 누구?
    private Player owner;
    private int grid;
    private int num;  // 몇번째말
    // 말이 여태 지나온 길.
    private ArrayList<Integer> routes = new ArrayList();
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
    public void addRoutes(int num){
        this.routes.add(num);
    }
    // routes 초기화. 완주 또는 먹혀서 출발 또는 끝 지점으로 도달할 시 사용
    public void clearRoutes(int num){
        this.routes = new ArrayList<>();
    }

    // 빽도일 경우 뒤로 가기위한 그리드값 반환.
    // 그리고 반환 후 그걸 삭제한다.
    public int getLastRoute(){
        int return_grid = this.routes.get(this.routes.size()-1);
        this.routes.remove(this.routes.size()-1);
        return return_grid;
    }

    public ArrayList getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList routes) {
        this.routes = routes;
    }

    /**
     *
     * @param num : 윷의 결과값
     */
    public void move(int num){
            // num 값 만큼 움직여야함.
            // 와일문을 써서 한번에 한칸씩 움직인다.
            // 한칸 움직인 후에는 그 위치에 벽이 있나 확인한다. 있으면 그대로 종료.

            // num이

            do {
                // 주사위 굴릴때 시작위치
                int start_loc = grid;
                System.out.println("현위치: " + grid);
                // Scanner sc = new Scanner(System.in);
                System.out.println("몇칸감: " + num);
                // int num = sc.nextInt();

                // grid += num;
                while (num > 0){
                    if (grid == -1) {
                        System.out.println("grid == -1");
                        grid = 1;
                        // 우측상단
                    }else if (start_loc == 5){
                        System.out.println("start_loc == 5");
                        grid = 20;
                        // 좌측상단
                    } else if ( start_loc == 10) {
                        System.out.println("start_loc == 10");
                        grid = 25;
                        // 정가운데로
                    }else if (start_loc == 26){
                        System.out.println("정가운데 시작");
                        grid = 22;
                        start_loc = 0;
                        // 정가운데
                    }else if (start_loc == 22 && start_loc != 26) {
                        System.out.println("정가운데 시작");
                        grid = 27;
                    }else if (grid == 26) {
                        System.out.println("정가운데로 이동");
                        grid = 22;
                        start_loc = 26;
                    } else if (grid == 24) {
                        System.out.println("grid == 24");
                        grid = 15;
                    } else if (grid == 19||grid == 28) {
                        System.out.println("grid == 19||grid == 28");
                        grid = 0;
                    } else if (grid == 0) {
                        System.out.println("도착!");
                        break;
                    } else {
                        grid++;
                    }
                    // 초기화 용도. 위에 중복으로 걸리면 곤란하니.
                    if (start_loc != 0 && start_loc != 26){
                        start_loc = 0;
                    }
                    num--;
                }
            }while (true);

    }

    
    public void backDo(){

    }

}
