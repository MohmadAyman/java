class IdentityMatrix extends Matrix {
	public IdentityMatrix(int n, int m)
	{
		super(m,n);
	}
 
 	public < E > boolean SetNumbers(E inputNum)
    {
        // put your code here
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
    
	
}