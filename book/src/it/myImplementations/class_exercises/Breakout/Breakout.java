package it.myImplementations.class_exercises.Breakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Breakout {

    public static void main(String[] args) {
        
        WindowListener closeManager = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Do you really want to quit ?") == 0)
                    System.exit(0);
            }
        };

        Game game = new Game();

        JFrame frame = new JFrame("Breakout");
        frame.addWindowListener(closeManager);
        frame.setSize(500, 700);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        
        JFrame full = new JFrame();
        full.setUndecorated(true);
 
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        game.setCursor(blankCursor);

        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton quit = new JButton("Quit");
        start.addActionListener((ActionEvent e) -> {game.startGame();});
        stop.addActionListener((ActionEvent e) -> {game.stopGame();});
        quit.addActionListener((ActionEvent e) -> {closeManager.windowClosing(null);});
        controls.add(start);
        controls.add(stop);
        controls.add(quit);
        frame.add(controls, BorderLayout.PAGE_START);
        frame.setVisible(true);
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
           (KeyEvent e)->{
               if(e.getID()==KeyEvent.KEY_PRESSED)
                  switch(e.getKeyCode()){
                     case KeyEvent.VK_F : 
                         if(frame.isVisible()){
                            full.add(game);
                            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(full);                             
                            frame.setVisible(false);
                         }else{
                            frame.add(game, BorderLayout.CENTER);
                            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
                            frame.setVisible(true);
                         }
                     break;
                  }
               return true;
           }
        );  
     
    }
    
}
