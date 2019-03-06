package TextBasedGame_BloodyBunny;

import java.util.Random;

public class Methods 
{
	
	static Random rand = new Random();
	
//	#	THIS IS WHERE GAME METHODS ARE PLACED
	
	public static void RUN() 
	{ 
		Data.hpAndAkDisplayed=false;
//		Data.playerForfeits=false;
		Data.running=true;	
		System.out.println();
		Print.LINE();
	}
	
	public static void GET_ADRENALINE(boolean voluntary) 
	{
//		adrenaline OD can kill
//		adrenaline shots make you stronger but eats away at HP
		
		HEALTH_LOSE(Data.adrenalineShotValue);
		ATKPTS_GAIN(Data.adrenalineShotValue);
		
		
		if(voluntary) 
		{
			Data.PLAYER.adrenalineShot--;
		}// !voluntary means someone gave you the shot

		
	}
	
	
	public static void HEALTH_LOSE(int pts) 
	{
		Data.PLAYER.healthPts-=pts;
		
		if(Data.PLAYER.healthPts<=0)
		{
//			System.out.println();
			Print.STATUS("You lose your remaining Health Points");
//			Print.STATUS("Y O U    D I E D .");
		}
		else
		{
			System.out.println("> You lose "+pts+" Health --- "+Data.PLAYER.healthPts+" remaining.");
		}
		
		CHECK_PLAYER_ALIVE();
		
		Data.hpAndAkDisplayed=true;


	}
	
	public static void HEALTH_GAIN(int pts) 
	{
		Data.PLAYER.healthPts+=pts;
		
		System.out.println("> You gain "+pts+" Health --- "+Data.PLAYER.healthPts+ " in total.");
		
		if(Data.PLAYER.healthPts>100) 
		{
			Data.PLAYER.healthPts=100;
		}
		
		Data.hpAndAkDisplayed=true;
	}
	
	public static void ATKPTS_GAIN(int pts) 
	{
		Data.PLAYER.maxAttack+=pts;
		
		System.out.println("> You gain "+pts+" Strength --- "+Data.PLAYER.maxAttack+" in total.");
		
		if(Data.PLAYER.maxAttack>75) 
		{
			Data.PLAYER.maxAttack=75;
		}
		
		Data.hpAndAkDisplayed=true;
	}
	
	public static void ATKPTS_LOSE(int pts) 
	{
		Data.PLAYER.maxAttack-=pts;
		System.out.println("> You lose "+pts+" Strength --- "+Data.PLAYER.maxAttack+" remaining.");
		
//		IF PLAYER GETS ZERO STRENGTH, HE CAN NO LONGER FIGHT.
//		IF HE STILL ENGAGES IN FIGHTS, HE GETS 35 CHANCE OF MERCY, ELSE SUDDEN DEATH.
		
		Data.hpAndAkDisplayed=true;
	}
	
	
	public static void CHAR_HEALTH_LOSE(int plAtk)
	{
	//		damage on player attack
	//		returns the new value of opponent to original Character Data
			
			Data.OPPONENT.healthPts-=plAtk;
			
			switch(Data.OPPONENT.name) 
			{			
			case "HOUND": Data.HOUND.healthPts=Data.OPPONENT.healthPts; break;
			}
			
		}

	public static void CHECK_PLAYER_ALIVE()
	{
		if(Data.PLAYER.healthPts<=0) 
		{
			Print.PLAYER_DEATH("[INSERT EULOGY HERE]");
		}
	}
	
