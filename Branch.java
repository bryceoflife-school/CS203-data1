import java.util.*;
//package CS203data1;


public class Branch implements FiniteSet{
    
    int root;
    FiniteSet left;
    FiniteSet right;
    
    Branch(int root, FiniteSet left, FiniteSet right){
        this.root = root;
        this.left = left;
        this.right = right;
    }
    
    public int cardinality(){
        return 1 + left.cardinality() + right.cardinality();
    }
    
    public boolean isEmptyHuh() {
        return false;
    }
    
    public boolean member(int elt){
        if (root == elt) {
            return true;
        } else if (root > elt) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }
    
    public FiniteSet add(int elt){
        return null;
    }
    
    public FiniteSet remove(int elt){
        return null;
    }
    
    public FiniteSet union(FiniteSet u){
        return null;
    }
    
    public FiniteSet inter(FiniteSet u){
        return null;
    }
    
    public FiniteSet diff(FiniteSet u){
        return null;
    }
    
    public boolean equal(FiniteSet u){
        return false;
    }
    
    public boolean subset(FiniteSet u){
        return false;
    }
}