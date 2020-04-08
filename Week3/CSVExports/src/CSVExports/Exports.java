package CSVExports;
import edu.duke.*;
import org.apache.commons.csv.*;
public class Exports {
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Printing CountryInfo");
        System.out.println(countryInfo(parser, "Germany"));
        System.out.println(countryInfo(parser, "India"));


        parser = fr.getCSVParser();
        System.out.println("Printing Countries which exports the two given products");
        listExportersTwoProducts(parser, "gold", "diamonds");

        parser = fr.getCSVParser();
        System.out.println("Printing number of exporters of a given product");
        System.out.println(numberOfExporters(parser, "gold"));

        parser = fr.getCSVParser();
        System.out.println("Printing BigExporters");
        bigExporters(parser, "$999,999,999");
    }

    public String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record: parser)
        {
            if(record.get("Country").equals(country))
                return record.get("Country")+": "+record.get("Exports")+": "+record.get("Value (dollars)");
        }
        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord record : parser) {
            if(record.get("Exports").contains(exportItem1)&&record.get("Exports").contains(exportItem1))
                System.out.println(record.get("Country"));
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for(CSVRecord record : parser) {
           if(record.get("Exports").contains(exportItem))
               count++;
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record : parser) {
            if(record.get("Value (dollars)").length() > amount.length()) {
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }

        }
    }
    public static void main(String args[])
    {
        Exports exports=new Exports();
        exports.tester();
    }
}
