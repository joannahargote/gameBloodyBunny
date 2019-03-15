package Set;


public class Hound_And_Hostage 
{
//	THIS IS THE OPENING SCENE
//	MOST CHOICES HERE ARE MORALITY-BASED
//	THIS IS A TORTURE SCENE AND THIS DEFINES WHO THE PLAYER GETS TO BE IN THE ENTIRE GAME
	
	static int 
	pdCnt=0 //playDeadCount -> path to adrenaline overdose
	;
	
	static String 
	choice,
	switchPath, //for conditional path redirection
	switchChoice, //like the above, but for choices
	fightAct1="",
	fightAct2="",
	hsLW, //headShotLastWords
	hsD //headShotDescrip
	;
	
	static boolean 
	cutRightF=false,
	hostageInRoom=false,
	pastHostageIntro=false,
	theGroupCalled=false,
	houndTookRing=false
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
		case "doYouKnow": doYouKnow(); break;
		case "theGroupsOffer": theGroupsOffer(); break;
		case "houndAsksAboutRing": houndAsksAboutRing(); break;
		case "headShot": Methods.headShot(hsLW, hsD); break;
		case "theCall": theCall(); break;
		case "welcomeFriend": welcomeFriend(); break;
		
		
		default: 
			IO.narration("STRING DOES NOT MATCH. ERROR.");
			IO.pressEnter("", true);
			break;
		}
	}
	
	
	
	
	public static void startScene()
	{
		//init:
		PlayerData.initialize();
		npcData.initialize();
		

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
		
		if(PlayerData.hp<=7)
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
		IO.narration("You watch in shock as he picks up your finger and places it in your shirt ");
		IO.narration("pocket.");
		
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
		else
		{
			//hound takes a break and helps himself with a pill
			npcData.hound.change_HP_Atk(genData.pillVal, 0);
			
			IO.narration("You wake up as a cold water is poured over your head. After looking around");
			IO.narration("you see that you are no longer alone with your tormentor.");
			IO.emptyLine(1);
		}
		
		IO.narration("A bleeding man kneels at gunpoint before Hound. He is beaten up worse than you.");
		IO.narration("His mouth is duct taped. For a second he glances at you and meets your eyes.");
		IO.narration("Hound sees this and turns back to you.");
		IO.emptyLine(1);
		IO.narration("\"Tell me or he dies!\"");
		IO.choices("Say \"Don't kill him!\"", "Say \"I don't know him\"", "" , "", "");
		choicesLeadTo("shotHostageKnee", "killHostage");
	}




	private static void shotHostageKnee()
	{
		IO.narration("Hound shoots the hostage in the knee!");
		IO.emptyLine(1);
		IO.narration("As the hostage lets out a muffled scream, Hound says, \"Give me a good reason");
		IO.narration("to spare him!\"");
		IO.choices("Say \"I didn't do anything wrong!\"", "Say \"I can help you.\"", "", "", "");
		choicesLeadTo("beatHostage", "doYouKnow");		
	}




	private static void killHostage() 
	{
		IO.narration("The hostage looks at you for the last time before bowing his head in defeat. ");
		IO.narration("You watch him as he waited, unmoving and quiet.");
		IO.emptyLine(1);
		IO.narration("Hound quietly shoots the hostage in the head. You watch as blood pools under");
		IO.narration("his lifeless body.");
		IO.emptyLine(2);

		npcData.hostage.kill();
		
		IO.narration("The silence was broken by a single beep. Hound takes out a mobile phone and answers");
		IO.narration("the call. You hear him say, \"The first on is dead sir... He doesn't seem to");
		IO.narration("remember anything... Yes, sir.\"");
		IO.emptyLine(1);
		IO.narration("With an exasperated sigh, Hound holsters his gun and takes out a small metal ");
		IO.narration("tin. He holds out two of its contents to you: red pills. ");
		IO.emptyLine(1);
		IO.narration("\"Take it. Now. It'll make things easier.\"");
		IO.choices("Take pills", "Do nothing", "", "", "");
		
		if(IO.pCHOICE.contentEquals("1"))
		{
			thePills(true); //he accepted the pills
		}
		else
		{
			thePills(false); //he refused
		}
	}




	private static void thePills(boolean tookPills) 
	{
		if(tookPills) {
			IO.narration("You take the pills and immediately feel more energized.");
			IO.emptyLine(1);
			IO.narration("You feel the pain from your injuries fade slightly.");
			Methods.change_HP_Atk(genData.pillVal*2, 0);
			IO.narration("Hound pockets the metal tin and says, \"I want you to pay attention to what I");
			IO.narration("am about to say.\"");
		}
		else
		{
			IO.narration("Hound waits a moment longer before swallowing a pill and pocketing the metal");
			IO.narration("tin mumbling, \"Just being nice.\"");
			IO.emptyLine(1);
			npcData.hound.change_HP_Atk(genData.pillVal, 0);
			IO.narration("Hound suddenlty moves his arm and you flich. He laughs drily and says, \"Relax,");
			IO.narration("I don't bite.\" He proceeds to pick up a bucket from behind your chair, set it");
			IO.narration("infront of you, and sit on it. He sighs with a friendly smile, although his");
			IO.narration("beady eyes remain sharp.");
			IO.emptyLine(1);
			IO.narration("\"Now that we're all comfortable... I want to announce that I bring you");
			IO.narration("good news!\"");	
		}
		
		IO.pressEnter("", true);
		doYouKnow();	
	}




	private static void doYouKnow()
	{
		// PART 1 ------------------------------------------------------------------------------
		
		if(theGroupCalled)
		{
			IO.narration("Hound opens the door slowly with his gun at hand. He looks around and lowers it");
			IO.narration("after seeing you.");
			IO.emptyLine(1);			
		}
		
		IO.narration("Hound asks,");
		IO.emptyLine(1);
		IO.narration("\"What do you know?\"");
		IO.choices("Say \"That you're a dangerous assh0le\"", "Say \"I told you, I dont remember ANYTHING\"", "", "", "");
		
		
		// PART 2 ------------------------------------------------------------------------------
		
		if(IO.pCHOICE.equals("1"))
		{
			IO.narration("Hound sneers and nods, and then says \"Yes... I get that a lot.\"");
		}
		else
		{
			IO.narration("Hound nods solemnly, then says, \"That puts you in quate a predicament, ");
			IO.narration("doesn't it? ...We can help you.\"");
		}
		
		IO.emptyLine(1);
		IO.narration("He continues, \"You may not trust me after what happened, but you have to know");
		IO.narration("the severity of the crime that you have committed. I know -knew- who you were");
		IO.narration("and you have been manipulated to do something terrible at our expense.");
		IO.pressEnter("", true);
		
		
		// PART 3 ------------------------------------------------------------------------------
		
		IO.narration("\"There is a war coming. A terrible war. Rivers of blood in the streets-- and we");
		IO.narration("know it. The Group can see it coming, which is why it offers you redemption.");
		IO.narration("It wants you to play a vital role in saving thousands of lives. Do you accept?\"");
		
		if(hostageInRoom && npcData.hostage.alive)
		{
			IO.emptyLine(1);
			IO.narration("The hostage suddenly starts screaming something incomprehensible. He meets your");
			IO.narration("eyes and shakes his head frantically.");
			IO.emptyLine(1);
			IO.narration("Hound growls and takes the hostage by the hair. He starts dragging him towards");
			IO.narration("the door. ");
			
			IO.pressEnter("", true);
			
			IO.narration("Halfway across the room, the hostage struggles free and puts something in your");
			IO.narration("hand.");
			
			houndAsksAboutRing();
			
			if(!houndTookRing)
			{
				theSilverRing(true);
			}	
			
			IO.narration("Hound opens the door slowly with his gun in hand. He looks around and lowers");
			IO.narration("it after seeing you.");
			IO.emptyLine(1);
			IO.narration("\"As i was saying... Do you accept our offer?\"");
		}
		
		IO.choices("Say \"Yes\"", "Say \"No\"", "", "", "");
		hsLW="Hound quietly says, \"Shame...\"";
		hsD="Hound shoots you in the dead!";
		choicesLeadTo("theGroupsOffer", "headShot");
	}




	private static void beatHostage() 
	{
		IO.narration("Hound kicks the hostag down until he lies still in a pool of blood. He straightens");
		IO.narration("his tie, looks down and waits for the man to breathe, then walks towards you.");
		IO.emptyLine(1);
		IO.narration("He puts the tip of his gun between your eyes.");
		IO.emptyLine(1);
		IO.narration("\"You know something?\" Hound growls, \"People like us, we never do the right thing");
		IO.narration("the fitst time. But me... heh, I can ALWAYS shoot to kill. This is your last chance.\"");
		IO.choices("Attack Hound", "Do nothing", "", "", "");
		choicesLeadTo("fightHound", "theCall");
	}




	private static void escapeAttempt() 
	{
		IO.narration("You get to your feet as quickly as you can.");
		IO.emptyLine(1);
		IO.narration("You quietly walk to the door.");
		IO.pressEnter("The door is in front of you.", true);
		
		
		IO.narration("You turn the door knob. It is unlocked!");
		IO.emptyLine(1);
		IO.narration("You start to open the door.");
		IO.pressEnter("You can see a portion of the night sky outside.", true);
		
		
		if(Methods.fortuneSmiles(25))
		{
			IO.pressEnter("You escape!", true);
		}
		else
		{
			IO.narration("Hound stands in your way with his suit blood-splattered. He towers over you");
			IO.narration("threateningly.");
			IO.emptyLine(1);
			IO.narration("Hound smiles at you.");
			IO.pressEnter("He says, \"Wrong choice...\"", true);
			
			fightHound();
		}
	}




	private static void theSilverRing(boolean givenToPlayer) 
	{
		if(givenToPlayer)
		{
			IO.narration("You open your hand when the door closes.");
			IO.emptyLine(1);
			IO.narration("On your palm is a silver ring.");
		}
		else
		{
			IO.narration("You slowly get up and walk towards the pool of blood.");
			IO.emptyLine(1);
			IO.narration("You pick up the object and see that it is a silver ring.");
		}
		
		IO.choices("Keep ring", "Discard ring", "", "", "");
		
		if(IO.pCHOICE.contentEquals("1"))
		{
			IO.narration("You pocket the ring.");
		}
		else
		{
			IO.narration("You drop the ring.");
		}

		IO.emptyLine(1);
	}




	private static void theGroupsOffer() 
	{
		IO.narration("Hound nods and says, \"Good choice.\"");
		IO.emptyLine(1);
		
		if(!PlayerData.handLeft && !PlayerData.handRight) //both hands have injured fingers
		{
			IO.narration("He gives you a dagger in its sheath. \"From The Group, as a sign of trust,\" he "); 
			IO.narration("explains. \"My apologies for the fingers.\"");
			
			Methods.changeWeapon("Dagger");
		}
		else
		{
			IO.narration("He gives you his gun. \"From The Group, as a sign of trust,\" he explains. "); 
			IO.narration("\"My apologies for the fingers.\"");
			
			Methods.changeWeapon("Gun");
			npcData.hound.changeWeapon("Dagger");
		}
		
		IO.narration("Hound offers to shake your hand.");
		
		if(PlayerData.weapon.equals("Gun"))
		{
			switchChoice="Shoot Hound";
			fightAct1="Hound pauses as he looks down at the bleeding hole in his abdomen.";
			fightAct2="He pulls out a dagger from its sheath hidden within his suit.";
		}
		else
		{
			switchChoice="Stab Hound";
			fightAct1="Hound pauses as you pull the blade out of his abdomen.";
			fightAct2="He pulls out out his gun.";
		}
		
		IO.choices("Shake his hand", switchChoice, "", "", "");
	}




	private static void houndAsksAboutRing() 
	{
		IO.emptyLine(1);
		IO.narration("Hound kicks him away from you.");
		IO.emptyLine(1);
		IO.narration("He asks, \"Did he give you anything?\"");
		IO.choices("Say \"Yes\"", "Say \"No\"", "", "", "");
		
		if(IO.pCHOICE.equals("1"))
		{
			IO.narration("Hound takes whatever is in your hand and immediately pockets it.");
			IO.narration("He says, \"Stay here\".");
			houndTookRing=true;
		}
		
		IO.pressEnter("Hound then proceeds to drag the hostage out.", true);
	}




	private static void theCall() 
	{
		theGroupCalled=true;
		hostageInRoom=false;
		
		IO.narration("The mobile rings again and Hound answers it.");
		IO.emptyLine(1);
		IO.narration("He blinks, looks at you, then says, \"Yes, sir\".");
		
		
		
		
		
		
		
	}




	private static void welcomeFriend() 
	{
		IO.pressEnter("welcomeFriend", true);
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
