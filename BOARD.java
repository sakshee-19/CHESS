//start game function
import java.util.*;
class BOARD
{
	public static PIECES square[][]=new PIECES[8][8];
	public  int checkm;
	char winner;
	public  PLAYER p1;
	public 	PLAYER p2;
	public char turn='w';
	char chance()
	{
		if(turn=='w')
		return 'b';
		else
		return 'w';
	}
	BOARD(String pname1,String pname2)							//constructor
	{
		this.checkm=0;
		p1=new PLAYER('w', pname1);
		p2=new PLAYER('b', pname2);
	}
	//----------display function---------------
	public void display()
	{
		int i,j,k;
		System.out.println("--------------------------------------------------------------------\n");
		System.out.printf("\t");
		for( k=0;k<8;++k)
			System.out.printf("  %d \t",k);
		System.out.println("\n\n");
		for(i=0;i<8;++i)
		{
			for(j=0;j<8;++j)
			{

				String name=square[i][j].class_name();
				switch(name)
				{
					case "KING": 	if(square[i][j].colour=='w')
									{
									if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("King1\t");
									}
									else
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("King2\t");
									}
									break;
					case "QUEEN":	if(square[i][j].colour=='w')
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("Quen1\t");
									}
									else
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("Quen2\t");
									}
									break;
					case "ROOK":	if(square[i][j].colour=='w')
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("Rook1\t");
									}
									else
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("Rook2\t");
									}
									break;
					case "BISHOP":	if(square[i][j].colour=='w')
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("BISP1\t");
									}
									else
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("BISP2\t");
									}
									break;
					case "PAWN":	if(square[i][j].colour=='w')
									{
										if(j==0)
											System.out.printf("%d:\t",i);

										System.out.printf("Pawn1\t");
									}
									else
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("Pawn2\t");
									}
									break;
					case "EMPTY":	if(j==0)
										System.out.printf("%d:\t",i);
									System.out.printf("----\t");
									break;
					case "KNIGHT":	if(square[i][j].colour=='w')
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("Kngt1\t");
									}
									else
									{
										if(j==0)
											System.out.printf("%d:\t",i);
										System.out.printf("Kngt2\t");
									}
									break;
				}
			}
			System.out.println("\n\n");
		}
		System.out.println("\n----------------------------------------------------------------------");

	}
	//-----------------------------------------
	//-------------to update checkm value 1 if king is killed--------------
	public char checkmate()
	{
		if(p1.king.liv_status==0)
		{
			checkm=1;
			return 'b';
		}
		else if(p2.king.liv_status==0)
		{
			checkm=1;
			return 'w';
		}
		else
			return '0';
	}
	//----------------
	//---------------check function---------------------------------------------------------------------------
	public int check(PLAYER p)			//to check if king is under check
	{
		int kx=-1,ky=-1,i,j,k;
		boolean chck=false;
		if(p==p1)		//for player p1's king
		{
			kx=p1.king.pos_x;
			ky=p1.king.pos_y;		//to fing king's position of player p
			if(kx==-1)	return 0;
			for(i=0;i<8;++i)
			{
				if(chck==true) break;		//if for any piece we found it is checking king then its check situation
				for(j=0;j<8;++j)				//to find if any piece can kill king of player p
				{
					if(square[i][j].liv_status==1)
					{
						if(square[i][j]==p2.king)			//to get if move is possible of all alive pieces to king of opposite player
							chck=p2.king.valid_move(kx,ky);
						else if(square[i][j]==p2.bishop[0])
							chck=p2.bishop[0].valid_move(kx,ky);
						else if(square[i][j]==p2.bishop[1])
							chck=p2.bishop[1].valid_move(kx,ky);
						else if(square[i][j]==p2.rook[0] )
							chck=p2.rook[0].valid_move(kx,ky);
						else if(square[i][j]==p2.rook[1] )
							chck=p2.rook[1].valid_move(kx,ky);
						else if(square[i][j]==p2.knight[0])
							chck=p2.knight[0].valid_move(kx,ky);
						else if(square[i][j]==p2.knight[1])
							chck=p2.knight[1].valid_move(kx,ky);
						else if(square[i][j]==p2.queen)
							chck=p2.queen.valid_move(kx,ky);
						else
						{
							for(k=0;k<8;++k)
							{
								if(square[i][j]==p2.pawn[k] )
									chck=p2.pawn[k].valid_move(kx,ky);
							}
						}
					}
					if(chck==true) break;
				}
			}
			if(chck==true)
				System.out.println("----------------------------------------------------\n\n!!!!! -- CHECK -- !!!!!!\n\n");
		}
		//for player p2's king
		else if(p==p2)
		{
			kx=p2.king.pos_x;
			ky=p2.king.pos_y;
			if(kx==-1)	return 0;
			for(i=0;i<8;++i)
			{
				if(chck==true) break;
				for(j=0;j<8;++j)				//to find if any piece can kill king of player p
				{
					if(square[i][j].liv_status==1)
					{
						if(square[i][j]==p1.king)				//to get if move is possible of all alive pieces to king of opposite player
							chck=p1.king.valid_move(kx,ky);
						else if(square[i][j]==p1.bishop[0])
							chck=p1.bishop[0].valid_move(kx,ky);
						else if(square[i][j]==p1.bishop[1])
							chck=p1.bishop[1].valid_move(kx,ky);
						else if(square[i][j]==p1.rook[0] )
							chck=p1.rook[0].valid_move(kx,ky);
						else if(square[i][j]==p1.rook[1] )
							chck=p1.rook[1].valid_move(kx,ky);
						else if(square[i][j]==p1.knight[0])
							chck=p1.knight[0].valid_move(kx,ky);
						else if(square[i][j]==p1.knight[1])
							chck=p1.knight[1].valid_move(kx,ky);
						else if(square[i][j]==p1.queen)
							chck=p1.queen.valid_move(kx,ky);
						else
						{
							for(k=0;k<8;++k)
							{
								if(square[i][j]==p1.pawn[k] )
									chck=p1.pawn[k].valid_move(kx,ky);
							}
						}
					}
					if(chck==true) break;
				}
			}
			if(chck==true)
				System.out.println("-------------------------------------------------------\n\n!!!!! -- CHECK -- !!!!!!\n\n");

		}
		if(chck==true)
		return 1;
		else
			return 0;
	}
	//---------------------------------------------------------------------------------------
	//------------------game-----------------------------------------------------------------
	public char Start_Game()
	{
		while(checkm==0)
		{
			boolean vm=false;
			int f=1,px=-1,py=-1,nx=-1,ny=-1,c;
			int i ;
			Scanner scan=new Scanner(System.in);
			display();
			//------------player 1----------------------------
			while(f==1)					//to take correct piece position
			{
				System.out.println("** Turn: "+p1.name+" **\n\nNOTE:- you can only move pieces1");
				System.out.println("Enter piece's position you want to pick");
				try{
					px=scan.nextInt();
					py=scan.nextInt();
				} catch (Exception e){
					System.out.println("Error!!! you can only give position's index e.g. 0 1");
					System.out.println("Try again\n-------------------------------------------\n");
					scan.nextLine();
					continue;
				}
				if(px<0 || px >7 || py<0 || py>7)
				{
						System.out.println("INVALID!!!! out of bound\n------------------------------------------------\n");
						continue;
				}
				if(square[px][py].liv_status==0 ||p1.colour != square[px][py].colour)
				{
					System.out.println("\nInvalid positions (There is no piece or not your piece)\n------------------------------------------------\n");
					continue;
				}
				System.out.println("\nEnter position to which you want to place the piece");
				try {
					nx=scan.nextInt();
					ny=scan.nextInt();
				} catch (Exception e){
					System.out.println("Error!!! you can only give position's index e.g. 0 1");
					System.out.println("Try again\n-------------------------------------------\n");
					scan.nextLine();
					continue;
				}
				if(nx<0 || nx >7 || ny<0 || ny>7)
				{
						System.out.println("INVALID!!!! out of bound\n------------------------------------------------\n");
						continue;
				}
				//checking for piece and calling its valid move function
				if(square[px][py]==p1.king)
					vm=p1.king.valid_move(nx,ny);
				else if(square[px][py]==p1.bishop[0])
					vm=p1.bishop[0].valid_move(nx,ny);
				else if(square[px][py]==p1.bishop[1])
					vm=p1.bishop[1].valid_move(nx,ny);
				else if(square[px][py]==p1.rook[0] )
					vm=p1.rook[0].valid_move(nx,ny);
				else if(square[px][py]==p1.rook[1] )
					vm=p1.rook[1].valid_move(nx,ny);
				else if(square[px][py]==p1.knight[0])
					vm=p1.knight[0].valid_move(nx,ny);
				else if(square[px][py]==p1.knight[1])
					vm=p1.knight[1].valid_move(nx,ny);
				else if(square[px][py]==p1.queen)
					vm=p1.queen.valid_move(nx,ny);
				else
				{
					for(i=0;i<8;++i)
					{
						if(square[px][py]==p1.pawn[i] )
							vm=p1.pawn[i].valid_move(nx,ny);
					}
				}
				if(vm==false)
				{
					System.out.println("Invalid move\n------------------------------------------------\n");
					continue;
				}
				else
					break;
			}
			square[px][py].move(nx,ny);
			c=check(p2);
			turn=chance();			//chance 2nd
			winner=checkmate();			//to check if king is killed by p1
			if(checkm==1)
				break;
			display();
			//------------------for player 2------------
			while(f==1)					//to take correct piece position
			{
				System.out.println("** Turn: "+p2.name+" **\n\nNOTE:- you can only move pieces2\n");
				System.out.println("Enter piece's position you want to pick");
				try {
					px=scan.nextInt();
					py=scan.nextInt();

				} catch (Exception e){
					System.out.println("Error!!! you can only give position's index e.g. 0 1");
					System.out.println("Try again\n------------------------------------------------\n");
					scan.nextLine();
					continue;
				}
				if(px<0 || px >7 || py<0 || py>7)
				{
						System.out.println("INVALID!!!! out of bound\n------------------------------------------------\n");
						continue;
				}
				if(square[px][py].has_piece(px,py)==false || (p2.colour != square[px][py].colour))
				{

					System.out.println("Invalid positions (There is no piece or not your piece)\n------------------------------------------------\n");
					continue;
				}
				System.out.println("\nEnter position to which you want to place the piece");
				try {
					nx=scan.nextInt();
					ny=scan.nextInt();
				} catch (Exception e){
					System.out.println("Error!!! you can only give position's index e.g. 0 1");
					System.out.println("Try again\n------------------------------------------------\n");
					scan.nextLine();
					continue;
				}
				if(nx<0 || nx >7 || ny>7 || ny<0)
				{
						System.out.println("INVALID!!!! out of bound\n------------------------------------------------\n");
						continue;
				}
				//checking for piece and calling its valid move function

				if(square[px][py]==p2.king)
					vm=p2.king.valid_move(nx,ny);
				else if(square[px][py]==p2.bishop[0])
					vm=p2.bishop[0].valid_move(nx,ny);
				else if(square[px][py]==p2.bishop[1])
					vm=p2.bishop[1].valid_move(nx,ny);
				else if(square[px][py]==p2.rook[0] )
					vm=p2.rook[0].valid_move(nx,ny);
				else if(square[px][py]==p2.rook[1] )
					vm=p2.rook[1].valid_move(nx,ny);
				else if(square[px][py]==p2.knight[0])
					vm=p2.knight[0].valid_move(nx,ny);
				else if(square[px][py]==p2.knight[1])
					vm=p2.knight[1].valid_move(nx,ny);
				else if(square[px][py]==p2.queen)
					vm=p2.queen.valid_move(nx,ny);
				else
				{
					for(i=0;i<8;++i)
					{
						if(square[px][py]==p2.pawn[i] )
						{
							vm=p2.pawn[i].valid_move(nx,ny);
							break;
						}
					}
				}
				if(vm==false)
				{
					System.out.println("Invalid move\n------------------------------------------------\n");
					continue;
				}
				else
					break;
			}
			square[px][py].move(nx,ny);
			c=check(p1);
			//--------------------------------
			winner =checkmate();			//to check if king is killed by player 2.
			turn=chance();					//chance 1st
		}
		display();
		return winner;
	}
	//----------------------------------------------------------------------------------------------
}
