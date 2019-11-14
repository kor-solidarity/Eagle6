package yut.view;

import javax.swing.JFrame;

public class Yut extends JFrame{
    // 윷에 나와야할 것들.
    // 낙 나올 확률
    // 빽도확률: 1 나왔을때 1/4
    // 1-5 나오게


    public Yut() {
    }

    public int throw_yut(){
       //return은 이동할 칸수
        // 낙 계산
        if ((int)(Math.random()*10) == 0){
            return 0;
        }
        // 여기서 던짐, num=윷값
        int num = (int)(Math.random()*5 + 1);
        // 도가 나왔으면 백도 계산
        if (num == 1 && (int)(Math.random()*4) == 0){
           //말 4개중 백도그림이 있는 말인지 아닌지 확인함
            return -1;
        }
        return num;
    }

    // 모아니면 도
    public int modo(){
        // 랜덤값 1 또는 0, 0이면 모 1이면 도
        if ((int)(Math.random()*2) == 0){
            return 5;
        }else {
            return 1;
        }
    }

    // 윷 확률 올리기
    public int increaseYut(){
        // 랜덤값 1 또는 0, 0이면 모 1이면 도
        if ((int)(Math.random()*2) == 0){
            return 4;
        }else {
            return throw_yut();
        }
    }
    
    //백도
    public int backdo() {
       return -1;
    }
    //ryan패시브
    public int ryan() {
       //낙이 나왔을때 
       if ((int)(Math.random()*10) == 0){
            return 0;
        }
       //낙이 나오지 않았을 때 윷값 받음
        int num = (int)(Math.random()*5 + 1);
        //도가 나왔을 때 백도 가 나왔는 지 확인
        if (num == 1 && (int)(Math.random()*4) == 0){
          //말 4개중 백도그림이 있는 말인지 아닌지 확인함
            return -1;
        }
        return 2*num;
    }

}