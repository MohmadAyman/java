import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class IdentityMatrix extends Matrix {
	public IdentityMatrix(int n, int m)
	{
		super(m,n);
	}
 
 	public < E > boolean SetNumbers(E inputNum)
    {
     Object a = inputNum;
     if(m!=n)
      {
        System.out.println("Idintty matrix is square");
        return false;
        // put your code here
      }
      if(a!=1)
      {
       System.out.println("Idintty has to take a one");
        return false;
      }
      super(inputNum);
      return true;
    }

    public < E > void Transpose()
    {

    }
	
}