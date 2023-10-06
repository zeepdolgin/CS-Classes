
//CS102 - Data Structures, Dr.Anasse Bari
//Adopted from Data Structures and Algorithms in Java / Edition 2 by Robert Lafore
// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
import java.io.*;
import java.util.*; // for Stack class

////////////////////////////////////////////////////////////////
class Node {

    public int iData; // data item (key)
    public double dData; // data item
    public Node leftChild; // this node's left child
    public Node rightChild; // this node's right child

    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
} // end class Node

////////////////////////////////////////////////////////////////
class Tree {
    private static Node root; // first node of tree

    // -------------------------------------------------------------
    public Tree() { // constructor
        root = null; // no nodes in tree yet
    }

    // -------------------------------------------------------------
    public static Node find(int key) { // find node with given (assumes non-empty tree)
        Node current = root; // start at root
        while (current.iData != key) { // while no match,
            if (key < current.iData) { // go left?
                current = current.leftChild;
            } else { // or go right?
                current = current.rightChild;
            }
            if (current == null) { // if no child,
                return null; // didn't find it
            }
        }
        return current; // found it
    } // end find()
    // -------------------------------------------------------------
    public static void insert(int id, double dd) {
        Node newNode = new Node(); // make new node
        newNode.iData = id; // insert data
        newNode.dData = dd;
        if (root == null) // no node in root
            root = newNode;
        else // root occupied
        {
            Node current = root; // start at root
            Node parent;
            while (true) // (exits internally)
            {
                parent = current;
                if (id < current.iData) // go left?
                {
                    current = current.leftChild;
                    if (current == null) // if end of the line,
                    { // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } // end if go left
                else // or go right?
                {
                    current = current.rightChild;
                    if (current == null) // if end of the line
                    { // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                } // end else go right
            } // end while
        } // end else not root
    } // end insert()
    // -------------------------------------------------------------
    // returns node with next-highest value after delNode
    // goes to right child, then right child's left descendents
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // go to right child
        while (current != null) // until no more
        { // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to left child
        }
        // if successor not
        if (successor != delNode.rightChild) // right child,
        { // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    // -------------------------------------------------------------
    public void traverse(int traverseType) {
        switch (traverseType) {
        case 1:
            System.out.print("\nPreorder traversal: ");
            preOrder(root);
            break;
        case 2:
            System.out.print("\nInorder traversal:  ");
            inOrder(root);
            break;
        case 3:
            System.out.print("\nPostorder traversal: ");
            postOrder(root);
            break;
        }
        System.out.println();
    }

    // -------------------------------------------------------------
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    // -------------------------------------------------------------
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    // -------------------------------------------------------------
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    // -------------------------------------------------------------
    public boolean isBSTUtil(Node localRoot, int prev) { // this is a utility method to get a boolean answer (allows for
        // recursive solution).
        if (localRoot != null) {
            if (!isBSTUtil(localRoot.leftChild, prev)) {
                return false;
            }
            if (localRoot.iData <= prev) {
                return false;
            }
            prev = localRoot.iData;
            return isBSTUtil(localRoot.rightChild, prev);
        }
        return true;
    }

    public void isBST() { // isBST() this method will take a tree as an input and will PRINT to the screen
        // if the tree is a BST or NOT.
        int prev = Integer.MIN_VALUE;
        if (isBSTUtil(root, prev)) {
            System.out.println("This is a BST");
        } else {
            System.out.println("This is not a BST");
        }
    }
    // ------------------------------------------------------------
    public boolean delete(int key) { // delete node with given key (assumes non-empty list)
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iData != key) // search for node
        {
            parent = current;
            if (key < current.iData) // go left?
            {
                isLeftChild = true;
                current = current.leftChild;
            } else // or go right?
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) // end of the line,
                return false; // didn't find it
        } // end while
        // found node to delete

        // if no children, simply delete it
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) // if root,
                root = null; // tree is empty
            else if (isLeftChild)
                parent.leftChild = null; // disconnect
            else // from parent
                parent.rightChild = null;
        }

        // if no right child, replace with left subtree
        else if (current.rightChild == null)
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;

        // if no left child, replace with right subtree
        else if (current.leftChild == null)
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;

        else // two children, so replace with inorder successor
        {
            // get successor of node to delete (current)
            Node successor = getSuccessor(current);

            // connect parent of current to successor instead
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;

            // connect successor to current's left child
            successor.leftChild = current.leftChild;
        } // end else two children
        // (successor cannot have a left child)
        return true; // success
    } // end delete()

    // -------------------------------------------------------------
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        int counter = 1;
        boolean isRowEmpty = false;
        System.out.println(".............................................................................");
        while (isRowEmpty == false) {
            System.out.print("Level: "+ counter);
            counter++;
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            } // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());       
        } // end while isRowEmpty is false
        System.out.println(".............................................................................");
    } // end displayTree()

    // -------------------------------------------------------------
    public void displaymyChilds(int value) {
        Node found = Tree.find(value);
        if (found != null) {
            if (found.leftChild != null) {
                System.out.println("Left Child: ");
                found.leftChild.displayNode();
            } else {
                System.out.println("Node has not left child.");
            }
            if (found.rightChild != null) {
                System.out.println("\n");
                System.out.println("Right Child: ");
                found.rightChild.displayNode();
            } else {
                System.out.println("Node has not right child.");
                System.out.println("\n");
            }
        } else {
            System.out.print("Could not find node with iData of: " + value);
        }
    }
    // -------------------------------------------------------------
    public void displayLeavesUtil(Node localRoot) {
        if (localRoot == null) {
            return; // If node is leaf node, print its data
        }
        if (localRoot.leftChild == null && localRoot.rightChild == null) {
            System.out.print("| " + localRoot.iData + " & " + localRoot.dData + " |" + " ");
            return;
        }
        // If left child exists, check for leaf
        // recursively
        if (localRoot.leftChild != null) {
            displayLeavesUtil(localRoot.leftChild);
        }
        // If right child exists, check for leaf
        // recursively
        if (localRoot.rightChild != null) {
            displayLeavesUtil(localRoot.rightChild);
        }
    }

    public void displayLeaves() {
        displayLeavesUtil(root);
    }
} // end class Tree
  ////////////////////////////////////////////////////////////////

