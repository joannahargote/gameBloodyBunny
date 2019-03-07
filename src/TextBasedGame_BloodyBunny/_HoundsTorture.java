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
		Print.STATUS("HOUND: \"Where is it?\"");
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
		Data.playerForfeits=false;  
		
		while(Data.PLAYER.healthPts>0 && Data.OPPONENT.alive && !Data.playerForfeits)
		{
			Methods.FIGHT();
		}
		
		if(Data.playerForfeits)
		{
			Print.LINE();
			
			if(Data.PLAYER.healthPts>10) 
			{
				Methods.CHANCE(40);
				
				if(Data.fortuneSmiles) 
				{
					Print.STATUS("HOUND shoots your knee as you run to the door!");
					Methods.CHANCE(50);
					if(Data.fortuneSmiles)
					{
						Methods.PLAYER_INJURY("left leg");
					}
					else
					{
						Methods.PLAYER_INJURY("right leg");
					}
					
					
					Methods.HEALTH_LOSE((int) (Data.PLAYER.healthPts * 0.75));
					Methods.ATKPTS_LOSE((int) (Data.PLAYER.maxAttack * 0.50));
					
					Print.STATUS("Time passed in a painful blur.\n\n  [PRESS ENTER TO CONTINUE]");
					Data.ANSWER=Print.scan.nextLine();
					
					//JUMP TO THE HOSTAGE SCENE- too weak to endure torture
					Print.LINE();
					theShackledHostage();
					
				}
				else
				{
					fatalHeadShot("HOUND shoots you in the back of the head as you run to the door!", 35);
				}
			}
			else
			{
				Print.STATUS("HOUND catches you before you reach the door.\n  He beats you up until you lost consciousness.");
				Methods.HEALTH_LOSE(6);
				Print.STATUS("[PRESS ENTER TO CONTINUE]");
				Data.ANSWER=Print.scan.nextLine();	
			
				Print.LINE();
				theShackledHostage();
			}
		}
		
		if(!Data.OPPONENT.alive) 
		{
			//you wander around, get the gun, and find the hostage. 
			//you can also just leave.
		}
		
	}

	private static void fatalHeadShot(String descrip, int luck) 
	{
		Print.STATUS(descrip);
		Print.STATUS("Within a second everything went dark and quiet.\n\n [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		
		//YOU CAN DIE, OR THE MINER GETS YOU.
		Methods.CHANCE(luck);
		
		if(Data.fortuneSmiles) 
		{
			Print.STATUS("You somehow survive. You wake up in a shack. \n "
					+ "the old miner knows you and says that YOUR FRIEND werent as lucky.");
		}
		else 
		{
			Methods.HEALTH_LOSE(Data.PLAYER.healthPts);
		}
	}




	private static void shotRightArm()
	{
		
		Print.STATUS("HOUND shoots your arm!\n");
		
		Methods.PLAYER_INJURY("right arm");
		
		Methods.HEALTH_LOSE(18);
		Methods.ATKPTS_LOSE(10);
		
//		Print.PLAYER_INFO();

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
				
				fightHound();
			}
		}	
	}




	private static void boxCutterWarning() 
	{
		
		Print.STATUS("HOUND holds down your hand firmly over the arm rest of your chair.");
		Print.STATUS("HOUND: \"We both know what The Group does to theives. But... they didn't\n"
			    	+ "          specifically order me to chop it off in one clean strike.\n"
			    	+ "          So why don't you just tell me what you know?\"");
		Print.IMAGE(Images.boxCutter);
		Print.STATUS("HOUND positions a box cutter over your index finger. ");
		Print.STATUS("HOUND looks at you and awaits your response.");
		Print.CHOICES("SAY: \"I swear I dont know what you're talking about!\"", "PULL YOUR HAND AWAY");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				sliceLeftFinger();
			}
			else if(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				shotRightFingerOff();
			}
		}	
	}




	private static void sliceLeftFinger() 
	{
		Print.STATUS("HOUND slices your index finger off at the joint!");
		Methods.PLAYER_INJURY("left hand");
		Print.IMAGE(Images.sliceLeftFinger1);
		
		Methods.HEALTH_LOSE(9);
		Methods.ATKPTS_LOSE(5);
		Print.STATUS("You struggle weakly. You're bleeding out.");
		Print.STATUS("HOUND: \"Tell me now or the next one won't be as clean.\"");
		Print.CHOICES("SAY: \"I told you I dont know! I can't remember anything!\"", "STAY QUIET");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				sliceLeftFinger2();
				
			}
			else if
			(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				shotRightFingerOff();
			}
		}
	}




	private static void shotRightFingerOff() 
	{
		Print.STATUS("HOUND shoots a finger off your other hand!");
		Methods.PLAYER_INJURY("right hand");
		Print.IMAGE(Images.shotRightFinger);
		
		Methods.HEALTH_LOSE(15);
		Methods.ATKPTS_LOSE(10);
//		Print.PLAYER_INFO();
		Print.STATUS("He places the finger in your shirt pocket.");
		Print.STATUS("You black out.\n\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();		
		Print.LINE();
		theShackledHostage();	
	}




	private static void sliceLeftFinger2() 
	{
		Print.STATUS("HOUND quietly proceeds to slice at the next finger.\n"
				+ "  He severs the joint with his hand in a quick twist before proceeding.");
		Methods.PLAYER_INJURY("left hand");
		Print.IMAGE(Images.sliceLeftFinger2);
		
		Methods.HEALTH_LOSE(7);
		Methods.ATKPTS_LOSE(5);
		Print.STATUS("You black out.\n\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		Print.LINE();
		theShackledHostage();	
	}




	private static void theShackledHostage()
	{
//		HOUND GETS A BREAK AND PROBABLY TAKES A PILL
		Data.HOUND.healthPts+=25;
		
		Print.STATUS("You wake up as HOUND pours a bucket of cold water over your head.\n"
				+ "  You look around and see that you are no longer alone.");
		
		
		Print.STATUS("The shackled HOSTAGE kneels at gunpoint before HOUND.\n"
				+ "  HOSTAGE is beaten up worse than you. His mouth is duct taped.\n"
				+ "  HOUND turns to you.");
		Print.STATUS("HOUND: \"Tell me or he dies!\"");
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
				killHostage();
				
			}
		}
	}




	private static void killHostage() 
	{
		Print.STATUS("HOSTAGE looks at you with tears in his eyes before bowing his head\n"
				+ "  in defeat. He waits, still and silent.");
		Print.STATUS("HOUND shoots HOSTAGE in the head.\n"
				+ "  You watch as blood pools under his lifeless body.");

//		i can put a chance here. 75 percent, he dies. else, HOUND shoots his leg repeatedly and breaks it.
//		if hostage lives, there's a 60% chance he stays in prison to be saved, or he becomes the HERALD with a limp. 
//		if HOSTAGE=HERALD, he feels betrayed and wants to kill PLAYER. They knew each other from before.
//		HERALD (with or without limp) sends PLAYER orders from the Group.
		
		
//		he's supposed to recruit you now and you are ordered to dispose of the body
//		you get the mask
		
		Print.STATUS("You hear HOUND say: \"Dead, sir... He doesn't seem to remember anything...\n"
				+ "                       Yes, sir.\"");
		Print.STATUS("HOUND turns to you. With a gloved hand he takes two of the contents of a\n"
				+ "  small silver case from his pocket and offers them to you: RED PILLS.");
		Print.STATUS("HOUND: \"Take it. Now. You'll feel better.\"");
		Print.CHOICES("TAKE PILLS", "DO NOTHING");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				thePills(true);
				
			}
			else if
			(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				thePills(false);
			}
		}

	}




	private static void thePills(boolean acceptPills)
	{
		if(acceptPills)
		{
			Print.STATUS("You take the pills and immediately feel more energized.\n"
					+ "  The pain from your injuries is slightly muted.");
			Methods.HEALTH_GAIN(Data.healthPillValue*2);
			
			Print.STATUS("HOUND: \"Now that you're not dying I want you to listen.\"\n\n"
					+ " [PRESS ENTER TO CONTINUE]");
		}
		else
		{
//			you still don't trust HOUND. If you fight him, he'll kill you for sure.
			Print.STATUS("HOUND: \"...Your call.\"");
			Print.STATUS("HOUND eats one and retuns the other to the silver case.");
			Data.HOUND.healthPts+=25;
			Print.STATUS("HOUND: \"Now I am going to tell you something, and I would appreciate it\n"
					+ "          greatly if you behave yourself and listen.\"\n\n"
					+ " [PRESS ENTER TO CONTINUE]");
		}
		
		Data.ANSWER=Print.scan.nextLine();
		doYouKnow();
	}


	private static void doYouKnow()
	{
//		HOUND SWEET TALKS YOU INTO JOINING THE GROUP
		Print.STATUS("HOUND: \"Do you know who you are?\"");
		Print.CHOICES("SAY: \"No.\"", "SAY: \"Yes, but this isn't real!\"");
//		
//		while(!Data.running) 
//		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				Print.STATUS("HOUND: \"I know that now. You may not trust me after what happened, but \n"
						+ "          you have to understand the severity of what you have committed. \n"
						+ "          I know who you are, and you have been manipulated to do something\n"
						+ "          terrible at our expense.\" \n\n"
						+ " [PRESS ENTER TO CONTINUE]");
			}
			else
