
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Matrix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matrix 
{
    // instance variables - replace the example below with your own
    private int x;
    private int m;
    private int n;
    private Object[][] list;
        
    public <T> void swap (T[][] a) {
      T[][] b = a;
       for(int i=0; i<this.n; i++){
          for(int j=0; j<this.m; j++){
            this.list[i][j] = b[j][i];
                System.out.println(b[0][1]);
            }
        }
      printArray();
    }
    /**
     * Constructor for objects of class Matrix
     */
    public Matrix()
    {
        // initialise instance variables
        x = 0;
    }
    public Matrix(int m, int n)
    {
        System.out.println("Constructed a Matrix");
        this.m = m;
        this.n = n;
        // initialise instance variables
        list = new Object[m][n];
    }    
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public < E > boolean SetNumbers(E[] inputArray)
    {
      System.out.println(inputArray.length);
      if(inputArray.length != this.n*this.m)
        return false;
        // put your code here
      System.out.println("shouldnt be here if false");
      int i = 0;
      int j = 0;
      for (E element : inputArray) {
            this.list[i][j] = element;
            i++;
            if(i==this.n){
              i=0;
              j++;
            }
          }  
      return true;
    }
    
    public < E > void printArray() {
          for(int i=0; i<this.m; i++){
            for(int j=0; j<this.n; j++){
              System.out.print(this.list[i][j] + " ");
            }
          System.out.println("");
        } 
    }
    
    public < E > void Transpose()
    {
        swap(this.list);
    }
    
}