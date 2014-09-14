import java.util.*;


public class Branch implements BinaryTree{
    
    int root;
    BinaryTree left;
    BinaryTree right;
    
    public Branch(int root){
        this.root = root;
        this.left = new Leaf();
        this.right = new Leaf();
    }
    
    Branch(int root, BinaryTree left, BinaryTree right){
        this.root = root;
        this.left = left;
        this.right = right;
    }
    
    public BinaryTree empty(){
        return new Leaf();
    }
    
    public int cardinality(){
        return 1 + this.left.cardinality() + this.right.cardinality();
    }
    
    public boolean isEmptyHuh() {
        return false;
    }
    
    public boolean member(int elt){
        if (this.root == elt) {
            return true;
        } else if (this.root > elt) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }
    

    public BinaryTree add(int elt){
        Branch newBST = new Branch(this.root, this.left, this.right);
        if (elt < newBST.root) {
            newBST.left = newBST.left.add(elt);
        } else if (elt > newBST.root) {
            newBST.right = newBST.right.add(elt);
        }
        return newBST;
    }
    
    
    public BinaryTree remove(int elt){
        return null;
    }
    
    public BinaryTree union(BinaryTree u){
        return u.add(this.root).union(this.left).union(this.right);
    }
    
    public BinaryTree inter(BinaryTree u){
        return null;
    }
    
    public BinaryTree diff(BinaryTree u){
        return null;
    }
    
    public boolean equal(BinaryTree u){
        return false;
    }
    
    public boolean subset(BinaryTree u){
        return false;
    }
}