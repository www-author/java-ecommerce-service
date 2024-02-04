package com.ecommerce.utils;

import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    public Console() {
    }

    public static String readLine() {
        return getInstance().nextLine();
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }

    }

    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }
}
