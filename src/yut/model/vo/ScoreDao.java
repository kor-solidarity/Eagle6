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

   Player pl=new Player();
   public HashMap hmap = null;

    public void insertScore(Player p) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("score.dat"));
            oos.writeObject(hmap);
            oos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public HashMap readAll() {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("Score.dat");
            while (true) {
                try {
                    hmap = new HashMap();
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Player p = (Player) ois.readObject();


                    hmap.put(p.getNick(), p.getSongP());


                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
        }try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hmap;
    }
    public void read(String text) {
        for (String word : text.split(" ")) {
            if (hmap.containsKey(word)) {
                Integer songP = (Integer) hmap.get(word);
                songP+=(Integer)pl.getSongP();
                hmap.put(word, songP);
            }
        }
    }
}