package FiniteSets;

import static FiniteSets.FiniteSet.empty;

/* Binary Search Tree structure
    A tree is either:
        * A Leaf (In which case it is empty)
        * A branch
            * Root
            * Left
            * Right
 */
public class Leaf implements BinaryTree{
    
    public void Leaf(){ }
    
    /*
    // (empty) → finite-set
    // Returns a fresh empty set.
    public BinaryTree empty(){
        return this;
    };
    */
    
    // (cardinality t) → integer
    // t : finite-set
    // Returns the number of elements in set t
    public int cardinality(){
        return 0;
    }

    // A Leaf() is always empty and therefore will always return true
    public boolean isEmptyHuh() {
        return true;
    }
    
    // A Leaf() is always empty and therefore should not have any members
    // Therefore it should return false
    public boolean member(int elt){
        return false;
    }
    
    // A Leaf() is empty so it should return a new tree
    // With just the added element
    public BinaryTree add(int elt){
        return new FiniteSet(elt);
    }
    
    // There is nothing to remove in Leaf()
    // so it should just return itself
    public BinaryTree remove(int elt){
        return new Leaf();
    }
    
    // The union of anything and the empty set is
    // just the union of u
    public BinaryTree union(BinaryTree u){
        return u;
    }
    
    // The empty set cannot have common elements with another set
    // And therefore should return empty
    public BinaryTree inter(BinaryTree u){
        return empty();
    }
    
    // A Leaf() is empty and therefore every elment in
    // U should be returned
    public BinaryTree diff(BinaryTree u){
        return u;
    }
    
    // Only if both sets are empty can they be equal
    // And can return true
    public boolean equal(BinaryTree u){
        return u.cardinality() == this.cardinality();
    }
    
    // The empty set is a subset of all sets
    public boolean subset(BinaryTree u){
        return true;
     
    }
     
}