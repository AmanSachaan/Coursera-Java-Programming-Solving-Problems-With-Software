package StringsSecondAssignment;
public class Part3{
    public int findStopCodon(String dna, int startIndex,String stopCodon)
    {
        int stopIndex=dna.indexOf(stopCodon,startIndex+3);
        while(stopIndex!=-1)
        {
            if (((stopIndex - startIndex) % 3) == 0)
                return stopIndex;
            else
                stopIndex=dna.indexOf(stopCodon,stopIndex+1);
        }
        return dna.length();
    }
    public void testFindStopCodon()
    {
        System.out.println(findStopCodon("ATGTAGGTATAA",0,"TAA"));
        System.out.println(findStopCodon("ATGTAGGTATAA",0,"TAG"));
        System.out.println(findStopCodon("TAGTGAATGTAGGTATAA",6,"TGA"));
        System.out.println(findStopCodon("TAAATGTAGGTATAATGATAA",3,"TAA"));
        System.out.println(findStopCodon("TAGATGTATGTATAA",3,"TAG"));
        System.out.println(findStopCodon("AGATGTAGGTATAA",2,"TGA"));
    }
    public String findGene(String dna,int where)
    {
        String gene="";
        int startIndex=dna.indexOf("ATG",where);
        if(startIndex==-1)
            return gene;
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");

        int stopIndex=Math.min(taaIndex,Math.min(tagIndex,tgaIndex));
        if(stopIndex==dna.length())
            return gene;
        return dna.substring(startIndex,stopIndex+3);

    }
    public void testFindGene()
    {
        String dna1="ATAGTGATAAGTAA";
        System.out.println("dna1 : "+dna1);
        System.out.println("gene1 : "+findGene(dna1,0));
        String dna2="ATGGTGATAGGTTAA";
        System.out.println("dna2 : "+dna2);
        System.out.println("gene2 : "+findGene(dna2,0));
        String dna3="ATATGTGTAAATAGGTAT";
        System.out.println("dna3 : "+dna3);
        System.out.println("gene3 : "+findGene(dna3,0));
        String dna4="ATAATGGTGATAGGTTAATAAAT";
        System.out.println("dna4 : "+dna4);
        System.out.println("gene4: "+findGene(dna4,0));
        String dna5="ATAGATGGTAATATGGTTATAT";
        System.out.println("dna5 : "+dna5);
        System.out.println("gene5 : "+findGene(dna5,0));
    }

    public void printAllGenes(String dna) {
        int startIndex = 0;
        while(true) {
            String gene = findGene(dna, startIndex);
            if(gene.isEmpty()) {
                break;
            }
            System.out.println(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
    }
    public int countGenes(String dna) {
        int count=0;
        int startIndex = 0;
        while(true) {
            String gene = findGene(dna, startIndex);
            if(gene.isEmpty()) {
                break;
            }
            count++;
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return count;
    }
    public void testCountGenes()
    {
        String dna="ATATGTGTAAATAGGTATATAATGGTGATAGGTTAATAAAT";
        System.out.println(countGenes(dna));
        dna="ATGTAATAATAAAGTAAATGGTGTGTTTAAGGTAAATGAAATAAAAAAT";
        System.out.println(countGenes(dna));
        dna="TAAGTATAAGAGAGAT";
        System.out.println(countGenes(dna));

    }
    public static void main(String args[])
    {
        Part3 part3=new Part3();
        System.out.println("Testing Stop Codon");
        part3.testFindStopCodon();
        System.out.println("Testing findGene");
        part3.testFindGene();
        System.out.println("Printing all genes in a String");
        part3.printAllGenes("ATATGTGTAAATAGGTATATAATGGTGATAGGTTAATAAAT");
        System.out.println("Printing countGenes");
        part3.testCountGenes();
    }
}
