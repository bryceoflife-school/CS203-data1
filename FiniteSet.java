import java.util.Random;


public class FiniteSet{
    
    
    public static int randInt( int min, int max ) {
        return new Random().nextInt((max - min) + 1) + min; }
    
    public static void unionChecker(int times){
        for(int i = 0; i < times; i++){
            
            BinaryTree firstHalf = new Leaf();
            BinaryTree secondHalf = new Leaf();
            
            for(int j = 0; j < 30; j++){
                firstHalf.add(randInt(0,100));
                
                
            }
            
            for(int j = 0; j < 30; j++){
                secondHalf.add(randInt(0,100));
            }
            
            BinaryTree wholeTree;
            wholeTree = firstHalf.union(secondHalf);
            /*
            for(int j = 0; j < 100; j++){
                if((firstHalf.member(j)!= wholeTree.member(i))||
                   (secondHalf.member(i)!= wholeTree.member(i))){
                    System.out.println("HALP");
                }
             }
             */
//            System.out.println(firstHalf.cardinality());
//            System.out.println(secondHalf.cardinality());
            if (wholeTree == null){
            System.out.println("WTF NULL");
            }
            
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
        System.out.println(t1.add(6).member(6) + " expected " + true);
        
        
//        System.out.println(new Random().nextInt(100));
//        System.out.println(randInt(0,10));
        
        BinaryTree thirdHalf = firstHalf.union(secondHalf);
        System.out.println(thirdHalf.cardinality());
        
        
        // Tests for union()
        unionChecker(5);
        
        
        
        
        
    }
}