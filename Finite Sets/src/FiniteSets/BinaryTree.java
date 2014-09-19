package FiniteSets;

public interface BinaryTree {
    public int cardinality();
    public boolean isEmptyHuh();
    public boolean member(int elt);
    public BinaryTree add(int elt);
    public BinaryTree remove(int elt);
    public BinaryTree union(BinaryTree u);
    public BinaryTree inter(BinaryTree u);
    public BinaryTree diff(BinaryTree u);
    public boolean equal(BinaryTree u);
    public boolean subset(BinaryTree u);
}

