package lojadetelemoveis;

import java.io.*;

public class Ler {

    public static String umaString() {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            s = in.readLine();

        } catch (IOException e) {
            System.out.println("Erro ao ler");
        }
        return s;
    }

    public static int umInt() {
        while (true) {
            try {
                return Integer.valueOf(umaString().trim());
            } catch (Exception e) {
                System.out.print("Inválido, introduza novamente:");
            }
        }
    }

    public static float umFloat() {
        while (true) {
            try {
                return Float.valueOf(umaString().trim());
            } catch (Exception e) {
                System.out.print("Inválido, introduza novamente:");
            }
        }
    }

    public static double umDouble() {
        while (true) {
            try {
                return Double.valueOf(umaString().trim());
            } catch (Exception e) {
                System.out.print("Inválido, introduza novamente:");
            }
        }
    }

    public static long umLong() {
        while (true) {
            try {
                return Long.valueOf(umaString().trim());
            } catch (Exception e) {
                System.out.print("Inválido, introduza novamente:");
            }
        }
    }

    public static boolean umBoolean() {
        while (true) {
            try {
                return Boolean.valueOf(umaString().trim());
            } catch (Exception e) {
                System.out.print("Inválido, introduza novamente:");
            }
        }
    }

    public static char umChar() {
        while (true) {
            try {
                return umaString().trim().charAt(0);
            } catch (Exception e) {
                System.out.print("Inválido, introduza novamente:");
            }
        }
    }

}
