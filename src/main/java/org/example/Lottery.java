package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Lottery {

    private static ArrayList<Toy> toys = new ArrayList<>();
    private static PriorityQueue<Toy> prizes = new PriorityQueue<>();

    private static int idCounter = 0;

    public void addToy() {
        Scanner scan = new Scanner(System.in);
        String title;
        int frequency;
        while (true) {
            System.out.println("Enter title: ");
            title = scan.nextLine();
            if (title.isEmpty()) {
                System.out.println("Incorrect input. Try again.");
                break;
            }
            System.out.println("Enter Frequency of dropping out: ");
            String value = scan.nextLine();
            if (isDigit(value)) {
                frequency = Integer.parseInt(value);
                if (frequency <= 0) {
                    System.out.println("Incorrect input. Try again.");

                } else {
                    Toy toy = new Toy(idCounter, title, frequency);
                    if (!toys.contains(toy) || toys.size() == 0) {
                        idCounter++;
                        toys.add(toy);
                        System.out.println("NEW Toy was Add");

                    } else {
                        System.out.println("This toy is already in the prize fund.");

                    }
                }
            } else {
                System.out.println("Incorrect input. Try again.");
            }
            break;
        }
    }

    public void setFrequency() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Toy Id");
        String value = scan.nextLine();
        if (isDigit(value)) {
            int selectedId = Integer.parseInt(value);
            if (selectedId >= 0 && selectedId < toys.size()) {
                System.out.println("Toy" + toys.get(selectedId).getToyTitle() + "has frequency of victory" +
                        toys.get(selectedId).getToyVictoryFrequensy());
                System.out.println("Enter new Frequency of dropping out: ");
                value = scan.nextLine();
                if (isDigit(value)) {
                    int newFrequency = Integer.parseInt(value);
                    toys.get(selectedId).setToyVictoryFrequensy(newFrequency);
                    System.out.println("Frequency was change");
                } else {
                    System.out.println("Try agene");
                }
            } else {
                System.out.println("There is not toy with such ID in prize fund.");
            }

        } else {
            System.out.println("Incorrect input. Try again.");
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Toy getPrize() {
        if (prizes.size() == 0) {
            Random rnd = new Random();
            for (Toy toy : toys) {
                for (int i = 0; i < toy.getToyVictoryFrequensy(); i++) {
                    Toy temp = new Toy(toy.getToyId(), toy.getToyTitle(), rnd.nextInt(1, 10));
                    prizes.add(temp);
                }
            }
        }
        return prizes.poll();

    }

    public void lottery() {
        if (toys.size() >= 2) {
            Toy prize = getPrize();
            System.out.println("Prize = " + prize.getToyTitle());
            seveResult(prize.getInfo());

        } else {
            System.out.println("You should add at least two toys into prize fund.");
        }
    }
    private void seveResult(String text){
        File file = new File("Result.txt");
        try {
            file.createNewFile();

        }catch (Exception ignored){
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("Result.txt", true)){
            fw.write(text + "\n");

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }


}

