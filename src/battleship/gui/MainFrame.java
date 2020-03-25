package battleship.gui;

import battleship.logic.HitReg;
import battleship.logic.Ships;
import battleship.logic.Player;
import battleship.text.TextMessages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame {

    final static int NUM_OF_BUTTONS = 9;
    private JFrame frame;
    private ImageIcon battleshipIcon, shipImgDef, shipImgFirst, shipImgSecond, shipImgThird;
    private JPanel panel1, panel2, panel3;
    private final JButton[] button = new JButton[NUM_OF_BUTTONS];
    private JButton statsButton, howToPlayButton, restartButton;
    private int buttonNamer = 1;
    private Cursor cursor1, cursor2;
    private JLabel shipImgLabel;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame();
        battleshipIcon = new ImageIcon(getClass().getResource("battleship.png"));
        frame.setIconImage(battleshipIcon.getImage());

        panel1 = new JPanel();
        panel1.setBackground(new Color(179, 255, 255));

        panel3 = new JPanel();
        panel3.setBackground(new Color(179, 255, 255));

        shipImgDef = new ImageIcon(new ImageIcon(getClass().getResource("default.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        shipImgFirst = new ImageIcon(new ImageIcon(getClass().getResource("first.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        shipImgSecond = new ImageIcon(new ImageIcon(getClass().getResource("second.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        shipImgThird = new ImageIcon(new ImageIcon(getClass().getResource("third.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        shipImgLabel = new JLabel(shipImgDef);
        panel3.add(shipImgLabel);
        panel3.setLayout(new GridLayout(1, 0));
        frame.add(panel3, BorderLayout.CENTER);

        cursor1 = new Cursor(Cursor.CROSSHAIR_CURSOR);
        cursor2 = new Cursor(Cursor.HAND_CURSOR);

        for (int i = 0; i < NUM_OF_BUTTONS; i++) {
            button[i] = new JButton(String.valueOf(buttonNamer));
            buttonNamer++;
            button[i].setCursor(cursor1);
            button[i].setBackground(Color.LIGHT_GRAY);
        }

        grLayout();

        buttonListener();

        miscButtons();

        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700, 500);
        frame.setTitle("Battleship");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);
    }

    void grLayout() {
        panel1.setLayout(new GridLayout(3, 3, 10, 10));
        for (JButton i : button) {
            panel1.add(i);
        }
        frame.add(panel1, BorderLayout.SOUTH);
        //frame.pack();
    }

    public void buttonListener() {
        Player player = new Player();
        Ships ships = new Ships();
        HitReg hitReg = new HitReg(player, ships);

        //console log
        int[] x = ships.getPos();
        System.out.print("Answers: ");
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println("");
        //console log

        class shipImgChanger {

            shipImgChanger() {
                switch (hitReg.numOfHits) {
                    case 1:
                        shipImgLabel.setIcon(shipImgFirst);
                        break;
                    case 2:
                        shipImgLabel.setIcon(shipImgSecond);
                        break;
                }
                if (hitReg.isSunk == true) {
                    shipImgLabel.setIcon(shipImgThird);
                }
            }
        }

        final class NumberButtonListener {

            NumberButtonListener(int i) {
                getListener(i);
            }

            void getListener(int i) {
                button[i].addActionListener((ActionEvent e) -> {
                    initActions(i);
                });
            }

            void initActions(int i) {
                player.setPlayerGuess((i + 1));
                hitReg.checkHits();
                if (hitReg.guiLabel == true) {
                    button[i].setText("HIT!");
                    button[i].setBackground(Color.GREEN);
                    button[i].setEnabled(false);
                    shipImgChanger s = new shipImgChanger();
                } else {
                    button[i].setText("MISS!");
                    button[i].setBackground(Color.RED);
                    button[i].setEnabled(false);
                }

                if (hitReg.isSunk == true) {
                    for (int k = 0; k < 9; k++) {
                        button[k].setEnabled(false);
                    }
                    JOptionPane.showMessageDialog(null, TextMessages.getWinMessage() + "\n" + TextMessages.getStatsSaved(), "YOU WIN", JOptionPane.INFORMATION_MESSAGE);
                }
                if (hitReg.numOfMisses == hitReg.MAX_MISSES) {
                    for (int k = 0; k < 9; k++) {
                        button[k].setEnabled(false);
                    }
                    JOptionPane.showMessageDialog(null, TextMessages.getLoseMessage() + "\n" +TextMessages.getStatsSaved(), "YOU LOSE", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
        NumberButtonListener[] numberButtonListener = new NumberButtonListener[9];
        for(int n = 0; n<9; n++){
            numberButtonListener[n] = new NumberButtonListener(n);
        }

    }

    void miscButtons() {
        panel2 = new JPanel();
        statsButton = new JButton("Stats");
        restartButton = new JButton("Restart");
        howToPlayButton = new JButton("How To Play");
        statsButton.setCursor(cursor2);
        restartButton.setCursor(cursor2);
        howToPlayButton.setCursor(cursor2);
        statsButton.setBackground(Color.LIGHT_GRAY);
        restartButton.setBackground(Color.LIGHT_GRAY);
        howToPlayButton.setBackground(Color.LIGHT_GRAY);
        statsButton.setToolTipText("Click to see your stats");
        restartButton.setToolTipText("Restart the game");
        howToPlayButton.setToolTipText("Learn how to play the game");

        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 10));
        panel2.add(howToPlayButton);
        panel2.add(statsButton);
        panel2.add(restartButton);
        frame.add(panel2, BorderLayout.NORTH);
        panel2.setBackground(new Color(179, 255, 255));

        howToPlayButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, TextMessages.getHowToPlayText(), "How To Play", JOptionPane.QUESTION_MESSAGE);
        });
        statsButton.addActionListener((ActionEvent e) -> {
            StatsFrame statsFrame = new StatsFrame();
        });
        restartButton.addActionListener((ActionEvent e) -> {
            frame.dispose();
            StartMenu startMenu = new StartMenu();
        });
    }
}
















