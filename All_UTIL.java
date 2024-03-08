package Ch_04.Video04_08.Start;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class All_UTIL {
// when the data is seperated with Blank space \\s+
    public static CarRecord parseCar(String dataString) {
        List<String> fields = new ArrayList<>(Arrays.asList(dataString.split("\\s+")));
        try {
            Float mpg = Float.parseFloat(fields.get(0).trim());
            Integer numberOfCylinders = Integer.parseInt(fields.get(1).trim());
            Float displacement = Float.parseFloat(fields.get(2).trim());
            Float weight = Float.parseFloat(fields.get(4).trim());
            Integer year = Integer.parseInt(fields.get(6).trim());
            Integer origin = Integer.parseInt(fields.get(7).trim());

            return new CarRecord(mpg, numberOfCylinders, displacement, weight, year, origin);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    // when the data is seperated with ,
    public static PersonRecord parsePerson(String dataString) {
        List<String> fields = new ArrayList<>(Arrays.asList(dataString.split(",")));

        try {
            Integer age = Integer.parseInt(fields.get(0));
            String employmentStatus = fields.get(1).trim();
            String education = fields.get(3).trim();

            return new PersonRecord(age, employmentStatus, education);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }


    // when the data is CSV
    public static GroceryRecord parseGroceryRecord(CSVRecord record) {
        try {
            String memberNumber = record.get("Member_number");
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(record.get("Date"));
            String itemDescription = record.get("itemDescription");

            return new GroceryRecord(memberNumber, date, itemDescription);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
}
