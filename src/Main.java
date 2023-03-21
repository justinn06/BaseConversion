import java.util.*;
public class Main {
    public static void main(String[] args) {

        System.out.println("Please enter a number in base 2: ");
        Scanner key = new Scanner(System.in);
        String num = key.nextLine();

        /*System.out.println("Which base is your number? ");
        key = new Scanner(System.in);
        int base = key.nextInt();*/

        Number num1 = new Number(num, 2);
        System.out.println(num1.toString());

    }
}
