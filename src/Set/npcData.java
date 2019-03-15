package Set;

public class npcData
{
//	THIS IS WHERE ALL THE OTHER CHARCTERS ARE CREATED AND MANAGED
	
	static class npc
	{
		String 
		name,
		status,
		weapon,
		weaponType
		;
		
		boolean
		alive=true
		;
		
		
		int
		hp,
		strength,
		pills,
		shots
		;

		
		//this is called a "constructior" 
		npc(String name, String status, String weapon, String weaponType, 
				int hp, int strength, int pills, int shots)
		{
			this.name=name;
			this.status=status;
			this.weapon=weapon;
			this.weaponType=weaponType;
			this.hp=hp;
			this.strength=strength;
			this.pills=pills;
			this.shots=shots;
		}
		
		
		
//		move the ff to mpcMethods if needed-----------------------------------------------
		
		
		
		void kill() 
		{
			this.alive=false;
		}
		
		
		
		void getPill()
		{	
			IO.narration(this.name+" took a pill.");
			IO.emptyLine(1);
			this.pills--;
			this.hp+=genData.pillVal;
			this.strength+=genData.pillVal/3;
			checkNPC();
		}
		
		
		
		void getInjection() 
		{
			IO.narration(this.name+" injected himself.");
			IO.emptyLine(1);
			this.shots--;
			this.hp-=genData.shotVal;
			this.strength+=genData.shotVal;
			checkNPC();
		}
		
		
		
		void checkNPC() //monitors NPC stats and values
		{
			if(this.hp<1) //npc dies 
			{
				IO.emptyLine(1);
				IO.narration( this.name+" is dead.");
				this.alive=false;
			}
			else //is alive
			{
				if(this.hp>100)
				{
					this.hp=100; //adjust ceiling
				}
			}
			
			if(this.strength>100)
			{
				this.strength=100; //can't be too strong 
			}
		}
		
		
		
		 void change_HP_Atk(int chgHP, int chgStr)
		 {
			 this.hp+=chgHP;
			 this.strength+=chgStr;
			 checkNPC();
		 }
		
	}
	
	
	public static  npc tempOp; //temporary opponent -> place holder for fights
	public static  npc hound;
	public static  npc hostage;
	
	
	
	
	public static void initialize()
	{
		hound=new npc("Hound", "Foe", "Gun", "Firearm", 90, 70, 5, 5);
		
		hostage=new npc("Hostage", "Neutral", "None", "None", 20, 15, 0, 0);
		
	}

}
