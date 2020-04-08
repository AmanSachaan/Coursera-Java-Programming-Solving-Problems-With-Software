package BabyNames;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyNames {

    public void totalBirths(FileResource fr) {
        int totalBirths = 0, totalBoys = 0, totalGirls = 0;
        int girlsNames = 0, boysNames = 0, totalNames = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            String name = record.get(0);
            totalBirths = totalBirths + numBorn;
            totalNames = totalNames + 1;
            if (record.get(1).equals("M")) {
                totalBoys = totalBoys + numBorn;
                boysNames = boysNames + 1;
            } else {
                totalGirls = totalGirls + numBorn;
                girlsNames = girlsNames + 1;
            }
        }
        System.out.println("Total Births : " + totalBirths);
        System.out.println("Total Girls : " + totalGirls);
        System.out.println("Total Boys  : " + totalBoys);
        System.out.println("Girls Names:" + girlsNames);
        System.out.println("Boys Names : " + boysNames);
        System.out.println("Total Names : " + (boysNames + girlsNames));
    }


    public int getRank(int year, String name, String gender) {

        FileResource fr = new FileResource("/home/aman/IdeaProjects/BabyNames/src/BabyNames/us_babynames_by_year/yob" + year + ".csv");
        int rank = -1;
        int genderCnt = 0;
        for (CSVRecord rec : fr.getCSVParser(false)
        ) {

            if (rec.get(1).equals(gender)) {
                genderCnt++;
                if (rec.get(0).equals(name) && rec.get(1).equals(gender))
                    rank = genderCnt;
            }
        }

        return rank;
    }


    public String getName(int year, int rank, String gender) {

        String name = "";
        int count = 0;
        FileResource fr = new FileResource("/home/aman/IdeaProjects/BabyNames/src/BabyNames/us_babynames_by_year/yob" + year + ".csv");

        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (gender.equals(rec.get(1))) {
                count++;
                if (rank == count)
                    name = rec.get(0);
            }
        }
        return name;
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {

        int rankOfThatYear = -1;
        String nameOfNewYear = "";
        FileResource fr = new FileResource("/home/aman/IdeaProjects/BabyNames/src/BabyNames/us_babynames_by_year/yob" + year + ".csv");
        rankOfThatYear = getRank(year, name, gender);
        if (rankOfThatYear != -1)
            nameOfNewYear = getName(newYear, rankOfThatYear, gender);
        System.out.println(name + " born in " + year + " would be " + nameOfNewYear + " if she was born in " + newYear);
    }

    public int yearOfHighestRank(String name, String gender) {
        int year = -1, tempYear = 0, highestRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            String filename = file.getName();
            tempYear = Integer.parseInt(filename.substring(3, 7));
            int currentRank = getRank(tempYear, name, gender);
            if ((currentRank != -1) && (highestRank == 0 || currentRank < highestRank)) {
                highestRank = currentRank;
                year = tempYear;
            }
        }
        return year;
    }

    public double getAverageRank(String name, String gender) {
        double average = -1.0;
        int sumOfRank = 0;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            String filename = file.getName();
            int year = Integer.parseInt(filename.substring(3, 7));
            sumOfRank = sumOfRank + getRank(year, name, gender);
            count++;
        }
        return (double) sumOfRank / count;
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int count = 0;
        FileResource fr = new FileResource("/home/aman/IdeaProjects/BabyNames/src/BabyNames/us_babynames_by_year/yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(0).equals(name) && rec.get(1).equals(gender))
                break;
            else if (rec.get(1).equals(gender))
                count = count + Integer.parseInt(rec.get(2));
        }
        return count;
    }

    public static void main(String args[]) {

        System.out.println("Printing Total births");
        BabyNames babyNames = new BabyNames();
        FileResource fr = new FileResource();
        babyNames.totalBirths(fr);

        System.out.println("\nPrinting ranks");
        System.out.println(babyNames.getRank(2012, "Sophia", "F"));
        System.out.println(babyNames.getRank(2012, "Ava", "F"));
        System.out.println(babyNames.getRank(2012, "Noah", "M"));
        System.out.println(babyNames.getRank(2012, "Ethan", "M"));

        System.out.println("\nPrinting names");
        System.out.println(babyNames.getName(2010, 12, "F"));
        System.out.println(babyNames.getName(2010, 1000, "F"));
        System.out.println(babyNames.getName(2010, 10, "M"));
        System.out.println(babyNames.getName(2010, 1, "M"));


        System.out.println("\nPrinting name in that year");
        babyNames.whatIsNameInYear("Isabella", 2012, 2014, "F");
        babyNames.whatIsNameInYear("Noah", 2014, 2012, "M");

        System.out.println("\nPrinting year of highest rank");
        System.out.println(babyNames.yearOfHighestRank("Genevieve", "F"));

        System.out.println("\nPrinting average rank");
        System.out.println(babyNames.getAverageRank("Robert", "M"));

        System.out.println("\nPrinting total births ranked higher");
        System.out.println(babyNames.getTotalBirthsRankedHigher(1990, "Emily", "F"));

    }
}