package sudoku;

import javax.swing.*;
import java.awt.*;

public class Main {

  public static void main(String[] args) {

      GameWindow game = new GameWindow("Group F aMaze");

      game.setSize(new Dimension(950, 950));
      game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      game.getContentPane().setBackground(new Color(9, 63, 145));
      game.setUp(); 
      game.setVisible(true);
      game.setResizable(false);
  }
}