	public static boolean CHECK_OPPONENT_ALIVE() 
	{
		
		if(Data.OPPONENT.healthPts<=0)
		{
			Data.OPPONENT.alive=false;
//			DECLARE THEM DEAD IN THE ORIGINAL DATA		
			switch(Data.OPPONENT.name) 
			{
	
			case "HOUND": Data.HOUND.alive=false; break;
			
			}
			
//			PRINT ANNOUNCEMENT THAT CHARACTER IS DEAD
			Print.STATUS("You killed "+Data.OPPONENT.name+". You can go on.");
			
//			IF THEY HAVE A WEAPON, THEY WILL DROP IT? ...MAYBE THEY'LL DROP USEFUL THINGS.

			
		}
		else
		{
			Data.OPPONENT.alive=true;
		}
		return Data.OPPONENT.alive;
	}
	
	
	
	
	
	public static void FIGHT() 
	{
		
//		FIGHTS WILL BE TURN-BASED and PLAYER ALWAYS ATTACKS FiRST
//		ATTACKS WILL BE RANDOM AND BASED ON THE MAXIMUM ATTACK OF EACH
//		HEALTH PILLS AND ADRENALINE SHOT DROPS ARE RANDOM
		
		if(CHECK_OPPONENT_ALIVE())
		{
			Print.IMAGE(Images.playerVShound);
			Print.FIGHT_ALL_INFO();
			Print.FIGHT_CHOICES();
			Print.PLAYER();
						
//				PLAYER CHOSE ATTACK
				if(Data.ANSWER.equals("1")) 
				{

					System.out.println("\n"+Data.fightLine+"\n");
					
					int plAtk=rand.nextInt(Data.PLAYER.maxAttack);
					Print.STATUS("You "+ATTACK_TYPE(Data.PLAYER.weapon, "PLAYER")+
							     " "+Data.OPPONENT.name+" dealing "+plAtk+" damage!");
					
//					DAMAGE TO ENEMY:
					CHAR_HEALTH_LOSE(plAtk);
					
					if(CHECK_OPPONENT_ALIVE()) 
					{
//						OPPONENT'S COUNTER ATTACK
						OPPONENT_ATTACKS();
					}					 
				}
				
//				PLAYER TAKES HEALTH PILL
				else if(Data.ANSWER.equals("2"))
				{
					if(Data.PLAYER.healthPill>0) 
					{
						System.out.println("\n"+Data.fightLine+"\n");
						Print.STATUS("You take a pill and feel more energized.");
						GET_HEALTHPILL(true);
						OPPONENT_ATTACKS();
					}
					else
					{
						System.out.println("\n"+Data.fightLine+"\n");
						Print.STATUS("You have no pills.\n");
						int opAtk=rand.nextInt(Data.OPPONENT.maxAttack)/2;
						Print.STATUS("You pause for a moment and "+Data.OPPONENT.name+" sees it as an opportunity.");
						Print.STATUS(Data.OPPONENT.name+" "+ATTACK_TYPE("None", Data.OPPONENT.name)+
								     " you and deals "+opAtk+" damage!");
						HEALTH_LOSE(opAtk);
					}
				}
				
//				PLAYER TAKES ADRENALINE SHOT
				else if(Data.ANSWER.equals("3")) 
				{
					if(Data.PLAYER.adrenalineShot>0) 
					{
						System.out.println("\n"+Data.fightLine+"\n");
						Print.STATUS("You administer a shot and immediately feel stronger.");
						GET_ADRENALINE(true);
						OPPONENT_ATTACKS();
					}
					else
					{
						System.out.println("\n"+Data.fightLine+"\n");
						Print.STATUS("You have no shots.\n");
						int opAtk=rand.nextInt(Data.OPPONENT.maxAttack)/2;
						Print.STATUS("You pause for a moment and "+Data.OPPONENT.name+" sees it as an opportunity.");
						Print.STATUS(Data.OPPONENT.name+" "+ATTACK_TYPE("None", Data.OPPONENT.name)+
								     " you and deals "+opAtk+" damage!");
						HEALTH_LOSE(opAtk);
					}
				}
				
//				PLAYER RUNS AWAY
				else if(Data.ANSWER.equals("4")) 
				{
					if(Data.OPPONENT.name.equals("HOUND")) 
					{
						Data.playerForfeits=true;
					}		
				}
				
				//YOU DIDNT CHOOSE PROPERLY IN THE MIDDLE OF THE FIGHT
				else 
				{
//					OPPONENT ATTACKS YOU DIRECTLY

					System.out.println("\n"+Data.fightLine+"\n");
					int opAtk=rand.nextInt(Data.OPPONENT.maxAttack)/2;
					Print.STATUS("You hesitate and "+Data.OPPONENT.name+" sees it as an opportunity.");
					Print.STATUS(Data.OPPONENT.name+" "+ATTACK_TYPE("None", Data.OPPONENT.name)+
							     " you and deals "+opAtk+" damage!");
					HEALTH_LOSE(opAtk);
					
				}
		}
		
		
	}

	
	private static void GET_HEALTHPILL(boolean voluntary) 
	{
		HEALTH_GAIN(Data.healthPillValue);
		
		if(voluntary)
		{
			Data.PLAYER.healthPill--;
		}
	}

