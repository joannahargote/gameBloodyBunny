package ProgTools;


public class Data 
{

//	#	CHARACTER AND GAME DATA ARE STORED HERE
	
	public static String line=     "================================================================================";
	public static String fightLine="===[ F I G H T ]================================================================";
	public static boolean hpAndAkDisplayed=false; //i use this to make a line after the display of health and atk update
	
	
//	FOR GAMEPLAY:
	public static String ANSWER="0";
	public static boolean running=false; //is game still "running"?
	public static boolean playerForfeits=false;
	public static boolean fortuneSmiles=false;//for little unexpected turn of events
	
//	PLAYER'S INJURIES LIMIT HIS ABILITIES
	public static boolean OK_rightArm=true;//injured arms can't punch
	public static boolean OK_rightHand=true;//injured hands can't hold weapons
	public static boolean OK_leftArm=true;
	public static boolean OK_leftHand=true;
	public static boolean OK_rightLeg=true;//injured legs can't run or kick
	public static boolean OK_leftLeg=true;
	public static boolean canFireGun_right=true; //depends if he has his index fingers (thanks to hound)
	public static boolean canFireGun_left=true;
	
	
	
	public static int healthPillValue=25;
	public static int adrenalineShotValue=10;
		
	
//	FOR CHARACTERS

	public static class Character
	{
		
		public String name; //for OPPONENT in fights
		public String[] image;
		public String role; //friend, foe, or neutral 
		public boolean masked; //do they wear a mask
		public String weapon; //knife, gun, none, stick, etc.
		public String weaponType;//used to determine attack move
		public int maxAttack; //depends on weapon and injury
		public int healthPts; //injury has an impact too
		public int healthPill; //adds to health
		public int adrenalineShot; //adds to health limited
		public boolean alive; //everyone except the player can be revived if the player figures it out		
		public String[] inventory;
	}
	
	
	//SHELL FOR CURRENT ENEMY. DATA IS USED FOR FIGHTS. TAKES IMAGE, NAME, WEAPON, HEALTH POINTS, AND MAX ATTACK;
	public static Character OPPONENT = new Character();
	
	//BY ORDER OF APPEARANCE
	
	public static Character PLAYER=new Character();
	
	public static Character HOUND=new Character();

	public static Character HOSTAGE=new Character();
			
			
	public static void INITIALIZE_CHARACTERS()
	{
		
//		this initializes all the characters in the game
		
		
		PLAYER.healthPts=39;//DO NOT CHANGE. 39 is the initial HP
		PLAYER.weapon="None";
		PLAYER.weaponType="none";
		PLAYER.maxAttack=27;
		PLAYER.inventory=new String[5];
//		PLAYER.healthPill=1;
//		PLAYER.adrenalineShot=2;
		
		
		HOUND.name="HOUND";
		HOUND.healthPts=90;
		HOUND.weapon="GUN";
		HOUND.weaponType="firearm";
		HOUND.maxAttack=70;
		HOUND.alive=true;
		HOUND.inventory=new String[5];
		
		
		HOSTAGE.alive=true;
	}		
			
			
	
}
