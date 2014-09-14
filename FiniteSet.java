public class FiniteSet{
    public static void main (String[] args ){
        System.out.println("The Code Runs");
        
    
        BinaryTree empty = new Leaf();
        
        BinaryTree t1 = new Branch(9,
                                   (new Branch(7, new Leaf(), new Branch(8))),
                                   (new Branch(11, new Leaf(), new Branch(12))));
        
        
        
        
        BinaryTree t2 = new Branch(13, t1, empty);
        
        // Tests for Cardinality()
        System.out.println("Cardinality of t1 is: " + t1.cardinality() + " expected " + 5);
        System.out.println("Cardinality of t2 is: " + t2.cardinality() + " expected " + 6);
        
        // Tests for isEmptyHuh()
        System.out.println(t1.isEmptyHuh() + " expected " + false);
        System.out.println(empty.isEmptyHuh() + " expected " + true);
        
        // Tests for member()
        System.out.println(t1.member(9) + " expected " + true);
        System.out.println(t2.member(9) + " expected " + true);
        System.out.println(empty.member(9) + " expected " + false);
        
        
        // Tests for add()
        System.out.println(t1.member(6) + " expected " + false);
        System.out.println("Cardinality of t1 is: " + t1.add(6).cardinality() + " expected " + 6);
        System.out.println(t1.member(6) + " expected " + true);
     
        
           }
}