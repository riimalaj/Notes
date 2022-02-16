import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalTime;

import javax.sound.sampled.SourceDataLine;

import static java.util.Locale.ROOT;

//-Dfile.encoding=UTF8 <Your class Name>
public class Pointit {

    public static void main(String[] args) throws IOException {
        int count = 0;
        String pathDir = "C:\\hakemisto";
        LocalTime lT = LocalTime.now();
        Scanner scan = new Scanner(System.in);

        File testDir = new File(pathDir);
        if (!testDir.exists()) {
            testDir.mkdir();
        }
        System.out.println("Anna filename (vain nimi): ");
        String fileName = scan.nextLine();
        FileWriter fw = new FileWriter(pathDir +"\\"+ fileName + ".log", true);
        BufferedWriter bw = new BufferedWriter(fw);
        ArrayList<String> points = new ArrayList<>();

        bw.write( lT.toString() + " notes:");
        bw.newLine();
        bw.newLine();

        System.out.println("Anna line :\n");
        while (scan.hasNextLine()) {            
            String input = scan.nextLine();            
            if (input.equals("x")){
                System.out.println("x - klikattu");
                break;
            }
            points.add(input);
        }

        for (String point : points) {
            count++;
            final String s = Character.toUpperCase(point.charAt(0)) + point.substring(1);
            System.out.println(s);
            String rest = point.substring(1, point.length()-1);
            String newString = s + rest;
            System.out.println(count + ", " + newString);
            bw.write("- " + newString);
            bw.newLine();
        }
        bw.close();

    }

}