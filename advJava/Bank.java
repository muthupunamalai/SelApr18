package advJava;

public abstract class Bank {
	public static void main(String[] args) {
		//Bank b = new Bank();
		SBIN b = new SBIN();
		b.desc();
		b.getInterestRate();
	}
	
	public void desc() {
		System.out.println("Description");
	}
	public abstract void getInterestRate();
}





