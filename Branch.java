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
        Branch newBST = new Branch(this.root, this.left, this.right);
        if (elt == root) {
            return newBST.left.union(newBST.right);
        } else if (elt < newBST.root) {
            newBST.left = newBST.left.remove(elt);
        } else {
            newBST.right = newBST.right.remove(elt);
        }
        return newBST;
    }
    
    public BinaryTree union(BinaryTree u){
        return left.union(right.union(u)).add(root);
    }
    
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
  
    public BinaryTree diff(BinaryTree u){
        Branch newBST = new Branch(this.root, this.left, this.right);
        
        if((this.union(u).member(this.root)) &&
            !(this.inter(u).member(this.root))) {
            System.out.println("here");
            newBST.left.diff(u);
            newBST.right.diff(u);
            return newBST;
        } else {
            return left.diff(u).union(right.diff(u));
        }
    }
    
    
    public boolean equal(BinaryTree u){
        if (u.cardinality() != this.cardinality()){
            return false;
        } else if (this.subset(u) == u.subset(this)) {
            
            return true;
        } else {
            
        return false;
            
        }
    }
    
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








