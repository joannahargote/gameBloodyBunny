package Set;

import java.util.Random;



public class Methods {


	static Random rand = new Random();
	
	public static void getInjection(boolean ownSupply) //called shots in game. Like a drug, it gives you strength but drains life points
	{
		if(ownSupply) // the shot is form your inventory
		{
			Player.injections--; //supply gets depleted
		}
		
		change_HP_Atk(-genData.shotVal, genData.shotVal);
	}
	
	
	
	
	public static void getPill(boolean ownSupply) //called shots in game. Like a drug, it gives you strength but drains life points
	{
		if(ownSupply) // the pill is yours
		{
			Player.pills--; //supply gets depleted
		}

		change_HP_Atk(genData.pillVal, genData.pillVal/3);
	}
	
	
	
	
	public static void change_HP_Atk(int chgHP, int chgStr) //gets change in HP and change in Attack
	{
		if(!IO.methodPrinted)
		{
			IO.emptyLine(1);
		}
		
		Player.hp+=chgHP;
		Player.strength+=chgStr;
		
		if(Player.hp>100)
		{
			Player.hp=100;
		}
		else if(Player.hp<1)
		{
			IO.dead();
		}
		
		if(Player.strength>100)
		{
			Player.strength=100;
		}
		else if (Player.strength<0)
		{
			Player.strength=0;
		}
		
		if(chgHP!=0)
		{
			if(chgHP<0)
			{
				IO.narration("- You lose "+(chgHP*-1)+" HP. You have "+Player.hp+" HP remaining.");
			}
			else
			{
				IO.narration("- You gain "+chgHP+" HP. You have a total of "+Player.hp+" HP.");
			}
		}
		
		if(chgStr!=0)
		{
			if(chgStr<0)
			{
				IO.narration("- You lose "+(chgStr*-1)+" Strength. You have "+Player.strength+" Strength remaining.");
			}
			else
			{
				IO.narration("- You gain "+chgStr+" Stregth. You have a total of "+Player.strength+" Strength.");
			}
		}
		
		IO.emptyLine(1);
		
		IO.methodPrinted=true;
	}
	
	
	
	
	public static void injury(String part)
	{
		if(!IO.methodPrinted)
		{
			IO.emptyLine(1);
		}
		
		IO.narration("Your "+part+ " is injured and in need of medical attention.");
		
		switch(part)
		{
		case "left hand": Player.handLeft=false; break;
		case "right hand":Player.handRight=false; break;
		case "left arm":Player.armLeft=false; break;
		case "right arm":Player.armLeft=false; break;
		}
		
		IO.emptyLine(1);
		
		IO.methodPrinted=true;
	}
	
	
	
	
	public static void fatalShot(String lastWords, String descrip)
	{
		IO.narration(lastWords);
		IO.emptyLine(1);
		IO.narration(descrip);
		IO.emptyLine(1);
		
		if(genData.shotInHeart)
		{
			IO.narration("A chill ran down your spine as your blood seeped through your fingers.");
			IO.emptyLine(1);
			IO.narration("You fell down and gave in to sleep.");
		}
		else //headshot
		{
			IO.narration("Within that second everything went dark and quiet.");
		}
			
		
		//let's see if you survive a headshot
		if(fortuneSmiles(20))
		{
			IO.pressEnter("",true);
			IO.narration("You somehow survive. JUMP TO NEXT CHAPTER!");
		}
		else
		{
			change_HP_Atk(-Player.hp, 0);
		}
	}
	
	
	
