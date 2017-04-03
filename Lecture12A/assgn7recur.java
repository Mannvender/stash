package Lecture12A;

public class assgn7recur {

	public static void main(String[] args) {
		// String s = "120";
		// System.out.println(SumOfDigitsOfString(s));
		// **********
		// String s1 = "2ab(c";
		// String s2 = "c(ba2";
		// System.out.println(reverseOrNot(s1, s2));
		// **********
		// String s=")(123hh321()";
		// System.out.println(isStringPalindrome(s));
		// ***********
		// String s = "helllo";
		// System.out.println(AddStarforConsicutive(s));
		// ***********
		// String s = "hhellloo";
		// System.out.println(RemoveforConsicutive(s));
		// ***********
		 //String s="xabcxghgxmnox";
		// System.out.println(moveAllXtoEnd(s));
		// ***********
		// String s=" hi ,hiand *h";
		// System.out.println(countHI(s));
		// ***********
		// String s="iiihiiihhi";
		// System.out.println(RemoveHI(s));
		// ***********
		// String s="hihellohi";
		// System.out.println(RemoveHIaddBYE(s));
		// ***********
		// String s="hi, hitandhi";
		// System.out.println(countHInotHIT(s));
		// ***********
		// String s="hi, hitandhi";
		// System.out.println(RemoveHInotHIT(s));
		// ***********
		// String s = "hi, hitandhi";
		// System.out.println(RemoveHIaddBYEnotHIT(s));
		// ***********
		// String s = "axaxa";
		// System.out.println(CountTwins(s));
		// ***********
		// String s="aaaa2aa";
		// System.out.println(CountAAA(s));
		// ***********
		// needs fixing
		// String s = "aaa,aaaa,aaaaa,aaaaaa,aaaaaaa";
		// System.out.println(CountAAAnotOverlapping(s));
		// ***********
		// String s = "1123";
		// possibleCodesForIntegerString(s, "");
		// ***********
		// String s = "abbaaaabba";
		// System.out.println(StringUsingStrangeRules(s));
		// ***********
		// String s = "xyz45(abc)";
		// System.out.println(BetweenParenthesis(s));
		// ***********
		String s = "(((a+b))";
		System.out.println(areBracketsBalanced(s));
	}

	public static int SumOfDigitsOfString(String s) {
		if (s.equals("")) {
			return 0;
		}
		int retVal = 0;
		char cc = s.charAt(0);
		int intcc = cc - '0';
		String ros = s.substring(1);
		int recurVal = SumOfDigitsOfString(ros);
		retVal = recurVal + intcc;
		return retVal;
	}

	public static boolean reverseOrNot(String s1, String s2) {
		if (s1.equals("")) {
			return true;
		}

		char ccs1 = s1.charAt(0);
		String s1ros = s1.substring(1);
		char ccs2 = s2.charAt(s2.length() - 1);
		String s2ros = s2.substring(0, s2.length() - 1);
		if (ccs1 != ccs2) {
			return false;
		} else {
			boolean answer = reverseOrNot(s1ros, s2ros);
			return answer;
		}

	}

	public static boolean isStringPalindrome(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		char first = s.charAt(0);
		char last = s.charAt(s.length() - 1);
		if (first != last) {
			return false;
		} else {
			String ros = s.substring(1, s.length() - 1);
			boolean ans = isStringPalindrome(ros);
			return ans;
		}
	}

	public static String AddStarforConsicutive(String s) {
		if (s.length() == 1) {
			String last = "" + s.charAt(0);
			return last;
		}
		char cc = s.charAt(0);
		String ret = "";
		ret = ret + cc;

		if (cc == s.charAt(1)) {
			ret = ret + "*";
		}
		String recurRet = AddStarforConsicutive(s.substring(1));
		ret = ret + recurRet;

		return ret;
	}

	public static String RemoveforConsicutive(String s) {
		if (s.length() == 1) {
			String last = "" + s.charAt(0);
			return last;
		}
		char cc = s.charAt(0);
		String ret = "";

		if (cc != s.charAt(1)) {
			ret = ret + cc;
		}
		String recurRet = RemoveforConsicutive(s.substring(1));
		ret = ret + recurRet;

		return ret;
	}

	public static String moveAllXtoEnd(String s) {
		if (s.equals("")) {
			return "";
		}
		char cc = s.charAt(0);
		String notx = "";
		String xcontainer = "";
		if (cc != 'x') {
			notx = notx + cc;
		} else {
			xcontainer = xcontainer + "x";
		}
		String recur = moveAllXtoEnd(s.substring(1));
		return notx + recur + xcontainer;

	}

	public static int countHI(String s) {
		if (s.length() == 1) {
			return 0;
		}
		char cc = s.charAt(0);
		int count = 0;
		if (cc == 'h' && s.charAt(1) == 'i') {
			count++;
		}
		String ros = s.substring(1);
		int retRecur = countHI(ros);
		return retRecur + count;

	}

