package TextBasedGame_BloodyBunny;

public class Data2 extends _HoundsTorture 
{

//	#	WEAPONS AND PLACE DATA ARE STORED HERE
	
	public static class Weapon
	{
		public String name;
		public int addAtk;
		public String type; //blade or firearm;
	}

	
	public static Weapon dagger = new Weapon();
	public static Weapon gun=new Weapon();
	
	
	public static void INITIALIZE_WEAPONS()
	{
		dagger.name="DAGGER";
		dagger.addAtk=23;
		dagger.type="blade";
		
		gun.name="GUN";
		gun.addAtk=30;
		gun.type="firearm";
		
	}
	

	
}
