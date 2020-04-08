package CSVExports;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Weather {

   public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestHour=null;
        for(CSVRecord currRecord:parser)
        {
            if(coldestHour==null)
                coldestHour=currRecord;
            else
            {
                if(Double.parseDouble(currRecord.get("TemperatureF"))<Double.parseDouble(coldestHour.get("TemperatureF")))
                    coldestHour=currRecord;
            }
        }
        return coldestHour;
    }

    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVRecord coldestHour = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest Temperature was: " + coldestHour.get("TemperatureF") + " at " + coldestHour.get("TimeEST"));
    }

    public String fileWithColdestTemperature() {
        CSVRecord coldestHour=null;
        String fileWithColdestTemperature=null;
        DirectoryResource dr = new DirectoryResource();
        for(File file: dr.selectedFiles())
        {
            FileResource fr=new FileResource(file);
            CSVParser currParser=fr.getCSVParser();
            CSVRecord currRecord=coldestHourInFile(currParser);
            if(coldestHour==null) {
                coldestHour = currRecord;
                fileWithColdestTemperature=file.getName();
            }
            else
            {
                if(Double.parseDouble(currRecord.get("TemperatureF"))<Double.parseDouble(coldestHour.get("TemperatureF"))) {
                    coldestHour = currRecord;
                    fileWithColdestTemperature = file.getName();
                }
            }
        }
        return fileWithColdestTemperature;
    }


    public void testFileWithColdestTemperature() {
        String fileWithColdestTemperature = fileWithColdestTemperature();
        System.out.println("Coldest day was in file : " + fileWithColdestTemperature);
        FileResource fr = new FileResource("/home/aman/IdeaProjects/CSVExports/src/nc_weather/2014/"+fileWithColdestTemperature);
        CSVParser parser=fr.getCSVParser();
        CSVRecord coldestTemperature= coldestHourInFile(parser);
        System.out.println("Coldest temperature on that day was " + coldestTemperature.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were: ");
        parser=fr.getCSVParser();
        for(CSVRecord record : parser) {
            System.out.println(record.get("DateUTC")+ " " +record.get("TemperatureF") );
        }
    }


    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidity= null;
        for(CSVRecord currRecord : parser) {
            if(lowestHumidity == null) {
                lowestHumidity = currRecord;
            }
            else {
                String currHuminity = currRecord.get("Humidity");
                String lowHuminity = lowestHumidity.get("Humidity");
                if(!currHuminity.equals("N/A") && !lowHuminity.equals("N/A")) {

                    if(Double.parseDouble(currHuminity) < Double.parseDouble(lowHuminity) ){
                        lowestHumidity= currRecord;
                    }
                }
            }
        }
        return lowestHumidity;
    }


    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord lowestHumidity= null;
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            CSVParser parser=fileResource.getCSVParser();
            CSVRecord currRecord = lowestHumidityInFile(parser);
            if(lowestHumidity == null) {
                lowestHumidity = currRecord;
            }
            else {
                String currHuminity = currRecord.get("Humidity");
                String lowHuminity = lowestHumidity.get("Humidity");
                if(!currHuminity.equals("N/A") && !lowHuminity.equals("N/A")) {

                    if(Double.parseDouble(currHuminity) < Double.parseDouble(lowHuminity) ){
                        lowestHumidity= currRecord;
                    }
                }
            }
        }
        return lowestHumidity;
    }

    public void testLowestHumidityInManyFiles() {
        CSVRecord lowestHumidity = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumidity.get("Humidity") + " at " + lowestHumidity.get("DateUTC"));
    }

    public double averageTemperatureInFile(CSVParser parser) {
        double sum = 0.0,count=0.0,average = 0.0;
        for(CSVRecord record: parser) {
            sum = sum + Double.parseDouble(record.get("TemperatureF"));
            count++;
        }
        average = sum / count;
        return average;
    }

    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average temperature in file is " + averageTemperatureInFile(parser));
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double sum = 0.0,count=0.0,average = 0.0;
        for(CSVRecord record: parser) {
            if(!record.get("Humidity").equals("N/A")) {
                if(Double.parseDouble(record.get("Humidity")) > value) {
                    sum = sum + Double.parseDouble(record.get("TemperatureF"));
                    count++;
                }
            }
        }
        average=sum/count;
        return average;
    }

    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int value = 80;
        double averageTemperature = averageTemperatureWithHighHumidityInFile(parser, 80);
        if(averageTemperature >0.0) {
            System.out.println("Average Temp when high Humidity is " + averageTemperature);

        } else {
            System.out.println("No temperatures with that humidity");
        }
    }
    public static void main(String args[])
    {
        Weather weather=new Weather();
        System.out.println("Testing coldest hour in a file");
        weather.testColdestHourInFile();
        System.out.println("\nTesting file with coldest temperature");
        weather.testFileWithColdestTemperature();
        System.out.println("\nTesting lowest humidity in a file");
        weather.testLowestHumidityInFile();
        System.out.println("\nTesting lowest humidity in many file");
        weather.testLowestHumidityInManyFiles();
        System.out.println("\nTesting average temperature in a file");
        weather.testAverageTemperatureInFile();
        System.out.println("\nTesting average temperature with high humidity in a file");
        weather.testAverageTemperatureWithHighHumidityInFile();




    }
}