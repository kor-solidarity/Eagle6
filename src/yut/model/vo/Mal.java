package yut.model.vo;

import yut.view.GameMap;
import yut.view.GamePage;
import yut.view.MainFrame;

import yut.model.vo.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Mal {
    // 이 말 주인 누구? - 닉
    private String owner;
    // 플레이어가 배열 몇번째인가?
    private int player_num;
    private int grid;
    private int num;  // 몇번째말
    // 말이 여태 지나온 길.
    private ArrayList<Integer> routes = new ArrayList();

    private MapGrid mapGrid;

    private MainFrame mf;


    // 그리드 -1일때 위치할 곳.
    private int init_x;
    private int init_y;

    // 판 내 좌표 위치. 겹칠때 위치 다르게 하려고 놓은거임.
    private int strafe_x;
    private int strafe_y;
    
    //=======미션 카운트======= -> 다영
    public static int cou = 1;
    public static int cou2 = 1;
    public static int cou3 = 1;
    public static int cou4 = 1;


    // { 2, 3, 4, 5}
    // Integer[] route = new Integer[];

    //=======미션 카운트======= -> 다영
    public static int cou = 1;
    public static int cou2 = 1;
    public static int cou3 = 1;
    public static int cou4 = 1;


    // { 2, 3, 4, 5}
    // Integer[] route = new Integer[];

    public Mal(int num, String ownerName) {
        this.grid = -1;
        this.num = num;
        this.owner = ownerName;
    }



    @Override
    public String toString() {
        return "Mal{" +
                "owner='" + owner + '\'' +
                ", player_num=" + player_num +
                ", grid=" + grid +
                ", num=" + num +
                ", routes=" + routes +
                ", mapGrid=" + mapGrid +
                ", init_x=" + init_x +
                ", init_y=" + init_y +
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

    public String getOwner() {
        return owner;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    // routes 에 숫자 추가:
    public void addRoutes(int num) {
        this.routes.add(num);
    }

    public void setRoutes(ArrayList routes) {
        this.routes = routes;
    }

    /**
     * @param playerIndexNum - 지금 차례인 플레이어 배열번호
     * @param TRUEYUTGAP     - 이동해야할 윷값, static
     * @param mal_labels     - 게임 내 모든 말의 라벨
     * @param gp             - 게임페이지 그 자체.
     * @param player         - 지금 이 말의 플레이어.
     */
    public void move(int playerIndexNum, int TRUEYUTGAP, JLabel[][] mal_labels, GamePage gp, Player player) {
        if (TRUEYUTGAP == 0) {
            return;
        }

        int move_num = TRUEYUTGAP;
        // num 값 만큼 움직여야함.
        // 와일문을 써서 한번에 한칸씩 움직인다.
        // 한칸 움직인 후에는 그 위치에 벽이 있나 확인한다. 있으면 그대로 종료.
        System.out.println("mal.move()");
        for (int i = 0; i < mal_labels.length; i++) {
            System.out.println("i " + i);
            for (int j = 0; j < mal_labels[i].length; j++) {
                System.out.println("j " + j + " " + mal_labels[i][j]);
            }

        }

        // TODO: 2019-11-23 지금 안되는 작업
        //  1 말 업어 움직이기 + 업힐때
        //  2 아이템..
        System.out.println("move_num " + move_num);

        /*
         * 말 업기 위한 방법:
         * 우선 같은 칸에 같은 말이 있는지 확인한다.
         * 있으면 같이 이동시킬 말 객체로 가져온다.
         * 이제 이동.
         * 겹친 말은 같이 움직인다. 다만 마지막 갈때만 이동.
         * 현재 애니메이션 구현이 무리가 된 상황이니 이리 놓는거.
         *
         */


        // 이 객체와 연결된 말
        JLabel my_mal = mal_labels[playerIndexNum][this.num];
        // 말이 움직이기 시작한 최초위치.
        int start_grid = this.getGrid();
        System.out.println("출발위치 " + start_grid);
        // move_num 이 마이너스면 빽도 발동
        if (move_num < 0) {
            this.backDo(playerIndexNum, mal_labels, gp, my_mal);
        } else {
            // move_num 이 0이 아니면 계속 갈 수 있다는 소리
            while (move_num > 0) {

                // 루트 추가: 이동직전 현위치를 넣는다.
                // 다만, 첫 출발일 경우 -1로 넣으면 안되니 유의
                if (this.getGrid() == -1) {
                    this.addRoutes(0);
                } else {
                    this.addRoutes(this.getGrid());
                }

                System.out.println("moving");
                // 처음 출발하는 말.
                if (this.getGrid() == -1) {
                    this.setGrid(1);
                    my_mal.setLocation(MapGrid.GRIDS.get(1).x, MapGrid.GRIDS.get(1).y);

                } else if (this.getGrid() == 5 && start_grid == 5) {
                    // 우측상단에서 출발했으니 대각 진입
                    this.setGrid(20);
                    my_mal.setLocation(MapGrid.GRIDS.get(20).x, MapGrid.GRIDS.get(20).y);
                } else if (this.getGrid() == 10 && start_grid == 10) {
                    // 좌측상단에서 출발했으니 대각 진입
                    this.setGrid(25);
                    my_mal.setLocation(MapGrid.GRIDS.get(25).x, MapGrid.GRIDS.get(25).y);

                } else if (this.getGrid() == 26) {
                    // 정가운데 좌측상단 바로 옆에 있으니 정가운데로
                    this.setGrid(22);
                    my_mal.setLocation(MapGrid.GRIDS.get(22).x, MapGrid.GRIDS.get(22).y);
                } else if (this.getGrid() == 22 && (start_grid == 22 || start_grid == 10 || start_grid == 25 || start_grid == 26)) {
                    // 정가운데에 위치하고 있고 정가운데에서 출발한 경우
                    // 그리고 좌측상단에서 가운대로 내려온 모든 경우

                    // 우측하단으로 내려간다.
                    this.setGrid(27);
                    my_mal.setLocation(MapGrid.GRIDS.get(27).x, MapGrid.GRIDS.get(27).y);
                } else if (this.getGrid() == 24) {
                    // 대각에 나와서 좌측하단 모서리 도착
                    this.setGrid(15);
                    my_mal.setLocation(MapGrid.GRIDS.get(15).x, MapGrid.GRIDS.get(15).y);
                } else if (this.getGrid() == 19 || this.getGrid() == 28) {
                    // 19 || 28 걸렸다면 마지막 칸이라는거.
                    this.setGrid(0);
                    my_mal.setLocation(MapGrid.GRIDS.get(0).x, MapGrid.GRIDS.get(0).y);
                } else if (this.getGrid() == 0) {
                    // 0까지 왔으면 도착했다는 소리.
                    this.setGrid(29);
                    // 여기까지 왔으면 끝, 말을 보여주는 레이블을 없애버린다.
                    my_mal.setVisible(false);
                    break;
                } else {
                    // 위에 해당사항 없으면 그냥 1추가
                    this.setGrid(this.getGrid() + 1);
                    my_mal.setLocation(MapGrid.GRIDS.get(this.getGrid()).x,
                            MapGrid.GRIDS.get(this.getGrid()).y);
                }
                System.out.println(" 최종위치 " + this.getGrid());
                System.out.println("x " + my_mal.getX() + " y " + my_mal.getY());
                System.out.println();

                my_mal.repaint();
                move_num--;

                // 한칸 이동 완료.
                // 안에 장애물(벽) 있나 확인

            }
        }

        
        // 미션 확인용 용도 - 다영
        boolean confirmM = false;
        // 돌거 다 돌았음.
        // 이제 말 잡기 - 모든 말 한번씩 스크리닝 해서 같은 곳에 위치하면 잡는다.
        // 말의 그리드가 -1 또는 29면 판에 있는게 아니니 실행할 필요가 없다.

        
        // 미션 확인용 용도 - 다영
        boolean confirmM = false;
        
        if (!(this.getGrid() == 29 || this.getGrid() == -1)) {
            // 아래 플레이어 확인용도
            int playerArrayNum = -1;

            // 플레이어 포문
            for (Player p : gp.players) {
                // 임시조치. 그냥 널이 있는지 확인용도
                if (p == null) {
                    System.out.println("p == null");
                    continue;
                }

                System.out.println("player p.getNick() " + p.getNick());
                System.out.println("current piece this.owner: " + this.owner);
                System.out.println("p.getNick().equals(this.owner) " + p.getNick().equals(this.owner));

                playerArrayNum++;
                // 플레이어가 없거나 지금 말주인과 갈은 사람이면 통과
                if (p == null || p.getNick().equals(this.owner)) {
                    continue;
                }


                // 아래 말번호 확인용도
                int malNum = 0;
                // 각 말 뒤적이기
                for (Mal m : p.getMals()) {
                    // 같은 위치에 있으면 잡힌거.
                    if (m.getGrid() == this.getGrid()) {
                        // 그리드 위치 원위치
                        m.setGrid(-1);
                        // GUI 말 위치도 원위치
                        mal_labels[playerArrayNum][malNum].setLocation(
                                m.getInit_x(), m.getInit_y()
                        );
                        //미션 확인용 - 다영
                        confirmM = true;


                        //미션 확인용 - 다영
                        confirmM = true;
                    }
                    malNum++;
                }

            }

        }
        
      //====================미션==================== -> 다영
        //while문 안에 있으면 말이 한칸씩 움직이기 때문에 그냥 가운데를 지나가도 미션이 완수되서 while문 밖으로 뺌
        //System.out.println("미션완료: " + cou);
        
        //미션 클래스의 랜덤 미션과 맞추기 위해 미션 
        Mission m = new Mission(mf, gp.gamePanel);
        
        //미션 1번 - 1등으로 들어오기
        if(m.missionNum == 1 && cou == 1) {
            
            if(this.getGrid() == 0) {
                System.out.println("======미션 1번 성공======");
                m.confirmMission(mf);
            }
        }
        
        //미션 2번 - 처음으로 윷 나오기
        if(m.missionNum == 2 && cou2 == 1) {
            
            if(gp.YUTGAP == 4) {
                 
                System.out.println("======미션 2번 성공======");
                m.confirmMission(mf);   
            }
        }
        
        //미션 3번 - 정중앙에 1등으로 가기
        if(m.missionNum == 3 && cou3 == 1) {
            
            if(this.getGrid() == 5) { //22
                System.out.println("======미션 3번 성공======");
                m.confirmMission(mf);
            }
        }
        
        //미션 4번 - 빽도로 플레이어 잡기
        if(m.missionNum == 4 && cou4 == 1) {
            
            if(confirmM == true) {
                System.out.println("=====미션 4번 성공 =====");
                m.confirmMission(mf);
            }
            
        }
        
        
       //================여기 까지 미션 ===================



        // 이제 아이템이 있는지 확인.
        // if (GameMap)
        
        //====================미션==================== -> 다영
        //while문 안에 있으면 말이 한칸씩 움직이기 때문에 그냥 가운데를 지나가도 미션이 완수되서 while문 밖으로 뺌
        //System.out.println("미션완료: " + cou);
        
        //미션 클래스의 랜덤 미션과 맞추기 위해 미션 
//        Mission m = new Mission(mf, gp.gamePanel);
//        
//        //미션 1번 - 1등으로 들어오기
//        if(m.missionNum == 1 && cou == 1) {
//            
//            if(this.getGrid() == 0) {
//                System.out.println("======미션 1번 성공======");
//                m.confirmMission(mf);
//            }
//        }
//        
//        //미션 2번 - 처음으로 윷 나오기
//        if(m.missionNum == 2 && cou2 == 1) {
//            
//            if(gp.YUTGAP == 4) {
//                 
//                System.out.println("======미션 2번 성공======");
//                m.confirmMission(mf);   
//            }
//        }
//        
//        //미션 3번 - 정중앙에 1등으로 가기
//        if(m.missionNum == 3 && cou3 == 1) {
//            
//            if(this.getGrid() == 5) { //22
//                System.out.println("======미션 3번 성공======");
//                m.confirmMission(mf);
//            }
//        }
//        
//        //미션 4번 - 빽도로 플레이어 잡기
//        if(m.missionNum == 4 && cou4 == 1) {
//            
//            if(confirmM == true) {
//                System.out.println("=====미션 4번 성공 =====");
//                m.confirmMission(mf);
//            }
//            
//        }
//        




        //위에 모든 이동절차가 끝났으면
        //업혔던 말 이동한다.
        //만일 애니메이션 넣기로 되면 이거 엎어야함.
        //Mal m을 Mal mal로 수정

        for (Mal mal : player.getMals()) {
            // 말중에 지금 말과 같은 위치에 존재하는 말이 있는지 확인한다. 그게 업힌 말임.
            if (mal.getGrid() == start_grid) {
                // 그리드값 좌표 가져오기.
                int gridX = MapGrid.GRIDS.get(this.getGrid()).x;
                int gridY = MapGrid.GRIDS.get(this.getGrid()).y;
                // 그리드 재조정
                mal.setGrid(this.getGrid());
                // 그리드 -1, 29 등인 경우를 따로 해줘야함.

                if (mal.getGrid() == 29) {
                    // 29인 경우 완주한거임. 고로 없애준다.
                    mal_labels[playerIndexNum][this.num].setVisible(false);
                } else if (mal.getGrid() == -1) {
                    // 시작위치로 간 경우
                    mal_labels[playerIndexNum][this.num].setLocation(
                            mal.getInit_x(), mal.getInit_y());
                } else {
                    mal_labels[playerIndexNum][this.num].setLocation(gridX, gridY);
                }
            }
        }
    }


    public void backDo(int playerNum, JLabel[][] mals, GamePage gp, JLabel my_mal) {

        // 빽도는 기본적으로 여태 찍어둔 거리목록에서
        // 가장 마지막에 있는 그리드값으로 간다.
        if (this.routes.size() > 0) {
            // 빽도 - 뒤로 갈 목적지.
            int desto_grid = this.routes.get(this.routes.size() - 1);
            // 값 받았으면 바로 삭제.
            this.routes.remove(this.routes.size() - 1);
            // 그리드 위치 빽도 반영
            this.setGrid(desto_grid);
            my_mal.setLocation(MapGrid.GRIDS.get(desto_grid).x,
                    MapGrid.GRIDS.get(desto_grid).y);
        } else {
            // 위 안걸렸다면 최초 도나오고 빽나온 후 또 빽도 걸렸다는거임.
            if (this.getGrid() == 0) {
                // 바로 뒤로 보낸다
                this.setGrid(19);
                // 그리고 보내진 위치로 이동
                my_mal.setLocation(MapGrid.GRIDS.get(this.getGrid()).x,
                        MapGrid.GRIDS.get(this.getGrid()).y);

            } else {
                // 엘스라는건 그저 뒤로 가는거.
                this.setGrid(this.getGrid() - 1);
                my_mal.setLocation(MapGrid.GRIDS.get(this.getGrid()).x,
                        MapGrid.GRIDS.get(this.getGrid()).y);
            }


        }

    }

}
