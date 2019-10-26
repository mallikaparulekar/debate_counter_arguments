#Query to Wit.ai NLP

import java.io.*;
import org.json.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WitNLPQuery {
	
	public static boolean parseJsonResponseForEntities(String response) {
		JSONObject obj = new JSONObject(response);
		JSONObject entities = obj.getJSONObject("entities"); //.getString("pageName");

		if (!entities.isEmpty()) {
			//System.out.println(entities);
			return true;
		}
		return false;
	}
	
	public static String getCommand(String input) throws Exception {
		String url = "https://api.wit.ai/message";
		String key = "5QKDRSVTRBVAZCYPYEBON6HKUDJZZS6Z";
		
		String charset = "UTF-8";
		
		String encodedInput = URLEncoder.encode(input, charset);
		String query = String.format("q=%s", encodedInput);
		String fullUrl = url + "?" + query;
		System.out.println("Sentence = " + input);
		URLConnection connection = new URL(fullUrl).openConnection();
		connection.setRequestProperty ("Authorization", "Bearer "+key);
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Accept-Charset", charset);
		BufferedReader br = new BufferedReader(new InputStreamReader(
	            (connection.getInputStream())));
		String output;
        while ((output = br.readLine()) != null) {
            if (parseJsonResponseForEntities(output)) {
            	System.out.println("Negations Found:\n" + output + "\n");
            };
        }
		return "";
	}
	
	public static void main(String args[])  throws Exception {
		String sentence;
		Scanner sc = new Scanner(new File("Textfolder/sampleInput.txt"));
		//Scanner sc = new Scanner(new File("Textfolder/short.txt"));
		while ((sentence = nextSentence(sc)) != null)  {
			getCommand(sentence);
		}
		
	}
	
	public static String nextSentence(Scanner sc) {
		if (!sc.hasNext()) {
			return null;
		}
		String senten = "";
		ArrayList<String> exceptabbrev= new ArrayList<String>();
		exceptabbrev.add("Mr.");
		exceptabbrev.add("Mrs.");
		exceptabbrev.add("U.S.");
		while(sc.hasNext()){
			String s = sc.next();
			senten = senten + s + " "; 
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



