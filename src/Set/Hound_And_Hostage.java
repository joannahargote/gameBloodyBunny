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
		
		

		IO.drawLine();
		wakeUp();
	}

	
	
	
	private static void wakeUp() 
	{
		IO.graphics(Graphics.wakeUp);
		IO.narration("You suddenly gain consciousness and pain floods in. Your neck feels sore");
		IO.narration("from hanging forward as you are in a sitting position.  You feel sick, your ");
		IO.narration("head is throbbing, and deep breaths seem agonizingly impossible at the");
		IO.narration("moment.");
		IO.emptyLine(1);
		IO.narration("You open your eyes slightly and see the shadow of a person moving around");
		IO.narration("near you. The person is humming. You close your eyes again.");
		IO.choices("Let them know you're awake", "Pretend to be unconscious", "", "", "");
		choicesLeadTo("openEyes", "playDead");
	}




	private static void openEyes() 
	{
		IO.graphics(Graphics.openEyes);
		IO.narration("You are seated on a chair, unrestrained, in a small empty room. There is");
		IO.narration("only one door which is currently closed. The walls are stained with");
		IO.narration("splashes of something that has long dried out. No window is in sight.");
		IO.emptyLine(1);
		IO.narration("A tall man in a dark suit holds a syringe away from your arm and looks at");
		IO.narration("you. He caps the needle and places the syringe in his pocket. A small ");
		IO.narration("letter \"H\" is pinned to his collar.");
		IO.emptyLine(1);
		IO.narration("You will call him \"Hound\".");
		IO.emptyLine(1);
		IO.narration("You move to get up but immediately freeze as Hound pulls out a gun and");
		IO.narration("points it at you. \"One wrong move and you die,\" he growls. \"Where is it?\"");
		IO.choices("Say \"What are you talking about?\"", "Attack Hound", "", "", "");
		choicesLeadTo("shotRightArm", "fightHound");
	}



	static int pdCnt=0; //playDeadCount -> path to adrenaline overdose
	private static void playDead()
	{
		switch(pdCnt)
		{
		case 0:
			IO.narration("You feel a sharp pain on your arm. You peek for a second and see that a blue");
			IO.narration("liquid is being injected into your veins.");
			IO.emptyLine(1);
			Methods.getInjection(false);
			IO.narration("Your heart beats faster. The person continues their melodic humming.");
			break;
		case 1:
			IO.narration("You feel the injection again and your pain begins to fade. But you begin to");
			IO.narration("feel lightheaded and giddy, and it feels as though the room is shifting ");
			IO.narration("and melting under your feet.");
			IO.emptyLine(1);
			Methods.getInjection(false);
			IO.narration("The melody begins to echo in your head as colors collide in the darkness ");
			IO.narration("behind your eyelids. Your throat goes dry.");
			break;
		case 2:
			IO.narration("You hardly feel the needle this time. It feels as though if you stand up you'll");
			IO.narration("float like a half-hearted helium balloon.");
		}
	}




	private static void shotRightArm() 
	{
	// TODO Auto-generated method stub
	
	
	}




	private static void fightHound() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void boxCutter() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void theGoldenRing() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void cutRightF()
	{
		// TODO Auto-generated method stub
		
	}




	private static void cutLeftF() 
		{
		// TODO Auto-generated method stub
		
	}




	private static void shotLeftF() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void theHostage()
	{
		// TODO Auto-generated method stub
		
	}




	private static void shotHostageKnee()
	{
		// TODO Auto-generated method stub
		
	}




	private static void killHostage() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void beatHostage() 
		{
		// TODO Auto-generated method stub
		
	}




	private static void escapeAttempt() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void thePills() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void doYouKnow()
	{
		// TODO Auto-generated method stub
		
	}




	private static void theGroupsOffer() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void houndAsksAboutRing() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void fatalHeadShot() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void theCall() 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
