import java.util.Scanner;
//Driver class
class GAME
{
	public static void main(String arg[])
	{
		BOARD board;
		Scanner scan = new Scanner(System.in);
		char c;
		System.out.print("** -- Welcome to the Chess Game -- **\n\nEnter your names:: Player 1(White Pieces):  ");
		String p1 = scan.nextLine();
		System.out.print("\n\t\t  Player 2 (Black Pieces):  ");
		String p2 = scan.nextLine();
		System.out.println();
		board =new BOARD(p1,p2);
		c=board.Start_Game();
		if(c=='0')
			System.out.println("\n\nRESULT :: DRAW !!!");
		else if(c=='w')
			System.out.println("\n\n MATE\n\nRESULT :: WINNER - PLAYER 1 ");
		else if(c=='b')
			System.out.println("\n\n RESULT :: WINNER - PLAYER 2 ");
	}
}
