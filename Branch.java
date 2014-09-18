import java.util.*;


public class Branch implements BinaryTree{
    
    // Define global variables
    int root;
    BinaryTree left;
    BinaryTree right;
    
    // Constructor that takes root
    public Branch(int root){
        this.root = root;
        this.left = new Leaf();
        this.right = new Leaf();
    }
    
    // Constructor that takes root, left and right
    Branch(int root, BinaryTree left, BinaryTree right){
        this.root = root;
        this.left = left;
        this.right = right;
    }
    
    // (empty) → finite-set
    // Returns a fresh empty set.
    public BinaryTree empty(){
        return new Leaf();
    }
    
    // (cardinality t) → integer
    // t : finite-set
    // Returns the number of elements in set t
    public int cardinality(){
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
    public boolean member(int elt){
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
    public BinaryTree add(int elt){
        Branch newBST = new Branch(this.root, this.left, this.right);
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
    public BinaryTree remove(int elt){
        
        if (elt == this.root) {
            return this.left.union(this.right);
        } else if (elt < this.root) {
            this.left = this.left.remove(elt);
        } else {
            this.right = this.right.remove(elt);
        }
        return this;
    }
    
    // (union t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything in t and u.
    public BinaryTree union(BinaryTree u){
        return left.union(right.union(u)).add(root);
    }
    
    // (inter t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything that is in both t and u.
    public BinaryTree inter(BinaryTree u){
        Branch newBST = new Branch(this.root, this.left, this.right);
        
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
    public BinaryTree diff(BinaryTree u){
        BinaryTree rootless = u.remove(root);
        return (left.union(right)).diff(rootless);
    }

    // (equal t u) → boolean
    // t : finite-set
    // u : finite-set
    //Determines if t and u contain the same elements.
    public boolean equal(BinaryTree u){
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
    public boolean subset(BinaryTree u){
        if (!u.member(this.root)){
            return false;
            
        } else if ((this.left.isEmptyHuh()) ||
                   (this.right.isEmptyHuh())) {
            return true;
            
        } else {
            return this.right.union(this.left).subset(u);
            
        }
    }
}