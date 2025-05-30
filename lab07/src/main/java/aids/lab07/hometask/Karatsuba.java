package aids.lab07.hometask;

public class Karatsuba {

    public static void main(String[] args) {
        String a = "1101"; // 13
        String b = "1010"; // 10
        String result = multiply(a, b);
        System.out.println("Result: " + result); // 1000001013 = 130
    }

    public static String multiply(String a, String b) {
        // доп строки до одинаковой длины (по усл они уже степени двойки)
        int length = Math.max(a.length(), b.length());
        a = addZeros (a, length);
        b = addZeros (b, length);

        // база
        if (length == 1) {
            return (a.charAt(0) == '1' && b.charAt(0) == '1') ? "1" : "0";
        }

        int half = length / 2;

        // разд на половинки
        String aHigh = a.substring(0, half);
        String aLow = a.substring(half);
        String bHigh = b.substring(0, half);
        String bLow = b.substring(half);

        String p1 = multiply(aHigh, bHigh);
        String p2 = multiply(aLow, bLow);
        String p3 = multiply(addBinary(aHigh, aLow), addBinary(bHigh, bLow));

        // (p1 * 2^n) + ((p3 - p1 - p2) * 2^(n/2)) + p2
        String term1 = shiftLeft(p1, length);
        String term2 = shiftLeft(subtractBinary(subtractBinary(p3, p1), p2), half);
        String term3 = p2;

        return addBinary(addBinary(term1, term2), term3);
    }

    // доб нули слева до нужной длины
    private static String addZeros(String s, int length) {
        while (s.length() < length) {
            s = "0" + s;
        }
        return s;
    }

    // сдвиг влево на n позиций
    private static String shiftLeft(String s, int n) {
        return s + "0".repeat(n);
    }

    // + бин чисел
    private static String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        a = addZeros (a, maxLength);
        b = addZeros (b, maxLength);

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            result.insert(0, sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }

    // -, где a >= b
    private static String subtractBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        a = addZeros(a, maxLength);
        b = addZeros (b, maxLength);

        StringBuilder result = new StringBuilder();
        int borrow = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int sub = (a.charAt(i) - '0') - (b.charAt(i) - '0') - borrow;
            if (sub < 0) {
                sub += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.insert(0, sub);
        }

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}