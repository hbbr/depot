import junit.framework.*;

public class TestYinsh extends TestCase{
	public TestYinsh(String color){ super(color);}
	
	public void test1()
	{
		Yinsh c= new Yinsh();
		assertTrue(c.current_color() == Yinsh.Color.BLACK ||
		c.current_color() == Yinsh.Color.WHITE );
	}	
	public void test2()
	{
		Yinsh nb= new Yinsh();
		assertTrue(nb.nbanneau==0);
	}
	public void test3()
	{
		Yinsh r= new Yinsh();
		assertTrue(r.put_ring('a',2,Yinsh.Case.ANoir) == Yinsh.Case.ANoir || r.put_ring('b',2,Yinsh.Case.ABlanc)==Yinsh.Case.ABlanc);
		assertTrue(r.nbanneau==1);	
	}	
	public void test4()
	{
		Yinsh execpt= new Yinsh();
		try {
		execpt.put_ring('a',1,Yinsh.Case.ANoir);
		assertTrue(false);
		}catch(IllegalArgumentException e){
		assertTrue(true);
		}
	}
	public void test5()
	{
		Yinsh tour= new Yinsh();
		try {
		tour.put_ring('a',4,Yinsh.Case.ANoir);
		tour.put_ring('b',5,Yinsh.Case.ANoir);
		assertTrue(false);
		}catch(IllegalArgumentException ex){
		assertTrue(true);
		}
	}

	

}
