package battleship.logic;

import battleship.gui.StartMenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public final class Stats {

    File stats;
    Formatter write;
    FileWriter fileWriter;
    Scanner read;
    int hitStats, missStats;
    
    public Stats(int hitStats, int missStats){
        this.hitStats = hitStats;
        this.missStats = missStats;
        initIO();
    }

    void initIO() {
        stats = new File("Stats.txt");
        createStatsFile();
        writeStatsFile();
        //readStatsFile();
    }
    
    void createStatsFile(){
        if (!stats.exists()) {
            try {
                stats.createNewFile();
                System.out.println("New Stats.txt file created.");
            } catch (Exception e1) {
                System.out.println("Unable to create Stats.txt file. Exception: " + e1);
            }
        }else{
            System.out.println("Stats.txt file already exists.");
        }
    }
    
    void writeStatsFile(){
        try{
            fileWriter = new FileWriter("Stats.txt", true);
            write = new Formatter(fileWriter);
            write.format("Name: %s | Hits: %d | Misses: %d\r\n", StartMenu.getPlayerName(), hitStats, missStats);
            System.out.println("Stats written into 'Stats.txt' successfully.");
        }catch(FileNotFoundException e2){
            System.out.println("Unable to write to file. Exception: " + e2);
        }catch(IOException e2){
            System.out.println("Unable to write to file. Exception: " + e2);
        }
        finally{
            write.close();
        }
    }
    
    void readStatsFile(){
        String line = "";
        try{
            read = new Scanner(stats);
            while(read.hasNext()){
                line = line + read.nextLine();
                
                System.out.println(line);
            }
        }catch(FileNotFoundException e3){
            System.out.println("Unable to read from the file. Exception: " + e3);
        }
        finally{
            read.close();
        }
    }
}







































