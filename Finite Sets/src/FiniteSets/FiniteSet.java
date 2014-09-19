package FiniteSets;

import static FiniteSets.Tests.randInt;
import static FiniteSets.Tests.randomTree;
import static FiniteSets.Tests.treeTestaddAndmember;
import static FiniteSets.Tests.treeTestcardinalityAndadd;
import static FiniteSets.Tests.treeTestemptyAndisEmptyHuh;
import static FiniteSets.Tests.treeTestisEmptyHuhAndCardinality;
import static FiniteSets.Tests.treeTestremoveandisEmptyHuh;

public class FiniteSet implements BinaryTree {

    // Define global variables
    int root;
    BinaryTree left;
    BinaryTree right;

    // Constructor that takes root
    public FiniteSet(int root) {
        this.root = root;
        this.left = empty();
        this.right = empty();
    }

    // Constructor that takes root, left and right
    public FiniteSet(int root, BinaryTree left, BinaryTree right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    // (empty) → finite-set
    // Returns a fresh empty set.
    public static BinaryTree empty() {
        return new Leaf();
    }

    // (cardinality t) → integer
    // t : finite-set
    // Returns the number of elements in set t
    public int cardinality() {
        return 1 + this.left.cardinality() + this.right.cardinality();
    }

    // (isEmptyHuh t) → boolean
    // t : finite-set
    // Determines if t is empty
    public boolean isEmptyHuh() {
        return false;
    }

    // (member t elt) → boolean
    // t : finite-set
    // elt : integer
    // Determines if elt is in t
    public boolean member(int elt) {
        if (this.root == elt) {
            return true;
        } else if (this.root > elt) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }

    // (add t elt) → finite-set
    // t : finite-set
    // elt : integer
    // Returns a set containing elt and everything in t
    public BinaryTree add(int elt) {
        FiniteSet newBST = new FiniteSet(this.root, this.left, this.right);
        if (elt < newBST.root) {
            newBST.left = newBST.left.add(elt);
        } else if (elt > newBST.root) {
            newBST.right = newBST.right.add(elt);
        }
        return newBST;
    }

    // (remove t elt) → finite-set
    // t : finite-set
    // elt : integer
    // Returns a set containing everything in t except elt.
    public BinaryTree remove(int elt) {

        if (elt == this.root) {
            return this.left.union(this.right);
        } else if (elt < this.root) {
            return new FiniteSet(this.root, this.left.remove(elt), 
                    this.right.remove(elt));
        } else {
            return new FiniteSet(this.root, this.left.remove(elt), this.right);
        }
    }

    // (union t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything in t and u.
    public BinaryTree union(BinaryTree u) {
        return left.union(right.union(u)).add(root);
    }

    // (inter t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything that is in both t and u.
    public BinaryTree inter(BinaryTree u) {
        FiniteSet newBST = new FiniteSet(this.root, this.left, this.right);

        if (u.member(this.root)) {
            newBST.left.inter(u);
            newBST.right.inter(u);
            return newBST;
        } else {
            return left.inter(u).union(right.inter(u));
        }
    }

    //(diff t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything in u except those that are in t.
    public BinaryTree diff(BinaryTree u) {
        BinaryTree rootless = u.remove(root);
        return (left.union(right)).diff(rootless);
    }

    // (equal t u) → boolean
    // t : finite-set
    // u : finite-set
    //Determines if t and u contain the same elements.
    public boolean equal(BinaryTree u) {
        if (this.subset(u) == u.subset(this)) {
            return true;
        } else {
            return false;
        }
    }

    //(subset t u) → boolean
    // t : finite-set
    // u : finite-set
    // Determines if t is a subset of u.
    public boolean subset(BinaryTree u) {
        if (!u.member(this.root)) {
            return false;

        } else if ((this.left.isEmptyHuh())
                || (this.right.isEmptyHuh())) {
            return true;

        } else {
            return this.right.union(this.left).subset(u);

        }
    }

    public static void main(String[] args) {
        System.out.println("The Code Runs");

        // COME BACK TO LOOK AT THESE **************************************************
        BinaryTree empty = new Leaf();

        BinaryTree t1 = new FiniteSet(9,
                (new FiniteSet(7, new Leaf(), new FiniteSet(8))),
                (new FiniteSet(11, new Leaf(), new FiniteSet(12))));

        BinaryTree t2 = new FiniteSet(13, t1, empty);

        BinaryTree firstHalf = new FiniteSet(7,
                (new FiniteSet(6)),
                (new FiniteSet(8)));
        BinaryTree secondHalf = new FiniteSet(9,
                new Leaf(),
                (new FiniteSet(11)));

        BinaryTree interHalfOne = new FiniteSet(9,
                new Leaf(),
                (new FiniteSet(11)));
        BinaryTree interHalfTwo = new FiniteSet(9,
                (new FiniteSet(8)),
                (new FiniteSet(11)));

        // Tests for randInt()
        System.out.println("Random Number Generation from 0 to 100 chooses: " + randInt(0, 100) + " Real quick.");
        System.out.println("Random Number Generation from 0 to 100 chooses: " + randInt(0, 100) + " Real quick.");
        System.out.println("Random Number Generation from 0 to 100 chooses: " + randInt(0, 100) + " Real quick.");
        System.out.println("Random Number Generation from 0 to 100 chooses: " + randInt(0, 100) + " Real quick.");
        System.out.println("Random Number Generation from 0 to 100 chooses: " + randInt(0, 100) + " Real quick.");

        // Tests for empty() and isEmptyHuh()
        System.out.println();
        System.out.println("Tests for Empty() & IsEmptyHuh?");
        System.out.println();
        for (int i = 0; i < 50; i++) {
            int randomInt = randInt(0, 1);
            treeTestemptyAndisEmptyHuh(randomInt);
        }

        // Tests for isEmptyHuh() and cardinality()
        System.out.println();
        System.out.println("Tests for isEmptyHuh() and cardinality()");
        System.out.println();
        for (int i = 0; i < 50; i++) {
            int randomInt = randInt(0, 10);
            BinaryTree tree = randomTree(randomInt);
            treeTestisEmptyHuhAndCardinality(tree);
        }

        // Tests for cardinality() and add()
        System.out.println();
        System.out.println("Tests for cardinality() and add()");
        System.out.println();
        for (int i = 0; i < 50; i++) {
            int randomInt = randInt(0, 10);
            int randomElt = randInt(0, 100);
            BinaryTree tree = randomTree(randomInt);
            treeTestcardinalityAndadd(tree,randomInt,randomElt);
        }
        
        // Tests for add() and member()
        System.out.println();
        System.out.println("Tests for add() and member()");
        System.out.println();
        for (int i = 0; i < 50; i++) {
            int randomElt = randInt(0, 100);
            BinaryTree tree = empty();
            treeTestaddAndmember(tree,randomElt);
        }
        
         // Tests for remove() and isEmptyHuh()
        System.out.println();
        System.out.println("Tests for remove() and isEmptyHuh()");
        System.out.println();
        for (int i = 0; i < 50; i++) {
            int randomElt = randInt(0, 100);
            BinaryTree tree = empty();
            treeTestremoveandisEmptyHuh(tree,randomElt);
        }
        
        
        /*
        
        
         // Tests for cardinality()
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
         //         unionChecker(5);
        
         // Tests for inter()
         System.out.println(" ");
         System.out.println("Tests for inter() of manually generated trees");
         BinaryTree interHalfThree = interHalfOne.inter(interHalfTwo);
         System.out.println(interHalfThree.cardinality() + " expected " + 2);
         System.out.println(interHalfThree.member(9) + " expected " + true);
         System.out.println(interHalfThree.member(11) + " expected " + true);
         System.out.println(interHalfThree.member(8) + " expected " + false);
         
         // Tests for diff()
         System.out.println(" ");
         System.out.println("Tests for diff() of manually generated trees");
         BinaryTree diffHalfThree = interHalfOne.diff(interHalfTwo);
         System.out.println(diffHalfThree.cardinality() + " expected " + 1);
         System.out.println(diffHalfThree.member(9) + " expected " + false);
         System.out.println(diffHalfThree.member(11) + " expected " + false);
         System.out.println(diffHalfThree.member(8) + " expected " + true);
         
         // Tests for equal()
         System.out.println(" ");
         System.out.println("Tests for equal() of manually generated trees");
         System.out.println(interHalfTwo.equal(interHalfTwo) + " expected " + true);
         System.out.println(firstHalf.equal(secondHalf) + " expected " + false);
         
         // Tests for subset()
         System.out.println(" ");
         System.out.println("Tests for subset() of manually generated trees");
         System.out.println(interHalfTwo.subset(interHalfTwo) + " expected " + true);
         System.out.println(firstHalf.subset(secondHalf) + " expected " + false);
         System.out.println(secondHalf.subset(interHalfTwo) + " expected " + true);
         */
    }
}

// Testing : standard says we should do x y z, reference our own code and show that that happens.
// Convince yourself and other people that your code does what it is supposed to do.
// Property about cardninality? Properties are all about the relationship between multiple methods. for example
// addition is associatitve, that shows you that you can permute it and it is still equal. But that is really saying
// things about addition and equality.  ONLY thing worth talking about are their relationships.
// Create a table of all the methods against eachother. How does empty() relate to remove()
// the cardinaltiy of empty() is zero etc. What empty does against everything is the implementation of the leaf class.
// The column for equals is the implementation of the FiniteSet class. 
