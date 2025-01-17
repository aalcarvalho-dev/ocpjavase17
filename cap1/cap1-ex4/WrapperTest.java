package wrapping;
public class WrapperTest{
	public static void main(String[] args){
		int num1 = 5;
		int num2 = Integer.valueOf(6);
		Integer num4;
		int num5 = 2;
		Integer num3 = 7;
		num1 = num3;
		num4 = num5;
		System.out.println(num1);
		System.out.println(num4);
		int primitive = Integer.parseInt("123");
		Integer wrapper = Integer.valueOf("123");
		System.out.println(primitive);
		System.out.println(wrapper);
		Double apple = Double.valueOf(200.2);
		System.out.println(apple.intValue());
		System.out.println(apple.byteValue());
		System.out.println(apple.shortValue());
		System.out.println(apple.longValue());
		System.out.println(apple.floatValue());
		System.out.println(apple.doubleValue());
	}
}
