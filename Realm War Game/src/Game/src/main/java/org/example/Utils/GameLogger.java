package src.Game.src.main.java.org.example.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GameLogger {
    public static void log(String message)  {
        try(FileWriter writer = new FileWriter("game_logger.txt",true);){
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
            writer.write("["+timeStamp+"]"+message+"\n");
        }
        catch (IOException e){
            System.err.println("Error writing log file"+e.getMessage());
        }
    }
}
