public class BinaryTree {
 Node root;
 
 public void addNode(int key, String name)
 {
  Node newNode = new Node(key, name);
  
  //If there is no curr root, becomes root
  
  if (root == null) {
   root = newNode;
  } else {
   
   //Setting searching node
   
   Node focusNode = root;
   
   Node parent;
   
   while(true) {
    parent = focusNode;
   if (key < focusNode.key) {
    focusNode = focusNode.leftChild;
    
    if (focusNode == null){
    parent.leftChild = newNode;
    return;
   }
   
  } else {
   
   focusNode = focusNode.rightChild;
   
   if (focusNode == null) {
    parent.rightChild = newNode;
    return;
    
    
   }
  }
 }
 }
}

 public void inOrderTraverseTree(Node focusNode) {
  
  if (focusNode != null) {
   
   // Traverse left
   
   inOrderTraverseTree(focusNode.leftChild);
   
   System.out.println(focusNode);
   
   // Traverse Right
   
   inOrderTraverseTree(focusNode.rightChild);
   
   
  }
 }

 public void preOrderTraverse(Node focusNode) {
  
  if (focusNode != null) {
   System.out.println(focusNode);
   
   preOrderTraverse(focusNode.leftChild);
   preOrderTraverse(focusNode.rightChild);
   
  }
 }
 
 public void postOrderTraverse(Node focusNode) {
  
  if( focusNode != null) {
   postOrderTraverse(focusNode.leftChild);
   postOrderTraverse(focusNode.rightChild);
   
   System.out.println(focusNode);

  }
 }
 
 public Node findNode(int key) {
  
  Node focusNode = root;
  
  while( focusNode.key != key) {
   
   if (key < focusNode.key) {
    focusNode = focusNode.leftChild;
   } else {
    focusNode = focusNode.rightChild;
   }
   
   if (focusNode == null)
    return null;
  }
  return focusNode;
 }
 
 public boolean remove(int key) {
	Node focusNode = root;
	Node parent = root;
	
	boolean aLeftChild = true;
	
	while(focusNode.key != key)	{
		parent = focusNode;
		
		if(key < focusNode.key) {
			aLeftChild = true;
			
			focusNode = focusNode.leftChild;
		} else {
			aLeftChild = false;
			
			focusNode = focusNode.rightChild;
		}
		if(focusNode == null)
			return false;
	}
	
	if(focusNode.leftChild == null && focusNode.rightChild == null) {
		if(focusNode == root) {
			root = null;
		} else if(aLeftChild) {
			parent.leftChild = null;
		}else {
			parent.rightChild = null;
		}
	}
	else if(focusNode.rightChild == null) {
		if(focusNode == root)
			root = focusNode.leftChild;
		else if(aLeftChild)
			parent.leftChild = focusNode.leftChild;
		else parent.rightChild = focusNode.leftChild;
	}
	else if(focusNode.leftChild == null) {
		if(focusNode == root)
			root = focusNode.rightChild;
		else if(aLeftChild)
			parent.leftChild = focusNode.rightChild;
		else
			parent.rightChild=focusNode.leftChild;
	}
	else {
		Node replacement = getReplacementNode(focusNode);
		
		if(focusNode == root)
			root = replacement;
		else if(aLeftChild)
			parent.leftChild = replacement;
		else
			parent.rightChild = replacement;
		replacement.leftChild = focusNode.leftChild;
	}
	return true;
	}
 
 	public Node getReplacementNode(Node replacedNode) {
 		Node replaceParent = replacedNode;
 		Node replacement = replacedNode;
 		
 		Node focusNode = replacedNode.rightChild;
 		
 		while(focusNode != null) {
 			replaceParent = replacement;
 			
 			replacement = focusNode;
 			
 			focusNode = focusNode.leftChild;
 		}
 		
 		if(replacement != replacedNode.rightChild) {
 			
 			replaceParent.leftChild = replacement.rightChild;
 			replacement.rightChild = replacedNode.rightChild;
 		}
 		return replacement;
 	}
 public static void main(String[] args) {
  
  BinaryTree theTree = new BinaryTree();
  
  theTree.addNode(50, "One");
  theTree.addNode(45, "Two");
  theTree.addNode(35, "Three");
  theTree.addNode(12, "Four");
  theTree.addNode(8, "Five");
  theTree.addNode(1, "Six");
  theTree.addNode(0, "Seven");
  theTree.addNode(125, "Eight");
  
  
  theTree.inOrderTraverseTree(theTree.root);
  System.out.println("Let's Remove 12!");
  theTree.remove(12);
  System.out.println(theTree.findNode(12));
  theTree.inOrderTraverseTree(theTree.root);

   }
  }
  
class Node{
 
 int key;
 String name;
 
 Node leftChild;
 Node rightChild;
 
 Node(int key, String name) {
  
  this.key = key;
  this.name = name;
 }
 public String toString() {
     return name + " has the key " + key;

 }
 }