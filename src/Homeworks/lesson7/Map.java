package Homeworks.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    int[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLength;
    int cellHeight;
    int cellWidth;

    private static final int EMPTY_DOT = 0;
    private static final int AI_DOT = 1;
    private static final int PLAYER_DOT = 2;
    static int player_count = 0;
    int[] player_turnsy = new int[fieldSizeY * fieldSizeY / 2];
    int[] player_turnsx = new int[fieldSizeX * fieldSizeX / 2];
    static Random random = new Random();


    boolean isInitialized = false;

    Map()
    {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (!isInitialized) return;
                update(e);
            }
        });
    }

    void update(MouseEvent e){
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        render(g);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength =winLength;
        field = new int[fieldSizeY][fieldSizeX];
        isInitialized = true;
        repaint();
    }

    void render(Graphics g) {
        if (!isInitialized) return;
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellHeight;
            g.drawLine(x, 0, x, panelHeight);

        }

    }

    private void doturn(int y, int x, int dot) {
        field[y][x]=dot;
    }

    private boolean checkturn(int y, int x) {
        if (y < 0 || y > fieldSizeY - 1 || x < 0 || x > fieldSizeX - 1) return false;
        return field[y][x] == EMPTY_DOT;
    }

    private boolean checkwin(int dot) {
        for(int i = 0; i < fieldSizeY; i++) {
            int count = 0;
            for (int j = 0; j < fieldSizeX; j++) {
                if(field[i][j] == dot) {
                    count++;
                    if (count >= winLength) return true;
                } else {
                    count = 0;
                }
            }

        }
        for(int i = 0; i < fieldSizeX; i++) {
            int count = 0;
            for (int j = 0; j < fieldSizeY; j++) {
                if(field[j][i] == dot){
                    count++;
                    if (count >= winLength) return true;
                } else {
                    count = 0;
                }
            }
        }
        for(int i = 0; i < fieldSizeY; i++) {
            int count = 0;
            for (int j = 0; j < fieldSizeX; j++) {
                if(j+i < fieldSizeX) {
                    if (field[j][j + i] == dot){
                        count++;
                        if (count >= winLength) return true;
                    } else {
                        count = 0;
                    }
                }
            }
        }
        for(int i = 0; i < fieldSizeY; i++) {
            int count = 0;
            for (int j = 0; j < fieldSizeX; j++) {
                if(j-i >= 0) {
                    if (field[j][j - i] == dot){
                        count++;
                        if (count >= winLength) return true;
                    } else {
                        count = 0;
                    }
                }
            }
        }
        for(int i = 0; i < fieldSizeY; i++) {
            int count = 0;
            for (int j = 0; j < fieldSizeX; j++) {
                if(j+i < fieldSizeX) {
                    if (field[fieldSizeX -1 - j][j + i] == dot){
                        count++;
                        if (count >= winLength) return true;
                    } else {
                        count = 0;
                    }
                }
            }
        }
        for(int i = 0; i < fieldSizeY; i++) {
            int count = 0;
            for (int j = 0; j < fieldSizeX; j++) {
                if(j-i >= 0) {
                    if (field[fieldSizeX - 1 - j][j - i] == dot){
                        count++;
                        if (count >= winLength) return true;
                    } else {
                        count = 0;
                    }
                }
            }
        }
        return false;
    }

    private boolean winstrat() {
        for(int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (checkturn(i,j) == true) {
                    field[i][j] = AI_DOT;
                    if (checkwin(AI_DOT) == true)
                        return true;
                    field[i][j] = EMPTY_DOT;
                }
            }
        }
        return false;
    }

    private boolean defstrat() {
        for(int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (checkturn(i,j) == true) {
                    field[i][j] = PLAYER_DOT;
                    if (checkwin(PLAYER_DOT) == true) {
                        field[i][j] = AI_DOT;
                        return true;
                    }
                    field[i][j] = EMPTY_DOT;
                }
            }
        }
        return false;
    }

    private boolean checkspace() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT)
                    return true;
            }
        }
        return false;
    }
    private void advancedAIturn() {
        if (winstrat() == false) {
            if (defstrat() == false) {
                int x;
                int y;
                if (player_count >= 1) {
                    y = 2 * player_turnsy[player_count] - player_turnsy[player_count - 1];
                    x = 2 * player_turnsx[player_count] - player_turnsx[player_count - 1];
                    y = (y > 0) ? y : 0 - y;
                    x = (x > 0) ? x : 0 - x;
                    if (!checkturn(y, x)) {
                        y = (player_turnsy[player_count] + player_turnsy[player_count - 1]) / 2;
                        x = (player_turnsx[player_count] + player_turnsx[player_count - 1]) / 2;
                        if (!checkturn(y, x)) {
                            do {
                                y = random.nextInt(fieldSizeY);
                                x = random.nextInt(fieldSizeX);
                            } while (!checkturn(y, x));
                        }
                    }
                } else {
                    do {
                        y = random.nextInt(fieldSizeY);
                        x = random.nextInt(fieldSizeX);
                    } while (!checkturn(y, x));
                }
                doturn(y, x, AI_DOT);
            }
        }
    }
}