import java.math.*;
public class Number {
    String base16;
    String base10;
    String base8;
    String base2;
    int intBase10;

    public Number(String input, int base) {
        if (base == 16)
            this.base16 = input;
        else if (base == 10)
            this.base10 = input;
        else if (base == 8)
            this.base8 = input;
        else if (base == 2)
            this.base2 = input;
        else
            System.out.println("Invalid base.");


        Convert(input, base);

    }

    public void Convert(String input, int base) {
        double sum = 0;
        int len = input.length();

        if (base == 2) {
            for (int i = 0; i < len; i++) {
                char c = input.charAt(i);
                int n = c - '0';
                sum = sum + (n * Math.pow(2, len - (i + 1)));
            }
            this.base10 = Double.toString(sum);
            this.intBase10 = (int) sum;

            //base 16
            String str = "";
            sum = 0;

            int r = 4 - (len % 4);
            if (r != 0) {
                for (int i = 0; i < r; i++)
                    input = '0' + input;
            }
            System.out.println("new string " + input);

            len = input.length();

            for (int i = 0; i < (len / 4); i++) {
                for (int j = 0; j < 4; j++) {
                    char c = input.substring(i*4, (i+1)*4).charAt(j);
                    int n = c - '0';
                    sum = sum + (n * Math.pow(2, 3-j));
                }
                str = str + String.valueOf(Math.round(sum));
                sum = 0;
            }
            this.base16 = str;
        }
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

    @Override
    public String toString() {
        return "Number{" +
                "base 16 = '" + base16 +
                "', base 10 = '" + base10 +
                "', base 8 = '" + base8 +
                "', base 2 = '" + base2 +
                "', intBase 10 = " + intBase10 +
                '}';
    }
}
