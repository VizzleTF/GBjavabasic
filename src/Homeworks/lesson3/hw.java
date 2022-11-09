package Homeworks.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hw {

    static final int SIZE_X = 3;
    static final int SIZE_Y = 3;
    static final int WIN_COND = 3;
    static int player_count = 0;
    static int[] player_turnsy = new int[SIZE_Y * SIZE_Y / 2];
    static int[] player_turnsx = new int[SIZE_X * SIZE_X / 2];
    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';
    static final char EMPTY_DOT = ' ';

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static final char[][] field = new char[SIZE_Y][SIZE_X];

    private static void initfield(int y, int x, char dot) {
        for (int i = 0; i < y; i++) {
            for (int j= 0; j < x; j++)
                field[i][j] = dot;
        }
    }

    private static void printfield(int y, int x) {
        for (int i = 0; i < y; i++) {
            System.out.print("|");
            for (int j= 0; j < x; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static void playerturn(){
        int x;
        int y;
        do {
            System.out.println("Choose x & y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!checkturn(y, x));
        player_turnsy[player_count] = y;
        player_turnsx[player_count] = x;
        doturn(y, x, PLAYER_DOT);
    }

    private static void aiturn(){
        int x;
        int y;
        do {
            y = random.nextInt(SIZE_Y);
            x = random.nextInt(SIZE_X);
        } while (!checkturn(y,x));
        doturn(y, x, AI_DOT);
    }
    private static void doturn(int y, int x, char dot) {
        field[y][x]=dot;
    }

    private static boolean checkturn(int y, int x) {
        if (y < 0 || y > SIZE_Y - 1 || x < 0 || x > SIZE_X - 1) return false;
        return field[y][x] == EMPTY_DOT;
    }

    private static boolean checkwin(char dot) {
        for(int i = 0; i < SIZE_Y; i++) {
            int count = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if(field[i][j] == dot)
                    count++;
            }
            if (count >= WIN_COND) return true;
        }
        for(int i = 0; i < SIZE_X; i++) {
            int count = 0;
            for (int j = 0; j < SIZE_Y; j++) {
                if(field[j][i] == dot)
                    count++;
            }
            if (count >= WIN_COND) return true;
        }
        for(int i = 0; i < SIZE_Y; i++) {
            int count = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if(j+i < SIZE_X) {
                    if (field[j][j + i] == dot)
                        count++;
                }
            }
            if (count >= WIN_COND) return true;
        }
        for(int i = 0; i < SIZE_Y; i++) {
            int count = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if(j-i >= 0) {
                    if (field[j][j - i] == dot)
                        count++;
                }
            }
            if (count >= WIN_COND) return true;
        }
        for(int i = 0; i < SIZE_Y; i++) {
            int count = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if(j+i < SIZE_X) {
                    if (field[SIZE_X -1 - j][j + i] == dot)
                        count++;
                }
            }
            if (count >= WIN_COND) return true;
        }
        for(int i = 0; i < SIZE_Y; i++) {
            int count = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if(j-i >= 0) {
                    if (field[SIZE_X - 1 - j][j - i] == dot)
                        count++;
                }
            }
            if (count >= WIN_COND) return true;
        }
        return false;
    }

    private static boolean checkspace() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT)
                    return true;
            }
        }
        return false;
    }
    private static void advancedAIturn() {
        int x;
        int y;
        if (player_count >= 1) {
            y = 2 * player_turnsy[player_count] - player_turnsy[player_count -1];
            x = 2 * player_turnsx[player_count] - player_turnsx[player_count -1];
            y = (y > 0) ? y : 0 - y;
            x = (x > 0) ? x : 0 - x;
            System.out.println(y + " " + x);
            if (!checkturn(y,x)) {
                y = (player_turnsy[player_count] + player_turnsy[player_count - 1]) / 2;
                x = (player_turnsx[player_count] + player_turnsx[player_count - 1]) / 2;
                System.out.println(y + " " + x);
                y = (y > 0) ? y : 0 - y;
                x = (x > 0) ? x : 0 - x;
                if (!checkturn(y,x)) {
                    do {
                        y = random.nextInt(SIZE_Y);
                        x = random.nextInt(SIZE_X);
                    } while (!checkturn(y, x));
                }
            }
        } else {
            do {
                y = random.nextInt(SIZE_Y);
                x = random.nextInt(SIZE_X);
            } while (!checkturn(y,x));
        }
        doturn(y, x, AI_DOT);
    }





    public static void main(String[] args){
        initfield(SIZE_Y, SIZE_X, EMPTY_DOT);
        printfield(SIZE_Y, SIZE_X);
        while (true) {
            playerturn();
            printfield(SIZE_Y, SIZE_X);
            if (checkwin(PLAYER_DOT)) {
                System.out.println("You won");
                break;
            }
            if (!checkspace()) {
                System.out.println("DRAW");
                break;
            }
            advancedAIturn();
            printfield(SIZE_Y, SIZE_X);
            if (checkwin(AI_DOT)) {
                System.out.println("You loose");
                break;
            }
            if (!checkspace()) {
                System.out.println("DRAW");
                break;
            }
            player_count++;
        }
    }
}