	public static String RemoveHI(String s) {
		if (s.length() == 1) {
			String base = "" + s.charAt(0);
			return base;
		}
		if (s.length() == 2 && s.charAt(1) == 'i' && s.charAt(0) == 'h') {
			return "";
		}
		char cc = s.charAt(0);
		String ret = "";
		String ros = "";
		if (cc == 'h' && s.charAt(1) == 'i') {
			ros = s.substring(2);

		} else {
			ret = ret + cc;
			ros = s.substring(1);
		}
		String recurReturn = RemoveHI(ros);
		return ret + recurReturn;
	}

	public static String RemoveHIaddBYE(String s) {
		if (s.length() == 1) {
			String base = "" + s.charAt(0);
			return base;
		}
		if (s.length() == 2 && s.charAt(1) == 'i' && s.charAt(0) == 'h') {
			return "bye";
		}
		char cc = s.charAt(0);
		String ret = "";
		String ros = "";
		if (cc == 'h' && s.charAt(1) == 'i') {
			ros = s.substring(2);
			ret = ret + "bye";

		} else {
			ret = ret + cc;
			ros = s.substring(1);
		}
		String recurReturn = RemoveHIaddBYE(ros);
		return ret + recurReturn;
	}

	public static int countHInotHIT(String s) {
		if (s.length() == 1) {
			return 0;
		}
		if (s.length() == 2 && s.charAt(1) == 'i' && s.charAt(0) == 'h') {
			return 1;
		}
		char cc = s.charAt(0);
		int count = 0;
		if (cc == 'h' && s.charAt(1) == 'i' && s.charAt(2) != 't') {
			count++;
		}
		String ros = s.substring(1);
		int retRecur = countHInotHIT(ros);
		return retRecur + count;

	}

	public static String RemoveHInotHIT(String s) {
		if (s.length() == 1) {
			String base = "" + s.charAt(0);
			return base;
		}
		if (s.length() == 2 && s.charAt(1) == 'i' && s.charAt(0) == 'h') {
			return "";
		}
		char cc = s.charAt(0);
		String ret = "";
		String ros = "";
		if (cc == 'h' && s.charAt(1) == 'i' && s.charAt(2) != 't') {
			ros = s.substring(2);

		} else {
			ret = ret + cc;
			ros = s.substring(1);
		}
		String recurReturn = RemoveHInotHIT(ros);
		return ret + recurReturn;
	}

	public static String RemoveHIaddBYEnotHIT(String s) {
		if (s.length() == 1) {
			String base = "" + s.charAt(0);
			return base;
		}
		if (s.length() == 2 && s.charAt(1) == 'i' && s.charAt(0) == 'h') {
			return "bye";
		}
		char cc = s.charAt(0);
		String ret = "";
		String ros = "";
		if (cc == 'h' && s.charAt(1) == 'i' && s.charAt(2) != 't') {
			ros = s.substring(2);
			ret = ret + "bye";

		} else {
			ret = ret + cc;
			ros = s.substring(1);
		}
		String recurReturn = RemoveHIaddBYEnotHIT(ros);
		return ret + recurReturn;
	}

	public static int CountTwins(String s) {
		if (s.length() == 2) {
			return 0;
		}
		int count = 0;
		char first = s.charAt(0);
		char third = s.charAt(2);
		if (first == third) {
			count++;
		}
		int recResult = CountTwins(s.substring(1));
		return count + recResult;
	}

	public static int CountAAA(String s) {
		if (s.length() == 2) {
			return 0;
		}
		int count = 0;
		if (s.charAt(0) == 'a' && s.charAt(1) == 'a' && s.charAt(2) == 'a') {
			count++;
		}
		int recResult = CountAAA(s.substring(1));

		return count + recResult;
	}

	// fix it
	public static int CountAAAnotOverlapping(String s) {
		if (s.length() == 4 && s.charAt(0) != 'a' && s.charAt(1) == 'a' && s.charAt(2) == 'a' && s.charAt(3) == 'a') {
			return 1;
		}

		if (s.length() == 3 && s.charAt(0) == 'a' && s.charAt(1) == 'a' && s.charAt(2) == 'a') {
			return 1;
		}
		if (s.length() == 2) {
			return 0;
		}
		int count = 0;

		boolean wasLastA = false;
		char lastchar = s.charAt(0);
		if (lastchar == 'a') {
			wasLastA = true;
		}
		if (s.charAt(1) == 'a' && s.charAt(2) == 'a' && s.charAt(3) == 'a' && s.charAt(4) != 'a' && !wasLastA) {
			count++;

		}
		int recResult = CountAAAnotOverlapping(s.substring(1));

		return count + recResult;
	}

	public static void possibleCodesForIntegerString(String s, String osf) {
		if (s.length() == 0) {
			System.out.println(osf);
			return;
		}
		if (s.length() == 1) {
			int base = s.charAt(0) - '0';
			osf = osf + (ReturnCode(base));
			System.out.println(osf);
			return;
		}
		if (s.length() == 2) {
			int base = s.charAt(0) - '0';
			int base2 = s.charAt(1) - '0';
			possibleCodesForIntegerString(s.substring(1), osf + ReturnCode(base));
			if(base * 10 + base2<=26){
				possibleCodesForIntegerString("", osf + ReturnCode(base * 10 + base2));
			}
			
			return;

		}
		int cc = s.charAt(0) - '0';
		int cc2 = s.charAt(1) - '0';
		String ros = s.substring(1);

		String ros2 = s.substring(2);

		possibleCodesForIntegerString(ros, osf + ReturnCode(cc));
		if (cc*10 + cc2 <= 26) {
			possibleCodesForIntegerString(ros2, osf + ReturnCode(cc * 10 + cc2));
		}
		
	}