class TreeApp {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int value;
        Tree theTree = new Tree();

        Tree.insert(50, 1.5);
        Tree.insert(25, 1.2);
        Tree.insert(75, 1.7);
        Tree.insert(12, 1.5);
        Tree.insert(37, 1.2);
        Tree.insert(43, 1.7);
        Tree.insert(30, 1.5);
        Tree.insert(33, 1.2);
        Tree.insert(87, 1.7);
        Tree.insert(93, 1.5);
        Tree.insert(97, 1.5);

        System.out.println("\n");
        System.out.println("Please choose an option:");
        System.out.println("1. Traverse." + "\n2. Check if the Tree is a BTS tree." + "\n3. Delete by iData."
                + "\n4. Dispplay tree by levels." + "\n5. Display children of a node with a given iData and dData."
                + "\n6. Insert a new Node (leaf)." + "\n7. Display all the Leaves" + "\n8. Exit");
        String s = "What do you want to do next?";
        int option_choice = 0;
        do {
            option_choice = input.nextInt();
            switch (option_choice) {
            case 1:
                System.out.print("Enter type 1, 2 or 3: ");
                value = getInt();
                theTree.traverse(value);
                System.out.println(s);
                break;

            case 2:
                theTree.isBST();
                System.out.println(s);
                break;

            case 3:
                System.out.print("Enter value to delete: ");
                value = getInt();
                boolean didDelete = theTree.delete(value);
                if (didDelete) {
                    System.out.print("Deleted " + value + '\n');
                } else {
                    System.out.print("Could not delete ");
                    System.out.print(value + '\n');
                }
                System.out.println(s);
                break;

            case 4:
                theTree.displayTree();
                System.out.println(s);
                break;

            case 5: 
                System.out.print("Enter value whose children to display: ");
                value = getInt();
                theTree.displaymyChilds(value);
                System.out.println("\n");
                System.out.println(s);
                break;

            case 6:
                System.out.print("Enter value to insert: ");
                value = getInt();
                Tree.insert(value, value + 0.9);
                System.out.println(s);
                break;

            case 7:
                theTree.displayLeaves();
                System.out.println();
                System.out.println(s);
                break;

            case 8:
                System.out.println("Thank you for using the TreeApp Quiz 2 program.");
                break;

            default:
                System.out.println("No such option, please try again");
                System.out.println(s);
                break;
            }
        } while (option_choice != 8);

        input.close();
    } // end main()
      // -------------------------------------------------------------

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // -------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    // -------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    // -------------------------------------------------------------
} // end class TreeApp
  ////////////////////////////////////////////////////////////////
