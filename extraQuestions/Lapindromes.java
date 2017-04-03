package extraQuestions;

import java.util.HashMap;
import java.util.Scanner;

public class Lapindromes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		scn.nextLine();
		boolean isFound;
		boolean printed = false;
		//codechef solution
//		Consider the following pseudocode: 
//			bool isLapin(S)
//			    initialize cntL[] and cntR[] with 0
//			    L = S.length()
//			    for(i = 0; i < L/2; i++)
//			        cntL[S[i]-'a']++
//			    for(i = (L+1)/2; i < L; i++)
//			        cntR[S[i]-'a']++
//			    bool ret = true
//			    for(c = 0; c < 26; c++)
//			        if(cntL[c] != cntR[c])
//			            ret = false
//			    return ret
//
//			The time complexity for this is O(|S| + 26) per test-case.

		for (int i = 0; i < T; i++) {
			String input = scn.nextLine();
			HashMap<Character, Integer> map = new HashMap<>();
			for (int j = 0; j < input.length() / 2; j++) {
				if (map.containsKey(input.charAt(j))) {
					int ov = map.get(input.charAt(j));
					map.put(input.charAt(j), ov + 1);
				} else {
					map.put(input.charAt(j), 1);
				}

			}
			boolean isPrinted = false;
			int idx = input.length() - 1;
			for (int j = input.length() / 2; j > 0; j--, idx--) {
				if (!map.containsKey(input.charAt(idx))) {
					System.out.println("NO");
					isPrinted = true;
					break;
				} else {
					if (map.get(input.charAt(idx)) == 1) {
						map.remove(input.charAt(idx));
					} else {
						int ov = map.get(input.charAt(idx));
						map.put(input.charAt(idx), ov - 1);
					}

				}
			}
			if (!isPrinted) {
				System.out.println("YES");
			}

		}
	}

}
