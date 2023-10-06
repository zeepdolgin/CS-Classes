import java.util.Scanner;
//________________________________________________________LINK LIST 2 APP driver code_______________________________________________________
class LinkList2App{
   public static void main(String[] args){

   LinkListQuiz2 theList = new LinkListQuiz2();  // make list

   //You have to call all the method and test them here. 
   Scanner input = new Scanner(System.in);
   String s = "What do you want to do next?";
   System.out.println("Welcome to Linked List Quiz 2 program:");
   System.out.println("____________________________________________");
   theList.insertFirst(22, 2.99);// insert four items
   theList.insertFirst(44, 4.99);
   theList.insertFirst(66, 6.99);
   theList.insertFirst(88, 8.99);
   System.out.println("To make testing easier, the following Links (Nodes) have been added: ");
   theList.displayList();

   System.out.println("\n");
   System.out.println("Please choose an option:");
   
   System.out.println("1. Insert First (add an element to the beggining of the Linked List." + "\n2. Display value in the last node." + "\n3. Display value in the middle node."
    + "\n4. Count elements in the Linked List." + "\n5. Search by key (iData)."
    + "\n6. Delete by key (iData)." + "\n7. Display the whole Linked List." + "\n8. See if there are duplicates in the list (1 if present, 0 if none)."
    + "\n9. Delete duplicates from the list and display the List without duplicates on screen." + "\n10. Exit");
    
    int option_choice = 0;
      do{
         option_choice = input.nextInt();
         switch(option_choice){
                
            case 1:
               System.out.println("Please enter the value of iData (int) that you want to be stored in the Node that will be added.");
               int iD = input.nextInt();
               System.out.println("Please enter the value of dData (double) that you want to be stored in the Node that will be added.");
               double dD = input.nextDouble();
               theList.insertFirst(iD, dD);
               System.out.println("Node added to the beggining of the list.");
               System.out.println(s);
               break;
            
               case 2:
               theList.displayidValueintheLastNode();
               System.out.println(s);
               break;

               case 3:
               theList.displayidValueinthemiddleNode();
               System.out.println(s);
               break;
                
               case 4:
               System.out.println(theList.count());
               System.out.println(s);
               break;

               case 5:
               System.out.println("Please enter the value of key (iData) by which you want to search: ");
               int k = input.nextInt();
               Link answer = theList.search(k);
               if(answer != null){
                  answer.displayLink();
               }else{
                  System.out.println("No entry with key (iData int value) " + k + " exists in the list.");
               }
               System.out.println(s);
               break;

               case 6:
               System.out.println("Please enter the value of key (iData) whose node you want to delete: ");
               int d = input.nextInt();
               theList.delete(d);
               System.out.println("Node either did not exist, or deleted from the List.");
               System.out.println(s);
               break;

               case 7:
               System.out.println("Displaying the whole list: ");
               int length = theList.displayList();
               System.out.println("The length of the list is: " + length);
               System.out.println(s);
               break;

               case 8:
               System.out.println("Checking if there are duplicates in the list: ");
               int duplicates = theList.Duplicates();
               if(duplicates == 1){
                  System.out.println("There are duplicates in the list");
               }else{
                  System.out.println("There are no duplicates in the list");
               }
               System.out.println(s);
               break;

               case 9:
               System.out.println("Deleting the duplicates from the list...");
               theList.deleteDuplicateNodes();
               System.out.println("Displaying the list with no duplicates: ");
               theList.displayList();
               System.out.println(s);
               break;

               case 10:
               System.out.println("Thank you for using the Linked List Quiz 2 program.");
               break;

               default:
               System.out.println("No such option, please try again");
               break;
            }
      }while(option_choice != 10);

   input.close();

   }
   //Create a menu that will allow the user to choose from to call the method you implmented above 
    
}

//________________________________________________________ LINK LIST QUIZ 2 CLASS _______________________________________________________

class LinkListQuiz2
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public LinkListQuiz2()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      {
      return (first==null);
      }
// -------------------------------------------------------------
   public void insertFirst(int id, double dd)
      {
      Link newLink = new Link(id, dd);
      newLink.next = first;       // newLink --> old first
      first = newLink;            // first --> newLink                        
      }

