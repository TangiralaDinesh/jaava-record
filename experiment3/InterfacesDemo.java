import java.util.Arrays;

interface Shape {
    double area();
}

class Circle implements Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private final double length;
    private final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class Player implements Comparable<Player> {
    private final String name;
    private final int runs;

    Player(String name, int runs) {
        this.name = name;
        this.runs = runs;
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.runs, runs);
    }

    @Override
    public String toString() {
        return name + "(" + runs + ")";
    }
}

interface Payment {
    double charge(double amount);
    String name();
}

class Upi implements Payment {
    @Override
    public double charge(double amount) { return 0; }
    @Override
    public String name() { return "UPI"; }
}

class Card implements Payment {
    @Override
    public double charge(double amount) { return amount * 0.02; }
    @Override
    public String name() { return "Card"; }
}

class Cash implements Payment {
    @Override
    public double charge(double amount) { return 20; }
    @Override
    public String name() { return "Cash"; }
}

public class InterfacesDemo {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(5), new Rectangle(4, 6) };
        for (Shape shape : shapes) {
            System.out.printf("%-10s area = %.2f%n",
                    shape.getClass().getSimpleName(), shape.area());
        }

        Player[] players = {
            new Player("Ravi", 45), new Player("Anu", 92), new Player("Kiran", 67)
        };
        Arrays.sort(players);
        System.out.println("Players by runs = " + Arrays.toString(players));

        double fee = 75000;
        Payment[] paymentModes = { new Upi(), new Card(), new Cash() };
        for (Payment payment : paymentModes) {
            double charge = payment.charge(fee);
            System.out.printf("%-5s charge = %7.2f total = %10.2f%n",
                    payment.name(), charge, fee + charge);
        }
    }
}