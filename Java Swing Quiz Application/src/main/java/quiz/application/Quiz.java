package quiz.application;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    String option;
    String questions[][] = new String[15][5];
    String answers[][] = new String[15][2];
    String useranswers[][] = new String[15][1];
    int[] easy={0,1,2,3,4};
    int easy_no=5;
    int[] medium={5,6,7,8,9};
    int medium_no=5;
    int[] hard={10,11,12,13,14};
    int hard_no=5;
    int selected;
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 30;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name,String option) {
        this.name = name;
        this.option=option;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        try{
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        qno = new JLabel();
        qno.setBounds(70, 450, 80, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(100, 450, 975, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        if(option.equals("Java")){
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        questions[10][0] = "Which of the following is not a valid way to create an array in Java?";
        questions[10][1] = "int[] arr = {1, 2, 3};";
        questions[10][2] = "int[] arr = new int[3];";
        questions[10][3] = "int arr[] = new int[]{1, 2, 3};";
        questions[10][4] = "int arr[3] = {1, 2, 3};";
        
        questions[11][0] = "Which of the following is not a valid loop in Java?";
        questions[11][1] = "repeat-until loop";
        questions[11][2] = "while loop";
        questions[11][3] = "do-while loop";
        questions[11][4] = "for loop";
        
        questions[12][0] = "Which of the following is not a valid access modifier in Java?";
        questions[12][1] = "public";
        questions[12][2] = "final";
        questions[12][3] = "protected";
        questions[12][4] = "private";
        
        questions[13][0] = "Which of the following is not a valid data type in Java?";
        questions[13][1] = "float";
        questions[13][2] = "char";
        questions[13][3] = "string";
        questions[13][4] = "double";
        
        questions[14][0] = "What is the correct way to declare an integer variable in Java?";
        questions[14][1] = "int x = \"10\";";
        questions[14][2] = "int x = 10;";
        questions[14][3] = "int x = '10';";
        questions[14][4] = "int x = 10.0;";
        
        
          
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        answers[10][1] = "int arr[3] = {1, 2, 3};";
        answers[11][1] = "repeat-until loop";
        answers[12][1] = "final";
        answers[13][1] = "string";
        answers[14][1] = "int x = 10;";
        }
        else if(option.equals("Cpp")){
        
        questions[0][0] = "Which of the following is not a valid variable name in C++.?";
        questions[0][1] = "myVar";
        questions[0][2] = "my-var";
        questions[0][3] = "my_var";
        questions[0][4] = "myvar";
        
        questions[1][0] = "Which keyword is used to create a new object in C++.?";
        questions[1][1] = "new";
        questions[1][2] = "create";
        questions[1][3] = "object";
        questions[1][4] = "init";
        
        questions[2][0] = "Which of the following is not a valid loop in C++.?";
        questions[2][1] = "for loop";
        questions[2][2] = "while loop";
        questions[2][3] = "do-while loop";
        questions[2][4] = "repeat-until loop";
        
        questions[3][0] = "Which of the following is not a valid function declaration in C++.?";
        questions[3][1] = "int add(int x, int y);";
        questions[3][2] = "double multiply(double x, double y);";
        questions[3][3] = "string getName();";
        questions[3][4] = "void myFunction;";
        
        questions[4][0] = "Which of the following is not a valid way to declare a constant in C++.?";
        questions[4][1] = "const int x = 5;";
        questions[4][2] = "int const y = 10;";
        questions[4][3] = "int* const ptr = new int[5];";
        questions[4][4] = "constexpr double PI = 3.14159;";
        
        questions[5][0] = "Which of the following is not a valid way to create a dynamic array in C++.?";
        questions[5][1] = "int* arr = new int[5];";
        questions[5][2] = "int* arr = (int*)malloc(5 * sizeof(int));";
        questions[5][3] = "int arr[5];";
        questions[5][4] = "vector<int> arr(5);";
        
        questions[6][0] = "Which of the following is not a valid way to declare a function pointer in C++.?";
        questions[6][1] = "int (*ptr)(int, int);";
        questions[6][2] = "typedef int (func_ptr)(int, int);";
        questions[6][3] = "using func_ptr = int ()(int, int);";
        questions[6][4] = "int& (*ptr)(int&);";
          
        questions[7][0] = "Which of the following is not a valid way to pass a variable by reference in C++.?";
        questions[7][1] = "void myFunction(int& x);";
        questions[7][2] = "void myFunction(int* x);";
        questions[7][3] = "void myFunction(int&& x);";
        questions[7][4] = "void myFunction(int x);";
        
        questions[8][0] = "Which of the following is not a valid way to initialize a class object in C++.?";
        questions[8][1] = "MyClass obj;";
        questions[8][2] = "MyClass obj = MyClass();";
        questions[8][3] = "MyClass obj(5);";
        questions[8][4] = "MyClass obj{5};";
        
        questions[9][0] = "When can an inline function be expanded.?";
        questions[9][1] = "Run time";
        questions[9][2] = "Compile time";
        questions[9][3] = "Never gets Expanded";
        questions[9][4] = "All of the above";
        
        questions[10][0] = "Which keyword is used to define the macros in c++.?";
        questions[10][1] = "#macro";
        questions[10][2] = "#define";
        questions[10][3] = "macro";
        questions[10][4] = "define";
        
        questions[11][0] = "Can we typecast void * into int * .?";
        questions[11][1] = "Yes";
        questions[11][2] = "No";
        questions[11][3] = "Undefined";
        questions[11][4] = "Depends on Compiler";
        
        questions[12][0] = "Which operator can not be overloaded.?";
        questions[12][1] = "+";
        questions[12][2] = "-";
        questions[12][3] = "*";
        questions[12][4] = "::";
        
        questions[13][0] = "What are Iterators.?";
        questions[13][1] = "Iterators are used to iterate over C-like arrays";
        questions[13][2] = "Iterators are used to iterate over pointers";
        questions[13][3] = "Iterators are used to point memory addresses of STL containers";
        questions[13][4] = "Iterators are used to iterate over functions";
        
        questions[14][0] = "How many types of Iterators are provided by C++.?";
        questions[14][1] = "2";
        questions[14][2] = "3";
        questions[14][3] = "4";
        questions[14][4] = "5";
        
        answers[0][1] = "my-var";
        answers[1][1] = "new";
        answers[2][1] = "repeat-until loop";
        answers[3][1] = "void myFunction;";
        answers[4][1] = "int const y = 10;";
        answers[5][1] = "int arr[5];";
        answers[6][1] = "int& (*ptr)(int&);";
        answers[7][1] = "void myFunction(int x);";
        answers[8][1] = "MyClass obj;";
        answers[9][1] = "Compile time";
        answers[10][1] = "#define";
        answers[11][1] = "Yes";
        answers[12][1] = "::";
        answers[13][1] = "Iterators are used to point memory addresses of STL containers";
        answers[14][1] = "5";
        
        }
        
        
        else if(option.equals("C")){
        questions[0][0] = "Which of the following is not a valid data type in C language?";
        questions[0][1] = "int";
        questions[0][2] = "char";
        questions[0][3] = "bool";
        questions[0][4] = "float";
        
        questions[1][0] = "Which of the following is not a logical operator in C language.?";
        questions[1][1] = "!";
        questions[1][2] = "&&";
        questions[1][3] = "||";
        questions[1][4] = "&";
        
        questions[2][0] = "Which of the following is not a valid way to declare a function in C language.?";
        questions[2][1] = "void fun();";
        questions[2][2] = "void fun(void);";
        questions[2][3] = "void fun(int a);";
        questions[2][4] = "void fun(int);";
        
        questions[3][0] = "Which of the following is not a loop statement in C language.?";
        questions[3][1] = "for";
        questions[3][2] = "while";
        questions[3][3] = "repeat";
        questions[3][4] = "do-while";
        
        questions[4][0] = "Which of the following is a correct way to declare a string in C language.?";
        questions[4][1] = "string s = \"Hello\";";
        questions[4][2] = "char s[] = \"Hello\";";
        questions[4][3] = "string[] s = \"Hello\";";
        questions[4][4] = "char[] s = \"Hello\";";
        
        questions[5][0] = "Which is valid C expression.?";
        questions[5][1] = "int my_num = 100,000;";
        questions[5][2] = "int my_num = 100000;";
        questions[5][3] = "int my num = 1000;";
        questions[5][4] = "int $my_num = 10000;";
        
        questions[6][0] = "Which of the following is a correct way to allocate memory dynamically in C language.?";
        questions[6][1] = " int *ptr = malloc(sizeof(int));";
        questions[6][2] = "int *ptr = new int;";
        questions[6][3] = "int ptr = malloc(sizeof(int));";
        questions[6][4] = "int ptr = new int;";
        
        questions[7][0] = "Which of the following is not an operator in C.?";
        questions[7][1] = ",";
        questions[7][2] = "sizeof()";
        questions[7][3] = "~";
        questions[7][4] = "None of the mentioned";
        
        questions[8][0] = "scanf() is a predefined function in______header file.?";
        questions[8][1] = "stdlib.h";
        questions[8][2] = "ctype.h";
        questions[8][3] = "stdio.h";
        questions[8][4] = "stdarg.h";
        
        questions[9][0] = "What will be the value of Expression: (x = foo())!= 1 considering foo() returns 2 ";
        questions[9][1] = "2";
        questions[9][2] = "True";
        questions[9][3] = "1";
        questions[9][4] = "0";
        
        questions[10][0] = "What is the range of values that can be stored by int datatype in C.?";
        questions[10][1] = "-(2^31) to (2^31)-1";
        questions[10][2] = "-256 to 255";
        questions[10][3] = "-(2^63) to (2^63)-1";
        questions[10][4] = "0 to (2^31)-1";
        
        questions[11][0] = "What is the keyword used to declare a C file pointer.?";
        questions[11][1] = "file";
        questions[11][2] = "FILE";
        questions[11][3] = "FILEFP";
        questions[11][4] = "filefp";
        
        questions[12][0] = "What is the need for closing a file in C language.?";
        questions[12][1] = "fclose(fp) closes a file to release the memory used in opening a file.";
        questions[12][2] = "Closing a file clears Buffer contents from RAM or memory.";
        questions[12][3] = "Unclosed files occupy memory and PC hangs when on low memory.";
        questions[12][4] = "All the above";
        
        questions[13][0] = "What is the operator used to make 1's One's compliment.?";
        questions[13][1] = "&";
        questions[13][2] = "|";
        questions[13][3] = "~";
        questions[13][4] = "^";
        
        questions[14][0] = "What is the value of an array element which is created by calloc.?";
        questions[14][1] = "By default Zero 0";
        questions[14][2] = "1";
        questions[14][3] = "Depends on Storage Class";
        questions[14][4] = "None of the above";
        
        answers[0][1] = "bool";
        answers[1][1] = "&";
        answers[2][1] = "void fun(int);";
        answers[3][1] = "repeat";
        answers[4][1] = "char s[] = \"Hello\";";
        answers[5][1] = "int my_num = 100000;";
        answers[6][1] = "int *ptr = malloc(sizeof(int));";
        answers[7][1] = "None of the mentioned";
        answers[8][1] = "stdio.h";
        answers[9][1] = "2";
        answers[10][1] = "-(2^31) to (2^31)-1";
        answers[11][1] = "FILE";
        answers[12][1] = "All the above";
        answers[13][1] = "~";
        answers[14][1] = "By default Zero 0";
        
        }
        else if(option.equals("R")){
        questions[0][0] = "What is R used for?";
        questions[0][1] = "Statistical computing and graphics";
        questions[0][2] = "Web development";
        questions[0][3] = "Game development";
        questions[0][4] = "Database management";

        questions[1][0] = "Which function can be used to calculate the mean of a vector in R?";
        questions[1][1] = "mean()";
        questions[1][2] = "median()";
        questions[1][3] = "sum()";
        questions[1][4] = "sd()";

        questions[2][0] = "Which function can be used to generate random numbers from a normal distribution in R?";
        questions[2][1] = "rnorm()";
        questions[2][2] = "runif()";
        questions[2][3] = "rexp()";
        questions[2][4] = "rgamma()";

        questions[3][0] = "Which function can be used to fit a linear regression model in R";
        questions[3][1] = "lm()";
        questions[3][2] = "glm()";
        questions[3][3] = "lmer()";
        questions[3][4] = "nls()";

        questions[4][0] = "Which function can be used to read data from a CSV file in R?";
        questions[4][1] = "read.csv()";
        questions[4][2] = "read.table()";
        questions[4][3] = "read.xls()";
        questions[4][4] = "read.xlsx()";

        questions[5][0] = "Which of the following is not a valid way to create a vector in R";
        questions[5][1] = "c(2, 4, 6)";
        questions[5][2] = "2:6";
        questions[5][3] = "seq(2, 6)";
        questions[5][4] = "None of the above";

        questions[6][0] = "Which function can be used to merge two data frames in R?";
        questions[6][1] = "merge()";
        questions[6][2] = "cbind()";
        questions[6][3] = "rbind(";
        questions[6][4] = "bind_rows()";

        questions[7][0] = "Which function can be used to perform a t-test in R?";
        questions[7][1] = "t.test()";
        questions[7][2] = "wilcox.test()";
        questions[7][3] = "chisq.test(";
        questions[7][4] = "ks.test()";

        questions[8][0] = "Which function can be used to apply a function to each element of a vector in R?";
        questions[8][1] = "apply()";
        questions[8][2] = "lapply()";
        questions[8][3] = "sapply()";
        questions[8][4] = "All of the above";

        questions[9][0] = "Which function can be used to create a histogram in R?";
        questions[9][1] = "hist()";
        questions[9][2] = "barplot()";
        questions[9][3] = "plot()";
        questions[9][4] = "boxplot()";
        
        questions[10][0] = "Which function is used to calculate the standard deviation of a set of values in R";
        questions[10][1] = "var()";
        questions[10][2] = "mean()";
        questions[10][3] = "sd()";
        questions[10][4] = "range()";
        
        questions[11][0] = "Which of the following is not a valid control structure in R";
        questions[11][1] = "if-else";
        questions[11][2] = "for loop";
        questions[11][3] = "while loop";
        questions[11][4] = "switch case";
        
        questions[12][0] = "Which of the following is not a valid comparison operator in R?";
        questions[12][1] = "<";
        questions[12][2] = ">";
        questions[12][3] = "<=";
        questions[12][4] = "><";
        
        questions[13][0] = "Which function is used to generate a sequence of numbers in R?";
        questions[13][1] = "sd()";
        questions[13][2] = "range()";
        questions[13][3] = "mean()";
        questions[13][4] = "seq()";
        
        questions[14][0] = "What is the correct way to assign a value to a variable in R?";
        questions[14][1] = "variable = value";
        questions[14][2] = "value = variable";
        questions[14][3] = "variable <- value";
        questions[14][4] = "value <- variable";
        
        

        answers[0][1] = "Statistical computing and graphics";
        answers[1][1] = "median()";
        answers[2][1] = "rnorm()";
        answers[3][1] = "lm()";
        answers[4][1] = "read.csv()";
        answers[5][1] = "2:6";
        answers[6][1] = "merge()";
        answers[7][1] = "t.test()";
        answers[8][1] = "All of the above";
        answers[9][1] = "hist()";
        answers[10][1] = "sd()";
        answers[11][1] = "switch case";
        answers[12][1] = "><";
        answers[13][1] = "seq()";
        answers[14][1] = "variable <- value";
        }
        
        
        opt1 = new JRadioButton();
        opt1.setBounds(120, 520, 780, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(120, 560, 780, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(120, 600, 780, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(120, 640, 780, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[selected][0] = "";
            } else {
                useranswers[selected][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 13) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } 
        
        else if (ae.getSource() == lifeline)  {
            if(option.equals("Java")){
                if(selected==1 || selected==2 || selected==6 || selected==8 || selected==9){
                    opt2.setEnabled(false);
                    opt3.setEnabled(false);
                }
                else if(selected==0 || selected==5 || selected==7 || selected==12 || selected==13){
                    opt1.setEnabled(false);
                    opt4.setEnabled(false);
                }
                else if(selected==3 || selected==14){
                    opt2.setEnabled(false);
                    opt1.setEnabled(false);
                }
                else if(selected==4 || selected==10 || selected==11){
                    opt1.setEnabled(false);
                    opt3.setEnabled(false);
                    
                }
            }
            else if(option=="C"){
                if(selected==6 || selected==9 || selected==10 || selected==14 ){
                    opt2.setEnabled(false);
                    opt3.setEnabled(false);
                }
                else if(selected==4 || selected==5 || selected==11){
                    opt1.setEnabled(false);
                    opt4.setEnabled(false);
                }
                else if(selected==0 || selected==3 || selected==8 || selected==13){
                    opt2.setEnabled(false);
                    opt1.setEnabled(false);
                }
                else if(selected==1 || selected==2 || selected==7 || selected==12){
                    opt1.setEnabled(false);
                    opt3.setEnabled(false);
                    
                }   
            }
                else if(option=="Cpp"){
                if(selected==1 || selected==8 || selected==11){
                    opt2.setEnabled(false);
                    opt3.setEnabled(false);
                }
                else if(selected==0 || selected==4|| selected==9 || selected==10){
                    opt1.setEnabled(false);
                    opt4.setEnabled(false);
                }
                else if(selected==5 || selected==13){
                    opt2.setEnabled(false);
                    opt1.setEnabled(false);
                }
                else{
                    opt1.setEnabled(false);
                    opt3.setEnabled(false);   
                    } 
                    
                }
            else if(option=="R"){
                if(selected==2 || selected==3|| selected==4|| selected==6 || selected==7|| selected==9){
                    opt2.setEnabled(false);
                    opt3.setEnabled(false);
                }
                else if(selected==0 || selected==1 || selected==5 ){
                    opt1.setEnabled(false);
                    opt4.setEnabled(false);
                }
                else if(selected==10 || selected==14){
                    opt2.setEnabled(false);
                    opt1.setEnabled(false);
                }
                else{
                    opt1.setEnabled(false);
                    opt3.setEnabled(false);                   
                }
            }
               
            
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[selected][0] = "";
            } else {
                useranswers[selected][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name,option, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            if(count<=4){
                timer=30;
            }
            else if(count>4 && count<10){
                timer=60;
            }
            else if(count>=10){
                timer=120;
            }
            
        } else if (timer < 0) {
            if(count<=4){
                timer=30;
            }
            else if(count>4 && count<10){
                timer=60;
            }
            else if(count>=10){
                timer=120;
            }
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 13) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 14) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name,option, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[selected][0] = "";
                } else {
                    useranswers[selected][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        int r;
        ArrayOperations obj=new ArrayOperations();
        if(count<5){
            
            r=ThreadLocalRandom.current().nextInt(0, easy_no);
            selected=easy[r];
            qno.setText("" + (count + 1) + ". ");
            question.setText(questions[easy[r]][0]);
            opt1.setText(questions[easy[r]][1]);
            opt1.setActionCommand(questions[easy[r]][1]);
            
            opt2.setText(questions[easy[r]][2]);
            opt2.setActionCommand(questions[easy[r]][2]);
            
            opt3.setText(questions[easy[r]][3]);
            opt3.setActionCommand(questions[easy[r]][3]);
            
            opt4.setText(questions[easy[r]][4]);
            opt4.setActionCommand(questions[easy[r]][4]);
            
            
            obj.deleteElement(easy,easy[r]);
            easy_no--;
            
            
        }
        else if(count>=5 && count<10){
            r=ThreadLocalRandom.current().nextInt(0, medium_no);
            qno.setText("" + (count + 1) + ". ");
            selected=medium[r];
            question.setText(questions[medium[r]][0]);
            opt1.setText(questions[medium[r]][1]);
            opt1.setActionCommand(questions[medium[r]][1]);
            
            opt2.setText(questions[medium[r]][2]);
            opt2.setActionCommand(questions[medium[r]][2]);
            
            opt3.setText(questions[medium[r]][3]);
            opt3.setActionCommand(questions[medium[r]][3]);
            
            opt4.setText(questions[medium[r]][4]);
            opt4.setActionCommand(questions[medium[r]][4]);
            
            
            obj.deleteElement(medium,medium[r]);
            medium_no--;
        }
        else if(count>=10 ){
            r=ThreadLocalRandom.current().nextInt(0, hard_no);
            qno.setText("" + (count + 1) + ". ");
            selected=hard[r];
            question.setText(questions[hard[r]][0]);
            opt1.setText(questions[hard[r]][1]);
            opt1.setActionCommand(questions[hard[r]][1]);
            
            opt2.setText(questions[hard[r]][2]);
            opt2.setActionCommand(questions[hard[r]][2]);
            
            opt3.setText(questions[hard[r]][3]);
            opt3.setActionCommand(questions[hard[r]][3]);
            
            opt4.setText(questions[hard[r]][4]);
            opt4.setActionCommand(questions[hard[r]][4]);
            
            
            obj.deleteElement(hard,hard[r]);
            hard_no--;
        }

        
        groupoptions.clearSelection();
    }
    

}
