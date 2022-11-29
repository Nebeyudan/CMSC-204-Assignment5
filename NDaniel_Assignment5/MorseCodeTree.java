import java.util.ArrayList;
/**
 * 
 * @author Nebeyu PC
 * This is a MorseTree class that changes morse code to english
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root;
	/**
	 * no arg constructor 
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	@Override
	/**
	 * returns the root node
	 * @return a reference to a root
	 */
	public TreeNode<String> getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	/**
	 *  sets the root to a new tree node
	 *  @param newNode - a node that we be the root of the morse tree
	 */
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		root = new TreeNode<>(newNode);
	}

	@Override
	/**
	 * adds elements to the correct position based on its code 
	 * which also calls the method addNode
	 * @param code - the code for the node 
	 */
	public void insert(String code, String result) {
		// TODO Auto-generated method stub
		addNode(root, code, result);
	}

	@Override
	/**
	 * a recursive method that adds a element to the correct 
	 * position by its code 
	 * @param root - the root of the tree for this current recursion
	 * @param code - the cood for this current recursion
	 * @param letter - data of the new tree
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub
		//base case
		if(code.length() ==1 ) {
			if(code.equals(".")) {
				root.setLeft(new TreeNode<>(letter));
			}
			else if(code.equals("-")) {
				root.setRight((new TreeNode<>(letter)));
			}
			
		}
		//Recursion case
		else if(code.length() > 1) {
			if(code.charAt(0)== '.' ) {
				addNode(root.getLeft(), code.substring(1),letter );
			}
			else if(code.charAt(0) == '-') {
				addNode(root.getRight(), code.substring(1), letter);
			}
		}
	}

	@Override
	/**
	 * fetches the data in the tree based on the code and calls
	 * the recursive method fetchNode
	 * @param code - the code that shows the traversal for the letter
	 * @return the letter for that code
	 */
	public String fetch(String code) {
		// TODO Auto-generated method stub
		return fetchNode(root, code);
	}

	@Override
	/**
	 * A recursive method that fetches the data of the tree by its code
	 * @param root - the root of the tree
	 * @param code - the code for this current recursion
	 * @return the letter for the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		String temp ="";
		//base casee
			if(code.length() == 1) {
				if(code.equals(".")) {
					temp = root.getLeft().getData();
				}
				else if(code.equals("-")) {
					temp = root.getRight().getData();
				}
			}
			//Recursion case
			else if(code.length()> 1) {
				if(code.charAt(0) =='.') {
					temp = fetchNode(root.getLeft(),code.substring(1));
				}
				else if(code.charAt(0) == '-') {
					temp = fetchNode(root.getRight(),code.substring(1));
				}
			}
		// TODO Auto-generated method stub
		return temp;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	/**
	 * this method builds the tree by adding the nodes
	 * level by level 
	 */
	public void buildTree() {
		// TODO Auto-generated method stub
		root = new TreeNode<>("");
		//level 1
				insert(".","e");
				insert("-","t");
				//level 2
				insert("..","i");
				insert(".-","a");
				insert("--","m");
				insert("-.","n");
				//level 3
				insert("...","s");
				insert("..-" ,"u");
				insert(".-.","r");
				insert(".--","w");
				insert("-..","d");
				insert("-.-","k");
				insert("---","o");
				insert("--.","g");
				//level 4
				insert("--..","z");
				insert("--.-","q");
				insert("-.--","y");
				insert("-.-.","c");
				insert("-...","b");
				insert("-..-","x");
				insert(".---","j");
				insert(".--.","p");
				insert(".-..","l");
				insert("..-.","f");
				insert("...-","v");
				insert("....","h");
				
	}

	@Override
	/**
	 * returns a list of items in the LinkedTree in orderT
	 * @returns a arrayList - of the items in the linkedTree
	 */
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root,list);
		return list;
	}

	@Override
	/**
	 * the recursive method to put it in order in a arrList
	 * @param root - the root of the tree for this recursive 
	 * @list list - the arraylist will hold the content of the tree
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if(root!= null) {
			LNRoutputTraversal(root.getLeft(),list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRight(),list);
		}
	}

}
