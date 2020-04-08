package StringsSecondAssignment;
public class Part2 {
    public int howMany(String stringa, String stringb) {
        int count = 0;
        int startIndex=0;
         while(true)
         {
            if(stringb.indexOf(stringa,startIndex)==-1)
                break;
            else
            {
                count++;
                startIndex=stringb.indexOf(stringa,startIndex)+stringa.length();
            }
         }
        return count;
    }

    public void testHowMany() {
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));
        System.out.println(howMany("A", "ATGAtATAT"));
        System.out.println(howMany("ABCD", "ATABCAAA"));
    }
    public static void main(String args[]) {
        Part2 part2 = new Part2();
        part2.testHowMany();
    }
}