	private static void OPPONENT_ATTACKS() 
	{
		int opAtk=rand.nextInt(Data.OPPONENT.maxAttack);
		int atkRate=(Data.OPPONENT.maxAttack/5)*2;
		
		if(opAtk>atkRate)
		{
			Print.STATUS(Data.OPPONENT.name+" "+ATTACK_TYPE(Data.OPPONENT.weapon, Data.OPPONENT.name)+
				     " you and deals "+opAtk+" damage!");
		}
		else 
		{
			Print.STATUS(Data.OPPONENT.name+" "+ATTACK_TYPE("None", Data.OPPONENT.name)+
				     " you and deals "+opAtk+" damage!");
		}
		
		HEALTH_LOSE(opAtk);
	}

//	SETS FIGHT MOVE OF CHARACTER DEPENDING ON WEAPON
	public static String ATTACK_TYPE(String weapon, String name) 
	{
		
		String attack = "";
		
		switch (weapon)
		{
		
		case "None":
			int chance=rand.nextInt(10);
			if(chance<=5) {
				if(name.contentEquals("PLAYER"))
				{
					attack="punch";
				}
				else 
				{
					attack="punches";
				}
			}
			else
			{
				if(name.contentEquals("PLAYER")) 
				{
					attack="kick";
				}
				else
				{
					attack="kicks";
				}
			}
			break;
		
//		with weapon:
		case "GUN": 
			if(name.contentEquals("PLAYER")) 
			{ 
				attack="shoot"; 
			}
			else 
			{ 
				attack="shoots"; 
				} 
			break;
				
		}
		
		return attack;		
	}
		
	public static void SET_OPPONENT(String img[], String name, String weapon, int health, int maxAtk) 
	{
		Data.OPPONENT.image=img.clone();
		Data.OPPONENT.name=name;
		Data.OPPONENT.weapon=weapon;
		Data.OPPONENT.healthPts=health;
		Data.OPPONENT.maxAttack=maxAtk;
		Data.OPPONENT.alive=true;
	}

	public static void PLAYER_INJURY(String part)
	{
		Print.STATUS("Your "+part+" is injured and in need of medical assistance.");
		switch (part)
		{
		case "right arm":
			Data.OK_rightArm=false; 
			break;
		case "left arm":
			Data.OK_leftArm=false; 
			break;
		case "right hand":
			Data.OK_rightHand=false; 
			break;
		case "left hand":
			Data.OK_leftHand=false; 
			break;
		case "right leg":
			Data.OK_rightLeg=false; 
			break;
		case "left leg":
			Data.OK_leftLeg=false; 
			break;	
		}
	}

	public static void CHANCE(int chanceInAHundred) 
	{
		
		int x=rand.nextInt(100);
		
		if(x<=chanceInAHundred)
		{
			Data.fortuneSmiles=true;
		}
		else
		{
			Data.fortuneSmiles=false;
		}
	}
	
}
