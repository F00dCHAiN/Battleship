
package battleship.gui;

import battleship.text.TextMessages;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


public final class StartMenu {
    private JFrame frame;
    private JButton startButton, exitButton, aboutButton;
    private Font fontStartMenu, fontStartMenuHeader;
    private ImageIcon battleshipIcon, battleshipHeaderIcon;
    private JLabel header, headerImg, gitLabel;
    private JTextField gitTextField;
    private Cursor startMenuCursor;
    private Cursor textCursor;
    private static String playerName;
    private Border buttonBorder;
    private Border raisedBevelBorder;
    private Border loweredBevelBorder;
    private Border frameBorder;
    
    public StartMenu(){
        System.out.println("Program starting...");
        System.out.println("---------------------");
        System.out.println("\tLog");
        System.out.println("---------------------");
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame();
        
        startButton = new JButton("Start");
        exitButton = new JButton("Exit");
        aboutButton = new JButton("About");
        
        fontStartMenu = new Font("Elephant", Font.BOLD, 20);
        fontStartMenuHeader = new Font("Algerian", Font.BOLD, 60);
        
        startButton.setFont(fontStartMenu);
        exitButton.setFont(fontStartMenu);
        aboutButton.setFont(fontStartMenu);
        
        startButton.setBackground(Color.LIGHT_GRAY);
        exitButton.setBackground(Color.LIGHT_GRAY);
        aboutButton.setBackground(Color.LIGHT_GRAY);
        
        startMenuCursor = new Cursor(Cursor.HAND_CURSOR);
        
        startButton.setCursor(startMenuCursor);
        exitButton.setCursor(startMenuCursor);
        aboutButton.setCursor(startMenuCursor);
        
        raisedBevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        loweredBevelBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        buttonBorder = BorderFactory.createCompoundBorder(raisedBevelBorder, loweredBevelBorder);
        
        startButton.setBorder(buttonBorder);
        exitButton.setBorder(buttonBorder);
        aboutButton.setBorder(buttonBorder);
        
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start button");
                try{
                    setPlayerName();
                    System.out.println("Player Name: " + playerName);
                }
                catch(NullPointerException e1){
                    System.out.println("Cancel button");
                }
            }
        });
        
        exitButton.addActionListener((ActionEvent e) -> {
            System.out.println("Exit button");
            int choice = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(choice == JOptionPane.YES_OPTION){
                System.out.println("Bye bye!");
                System.exit(0);
            }
        });
        
        aboutButton.addActionListener((ActionEvent e) -> {
            System.out.println("About button");
            JOptionPane.showMessageDialog(null, TextMessages.getCredits(), "About", JOptionPane.INFORMATION_MESSAGE);
        });
        
        startButton.setBounds(190, 225, 100, 50);
        exitButton.setBounds(190, 280, 100, 50);
        aboutButton.setBounds(190, 335, 100, 50);
        frame.add(startButton);
        frame.add(exitButton);
        frame.add(aboutButton);
        
        gitLabel = new JLabel("GitHub Link:");
        frame.add(gitLabel);
        gitLabel.setBounds(70, 420, 100, 30);
        
        header = new JLabel("BATTLESHIP");
        frame.add(header);
        header.setBounds(60, 85, 450, 150);
        header.setFont(fontStartMenuHeader);
        
        battleshipHeaderIcon = new ImageIcon(getClass().getResource("battleshipHeader.png"));
        headerImg = new JLabel(battleshipHeaderIcon);
        frame.add(headerImg);
        headerImg.setBounds(1, 20, 450, 100);
        
        battleshipIcon = new ImageIcon(getClass().getResource("battleship.png"));
        frame.setIconImage(battleshipIcon.getImage());
        
        gitTextField = new JTextField(TextMessages.getGitLink());
        gitTextField.setEditable(false);
        frame.add(gitTextField);
        gitTextField.setBounds(150, 420, 250, 30);
        textCursor = new Cursor(Cursor.TEXT_CURSOR);
        gitTextField.setCursor(textCursor);
        
        frameBorder = BorderFactory.createLineBorder(Color.WHITE, 5);
        
        frame.getRootPane().setBorder(frameBorder);
        frame.getContentPane().setBackground(new Color(66, 180, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Battleship");
        frame.setVisible(true);
    }
    
    void setPlayerName() throws NullPointerException{
        StartMenu.playerName = JOptionPane.showInputDialog(null,"Enter your name: ", "Player");
        if(playerName.isBlank()){
            StartMenu.playerName = "[No Player Name]";
        }
        if(playerName != null){ //if user does not press cancel button
            frame.dispose();
            new MainFrame();
        }
    }
    
    public static String getPlayerName(){
        return playerName;
    }
}







































































































































































































