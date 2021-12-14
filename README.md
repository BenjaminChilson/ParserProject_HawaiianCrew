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


#compilation instructions

1. First cd into the src/antlr directory.
2. Second run the ```$ java -jar ./lib/antlr-4.9.2-complete.jar ./grammar/grammarTest.g4``` command (this updates the generated files in the antlr directory)
3. Third run the ```$ javac -cp ./lib/antlr-4.9.2-complete.jar grammarTest*.java``` command (this compiles the generated java codes in the antlr directory)
4. Forth run the ```$ java -cp ./lib/antlr-4.9.2-complete.jar org.antlr.v4.gui.TestRig grammarTest prog -gui ./testCode/python_test_code.py``` command. If all works, this should produce the parse tree
