public class StringPatternRabinKarp {

	public boolean rabinKarpAlgorithm(String pattern, String targetString) {
		if (pattern.length() > targetString.length()
				|| (pattern.length() == targetString.length() && !targetString.equals(pattern))) {
			return false;
		}

		boolean result = false;
		long hashOfSource = this.hashFuntion(pattern);
		int lenOfSource = pattern.length();
		long hashOfTarget = this.hashFuntion(targetString.substring(0, lenOfSource));
		char[] charArray = targetString.toCharArray();

		if (hashOfSource == hashOfTarget)
			return true;

		for (int i = lenOfSource; i < charArray.length; ++i) {
			int first = i - lenOfSource;

			hashOfTarget = (long) ((hashOfTarget - (int) charArray[first] * Math.pow(10, lenOfSource - 1)) * 10
					+ (int) charArray[i]);
			if (hashOfSource == hashOfTarget)
				return true;
		}

		return result;
	}

	public long hashFuntion(String inputString) {
		long hashedValue = 0;
		char[] charArray = inputString.toCharArray();
		int length = charArray.length - 1;

		for (int i = 0; i < charArray.length; ++i) {
			hashedValue += (int) charArray[i] * Math.pow(10, length);
			length -= 1;
		}

		return hashedValue;
	}

	public static void main(String[] args) {
		String pattern = "GEEKS";
		String targetString = "GEEKS FOR GEEKS";
		StringPatternRabinKarp patternSolution = new StringPatternRabinKarp();
		System.out.println(String.format("Does-> {%s} present into {%s}, Result -> %s ", pattern,
				targetString, patternSolution.rabinKarpAlgorithm(pattern, targetString)));
	}

}
