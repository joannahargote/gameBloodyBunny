package Classes;

import Scenes._HoundsTorture;
import Visuals.Images;

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
		
		Print.SITUATION("Select action:");
		System.out.println("\t[1] START GAME\n\t[2] ABOUT\n\t[3] QUIT\n");
		
		while(!Data.running) 
		{
			Print.PLAYER();		
			
			if(Data.ANSWER.equals("1")) 
			{
				Methods.RUN();
				Print.LINE();
				System.out.println();
				Print.STATUS("HELLO, PLAYER. CHOOSE WISELY. GOOD LUCK. \n");
			
				_HoundsTorture.StartGame();		
				
			}
			else if(Data.ANSWER.contentEquals("2"))
			{
				Print.LINE();
				System.out.println();
				Print.STATUS("A B O U T    T H I S : \n\n"
						+ "  BY: Joannah C. Argote\n"
						+ "      github.com/joannahargote\n"
						+ "      joannahargotec@gmail.com\n\n"
						+ "   S: March 2019\n\n\n"
						+ "  [PRESS ENTER TO GO BACK]");
				Data.ANSWER=Print.scan.nextLine();
				Menu.main(Images.HANDS);
				
			}
			else if(Data.ANSWER.contentEquals("3"))
			{
				System.out.println();
				Print.STATUS("PLAYER QUIT GAME. THANKS FOR PLAYING!");
				Print.LINE();
				System.exit(1);
			}
		}	
	}
	
	
	
	


}
