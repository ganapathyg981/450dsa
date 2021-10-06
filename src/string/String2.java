package string;

public class String2 {

	public static void main(String[] args) {
		String ip="abba";
		palindrome(ip);

	}
	static void palindrome(String ip) {
		int start=0;
		int end=ip.length()-1;
		int count=0;
		for(int i=0;i<ip.length()/2;i++) {
			if(ip.charAt(start)!=ip.charAt(end))
				count++;
			start++;
			end--;
			
		}
		if(count==0)
			System.out.println("Palindrome");
		else
			System.out.print("Not A Palindrome");
	}
	
}
