package Lecture12;

import java.util.ArrayList;

public class keyPad {

	public static void main(String[] args) {
		String s = "20";
		System.out.println(returnKey(s));
		System.out.println("******");
		PrintKeypadCombinations(s, "");
	}

	public static ArrayList<String> returnKey(String s) {
		if (s.equals("")) {
			ArrayList<String> getbase = new ArrayList<>();
			getbase.add("");
			return getbase;
		}

		char cc = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> recResult = returnKey(ros);
		ArrayList<String> myResult = new ArrayList<>();
		String code = Code(cc);
		for (int i = 0; i < recResult.size(); i++) {
			for (int j = 0; j < code.length(); j++) {
				String my = code.charAt(j) + recResult.get(i);
				myResult.add(my);
			}
		}

		return myResult;
	}

	public static String Code(char cc) {
		String retVal = "";
		switch (cc) {
		case '1':
			retVal = "abc";
			break;
		case '2':
			retVal = "def";
			break;
		case '3':
			retVal = "ghi";
			break;
		case '4':
			retVal = "jkl";
			break;
		case '5':
			retVal = "mno";
			break;
		case '6':
			retVal = "pqr";
			break;
		case '7':
			retVal = "stu";
			break;
		case '8':
			retVal = "vwx";
			break;
		case '9':
			retVal = "yz";
			break;
		case '0':
			retVal = ".#";
			break;
		default:
			retVal = "";

		}
		return retVal;
	}

	public static void PrintKeypadCombinations(String s, String osf) {

		if (s.length() == 0) {
			System.out.println(osf);
			return;
		}

		
			char cc = s.charAt(0);
			String code = Code(cc);
			String ros = s.substring(1);
			for (int j = 0; j < code.length(); j++) {

				PrintKeypadCombinations(ros, osf + code.charAt(j));
			}

		
	}
}
