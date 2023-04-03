import java.util.Scanner;// imports scanner object

public class tictac
{
	String[] gm = {".", ".", ".", ".", ".", ".", ".", ".", "."};
	char[] gma = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	String[] ap = {"0","0","0","0","0","0","0","0","0"};
	String pp;
	Scanner numc = new Scanner(System.in);

	public void printg()
	{
		int b = 0;
		 System.out.print("\n");
		 for (int a = 0; a < 9;a++)
		 {
			System.out.print("\t"  + gm[a]  +  "\t");
			if ((a % 3) == 2)
			{
				System.out.print("\t\t\t\t");
				while(b < 9)
				{ 
					System.out.print("\t"  + gma [b]  +  "\t");
					b++;
					if ((b % 3) == 0)
					{
						System.out.print("\n\n\n\n\n\n");
						break;
					}
				}
			}
		 }
		 System.out.print("\n");
	}

	public int chkwin(String a)
	{
		if(gm[0] == a && gm[1] == a && gm[2] == a)
			return 1;
		if(gm[3] == a && gm[4] == a && gm[5] == a)
			return 1;
		if(gm[6] == a && gm[7] == a && gm[8] == a)
			return 1;
		if(gm[0] == a && gm[4] == a && gm[8] == a)
			return 1;
		if(gm[0] == a && gm[3] == a && gm[6] == a)
			return 1;
		if(gm[1] == a && gm[4] == a && gm[7] == a)
			return 1;
		if(gm[2] == a && gm[5] == a && gm[8] == a)
			return 1;
		if(gm[2] == a && gm[4] == a && gm[6] == a)
			return 1;
		return 0;
	}

	public int input(int b, String[] pnm)
	{
		int c = 0, w = 0, opl, pl;
		while( c < 2)
		{
			printg();
			w = chkwin(pp);
			if (w == 1)
			{
				System.out.print(pp  +  " wins game!\n");
				return w;
			}

			pp = pnm[c];
			
			if(b > 3)
			{					
				System.out.print("\nMake your move player "  +  pp  +  "\nSelect the number you want to move.\n");
				opl = numc.nextInt();
				if (opl < 1 || opl > 9)
				{
					   System.out.print("Wrong input player "  +  pp  +  ". Please enter an integer from 1 to 9\n");
					   continue;
				}
				if(ap[--opl] != pp)
				{
					System.out.print("Wrong input player "  +  pp  +  ". You have no dice there.\n");
					continue;
				}
				System.out.print("Select the number you want to move it to."  + "\n");
				pl = numc.nextInt();
				
				if (pl < 1 || pl > 9)
				{
					   System.out.print("Wrong input player "  +  pp  +  ". Please enter an integer from 1 to 9\n");
					   continue;
				}
				
				if (pl < 1 || pl > 9 && opl < 1 || opl > 9)
				{
					   System.out.print("Wrong input player "  +  pp  +  ". Please enter an integer from 1 to 9\n");
					   continue;
				}
				if(ap[--pl] != "0")
				{
						  System.out.print("That position has alredy benn filled by player "  +  ap[pl]  +  "\n");
						  continue;
				}
				
				if((pl+1) == (opl -2) || (pl+1) == (opl + 4) || (pl+1) == (opl + 2) || (pl+1) == opl )
				{
					ap[pl] = pp;
					gm[pl] = pp;
					ap[opl] = "0";
					gm[opl] = ".";
				}else
				{
					if(opl==4 || pl == 4)
					{
						ap[pl] = pp;
						gm[pl] = pp;
						ap[opl] = "0";
						gm[opl] = ".";
					}else
					{
						continue;
					}
				}
			}else
			{				
				System.out.print("\nMake your move player "  +  pp  + "\n");
				pl = numc.nextInt();
				
				if (pl < 1 || pl > 9)
				{
					   System.out.print("Wrong input player "  +  pp  +  ". Please enter an integer from 1 to 9\n");
					   continue;
				}
				if(ap[--pl] != "0")
				{
					  System.out.print("That position has alredy benn filled by player "  +  ap[pl]  + "\n");
					  continue;
				}
				ap[pl] = pp;
				gm[pl] = pp;
			}
			
			w = chkwin(pp);
			if (w == 1)
			{
				System.out.print(pp  +  " wins the game!\n");
				return w;
			}
			c++;
		}
		return 0;
	}

	tictac(String[] a)
	{
		 int b = 1;
		 int wn = 0;
		 while(wn != 1)
		 {
				System.out.print("\nRound "  +  b  + "\n");
				wn = input(b, a);
				b++;
		 }
	}
}
