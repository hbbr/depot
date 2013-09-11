import junit.framework.*;
import java.io.*;

public class Yinsh
{

//Histoire 1
public enum Color {BLACK,WHITE};
public Color couleur;	
public int nbanneau=0;
public int i = 0;
Case[] tour = new Case[100];

public Yinsh(){


double rand=Math.random();

if(rand < 0.5){
	couleur=Color.BLACK;
}else{
	couleur=Color.WHITE;
	}
}

public Color current_color(){
	return couleur;
}

//Histoire 2 
Case[][] Ring = new Case[11][11]; 

public enum Case {Rien,ABlanc,ANoir};

public Case put_ring(char lettre, int chiffre, Case couleurA){	
	
		
	Case cases;
	boolean existe=false;
	int let=(int)(lettre - 'a');

	switch(lettre){
	case 'a' : 
		existe = (chiffre>1 && chiffre<6);
			break;
	case 'b' : 
		existe = (chiffre>0 && chiffre<8);
			break;
	case 'c' : 
		existe = (chiffre>0 && chiffre<10);
			break;
	case 'd' : 
		existe = (chiffre>0 && chiffre<11);
			break;
	case 'e' : 
		existe = (chiffre>0 && chiffre<11);
			break;
	case 'f' : 
		existe = (chiffre>1 && chiffre<11);
			break;
	case 'g' : 
		existe = (chiffre>1 && chiffre<12);
			break;
	case 'h' : 
		existe = (chiffre>2 && chiffre<12);
			break;
	case 'i' : 
		existe = (chiffre>3 && chiffre<12);
			break;
	case 'j' : 
		existe = (chiffre>4 && chiffre<12);
			break;
	case 'k' : 
		existe = (chiffre>6 && chiffre<11);
			break;
	}

	if(existe==true){

	i=i+1;
	tour[i]=couleurA;
	if(tour[i-1]==tour[i]){
		throw new IllegalArgumentException();
	}
	else{
	cases = Ring[let][chiffre]=couleurA;
	nbanneau = nbanneau + 1;
	}
	
	
	return cases;

	}else{
		throw new IllegalArgumentException();
	}

    }
}
