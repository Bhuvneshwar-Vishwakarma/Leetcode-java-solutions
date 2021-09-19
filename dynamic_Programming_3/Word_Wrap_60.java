package dynamic_Programming_3;
import java.util.Scanner;

public class Word_Wrap_60{
    // return cost of optimal word-wrap.
    private static int wordWrap(String []words,int width){

        // write your code here.
        
        return 0;
    } 
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        String words[] = new String[n];
        
        for(int i = 0 ; i < n ;i++)
            words[i] = scn.next();
        
        int width = scn.nextInt();
        
        System.out.println(wordWrap(words, width));

        scn.close();
    }
}