import java.util.Scanner;

public class tictactoe
{
	public static void main(String[] args)
	{
		String[] a = new String[2];
		Scanner nm = new Scanner(System.in);
		for(int i = 0; i < 2;i++)
		{
			System.out.print("\nPlayer " + (i+1) + " enter initials\n");
			a[i] = nm.nextLine();
		}
		tictac tt = new tictac(a);
		tt.printg();
		nm.close();
		System.out.print("\n\n\nGame over\n\n");
	}
}
