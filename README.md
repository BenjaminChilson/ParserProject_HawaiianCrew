# Hawaiian Crew Parser Project
We are implementing a parser for the Python languague using ANTLR and Java

Group Members: Benjamin Chilson, Matt Hackman, and Nate Beattie

# Requirements:
## Java
install Java version 1.7 or higher.
## ANTLR
install ANTLR for your system. We are utilizing ANTLR v4 for this project.
Install Instruction for your Operating System can be found here: https://github.com/antlr/antlr4/blob/master/doc/getting-started.md
or here: https://www.antlr.org/

# Demo Video


# Compilation and Run Instructions
Once ANTLR is installed on your machine and you have downloaded our repo, cd into the ParserProject_HawaiianCrew/pythonGrammar directory
From there you will run the following commands from your command line:

First we will run this command to generate the needed files to run our grammar using ANTLR
```
antlr4 PythonGrammar.g4
```
Next we will compile all of the generated java code that was produced from the previous command
```
javac PythonGrammar*.java
```
Now go back one directory. This should be the ParserProject_HawaiianCrew directory
```
cd ..
```
And finally, to run the parser and see the parse tree output we will run this command
```
grun pythonGrammar.PythonGrammar prog tests/python_test_code.py -gui &
```
Do note: if you like to run our parser with another file, you can do so by placing the wanted file in the ParserProject_HawaiianCrew/tests directory and replace the snippet ```tests/python_test_code.py``` from the previous command with ```tests/<your file here>```

### For Ubuntu/WSL
Here is a great resource that helped me out using Ubuntu on Windows Subsystem for Linux: [Testing Grammar using ANTLR](https://blog.knoldus.com/testing-grammar-using-antlr4-testrig-grun/), especially steps 3-6. It is also worth noting that you should not `sudo apt install` grun or antlr4, but instead add those commands as aliases:
```
alias antlr4='java -Xmx500M -cp "/usr/local/lib/antlr-4.8-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias grun='java org.antlr.v4.gui.TestRig' 
```
 
 Additionally make sure you have the correct CLASSPATH:
 ```
 export CLASSPATH=".:/usr/local/lib/antlr-4.8-complete.jar:$CLASSPATH"
 ```
