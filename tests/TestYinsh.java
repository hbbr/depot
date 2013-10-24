import junit.framework.*;

public class TestYinsh extends TestCase {

    public TestYinsh(String color) {
        super(color);
    }

    // Test Histoire 1 : test couleur actuelle
    public void test1() {
        Yinsh coco = new Yinsh();
        assertTrue(coco.currentColor() == Yinsh.Color.BLACK ||
                coco.currentColor() == Yinsh.Color.WHITE);
    }
    // Test Histoire 1 : test couleur actuelle

    public void test18() {
        Yinsh coloration = new Yinsh();
        coloration.putRing('b', 2, Yinsh.Case.ANoir);
        assertTrue(coloration.currentColor() == Yinsh.Color.WHITE ||
                coloration.currentColor() == Yinsh.Color.BLACK);
    }

    // Test Histoire 2.1  : verification du nombre d anneau au debut
    public void test2() {
        Yinsh nb = new Yinsh();
        assertTrue(nb.m_nbAnneau == 0);
    }

    // Test Histoire 2.2  : le nombre d anneau augmente apres avoir pose un anneau
    public void test3() {
        Yinsh r = new Yinsh();
        assertTrue(r.putRing('b', 2, Yinsh.Case.ANoir) == Yinsh.Case.ANoir || r.putRing('c', 2, Yinsh.Case.ABlanc) == Yinsh.Case.ABlanc);
        assertTrue(r.m_nbAnneau == 1);
    }

