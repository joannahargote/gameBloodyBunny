package Set;

import java.util.Random;

public class Methods {

	
	
	public static void getInjection(boolean ownSupply) //called shots in game. Like a drug, it gives you strength but drains life points
	{
		if(ownSupply) // the shot is form your inventory
		{
			PlayerData.shots--; //supply gets depleted
		}
		
		change_HP_Atk(-genData.shotVal, genData.shotVal);
	}
	
	
	
	
	public static void getPill(boolean ownSupply) //called shots in game. Like a drug, it gives you strength but drains life points
	{
		if(ownSupply) // the pill is yours
		{
			PlayerData.pills--; //supply gets depleted
		}

		change_HP_Atk(genData.pillVal, genData.pillVal/3);
	}
	
	
	
	
	public static void change_HP_Atk(int chgHP, int chgStr) //gets change in HP and change in Attack
	{
		if(!IO.methodPrinted)
		{
			IO.emptyLine(1);
		}
		
		PlayerData.hp+=chgHP;
		PlayerData.strength+=chgStr;
		
		if(PlayerData.hp>100)
		{
			PlayerData.hp=100;
		}
		else if(PlayerData.hp<1)
		{
			IO.dead();
		}
		
		if(PlayerData.strength>100)
		{
			PlayerData.strength=100;
		}
		else if (PlayerData.strength<0)
		{
			PlayerData.strength=0;
		}
		
		if(chgHP!=0)
		{
			if(chgHP<0)
			{
				IO.narration("- You lose "+(chgHP*-1)+" HP. You have "+PlayerData.hp+" HP remaining.");
			}
			else
			{
				IO.narration("- You gain "+chgHP+" HP. You have a total of "+PlayerData.hp+" HP.");
			}
		}
		
		if(chgStr!=0)
		{
			if(chgStr<0)
			{
				IO.narration("- You lose "+(chgStr*-1)+" Strength. You have "+PlayerData.strength+" Strength remaining.");
			}
			else
			{
				IO.narration("- You gain "+chgStr+" Stregth. You have a total of "+PlayerData.strength+" Strength.");
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
		case "left hand": PlayerData.handLeft=false; break;
		case "right hand":PlayerData.handRight=false; break;
		case "left arm":PlayerData.armLeft=false; break;
		case "right arm":PlayerData.armLeft=false; break;
		}
		
		IO.emptyLine(1);
		
		IO.methodPrinted=true;
	}
	
	
	
	
	public static void headShot(String lastWords, String descrip)
	{
		IO.narration(lastWords);
		IO.emptyLine(1);
		IO.narration(descrip);
		IO.emptyLine(1);
		IO.narration("Within that second everyhting went dark and quiet.");
		
		//let's see if you survive a headshot
		if(fortuneSmiles(20))
		{
			IO.narration("You somehow survive. JUMP TO NEXT CHAPTER!");
		}
		else
		{
			change_HP_Atk(PlayerData.hp, 0);
		}
	}
	
	
	
	public static boolean fortuneSmiles(int chance)
	{
		Random rand = new Random();
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
	
}
