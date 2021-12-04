//@author juan
import java.util.*;
import java.util.Scanner;

public class ParenMatch {
    public static void main(String[] args) {
        Stack s = new Stack();
        String line; // the string of characters to be checked 
        Scanner scan = new Scanner(System.in); 
        System.out.println ("\nParenthesis Matching");
        System.out.print ("Enter a parenthesized expression: "); 
        line = scan.nextLine();
     
        boolean error = false;
        //String to store up to when error is detected
        String str = "";
        //loop to process the line one character at a time
        for (int i = 0; i < line.length(); i++) {
            str = str + line.charAt(i); //appends current char to str
            if (line.charAt(i) == '(') {
                s.push('(');
            }
            else if (line.charAt(i) == ')') {
                if (s.isEmpty()) {
                    System.out.println("Too many right parentheses");
                }
                error = true;
                break;
            }
            else {
                s.pop();
            }
        }
        
        //If the stack is not empty there are left parentheses that are left unclosed
        if (!error && !s.isEmpty()) {
            System.out.println("Too many left parentheses");
            error = true;
        }
        if (!error) {
            System.out.println("Parentheses matched");
        }
        else {
            System.out.println("String until where the error was detected: " + str);
        }
    }
}
