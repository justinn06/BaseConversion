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
    }

    public void Convert() {
        double sum = 0;
        int len = base2.length();

            //base 10
            for (int i = 0; i < len; i++) {
                char c = base2.charAt(i);
                int n = c - '0';
                sum = sum + (n * Math.pow(2, len - (i + 1)));
            }
            this.base10 = Double.toString(sum);
            this.intBase10 = (int) sum;


            String str = "";
            sum = 0;

            //base 8
            int r = 3 - (len % 3);
            if (r != 0) {
                for (int i = 0; i < r; i++)
                    base2 = '0' + base2;
            }

            len = base2.length();

            for (int i = 0; i < (len / 3); i++) {
                for (int j = 0; j < 3; j++) {
                    char c = base2.substring(i*3, (i+1)*3).charAt(j);
                    int n = c - '0';
                    sum = sum + (n * Math.pow(2, 2-j));
                }
                str = str + String.valueOf(Math.round(sum));
                sum = 0;
            }
            this.base8 = str;

            //base 16
            str = "";
            sum = 0;
            String s = "";

            r = 4 - (len % 4);
            if (r != 0) {
                for (int i = 0; i < r; i++)
                    base2 = '0' + base2;
            }

            len = base2.length();

            for (int i = 0; i < (len / 4); i++) {
                for (int j = 0; j < 4; j++) {
                    char c = base2.substring(i*4, (i+1)*4).charAt(j);
                    int n = c - '0';
                    sum = sum + (n * Math.pow(2, 3-j));
                }
                if (sum > 9) {
                    s = ConvertChar((int) sum);
                }
                else
                    s = String.valueOf(Math.round(sum));
                str = str + s;
                sum = 0;
            }
            this.base16 = str;
        }


    public String ConvertChar(int c) {
        if (c == 10)
            return "A";
        else if (c == 11)
            return "B";
        else if (c == 12)
            return "C";
        else if (c == 13)
            return "D";
        else if (c == 14)
            return "E";
        else if (c == 15)
            return "F";
        else
            return "invalid";
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