	public static boolean fortuneSmiles(int chance)
	{
		int x = rand.nextInt(100);
		boolean lucky;
		
		if(x<=chance)
		{
			lucky=true;
		}
		else
		{
			lucky=false;
		}
		
		return lucky;
	}
	
	
	
	
	public static void changeWeapon(String newWeapon)
	{
		for(int x=0; x<genData.weapon.length; x++)
		{
			//reset player strength during un-equip
			if(genData.weapon[x][0].equals(Player.weapon))
			{
				Player.strength-=Integer.valueOf(genData.weapon[x][2]);
			}
			
			//equip new weapon
			if(genData.weapon[x][0].equals(newWeapon)) 
			{
				Player.weapon=newWeapon;
				Player.weaponType=genData.weapon[x][1];
				Player.strength+=Integer.valueOf(genData.weapon[x][2]);
			}
		}
		
		if(!Player.weapon.equals("None"))
		{
			IO.emptyLine(1);
			IO.narration("- You are now armed with a "+newWeapon);
			IO.emptyLine(1);
			
			IO.methodPrinted=true;
		}
	}



	
	static int plAtk, opAtk; //player attack, opponent attack
	static String atkMove="";
	public static void fight() 
	{
		if(Npc.OPPONENT.alive) {
			
			// start status -----------------------------------------------------------------------------------------------------
			IO.narration("- COMBAT ENGAGED -");
			IO.emptyLine(1);
			IO.narration(genData.fightAct1);
			if(!genData.fightAct2.equals(""))
			{
				IO.emptyLine(1);
				IO.narration(genData.fightAct2);
			}
			
			
			// end status -------------------------------------------------------------------------------------------------------
			
			if(Player.hp<1)
			{
				IO.dead();
			}
			else
			{
				stats();
				IO.choices("Attack", "Take pill", "Inject energy", "Yield", "Run");
			}
			
			
			switch(IO.pCHOICE) //processing player choice
			{
			
			case "1": //attack

				//player---------------------------------------------------------------------
				
				plAtk=rand.nextInt(Player.strength);
				
				if(genData.pWpAddAtk>0) 
					//adds a random number between the atkValue of the weapon and 1/3 of it.
					//value is solved in Methods.stats()
				{
					plAtk+=rand.nextInt(genData.pWpAddAtk-genData.pWpAddAtk/3)+(genData.pWpAddAtk/3);
				}
				
				switch(Player.weaponType)
				{
				case "None":
					if(fortuneSmiles(50))
					{
						atkMove="punch";
					}
					else
					{
						atkMove="kick";
					}
					break;
				case "Blade":
					if(fortuneSmiles(50))
					{
						atkMove="stab";
					}
					else
					{
						atkMove="slash";
					}
					break;
				case "Firearm":
					atkMove="shoot";
					break;
				default: 
					atkMove="UNRECORDED WEAPON TYPE";
					break;
				}
				
				genData.fightAct1="You "+atkMove+" "+Npc.OPPONENT.name+", dealing "+plAtk+" damage!";
				
				Npc.OPPONENT.hp-=plAtk;
				
				//Opponent-------------------------------------------------------------------
				
				opponentAttack();
				
				
				break;
			case "2": //pill
				
				if(Player.pills<1)
				{
					genData.fightAct1="You check your pockets and realize that you have no pills.";
				}
				else
				{
					genData.fightAct1="You take a pill, gaining "+genData.pillVal+" HP and "+genData.pillVal/3+" strength.";
					Player.hp+=genData.pillVal;
					Player.strength+=genData.pillVal/3;
					Player.pills--;
				}
				
				opponentAttack();
				
				
				break;
			case "3": //injection
				
				if(Player.injections<1)
				{
					genData.fightAct1="You take the syringe and realize that it is empty.";
				}
				else
				{
					genData.fightAct1="You inject yourself, gaining "+genData.shotVal+" in strength but losing "+genData.shotVal+" HP.";
					Player.hp-=genData.shotVal;
					Player.strength+=genData.shotVal;
					Player.injections--;
				}
				
				opponentAttack();
				
				break;
			case "4": //surrender
				
				Player.surrenderFight=true;

				break;
			case "5": //run
				
				Player.forfeitFight=true;
				
				break;

			}
			
			
			
			
		}
		else //OPPONENT dies
		{
			
		}
	}







