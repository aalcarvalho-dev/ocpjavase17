package cap1ex7;
public class River{
	float temp = 50;
	public void flow(){
		for (int i=0; i < 1; i++){
			temp--;
		}
		System.out.println(temp);
	}
	public static void main(String... args){
		new River().flow();
	}
}
