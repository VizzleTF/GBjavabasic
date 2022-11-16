package Homeworks.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame{
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_WIDTH =507;
    private static final int WIN_POS_X = 800;
    private static final int WIN_POS_Y = 300;

    private static final int BUTTONS = 2;
    private static final int LINE_OF_BUTTONS = 1;

    private static StartNewGameWindow startNewGameWindow;
    private static Map field;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setResizable(false);
        setTitle("Tic Tac Toe");

        startNewGameWindow = new StartNewGameWindow(this);

        JPanel topPanel = new JPanel(new GridLayout(LINE_OF_BUTTONS, BUTTONS));
        JButton btnNewGame = new JButton("Start new game");
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startNewGameWindow.setVisible(true);
            }
        });
        topPanel.add(btnNewGame);

        JButton btnExit = new JButton("Exit game");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        topPanel.add(btnExit);

        field = new Map();
        add(field, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);


        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        field.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }

    }
