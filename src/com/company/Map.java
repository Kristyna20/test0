package com.company;

import javax.lang.model.util.ElementScanner6;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Map {
    private static boolean first = true;
    Scanner sc = new Scanner(System.in);
    static Player myPlayer = new Player();
    static int[][] map = {
            {
                    2, 2, 2, 2, 2, 2, 2, 2, 2, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 0, 0, 0, 0, 0, 0, 0, 0, 2
            },
            {
                    2, 2, 2, 2, 2, 2, 2, 2, 2, 2
            },
    };

    public void showMap() {
        if (first){
            putPlayer(myPlayer);
            first = false;
        }
        System.out.println("Map:");
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        System.out.println();
    }

    public static void putPlayer(Player myPlayer) {
        map[myPlayer.getY()][myPlayer.getX()] = 1;

    }

    public void movePlayer(Options options) throws WrongDirectionException {
        switch (options) {
            case TOP -> {
                if (map[myPlayer.getY() - 1][myPlayer.getX()] == 0) {
                    map[myPlayer.getY() - 1][myPlayer.getX()] = 1;
                    map[myPlayer.getY()][myPlayer.getX()] = 2;
                    myPlayer.setY(myPlayer.getY() - 1);
                } else {
                    throw new WrongDirectionException();
                }
            }
            case LEFT -> {
                if (map[myPlayer.getY()][myPlayer.getX() - 1] == 0) {
                    map[myPlayer.getY()][myPlayer.getX() - 1] = 1;
                    map[myPlayer.getY()][myPlayer.getX()] = 2;
                    myPlayer.setX(myPlayer.getX() - 1);
                }else {
                    throw new WrongDirectionException();
                }
            }
            case RIGHT -> {
                if (map[myPlayer.getY()][myPlayer.getX() + 1] == 0) {
                    map[myPlayer.getY()][myPlayer.getX() + 1] = 1;
                    map[myPlayer.getY()][myPlayer.getX()] = 2;
                    myPlayer.setX(myPlayer.getX() + 1);
                }else {
                    throw new WrongDirectionException();
                }
            }
            case BOTTOM -> {
                if (map[myPlayer.getY() + 1][myPlayer.getX()] == 0) {
                    map[myPlayer.getY() + 1][myPlayer.getX()] = 1;
                    map[myPlayer.getY()][myPlayer.getX()] = 2;
                    myPlayer.setY(myPlayer.getY() + 1);
                }else {
                    throw new WrongDirectionException();
                }
            }
        }

    }
    public void getUseInput() throws WrongDirectionException {
        String userInput = sc.nextLine();
        if (userInput.equals("TOP")) {
            movePlayer(Options.TOP);
        }else  if (userInput.equals("LEFT")) {
            movePlayer(Options.LEFT);
        }else  if (userInput.equals("RIGHT")) {
            movePlayer(Options.RIGHT);
        }else  if (userInput.equals("BOTTOM")) {
            movePlayer(Options.BOTTOM);
        }
    }

}

