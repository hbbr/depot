import junit.framework.*;

public class TestYinsh extends TestCase{

	public TestYinsh(String color){ super(color);}
	// Test Histoire 1
	public void test1()
	{
		Yinsh c= new Yinsh();
		assertTrue(c.current_color() == Yinsh.Color.BLACK ||
		c.current_color() == Yinsh.Color.WHITE );
	}
	// Test Histoire 2.1	
	public void test2()
	{
		Yinsh nb= new Yinsh();
		assertTrue(nb.nbanneau==0);
	}

	// Test Histoire 2.2
	public void test3()
	{
		Yinsh r= new Yinsh();
		assertTrue(r.put_ring('b',2,Yinsh.Case.ANoir) == Yinsh.Case.ANoir || r.put_ring('c',2,Yinsh.Case.ABlanc)==Yinsh.Case.ABlanc);
		assertTrue(r.nbanneau==1);	
	}	
	// Test Histoire 2.3
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
	// Test Histoire 2.4
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
	// Test Histoire 3
	public void test6()
	{
		Yinsh memepos = new Yinsh();
		try{
		memepos.put_ring('a',4,Yinsh.Case.ANoir);
		memepos.put_ring('a',4,Yinsh.Case.ABlanc);
		assertTrue(true);
		}catch(IllegalArgumentException exe){
		assertTrue(false);
		}
	}
	// Test Histoire 4
	public void test7()
	{
		Yinsh init = new Yinsh();
		init.put_ring('a',4,Yinsh.Case.ANoir);
		init.put_ring('b',4,Yinsh.Case.ABlanc);
		init.put_ring('c',4,Yinsh.Case.ANoir);
		init.put_ring('d',4,Yinsh.Case.ABlanc);
		init.put_ring('e',4,Yinsh.Case.ANoir);
		init.put_ring('f',4,Yinsh.Case.ABlanc);
		init.put_ring('g',4,Yinsh.Case.ANoir);
		init.put_ring('h',4,Yinsh.Case.ABlanc);
		init.put_ring('i',4,Yinsh.Case.ANoir);
		init.put_ring('j',8,Yinsh.Case.ABlanc);
		assertTrue(init.is_initialized());
	}
	// Test Histoire 5
	public void test8()
	{
		Yinsh marker= new Yinsh();
		marker.put_ring('d',2,Yinsh.Case.ANoir);
		assertTrue(marker.put_marker('d',2,Yinsh.Case.MNoir) == Yinsh.Case.MNoir);
	}
		
	public void test9()
	{
		Yinsh lol= new Yinsh();
		lol.move_ring('d', 2, 'b', 5, Yinsh.Case.MNoir);
		int let=(int)('b' - 'a');
		assertTrue(lol.Ring[let][5] == Yinsh.Case.MNoir);
	}

	public void test10()
	{
		Yinsh marktes= new Yinsh();
		marktes.put_ring('a',4,Yinsh.Case.ANoir);
		assertTrue(marktes.put_marker('a',4,Yinsh.Case.MNoir)==Yinsh.Case.MNoir);
	}

	public void test11()
	{
		Yinsh testo= new Yinsh();
		try{
		testo.put_ring('a',4,Yinsh.Case.ANoir);
		testo.move_ring('d', 2, 'a', 4, Yinsh.Case.MNoir);
		assertTrue(true);
		}catch(IllegalArgumentException e){
		assertTrue(false);
		}
	}

	public void test12()
	{
		Yinsh testi= new Yinsh();
		try{
		testi.put_ring('a',3,Yinsh.Case.ANoir);
		testi.move_ring('a', 2, 'a', 4, Yinsh.Case.MNoir);
		assertTrue(true);
		}catch(IllegalArgumentException ex){
		assertTrue(false);
		}
	}

	// Test Histoire 6
	
	public void test13()
	{
		Yinsh pesto= new Yinsh();
		int let=(int)('e' - 'a');
		pesto.put_ring('e',4,Yinsh.Case.ANoir);
		pesto.put_marker('e',4,Yinsh.Case.MNoir);
		pesto.changer_couleur('e', 3, 'e', 5, Yinsh.Case.MNoir);
		assertTrue(pesto.Ring[let][4] == Yinsh.Case.MBlanc);
		}
	

	// Test Histoire 7

	public void test14()
	{
		Yinsh pesti= new Yinsh();
		int let=(int)('e' - 'a');
		pesti.put_ring('e',4,Yinsh.Case.ANoir);
		pesti.put_marker('e',4,Yinsh.Case.MNoir);
		pesti.remove_row('e', 3, 'e', 5, Yinsh.Case.MNoir);
		assertTrue(pesti.Ring[let][4] == Yinsh.Case.Rien);
		}
	
	public void test15()
	{
		Yinsh remove= new Yinsh();
		int let=(int)('e' - 'a');
		remove.put_ring('e',4,Yinsh.Case.ABlanc);
		remove.remove_ring('e',4,Yinsh.Case.ABlanc);
		assertTrue(remove.Ring[let][4] == Yinsh.Case.Rien && remove.pointblanc==1);
		
		}


}
