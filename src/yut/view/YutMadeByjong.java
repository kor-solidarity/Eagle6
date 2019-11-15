package yut.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

//아이템 모아니면 도 객체생성때문에 불러옴
import yut.model.vo.Item;


public class YutMadeByjong extends JFrame{
    // 윷에 나와야할 것들.
    // 낙 나올 확률
    // 빽도확률: 1 나왔을때 1/4
    // 1-5 나오게

	private MainFrame mf;
	private JPanel panel2;
	private JPanel mainPage;
	private JPanel throwYutPan;//윷던지는 판
    public YutMadeByjong() { }

   /* public Yut(MainFrame mf) {
        //mainPage = this;
		this.mf = mf;
		this.setSize(1500,800);
        panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setSize(1500,800);
	
		throwYutPan.setSize(500,500);
		throwYutPan.setLayout(null);
    
    }*/
			
    
    
    
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

    // 모아니면 도 아이템
    public int moOrDo(){
    	//아이템 메소드에 가격과 이름 설정
    	Item item=new Item(5,"moOrDo");
        // 랜덤값 1 또는 0, 0이면 모 1이면 도
        if ((int)(Math.random()*2) == 0){
            return 5;
        }else {
            return 1;
        }
    }

    // Neo 패시브 윷 확률 올리기
    public int neoIncreaseYut(){
    	
        // 랜덤값 1 또는 0, 0,1이면 윷 2면 낙
    	int random=(int)(Math.random()*3); 
        if (random== 0||random==1){
            return 4;
        }else {
            return throw_yut();
        }
    }
    
    //백도
    public int backdo() {
       return -1;
    }
    //ryan패시브 첫말*2로 이동
    public int ryanMoveDouble() {
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
    //해야할거: subpage1에서 버튼 누르면 yut메소드 호출,
    //	반환 받은 yut값에 따라서 달라지는 화면 출력 이미지 subpage1에서 구현
    //	윷이나 모 나왔을 때 yutCount값 1로 다시 설정
 

}