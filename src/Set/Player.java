package Set;

public class Player
{
	public static int 
		hp,
		strength,
		pills,
		injections
		;
	
	public static String
		weapon,
		weaponType
		;
	
	public static String[]
		fGraph
		;
	
	public static boolean 
		masked,
		armed,
		
		//for injuries-> important if using a weapon
		handLeft,
		handRight,
		armLeft,
		armRight,
		forfeitFight
		;
	
	
	
	
	public static void initialize()
	{
		//DO NOT TOUCH
		hp=39;
		weapon="None";
		weaponType="None";
		fGraph=GrFight.player.clone();
		strength=27;
		pills=0;
		injections=0;
		handLeft=true;
		handRight=true;
		armLeft=true;
		armRight=true;
	}

}
