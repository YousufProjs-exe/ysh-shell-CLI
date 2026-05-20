
import javax.swing.*;
import java.util.*;
import java.io.*;

public class ysh_v1 {
    public static void main(String args[]){
        
        Scanner in = new Scanner(System.in);
        
        System.out.println(" YSH Yousuf Shell [Version 1.0.1] \n");
        System.out.println("(C) ysh build by Yousuf 25061-CS-010 \n\n");
        System.out.println("Type 'help' for help \n");
        System.out.println("Hello user\n");
        
        while(true){
            System.out.print("ysh> ");
            String input = in.nextLine().trim(); //trim removes xtra space
            
            //exit
            if(input.equals("exit")) {
                System.out.println("ysh is closed");
                break;
            }
            //help
            else if(input.equals("help")){
                System.out.println("\n Commands:");
                System.out.println("\nhelp-> shows commands");
                System.out.println("echo-> to print text");
                System.out.println("exit-> to close ysh\n");
            }
            //echo
            else if(input.startsWith("echo ")){
                String msg = input.substring(5);
                System.out.println(msg);
            }
            //terminal
            else if(input.isEmpty()){
                
            }
            else {
                System.out.println(""  + input + "is not recognised as a command");
            }
        }
        
        in.close();
    }
}
