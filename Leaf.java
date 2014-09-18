//package CS203data1;

/* Binary Search Tree structure
    A tree is either:
        * A Leaf (In which case it is empty)
        * A branch
            * Root
            * Left
            * Right
 */
public class Leaf implements BinaryTree{
    
    Leaf(){ }
    
    // (empty) → finite-set
    // Returns a fresh empty set.
    public BinaryTree empty(){
        return this;
    };
    
    // (cardinality t) → integer
    // t : finite-set
    // Returns the number of elements in set t
    public int cardinality(){
        return 0;
    }

    // (isEmptyHuh t) → boolean
    // t : finite-set
    // Determines if t is empty
    
    public boolean isEmptyHuh() {
        return true;
    }
    
    // (member t elt) → boolean
    // t : finite-set
    // elt : integer
    // Determines if elt is in t
    public boolean member(int elt){
        return false;
    }
    
    // (add t elt) → finite-set
    // t : finite-set
    // elt : integer
    // Returns a set containing elt and everything in t
    public BinaryTree add(int elt){
        return new Branch(elt);
    }
    
    // (remove t elt) → finite-set
    // t : finite-set
    // elt : integer
    // Returns a set containing everything in t except elt.
    public BinaryTree remove(int elt){
        return new Leaf();
    }
    
    // (union t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything in t and u.
    

    public BinaryTree union(BinaryTree u){
        return u;
    }
    // (inter t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything that is in both t and u.
    public BinaryTree inter(BinaryTree u){
        return u;
    }
    
    //(diff t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything in u except those that are in t.
    public BinaryTree diff(BinaryTree u){
        return u;
    }
    
    // (equal t u) → boolean
    // t : finite-set
    // u : finite-set
    //Determines if t and u contain the same elements.
    public boolean equal(BinaryTree u){
        return false;
    }
    
    //(subset t u) → boolean
    // t : finite-set
    // u : finite-set
    // Determines if t is a subset of u.
    public boolean subset(BinaryTree u){
        return false;
     
    }
     
}