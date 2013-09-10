import junit.framework.*;

public class Yinsh
{

public enum Color {BLACK,WHITE};
public Color couleur;	

public Yinsh(){

double rand=Math.random();
if(rand < 0.5)
{
	couleur=Color.BLACK;
}else{
	couleur=Color.WHITE;
}


}


public Color current_color(){
	return couleur;
}

}
