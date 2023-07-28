package OOPs;


class Shape{
    String color; 
    private String colorid;

    public String getcolorid(){
        return this.colorid;
    }

    public void setColorid(String colorid){
        this.colorid = colorid;
    }

    // in order to access private things - getters and setters 
}

// class Triangle extends Shape{

// }

public class InheritOOPS {
    public static void main(String[] args) {
        //Triangle t1 = new Triangle();
        //t1.color = "red"; // increases the reusability of code  
        // grouping related items together - package
        Shape shape1 = new Shape();
        shape1.color = "square";
        shape1.setColorid("abcd");  
        System.out.println(shape1.getcolorid());
        
        // for static methods and static variables we can access them from the name of a class 
        // whenever we want to save memory and we have some common information we can make it static 
    }
}
