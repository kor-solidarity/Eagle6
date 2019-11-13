package yut.view;

public class Yut {
    // 윷에 나와야할 것들.
    // 낙 나올 확률
    // 빽도확률: 1 나왔을때 1/4
    // 1-5 나오게
    public int throw_yut(){
        // 낙 계산
        if ((int)(Math.random()*10) == 0){
            return 0;
        }
        // 여기서 던짐
        int num = (int)(Math.random()*5 + 1);
        // 도가 나왔으면 낙 계산
        if (num == 1 && (int)(Math.random()*4) == 0){
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

}
