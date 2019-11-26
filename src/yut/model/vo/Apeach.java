package yut.model.vo;

import yut.view.GamePage;
 
public class Apeach extends Player {

    public Apeach(String nick) {
        super(nick, "Apeach");
    }
    //폭탄 아이템 피하기
    public void skill(GamePage gp) {
        //카운트 적용 : 처음폭탄 밟을시 카운트 증가
        if(getSpecialty()==true) {
        	for(int i = 0  ; i <4 ; i++) {
        	if(gp.currentPlayer.getMals()[i].getGrid()!=-1) {
        		if(i+1< 3) {
        			gp.currentPlayer.getMals()[i+1].setGrid(gp.currentPlayer.getMals()[i].getGrid());
        			 gp.mals[1][i+1].setLocation(MapGrid.GRIDS.get(gp.currentPlayer.getMals()[i].getGrid()).x, 
        					 MapGrid.GRIDS.get(gp.currentPlayer.getMals()[i].getGrid()).y);
        			 System.out.println("어피치 스킬 발동");
        	        	setSpecialty(false);
        	        	break;
        		}
        		else {
        			gp.currentPlayer.getMals()[0].setGrid(gp.currentPlayer.getMals()[i].getGrid());
       			 gp.mals[1][0].setLocation(MapGrid.GRIDS.get(gp.currentPlayer.getMals()[i].getGrid()).x, 
    					 MapGrid.GRIDS.get(gp.currentPlayer.getMals()[i].getGrid()).y);
       			 System.out.println("어피치 스킬 발동");
             	setSpecialty(false);
            	break;
        		}
        	}

        	}
        }
    }
}
