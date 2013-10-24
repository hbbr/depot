public class Yinsh {

    public enum Color {BLACK, WHITE}

    private Color m_couleur;
    public int m_nbAnneau = 0;
    private int m_compteur = 0;
    private int m_pointNoir = 0;
    public int m_pointBlanc = 0;
    private final Case[] m_tourJoueur = new Case[100];

    public Yinsh() {


        double rand = Math.random();

        if (rand < 0.5) {
            m_couleur = Color.BLACK;
        } else {
            m_couleur = Color.WHITE;
        }
    }

    public Color currentColor() {

        if ((m_nbAnneau % 2) == 0) {
            m_couleur = Color.BLACK;
        } else {
            m_couleur = Color.WHITE;
        }

        return m_couleur;
    }


    final Case[][] m_terrainRing = new Case[11][11];

    public enum Case {Rien, ABlanc, ANoir, MNoir, MBlanc}


    public Case putRing(char lettre, int chiffre, Case couleurA) {


        Case cases;
        boolean existe = false;
        int let = lettre - 'a';

        switch (lettre) {
            case 'a':
                existe = (chiffre > 1 && chiffre < 6);
                break;
            case 'b':
                existe = (chiffre > 0 && chiffre < 8);
                break;
            case 'c':
                existe = (chiffre > 0 && chiffre < 10);
                break;
            case 'd':
                existe = (chiffre > 0 && chiffre < 11);
                break;
            case 'e':
                existe = (chiffre > 0 && chiffre < 11);
                break;
            case 'f':
                existe = (chiffre > 1 && chiffre < 11);
                break;
            case 'g':
                existe = (chiffre > 1 && chiffre < 12);
                break;
            case 'h':
                existe = (chiffre > 2 && chiffre < 12);
                break;
            case 'i':
                existe = (chiffre > 3 && chiffre < 12);
                break;
            case 'j':
                existe = (chiffre > 4 && chiffre < 12);
                break;
            case 'k':
                existe = (chiffre > 6 && chiffre < 11);
                break;
        }

        if (existe) {
            if (m_terrainRing[let][chiffre] != Case.Rien) {
                m_compteur = m_compteur + 1;
                m_tourJoueur[m_compteur] = couleurA;
                if (m_tourJoueur[m_compteur - 1] == m_tourJoueur[m_compteur]) {
                    throw new IllegalArgumentException("Pas le bon tour");
                } else {
                    m_terrainRing[let][chiffre] = couleurA;
                    cases = m_terrainRing[let][chiffre];
                    m_nbAnneau = m_nbAnneau + 1;
                }

            } else {
                throw new IllegalArgumentException("Case utilisee");
            }

        } else {
            throw new IllegalArgumentException("Mauvaise case");
        }

        return cases;

    }


    public boolean isInitialized() {
        return m_nbAnneau == 10;

    }


    public Case putMarker(char lettre, int chiffre, Case couleurM) {

        Case cases;
        int let = lettre - 'a';

        if (couleurM == Case.MNoir && m_terrainRing[let][chiffre] == Case.ANoir) {
            m_terrainRing[let][chiffre] = Case.MNoir;
            cases = m_terrainRing[let][chiffre];
        } else {
            throw new IllegalArgumentException("Mauvaise coloration");
        }


        return cases;
    }

    public void moveRing(char lettreorig, int chiffreorig, int lettredest, int chiffredest, Case couleurM) {


        int letdest = lettredest - 'a';
        boolean test = verif(lettreorig, chiffreorig, lettredest, chiffredest);


        if (m_terrainRing[letdest][chiffredest] == null || m_terrainRing[letdest][chiffredest] == Case.ANoir) {

            if (test) {
                m_terrainRing[letdest][chiffredest] = couleurM;
            } else {
                throw new IllegalArgumentException("Piece sur la route");
            }
        } else {
            throw new IllegalArgumentException("Deplacement non autorise");
        }


    }

    boolean verif(char lettreorig, int chiffreorig, int lettredest, int chiffredest) {
        int letorig = lettreorig - 'a', letdest = lettredest - 'a';
        boolean verite = true;
        for (int i = letorig; i == letdest; i++) {
            if (m_terrainRing[i][chiffreorig] != null) verite = false;
        }
        for (int j = chiffreorig; j == chiffredest; j++) {
            if (m_terrainRing[letorig][j] != null) verite = false;
        }
        return verite;
    }


    public void changerCouleur(char lettreorig, int chiffreorig, int lettredest, int chiffredest) {

        int letorig = lettreorig - 'a', z = letorig, k = chiffreorig;
        if (lettreorig != lettredest) {
            while (z != lettredest) {
                if (m_terrainRing[z][chiffreorig] == Case.MBlanc) m_terrainRing[z][chiffreorig] = Case.MNoir;
                else m_terrainRing[z][chiffreorig] = Case.MBlanc;
                z++;
            }
        } else {
            while (k != chiffredest) {
                if (m_terrainRing[letorig][k] == Case.MBlanc) m_terrainRing[letorig][k] = Case.MNoir;
                else m_terrainRing[letorig][k] = Case.MBlanc;
                k++;
            }
        }

    }

    public void removeRow(char lettreorig, int chiffreorig, int lettredest, int chiffredest) {

        int letorig = lettreorig - 'a';
        int z = letorig;
        int k = chiffreorig;
        if (lettreorig != lettredest) {
            while (z != lettredest) {
                m_terrainRing[z][chiffreorig] = Case.Rien;
                z++;
            }
        } else {
            while (k != chiffredest) {
                m_terrainRing[letorig][k] = Case.Rien;
                k++;
            }
        }
    }

    public void removeRing(char lettre, int chiffre, Case couleurA) {

        int let = lettre - 'a';
        if (couleurA == Case.ABlanc) {
            m_terrainRing[let][chiffre] = Case.Rien;
            m_pointBlanc = m_pointBlanc + 1;
        } else {
            m_terrainRing[let][chiffre] = Case.Rien;
            m_pointNoir = m_pointNoir + 1;
        }
    }

/*public void position(char lettre, int chiffre, Case couleurA){

	int let=(int)(lettre - 'a');
	int nb = 0;
	int[] position = new int[50];
	while(m_terrainRing[let][nb]!=Case.MBlanc || m_terrainRing[let][nb]=Case.MNoir || nb<11){
	if(m_terrainRing[let][nb]==Case.Rien){
			
	}
	nb++;

}*/

    public Color gagnantblitz() {
        Color couleur;
        if (m_pointBlanc > m_pointNoir) {
            couleur = Color.WHITE;
        } else {
            couleur = Color.BLACK;
        }
        return couleur;
    }

    public Color gagnantnormal() {

        Color couleur = Color.WHITE;
        if (m_pointBlanc > m_pointNoir && m_pointBlanc == 3) {
            couleur = Color.WHITE;
        }
        if (m_pointNoir > m_pointBlanc && m_pointNoir == 3) {
            couleur = Color.BLACK;
        }
        return couleur;
    }

}