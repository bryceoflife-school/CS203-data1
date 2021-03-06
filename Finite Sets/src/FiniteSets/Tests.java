package FiniteSets;

import static FiniteSets.FiniteSet.empty;
import java.util.Random;

public class Tests {

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static BinaryTree randomTree(int count) {
        if (count == 0) {
            return empty();
        } else {
            return randomTree(count - 1).add(randInt(0, 50));
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
            int nodes = randInt(1, 10);
            BinaryTree popTree = randomTree(nodes);
            if (!popTree.isEmptyHuh()) {
                System.out.println("Pass. The set is not empty. As it should be.");
            } else {
                System.out.println("Fail. There's something wrong. The set should not be empty.");
            }
        }

    }

    // Logic: a set with a cardinality of 0 should result in isEmptyHuh() returning true.
    public static void treeTestisEmptyHuhAndCardinality(BinaryTree tree) {
        if ((tree.isEmptyHuh()) && (tree.cardinality() == 0)) {
            System.out.println("Pass. The Empty set has a cardinality of zero.");
        } else {
            if ((!tree.isEmptyHuh()) && (tree.cardinality() > 0)) {
                System.out.println("Pass. The not-empty set has a cardinality greater than zero.");
            } else {
                System.out.println("Fail. The cardinality and emptiness of the set do not correspond correctly.");
            }
        }
    }

    // Logic: adding a random number of elements to a tree should result
    // in the cardinality being greater by that number of elements.
    public static void treeTestcardinalityAndadd(BinaryTree tree, int count, int elt) {
        for (int i = 0; i < count; i++) {
            tree.add(elt);
        }
        int newCard = tree.cardinality();
        if (count == 0) {
            if (tree.cardinality() == 0) {
                System.out.println("Pass. The Empty set has a cardinality of zero.");
            } else {
                System.out.println("Fail. A non-Empty set has a cardinality of zero.");
            }
        } else if (!(count == 0) && (tree.cardinality() == newCard)) {
            System.out.println("Pass. The cardinality has been increased by the number of added elements.");
        } else {
            System.out.println("Fail. The cardinality and number of elements do not match");
        }
    }

    // Logic: adding an element to the results in that element being a member of the set.
    // Therefore member should return true.
    public static void treeTestaddAndmember(BinaryTree tree, int elt) {
        BinaryTree treeWithMember = tree.add(elt);

        if (treeWithMember.member(elt)) {
            System.out.println("Pass. The added element is a member of the set");
        } else {
            System.out.println("Fail. The added member is not an element of the set");
        }
    }

    // Logic: adding and removing an element should result in the set remaining empty
    // Therefore isEmptyHuh should return true
    public static void treeTestremoveandisEmptyHuh(BinaryTree tree, int elt) {
        BinaryTree treeWithMember = tree.add(elt);
        Boolean checkOne = treeWithMember.isEmptyHuh();
        BinaryTree treeWithoutMember = tree.remove(elt);
        Boolean checkTwo = treeWithoutMember.isEmptyHuh();
        if (!checkOne && !checkTwo) {
            System.out.println("Fail. The element was not removed");
        } else if (checkOne && checkTwo) {
            System.out.println("Fail. The element was not added");
        } else if (!checkOne && checkTwo) {
            System.out.println("Pass. The element was added and removed resulting in an empty set");
        } else {
            System.out.println("Fail. The element was added but not removed ");
        }

    }
    // Logic: two empty trees with the same elements added to them should be equal
    // Therefore equal() should return true

    public static void treeTestaddAndequal(BinaryTree tree1, BinaryTree tree2, int elt) {
        BinaryTree addedTree = tree1.add(elt);
        BinaryTree addedTree2 = tree2.add(elt);
        if (addedTree.equal(addedTree2)) {
            System.out.println("Pass. The two sets are equal");
        } else {
            System.out.println("Fail. The two sets are not equal");
        }
    }

    // Logic: Both sets should be subsets of the union of set one and two
    public static void treeTestunionAndSubset(BinaryTree tree1, BinaryTree tree2) {
        if ((tree1.subset(tree1.union(tree2))) && (tree2.subset(tree1.union(tree2)))) {
            System.out.println("Pass. Both sets are subsets of the union of both sets");
        } else {
            System.out.println("Fail. The sets are not subsets of their union. Dumb union laws");
        }
    }

    // Logic: If two sets are equal, then the cardinality of their intersecition will be the same as
    // The cardinality of each set.
    public static void treeTestinterAndequalAndunion(BinaryTree tree1, BinaryTree tree2) {
        if ((tree1.union(tree2).equal(tree1.inter(tree2))) && tree1.equal(tree2)) {
            System.out.println("Pass. Sets equal with same intersection and union");
        } else if (!(tree1.union(tree2).equal(tree1.inter(tree2))) && !tree1.equal(tree2)) {
            System.out.println("Pass. Sets not equal with different intersection and union");
        } else {
            System.out.println("Fail. Sets equal with different intersection and union");
        }
    }

    // Logic: the difference of two equal sets should be empty
    public static void treeTestdiffAndisEmptyHuh(BinaryTree tree1, BinaryTree tree2) {
        if ((tree1.diff(tree2).isEmptyHuh()) && tree1.equal(tree2)) {
            System.out.println("Pass. Set difference of equal sets is the empty set");
        } else if (!(tree1.diff(tree2).isEmptyHuh()) && !tree1.equal(tree2)) {
            System.out.println("Pass. Set difference of non-equal sets is not the empty set");
        } else {
//            System.out.println(tree1.cardinality());
//            System.out.println(tree2.cardinality());
            System.out.println("Fail. Sets differnce of equal sets is not the empty set");
        }
    }

    // Logic: The cardinality of subset of set t should be smaler than the
    // cardinality of set t
    public static void treeTestsubsetAndcardinality(BinaryTree t, BinaryTree u) {
        if (t.subset(u)) {
            if (t.cardinality() <= u.cardinality()) {
                System.out.println("Pass. t is a subset of u and t's cardinality is smaller than or equal to u's.");
            } else {
                System.out.println("Fail. t is a subset of u but t's cardinality is not smaller than or equal to u's");
            }
        } else {
            if (t.cardinality() >= u.cardinality()) {
                System.out.println("Pass. t is not a subset of u and t's cardinality is not smaller than or equal to u's.");
            }
        }
    }

    // Logic: | t U u | <= | t | + | u |
    public static void treeTestunionAndcardinality(BinaryTree t, BinaryTree u) {
        if (t.union(u).cardinality() <= t.cardinality() + u.cardinality()) {
            System.out.println("Pass. The cardinality of the unon of t and u is smaller or equal to the cardinality of t + u.");
        } else {
            System.out.println("Fail. The cardinality of the unon of t and u is not smaller or equal to the cardinality of t + u.");
        }
    }
    
    // Logic: | t U u | = | t | + | u | - | t /inter u|
    public static void treeTestunionAndcardinalityAndinter( BinaryTree t, BinaryTree u){
        if (t.union(u).cardinality() == (t.cardinality() + u.cardinality()) - t.inter(u).cardinality()){
            System.out.println("Pass. The cardinalities are equal");
        } else {
             System.out.println("Fail. The cardinalities are not equal");
        }
    }
    
    // Logic: t = (t U t)
    public static void treeTestsUnionAndequal(BinaryTree t, BinaryTree u){
        if (t.equal(t.union(t))){
            System.out.println("Pass. The set t is equal to the set t union set t");
        } else {
            System.out.println("Fail. The set t is equal to the set t union set t");
        }
    }
}
