
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class ysh_v5 {
    
    //file model
    static class FileNode {
        String name;
        String content;

        FileNode(String name) {
            this.name = name;
            this.content = "";
        }
    }

    // Folder model
    static class Folder {
        String name;
        Folder parent;

        ArrayList<Folder> children = new ArrayList<>();
        ArrayList<FileNode> files = new ArrayList<>();
        
        Folder(String name, Folder parent) {
            this.name = name;
            this.parent = parent;
        }
    }

    //shows full path
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

        System.out.println(" YSH Yousuf Shell [Version 5.0.1] \n");
        System.out.println("(C) ysh build by Yousuf 25061-CS-010 \n\n");
        System.out.println("Type 'help' for help \n");
        System.out.println("Hello user\n");

        //W while looping the ysh
        while (true) {

            System.out.print("ysh> ");
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
                System.out.println("mkdir  -> create folder");
                System.out.println("touch -> to create a file");
                System.out.println("cat -> to read a file");
                System.out.println("write  -> write to file");
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

            //file write
            else if(command.equals("write")) {
                String[] parts = arguments.split(" ", 2);
                if(parts.length < 2) {
                    System.out.println("Usage: write filename text");
                }
                else {
                    String fileName = parts[0];
                    String text = parts[1];
                    boolean found = false;
                    for(FileNode f : current.files) {
                        if(f.name.equals(fileName)) {
                            f.content = text;
                            System.out.println("Written to file: " + fileName);
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("File not found: " + fileName);
                    }
                }
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
                for (Folder f : current.children) {
                    System.out.println("[DIR] " + f.name);
                }
                for (FileNode f : current.files) {
                    System.out.println("[FILE] " + f.name);
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
            
            else if(command.equals("yousuf") || 
                    command.equals("i am banana") || 
                    command.equals("816005641")) {
                System.out.println("01011001 01010011 01001000");
                System.out.println("Congrats on finding ysh Easter Egg");
                System.out.println("Learn JAVA, its cool");
                System.out.println("JAVA > Python anyday");
            }
            
            //file creation
            else if(command.equals("touch")) {
                if(arguments.isEmpty()) {
                   System.out.println("Usage: touch filename");
                 }
                 else {
                    boolean exists = false;
                    for(FileNode f : current.files) {
                        if(f.name.equals(arguments)) {
                            exists = true;
                            break;
                          }
                    }
                    if(exists) {
                        System.out.println("File already exists: " + arguments);
                    }
                    else {
                        FileNode newFile = new FileNode(arguments);
                        current.files.add(newFile);
                        System.out.println("File created: " + arguments);
                    }
                 }
            }
            
            //read file
            else if(command.equals("cat")) {
                if(arguments.isEmpty()) {
                    System.out.println("Usage: cat filename");
                }
                else {
                    boolean found = false;
                    for(FileNode f : current.files) {
                        if(f.name.equals(arguments)) {
                            System.out.println(f.content);
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("File not found: " + arguments);
                    }
                }
            }
            
            //terminal work space
            else if (command.isEmpty()) {
                //TERminal space
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
                System.out.println(command + " is not recognised as a command. Type 'help'");
            }
        }

        in.close();
    }
}
