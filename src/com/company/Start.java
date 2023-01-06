package com.company;

import java.util.Scanner;

public class Start {
    private boolean running = true;
    Scanner sc = new Scanner(System.in);
    public Map myMap = new Map();
    public Player myPlayer = new Player();

    public Start() throws WrongDirectionException {
        myMap.showMap();
        while (running) {
            myMap.movePlayer(selectOption());
            myMap.showMap();
        }

    }

    private void showOption() {
        System.out.println("Options: ");
        for (Options value : Options.values()) {
            System.out.println(value);
        }
    }

    private Options selectOption() {
        showOption();
        String Input = userInput();
        for (Options value : Options.values()) {
            if (Input.equalsIgnoreCase(value.toString())) {
                return value;
            }
        }
        return null;
    }

    private String userInput() {
        return sc.nextLine();
    }

}
