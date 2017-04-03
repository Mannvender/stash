package extraQuestions;

public class reverseAStringWordWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWordWise("Welcome to coding ninja"));

	}

	public static String reverseWordWise(String input) {
		// change> ek boolean leliya
		boolean firstTime = true;
		String temp = "";
		String ans = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			char s = input.charAt(i);
			temp = s + temp;
			if (input.charAt(i) == ' ') {
				// taki bus phle bar space na aaye
				if (firstTime) {
					temp = temp.substring(1);
					firstTime = !firstTime;
				}
				ans = ans + temp;
				temp = "";
			}
			if (i == 0) {
				ans = ans + " " + temp;
			}
		}
		return ans;
	}

}
