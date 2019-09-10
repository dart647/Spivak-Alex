
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestInterface A = new TestClass();
		TestInterface B = new TestClass2();
		ExtendClass C = new ExtendClass();
		
		A.Parametrs("Player1", 100.);
		B.Parametrs("Player2", 500.);
		
		A.OutputInf();
		B.OutputInf();
		
		C.Parametrs("Enemy", 1.);
		C.Enemy("evil");
		C.MyState();
		C.OutputInf();
	}

}
