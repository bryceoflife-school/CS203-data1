import java.util.Random;


public class FiniteSet{
    
    
    public static int randInt( int min, int max ) {
        return new Random().nextInt((max - min) + 1) + min; }
    
    public static BinaryTree randomTree(int nodes){
        if (nodes == 0) {
            return new Leaf();
        } else {
            return new Branch(randInt(0,100), randomTree(nodes - 1), randomTree(nodes - 1));
        }
        
    }
    
    
    public static void unionChecker(int times){
        for(int i = 0; i < times; i++){
            int elt = randInt(0,100);
            int nodes = randInt(0, 10);
            
            
            BinaryTree firstHalf = randomTree(nodes);
            BinaryTree secondHalf = randomTree(nodes);
            
            System.out.println("firstHalf Cardinality: " + firstHalf.cardinality());
            System.out.println("secondHalf Cardinality: " + secondHalf.cardinality());

            
            BinaryTree wholeTree = firstHalf.union(secondHalf);
            System.out.println("WholeTree Cardinality: " + wholeTree.cardinality());
            System.out.println(" ");
        }
    }
    
    
    public static void main (String[] args ){
        System.out.println("The Code Runs");
        
        
        BinaryTree empty = new Leaf();
        
        BinaryTree t1 = new Branch(9,
                                   (new Branch(7, new Leaf(), new Branch(8))),
                                   (new Branch(11, new Leaf(), new Branch(12))));
        
        BinaryTree t2 = new Branch(13, t1, empty);
        
        BinaryTree firstHalf = new Branch(7,
                                          (new Branch(6)),
                                          (new Branch(8)));
        BinaryTree secondHalf = new Branch(9,
                                           new Leaf(),
                                           (new Branch(11)));
        
        BinaryTree interHalfOne = new Branch(9,
                                             new Leaf(),
                                             (new Branch(11)));
        BinaryTree interHalfTwo = new Branch(9,
                                             (new Branch(8)),
                                             (new Branch(11)));
        
        // Tests for Cardinality()
        System.out.println(" ");
        System.out.println("Tests for cardinality()");
        System.out.println("Cardinality of t1 is: " + t1.cardinality() + " expected " + 5);
        System.out.println("Cardinality of t2 is: " + t2.cardinality() + " expected " + 6);
        
        // Tests for isEmptyHuh()
        System.out.println(" ");
        System.out.println("Tests for isEmptyHuh()");
        System.out.println(t1.isEmptyHuh() + " expected " + false);
        System.out.println(empty.isEmptyHuh() + " expected " + true);
        
        // Tests for member()
        System.out.println(" ");
        System.out.println("Tests for member()");
        System.out.println(t1.member(9) + " expected " + true);
        System.out.println(t2.member(9) + " expected " + true);
        System.out.println(empty.member(9) + " expected " + false);
        
        
        // Tests for add()
        System.out.println(" ");
        System.out.println("Tests for add()");
        System.out.println(t1.member(6) + " expected " + false);
        System.out.println("Cardinality of t1 is: " + t1.add(6).cardinality() + " expected " + 6);
        System.out.println(t1.add(6).member(6) + " expected " + true);
        
        // Tests for remove()
        System.out.println(" ");
        System.out.println("Tests for remove()");
        System.out.println(t1.member(11) + " expected " + true);
        System.out.println("Cardinality of t1 is: " + t1.remove(11).cardinality() + " expected " + 4);
        System.out.println(t1.remove(11).member(11) + " expected " + false);
        
        // Tests for union()
        System.out.println(" ");
        System.out.println("Tests for union() of manually generated trees");
        BinaryTree thirdHalf = firstHalf.union(secondHalf);
        System.out.println(thirdHalf.cardinality() + " expected " + 5);
        
        System.out.println(" ");
        System.out.println("Tests for union() of randomly generated trees");
        unionChecker(5);
        
        // Tests for inter()
        System.out.println(" ");
        System.out.println("Tests for inter() of manually generated trees");
        BinaryTree interHalfThree = interHalfOne.inter(interHalfTwo);
        System.out.println(interHalfThree.cardinality() + " expected " + 2);
        System.out.println(interHalfThree.member(9) + " expected " + true);
        System.out.println(interHalfThree.member(11) + " expected " + true);
        System.out.println(interHalfThree.member(8) + " expected " + false);
        
        
        
    }
}