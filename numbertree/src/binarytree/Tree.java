/** Deren Singh - Ms. Stowe
 * This class holds the data for a tree that can add and check if an 
 * element is in the tree. It also sorts it in a certain way when adding.
 */
package binarytree;

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
				//System.out.println(element);
			//	System.out.println("Found");
				return true;
			}else if(current.getValue().compareTo(element) > 0){
				//System.out.println(current.getValue());
				current = current.getLeft();
			}else if(current.getValue().compareTo(element) < 0){
				//System.out.println(current.getValue());
				current = current.getRight();
			}
		}
		//System.out.println("Not found!");
		return false;
	}
	
	public String printSearchPath(T element, TreeNode<T> root){
		String s = "";
		if(root == null){
			return "";
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
			//System.out.println("Not found!");
			return false;
		}else{
			if(element.compareTo(root.getValue()) == 0){
				//System.out.println(element);
				//System.out.println("Found");
				return true;
			}else if(root.getValue().compareTo(element) > 0){
				//System.out.println(root.getValue());
				return contains(element, root.getLeft());
			}else if(root.getValue().compareTo(element) < 0){
				//System.out.println(root.getValue());
				return contains(element, root.getRight());
			}
		}
		System.out.println("Not found!");
		return false;
	}

}