// -------------------------------------------------------------
   public int displayidValueintheLastNode() //Retruns the iData of the last node.
      {
         int length = this.count()-1;
         Link current = first;       // start at beginning of list
         int counter = 0; 
         while(counter != length )      // until end of list,
            {
            current = current.next;  // move to next link
            counter++;
            }
         int answer = current.iData;
         System.out.println("The iData of the last node is: " + answer);
         return answer;
      }

// -------------------------------------------------------------
   public int displayidValueinthemiddleNode() //Retruns the iData of the node located in the middle of the linkedlist
      {
         int length = this.count()/2;
         Link current = first;       // start at beginning of list
         int counter = 0; 
         while(counter != length )      // until end of list,
            {
            current = current.next;  // move to next link
            counter++;
            }
         int answer = current.iData;
         System.out.println("The iData of the last node in the middle (" + length + ") is: " + answer);
         return answer;                     
      }

// -------------------------------------------------------------
	  
public int count() //returns the number of nodes in a linkedlist     
      {
         Link current = first;       // start at beginning of list
         int counter = 0; 
         while(current != null)      // until end of list,
            {
            current = current.next;  // move to next link
            counter++;
            }
         return counter; 
      }

// -------------------------------------------------------------
   public Link search(int key) //Searches by key (iData) & Retruns the Link, in case the node does not exist you return an empty link.    
      {
         Link current = first;              // start at 'first'
         while(current.iData != key){       // while no match,
            if(current.next == null)        // if end of list,
               return null;                 // didn't find it
            else                            // not end of list,
               current = current.next;      // go to next link
         }
      return current;                    // found it
      }
// -------------------------------------------------------------
   public Link delete(int key)    // delete link with given key
      {                           // (assumes non-empty list)
         Link current = first;              // search for link
         Link previous = first;
         while(current.iData != key)
            {
            if(current.next == null)
               return null;                 // didn't find it
            else
               {
               previous = current;          // go to next link
               current = current.next;
               }
            }                               // found it
         if(current == first)               // if first link,
            first = first.next;             //    change first
         else                               // otherwise,
            previous.next = current.next;   //    bypass it
         return current;   
      }
// -------------------------------------------------------------
   public int displayList(){      // display the list to the SCREEN and return the count of nodes.
      System.out.print("List (first-->last): ");
      Link current = first;       // start at beginning of list
      int counter = 0; 
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         counter++;
         }
      System.out.println("");
      return counter;
      }
// -------------------------------------------------------------
   public int Duplicates(){      // returns 1 or 0, if duplicates (by iData) exist
      Link current = first;
      int count = 0;
      while (current.next != null){ 
  
        // Starting from the next node 
        Link ptr = current.next; 
        while (ptr != null) 
        {
            // If some duplicate node is found 
            if (current.iData == ptr.iData) 
            { 
                count++; 
                break; 
            } 
            ptr = ptr.next; 
        } 
  
        current = current.next; 
      } 
      if(count > 0){
         return 1;
      }else{
         return 0;
      }
   }
// -------------------------------------------------------------
   public void deleteDuplicateNodes(){    // displays the list with no duplicate. 
      Link current = first, index = null, temp = null;
      if(first == null) {  
         return;
      }else {  
         while(current != null){  
            //Node temp will point to previous node to index.  
            temp = current;  
            //Index will point to node next to current  
            index = current.next;
            while(index != null) {  
                //If current node's data is equal to index node's data  
               if(current.iData == index.iData) {  
                  //Here, index node is pointing to the node which is duplicate of current node  
                  //Skips the duplicate node by pointing to next node  
                  temp.next = index.next;  
               } else {  
                  //Temp will point to previous node of index.  
                  temp = index;  
               }  
               index = index.next;  
            }  
            current = current.next;  
         }  
      }  
   }
// -------------------------------------------------------------


}  // end class LinkList



//________________________________________________________ LINK CLASS _______________________________________________________
//Consider the following code of Singly LinkedList

class Link
   {
   public int iData; // data item            
   public double dData; // data item
   public Link next; // next link in list             
   public Link(int id, double dd) // constructor 
      {
      iData = id;
      dData = dd;
      }
   public void displayLink()      
      {
      System.out.print("{" + iData + ", " + dData + "} ");
      }
   }  // end class Link

