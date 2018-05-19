package string;

public class L_String {

	public static void main(String[] args) {		
		
		char var;
		int num;
		
		String txt = "testleafttt";
		//char ch = 'T';
		int count = 0;
		char[] charArray = txt.toCharArray();
		for (char c : charArray) {
			if (c=='t'||c=='T') {
				count++;
			}
		}
		System.out.println(count);
		/*
		  String txt = "a1b2c3";
		  char[] x = txt.toCharArray();
		for (int i = 0; i < x.length; i++) {
			num = (int)txt.charAt(i);
			var = (char)(num+1);
			System.out.print(var);
		}
		System.out.println();*/
		
		
		
		/*String txt1 = "Welcome,to,Java,World";

		
		System.out.println(txt1.replace(",", "-"));
		char ch= 'a';
		int n=ch;
		n=n+1;
		ch=(char)n;
		System.out.println(ch);
		
		//System.out.println(txt1.contains("r"));
		*/
		
		
		/*String[] split = txt1.split(",");
		for (String eachWord : split) {
			System.out.println(eachWord);
		}*/
		
		//String txt2 = new String("TestLeaf");		
		
		
		//System.out.println(txt2.toLowerCase());
		//System.out.println(txt2.toUpperCase());		
		//System.out.println(txt2);
		
		//System.out.println(txt2.trim());
		//System.out.println(txt2.substring(4));
		
		
		
		
		
		
		
		
		
		/*char[] ch = txt2.toCharArray();
		Integer in = new Integer(10);
	
		System.out.println(in.toString()+10);
	*/
		
		
		
		
		
		
		
		
		//	System.out.println(txt1.concat(txt2));

		//	System.out.println(txt2.lastIndexOf("e"));

		//	System.out.println(txt2.charAt(5));

		/*for (int i = 0; i < ch.length; i++) {
			System.out.println(ch[i]);
		}

		System.out.println(txt2.length());*/




	}

}
