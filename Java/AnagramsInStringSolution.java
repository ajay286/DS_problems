import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AnagramsInStringSolution {
	private int[] pCharArray = new int[26];

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		Arrays.fill(this.pCharArray, 0);

		for (char ch : p.toCharArray())
			pCharArray[this.charIndex(ch)] += 1;

		int pLength = p.length();

		for (int i = 0; i + pLength <= s.length(); ++i) {
			if (this.isAnagram(s.substring(i, i + pLength), pCharArray.clone())) {
				result.add(i);
			}
		}

		return result;
	}

	private int charIndex(char ch) {
		return (int) ch - (int) 'a';
	}

	private boolean isAnagram(String s, int[] pCharArrayCopy) {
		boolean result = true;
		for (int i = 0; i < s.length(); ++i) {
			int index = this.charIndex(s.charAt(i));
			pCharArrayCopy[index] -= 1;
		}

		for (int i : pCharArrayCopy) {
			if (i != 0)
				return false;
		}
		return result;
	}

	public static void main(String[] args) {
		AnagramsInStringSolution sol = new AnagramsInStringSolution();
		System.out.println(sol.findAnagrams("abbaabacab", "ab"));

	}
}
