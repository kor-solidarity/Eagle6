package yut.view;

import java.util.Arrays;
import java.util.Scanner;

public class panTest {
    // private Scanner sc = new Scanner(System.in);
    public static void testing() {
        // -1은 아예 미출발.
        int grid = -1;

        do {
            // 주사위 굴릴때 시작위치
            int start_loc = grid;
            System.out.println("현위치: " + grid);
            Scanner sc = new Scanner(System.in);
            System.out.print("몇칸감: ");
            int num = sc.nextInt();

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

    public static void main(String[] args) {
        panTest.testing();
    }
}
