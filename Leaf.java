//package CS203data1;

/* Binary Search Tree structure
    A tree is either:
        * A fruit (In which case it is empty)
        * A branch
            * Root
            * Left
            * Right
 */
public class Leaf implements BinaryTree{
    
    Leaf(){ }
    
    public BinaryTree empty(){
        return this;
    };
    
    public int cardinality(){
        return 0;
    }

    public boolean isEmptyHuh() {
        return true;
    }
    
    public boolean member(int elt){
        return false;
    }
    
    public BinaryTree add(int elt){
        return new Branch(elt);
    }
    
    public BinaryTree remove(int elt){
        return new Leaf();
    }
    
    public BinaryTree union(BinaryTree u){
        return u;
    }
    
    public BinaryTree inter(BinaryTree u){
        return u;
    }
    /*
    public BinaryTree diff(BinaryTree u){
        return null;
    }
    
    public boolean equal(BinaryTree u){
        return false;
    }
    
    public boolean subset(BinaryTree u){
        return false;
     
    }
     */
}