package advJava;

public class LearnStatic {
	int num = 10;
	static int num1;

	public static void main(String[] args) {
		System.out.println("print main");
		LearnStatic ls = new LearnStatic();
		/*LearnStatic lss = new LearnStatic();
		LearnStatic lsls = new LearnStatic();
		ls.counter();
		lss.counter();
		lsls.counter();*/

		ls.counter();

	}

	public void counter() {
		num++;
		num1++;
		System.out.println("non static "+num);
		System.out.println("static "+num1);
	}

	static {
		num1 = 15;
	}
















}
