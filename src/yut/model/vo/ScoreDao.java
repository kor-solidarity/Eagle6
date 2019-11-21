package yut.model.vo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ScoreDao {
	
	public void insertScore(Player p) {
		ObjectOutputStream oos = null;
		
		try {
			oos= new ObjectOutputStream(new FileOutputStream("score.dat"));
			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				oos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public HashMap readAll() {
		HashMap hmap = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("Score.dat");
			hmap = new HashMap();
			
			while(true) {
				try {
					ObjectInputStream ois = new ObjectInputStream(fis);
					Player p = (Player) ois.readObject();
					
					
					hmap.put(p, p);
					
					
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hmap;
	}
	

}