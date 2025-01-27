package com.csc;
public class Power {
    public int naivePower(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return x * naivePower(x, n - 1);
    }
    public int unoptimizedDCPower(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return unoptimizedDCPower(x, n / 2) * unoptimizedDCPower(x, n / 2);
        }
        else {
            return x * unoptimizedDCPower(x, n / 2) * unoptimizedDCPower(x, n / 2);
        }
    }
    public int optimizedDCPower(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int temp = optimizedDCPower(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }
        else {
            return x * temp * temp;
        }
    }
public static void main(String[] args) {

    // driver testing because junit was goofing today
    Power power = new Power();
    // if (power.naivePower(2, 3) == 8) {
    //     System.out.println("naivePower works");
    // }
    // if (power.unoptimizedDCPower(2, 3) == 8) {
    //     System.out.println("unoptimizedDCPower works");
    // }
    // if (power.optimizedDCPower(2, 3) == 8) {
    //     System.out.println("optimizedDCPower works");
    // }
    // if (power.naivePower(3, 2) == 9) {
    //     System.out.println("naivePower still works");
    // }
    // if (power.unoptimizedDCPower(3, 2) == 9) {
    //     System.out.println("unoptimizedDCPower still works");
    // }
    // if (power.optimizedDCPower(3, 2) == 9) {
    //     System.out.println("optimizedDCPower still works");
    // }
    // time testing
    long start = System.nanoTime();
    power.naivePower(10, 1000);
    long end = System.nanoTime();
    System.out.println(end - start);

    long start1 = System.nanoTime();
    power.unoptimizedDCPower(10,1000);
    long end1 = System.nanoTime();
    System.out.println(end1 - start1);

    long start2 = System.nanoTime();
    power.optimizedDCPower(10, 1000);
    long end2 = System.nanoTime();
    System.out.println(end2 - start2);
}
}
