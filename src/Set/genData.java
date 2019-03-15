package Set;

public class genData
{
//	GENERAL GAME DATA
	
	public static int
	pillVal=15, //adds to hp, add 1/3 to strength
	shotVal=10; // subtracts same value from hp, adds to strength
	;
	
	
	//allows me to loop through the arsenal
	public static String weapon[][]=
		{
				//weapon, type, additionalAtk
				{"None", "None", "0" },
				{"Gun", "Firearm", "30"},
				{"Dagger", "Blade", "20"}
		};


}