    // Test Histoire 2.3  : case inexistante
    public void test4() {
        Yinsh execpt = new Yinsh();
        try {
            execpt.putRing('a', 1, Yinsh.Case.ANoir);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    // Test Histoire 2.3  : meme case

    public void test22() {
        Yinsh execption = new Yinsh();
        try {
            execption.putRing('a', 5, Yinsh.Case.ANoir);
            execption.putRing('a', 5, Yinsh.Case.ABlanc);
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            assertTrue(false);
        }
    }

    // Test Histoire 2.4
    public void test5() {
        Yinsh tour = new Yinsh();
        try {
            tour.putRing('a', 4, Yinsh.Case.ANoir);
            tour.putRing('b', 5, Yinsh.Case.ANoir);
            assertTrue(false);
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }

    // Test Histoire 3
    public void test6() {
        Yinsh memepos = new Yinsh();
        try {
            memepos.putRing('a', 4, Yinsh.Case.ANoir);
            memepos.putRing('a', 4, Yinsh.Case.ABlanc);
            assertTrue(true);
        } catch (IllegalArgumentException exe) {
            assertTrue(false);
        }
    }

    public void test25() {
        Yinsh position = new Yinsh();
        try {
            position.putRing('a', 4, Yinsh.Case.Rien);
            position.putRing('a', 4, Yinsh.Case.ABlanc);
            assertTrue(false);
        } catch (IllegalArgumentException exe) {
            assertTrue(true);
        }
    }

    // Test Histoire 4
    public void test7() {
        Yinsh init = new Yinsh();
        init.putRing('k', 7, Yinsh.Case.ANoir);
        init.putRing('b', 4, Yinsh.Case.ABlanc);
        init.putRing('c', 4, Yinsh.Case.ANoir);
        init.putRing('d', 4, Yinsh.Case.ABlanc);
        init.putRing('e', 4, Yinsh.Case.ANoir);
        init.putRing('f', 4, Yinsh.Case.ABlanc);
        init.putRing('g', 4, Yinsh.Case.ANoir);
        init.putRing('h', 4, Yinsh.Case.ABlanc);
        init.putRing('i', 4, Yinsh.Case.ANoir);
        init.putRing('j', 8, Yinsh.Case.ABlanc);
        assertTrue(init.isInitialized());
    }

    // Test Histoire 5
    public void test8() {
        Yinsh marker = new Yinsh();
        marker.putRing('d', 2, Yinsh.Case.ANoir);
        assertTrue(marker.putMarker('d', 2, Yinsh.Case.MNoir) == Yinsh.Case.MNoir);
    }

    public void test21() {
        Yinsh marken = new Yinsh();
        try {
            marken.putRing('d', 2, Yinsh.Case.ABlanc);
            marken.putMarker('d', 2, Yinsh.Case.MBlanc);
            assertTrue(false);
        } catch (IllegalArgumentException exec) {
            assertTrue(true);
        }
    }

    public void test9() {
        Yinsh lol = new Yinsh();
        lol.moveRing('d', 2, 'b', 5, Yinsh.Case.MNoir);
        int let = 'b' - 'a';
        assertTrue(lol.m_terrainRing[let][5] == Yinsh.Case.MNoir);
    }

    public void test24() {
        Yinsh mouve = new Yinsh();
        try {
            mouve.putRing('b', 5, Yinsh.Case.ABlanc);
            mouve.moveRing('d', 5, 'b', 5, Yinsh.Case.MNoir);
            assertTrue(false);
        } catch (IllegalArgumentException exec) {
            assertTrue(true);
        }
    }

    public void test10() {
        Yinsh marktes = new Yinsh();
        marktes.putRing('a', 4, Yinsh.Case.ANoir);
        assertTrue(marktes.putMarker('a', 4, Yinsh.Case.MNoir) == Yinsh.Case.MNoir);
    }

    public void test11() {
        Yinsh testo = new Yinsh();
        try {
            testo.putRing('a', 4, Yinsh.Case.ANoir);
            testo.moveRing('d', 2, 'a', 4, Yinsh.Case.MNoir);
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            assertTrue(false);
        }
    }

    public void test12() {
        Yinsh testi = new Yinsh();
        try {
            testi.putRing('a', 3, Yinsh.Case.ANoir);
            testi.moveRing('a', 2, 'a', 4, Yinsh.Case.MNoir);
            assertTrue(true);
        } catch (IllegalArgumentException ex) {
            assertTrue(false);
        }
    }

    // Test Histoire 6

    public void test13() {
        Yinsh pesto = new Yinsh();
        int let = 'e' - 'a';
        pesto.putRing('e', 4, Yinsh.Case.ANoir);
        pesto.putMarker('e', 4, Yinsh.Case.MNoir);
        pesto.changerCouleur('e', 3, 'e', 5);
        assertTrue(pesto.m_terrainRing[let][4] == Yinsh.Case.MBlanc);
    }

    public void test23() {
        Yinsh changem = new Yinsh();
        int let = 'e' - 'a';
        try {
            changem.putRing('e', 4, Yinsh.Case.ANoir);
            changem.putMarker('e', 4, Yinsh.Case.MNoir);
            changem.changerCouleur('e', 3, 'f', 5);
            assertTrue(false);
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertTrue(true);
        }
    }
    // Test Histoire 7

    public void test14() {
        Yinsh pesti = new Yinsh();
        int let = 'e' - 'a';
        pesti.putRing('e', 4, Yinsh.Case.ANoir);
        pesti.putMarker('e', 4, Yinsh.Case.MNoir);
        pesti.removeRow('e', 3, 'e', 5);
        assertTrue(pesti.m_terrainRing[let][4] == Yinsh.Case.Rien);
    }

    public void test26() {
        Yinsh destination = new Yinsh();
        try {
            int let = 'e' - 'a';
            destination.removeRow('e', 5, 'b', 5);
            assertTrue(false);
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertTrue(true);
        }
    }


    public void test15() {
        Yinsh remove = new Yinsh();
        int let = 'e' - 'a';
        remove.putRing('e', 4, Yinsh.Case.ABlanc);
        remove.removeRing('e', 4, Yinsh.Case.ABlanc);
        assertTrue(remove.m_terrainRing[let][4] == Yinsh.Case.Rien && remove.m_pointBlanc == 1);

    }

    // Test Histoire 8


    // Test Histoire 9


    public void test16() {
        Yinsh gagnant = new Yinsh();
        gagnant.putRing('e', 4, Yinsh.Case.ABlanc);
        gagnant.removeRing('e', 4, Yinsh.Case.ABlanc);
        assertTrue(gagnant.gagnantblitz() == Yinsh.Color.WHITE);
    }

    public void test19() {
        Yinsh gagner = new Yinsh();
        gagner.putRing('d', 4, Yinsh.Case.ANoir);
        gagner.removeRing('d', 4, Yinsh.Case.ANoir);
        assertTrue(gagner.gagnantblitz() == Yinsh.Color.BLACK);
    }

    // Test Histoire 10


    // Test Histoire 11


    // Test Histoire 12

    public void test17() {
        Yinsh gagnantn = new Yinsh();
        gagnantn.putRing('e', 4, Yinsh.Case.ABlanc);
        gagnantn.putRing('e', 5, Yinsh.Case.ANoir);
        gagnantn.putRing('e', 6, Yinsh.Case.ABlanc);
        gagnantn.putRing('e', 7, Yinsh.Case.ANoir);
        gagnantn.putRing('e', 8, Yinsh.Case.ABlanc);
        gagnantn.removeRing('e', 4, Yinsh.Case.ABlanc);
        gagnantn.removeRing('e', 6, Yinsh.Case.ABlanc);
        gagnantn.removeRing('e', 8, Yinsh.Case.ABlanc);
        assertTrue(gagnantn.gagnantnormal() == Yinsh.Color.WHITE);
    }

    public void test20() {
        Yinsh gagnern = new Yinsh();
        gagnern.putRing('e', 4, Yinsh.Case.ANoir);
        gagnern.putRing('e', 5, Yinsh.Case.ABlanc);
        gagnern.putRing('e', 6, Yinsh.Case.ANoir);
        gagnern.putRing('e', 7, Yinsh.Case.ABlanc);
        gagnern.putRing('e', 8, Yinsh.Case.ANoir);
        gagnern.removeRing('e', 4, Yinsh.Case.ANoir);
        gagnern.removeRing('e', 6, Yinsh.Case.ANoir);
        gagnern.removeRing('e', 8, Yinsh.Case.ANoir);
        assertTrue(gagnern.gagnantnormal() == Yinsh.Color.BLACK);
    }


}
