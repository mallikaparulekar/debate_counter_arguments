#In progress Java Code
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Contradictions {

	public static void main(String[] args) throws Exception{

		// sample text file containing evidence
		Scanner sc = new Scanner(new File("Textfolder/sampleInput.txt"));
		ArrayList<String> sentence;

		// list of contradicting words
		ArrayList<String> contra= new ArrayList<String>();
		contra.add("But");
		contra.add("However,");
		contra.add("However");
		contra.add("Yet,");	

		while ((sentence = nextSentence(sc)) != null) {
			for (int i = 0; i < sentence.size(); i ++){
				if (contra.contains(sentence.get(i)) || (sentence.get(i).equals("In")&& sentence.get(i+1).equals("spite"))){
					System.out.println("");
					System.out.println("");
				}
				System.out.print(sentence.get(i)+ " ");
			}
			System.out.println("");
		}
	}

	public static ArrayList<String> nextSentence(Scanner sc) {
		if (!sc.hasNext()) {
			return null;
		}
		ArrayList<String> senten = new ArrayList<String>();
		ArrayList<String> exceptabbrev= new ArrayList<String>();
		exceptabbrev.add("Mr.");
		exceptabbrev.add("Mrs.");
		exceptabbrev.add("U.S.");
		while(sc.hasNext()){
			String s = sc.next();
			senten.add(s); 
			if (s.endsWith(".") && (!exceptabbrev.contains(s))) {
				break;
			}

			else if (s.contains(".") && (!exceptabbrev.contains(s))){
				break;
			}
		}
		return senten;
	}
}









