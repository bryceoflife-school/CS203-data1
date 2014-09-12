public class Main{
    public static void main (String[] args ){
        System.out.println("The Code Runs");
        
        
        FiniteSet empty = new Fruit();
        FiniteSet t1 = new Branch(9, empty, empty);
        FiniteSet t2 = new Branch(11, t1, empty);
        FiniteSet t3 = new Branch(7, empty, t2);
        
        // Tests for Cardinality()
        System.out.println("Cardinality of t1 is: " + t1.cardinality() + " expected " + 1);
        System.out.println("Cardinality of t2 is: " + t2.cardinality() + " expected " + 2);
        
        // Tests for isEmptyHuh()
        System.out.println(t1.isEmptyHuh());
        System.out.println(t2.isEmptyHuh());
        
        // Tests for member()
        System.out.println(t1.member(9));
        System.out.println(t2.member(9));
        System.out.println(t3.member(9));
        
        
    }
}