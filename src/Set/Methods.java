package Set;

public class Methods {

	
	
	public static void getInjection(boolean voluntary) //called shots in game. Like a drug, it gives you strength but drains life points
	{
		if(voluntary) // you administered the shot yourself
		{
			PlayerData.shots--; //supply gets depleted
		}
		
		change_HP_Atk(-10, 10);
		
	}
	
	
	
	
	public static void change_HP_Atk(int chgHP, int chgStr) //gets change in HP and change in Attack
	{
		if(!IO.methodPrinted)
		{
			IO.emptyLine(1);
		}
		
		PlayerData.HP+=chgHP;
		PlayerData.strength+=chgStr;
		
		if(PlayerData.HP>100)
		{
			PlayerData.HP=100;
		}
		else if(PlayerData.HP<1)
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
				IO.narration("- You lose "+(chgHP*-1)+" HP. You have "+PlayerData.HP+" HP remaining.");
			}
			else
			{
				IO.narration("- You gain "+chgHP+" HP. You have a total of "+PlayerData.HP+" HP.");
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
	
	
}
