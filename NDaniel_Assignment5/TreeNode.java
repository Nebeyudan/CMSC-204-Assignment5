
public class TreeNode<T> {
	/**
	 * private attributes
	 */
	private T data;
	private TreeNode<T> right;
	private TreeNode<T> left;
	/**
	 * Creates a TreeNOde with both left and right children
	 * @param dataNode- the data stored
	 */
	public TreeNode(T dataNode) {
		setRight(null);
		left = null;
		data = dataNode;
	}
	/**
	 * TreeNode constructor that is used to make deep 
	 * copies 
	 * @param node - used to make the deep copies of
	 * left and right.
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.data;
		setRight(new TreeNode<T>(node.getRight()));
		left = new TreeNode<T>(node.left);
	}
	public T getData() {
		return data;
	}
	public TreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	public TreeNode<T> getRight() {
		return right;
	}
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
}
