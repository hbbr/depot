import junit.framework.*;
import java.io.*;

public class Yinsh
{

public enum Color {BLACK,WHITE};
public Color couleur;	
public int nbanneau=0;
public int i = 0;
public int pointnoir=0;
public int pointblanc=0;
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
	
	if((nbanneau % 2)==0){
		couleur=Color.BLACK;
	}else{
		couleur=Color.WHITE;
	}

	return couleur;
}


Case[][] Ring = new Case[11][11]; 

public enum Case {Rien,ABlanc,ANoir,MNoir,MBlanc};


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
		if(Ring[let][chiffre]!=Case.Rien){
	i=i+1;
	tour[i]=couleurA;
	if(tour[i-1]==tour[i]){
		throw new IllegalArgumentException("Pas le bon tour");
	}
	else{
	Ring[let][chiffre]=couleurA;
	cases = Ring[let][chiffre];
	nbanneau = nbanneau + 1;
	}
		
	}else{
		throw new IllegalArgumentException("Case utilisee");
	}

	}else{
		throw new IllegalArgumentException("Mauvaise case");
	}

	return cases;

    }


public boolean is_initialized(){
	if(nbanneau==10){
		return true;
	}else{
		return false;
	}
}


public Case put_marker(char lettre, int chiffre, Case couleurM){
	
	Case cases;
	int let=(int)(lettre - 'a');
	
	if(couleurM==Case.MNoir && Ring[let][chiffre]==Case.ANoir){
		Ring[let][chiffre]=Case.MNoir;
		cases = Ring[let][chiffre];
	}else{
		throw new IllegalArgumentException("Mauvaise couleur");
	}
		
	
	return cases;
	}

public Case move_ring(char lettreorig, int chiffreorig, int lettredest, int chiffredest, Case couleurM){

	Case cases;
	int letorig=(int)(lettreorig - 'a');	
	int letdest=(int)(lettredest - 'a');
	boolean test = verif(lettreorig, chiffreorig, lettredest, chiffredest, couleurM);	
	

	if(Ring[letdest][chiffredest]==null || Ring[letdest][chiffredest]==Case.ANoir){
		
		if(test==true){
		cases = Ring[letdest][chiffredest]=couleurM;
		}else{
			throw new IllegalArgumentException("Piece sur la route");
		}
	}else{
		throw new IllegalArgumentException("Deplacement non autorise");
	}

	return cases;

}

public boolean verif(char lettreorig, int chiffreorig, int lettredest, int chiffredest, Case couleurM){
	
	int letorig=(int)(lettreorig - 'a');
	int letdest=(int)(lettredest - 'a');
	int i=letorig;
	int j=chiffreorig;
	boolean verite=true;
	while(i==letdest){
		if(Ring[i][chiffreorig]!=null){
			verite=false;
		}
		i++;
	}
	while(j==chiffredest){
		if(Ring[letorig][j]!=null){
			verite=false;
		}	
		j++;
	}


	return verite;
}
	
	
public void changer_couleur(char lettreorig, int chiffreorig, int lettredest, int chiffredest, Case couleurM){

	int letorig=(int)(lettreorig - 'a');
	int z=letorig;
	int k=chiffreorig;
	if(lettreorig!=lettredest){
	while(z!=lettredest){
		if(Ring[z][chiffreorig]==Case.MBlanc){
		Ring[z][chiffreorig]=Case.MNoir;
		}else{
		Ring[z][chiffreorig]=Case.MBlanc;
		}
		z++;
	}
	}else{
	while(k!=chiffredest){
		if(Ring[letorig][k]==Case.MBlanc){
		Ring[letorig][k]=Case.MNoir;
		}else{
		Ring[letorig][k]=Case.MBlanc;
		}
	k++;
	}
    }
}

public void remove_row(char lettreorig, int chiffreorig, int lettredest, int chiffredest, Case couleurM){

	int letorig=(int)(lettreorig - 'a');
	int z=letorig;
	int k=chiffreorig;
	if(lettreorig!=lettredest){
	while(z!=lettredest){
		if(Ring[z][chiffreorig]==Case.MBlanc){
		Ring[z][chiffreorig]=Case.Rien;
		}else{
		Ring[z][chiffreorig]=Case.Rien;
		}
		z++;
	}
	}else{
	while(k!=chiffredest){
		if(Ring[letorig][k]==Case.MBlanc){
		Ring[letorig][k]=Case.Rien;
		}else{
		Ring[letorig][k]=Case.Rien;
		}
	k++;
	}
    }
}

public void remove_ring(char lettre, int chiffre, Case couleurA){

	int let=(int)(lettre - 'a');
	if(couleurA==Case.ABlanc){
		Ring[let][chiffre]=Case.Rien;
		pointblanc=pointblanc+1;
	}else{
		Ring[let][chiffre]=Case.Rien;
		pointnoir=pointnoir+1;
	}
}

/*public void position(char lettre, int chiffre, Case couleurA){

	int let=(int)(lettre - 'a');
	int nb = 0;
	int[] position = new int[50];
	while(Ring[let][nb]!=Case.MBlanc || Ring[let][nb]=Case.MNoir || nb<11){ 
	if(Ring[let][nb]==Case.Rien){
			
	}
	nb++;

}*/

public Color gagnantblitz(){

	if(pointblanc>pointnoir){
		return Color.WHITE;	
	}else{
		return Color.BLACK;
	}
}

public Color gagnantnormal(){

	Color couleur=Color.WHITE;
	if(pointblanc>pointnoir && pointblanc==3){
		couleur=Color.WHITE;	
	}
	if(pointnoir>pointblanc && pointnoir==3){
		couleur=Color.BLACK;
	}
	return couleur;
}

}
