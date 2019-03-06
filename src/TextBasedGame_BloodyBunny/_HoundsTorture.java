package TextBasedGame_BloodyBunny;


public class _HoundsTorture 
{
	
//	#	THIS IS WHERE THE ENTIRE GAME IS PROGRAMMED
	
//	THIS IS WERE THE PLAYER STARTS OFF
	public static void StartGame() 
	{
		Data.INITIALIZE_CHARACTERS();
		Methods.SET_OPPONENT(Images.hound, Data.HOUND.name, Data.HOUND.weapon, 
				             Data.HOUND.healthPts, Data.HOUND.maxAttack);
		wakeUp();
	}

	
	
	
	private static void wakeUp() 
	{
		Print.IMAGE(Images.playerStart);
		Print.STATUS("You suddenly gain consciousness.");
		Print.PLAYER_INFO();
		Print.STATUS("You are in pain. You can hear someone humming near you.");
//		Print.IMAGE(Images.playerStart);
//		Print.SITUATION("Choose action:");
		Print.CHOICES("OPEN YOUR EYES", "PRETEND TO BE UNCONSCIOUS");
		
		while(!Data.running)
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1")) 
			{
				Methods.RUN();
				openEyes();
				
			}
			else if(Data.ANSWER.contentEquals("2"))
			{
				Methods.RUN();
				playDead(0);				
			}
		}	
	}

	private static void openEyes() 
	{
		Print.IMAGE(Images.hound);
		Print.STATUS("You are seated on a chair, unrestrained.");
		Print.PLAYER_INFO();
		Print.STATUS("You are in a small room. One door, no windows.\n"
				+ "  You see the HOUND pocketing a syringe. He points a GUN at you.");
//		Print.IMAGE(Images.hound);
		Print.STATUS("HOUND: \"Where is it?\"");
//		Print.SITUATION("Choose action: ");
		Print.CHOICES("SAY: \"What are you talking about?\"", "FIGHT HOUND");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1")) 
			{
				Methods.RUN();
				shotRightArm();
				
			}
			else if(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				
				Print.STATUS("You tackle HOUND to the ground.");

				fightHound();
			}
		}	
	}



	private static void fightHound()
	{

		while(Data.PLAYER.healthPts>0 && Data.OPPONENT.alive && !Data.playerForfeits)
		{
			Methods.FIGHT();
		}
		
		if(Data.playerForfeits)
		{
			//he gave up
		}
		
		if(!Data.OPPONENT.alive) 
		{
			//you wander around, get the gun, and find the hostage. 
			//you can also just leave.
		}
	}

	private static void shotRightArm()
	{
		
		Print.STATUS("HOUND shoots your arm!\n");
		
		Methods.PLAYER_INJURY("right arm");
		
		Methods.HEALTH_LOSE(18);
		Methods.ATKPTS_LOSE(10);
		
		Print.PLAYER_INFO();

		Print.IMAGE(Images.houndShotArm);
		Print.STATUS("HOUND: \"Where is it?\"");
//		Print.SITUATION("Choose action:");
		Print.CHOICES("SAY: \"I don't know!\"", "RETALIATE");
		
		while(!Data.running)
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1")) 
			{
				Methods.RUN();
				boxCutterWarning();
				
			}
			else if(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				
				Print.STATUS("You kick HOUND and he falls backwards.");
				Print.STATUS("He quickly retrieves his gun and stands, blocking your way to the door.");
				

				while(Data.PLAYER.healthPts>0 && Data.OPPONENT.alive && !Data.playerForfeits)
				{
					Methods.FIGHT();
				}
				
				if(Data.playerForfeits)
				{
					//he gave up
				}
				
				if(!Data.OPPONENT.alive) 
				{
					//you wander around, get the gun, and find the hostage
					//you can also just leave.
				}
			}
		}	
	}




	private static void boxCutterWarning() 
	{
		Print.IMAGE(Images.boxCutter);
		Print.STATUS("HOUND holds down your hand and positions a box cutter over your index finger.");
		Print.STATUS("HOUND looks at you and awaits your response.");
//		Print.SITUATION("Choose action:");
		Print.CHOICES("SAY: \"I swear I dont know what you're talking about!\"", "PULL YOUR HAND AWAY");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				sliceRightFinger();
			}
			else if(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				shotLeftFingerOff();
			}
		}	
	}




	private static void sliceRightFinger() 
	{
		Print.STATUS("HOUND slices your index finger off at the joint!\n");
		Methods.PLAYER_INJURY("right hand");
		
		Methods.HEALTH_LOSE(9);
		Methods.ATKPTS_LOSE(5);
		Print.PLAYER_INFO();
		Print.STATUS("You struggle weakly. You're bleeding out.");
		Print.STATUS("HOUND: \"Tell me now or the next one won't be as clean.\"");
//		Print.SITUATION("Choose action:");
		Print.CHOICES("SAY: \"I told you I dont know! I can't remember anything!\"", "STAY QUIET");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				sliceRightFinger2();
				
			}
			else if
			(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				shotLeftFingerOff();
			}
		}
	}




	private static void shotLeftFingerOff() 
	{
		Print.STATUS("HOUND shoots a finger off your other hand!\n");
		Methods.PLAYER_INJURY("left hand");
		
		Methods.HEALTH_LOSE(15);
		Methods.ATKPTS_LOSE(10);
		Print.PLAYER_INFO();
		Print.STATUS("He places the finger in your shirt pocket.");
		Print.STATUS("You black out.\n\n\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();		
		Print.LINE();
		theShackledHostage();	
	}




	private static void sliceRightFinger2() 
	{
		Print.STATUS("HOUND quietly proceeds to slice at the next finger.\n"
				+ "  He severs the joint with his hand in a quick twist before proceeding to cut away.");
		
		
		Methods.HEALTH_LOSE(7);
		Methods.ATKPTS_LOSE(5);
		Print.PLAYER_INFO();
		Print.STATUS("You black out.\n\n\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		Print.LINE();
		theShackledHostage();	
	}




	private static void theShackledHostage()
	{
		Print.STATUS("You wake up as HOUND pulls an empty syringe away from your arm.\n"
				+ "  You look around and see that you are no longer alone.");
		Print.STATUS("The shackled HOSTAGE kneels at gunpoint before HOUND.\n"
				+ "  HOSTAGE is beaten up worse than you. His mouth is duct taped.\n"
				+ "  HOUND turns to you.");
		Print.STATUS("HOUND: \"Tell me or he dies!\"");
//		Print.SITUATION("Choose action:");
		Print.CHOICES("SAY: \"Don't kill him!\"", "SAY: \"I don't know him.\"");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				shotHostageKnee();
			}
			else if
			(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				
			}
		}
	}




	private static void shotHostageKnee()
	{
		Print.STATUS("HOUND shoots HOSTAGE in the knee!");
		Print.STATUS("HOSTAGE lets out a muffled scream.");
		Print.STATUS("HOUND: \"Give me a good reason to spare him!\"");
//		Print.SITUATION("Choose action:");
		Print.CHOICES("SAY: \"I did't do anything wrong!\"", "SAY: \"I can help you.\"");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				beatHostageDown();
				
			}
			else if
			(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				
			}
		}
	}




	private static void beatHostageDown()
	{
		Print.STATUS("HOUND kicks HOSTAGE down until he lies still in a pool of blood.\n"
				+ "  He straightens his tie, looks down at HOSTAGE, then walks towards you.");
		Print.IMAGE(Images.gunBetweenEyes);
		Print.STATUS("HOUND points his GUN between your eyes.");
		Print.PLAYER_INFO();
		Print.STATUS("HOUND: \"You know something? People like us... we always do something wrong.\n"
				+ "          But me... heh, i can ALWAYS shoot to kill. This is your last chance.\"");
//		Print.SITUATION("Choose action:");
		Print.CHOICES("ATTACK HOUND", "DO NOTHING");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				fightHound();
				
			}
			else if
			(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				theCall();
			}
		}	
		
	}




	private static void theCall() 
	{
		Print.STATUS("HOUND stops and whispers: \"Yes, sir.\"");
		Print.STATUS("You watch HOUND drag HOSTAGE's body out the door.");
		Print.STATUS("You are now alone. You see something in the pool of blood.");
		Print.CHOICES("SEE WHAT IT IS", "ESCAPE");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
//				pickUpRing();
				
			}
			else if
			(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				escapeAttempt();
				
			}
		}

	}




	private static void escapeAttempt()
	{
		Print.STATUS("You get on your feet as quickly as you can.\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		
		Print.STATUS("You start walking towards the door.\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		
		Print.STATUS("You turn the door knob. It is unlocked!\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		
		Print.STATUS("You quietly open the door.\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		
		
//		rely on luck if you get caught while escaping
		Methods.LEAP_OF_FAITH(25);
		
		if(Data.fortuneSmiles)
		{
			//you escape
			Print.STATUS("You escape!");
		}
		else
		{
			//you get caught
			Print.STATUS("You get caught!");
		}
		
		
	}




	private static void playDead(int i)
	{
				
		switch(i)
		{
//		HOUND tries to wake you up by administering shots
		case 0: 
			Print.STATUS("You feel a sharp pain on your arm.");
			Methods.GET_ADRENALINE(false);
			Print.PLAYER_INFO();
			Print.STATUS("Your heart beats faster. The humming continues."); break;
		case 1:
			Print.STATUS("You feel the injection again.");
			Methods.GET_ADRENALINE(false);
			Print.PLAYER_INFO();
			Print.STATUS("You become light headed. You can feel the room melting around you. "); break;
		case 2:
			Print.STATUS("The pain feels distant. Your heart feels like it's in your brain.");
			Methods.GET_ADRENALINE(false);
			Print.PLAYER_INFO();
			Print.STATUS("The humming stops."); break;	
		}
		

		
		Print.IMAGE(Images.playerStart);
		
		if(i==2) 
		{
			Print.STATUS("Someone whispers: \"Shame if you die now, after everything...\"\n\n\tWhat do you do?");
			Print.SITUATION("Choose action:");
			Print.CHOICES("OPEN YOUR EYES", "PLAY DEAD");
		}
		else 
		{
			Print.SITUATION("Choose action:");
			Print.CHOICES("OPEN YOUR EYES", "WAIT");
		}
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				openEyes();
//				paths to be taken depend on players's health 
//				if he's too weak to survive the torture we jump to hostage scene
				
			}
			else if(Data.ANSWER.contentEquals("2")) 
			{  
				Methods.RUN();
				i++;
				playDead(i);
				
			}
		}	
	}
	
	
	
	
	
	
	
	
	
	
}