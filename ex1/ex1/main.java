
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class main
     */
   	public static void main(String[] av) {
	// Create a Date object for May 5, 1986
	Matrix m = new Matrix(2,2);
	Integer[] i = new Integer[2];
	Double[] j = new Double[4];

	j[0]=1.1;
	j[1]=1.2;
	j[2]=0.3;
    j[3]=0.4;
	m.SetNumbers(j);
	m.printArray();
    m.Transpose();
    m.printArray();
    System.out.println("Date is ");
	}

    public main()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
