class InvalidAgeException extends Exception {
    InvalidAgeException(String message) { super(message); }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String message) { super(message); }
}

class LowBalanceException extends Exception {
    LowBalanceException(String message) { super(message); }
}

public class ExceptionDemo {
    private static double balance = 5000;

    private static void verifyAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is below 18");
        }
        System.out.println("Age " + age + " accepted");
    }

    private static void withdraw(double amount)
            throws InvalidAmountException, LowBalanceException {
        if (amount <= 0 || amount % 100 != 0) {
            throw new InvalidAmountException(
                    "Amount must be positive and a multiple of 100: " + amount);
        }
        if (amount > balance) {
            throw new LowBalanceException("Balance is only " + balance);
        }
        balance -= amount;
        System.out.println("Dispensed " + amount + ", balance " + balance);
    }

    public static void main(String[] args) {
        try {
            int[] values = new int[3];
            int invalidIndex = 5;
            System.out.println(values[invalidIndex]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Array error caught");
        }

        try {
            int numerator = 10;
            int divisor = 0;
            System.out.println(numerator / divisor);
        } catch (ArithmeticException exception) {
            System.out.println("Math error caught");
        } finally {
            System.out.println("finally block ran");
        }

        try {
            String missing = null;
            System.out.println(missing.length());
        } catch (NullPointerException exception) {
            System.out.println("Null reference error caught");
        }

        try {
            verifyAge(21);
            verifyAge(15);
        } catch (InvalidAgeException exception) {
            System.out.println("Rejected: " + exception.getMessage());
        }

        double[] attempts = { 2000, 350, 9000, 1500 };
        for (double amount : attempts) {
            try {
                withdraw(amount);
            } catch (InvalidAmountException exception) {
                System.out.println("Invalid amount: " + exception.getMessage());
            } catch (LowBalanceException exception) {
                System.out.println("Withdrawal refused: " + exception.getMessage());
            }
        }
    }
}