//package tes;
import java.io.*;
import java.util.Scanner;
import mpi.*;

public class lab4 {

    public static void main(String[] args) {
	long startTime = System.currentTimeMillis();
	File file = new File("file1.txt");
	File file1 = new File("file2.txt");
	int line1 = 0;
	int line0 = 0;
	long endTime = 0;
	int [] found0 = {0};
	int [] found1 = {0};
	int [] rcv0 = {0};
	int [] rcv1 = {0};


	String word = "koko";

         MPI.Init(args) ;
		 int myrank = MPI.COMM_WORLD.Rank() ;
         System.out.println("My Rank: "+myrank);
		 if(myrank == 0) {
		try{
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  String line;
		  while ((line = br.readLine()) != null) {
		  	line0++;
		      if (line.contains(word)) {
		      	endTime = System.currentTimeMillis();
		      	System.out.println("Thread 0: time elaspsed is " + (endTime - startTime) + "ms");
		      	System.out.println("at line: "+ line0);
		      	found0[0] = 1;
		      	break;
		      }
		 	 }
		MPI.COMM_WORLD.Send(found0, 0, found0.length, MPI.INT, 1, 99);
    	// MPI.COMM_WORLD.Send(found, 0, notFound.length, MPI.CHAR, 1, 99) ;				
        // MPI.COMM_WORLD.Recv(rcv0, 0, found0.length, MPI.INT, 1, 100);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		}


		else if(myrank == 1) {
		try{
		  BufferedReader br = new BufferedReader(new FileReader(file1));
		  String line;
		  while ((line = br.readLine()) != null) {
		  	line1++;
		      if (line.contains(word)) {
		      	endTime = System.currentTimeMillis();
		      	System.out.println("Thread 0: time elaspsed is " + (endTime - startTime)+ "ms");
		      	System.out.println("at line: "+ line1);
		      	found1[0] = 2;
		      	break;
		      }
	 	 	}
        	// MPI.COMM_WORLD.Send(found1, 0, found1.length, MPI.INT, 0, 100) ;
		 // MPI.COMM_WORLD.Send(found1, 0, notFound.length, MPI.CHAR, 0, 100);
		 MPI.COMM_WORLD.Recv(rcv1, 0, found1.length, MPI.INT, 0, 99);
		 if (rcv1[0] == found1[0]) {
		 	System.out.println(word + " was Not Found in any file");
		 }
		 else{
		 System.out.println("thread one sent " + rcv1[0] + " to me, Thread 2");
		}
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		}
 	MPI.Finalize() ;
	}
}
