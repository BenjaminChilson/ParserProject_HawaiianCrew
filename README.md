# Hawaiian Crew Parser Project
We are implementing a parser for the Python languague using ANTLR and Java

Group Members: Benjamin Chilson, Matt Hackman, and Nate Beattie

# Environment Setup:
- We used the IntelliJ IDE for this project. If you do not have that installed, you can install it [here](https://www.jetbrains.com/idea/download/#section=windows). I chose the community version.
- Since Java is our target, you need to install the correct ANTLR plugin, found [here](https://github.com/antlr/antlr4/blob/master/doc/java-target.md).
- Once you have both of those downloaded, simply create a new Java project in IntelliJ (Making sure to follow the prompts to install the most recent JDK). Then to include ANTLR, navigate to File -> Settings -> Plugins -> Gear Icon -> Install Plugin from disk -> Find ANTLR zip downloaded in the previous step. 

From there, you are able to create a .g4 grammar file to write your own grammars. 

We mostly followed [this video](https://www.youtube.com/watch?v=svEZtRjVBTY) for ANTLR setup in IntelliJ
# How to use our parser: 
When you have written a grammar you are ready to test, you first need to right click anywhere in the file and select "Generate ANTLR Recognizer". This will generate files in the /gen folder in your project directory. Then, right click on the parser rule you want to test, and click "Test Rule <name_of_rule\>". This will show an ANTLR preview at the bottom of the screen, where you can type in code to test your parser rules. The video linked above shows this process as well. 
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

And finally, to run the parser and see the parse tree output we will run this command
```
grun pythonGrammar.PythonGrammar prog tests/python_test_code.py -gui &
```
Do note: if you like to run our parser with another file, you can do so by placing the wanted file in the ParserProject_HawaiianCrew/tests directory and replace the snippet ```tests/python_test_code.py``` from the previous command with ```tests/<your file here>```

Here is a great resource that helped me out using Ubuntu on Windows Subsystem for Linux: [Testing Grammar using ANTLR](https://blog.knoldus.com/testing-grammar-using-antlr4-testrig-grun/), especially steps 4 and 5.