//			(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				Print.STATUS("HOUND: \"You're thinking that this might as well be a cruel game, but I\n"
						+ "          know who you are... and what they did to you.\"\n\n"
						+ " [PRESS ENTER TO CONTINUE]");
			}
//		}
		
		Data.ANSWER=Print.scan.nextLine();
		
		Print.STATUS("HOUND: \"There is a war coming. A terrible war. The Monarchs want rivers\n"
				  + "          of blood in the streets, and only one thing can stop it: The Group.\n"
				  + "          The Group spared your life and chose you for a mission that offers\n"
				  + "          you redemption. The Group will save this world from the Monarchs, \n"
				  + "          cleanse it, so to speak, and you can be a part of it.\n"
				  + "          Do you accept?\"");
			
		Print.CHOICES("SAY: \"Yes.\"", "SAY: \"I would rather die!\"");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1"))
			{
				Methods.RUN();
				Print.STATUS("You are now BLOODY BUNNY");
				
			}
			else if
			(Data.ANSWER.contentEquals("2")) 
			{
				Methods.RUN();
				Print.STATUS("HOUND: \"Shame...\""); 
				fatalHeadShot("HOUND shoot you in the head!", 20);
				
			}
		}

	}




	private static void shotHostageKnee()
	{
		Print.STATUS("HOUND shoots HOSTAGE in the knee!");
		Print.STATUS("HOSTAGE lets out a muffled scream.");
		Print.STATUS("HOUND: \"Give me a good reason to spare him!\"");
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
		Print.STATUS("You get on your feet as quickly as you can.\n\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		
		Print.STATUS("You start walking towards the door.\n\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		
		Print.STATUS("You turn the door knob. It is unlocked!\n\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		
		Print.STATUS("You quietly open the door.\n\n  [PRESS ENTER TO CONTINUE]");
		Data.ANSWER=Print.scan.nextLine();
		
		
//		rely on luck if you get caught while escaping
		Methods.CHANCE(25);
		
		if(Data.fortuneSmiles)
		{
			//you escape
			Print.STATUS("You escape!");
		}
		else
		{
			//you get caught
			Print.STATUS("HOUND stands in your way with his suit blood-splattered.\n  He towers over you threateningly.");
			Print.STATUS("HOUND walks toward you slowly.");
			Print.STATUS("HOUND: \"Wrong choice...\"\n\n  [PRESS ENTER TO CONTINUE]");
			Data.ANSWER=Print.scan.nextLine();
			
			System.out.println(Data.fightLine);
			fightHound();
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
			Print.STATUS("Your heart beats faster. The humming continues."); break;
		case 1:
			Print.STATUS("You feel the injection again.");
			Methods.GET_ADRENALINE(false);
			Print.STATUS("You become light headed. You can feel the room melting around you. "); break;
		case 2:
			Print.STATUS("The pain feels distant. Your heart feels like it's in your brain.");
			Methods.GET_ADRENALINE(false);
			Print.STATUS("The humming stops."); break;	
		}
		

		
		Print.IMAGE(Images.playerStart);
		
		if(i==2) 
		{
			Print.STATUS("Someone whispers: \"Shame if you die now, after everything...\"\n\n\tWhat do you do?");
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
