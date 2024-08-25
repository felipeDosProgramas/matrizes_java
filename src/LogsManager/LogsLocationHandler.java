package LogsManager;

import java.io.*;
import java.util.Scanner;

public class LogsLocationHandler {

    public static void writeOnLog(String content, LOG log){
        try(
                var writer = new BufferedWriter(
                        new FileWriter(log.toString())
                )
        ) {
            writer.write(content);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFromLog(LOG log){
        var file = new StringBuilder();
        try(
                var scanner = new Scanner(
                        new File(log.toString())
                )
        ) {
            while (scanner.hasNextLine())
                file.append(scanner.nextLine()).append(System.lineSeparator());
            scanner.close();
            return file.toString();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
