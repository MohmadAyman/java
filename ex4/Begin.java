//package tes;
import mpi.*;
import java.io.*;
import java.util.Scanner;

public class Begin {

    public static void main(String[] args) {
    	Scanner txtscan = new Scanner(("file1.txt"));
         MPI.Init(args) ;
//		 try {
//			Thread.sleep(1000);                 //1000 milliseconds is one second.
//		 } catch(InterruptedException ex) {
//			Thread.currentThread().interrupt();
//		 }
		 int myrank = MPI.COMM_WORLD.Rank() ;
                 System.out.println("My Rank: "+myrank);
		 if(myrank == 0) {
			 char[] message = "Hello, there".toCharArray() ;
			 System.out.println("will send:" + new String(message) + ":") ;
			 //MPI.COMM_WORLD.Send(message, 0, message.length, MPI.CHAR, 1, 99) ;
			 try {
			Thread.sleep(3000);                 //1000 milliseconds is one second.
		 } catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		 }
		 }
		 else {
			 char[] message = new char [20] ;			
			 System.out.println("will receive:" + new String(message) + ":") ;
			 //MPI.COMM_WORLD.Recv(message, 0, 20, MPI.CHAR, 0, 99) ;
			 System.out.println("received:" + new String(message) + ":") ;
		 }
		 MPI.Finalize() ;
    }
}
