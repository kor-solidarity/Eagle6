package yut.controller;

import java.util.Comparator;

import yut.model.vo.Player;

public class compareScore implements Comparator {

@Override
public int compare(Object o1, Object o2) {
	Player p1 = (Player) o1;
	Player p2 = (Player) o2;
	
	int result = 0;
		
	if(p1.getSongP() == p2.getSongP()){
		result = 0;
	}
	if(p1.getSongP() > p2.getSongP()){
		result = -1;//바꿔줌
	}
	if(p1.getSongP() < p2.getSongP()){
		result = 1;//안바꿔줌
	}
	
	return result;
}



}
