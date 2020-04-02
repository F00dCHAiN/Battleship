package battleship.gui;

import battleship.text.TextMessages;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public final class StatsFrame {

    private JFrame frame;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private ImageIcon battleshipIcon;
    private JButton deleteButton;

    public StatsFrame() {
        initComponents();
    }

    void initComponents() {
        frame = new JFrame();
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        try {
            textAreaText();
        } catch (IOException e1) {
            textArea.setText("Stats are empty for now.\nStart playing to see your stats here!");
        }

        
        deleteStats();
        

        battleshipIcon = new ImageIcon(getClass().getResource("battleship.png"));
        frame.setIconImage(battleshipIcon.getImage());

        frame.add(deleteButton);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setTitle("Stats");
        frame.setVisible(true);
    }

    void textAreaText() throws IOException, FileNotFoundException {
        textArea = new JTextArea(20, 30);
        scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        frame.add(scrollPane);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Stats.txt")));

        textArea.read(reader, "Pls wait....");
        reader.close();
    }

    void deleteStats() {
        deleteButton = new JButton("Delete");
        deleteButton.setToolTipText("Delete 'Stats.txt' file");

        deleteButton.addActionListener((ActionEvent e) -> {
            File stats = new File("Stats.txt");
            stats.delete();
            JOptionPane.showMessageDialog(null, TextMessages.getFileDeletedMessage(), "File Deleted", JOptionPane.WARNING_MESSAGE);
        });
    }
}






