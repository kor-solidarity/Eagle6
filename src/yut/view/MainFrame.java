package yut.view;

import java.util.concurrent.ThreadPoolExecutor;

import javax.swing.JFrame;


public class MainFrame extends JFrame {

            public MainFrame() {
                System.out.println("MainFrame()");

                this.setSize(1500, 800);
                this.setLayout(null);


                new MainPage(this);


        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}