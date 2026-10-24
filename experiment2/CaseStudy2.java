import com.scsvmv.fee.model.Student;
import com.scsvmv.fee.service.FeeRule;

public class CaseStudy2 {
	public static void main(String[] args) {
		Student[] students = {
			new Student("Meena", "BE"),
			new Student("Ravi", "ME"),
			new Student("Anu", "BSc")
		};
		double total = 0;

		System.out.printf("%-10s %-8s %12s%n", "NAME", "COURSE", "FEE");
		for (Student student : students) {
			double fee = FeeRule.feeFor(student.getCourse());
			System.out.printf("%-10s %-8s %12.2f%n",
					student.getName(), student.getCourse(), fee);
			total += fee;
		}
		System.out.printf("Total fee = Rs. %.2f%n", total);
	}
}
