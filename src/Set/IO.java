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
	static int lineCount=26; //DO NOT CHANGE VALUE. ALWAYS 26. ALWAYS. IT MESSES UP THE FIRST SCENE IF CHANGED.
	
	
	
	
	public static void drawLine() //marks start and end of each page
	{
		narration("______________________________________________________________________________");
		emptyLine(1);
	}
	
	
	
	
	public static void pressEnter(boolean showInstruction)
	{
		if(showInstruction)
		{
			narration("[PRESS ENTER TO CONTINUE]");
		}
		
		pCHOICE=scan.nextLine();
	}
	
	
	
	
	public static void narration(String line) 
	{
		System.out.println(" "+line);
		lineCount++;
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
		
		
		//calculate the space to be taken by the choice display in PART 2
		//empty, narration, empty, cCnt, empty, narration = 5 + cCnt = gap
		
		int temp=5+cCnt;
		lineCount+=temp;
		int textGap=(40-lineCount)/2; //empty lines between last narration() and choices()
		int imgGap=((textGap-graphics.length)/4)*-1; //empty lines above and below the graphics when graphics is inserted
		
//		narration("TG: "+textGap+"\tIG: "+imgGap);
		
		//display graphics:
		
		emptyLine(imgGap); //spaces above
		
		for(int x=0; x<graphics.length; x++)
		{
			narration("    "+graphics[x]); //4 spaces
		}
		
		emptyLine(imgGap); //spaces below
		
//		emptyLine(41-lineCount); gives gap -> ORIGINAL GAP

		//----------------------------------------------------------------------------------
		//PART 2: printing the choice display
		
		emptyLine(1);
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
		lineCount=0;
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

	
	
}
