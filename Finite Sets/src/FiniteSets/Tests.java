package FiniteSets;
import static FiniteSets.FiniteSet.empty;
import java.util.Random;


public class Tests {

    public static int randInt( int min, int max ) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    
    public static BinaryTree randomTree(int count){
        if (count == 0) {
            return empty();
        } else {
            return randomTree(count - 1).add(randInt(0,50));
        }
    }
    
        // Logic: if tree is empty, isEmptyHuh should return true.
        public static void treeTestemptyAndisEmptyHuh(int count) {
        if (count == 0) {
            BinaryTree tree = empty();
            if (tree.isEmptyHuh()) {
                System.out.println("Pass. There is nothing here to see. As it should be.");
            } else {
                System.out.println("Fail. There's something wrong. You're not supposed to be here.");

            }
        } else {
            int nodes = randInt(1,10);
            BinaryTree popTree = randomTree(nodes);
            if (!popTree.isEmptyHuh()){
                System.out.println("Pass. The set is not empty. As it should be.");
            } else {
                System.out.println("Fail. There's something wrong. The set should not be empty.");
            }
        }

    }
        // Logic: a set with a cardinality of 0 should result in isEmptyHuh() returning true.
        public static void treeTestisEmptyHuhAndCardinality(BinaryTree tree){
            if ((tree.isEmptyHuh()) && (tree.cardinality() == 0) ){
                System.out.println("Pass. The Empty set has a cardinality of zero.");
            } else {
                if ((!tree.isEmptyHuh()) && (tree.cardinality() > 0)){
                    System.out.println("Pass. The not-empty set has a cardinality greater than zero.");
                } else {
                    System.out.println("Fail. The cardinality and emptiness of the set do not correspond correctly.");
                }
            }
        }
        
        // Logic: adding a random number of elements to a tree should result
        // in the cardinality being greater by that number of elements.
        public static void treeTestcardinalityAndadd(BinaryTree tree, int count, int elt){
            for (int i = 0; i < count; i++) {
                tree.add(elt);
            }
            int newCard = tree.cardinality();
            if (count == 0){
                if (tree.cardinality() == 0) {
                    System.out.println("Pass. The Empty set has a cardinality of zero.");
                } else {
                    System.out.println("Fail. A non-Empty set has a cardinality of zero.");
                }
            } else if (!(count == 0) && (tree.cardinality() == newCard)){
                System.out.println("Pass. The cardinality has been increased by the number of added elements.");
            } else {
                System.out.println("Fail. The cardinality and number of elements do not match");
            }
        }
        
        // Logic: adding an element to the results in that element being a member of the set.
        // Therefore member should return true.
        public static void treeTestaddAndmember(BinaryTree tree, int elt){
            BinaryTree treeWithMember = tree.add(elt);
           
            if (treeWithMember.member(elt)){
                System.out.println("Pass. The added element is a member of the set");
            } else {
                System.out.println("Fail. The added member is not an element of the set");
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
 
}