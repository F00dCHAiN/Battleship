
package Battleship.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.*;

public class StatsFrame {
    private JFrame frame;
    private JTextArea textArea;
    private JScrollPane scrollPane;
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
        
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
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
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                    File file = new File("Stats.txt");
                    file.createNewFile();
                    //file.deleteOnExit();
                    JOptionPane.showMessageDialog(null, "File successfully deleted", "Stats", JOptionPane.INFORMATION_MESSAGE);
                } catch(Exception exception){
                    JOptionPane.showMessageDialog(null, exception, "Stats", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        frame.add(deleteButton);
    }
    
}































































