package snq;


import java.util.*;
import java.util.Scanner;
public class MinStack {
    
    static int min;
    static Stack<Integer> stk=new Stack<>();
    //Complete the below 3 functions only
    
    
    static int getMin()
    {
        return min;
   }
    
    static int pop()
    {  int rv=0;
       if(stk.peek()<min){
           rv = min;
           min= (2*min)-stk.pop();
       }else{
           rv = stk.pop();
       }
       return rv;
    }
    static void push(int x)
    {
        if(stk.size()==0){
            stk.push(x);
            min=x;
        }else{
            if(x<min){
                stk.push(x+x-min);
                min=x;
            }else{
                stk.push(x);
            }
        }
    }	 










	 // Dont make changes here    
	 public static void main(String[] args) {
	 	 // TODO Auto-generated method stub
	 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 int[] query=new int[n];
	 	 for(int i=0;i<n;i++){
	 	 	 query[i]=sc.nextInt();
	 	 }
	 	 int i=0;
	 	 while(i<n){
	 	 	 if(query[i]==1){
	 	 	 	 i++;
	 	 	 	 push(query[i]);
	 	 	 }
	 	 	 else if(query[i]==2){
	 	 	 	 System.out.println(pop()+" ");
	 	 	 }
	 	 	 else if(query[i]==3){
	 	 	 	 System.out.println(getMin()+" ");
	 	 	 }
	 	 	 i++;
	 	 }
	 }

}
