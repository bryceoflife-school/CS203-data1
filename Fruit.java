//package CS203data1;

/* Binary Search Tree structure
    A tree is either:
        * A fruit (In which case it is empty)
        * A branch
            * Root
            * Left
            * Right
 */
public class Fruit implements FiniteSet{
    Fruit(){ }
    
    public int cardinality(){
        return 0;
    }

    public boolean isEmptyHuh() {
        return true;
    }
    
    public boolean member(int elt){
        return false;
    }
    
    public FiniteSet add(int elt){
        return new Branch(elt, this, this);
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