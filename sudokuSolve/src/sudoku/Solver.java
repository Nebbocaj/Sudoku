package sudoku;

public class Solver {
  private int size;
  private Square[][] square = new Square[9][9];
  
  
  public Solver (int type) {
    size = type;
  }
  
  public char[][] solveBoard(char[][] board){
    
    for(int i = 0; i < 9; i++)
      for(int j = 0; j < 9; j++)
        square[i][j] = new Square(board[i][j]);
    
    
    
    
    return board;
  }
  

  public void fillPencil() {
    
  }
  
  public void removePencilRow(char val, int row) {
    
  }
  
  public void removePencilColumn(char val, int col) {
    
  }
  
  public void removePencilSquare(char val, int row, int col) {
    
  }
  
  public void findSingluar() {
    
  }
  
  public int numInRow(char val, int row) {
    return 0;
  }
  
  public int numInColumn(char val, int col) {
    return 0;
  }
  
  public int numInSquare(char val, int row, int col) {
    return 0;
  }
}


