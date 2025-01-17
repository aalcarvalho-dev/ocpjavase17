package textblox;
public class TextBlock{
	public static void main(String[] args){
		String eyeTest = "\"Java Study Guide\"\n  by Scott & Jeanne";
		System.out.println(eyeTest);
		String textBlock = """
		 "Java Study Guide"
		   by Scott & Jeanne""";
		System.out.println(textBlock);
		String pyramid = 
			"""
			  *
			 *
			*
			""";
		System.out.println(pyramid);
	}
}
