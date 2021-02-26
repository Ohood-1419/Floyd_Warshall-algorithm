//Group 2 -section DAR
//

import java.util.*;
// A Java program for Floyd Warshall All Pairs Shortest
// Path algorithm.
public class Main {

    static char c1 = 'A'; 
    static char c2 = 'J';
    static int counter = 0 ;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //take the vertices from user
        System.out.print("            >>_The Floyd Algorithm_<<"
                +"\n---------------------------------------------------\n");
//        System.out.println("\n*_start from: ");
//        c1 = sc.next().charAt(0);
//        System.out.print("*_end at: ");
//        c2 = sc.next().charAt(0);

        //default
        System.out.print(">> The Weighted Matrix that start from (A) to (J) :\n\n");

        //record the matrix
        //Assign all values of graph
        int[][] M = {
                //A  |B  |C  |D  |E  |F  |G  |H  |I  |J
                {0  ,10 ,999,999,999,5  ,999,999,999,999},//A
                {999,0  ,3  ,999,3  ,999,999,999,999,999},//B
                {999,999,0  ,4  ,999,999,999,5  ,999,999},//C
                {999,999,999,0  ,999,999,999,999,4  ,999},//D
                {999,999,4  ,999,0  ,999,2  ,999,999,999},//E
                {999,3  ,999,999,999,0  ,999,999,999,2  },//F
                {999,999,999,7  ,999,999,0  ,999,999,999},//G
                {999,999,999,4  ,999,999,999,0  ,3  ,999},//H
                {999,999,999,999,999,999,999,999,0  ,999},//I
                {999,6  ,999,999,999,999,8  ,999,999,0  } //J
        };

        System.out.println("\n1) The Weighted Matrix ");
        printMatrix(M); // call method  printMatrix

        System.out.println("2)The Floyd Matrix :\n");
        //printMatrix(FloydAlgo(M));
        FloydAlgo(M); // call method   FloydAlgo
    }

    public static int[][] FloydAlgo(int[][] M) {
        //Find all pairs shortest path by trying all possible paths
        for (int k = 0; k < counter; k++) { //Try all intermediate nodes

            System.out.println("D("+k+") = ");  // this to print Next to iteration
            for (int i = 0; i < counter; i++) { //Try for all possible starting position
                for (int j = 0; j < counter; j++) { 	//Try for all possible ending position
                    // to keep track.;
                    if (M[i][k] + M[k][j] < M[i][j]) {   //Check if new distance is shorter via vertex K
                        M[i][j] = M[i][k] + M[k][j];
                        //System.out.print(M[i][j]+"^^\t");
                        //P[i][j] = k;

                    }
                }
            }
            printMatrix(M);

        }
        return M;




    }
    public static void printAlphpit(){
        System.out.print("\n\t");

        for (; c1 <= c2; c1++) {
          //  System.out.print(c1 + "\t");

            counter ++;
        }

        System.out.println("A\tB\tC\tD\tE\tF\tG\tH\tI\tJ\t");
        //System.out.println("--counter = "+ counter);
        System.out.println("\n--------------------------------------------------------------------------------------");

    }

    public static void printMatrix(int[][] Matrix) {  
        //counter =0; c1='A'; c2='J';
        printAlphpit();
        c1='A';
        for (int i = 0 ; i < counter; i++) {
            System.out.print(c1 + " |\t");
            c1++;
            for (int j = 0; j < counter; j++) {

                if(Matrix[i][j] == 999){
                    System.out.print((char) 8734+"\t");
                }else{
                    System.out.print(Matrix[i][j]);
                    System.out.print("\t");
                }
            }
            System.out.println("\n");
        }
        System.out.println("\n");


    }



}
