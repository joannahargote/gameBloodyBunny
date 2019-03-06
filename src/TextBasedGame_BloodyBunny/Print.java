package TextBasedGame_BloodyBunny;

import java.util.Scanner;


public class Print 
{
	
//	#	THIS IS WHERE ALL THE CLASSES THAT DISPLAY CONTENT IN SPECIFIC FORMATS ARE STORED
	
	
	
//	TEXT-BASED GAME MEANS THERE WILL BY LOTS OF PRINTING INVOLVED.
//	HENCE, THE CUSTOM PRINTERS TO MAKE IT EASIER TO FORMAT.
	
	
	public static void LINE()
	{
		System.out.println(Data.line);		
	}
	
	public static void STATUS(String string)
	{
		Data.running=false;
		System.out.println("> "+string+"\n");		
	}
	
	public static void SITUATION(String string) 
	{
//		System.out.println("\n\t"+string+"\n");	
		System.out.println("  ----- "+string+"\n");	
	}
	
	public static void CHOICES(String string, String string2) 
	{
		SITUATION("Select action:");
		System.out.println("\t[1] "+string);
		System.out.println("\t[2] "+string2+"\n");
	}
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void PLAYER() {
//		System.out.print("\tPLAYER: ");	
		System.out.print("  ----- PLAYER: ");	
		Data.ANSWER=scan.nextLine();
	}
	
	public static void CHAR_INFO(String name, int healthPoints, int maxAttack, String weapon)
	{
		
		System.out.println("\n  "+name+"'s Health: \t"+healthPoints+"");
		System.out.println("  "+name+"'s Strength: \t"+maxAttack+"");
		System.out.println("  "+name+"'s Weapon: \t"+weapon+"\n");
	}
	
	public static void PLAYER_INFO()
	{
		System.out.println("\n  PLAYER's Health: \t"+Data.PLAYER.healthPts);
		System.out.println("  PLAYER's Strength: \t"+Data.PLAYER.maxAttack);
		
		if(!Data.PLAYER.weapon.equals("None")) 
		{
			System.out.println("  PLAYER's Weapon: \t"+Data.PLAYER.weapon+"\n");
		}
		System.out.println();
		
	}
	
	public static void FIGHT_CHOICES() 
	{
//		SHOW OPPONENT IMAGE HERE
		SITUATION("What is your next move?");
		System.out.println("\t[1] ATTACK");
		System.out.println("\t[2] TAKE HEALTH PILL");
		System.out.println("\t[3] TAKE ADRENALIE SHOT");
		System.out.println("\t[4] RUN AWAY  \n");				
	}

	public static void FIGHT_ALL_INFO() 
	{		
		System.out.println("\n\tPLAYER's Health:    "+Data.PLAYER.healthPts+"\t\t   "+Data.OPPONENT.name+"'s Health:    "+Data.OPPONENT.healthPts);
		System.out.println("\tPLAYER's Strength:  "+Data.PLAYER.maxAttack+"\t\t   "+Data.OPPONENT.name+"'s Strength:  "+Data.OPPONENT.maxAttack);
		System.out.println("\tPLAYER's Weapon:    "+Data.PLAYER.weapon+"\t   "+Data.OPPONENT.name+"'s Weapon:    "+Data.OPPONENT.weapon);
		System.out.println("\tPLAYER's Pills:     "+Data.PLAYER.healthPill);
		System.out.println("\tPLAYER's Shots:     "+Data.PLAYER.adrenalineShot+"\n");
	}
	
//	DISPLAYS ASCII IMAGES
	public static void IMAGE(String img[])
	{
		for(int x=0; x<img.length; x++) 
		{
			System.out.println("\t"+img[x]);
		}

		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void PLAYER_DEATH(String string) 
	{
		STATUS(string);
		System.out.println(
				 "                                                                                " + "\n"
				+"                     T H E    P A T H    E N D S     H E R E .                    " + "\n"
				+"                                                                            " + "\n"
				+"                                    Cast your eyes to heaven        " + "\n"
				+"                                              and get a knife in the back                                           " + "\n"
				+"               /``''\\``--                                                       " + "\n"
				+"             ;..,:        \\--+,,.                                              " + "\n"
				+"         _./`'\\,                 :;.                                          " + "\n"
				+" ..,,,.`'      7      ...+`'''\"-.    \\,,....,-`~,..vvv\\(..,,,,.```-,,...........   "
				);
		
		LINE();
		SITUATION("Play again?");
		CHOICES("YES", "NO");
		
		while(!Data.running) 
		{
			PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				System.out.println("\n\n\n\n\n");
				Menu.main(Images.hound);
			}
			else if(Data.ANSWER.contentEquals("2"))
			{  
				LINE();
				System.out.println();
				STATUS("PLAYER QUIT GAME. THANKS FOR PLAYING!");
				System.out.println();
				LINE();
				System.exit(1);
			}
		}	
	}
	
	
	
	
	
	
}
