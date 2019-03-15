package Set;

import java.util.Arrays;
import java.util.Scanner;

public class IO
{
//	#IO STANDS FOR "INPUT/OUTPUT"#
//	THIS CLASS MANAGES SCANS AND PRINTS
	
	public static String pCHOICE;
	public static Scanner scan= new Scanner(System.in);
	
	//counts are set in narration and emptyLine
	static int lineCount;//value set in drawLine()	
	
	
	
	public static void drawLine() //marks start and end of each page
	{
		narration("______________________________________________________________________________");
		emptyLine(1);
		lineCount=1;
	}
	
	
	
	
	public static void pressEnter(String narration, boolean showInstruction)
	{
		//PART 1: set the gap to print the choice display in bottom of page
		
		int btmTextCnt=5; //bottom text count -> narration, emptySpaces[2], [Press en..], (added 1 for space adjustment)
		int emptySpc=43-(lineCount+btmTextCnt);
		
		//----------------------------------------------------------------------------------
		//PART 2: printing and positioning the image
		
		int remSpc=emptySpc-graphics.length; //remaining space with no text
		int gap=remSpc/2; //spaces above and below image
		
		emptyLine(gap);
		
		for(int x=0; x<graphics.length; x++)
		{
			narration("    "+graphics[x]); //printing the image.
		}
		
		if(remSpc%2==1)
		{
			emptyLine(gap+1);
		}
		else
		{
			emptyLine(gap);
		}
		
		//----------------------------------------------------------------------------------
		//PART 3: printing the choice display
		
		narration(narration);
		emptyLine(2);
	
		if(showInstruction)
		{
			narration("[PRESS ENTER TO CONTINUE]");
		}
		
		pCHOICE=scan.nextLine();
		
		if(!IO.pCHOICE.equals("0"))
		{
			IO.pCHOICE="0";
		}
		
		//print bottom line
		drawLine();
		graphics(Graphics.emptyFrame); //clear out array for image		
	}
	
	
	
	
	public static boolean methodPrinted; // prevents double spacing between two methods that print from Methods.java
	
	public static void narration(String line) 
	{
		System.out.println(" "+line);
		lineCount++;
		methodPrinted=false;
	}
	
	
	
	
	public static void emptyLine(int cnt)//count -> number of empty lines printed
	{
		int x=0;
		while(x<cnt) {
			System.out.println();
			lineCount++;
			x++;
		}
	}
	
	
	
	
	//goes hand-in-hand with choicesLeadTo();
	//choicesLeadTo() is unique in every scene and is coded there
	public static void choices(String s1, String s2, String s3, String s4, String s5)
	{
		//PART 1: set the gap to print the choice display in bottom of page
		
		int cCnt=0; //choiceCount

		//save entries to array:
		String choices[]= {s1, s2, s3, s4, s5};
		
		for(int x=0; x<choices.length; x++) 
		{
			if(!choices[x].equals(""))//if it has content
			{
				cCnt++;				
			}
		}
		
		int choiceSpc=cCnt+4; //choiceSpace -> lines occupied by choices at the bottom
		int emptySpc=43-(lineCount+choiceSpc);
		
		//----------------------------------------------------------------------------------
		//PART 2: printing and positioning the image
		
		int remSpc=emptySpc-graphics.length; //remaining space with no text
		int gap=remSpc/2; //spaces above and below image
		
		emptyLine(gap);
		
		for(int x=0; x<graphics.length; x++)
		{
			narration("    "+graphics[x]); //printing the image.
		}
		
		if(remSpc%2==1)
		{
			emptyLine(gap+1);
		}
		else
		{
			emptyLine(gap);
		}
		
		//----------------------------------------------------------------------------------
		//PART 3: printing the choice display
		
		narration("\t What will you do?");
		emptyLine(1);
	
		
		//displays choices:
		for(int x=0; x<choices.length; x++) 
		{
			if(!choices[x].equals(""))//if it has content
			{
				narration("\t ["+(x+1)+"] "+choices[x]);
			}
		}
		
		emptyLine(1);
		
		pCHOICE="0";
	
		String cNum[]=new String[cCnt]; //choiceNumber -> used in input checking
		
		for(int x=0; x<cCnt; x++)
		{
			cNum[x]=String.valueOf(x+1);
		}
		
		//inputChecking:
		while(!Arrays.asList(cNum).contains(pCHOICE))
		{
			//get playerChoice:
			System.out.print(" \t > "); //like colossal game adventure
			pCHOICE=scan.nextLine();
		}
		
		//print bottom line
		drawLine();
		graphics(Graphics.emptyFrame); //clear out array for image
	}
	
	
	
	
	//method called outside, variable called in choices()
	static String graphics[];
	public static void graphics(String img[]) //sets ASCII graphics from Graphics.java for use in this class
	{
		graphics = new String[img.length];
		
		for(int x=0; x<img.length; x++) //copies elements to local variable graphics[]
		{
			graphics[x]=img[x];
		}
	}



	static String startMenu[]=new String[1];
	public static void dead()
	{
		emptyLine(40);
		pressEnter("YOU DIED.",true);
		StartMenu.main(startMenu);
	}

	
	
}
