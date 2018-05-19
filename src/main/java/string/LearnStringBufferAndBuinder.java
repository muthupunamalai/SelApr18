package string;

public class LearnStringBufferAndBuinder {
	
	public static void main(String[] args) {
		
		String txt = "Test";
		StringBuffer buffer = new StringBuffer(txt);
		buffer.reverse();
		System.out.println(buffer);
		txt = buffer.toString();
		
		
		
		
		//System.out.println(txt);
		
		/*StringBuffer buffer = new StringBuffer("Test");
		buffer.append("Leaf");
		//System.out.println(buffer.insert(4, ' '));
		
		StringBuilder builder = new StringBuilder("Test");
		builder.append("Leaf");
		System.out.println(builder.insert(4, ' ').reverse());
		*/
		
		
		
		
		
	}
	
	
}
