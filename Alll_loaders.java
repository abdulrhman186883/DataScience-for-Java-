package Ch_04.Video04_08.Start;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Alll_loaders {

// this to load files
    List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while((line = reader.readLine()) != null) {
            lines.add(line);
        }
    } catch (Exception e) {
        System.out.println("Exception: " + e.getMessage());
    }

                return lines;




    // this to load CSV by using APAche library
    public static List<CSVRecord> parseCSV(String filename) {
        List<CSVRecord> records = new ArrayList<>();
        try {
            Reader reader = new FileReader(filename);
            Iterable<CSVRecord> recordsIterable = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : recordsIterable) {
                records.add(record);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return records;
    }

}


