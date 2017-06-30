
class Arrays_Strings{
	
	public static void main (String[] args){
		
		/*Test for unique chars*/
		String test = "idjwee";
		if (checkUniqueChars(test)){
			System.out.println("String has all unique characters");
		}else{
			System.out.println("String has repeated characters");
		}
		
		/*Test for reverse string*/
		System.out.println("Reversed string: " + reverseString(test));
		
		/*Test for fib*/
		System.out.println("fib(10): " + fib(10));
		
		/*Test for multiplication table*/
		multTables(12);
		
		System.out.println();
		
		/*Test for print odd*/
		printOdd();
		
		System.out.println();
		
		/*Test for largest value*/
		int[] inputArray = {23, 32, 54, 934, 2, -12, 84};
		System.out.println("largest value: " + largestValue(inputArray));
		
		System.out.println();
		
		/*Test for convert to hex*/
		System.out.println("RGB to hex: " + formatRGB(23, 6, 48));
		
		
	}

	/*Implement an algorithm to determined if a string has all unique characters. No additional data structures?*/
	public static boolean checkUniqueChars (String s){
		
		/*Assume char set is ASCII, if not we would need to increase storage size*/
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < s.length(); i++){
			int val = s.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		
		/*Time complexity: O(n) where n is length of the string
		  Space complexity: O(n)*/
		
		return true;
		
		
	}
	
	/*Write code to reverse a String. */
	public static String reverseString(String s){
		
		char[] chars = s.toCharArray();
		int length = s.length();
		int last = length - 1;
		
		/* s = "hello" 
		char c = 'h'*
		chars[0] = 'o'
		chars[4] = 'h'*/
		for (int i = 0; i < length/2; i++){
			char c = chars[i];
			chars[i] = chars[last - i];
			chars[last - i] = c;
		}
		
		return new String(chars);
		
	}
	
	/*Remove duplicate characters in a string without using any additional buffer*/
	public static void removeDuplicates(char[] str){
		if (str == null)
			return;
		int length = str.length;
		if (length < 2) return;
		
		int tail = 1;
		for (int i = 1; i < length; ++i){
			int j;
			for (j = 0; j < tail; ++j){
				/*if next character is equal to curr character*/
				if (str[i] == str[j])
					break;
			}
			if (j == tail){
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	}
	
	
	
	
	
	
	
	
	/*Problems from online*/
	
	/*Computer nth fibonacci number*/
	public static long fib(int n){
		return n<=1 ? n : fib(n-1) + fib(n-2);
	}
	
	/*Print out the grade-school multiplication table up to 12x12.*/
	public static void multTables (int max){
		for (int i = 1; i <= max; i++){
			for (int j = 1; j <= max; j++){
				System.out.print(String.format("%4d", j*i));
			}
			System.out.println();
		}
	}
	
	/*Write function to print the odd numbers from 1 to 99.*/
	public static void printOdd(){
		for (int i = 1; i <= 99; i+=2){
			System.out.print(i + ", ");
			
		}
	}
	
	/*Find the largest int value in an int array.*/
	public static int largestValue (int[] input){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++){
			if (input[i] > max) 
				max = input[i];
		}
		return max;
	}
	
	/*Format an RGB value (three 1-byte numbers) as a 6-digit hexadecimal string.*/
	public static String formatRGB(int r, int g, int b){
		return (toHex(r) + toHex(g) + toHex(b)).toUpperCase();
	}
	public static String toHex(int c){
		String s = Integer.toHexString(c);
		return (s.length() == 1) ? "0" + s : s;
	}
	
	
}
