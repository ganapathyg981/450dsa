package string;

public class String2 {

	public static void main(String[] args) {
		String ip="abba";
		palindrome(ip);

	}
	static void palindrome(String ip) {
		int start=0;
		int end=ip.length()-1;
		for(int i=0;i<ip.length()/2;i++) {
			if(ip.charAt(start)!=ip.charAt(end)) {
				System.out.println(" not Panlindrome");
				return;
			}
			start++;
			end--;
			
		}
		System.out.println("Panlindrome");
	
	
	}
	
}
