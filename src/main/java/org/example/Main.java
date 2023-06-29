package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lottery l = new Lottery();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("""
                    Main menu:
                    1 - Add a new toy into the prize fund
                    2 - Change the frequency of dropping out some toy
                    3 - Hold a raffle and save results
                    0 - EXIT
                    >\s""");
            var selection = sc.next();
            switch (selection){
                case "1" -> l.addToy();
                case "2" -> l.setFrequency();
                case "3" -> l.lottery();
                case "0" ->{
                    System.out.println("See u late, Bye!!");
                    System.exit(0);

                }
                default -> System.out.println("Incorrect selection. Try again.");
            }
        }

    }
}