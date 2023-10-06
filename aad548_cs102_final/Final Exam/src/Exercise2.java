////////////////////////////////////////////////////////////////
/// Program for exercise 2.
////////////////////////////////////////////////////////////////
import java.util.Scanner;


////////////////////////////////////////////////////////////////
// Stack START 
class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    // ------------------------------------------------------------
    public StackX() // constructor
    {
        st = new int[SIZE]; // make array
        top = -1;
    }

    // ------------------------------------------------------------
    public void push(int j) // put item on stack
    {
        st[++top] = j;
    }

    // ------------------------------------------------------------
    public int pop() // take item off stack
    {

        return st[top--];

    }

    // ------------------------------------------------------------
    public int peek() // peek at top of stack
    {
        return st[top];
    }

    // ------------------------------------------------------------
    public boolean isEmpty() // true if nothing on stack
    {
        return (top == -1);
    }
    // ------------------------------------------------------------
} // Stack END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// Vertex START 
class Vertex {
    public char label; // label (e.g. 'A')
    public boolean wasVisited;
    public int friends_club_number;

    // ------------------------------------------------------------
    public Vertex(char lab) // constructor
    {
        label = lab;
        wasVisited = false;
        friends_club_number = -1; // they belong yet.

    }
    // ------------------------------------------------------------
} // Vertex END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// Graph START 
class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices
    private StackX theStack;

    // ------------------------------------------------------------
    public Graph() // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int y = 0; y < MAX_VERTS; y++) // set adjacency
            for (int x = 0; x < MAX_VERTS; x++) // matrix to 0
                adjMat[x][y] = 0;
        theStack = new StackX();
    } // end constructor
    // ------------------------------------------------------------

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    // ------------------------------------------------------------
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    // ------------------------------------------------------------
    public char displayVertex(int v) {
        System.out.print(vertexList[v].label);
        return vertexList[v].label;
    }

    // ------------------------------------------------------------
    public String dfs(int start) { // depth-first search
        String DFS = "";
        int count = 1;
        vertexList[start].wasVisited = true; // mark it
        vertexList[start].friends_club_number = start;
        char m = displayVertex(start); // display it
        DFS += m;
        theStack.push(start); // push it

        while (!theStack.isEmpty()) { // until stack empty,
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) { // if no such vertex,
                theStack.pop();
            } else { // if it exists,
                vertexList[v].wasVisited = true;
                vertexList[v].friends_club_number = start;
                count++;
                // mark it
                char n = displayVertex(v); // display it
                DFS += n;
                theStack.push(v); // push it
            }
        } // end while

        // stack is empty, so we're done
        for (int j = 0; j < nVerts; j++) { // reset flags
            vertexList[j].wasVisited = false;
        } // end dfs
        return DFS;
    }

    // ------------------------------------------------------------
    // returns an unvisited vertex adj to v
    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++)
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
                return j;
        return -1;
    } // end getAdjUnvisitedVertex()

    // ------------------------------------------------------------
    // AlgorithmGraphOne
    // checks is a graph is connected:
    public boolean isConnected(int DFS_result_length) {
        if (DFS_result_length == nVerts) {
            return true;
        } else {
            return false;
        }
    }

} // Graph END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// MAIN START 
class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("____________________________________________");
        System.out.println("Welcome to Excercise 2 program.");
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0 (start for dfs)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE
        System.out.println("Testing for the original graph (expect connected). The number of verticies is 5.");
        System.out.print("Visits: ");
        String DFS_result = theGraph.dfs(0); // depth-first search
        System.out.println();
        int DFS_result_length = DFS_result.length();
        System.out.println("The length of string produced by DFS is: " + DFS_result_length + ";");
        System.out.println("Since " + DFS_result_length + " is equal to 5:");
        System.out.println("It is: " + theGraph.isConnected(DFS_result_length) + " that the graph is connected.");
        System.out.println("_________________________________________________");
        System.out.println("Testing for the modified graph (expect disconnected). The number of verticies is 6.");
        theGraph.addVertex('N'); // 5
        System.out.print("Visits: ");
        String DFS_result2 = theGraph.dfs(0); // depth-first search
        System.out.println();
        int DFS_result_length2 = DFS_result2.length();
        System.out.println("The length of string produced by DFS is: " + DFS_result_length2 + ";");
        System.out.println("Since " + DFS_result_length2 + " is < 6:");
        System.out.println("It is: " + theGraph.isConnected(DFS_result_length2) + " that the graph is connected.");
        input.close();
        System.out.println("Thank you for using Excercise 2 program!");
        System.out.println("_________________________________________________");
    } 
}// MAIN END 
////////////////////////////////////////////////////////////////

