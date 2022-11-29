import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	private static  MorseCodeTree tree = new MorseCodeTree();
	public MorseCodeConverter() {
		 tree = new MorseCodeTree();
	}
	/**
	 *
	 * @param code - the code
	 * @return the english translation
	 */
	public static String convertToEnglish(String code) {
		String e ="";
		String[] temp = code.split("/");
		String[] l;
		for(int i =0; i < temp.length; i++) {
			l = temp[i].split(" ");
			for(int j=0; j < l.length; j++) {
				e += tree.fetch(l[j]);
			}
			e = e+ " ";
		}
		return e.trim();
	}
	/**
	 * 
	 * @param codeFile - name of the file that has the code
	 * @return the translated version
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		
		Scanner input = new Scanner(codeFile);
		 
		return convertToEnglish(input.nextLine());
	}
	public static String printTree() {
		String temp ="";
		ArrayList<String> list = tree.toArrayList();
		for(int i=0; i < list.size(); i++) {
			temp += list.get(i) + " ";
		}
		return temp.trim();
		
	}
}
