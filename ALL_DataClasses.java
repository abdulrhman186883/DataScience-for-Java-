package Ch_04.Video04_08.Start;

import java.util.Date;

public class ALL_DataClasses {
    public class CarRecord {
        public final Float mpg;
        public final Integer numberOfCylinders;
        public final Float displacement;
        public final Float weight;
        public final Integer year;
        public final Integer origin;

        public CarRecord(Float mpg, Integer numberOfCylinders, Float displacement, Float weight, Integer year, Integer origin) {
            this.mpg = mpg;
            this.numberOfCylinders = numberOfCylinders;
            this.displacement = displacement;
            this.weight = weight;
            this.year = year;
            this.origin = origin;
        }

        @Override
        public String toString() {
            return "CarRecord{" +
                    "mpg=" + mpg +
                    ", numberOfCylinders=" + numberOfCylinders +
                    ", displacement=" + displacement +
                    ", weight=" + weight +
                    ", origin=" + origin +
                    '}';
        }
    }


    public class GroceryRecord {
        public final String memberNumber;
        public final Date date;
        public final String itemDescription;

        public GroceryRecord(String memberNumber, Date date, String itemDescription) {
            this.memberNumber = memberNumber;
            this.date = date;
            this.itemDescription = itemDescription;
        }

        @Override
        public String toString() {
            return "GroceryRecord{" +
                    "memberNumber='" + memberNumber + '\'' +
                    ", date=" + date +
                    ", itemDescription='" + itemDescription + '\'' +
                    '}';
        }
    }



    public class PersonRecord {
        public final Integer age;
        public final String employmentStatus;
        public final String education;

        public PersonRecord(Integer age, String employmentStatus, String education) {
            this.age = age;
            this.employmentStatus = employmentStatus;
            this.education = education;
        }

        @Override
        public String toString() {
            return "PersonRecord{" +
                    "age=" + age +
                    ", employmentStatus='" + employmentStatus + '\'' +
                    ", education='" + education + '\'' +
                    '}';
        }
    }

}
