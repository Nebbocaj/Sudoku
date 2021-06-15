package sudoku;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameWindow extends JFrame implements ActionListener{
  
  public static final long serialVersionUID = 1;
  private JTextField[][] text = new JTextField[9][9];
  private Label[][] value = new Label[9][9];
  private JPanel[][] tile = new JPanel[9][9];
  private Label instruction = new Label();
  private JButton next;
  private Solver solver;
  private int size = 75;
  private char[][] board = new char[9][9];
  private char[][] solution = new char[9][9];
  
  public GameWindow(String s)  {
    super(s);
    GridBagLayout gbl = new GridBagLayout();
    setLayout(gbl);
  }
  
  public void setUp() {
    // sets GridBagConstriants
    GridBagConstraints basic = new GridBagConstraints();
    basic.gridx = 0;
    basic.gridy = 0;
    basic.gridheight = 1;
    basic.weightx = 0.0;
    basic.weighty = 0.4;
    basic.gridwidth = 9;
    
    instruction.setText("Fill in blanks with starting numbers");
    instruction.setFont(new Font("Verdana", Font.PLAIN, 25));
    instruction.setForeground(new Color(0,0,0));
    this.add(instruction, basic);
    
    basic.weighty = 0.0;
    basic.gridwidth = 1;  
    for (int i = 0; i < 9; i++) {
      basic.gridx = i;
      for (int j = 0; j < 9; j++) {
        basic.gridx = i;
        basic.gridy = j + 1;

        tile[i][j] = new JPanel();
        tile[i][j].setLayout(new GridBagLayout());
        tile[i][j].setPreferredSize(new Dimension(size, size));
        tile[i][j].setBackground(new Color(132, 112, 114));
        
        
        if (j % 3 == 0 && i % 3 == 0)
          tile[i][j].setBorder(new MatteBorder(5,5,1,1, Color.BLACK));
        else if (j % 3 == 0 && i % 3 != 0 && i != 8)
          tile[i][j].setBorder(new MatteBorder(5,1,1,1, Color.BLACK));
        else if (j % 3 == 0 && i % 3 != 0 && i == 8)
          tile[i][j].setBorder(new MatteBorder(5,1,1,5, Color.BLACK));
        else if (j % 3 != 0 && i % 3 == 0 && j != 8)
          tile[i][j].setBorder(new MatteBorder(1,5,1,1, Color.BLACK));
        else if (j % 3 != 0 && i % 3 == 0 && j == 8)
          tile[i][j].setBorder(new MatteBorder(1,5,5,1, Color.BLACK));
        else if (j % 3 != 0 && i % 3 != 0 && j != 8 && i != 8)
          tile[i][j].setBorder(new MatteBorder(1,1,1,1, Color.BLACK));
        else if (j % 3 != 0 && i % 3 != 0 && j == 8 && i != 8)
          tile[i][j].setBorder(new MatteBorder(1,1,5,1, Color.BLACK));
        else if (j % 3 != 0 && i % 3 != 0 && j != 8 && i == 8)
          tile[i][j].setBorder(new MatteBorder(1,1,1,5, Color.BLACK));
        else if (j % 3 != 0 && i % 3 != 0 && j == 8 && i == 8)
          tile[i][j].setBorder(new MatteBorder(1,1,5,5, Color.BLACK));
        
        this.add(tile[i][j], basic);
        
        basic.gridy = 0;
        basic.gridx = 0;
        
        text[i][j] = new JTextField(1);
        text[i][j].addActionListener(this);
        tile[i][j].add(text[i][j], basic);
    
        basic.gridy = 1;
        value[i][j] = new Label("0");
        value[i][j].setFont(new Font("Verdana", Font.PLAIN, 30));
        value[i][j].setForeground(new Color(132,112,114));
        tile[i][j].add(value[i][j], basic);
        

      }    
    }
    
    next = new JButton("Continue");
    next.setActionCommand("next");
    next.setPreferredSize(new Dimension(200,50));
    next.addActionListener(this);
    basic.gridwidth = 9;
    basic.gridx = 0;
    basic.gridy = 10;
    basic.anchor = GridBagConstraints.CENTER;
    basic.weighty = 0.6;
    this.add(next, basic);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if ("next".equals(e.getActionCommand())) {
      for(int i = 0; i < 9; i++) {
        for (int  j = 0; j < 9; j++) {
          String temp = text[i][j].getText();
          try {
            board[i][j] = temp.charAt(0);
          }
          catch (StringIndexOutOfBoundsException e1) {
            board[i][j] = '0';
          }
          if (board[i][j] < '0' || board[i][j] > '9') {
            System.out.println("Incorrect Value");
            break;
          }
        }
      }
      solver = new Solver(9);
      solution = solver.solveBoard(board);
      showBoard(solution);
    }
  }
  
  public void showBoard(char[][] sol) {
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        tile[i][j].remove(text[i][j]);
        value[i][j].setText("" + solution[i][j]);
        value[i][j].setForeground(new Color(0,0,0));
        this.repaint();
      }
    }
  }


  
}
