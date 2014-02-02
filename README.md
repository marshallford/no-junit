# NoJUnit

A simple alternative to JUnit for testing Java code in the client class.

## Preface

Before you read through my documentation and code, please note that I am not even close to being fully proficient at programming, so if you see any issues with my code/documentation or if I have broken some unwritten rule, let me know.

Secondly, understand that this was written to improve the speed at which I finish my CS coursework. Yes, I realize I am probably better off writing tests in an actual framework, however most professors in beginner programming courses want assignments completed with just standard Java.

## The Documentation

### Install

1. Import or copy the class into the package/project you would like to test.
2. Change the package name at the top of NoJUnit to match the package it is apart of.

### Main setup and options

To setup a group of tests first call `NoJUnit.setupTest(String newTitle, int newLineLength)`. The first parameter is the title of the tests you will be running and the second is how long the line separators will be.

For example, `NoJUnit.setupTest("This is my first set of tests", 60);` would print out,

    This is my first set of tests
    ============================================================
    
Now that you have properly setup a group of tests, you can actually test something! Use `NoJUnit.test(boolean foo, String message)` to list out each test. The first parameter is the result of the test and the second is the title or descriptor of what you are testing. Below are a few examples.

    NoJUnit.test("foo".equals("foo"),"Does foo = foo?");
    NoJUnit.test(8.5==8.5,"Testing floating point numbers");
    NoJUnit.test(8==9,"Does 8 equal 9?");
    
Lastly, to display the results of the tests, simply call `NoJUnit.results();`. Below is the full output of everything we have written so far.

    This is my first set of tests
    ============================================================
    [X] Does foo = foo?
    [X] Testing floating point numbers
    [ ] Does 8 equal 9?

    ------------------------------------------------------------
    NoJUnit Results
    Total Tests: 3   ||   Passed Tests: 2   ||   Failed Tests: 1
    Pass Percentage: 66.67%
    [ ] Passed All Tests
    ------------------------------------------------------------
    
### Other useful bits

#### Debugging

If you would like additional info on what NoJUnit is doing, when setting up a group of tests use the following code and set the last variable to true. By default debugging is turned off.

    setupTest(String newTitle, int newLineLength, boolean debug)

#### Changing the line length

If for whatever reason you would like to change the line separator length of the results section, use `lineLength(int newLineLength)` before calling `NoJUnit.results();`.
