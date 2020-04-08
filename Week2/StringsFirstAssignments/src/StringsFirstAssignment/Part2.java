package StringsFirstAssignment;
public class Part2 {
    public String findSimpleGene(String dna,String startCodon,String stopCodon)
    {
        String geneSequence="";
        String dnaOriginal=dna;
        dna=dna.toUpperCase();
        int startIndex=dna.indexOf(startCodon);
        if(startIndex==-1)
            return geneSequence;
        int stopIndex=dna.indexOf(stopCodon,startIndex);
        if(stopIndex==-1)
            return geneSequence;
        if(((stopIndex-startIndex)%3)==0)
            return dnaOriginal.substring(startIndex,stopIndex+3);
        return geneSequence;
    }
    public void testSimpleGene()
    {
        String startCodon="ATG";
        String stopCodon="TAA";
        String dna1="ATAGTGATAAGTAA";
        System.out.println("dna1 : "+dna1);
        System.out.println("gene1 : "+findSimpleGene(dna1,startCodon,stopCodon));
        String dna2="ATGGTGATAGGTA";
        System.out.println("dna2 : "+dna2);
        System.out.println("gene2 : "+findSimpleGene(dna2,startCodon,stopCodon));
        String dna3="ATAGTGATAGGTAT";
        System.out.println("dna3 : "+dna3);
        System.out.println("gene3 : "+findSimpleGene(dna3,startCodon,stopCodon));
        String dna4="ataatggtgataggttaataaat";
        System.out.println("dna4 : "+dna4);
        System.out.println("gen: "+findSimpleGene(dna4,startCodon,stopCodon));
        String dna5="ATAGATGTGATAGGTTAAAT";
        System.out.println("dna5 : "+dna5);
        System.out.println("gene5 : "+findSimpleGene(dna5,startCodon,stopCodon));
    }
    public static void main(String args[])
    {
        Part2 part2=new Part2();
        part2.testSimpleGene();
    }
}
