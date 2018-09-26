/** Deren Singh - Ms. Stowe
 * This class is an interface that should be implemented whenever creating
 * a binary tree. It has all methods needed for a binary tree.
 */
package binarytree;

public interface BinaryTreeADT <T>{
	
	/** Get root of node
	 * @return - node root
	 */
	public TreeNode<T> getRoot();
	
	/** Set the root of node
	 * @param newNode - new root
	 */
	public void setRoot(TreeNode<T> newNode);
	
	/** Check if tree is empty
	 * @return - boolean whether tree is empty or not
	 */
	public boolean isEmpty();
	
	/** Add element to tree
	 * @param element - item added to tree
	 */
	public void add(T element);
	
	/** Check is specific object is in tree
	 * @param element - object getting checked
	 * @return - boolean whether object is in tree or not
	 */
	public boolean contains(T element);
	
	/** Print out the tree in pre order
	 * @param root - the root getting printed
	 * @return - tree in pre order 
	 */
	public String preOrder(TreeNode<T> root);
	
	/** Print out the tree in order
	 * @param root - the root getting printed
	 * @return - tree in order 
	 */
	public String inOrder(TreeNode<T> root);
	
	/** Print out the tree in post order
	 * @param root - the root getting printed
	 * @return - tree in post order 
	 */
	public String postOrder(TreeNode<T> root);
	
	/** Print out the tree in level order
	 * @param root - the root getting printed
	 * @return - tree in level order 
	 */
	public String levelOrder(TreeNode<T> root);
	
}
