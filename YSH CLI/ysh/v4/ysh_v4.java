
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class ysh_v4 {

    // Folder model
    static class Folder {
        String name;
        Folder parent;

        ArrayList<Folder> children = new ArrayList<>();

        Folder(String name, Folder parent) {
            this.name = name;
            this.parent = parent;
        }
    }

    //show full path
    static String getPath(Folder f) {

        if (f.parent == null) return "/";

        String path = "";

        while (f.parent != null) {
            path = "/" + f.name + path;
            f = f.parent;
        }

        return path;
    }

    // main function
    public static void main(String args[]) {

        Folder root = new Folder("/", null);
        Folder current = root;

        Scanner in = new Scanner(System.in);

        System.out.println(" YSH Yousuf Shell [Version 4.0.1] \n");
        System.out.println("(C) ysh build by Yousuf 25061-CS-010 \n\n");
        System.out.println("Type 'help' for help \n");
        System.out.println("Hello user\n");

        //W while looping the ysh
        while (true) {

            System.out.print("ysh> " + getPath(current) + " > ");
            String input = in.nextLine().trim();

            String command;
            String arguments;

            // command + arguments split
            if (input.contains(" ")) {
                command = input.substring(0, input.indexOf(" "));
                arguments = input.substring(input.indexOf(" ") + 1);
            } else {
                command = input;
                arguments = "";
            }

            // exit
            if (command.equals("exit")) {
                System.out.println("ysh is closed");
                break;
            }

            // help
            else if (command.equals("help")) {
                System.out.println("\nCommands:");
                System.out.println("help  -> shows commands");
                System.out.println("home  -> reset/initial terminal");
                System.out.println("echo  -> prints text");
                System.out.println("clear -> clears screen");
                System.out.println("ls    -> list folders");
                System.out.println("pwd   -> show path");
                System.out.println("cd    -> change folder/directory");
                System.out.println("exit  -> close ysh\n");
            }

            // echo
            else if (command.equals("echo")) {
                System.out.println(arguments);
            }

            // home
            else if(command.equals("home")) {
                current = root;
                System.out.println("Returned to home (/)");
                System.out.println("Now at: " + getPath(current));
            }
            
            // clear
            else if (command.equals("clear")) {
                for (int i = 0; i < 40; i++) {
                    System.out.println();
                }
            }

            // pwd
            else if (command.equals("pwd")) {
                System.out.println(getPath(current));
            }

            // ls
            else if (command.equals("ls")) {
                if (current.children.size() == 0) {
                    System.out.println("(empty)");
                }
                for (Folder f : current.children) {
                    System.out.println("[DIR] " + f.name);
                }
            }

            // cd
            else if (command.equals("cd")) {
                if (arguments.equals("..")) {
                    if (current.parent != null) {
                        current = current.parent;
                    }
                }
                else {
                    boolean found = false;
                    for (Folder f : current.children) {
                        if (f.name.equals(arguments)) {
                            current = f;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Folder not found: " + arguments);
                    }
                }
            }

            //terminal work space
            else if (command.isEmpty()) {
                //nothing
            }

            // mkdir - create new folder inside current folder
            else if(command.equals("mkdir")) {
                if(arguments.isEmpty()) {
                    System.out.println("Usage: mkdir foldername");
                }
                else {
                    boolean exists = false;
                    for(Folder f : current.children) {
                        if(f.name.equals(arguments)) {
                            exists = true;
                            break;
                        }
                    }
                    if(exists) {
                        System.out.println("Folder already exists: " + arguments);
                    }
                    else {
                        Folder newFolder = new Folder(arguments, current);
                        current.children.add(newFolder);
                        System.out.println("Folder created: " + arguments);
                    }
                }
            }
            
            // invalid command
            else {
                System.out.println(command + " is not recognised as a command");
            }
        }

        in.close();
    }
}
