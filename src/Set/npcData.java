package Set;

public class npcData
{
//	THIS IS WHERE ALL THE OTHER CHARCTERS ARE CREATED AND MANAGED
	
	static class npc
	{
		public static String 
		name,
		status,
		weapon,
		weaponType
		;
		
		public static boolean
		alive
		;
		
		
		public static int
		hp,
		strength,
		pills,
		shots
		;
		
		public void setString(String name, String status, String weapon, String weaponType)
		{
			npc.name=name;
			npc.status=status;
			npc.weapon=weapon;
			npc.weaponType=weaponType;
		}
		public void setInt(int hp, int strength, int pills, int shots)
		{
			npc.hp=hp;
			npc.strength=strength;
			npc.pills=pills;
			npc.shots=shots;
		}
		
		
	}
	
	
	public 	static npc tempOp; //temporary opponent -> place holder for fights
	public static npc hound;
	public static npc hostage;
	
	
	
	
	public static void initialize()
	{
		hound.setString("Hound", "Foe", "Gun", "Firearm");
		hound.setInt(90, 70, 5, 5);		
		
		hostage.setString("Hostage", "Neutral", "None", "None");
		hostage.setInt(20, 15, 0, 0);
	}

}
