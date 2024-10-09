class Node{
   int value;
   Node left, right;
	   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
   public void insert(int value){
         //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
            
         while(true){
            parent = current;
               
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
              
         }//closing while
         
      }//closing main if-else 
   }
	   
	/*
   pre-order traversal
	Prints the value of every node in preorder. Uses the root.left and root.right
   functions to traverse in pre order. 
	*/
   public void preOrderTraversal(Node root) {
   
      if (root != null) { 
      
         System.out.print(root.value + " "); 
         
         preOrderTraversal(root.left); 
         
         preOrderTraversal(root.right); 
         
      }
   }
	   
	/*
	in-order traversal
   Prints the value of every node in order traversal. Uses the root.left and root.right 
   functions to go through the in order traversal. 
	*/
   public void inOrderTraversal(Node root) { 
   
      if (root != null) { 
      
         inOrderTraversal(root.left); 
         
         System.out.print(root.value + " "); 
         
         inOrderTraversal(root.right); 
         
      }
   }   
	   
	/*
   post-order traversal
   Prints the value of every node in poster order traversal. Uses the root.left and root.right 
   functions to pass through the post order traversal. 
	*/
   public void postOrderTraversal(Node root) { 
   
      if (root != null) { 
      
         postOrderTraversal(root.left); 
         
         postOrderTraversal(root.right); 
         
         System.out.print(root.value + " "); 
         
      }
   }
	   
	   
	   
	/*
	a method to find the node in the tree
	with a specific value. 
   Creates a boolean method called find in order to go through the root using the
   root.left and root.right functions, and finds the necessary values with an if else if else statement. 
	*/
   public boolean find(Node root, int key) { 
   
      if (root == null) { 
      
         return false; 
         
      } 
      
      if (root.value == key) { 
      
         return true; 
         
      } else if (key < root.value) { 
      
         return find(root.left, key); 
         
      } else { 
      
         return find(root.right, key); 
         
      }
   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
   public int getMin(Node root){
         //implement in here
      return 0;
   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
   public int getMax(Node root){
         //implement in here
      return 0;
   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
   public Node delete(Node root, int key){
         
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
            //node has been found
         if(root.left==null && root.right==null){
               //case #1: leaf node
            root = null;
         }else if(root.right == null){
               //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
               //case #2 : only right child
            root = root.right;
         }else{
               //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
	   
	   
	   
}



public class TreeDemov1{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert( 24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
               
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
              
      System.out.print("pre-order :   "); 
      t1.preOrderTraversal(t1.root); 
      System.out.println(); 
      
      System.out.print("post-order:   "); 
      t1.postOrderTraversal(t1.root); 
      System.out.println(); 
      
      System.out.println("locate 18 :   " + t1.find(t1.root, 18)); 
      System.out.println("locate 100 :   " + t1.find(t1.root, 100)); 
      System.out.println("min value :   " + t1.getMin(t1.root)); 
      System.out.println("max value :   " + t1.getMax(t1.root)); 
   }  
}
