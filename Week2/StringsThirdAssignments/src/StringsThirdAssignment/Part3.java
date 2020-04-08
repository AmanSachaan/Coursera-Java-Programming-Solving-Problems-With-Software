package StringsThirdAssignment;
import edu.duke.*;
public class Part3 extends Part2{
    public void processGene(StorageResource sr) {
        int noOfLongerStrings = 0, noOfCgStrings = 0, longestLength = 0;
        System.out.println("Strings with number of chracter greater than 9 in sr are");
        for (String string : sr.data()) {
            //if (string.length() > 9) {
            if (string.length() > 60)
                System.out.println(string);
                noOfLongerStrings++;
            }
        System.out.println("The number of Strings in sr that are longer than 9 characters are " + noOfLongerStrings);
        System.out.println("The Strings in sr whose C-G-ratio is higher than 0.35 are");
        for (String string : sr.data()) {
            float cgRatio = cgRatio(string);
            if (cgRatio > 0.35) {
                System.out.println(string);
                noOfCgStrings++;
            }
            if (string.length() > longestLength)
                longestLength = string.length();
        }
        System.out.println("The number of strings in sr whose C-G-ratio is higher than 0.35 are " + noOfCgStrings);
        System.out.println("The length of the longest gene in sr is " + longestLength);

    }
    public void testProcessGene()
        {
            StorageResource sr=new StorageResource();
           /* sr.add("ATGTATTGTAGATAA");
            sr.add("AAGTTAA");
            sr.add("ACGACG");
            sr.add("ACGTAATAAT");
            sr.add("AGTCGTTAATGTATTAT");
            processGene(sr);
           */
           FileResource fr = new FileResource("/home/aman/IdeaProjects/StringsThirdAssignments/src/StringsThirdAssignment/brca1line.fa");
           String dna = fr.asString();
           sr.add(dna);
           processGene(sr);

        }
    public static void main(String args[])
    {
        Part3 part3=new Part3();
        part3.testProcessGene();
    }
}
