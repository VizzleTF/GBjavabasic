package Homeworks.lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StartNewGameWindow extends JFrame {
    private final GameWindow gameWindow;
    private static final int WIN_HEIGHT =230;
    private static final int WIN_WIDTH = 350;
    private static final int MIN_WIN_LEN = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private JRadioButton jrbHumanVsAI = new JRadioButton("Human vs AI", true);
    private JRadioButton jrbHumanVsHuman = new JRadioButton("Human vs human");
    private ButtonGroup gameMode = new ButtonGroup();
    private final String STR_WIN_LEN = "Winning lenght: ";
    private final String STR_FIELD_SIZE = "Field size: ";

    private JSlider slFieldSize;
    private JSlider slWinLength;

    StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WIN_WIDTH, WIN_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int)gameWindowBounds.getCenterX() - WIN_WIDTH / 2;
        int posY = (int)gameWindowBounds.getCenterY() - WIN_HEIGHT / 2;
        setLocation(posX, posY);
        setTitle("New game parameters");
        setLayout(new GridLayout(10,1));
        addGameControlsMode();
        addGameControlsFieldWinLength();
        JButton btnStartGame = new JButton("Start Game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnStartGameClick();
            }
        });
        add(btnStartGame);
    }

    void btnStartGameClick(){
        int gameMode;
        if(jrbHumanVsAI.isSelected())
            gameMode = Map.MODE_HVA;
        else if(jrbHumanVsHuman.isSelected())
            gameMode = Map.MODE_HVH;
        else
            throw new RuntimeException("No buttons selected");

        int fieldSize = slFieldSize.getValue();
        int winLength = slWinLength.getValue();
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
    }

    void addGameControlsMode() {
        add(new JLabel("Choose game mode"));
        gameMode.add(jrbHumanVsAI);
        gameMode.add(jrbHumanVsHuman);
        add(jrbHumanVsAI);
        add(jrbHumanVsHuman);
    }

    void addGameControlsFieldWinLength() {
        add(new JLabel("Choose field size"));
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        JLabel lbFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);
        add(lbFieldSize);
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int currentFieldSize = slFieldSize.getValue();
                lbFieldSize.setText(STR_FIELD_SIZE + currentFieldSize);
                slWinLength.setMaximum(currentFieldSize);
            }
        });

        add(slFieldSize);

        add(new JLabel("Choose winning length"));

        JLabel lbWinLen = new JLabel(STR_WIN_LEN + MIN_WIN_LEN);
        add(lbWinLen);
        slWinLength = new JSlider(MIN_WIN_LEN, MIN_WIN_LEN, MIN_WIN_LEN);
        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                lbWinLen.setText(STR_WIN_LEN + slWinLength.getValue());
            }
        });

        add(slWinLength);
    }
}