	// helping code for possibleCodesforIntegers
	public static String ReturnCode(int cc) {
		String retVal = "";
		switch (cc) {
		case 1:
			retVal = "a";
			break;
		case 2:
			retVal = "b";
			break;
		case 3:
			retVal = "c";
			break;
		case 4:
			retVal = "d";
			break;
		case 5:
			retVal = "e";
			break;
		case 6:
			retVal = "f";
			break;
		case 7:
			retVal = "g";
			break;
		case 8:
			retVal = "h";
			break;
		case 9:
			retVal = "i";
			break;
		case 10:
			retVal = "j";
			break;
		case 11:
			retVal = "k";
			break;
		case 12:
			retVal = "l";
			break;
		case 13:
			retVal = "m";
			break;
		case 14:
			retVal = "n";
			break;
		case 15:
			retVal = "o";
			break;
		case 16:
			retVal = "p";
			break;
		case 17:
			retVal = "q";
			break;
		case 18:
			retVal = "r";
			break;
		case 19:
			retVal = "s";
			break;
		case 20:
			retVal = "t";
			break;
		case 21:
			retVal = "u";
			break;
		case 22:
			retVal = "v";
			break;
		case 23:
			retVal = "w";
			break;
		case 24:
			retVal = "x";
			break;
		case 25:
			retVal = "y";
			break;
		case 26:
			retVal = "z";
			break;
		default:
			retVal = "";

		}
		return retVal;
	}

	public static boolean StringUsingStrangeRules(String s) {

		if (s.length() == 1) {
			if (s.charAt(0) != 'a') {
				return false;
			} else {
				return true;
			}
		}
		String ros = "";
		boolean isItRight = true;
		char cc = s.charAt(s.length() - 1);
		char cc2 = s.charAt(s.length() - 2);

		if (cc == 'a' || cc == 'b' && cc2 == 'b') {
			isItRight = true;
			if (cc == 'a') {
				ros = s.substring(0, s.length() - 1);
			} else {
				ros = s.substring(0, s.length() - 2);
			}
		} else {
			return false;
		}

		boolean recurResult = StringUsingStrangeRules(ros);

		return recurResult;
	}

	public static String BetweenParenthesis(String s) {
		if (s.length() == 0) {
			return "";
		}

		if (s.length() == 1) {
			return "";
		}

		char cc = s.charAt(0);

		if (cc != '(') {
			String frontFine = BetweenParenthesis(s.substring(1));
			return frontFine;
		} else {
			String frontFine = s;
			char ccend = frontFine.charAt(frontFine.length() - 1);

			if (ccend != ')') {
				String withP = BetweenParenthesis(frontFine.substring(0, frontFine.length() - 1));
				return withP;
			} else {
				String withP = s;
				return withP.substring(1, withP.length() - 1);
			}
		}

	}

	public static boolean areBracketsBalanced(String s) {
		if (s.length() == 0) {
			return true;
		}
		if (s.length() == 1) {
			if (s.charAt(0) == '{' || s.charAt(0) == '}' || s.charAt(0) == '[' || s.charAt(0) == ']'
					|| s.charAt(0) == '(' || s.charAt(0) == ')') {
				return false;
			} else {
				return true;
			}

		}
		char cc = s.charAt(0);
		if (cc == '[' || cc == '{' || cc == '(') {
			if (cc == '[') {
				char ccend = s.charAt(s.length() - 1);
				if (ccend == ']') {
					boolean r1 = areBracketsBalanced(s.substring(1, s.length() - 1));
					return r1;
				} else {
					boolean r2 = false;
					if (ccend == cc) {
						return r2;
					} else {
						r2 = areBracketsBalanced(s.substring(0, s.length() - 1));
						return r2;
					}
				}
			}
			if (cc == '{') {
				char ccend = s.charAt(s.length() - 1);
				if (ccend == '}') {
					boolean r1 = areBracketsBalanced(s.substring(1, s.length() - 1));
					return r1;
				} else {
					boolean r2 = false;
					if (ccend == cc) {
						return r2;
					} else {
						r2 = areBracketsBalanced(s.substring(0, s.length() - 1));
						return r2;
					}
				}
			}
			if (cc == '(') {
				char ccend = s.charAt(s.length() - 1);
				if (ccend == ')') {
					boolean r1 = areBracketsBalanced(s.substring(1, s.length() - 1));
					return r1;
				} else {
					boolean r2 = false;
					if (ccend == cc) {
						return r2;
					} else {
						r2 = areBracketsBalanced(s.substring(0, s.length() - 1));
						return r2;
					}

				}
			}
		} else {
			boolean r3 = areBracketsBalanced(s.substring(1));
			return r3;
		}
		return false;
	}
}
