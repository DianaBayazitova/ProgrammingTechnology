package Lab1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting project");

        byte v_byte = 120;
        short v_short = 129;
        char v_char = 'a';
        int v_int = 65999;
        long v_long = 4294967296L;
        float v_float = 0.33333334F;
        double v_double = 0.3333333333333333;
        boolean v_bool = true;

        System.out.println("This is a byte: " + v_byte);
        System.out.println("This is a short" + v_short);
        System.out.println("This is a char: " + v_char);
        System.out.println("This is a int: " + v_int);
        System.out.println("This is a long: " + v_long);
        System.out.println("This is a float: " + v_float);
        System.out.println("This is a double: " + v_double);
        System.out.println("This is a bool: " + v_bool);

        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        long begin = new java.util.Date().getTime();
        for (int i = 0; i <= 100000000; i++) {
        }
        long end = new java.util.Date().getTime();
        System.out.println(end - begin);

        long begin1 = new java.util.Date().getTime();
        for (long i = 0; i <= 100000000; i++) {
        }
        long end1 = new java.util.Date().getTime();
        System.out.println(end1 - begin1);

        int[] mas = {12, 43, 12, -65, 778, 123, 32, 76};
        int max = Integer.MIN_VALUE;
        for (int it : mas) {
            if (it > max) {
                max = it;
            }
        }
        System.out.println(max);

        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = (int) Math.round(Math.random() * 10);
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        int[][] transposedMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposedMatrix[i][j] = matrix[j][i];
                System.out.printf("%3d ", transposedMatrix[i][j]);
            }
            System.out.println();
        }

    }
}
