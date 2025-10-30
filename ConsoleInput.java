import java.util.Scanner;

public class ConsoleInput implements InputProvider {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("❌ Invalid choice. Enter number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine(); // consume newline
        return val;
    }
}