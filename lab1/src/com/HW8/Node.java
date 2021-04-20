import java.util.*;

// An Node object is one node in a binary tree of ints.
public class Node {
    private int element;            // data stored at this node
    private Node left;    // reference to left subtree
    private Node right;   // reference to right subtree
    private Node parent;     // a reference to the parent node (if any)
   
        
    // Constructs a leaf node with the given data.
    public Node(int data) {
        this(data, null, null, null);
    }
                
    // Constructs a branch node with the given data and links.
    public Node(int data, Node above, Node leftChild, Node rightChild) {
        element = data;
        parent = above;
        left = leftChild;
        right = rightChild;
    }


  
      // accessor methods
    public int getElement() { return element; }
    public Node getParent() { return parent; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
  
    // update methods
    public void setElement(int e) { element = e; }
    public void setParent(Node parentNode) { parent = parentNode; }
    public void setLeft(Node leftChild) { left = leftChild; }
    public void setRight(Node rightChild) { right = rightChild; }

    public boolean isInternal() { return numChildren() > 0; }

    public boolean isExternal() { return numChildren() == 0; }

    public boolean isRoot() { return parent ==null; }

    public int numChildren() {
        int count=0;
        if (left != null)
          count++;
        if (right != null)
          count++;
        return count;
      }

    public Node sibling() {
        if (parent == null) return null;                  // p must be the root
        if (this == parent.left)                            // p is a left child
            return parent.right;                           // (right child might be null)
        else                                              // p is a right child
            return parent.left;                            // (left child might be null)
    }

    public List<Node> children() {
      List<Node> snapshot = new ArrayList<>(2);    // max capacity of 2
      if (left != null)
        snapshot.add(left);
      if (right != null)
        snapshot.add(right);
      return snapshot;
    }

}
