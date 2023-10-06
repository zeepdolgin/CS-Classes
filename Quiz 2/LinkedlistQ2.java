//Consider the following code of Singly LinkedList

class Link
   {
   public int iData;              
   public double dData; // data item
   public Link next;              
   public Link(int id, double dd) 
      {
      iData = id;
      dData = dd;
      }
   public void displayLink()      
      {
      System.out.print("{" + iData + ", " + dData + "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////

class LinkListQuiz2
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public LinkList()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public void insertFirst(int id, double dd)
      {                           

      
      }

// -------------------------------------------------------------
   public int displayidValueintheLastNode() //Retruns the iData of the last node.
      {                           

      
      }

// -------------------------------------------------------------
   public int displayidValueinthemiddleNode() //Retruns the iData of the node located in the middle of the linkedlist
      {                           

      
      }

// -------------------------------------------------------------
	  
public int count() //returns the number of nodes in a linkedlist     
      {
      
                   
      }

// -------------------------------------------------------------
   public Link search(int key) //Searches by key (iData) & Retruns the Link, in case the node does not exist you return an empty link.    
      {
        
              
      }
// -------------------------------------------------------------
   public Link delete(int key)    // delete link with given key
      {                           // (assumes non-empty list)




      }
// -------------------------------------------------------------
   public int displayList()      // display the list to the SCREEN and return the count of nodes.
      {
      
      
      
      }
// -------------------------------------------------------------
public int Duplicates()      // returns 1 or 0, if duplicates exist
      {
      
      
      
      }
// -------------------------------------------------------------
   public void deleteDuplicateNodes()      // displays the list with no duplicate. 
      {
      
      
      
      }
// -------------------------------------------------------------


   }  // end class LinkList
////////////////////////////////////////////////////////////////
class LinkList2App
   {
   public static void main(String[] args)
      {
      LinkList theList = new LinkList();  // make list

      //You have to call all the method and test them here. 
   
      //Create a menu that will allow the user to choose from to call the method you implmented above
   
     
   } 
////////////////////////////////////////////////////////////////