	private static void opponentAttack() 
	{
		opAtk=rand.nextInt(Npc.OPPONENT.strength);
		
		if(genData.oWpAddAtk>0) 
			//adds a random number between the atkValue of the weapon and 1/3 of it.
			//value is solved in Methods.stats()
		{
			opAtk+=rand.nextInt(genData.oWpAddAtk-genData.oWpAddAtk/3)+(genData.oWpAddAtk/3);
		}

		
		switch(Npc.OPPONENT.weaponType)
		{
		case "None":
			if(fortuneSmiles(50))
			{
				atkMove="punches";
			}
			else
			{
				atkMove="kicks";
			}
			break;
		case "Blade":
			if(fortuneSmiles(50))
			{
				atkMove="stabs";
			}
			else
			{
				atkMove="slashes";
			}
			break;
		case "Firearm":
			atkMove="shoots";
			break;
		default: 
			atkMove="UNRECORDED WEAPON TYPE";
			break; 
		}
		

		
		if(IO.pCHOICE.equals("1"))
		{
			genData.fightAct2="Hound "+atkMove+" you in retaliation, dealing "+opAtk+" damage!";
		}
		else
		{
			genData.fightAct2="Hound takes the opportunity and "+atkMove+" you, dealing "+opAtk+" damage!";
		}
		
		Player.hp-=opAtk;
		
	}



	

	public static void stats() //shows fight status of player and opponent
	{
		String fs[]=new String[24]; //fsg -> fight stats
		
		//player-------------------------------------------------------------
		
		
		
		for(int x=0; x<12; x++)
		{
			fs[x]=Player.fGraph[x];
			
			switch(x)
			{
			case 2: fs[x]+="\t YOU"; break;
			case 4: fs[x]+="\t HP:       "+Player.hp; break;
			case 5: fs[x]+="\t ATK:      "+Player.strength;
			if(!Player.weapon.equals("None"))
			{
				for(int y=0; y<genData.weapon.length; y++)
				{
					if(Player.weapon.equals(genData.weapon[y][0])) //same weapon name
					{
						genData.pWpAddAtk=Integer.valueOf(genData.weapon[y][2]);
						fs[x]+=" (+"+genData.pWpAddAtk+")";
					}
				}
			}
			break;
			case 6: fs[x]+="\t WEAPON:   "+Player.weapon; break;
			case 8: fs[x]+="\t PILLS:    "+Player.pills; break;
			case 9: fs[x]+="\t INJ:      "+Player.injections; break;
			}
		}
		

		//opponent-----------------------------------------------------------
		
		for(int x=0; x<12; x++)
		{
			fs[x+12]=Npc.OPPONENT.fGraph[x];
			
			switch(x)
			{
			case 2: fs[x+12]+="\t "+Npc.OPPONENT.name; break;
			case 4: fs[x+12]+="\t HP:       "+Npc.OPPONENT.hp; break;
			case 5: fs[x+12]+="\t ATK:      "+Npc.OPPONENT.strength; 
			if(!Npc.OPPONENT.weapon.equals("None"))
			{
				for(int y=0; y<genData.weapon.length; y++)
				{
					if(Npc.OPPONENT.weapon.equals(genData.weapon[y][0])) //same weapon name
					{
						genData.oWpAddAtk=Integer.valueOf(genData.weapon[y][2]);
						fs[x+12]+=" (+"+genData.oWpAddAtk+")";
					}
				}
			}
			break;
			case 6: fs[x+12]+="\t WEAPON:   "+Npc.OPPONENT.weapon; break;
			case 8: fs[x+12]+="\t STATUS:   "+Npc.OPPONENT.status; break;
			case 9: fs[x+12]+="\t AFFIL:    "+Npc.OPPONENT.affiliation; break;
			}
		}
		
		IO.graphics(fs); //send to IO to be set as graphics[] and inserted to choices()
		
	}
}
