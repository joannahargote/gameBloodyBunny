package Set;

import java.util.Arrays;


public class StartMenu
{

	public static void main(String[] args) 
	{
//		42 lines per page
		System.out.print(
				 " ______________________________________________________________________________ " + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                          H E L L O ,  F R I E N D .                          |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                      1212121212121212121222 21221112121                      |" + "\n"
				+"|                      1222221212122121111121   112112121                      |" + "\n"
				+"|                      2212121212121  1121212   121212121                      |" + "\n"
				+"|                      121212121212  12121212    21212121                      |" + "\n"
				+"|                      2212121212    1212121      2121211                      |" + "\n"
				+"|                      221212122    1212112      11122121                      |" + "\n"
				+"|                      121212122   21212121     121212112                      |" + "\n"
				+"|                      1212121212   2212121    1212221121                      |" + "\n"
				+"|                      22122122121   122121   12121112121                      |" + "\n"
				+"|                      1121212122              2122212121                      |" + "\n"
				+"|                      112122212                121121212                      |" + "\n"
				+"|                      221212221                 21212121                      |" + "\n"
				+"|                      12121221                  11221212                      |" + "\n"
				+"|                      1121212                    1212112                      |" + "\n"
				+"|                      211221212                 12212122                      |" + "\n"
				+"|                      2211212212              1221212112                      |" + "\n"
				+"|                      1121212121122         121212121112                      |" + "\n"
				+"|                      2212121121112122   121221212121212                      |" + "\n"
				+"|                      2212112121121221221212121212121121                      |" + "\n"
				+"|                      2121212122221212212121121212121212                      |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                 PLEASE DRAG THE EDGES OF YOUR CONSOLE TO FIT                 |" + "\n"
				+"|                                   THE FRAME                                  |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                   WHEN DONE                                  |" + "\n"
				+"|                           [ P R E S S   E N T E R ]                          |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|                                                                              |" + "\n"
				+"|______________________________________________________________________________|" + "\n"
				);
		
		IO.pCHOICE=IO.scan.nextLine();
		IO.pCHOICE="0";
		
		
		startMenu();
	}
	
	
	
	
	public static void startMenu()
	{
		IO.drawLine();
		
		System.out.print(
				 "                                                                                " + "\n"
				+"                                                                                " + "\n"
				+"                              J.C.Argote Presents                               " + "\n"
				+"                                                                                " + "\n"
				+"                                                                                " + "\n"
				+"                       1212121212121212121222 21221112121                       " + "\n"
				+"                       1222221212122121111121   112112121                       " + "\n"
				+"                       2212121212121  1121212   121212121                       " + "\n"
				+"                       121212121212  12121212    21212121                       " + "\n"
				+"                       2212121212    1212121      2121211                       " + "\n"
				+"                       221212122    1212112      11122121                       " + "\n"
				+"                       121212122   21212121     121212112                       " + "\n"
				+"                       1212121212   2212121    1212221121                       " + "\n"
				+"                       22122122121   122121   12121112121                       " + "\n"
				+"                       1121212122              2122212121                       " + "\n"
				+"                       112122212                121121212                       " + "\n"
				+"                       221212221                 21212121                       " + "\n"
				+"                       12121221                  11221212                       " + "\n"
				+"                       1121212                    1212112                       " + "\n"
				+"                       211221212                 12212122                       " + "\n"
				+"                       2211212212              1221212112                       " + "\n"
				+"                       1121212121122         121212121112                       " + "\n"
				+"                       2212121121112122   121221212121212                       " + "\n"
				+"                       2212112121121221221212121212121121                       " + "\n"
				+"                       2121212122221212212121121212121212                       " + "\n"
				+"                       __________________________________                       " + "\n"
				+"                      |                                  |                      " + "\n"
				+"                      |     B L O O D Y    B U N N Y     |                      " + "\n"
				+"                      |__________________________________|                      " + "\n"
				+"                                                                                " + "\n"
				+"                          A Text-based Adventure Game                           " + "\n"
				+"                                                                                " + "\n"
				+"                                                                                " + "\n"
				+"                                                                                " + "\n"
				+"                                                                                " + "\n"
				+"                              Select Action:                                    " + "\n"
				+"                                                                                " + "\n"
				+"                              [1] Start Game                                    " + "\n"
				+"                              [2] About                                         " + "\n"
				+"                              [3] Quit                                          " + "\n"
				+"                                                                                " + "\n"
				);
		
		String cnum[]= {"1", "2", "3"}; //choice number
		
		while(!Arrays.asList(cnum).contains(IO.pCHOICE))
		{
			System.out.print("                              > ");
			IO.pCHOICE=IO.scan.nextLine();
		}

		
		//processing user choice:
		switch (IO.pCHOICE)
		{
		case "1":
			Hound_And_Hostage.startScene(); 
			break;
		case "2":
			//put an about page here 
		case "3":
			System.exit(1); break;
		}
	}


}
 