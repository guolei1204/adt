package com.thread.test.algs4.c1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuickUF {

    private int n;
    private int[] id;

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner(new java.io.BufferedInputStream(new FileInputStream(new File("/Users/guolei/java/algs4/data/tinyUF.txt"))), "utf-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public QuickUF(int n) {
        this.n = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        int n = QuickUF.readInt();
        QuickUF quf = new QuickUF(n);

        while (scanner.hasNext()) {
            int p = QuickUF.readInt();
            int q = QuickUF.readInt();
            if (quf.connect(p, q)) {
                continue;
            }
            quf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(quf.count() + "components");
    }

    private int count() {
        return n;
    }

    private void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        n--;
    }

    private boolean connect(int p, int q) {
        return id[p] == id[q];
    }


    public static int readInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from standard input, "
                    + "but the next token is \"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from standard input, "
                    + "but no more tokens are available");
        }

    }
}
