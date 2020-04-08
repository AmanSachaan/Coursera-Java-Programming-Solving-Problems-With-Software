package StringsFirstAssignment;
public class Part3 {
   public boolean twoOccurances(String stringa,String stringb)
   {
      int noOfOcuurance=0;
      int index1=stringb.indexOf(stringa);
      if (index1==-1)
          return false;
      else
      {
         noOfOcuurance++;
         int index2=stringb.indexOf(stringa,index1+stringa.length());
         if(index2==-1)
             return false;
      }
      noOfOcuurance++;
      return true;
   }
    public String lastPart(String stringa,String stringb)
    {
        int index=stringb.indexOf(stringa);
        if (index==-1)
            return stringb;
        else
            return stringb.substring(index+stringa.length());
    }
   public void testing()
   {
       String stringa="by";
       String stringb="a story by abby long";
       System.out.println("stringa : "+stringa+" "+"stringb : "+stringb+"  "+twoOccurances(stringa,stringb));
       stringa="aa";
       stringb="abcdef";
       System.out.println("stringa : "+stringa+" "+"stringb : "+stringb+"  "+twoOccurances(stringa,stringb));
       stringa="aa";
       stringb="aaaaaaaa";
       System.out.println("stringa : "+stringa+" "+"stringb : "+stringb+"  "+twoOccurances(stringa,stringb));
       stringa="is";
       stringb="ab is a good boy";
       System.out.println("stringa : "+stringa+" "+"stringb : "+stringb+"  "+twoOccurances(stringa,stringb));

       stringa="an";
       stringb="banana";
       System.out.println("The part of the string after "+stringa+" in "+stringb+" is "+lastPart(stringa,stringb));
       stringa="zoo";
       stringb="forest";
       System.out.println("The part of the string after "+stringa+" in "+stringb+" is "+lastPart(stringa,stringb));
       stringa="good boy";
       stringb="He is a good boy";
       System.out.println("The part of the string after "+stringa+" in "+stringb+" is "+lastPart(stringa,stringb));
       stringa="This is awesome";
       stringb="This is really awesome";
       System.out.println("The part of the string after "+stringa+" in "+stringb+" is "+lastPart(stringa,stringb));
   }

   public static void main(String[] args) {
       Part3 part3 = new Part3();
       part3.testing();
   }
}
