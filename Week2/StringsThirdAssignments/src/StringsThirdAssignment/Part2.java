package StringsThirdAssignment;
public class Part2{
    public float cgRatio(String dna) {
        String s = "C";
        int c=findCount(dna, s);
        s="G";
        int g=findCount(dna,s);
        return (float)(c+g)/dna.length();
    }
    public int findCount(String dna,String s)
    {
        int count=0;
        int index=dna.indexOf(s);
        while(true)
        {
            if(dna.indexOf(s,index)==-1)
                break;
            count++;
            index=dna.indexOf(s,index)+s.length();
        }
        return count;
    }
    public int countCTG(String dna)
    {
        return findCount(dna,"CTG");
    }
    public static void main(String args[])
    {
        Part2 part2=new Part2();
        System.out.println(part2.cgRatio("ATGCCATAG"));
        System.out.println(part2.countCTG("ATGCTGGTACTGTGCTGAT"));

    }
}