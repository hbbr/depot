import junit.framework.*;

public class TestYinsh extends TestCase{
	public TestYinsh(String color){ super(color);}
	
	public void test1()
	{
		Yinsh c= new Yinsh();
		assertTrue(c.current_color() == Yinsh.Color.BLACK ||
		c.current_color() == Yinsh.Color.WHITE );
	}	
}
