package StringsFirstAssignment;
public class Part1 {
   public String findSimpleGene(String dna)
   {
       String geneSequence="";
       int startIndex=dna.indexOf("ATG");
       if(startIndex==-1)
           return geneSequence;
       int stopIndex=dna.indexOf("TAA",startIndex);
       if(stopIndex==-1)
           return geneSequence;
       if(((stopIndex-startIndex)%3)==0)
           return dna.substring(startIndex,stopIndex+3);
       return geneSequence;
   }
   public void testSimpleGene()
   {
       String dna1="ATAGTGATAAGTAA";
       System.out.println("dna1 : "+dna1);
       System.out.println("gene1 : "+findSimpleGene(dna1));
       String dna2="ATGGTGATAGGTA";
       System.out.println("dna2 : "+dna2);
       System.out.println("gene2 : "+findSimpleGene(dna2));
       String dna3="ATAGTGATAGGTAT";
       System.out.println("dna3 : "+dna3);
       System.out.println("gene3 : "+findSimpleGene(dna3));
       String dna4="ATAATGGTGATAGGTTAATAAAT";
       System.out.println("dna4 : "+dna4);
       System.out.println("gene4: "+findSimpleGene(dna4));
       String dna5="ATAGATGTGATAGGTTAAAT";
       System.out.println("dna5 : "+dna5);
       System.out.println("gene5 : "+findSimpleGene(dna5));
   }
   public static void main(String args[])
   {
       Part1 part1=new Part1();
       part1.testSimpleGene();
   }
}
