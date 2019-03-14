package Set;

public class npcData
{
//	THIS IS WHERE ALL THE OTHER CHARCTERS ARE CREATED AND MANAGED
	
	static class npc
	{
		static String 
		name,
		status,
		weapon,
		weaponType
		;
		
		static boolean
		alive
		;
		
		
		static int
		hp,
		strength,
		pills,
		shots
		;
		
		void setString(String name, String status, String weapon, String weaponType)
		{
			npc.name=name;
			npc.status=status;
			npc.weapon=weapon;
			npc.weaponType=weaponType;
		}
		
		void setInt(int hp, int strength, int pills, int shots)
		{
			npc.hp=hp;
			npc.strength=strength;
			npc.pills=pills;
			npc.shots=shots;
		}
		
		
//		move the ff to mpcMethods if needed-----------------------------------------------
		
		public void getPill()
		{	
			IO.narration(npc.name+" took a pill.");
			npc.pills--;
			npc.hp+=genData.pillVal;
			npc.strength+=genData.pillVal/3;
			checkNPC();
		}
		
		public void getInjection() 
		{
			IO.narration(npc.name+" injected himself.");
			npc.shots--;
			npc.hp-=genData.shotVal;
			npc.strength+=genData.shotVal;
			checkNPC();
		}
		
		
		public void checkNPC() //monitors NPC stats and values
		{
			if(npc.hp<1) //npc dies 
			{
				IO.narration( npc.name+" is dead.");
				npc.alive=false;
			}
			else //is alive
			{
				if(npc.hp>100)
				{
					npc.hp=100; //adjust ceiling
				}
			}
			
			if(npc.strength>100)
			{
				npc.strength=100; //can't be too strong 
			}
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
