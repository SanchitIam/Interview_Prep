package snq;

import java.util.*;

class TernerayOperation {

    public static String parseTernary(String expression) {
        Stack<Character> stk = new Stack<>();
        for(int i = expression.length()-1; i>=0;--i ){
            char ch = expression.charAt(i);
            if(Character.isDigit(ch)){
                stk.push(ch);
            }else if(ch=='?'){
                stk.push(ch);
            }else if(ch==':'){
                continue;
            }else if (ch=='T' && stk.peek()=='?'){
                stk.pop();
                char c = stk.pop();
                stk.pop();
                
                stk.push(c);
            }else if (ch=='F' && stk.peek()=='?'){
                stk.pop();
                stk.pop();
                char c = stk.pop();
                stk.push(c);
                
            }else{
                stk.push(ch);
            }
        }
        
        return stk.peek() + "";
    }

    // Dont make chsnges here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(parseTernary(sc.next()));
    }
}