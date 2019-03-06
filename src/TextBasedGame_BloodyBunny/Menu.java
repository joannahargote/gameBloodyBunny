package TextBasedGame_BloodyBunny;

public class Menu 
{
	
//	#	THIS IS THE START MENU OF THE GAME

	public static void main(String[] args)
	{
		System.out.println(Data.line);
		System.out.println(Data.line);	
		System.out.println(
				 "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]" + "\n"
				+"[]    [][]  [][][]  [][][]  [][]    [][]  []  [][][][][][][][][][][][][][][][][]" + "\n"
				+"[]  []  []  [][]  []  []  []  []  []  []  []  [][][][][][][][][][][][][]    [][]" + "\n"
				+"[]  []  []  [][]  []  []  []  []  []  []  []  [][][][][][]    [][][][]      [][]" + "\n"
				+"[]    [][]  [][]  []  []  []  []  []  []      [][][][][][]  []  [][][]  []  [][]" + "\n"
				+"[]  []  []  [][]  []  []  []  []  []  [][][]  [][][][][][]  []  [][]  []    [][]" + "\n"
				+"[]  []  []  [][]  []  []  []  []  []  [][][]  [][][][][][][]  []  []      [][][]" + "\n"
				+"[]    [][]    [][]  [][][]  [][]    [][][]    [][][][][][][][]          [][][][]" + "\n"
				+"[][][][][][][][][][][][][][][][][][][][][]  [][][][][][][][]              [][][]" + "\n"
				+"[]    [][][][][][][][][][][][][][][][][][]  []  []    [][][]    []  []      [][]" + "\n"
				+"[]    [][][][][][][][][][]  [][][]  [][][]  []  []    [][][]      []        [][]" + "\n"
				+"[]        [][]    []    []    [][]    [][]  []  []    [][][]    []  []    [][][]" + "\n"
				+"[]    []    []    []    []  []  []  []  []  []        [][][][]            [][][]" + "\n"
				+"[]    []    []    []    []  [][]    [][]    [][]    [][][][][][][][][][][][][][]" + "\n"
				+"[]        [][][]        []  [][][]  [][][]  [][]    [][][][][][][][][][][][][][]" + "\n"
				+"[][][][][][][][][][][][][]  [][][][][][][][][][]    [][][][][][][][][][][][][][]" + "\n"
				+"[][][][][][][][][][][][][]  [][][][][][][][][][][][][][][][][][][][][version1.0]"
				);

		System.out.println(Data.line);	
		System.out.println(
				 "\n                 [ S W I T C H   T O    F U L L S C R E E N ]                   \n"
				);
		
		//Print.SITUATION("Type the number of your choice.");
		Print.CHOICES("START GAME","QUIT");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1")) 
			{
				Methods.RUN();
				Print.LINE();
				Print.STATUS("HELLO, PLAYER. CHOOSE WISELY. GOOD LUCK. \n");
			
				_HoundsTorture.StartGame();		
				
			}
			else if(Data.ANSWER.contentEquals("2"))
			{
				System.out.println();
				Print.STATUS("PLAYER QUIT GAME. THANKS FOR PLAYING!");
				Print.LINE();
				System.exit(1);
			}
		}	
	}
	
	
	
	


}
