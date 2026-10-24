
class Student 
{
    int roll; 
    String name;
    int marks;
    
    void set (int r ,String n,int m )
    {
        roll=r;
        name=n;
        marks=m;
    }
    
    void show()
    {
        System.out.println(roll+" "+name+" "+marks);
    }
}

public class StudentDemoJava
{
    public static void main(String[] args)
    {
        Student s1 = new Student();
        Student s2 = new Student();
        
        s1.set(1,"Dinesh",100);
        s2.set(2,"Narayana",101);
        
        s1.show();
        s2.show();
        
    }
}
