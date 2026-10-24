abstract class SalaryEmployee {
    private final String name;
    protected final double basic;

    SalaryEmployee(String name, double basic) {
        this.name = name;
        this.basic = basic;
    }

    String getName() {
        return name;
    }

    abstract double pay();
}

class SalaryManager extends SalaryEmployee {
    SalaryManager(String name, double basic) { super(name, basic); }
    @Override
    double pay() { return basic * 1.40; }
}

class Engineer extends SalaryEmployee {
    Engineer(String name, double basic) { super(name, basic); }
    @Override
    double pay() { return basic * 1.20; }
}

class Intern extends SalaryEmployee {
    Intern(String name, double basic) { super(name, basic); }
    @Override
    double pay() { return basic; }
}

class Person {
    protected final String name;

    Person(String name) { this.name = name; }

    void show() { System.out.println("Name   : " + name); }
}

class Employee extends Person {
    private final double salary;

    Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    void show() {
        super.show();
        System.out.println("Salary : " + salary);
    }
}

class Manager extends Employee {
    private final String department;

    Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    void show() {
        super.show();
        System.out.println("Dept   : " + department);
    }
}

class Staff {
    protected final String name;
    Staff(String name) { this.name = name; }
    String role() { return "Staff"; }
}

class Teacher extends Staff {
    Teacher(String name) { super(name); }
    @Override
    String role() { return "Teacher"; }
}

class Driver extends Staff {
    Driver(String name) { super(name); }
    @Override
    String role() { return "Driver"; }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("Multilevel inheritance and overriding:");
        Person person = new Manager("Meena", 75000, "CSE");
        person.show();

        System.out.println("\nHierarchical inheritance:");
        Staff[] staff = { new Teacher("Kumar"), new Driver("Selvam"), new Staff("Raj") };
        for (Staff member : staff) {
            System.out.println(member.name + " -> " + member.role());
        }

        System.out.println("\nAbstract salary rules:");
        SalaryEmployee[] employees = {
            new SalaryManager("Meena", 50000),
            new Engineer("Ravi", 40000),
            new Intern("Anu", 12000)
        };
        for (SalaryEmployee employee : employees) {
            System.out.printf("%-8s %10.2f%n", employee.getName(), employee.pay());
        }
    }
}