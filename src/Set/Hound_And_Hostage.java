package Set;

public class Hound_And_Hostage 
{
//	THIS IS THE OPENING SCENE
//	MOST CHOICES HERE ARE MORALITY-BASED
//	THIS IS A TORTURE SCENE AND THIS DEFINES WHO THE PLAYER GETS TO BE IN THE ENTIRE GAME
	
	
	static String 
	choice,
	switchPath, //for conditional path redirection
	fightAct1="",
	fightAct2=""
	;
	
	static boolean 
	cutRightF=false,
	hostageInRoom=false,
	pastHostageIntro=false;
	;
	
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
		case "cutRightF2": cutRightF2(); break;
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
		houndsIntro();
		
		IO.graphics(Graphics.openEyes);
		IO.narration("You move to get up but Hound pulls out a gun and points it ");
		IO.narration("at you. \"One wrong move and you die,\" he growls. \"Where is it?\"");
		IO.choices("Say \"What are you talking about?\"", "Attack Hound", "", "", "");
		fightAct1="You tackle Hound to the ground.";
		choicesLeadTo("shotRightArm", "fightHound");
	}



	static int pdCnt=0; //playDeadCount -> path to adrenaline overdose
	private static void playDead()
	{
		pdCnt++; //playDead count
		switch(pdCnt)
		{
		case 1:
			IO.narration("You feel a sharp pain on your arm. You peek for a second and see that a blue");
			IO.narration("liquid is being injected into your veins.");
			Methods.getInjection(false);
			IO.narration("Your heart beats faster. The person continues their melodic humming.");
			switchPath="openEyes";
			break;
		case 2:
			IO.narration("You feel the injection again and your pain begins to fade. But you begin to");
			IO.narration("feel lightheaded and giddy, and it feels as though the room is shifting ");
			IO.narration("and melting under your feet.");
			Methods.getInjection(false);
			IO.narration("The melody begins to echo in your head as colors collide in the darkness ");
			IO.narration("behind your eyelids. Your throat goes dry.");
			switchPath="boxCutter";
			break;
		case 3:
			IO.narration("You hardly feel the needle this time. It feels as though if you stand up you'll");
			IO.narration("float like a half-hearted helium balloon.");
			Methods.getInjection(false);
			IO.narration("The humming stops, leaving you in silence. You can feel your heart beating inside");
			IO.narration("your head.");
			IO.emptyLine(1);
			IO.narration("Someone says, \"Shame if you die this way... after everything.\" You hear the crisp");
			IO.narration("sound of every step as they walk towards you slowly.");
			switchPath="theHostage";
			break;
		}
		
		IO.choices("Let them know you're awake", "Pretend to be unconscious", "", "", "");
		choicesLeadTo(switchPath, "playDead");
	}




	private static void shotRightArm() 
	{
		IO.graphics(Graphics.shotRightArm);
		IO.narration("Hound shoots you in the arm!");
		Methods.injury("right arm");
		Methods.change_HP_Atk(-18, -10);
		IO.narration("Hound ignores your scream and says, \"Where is it?\"");
		IO.choices("Say \"I dont't know!\"", "Retaliate", "", "", "");
		
		fightAct1="You kick Hound and he falls backwards.";
		fightAct2="He quickly retrieves the gun and stands, blocking your way to the door.";
		choicesLeadTo("boxCutter", "fightHound");
			
	}




	private static void fightHound() 
	{
		if(!fightAct1.equals(""))
		{
			IO.narration(fightAct1);
		}
		
		IO.emptyLine(1);
		
		if(!fightAct2.equals(""))
		{
			IO.narration(fightAct2);
		}
		
		//START FIGHT CODE------------------------------------------------
		
		
		
		
		
		
		
		
		
		
		
		
		//END FIGHT CODE--------------------------------------------------
		
		//reset
		fightAct1="";
		fightAct2="";
	}




	private static void boxCutter() 
	{
		IO.graphics(Graphics.boxCutter);
		
		if(pdCnt==2) //if player jumped from playDead()
		{
			houndsIntro();
		}
		
		IO.narration("You move to get up but immediately sink back as Hound punches you in the guts");
		IO.narration("and grabs your hand with a vise-like grip. ");
		IO.emptyLine(1);
		IO.narration("\"We all know what they do to thieves, but The Group... they did not order me to");
		IO.narration("chop off a hand in one clean strike. So,\" he says cooly, \"Why don't you just " );
		IO.narration("tell me what you know?\"");
		IO.emptyLine(1);
		IO.narration("He positions a box cutter at the joint of your index finger. He looks at");
		IO.narration("you and awaits your response.");
		IO.choices("Say \"I swear i dont know what you're talking about!\"", "Pull your hand away", "", "", "");
		choicesLeadTo("cutRightF", "shotLeftF");
	}




	private static void cutRightF()
	{
		cutRightF=true;
		
		IO.graphics(Graphics.cutRightF);
		IO.narration("Hound slices your index finger off at the joint!");
		Methods.injury("right hand");
		Methods.change_HP_Atk(-9, -5);
		IO.narration("You are bleeding out. You struggle weakly as Hound discards your severed ");
		IO.narration("finger and playfully wipes the blade on the next one, calmly saying:");
		IO.emptyLine(1);
		IO.narration("\"Tell me now or the next one will not be as clean.\"");
		IO.choices("Say \"I told you I dont know! I can't remember anything!\"", "Stay quiet", "", "", "");
		
		if(PlayerData.HP<=7)
		{
			choicesLeadTo("theHostage", "theHostage");
		}
		else
		{
			choicesLeadTo("cutRightF2", "shotLeftF");
		}
	}




	private static void cutRightF2() 
	{
		IO.graphics(Graphics.cutRightF2);
		IO.narration("Hound quietly proceeds to slice your middle finger.");
		IO.emptyLine(1);
		IO.narration("He severs the bone by forcefully twisting it off before throwing your finger");
		IO.narration("to the back of the room.");
		IO.emptyLine(1);
		Methods.injury("right hand");
		Methods.change_HP_Atk(-7, -5);
		IO.pressEnter("You blacked out.", true);
		
		theHostage();
	}




	private static void shotLeftF() 
	{
		if(cutRightF)
		{
			IO.graphics(Graphics.cutAndShot);
		}
		else
		{
			IO.graphics(Graphics.shotLeftF);
		}
		
		IO.narration("Hound quickly shoots a finger off your other hand!");
		Methods.injury("left hand");
		Methods.change_HP_Atk(-8, -10);//originally -15, -10
		IO.narration("You watch in shock as he picks up your finger and places it in your ");
		IO.narration("shirt pocket.");
		
		IO.pressEnter("You blacked out.", true);
		
		theHostage();
	}




	private static void theHostage()
	{
		hostageInRoom=true;
		pastHostageIntro=true;
		
		if(pdCnt==3)
		{
			houndsIntro();
		}
	}




	private static void shotHostageKnee()
	{
		// TODO Auto-generated method stub
		
	}




	private static void killHostage() 
	{
		// TODO Auto-generated method stub
		
	}




	private static void theGoldenRing() 
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




	private static void houndsIntro() 
	{
		IO.narration("You are seated on a chair, unrestrained, in a small empty room. There is");
		IO.narration("only one door which is currently closed. The walls are stained with");
		IO.narration("splashes of something that has long dried out. No window is in sight.");
		IO.emptyLine(1);
		IO.narration("A tall man in a dark suit holds a syringe away from your arm and looks at");
		IO.narration("you. He caps the needle and places the syringe in his pocket. A small ");
		IO.narration("letter \"H\" is pinned to his shirt collar.");
		IO.emptyLine(1);
		IO.narration("You will call him \"Hound\".");
		IO.emptyLine(1);
	}
	
	
	
	
}
