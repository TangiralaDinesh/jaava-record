import java.util.*;

public class CaseStudy1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter the no of students : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        if (n <= 0) {
            System.out.println("Number of students must be greater than zero.");
            sc.close();
            return;
        }

        Bill[] bills = new Bill[n];
        float max_bill =0;
        int max_i=0;
        for (int i = 1; i <= n; i++) {
            bills[i - 1] = new Bill(); 
            
            System.out.println("Enter the " + i + " student details");
            System.out.print("name : ");
            bills[i - 1].name = sc.nextLine();
            
            System.out.print("no_of_days : ");
            bills[i - 1].no_of_days = sc.nextInt();
            sc.nextLine(); 
            if (bills[i - 1].no_of_days < 0) {
                System.out.println("Number of days cannot be negative.");
                sc.close();
                return;
            }
        }
        
        

        System.out.println("\nNAME\tDAYS\tBILL");
        float total = 0;
        for (int i = 0; i < n; i++) {
            float bill_= bills[i].calculate_bill();
            max_i=max_bill<bill_?i:max_i;
            max_bill =max_bill<bill_?bill_:max_bill;
            total += bill_;

            System.out.printf("%-12s %4d %8.2f%n", bills[i].name, bills[i].no_of_days, bill_);
        }
        sc.close();

        System.out.printf("Total collection = Rs. %.2f%n", total);
        System.out.printf("Highest bill = %s (Rs. %.2f)%n",
                bills[max_i].name, bills[max_i].calculate_bill());
    }
}

class Bill {
    int no_of_days = 0;
    String name = "";

    Bill() {}

    float calculate_bill() {
        if (no_of_days < 26) {
            return (85.0f * no_of_days) - ((85.0f * no_of_days) / 10.0f);
        }
        return 85.0f * no_of_days;
    }
}
