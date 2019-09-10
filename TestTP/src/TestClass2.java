public class TestClass2 implements TestInterface
{
	private static String name;
	private static Double hp;
	
	@Override
	public void Parametrs(String Name, Double Hp)
	{
		name = Name;
		hp = Hp;
	}
	
	@Override
	public void OutputInf() 
	{
		// TODO Auto-generated method stub
		System.out.println("My name is " + name + " And my hp = " + hp + " Im second CLASS");
	}

}
