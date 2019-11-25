package yut.model.vo;

import yut.view.GamePage;

public class Frodo extends Player {
    public Frodo(String nick) {
        super(nick, "Frodo");
    }
    @Override
    public void skill(GamePage gp) {
        if(getSpecialty()==true) {
        	int random = (int)(Math.random()*1.0+8);
        	System.out.println(random);
            if(getSpecialty()==true) {
                try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	if(gp.currentPlayer.getMals()[0].getGrid()==-1) {
            			gp.currentPlayer.getMals()[0].setGrid(random);
           			 gp.mals[2][0].setLocation(MapGrid.GRIDS.get(random).x, 
        					 MapGrid.GRIDS.get(random).y);
                 	setSpecialty(false);
            	}

            	}
            }
    }
}
