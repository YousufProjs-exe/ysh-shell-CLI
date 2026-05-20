
import javax.swing.*;
import java.util.*;
import java.io.*;

public class ysh_v3 {
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        System.out.println(" YSH Yousuf Shell [Version 3.0.1] \n");
        System.out.println("(C) ysh build by Yousuf 25061-CS-010 \n\n");
        System.out.println("Type 'help' for help \n");
        System.out.println("Hello user\n");

        while(true){

            System.out.print("ysh> ");
            String input = in.nextLine().trim(); //trim removes xtra space

            String command;
            String arguments;

            //input is now command + arguments
            if(input.contains(" ")) {
                command = input.substring(0, input.indexOf(" "));
                arguments = input.substring(input.indexOf(" ") + 1);
            } else {
                command = input;
                arguments = "";
            }
            //exit
            if(command.equals("exit")) {
                System.out.println("ysh is closed");
                break;
            }
            //help
            else if(command.equals("help")){
                System.out.println("\n Commands:");
                System.out.println("\nhelp-> shows commands");
                System.out.println("echo-> to print text");
                System.out.println("clear-> clear screen");
                System.out.println("exit-> to close ysh\n");
            }
            //echo
            else if(command.equals("echo")){
                System.out.println(arguments);
            }
            //clear
            else if(command.equals("clear")) {
                for(int i = 0; i < 40; i++) {
                    System.out.println();
                }
            }
            //terminal
            else if(command.isEmpty()){
                //terminal run block
            }

            else {
                System.out.println(command + " is not recognised as a command");
            }
        }

        in.close();
    }
}
