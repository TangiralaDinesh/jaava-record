public class StringDemo
{
public static void main(String[]args)
{
    String s="SCSVMV University";
    
    System.out.println("Length      : "+s.length());
    System.out.println("Upper case  : "+s.toUpperCase());
    System.out.println("First six   : "+s.substring(0,6));
    System.out.println("Position of U: "+s.indexOf('U'));
    System.out.println("Replace S->X: "+s.replace('S','X'));
    System.out.println("Original    : "+s);

    String word="madam";
    String reversed=new StringBuilder(word).reverse().toString();
    if(word.equals(reversed))
        System.out.println(word+" is a palindrome");
    else
        System.out.println(word+" is not a palindrome");
   
}


}