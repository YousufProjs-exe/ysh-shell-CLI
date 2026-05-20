
YSH – Yousuf Shell CLI

A Java-based mini operating system shell simulator built from scratch to understand how real terminals manage commands, files, and directories.

This project evolved across multiple versions (v1 → v5), gradually building a complete virtual filesystem and command execution engine.

Project Overview

YSH is a command-line shell simulation written in Java that replicates core features of a real terminal:

Command parsing system
Virtual folder structure (tree-based)
File system simulation
File read/write operations
Navigation commands like cd, pwd, ls

It started as a simple CLI experiment and evolved into a mini filesystem engine.

Version Evolution-
v1 – Basic Command Shell

Goal: Learn input/output and basic command handling

Features:
Simple command loop
echo
help
exit
Concept learned:
Scanner input handling
if-else command system
v2 – GUI Experiment (Swing)

Goal: Understand Java GUI basics

Features:
JFrame window
Text input field
Output area
Button-based command execution
Concept learned:
Java Swing basics
Event listeners
GUI vs CLI difference
v3 – Improved CLI Shell

Goal: Build proper command parser

Features:
Command + argument splitting
Cleaner shell structure
Improved help, echo, clear
Concept learned:
String parsing
CLI design patterns
Better control flow structure
v4 – Virtual Filesystem (Major Upgrade)

Goal: Simulate real directory system

Features:
Folder tree structure
mkdir
cd
ls
pwd
home
Concept learned:
Tree data structure
Parent-child relationships
State management (current directory)
v5 – Full Shell Engine (Final Version)

Goal: Complete mini terminal system

Features:

File System:
touch → create files
write → write to files
cat → read files
Folder System:
mkdir
cd
ls
home

Terminal Features:
Command parsing engine
Dynamic navigation system
Clean error handling
Improved help system

Easter Egg
"Hidden commands are there"

Key Concepts Used:
This project demonstrates:

Programming Fundamentals:
Object-Oriented Programming (OOP)
Classes and objects
Methods and encapsulation
🌳 Data Structures
Tree structure (filesystem simulation)
Lists for folder/file storage
⚙️ System Design
Command interpreter design
State-based navigation system
Modular feature expansion
💡 Software Thinking
Version-based development
Incremental feature building
Separation of concerns (engine vs interface)

Architecture:
YSH Shell Engine
│
├── Command Parser
│   ├── input splitting
│   └── argument handling
│
├── Filesystem Layer
│   ├── Folder (tree structure)
│   └── FileNode (content storage)
│
├── Execution Layer
│   ├── cd, ls, pwd
│   ├── mkdir, touch
│   ├── cat, write
│   └── home, clear, exit
│
└── UI Layer
    └── CLI (Scanner-based interface)


Available Commands (v5)-
Command	Description
help	Show all commands
echo text	Print text
mkdir name	Create folder
touch file	Create file
write file text	Write into file
cat file	Read file
ls	List folders & files
cd folder	Change directory
cd ..	Go back
home	Reset to root
pwd	Show current path
clear	Clear screen
exit	Exit shell

Example Usage:
ysh> mkdir projects
Folder created: projects

ysh> cd projects
ysh /projects > touch file.txt
File created: file.txt

ysh /projects > write file.txt hello world
Written to file: file.txt

ysh /projects > cat file.txt
hello world

ysh /projects > pwd
/projects

Easter Egg too

What I Learned:
How real shells interpret commands
Building a virtual filesystem from scratch
Managing hierarchical data (tree structures)
Designing scalable command-based systems
Improving code through version evolution

Future Improvements:
GUI version using Java Swing
Save/load filesystem (persistence)
Command history (like real terminals)
Autocomplete feature
Script execution system

Author:
Yousuf Uddin
Java Developer | System Builder | Learning Operating Systems Concepts

Why this project matters
This project is not just a Java program.

It is a:
Mini operating system shell simulation built to understand how real terminals work internally.

Final Note:
YSH evolved from:
simple echo program → full virtual filesystem engine

Thank You - K.Yousuf