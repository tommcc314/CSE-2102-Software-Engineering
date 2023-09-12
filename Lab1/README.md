## Building Unit Tests

In the test folder is TestRunner.java which contains the main method that executes unit tests. New test classes and methods should be created in the test folder.

## Executing Unit Tests

### Using VS Code and Terminal

VS Code provides the Test Runner for Java extension which creates a .jar file based on the JUnit imports the tests need. 

Using this, we can compile in the terminal in the test folder: `javac -cp 'Path/to/Junit/jar' .\TestScoreTable.java .\TestRunner.java`

Then, execute using `java -cp 'Class/Path;Path/to/H2/jar;' Lab1/test/TestRunner`