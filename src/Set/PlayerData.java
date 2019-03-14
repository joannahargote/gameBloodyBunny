package Set;

public class PlayerData
{
	public static int 
		hp,
		strength,
		pills,
		shots
		;
	
	public static String
		weapon,
		weaponType
		;
	
	public static boolean 
		masked,
		armed,
		
		//for injuries-> important if using a weapon
		handLeft,
		handRight,
		armLeft,
		armRight
		;
	
	
	
	
	public static void initialize()
	{
		//DO NOT TOUCH
		hp=39;
		weapon="None";
		weaponType="None";
		strength=27;
		pills=0;
		shots=0;
		handLeft=true;
		handRight=true;
		armLeft=true;
		armRight=true;
	}

}
