/** Deren Singh - Ms. Stowe
 * This class is a treenode class. It holds a value and points to two other
 * tree nodes which are right and left.
 */
package binarytree;

public class TreeNode<T> {

	private TreeNode<T> left, right;//Left and right tree nodes connecting to this one
	private T value;//Treenode value

	/** Special constructor to set instance variables
	 * @param initValue
	 * @param initLeft
	 * @param initRight
	 */
	public TreeNode(T initValue, TreeNode<T> initLeft, TreeNode<T> initRight){
		value = initValue;
		left = initLeft;
		right = initRight;
	}

	/** Default constructor to set value and initialize nodes
	 * @param initValue
	 */
	public TreeNode(T initValue){
		value = initValue;
		left = null;
		right = null;
	}

	/** Get the node's value
	 * @return - value
	 */
	public T getValue(){return value;}

	/** Get the left tree node connected to this one
	 * @return - left
	 */
	public TreeNode<T> getLeft(){return left;}
	
	/** Get the right tree node connected to this one
	 * @return - right
	 */
	public TreeNode<T> getRight(){return right;}

	/** Set the node's value
	 * @param value - new node value
	 */
	public void setValue(T value){this.value = value;}

	/** Set the left tree node
	 * @param node = new left node
	 */
	public void setLeft(TreeNode<T> node){left = node;}
	
	/** Set the right tree node
	 * @param node = new right node
	 */
	public void setRight(TreeNode<T> node){right = node;}

}
