
package battleship.gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public final class StatsFrame {
    private JFrame frame;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private ImageIcon battleshipIcon;
    private JButton deleteButton;
    
    public StatsFrame(){
        initComponents();
    }

    void initComponents() {
        frame = new JFrame();
        
        try{
            textAreaText();
        } catch(IOException e1){
            System.out.println("Error. Exception: " + e1);
        }
        
        //deleteStats();
        
        battleshipIcon = new ImageIcon(getClass().getResource("battleship.png"));
        frame.setIconImage(battleshipIcon.getImage());
        
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setTitle("Stats");
        frame.setVisible(true);
    }
    
    void textAreaText() throws IOException{
        textArea = new JTextArea(20, 30);
        scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        frame.add(scrollPane);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Stats.txt")));
        
        textArea.read(reader, "Pls wait....");
    }
    
    void deleteStats(){
        //might add this later
    }
    
}






































































