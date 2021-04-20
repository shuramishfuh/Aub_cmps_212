import java.util.*;
public class LBTTester {     
    public static void main(String[] args) {
        //construct an empty tree
        LinkedBinaryTree t1 = new LinkedBinaryTree();
         
        //add nodes to it making it a binary searh tree
        t1.addRoot(7);
        t1.addLeft(t1.root(), 3);
        t1.addRight(t1.root(), 1);
        
        Node n1= t1.root().getLeft();
        
        System.out.println(" node : " + n1 + " value : " + n1.getElement());

        Node n2= n1.sibling();

        System.out.println(" node : " + n2 + " value : " + n2.getElement());


       
        //print side ways the tree
        t1.printSideways();
        System.out.println();
        System.out.println("Size : " + t1.size()); 


        //LinkedBinaryTree t3 = new LinkedBinaryTree(3);

        //t3.printSideways();
        //System.out.println();
        //System.out.println("Size : " + t3.size());


        //System.out.println();

        //List<Node> listNodes = t3.nodes();
        //for (Node c : listNodes) System.out.print(c.getElement() + " ");

        //System.out.println();


        LinkedBinaryTree t2 = new LinkedBinaryTree();
        t2.addRoot(7); 
        Node v = t2.root();
        t2.expandExternal(v, 14, 15);

        Node vLeft = v.getLeft();
        Node vRight = v.getRight();
        t2.expandExternal(vLeft, 28, 29);

        t2.expandExternal(vRight, 30, 31);
        //print side ways the tree
        t2.printSideways();
        System.out.println();
        System.out.println("Size : " + t2.size()); 

        System.out.println("\n node : " + vLeft.getElement() + " sibling : " + vLeft.sibling().getElement()); 

        List<Node> listNodes = t2.nodes();
        for (Node c : listNodes) System.out.print(c.getElement() + " ");

        //System.out.println();
        
        
    }
}