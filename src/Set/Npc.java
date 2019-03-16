package Set;


public class Npc
{
//	THIS IS WHERE ALL THE OTHER CHARCTERS ARE CREATED AND MANAGED
	
	static class npc
	{
		
		String 
		name,
		status,
		weapon,
		weaponType,
		affiliation
		;
		
		
		String[]
		fGraph //fight graphics
		;
		
		boolean
		alive=true
		;
		
		
		int
		hp,
		strength,
		pills,
		injections
		;

		
		//this is called a "constructior" 
		npc(String name, String status, String weapon, String weaponType, String affiliation, 
				String[] fGraph,
				int hp, int strength, int pills, int shots)
		{
			this.name=name;
			this.status=status;
			this.weapon=weapon;
			this.weaponType=weaponType;
			this.affiliation=affiliation;
			this.fGraph=fGraph.clone();
			this.hp=hp;
			this.strength=strength;
			this.pills=pills;
			this.injections=shots;
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
			this.injections--;
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
		 
		 
		 
		 void changeWeapon(String newWeapon)
		 {
			 for(int x=0; x<genData.weapon.length; x++)
				{
					//reset player strength during un-equip
					if(genData.weapon[x][0].equals(this.weapon))
					{
						this.strength-=Integer.valueOf(genData.weapon[x][2]);
					}
					
					//equip new weapon
					if(genData.weapon[x][0].equals(newWeapon)) 
					{
						this.weapon=newWeapon;
						this.weaponType=genData.weapon[x][1];
						this.strength+=Integer.valueOf(genData.weapon[x][2]);
					}
				}
		 }
		 
		 
		 void makeClone()
		 {
			OPPONENT=new npc(this.name, this.status, this.weapon, this.weaponType, this.affiliation,
					this.fGraph,
					this.hp, this.strength, this.pills, this.injections);
		 }
		 
		 
		 
		 void reflectClone()
		 {
			 this.hp=OPPONENT.hp;
			 this.strength=OPPONENT.strength;
			 this.pills=OPPONENT.pills;
			 this.injections=OPPONENT.injections;
			 this.alive=OPPONENT.alive;
		 }
	}
	
	
	public static  npc OPPONENT; //temporary opponent -> npc place holder for fights 
	public static  npc hound;
	public static  npc hostage;
	
	
	
	static String blank[]= {"NO GRFIGHT", "NO GRFIGHT", "NO GRFIGHT"}; //fgraph place holder
	
	public static void initialize()
	{
		hound=new npc("Hound", "Foe", "Gun", "Firearm", "The Group", GrFight.hound, 90, 50, 5, 5);
		
		hostage=new npc("Hostage", "Neutral", "None", "None", "Unknown", blank, 20, 15, 0, 0);
		
		
	}

}
