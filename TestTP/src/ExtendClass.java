public class ExtendClass extends TestClass
{
	public static String state;
	
	public static void Enemy()
	{
		state = "evil";
	}
	
	public void Enemy(String State)
	{
		state = State;
	}
	
	public void MyState()
	{
		System.out.println("Im extend class my State is " + state + " I can use metods from TestClass");
	}
}
