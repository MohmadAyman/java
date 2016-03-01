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
      System.out.println("shouldnt be here if false");

      for (int i = 0;i<this.n ; i++) {
      	for (int j =0;j<this.m ;j++ ) {
      		if(i==j)
      			this.list[i][j]=inputNum;
      		else
      			this.list[i][j]=0;
      	}
      	
      }
      return true;
    }

    public < E > void Transpose()
    {

    }
	
}