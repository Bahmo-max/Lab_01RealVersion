public class ObjinputTest {
    public static void main(String[] args) {
        SafeObj input = new SafeObj();

        String name = input.getNonZeroLenString("Enter your name");
        System.out.println("Hello, " + name);

        int anyInt = input.getInt("Enter any integer");
        System.out.println("You entered: " + anyInt);

        int age = input.getRangedInt("Enter your age", 1, 120);
        System.out.println("Your age: " + age);

        double anyDouble = input.getDouble("Enter any double value");
        System.out.println("You entered: " + anyDouble);

        double salary = input.getRangedDouble("Enter your salary", 0, 1000000);
        System.out.println("Your salary: $" + salary);

        boolean continueProgram = input.getYNConfirm("Do you want to continue?");
        System.out.println("Continue? " + continueProgram);

        String email = input.getRegExString("Enter your email", "^[\\w.-]+@[\\w.-]+\\.\\w+$");
        System.out.println("Email: " + email);
    }
}
