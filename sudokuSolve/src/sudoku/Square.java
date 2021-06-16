package sudoku;

public class Square {
  
  private char val;
  private boolean[] pencil = new boolean[9];
  
  public Square(char num) {
    if(num < '0' || num > '9')
      return;
    val = num;
    for (int i = 0; i < 10; i++)
      pencil[i+1] = true;
    setValue(val);
  }

  public void removePencil(char num) {
    if(num < '1' || num > '9')
      return;
    int n = Character.getNumericValue(num);
    pencil[n] = false;
  }
  
  public boolean getPencil(char num) {
    if(num < '1' || num > '9')
      return false;
    int n = Character.getNumericValue(num);
    if(pencil[n] == true)
      return true;
    else
      return false;  
  }
  
  public void setValue(char num) {
    if(num < '1' || num > '9')
      return;
    val = num;
    int n = Character.getNumericValue(val)-1;
    for(int i = 0; i < 9; i++) {
      if (i == n)
        pencil[i+1] = true;
      else
        pencil[i+1] = false;
    }
  }
  
  public int getValue() {
    return val;
  }
  
  
}
