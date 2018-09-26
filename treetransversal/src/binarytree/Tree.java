/** Deren Singh - Ms. Stowe
 * This class holds the data for a tree that can add and check if an 
 * element is in the tree. It also sorts it in a certain way when adding.
 */
package binarytree;

import queue.LinkedListQueue;
import stack.LinkedListStack;

public class Tree<T extends Comparable<T>> implements BinaryTreeADT<T> {

	private TreeNode<T> root;//Root of tree

	//Default constructor
	public Tree() {
		root = null;
	}

	/** Get the tree's root
	 * @return - root
	 */
	public TreeNode<T> getRoot() {
		return root;
	}

	/** Set the tree's root
	 * @param newNode - what root is being set to
	 */
	public void setRoot(TreeNode<T> newNode) {
		root = newNode;
	}

	/** Check if the tree is empty
	 * @return - boolean if tree is empty or not
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/** Add an element to the tree
	 * @param element - element being added to tree
	 */
	public void add(T element) {
		if(root == null){
			root = new TreeNode<T>(element);
		}else{
			TreeNode<T> current = root;
			while(current != null){
				if(current.getValue().compareTo(element) > 0){
					if(current.getLeft() == null){
						current.setLeft(new TreeNode<T>(element));
						break;
					}
					current = current.getLeft();
				}else if(current.getValue().compareTo(element) < 0){
					if(current.getRight()==null){
						current.setRight(new TreeNode<T>(element));
						break;
					}
					current = current.getRight();
				}
			}
			
		}
	}

	/** Check if a certain element is in the tree without recursion
	 * @param element - element being searched for in tree
	 * @return - if element is in tree
	 */
	public boolean contains(T element) {
		if(root == null){
			return false;
		}
		TreeNode<T> current = root;
		while(current != null){
			if(current.getValue().compareTo(element)==0){
				return true;
			}else if(current.getValue().compareTo(element) > 0){
				current = current.getLeft();
			}else if(current.getValue().compareTo(element) < 0){
				current = current.getRight();
			}
		}
		return false;
	}
	
	/** Print the search path of the root while searching for an element
	 * @param element - the elment being searched for
	 * @param root - the root of the tree
	 * @return - String of path to find the element
	 */
	public String printSearchPath(T element, TreeNode<T> root){
		String s = "";
		if(root == null){
			return "Binary tree is empty!";
		}else{
			if(element.compareTo(root.getValue()) == 0){
				return ""+element+"\nFound";
			}else if(root.getValue().compareTo(element) > 0){
				return root.getValue() + " " + printSearchPath(element, root.getLeft())+"";
			}else if(root.getValue().compareTo(element) < 0){
				return root.getValue() + " " + printSearchPath(element, root.getRight())+"";
			}
		}
		return "";
	}
	
	/** Check if a certain element is in the tree with recursion
	 * @param element - element being searched for in tree
	 * @param root - root being checked for element
	 * @return - if element is in root
	 */
	public boolean contains(T element, TreeNode<T> root){
		if(root == null){
			return false;
		}else{
			if(element.compareTo(root.getValue()) == 0){
				return true;
			}else if(root.getValue().compareTo(element) > 0){
				return contains(element, root.getLeft());
			}else if(root.getValue().compareTo(element) < 0){
				return contains(element, root.getRight());
			}
		}
		return false;
	}

	/** Print out a root in pre order form without recursion 
	 * @param root - the root getting printed
	 * @return - string of the root getting printed
	 */
	public String preOrder(TreeNode<T> root) {
		TreeNode<T> current = root;
		String out = "";
		if(root == null){
			return "No items in tree!";
		}else{
			LinkedListStack<TreeNode> stack = new LinkedListStack<>();
			stack.push(root);
			
			while(!stack.isEmpty()){
				TreeNode<TreeNode> node = stack.pop();
				out += node.getValue() + " ";
				if(node.getRight() != null){
					stack.push(node.getRight());
				}
				if(node.getLeft() != null){
					stack.push(node.getLeft());
				}
			}
		}
		return out;
	}
	
	/** Print out the root in pre order form with recursion
	 * @param node - the root getting printed
	 * @return - string of root getting printed
	 */
	public String preOrderRecursion(TreeNode<T> root){
		if(root == null){
			return "";
		}
		return root.getValue() + ", " + preOrderRecursion(root.getLeft()) + preOrderRecursion(root.getRight());
	}
	
	/** Print out the root in order form with recursion
	 * @param node - the root getting printed
	 * @return - string of root getting printed
	 */
	public String inOrder(TreeNode<T> root) {
		if(root == null){
			//return "No items in tree!";
			return "";
		}else{
			return inOrder(root.getLeft()) + root.getValue()+ ", "+ inOrder(root.getRight());
		}
	}

