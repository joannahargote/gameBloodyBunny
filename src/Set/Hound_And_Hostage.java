package Set;


public class Hound_And_Hostage 
{
//	THIS IS THE OPENING SCENE
//	MOST CHOICES HERE ARE MORALITY-BASED
//	THIS IS A TORTURE SCENE AND THIS DEFINES WHO THE PLAYER GETS TO BE IN THE ENTIRE GAME
	
	
	static String choice;
	
	
	private static void choicesLeadTo(String s1, String s2)
	{
		//set path according to choice
		if(IO.pCHOICE.equals("1"))
		{
			choice=s1;
		}
		else
		{
			choice=s2;
		}
		
		
		//redirect the player's path
		switch (choice)
		{
		case "openEyes": openEyes(); break;
		case "playDead": playDead(); break;
		case "shotRightArm": shotRightArm(); break;
		case "fightHound": fightHound(); break;
		case "boxCutter": boxCutter(); break;
		case "cutRightF": cutRightF(); break;
		case "cutLeftF": cutLeftF(); break;
		case "shotLeftF": shotLeftF(); break;
		case "theHostage": theHostage(); break;
		case "shotHostageKnee": shotHostageKnee(); break;
		case "killHostage": killHostage(); break;
		case "beatHostage": beatHostage(); break;
		case "escapeAttempt": escapeAttempt(); break;
		case "thePills": thePills(); break;
		case "doYouKnow": doYouKnow(); break;
		case "theGroupsOffer": theGroupsOffer(); break;
		case "houndAsksAboutRing": houndAsksAboutRing(); break;
		case "fatalHeadShot": fatalHeadShot(); break;
		case "theCall": theCall(); break;
		case "theGoldenRing": theGoldenRing(); break;
		default: break;
		}
	}
	
	
	
	
	public static void startScene()
	{
		//init:
		PlayerData.initialize();
		
		
		
		wakeUp();
	}

	
	
	
	private static void wakeUp() 
	{
		IO.drawLine();
		IO.narration("You suddenly gain consciousness and pain floods in. You feel sick, your ");
		IO.narration("head is throbbing, and deep breaths seem agonizingly impossible at the");
		IO.narration("moment.");
		IO.emptyLine(1);
		IO.narration("You open your eyes slightly and see the shadow of a person moving around");
		IO.narration("near you. The person is humming.");
		
		IO.choices("Open your eyes", "Pretend to be unconscious", "", "", "");
		choicesLeadTo("openEyes", "playDead");
		
	}




	private static void theGoldenRing() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void theCall() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void fatalHeadShot() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void houndAsksAboutRing() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void theGroupsOffer() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void doYouKnow()
	{
		// TODO Auto-generated method stub
		
	}




	private static void thePills() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void escapeAttempt() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void beatHostage() 
	{
	// TODO Auto-generated method stub
	
}




	private static void killHostage() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void shotHostageKnee()
	{
		// TODO Auto-generated method stub
		
	}




	private static void theHostage()
	{
		// TODO Auto-generated method stub
		
	}




	private static void shotLeftF() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void cutLeftF() 
	{
	// TODO Auto-generated method stub
	
}




	private static void cutRightF()
	{
		// TODO Auto-generated method stub
		
	}




	private static void boxCutter() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void fightHound() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void shotRightArm() 
	{
	// TODO Auto-generated method stub
	

	}




	private static void playDead()
	{
	
	}




	private static void openEyes() 
	{
	IO.narration("open eyes");
	}
	
	
	
	
}
