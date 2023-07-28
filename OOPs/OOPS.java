package OOPs;

class Pen{
    String color; 
    String type; 

    public void write(){
        System.out.println("writing something");
    }

    public void PrintColor(){
        System.out.println(this.color);
    }
}

class Student{
    // the names of classes start with capital letters by convention - functions start with small letters 
    String name; 
    int age; 
    // does not need to be a wrapped class 

    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);

        /**
         * the printinfo function can be called in multiple ways -> 
        with different params and having the same name 
        this concept is called function overloading -> this is also called compile time polymorphism 
         */
    }


    /**
     * Student(){
        System.out.println("constructor called");
    }
    -> Non Parameterized Constructors 

    Student(String name, int age){
        this.name = name; 
        this.age = age; 
    }
     * @param s2
     */

    Student(Student s2) {
        this.name = s2.name; 
        this.age = s2.age; 
    }

    Student(){
    }
}

public class OOPS {
    public static void main(String[] args) {

        /*
         *  space gets allocated in the memory heap - and the object gets storedn there 
        Student() - paranthesis indicate fuctions and in this case they are called constructors 
        3 types of constructors in java 
        Type 1 - Non - Parametrized Constructors - no params 
        Consttuctors name is the same as the name of the class - no return time - for one object we can only call them when they are being created
        
        Type 2 - Paramaterized Constructors 

        Type 3 - Copy Constructors - derived from C++ initially but in java all the copy constructors need to be initialized in the console 
        c++ has a function called a destructor -> java already has a garbage collector so there is no need to write a destructor 
         */

        Student s1 = new Student();
        s1.name = "ishan";
        s1.age = 19;

        Student s2 = new Student(s1);
        s2.printInfo();

    }
}
