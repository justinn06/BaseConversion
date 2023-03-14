import java.math.*;
public class Number {
    String base16;
    String base10;
    String base8;
    String base2;
    int intBase10;

    public Number(String input, int base) {
        if (base == 16) {
            this.base16 = input;
            ConvertNumber(input, base);
        }
        else if (base == 10)
            this.base10 = input;
        else if (base == 8)
            this.base8 = input;
        else if (base == 2)
            this.base2 = input;
        else
            System.out.println("Invalid base.");
    }

    public int ConvertNumber(String input, int base) {
        int num = 0;
        int len = input.length();
        if (base == 2)
            num = BinaryToDecimal(input, len);
        return num;
    }

    public int ConvertChar(char c) {
        if (c == 'A')
            return 10;
        else if (c == 'B')
            return 11;
        else if (c == 'C')
            return 12;
        else if (c == 'D')
            return 13;
        else if (c == 'E')
            return 14;
        else if (c == 'F')
            return 15;
        else
            System.out.println("Invalid character.");
            return -1;
    }

    public int BinaryToDecimal(String input, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++){
            if (Integer.parseInt(String.valueOf(input.charAt(i))) == '1')
                sum = sum + Integer.parseInt(String.valueOf(input.charAt(i)))*(int)Math.pow(2, i);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Number{" +
                "base 16 = " + base16 +
                ", base 10 = " + base10 +
                ", base 8 = " + base8 +
                ", base 2 = " + base2 +
                ", intBase 10 = " + intBase10 +
                '}';
    }
}
