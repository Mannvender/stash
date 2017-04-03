package Lecture11;

public class string2Number {

	public static void main(String[] args) {
		String s="12346";
		System.out.println(s2n(s));

	}

	public static int s2n(String s) {
		if(s.length()==0){
			return 0;
		}
		int lastnum=s.charAt(s.length()-1)-'0';
		
	int retVal=	s2n(s.substring(0,s.length()-1));
	
	retVal=retVal*10+(lastnum);
		return retVal;
	}

}
