package StringsFirstAssignment;
import edu.duke.URLResource;
public class Part4 {
    public void printUrls() {
        URLResource urlResource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String word : urlResource.words()) {
            printURL(word);
        }
    }
    public void printURL(String s) {

        String sLower= s.toLowerCase();
        int youTubeIndex = sLower.indexOf("youtube.com");
        if (youTubeIndex == -1)
            return;
        int startIndex = sLower.indexOf("\"");
        if (startIndex== -1)
            return;
        int endIndex = sLower.indexOf("\"",youTubeIndex+8);
        if (endIndex== -1)
            return;

        System.out.println(s.substring(startIndex+1,endIndex));
    }
    public static void main(String[] args) {
        Part4 part4 = new Part4();
        part4.printUrls();
    }

}