	/** Print out the root in post order form with recursion
	 * @param node - the root getting printed
	 * @return - string of root getting printed
	 */
	public String postOrder(TreeNode<T> root) {
		if(root == null){
			return "";
		}else{
			return postOrder(root.getLeft()) + postOrder(root.getRight()) + root.getValue()+ ", ";
		}
	}
	
	/** Print out the root in level order form with recursion
	 * @param node - the root getting printed
	 * @return - string of root getting printed
	 */
	public String levelOrder(TreeNode<T> root) {
		LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
		String str = "";
		if(root == null){
			return "No items in tree!";
		}
		
		queue.enqueue(root);
		str = queue.peekFront().getValue().toString();
		while(!queue.isEmpty()){
			TreeNode current = queue.dequeue();
			
			if(current.getLeft()!=null){
				queue.enqueue(current.getLeft());
				str += ", "+current.getLeft().getValue();
			}
			if(current.getRight()!=null){
				queue.enqueue(current.getRight());
				str += ", "+ current.getRight().getValue();
			}
		}
		return str;
	}
	
	/** Print a binary tree in tree form
	 * @param currentLevel - the current level of the tree getting printed
	 * @param nextLevel - the next level of the tree that will be printed
	 * @return - a binary tree in tree form
	 */
	private String printBinaryTree(LinkedListQueue<TreeNode<T>> currentLevel, LinkedListQueue<TreeNode<T>> nextLevel) {
        String str = "";
        final int maxHeight = getHeight(this.root);
        TreeNode<T> node = currentLevel.dequeue();
        str += getIndent(node, maxHeight-getHeight(node), maxHeight) +node.getValue().toString() + getSpacing(root, maxHeight-getHeight(node), maxHeight);
        
        if (node.getLeft() != null) {
        	nextLevel.enqueue(node.getLeft());
        }else if(getNodeHeight(root, node, 1) > 1){
        	nextLevel.enqueue(new TreeNode<T>((T) new String(getSpacing(root, maxHeight, maxHeight)), null, null));
        }
        if (node.getRight() != null) {
        	nextLevel.enqueue(node.getRight());
        }else if(getNodeHeight(root, node, 1) > 1){
        	nextLevel.enqueue(new TreeNode<T>((T) new String(getSpacing(root, maxHeight, maxHeight)), null, null));
        }
        if(currentLevel.isEmpty()){
            str += "\n";
            while(!nextLevel.isEmpty()){
            	currentLevel.enqueue(nextLevel.dequeue());
            }
        }
       
        if (!nextLevel.isEmpty() || !currentLevel.isEmpty()){
            str += printBinaryTree(currentLevel, nextLevel);
        }
        return str;
      
    }
	
	/** Get the specific height of a node
	 * @param root - the root getting it's height checked
	 * @param x - the max height the node could be
	 * @param height - the node height
	 * @return - the node height
	 */
	public int getNodeHeight(TreeNode<T> root, TreeNode<T> x, int height){
		if(root == null){
			return 0;
		}
		if(root == x){
			return height;
		}
		
		int level = getNodeHeight(root.getLeft(), x, height+1);
		if(level != 0){
			return level;
		}
		return getNodeHeight(root.getRight(),x,height+1);
	}
	
	/** Print the tree in tree form
	 * @return - a string of the tree in tree form
	 */
	public String prettyPrintBinaryTree() {
        if (isEmpty()) {
            return "Binary Tree is empty!";
        }
        LinkedListQueue<TreeNode<T>> current = new LinkedListQueue<>();
        LinkedListQueue<TreeNode<T>> next = new LinkedListQueue<>();
        current.enqueue(root);
        return printBinaryTree(current, next);
	}

	
	/** Get the beginning indent of the nodes
	 * @param root - the root getting printed
	 * @param level - the level getting indented
	 * @param maxHeight - the max height of the total tree 
	 * @return - the indent of the beginning of the tree
	 */
	private String getIndent(TreeNode<T> root, int level, int maxHeight){
		int indent = (int) Math.pow(2, maxHeight-level)-1;
		String indents = "";
		for(int i = 0; i < indent; i++){
			indents += " ";
		}
		return indents;
	}
	
	/** Get the spaces between each node
	 * @param root - the root being printed
	 * @param level - the level of which the spaces will be printed in
	 * @param maxHeight - the tree's total height
	 * @return - the amount of spaces in between each node
	 */
	private String getSpacing(TreeNode<T> root, int level, int maxHeight){
		int spacing = (int) (Math.pow(2, maxHeight-level)-1);
		String spaces = "";
		for(int i = 0 ; i <= spacing; i++){
			spaces += " ";
		}
		return spaces;
	}
	
	/** Get the height of a specific root
	 * @param root - the rot getting it's height checked
	 * @return - the root's height
	 */
	public int getHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftHeight = getHeight(root.getLeft());
		int rightHeight = getHeight(root.getRight());
		
		if(leftHeight > rightHeight){
			return leftHeight+1;
		}else{
			return rightHeight+1;
		}
	}
	
}
