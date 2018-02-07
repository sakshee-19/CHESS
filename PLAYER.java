class PLAYER
{
	public int winstatus;
	public char colour;
	public String name;
	KING king=new KING();
	PAWN pawn[]=new PAWN[8];
	QUEEN queen=new QUEEN();
	ROOK rook[]=new ROOK[2];
	BISHOP bishop[]=new BISHOP[2];
	KNIGHT knight[]=new KNIGHT[2];
	static EMPTY empty[][]=new EMPTY[8][8];
	PLAYER(char c, String name)
	{
		this.name = name;
		int i;
		this.colour=c;
		if(this.colour=='b')
		{
			king=new KING(0,4,'b');			//constructor calling
			bishop[0]=new BISHOP(0,2,'b');
			bishop[1]=new BISHOP(0,5,'b');
			rook[0]=new ROOK(0,0,'b');
			rook[1]=new ROOK(0,7,'b');
			knight[0]=new KNIGHT(0,1,'b');
			knight[1]=new KNIGHT(0,6,'b');
			queen=new QUEEN(0,3,'b');//queen
			for(i=0;i<8;++i)
				pawn[i]=new PAWN(1,i,'b');
			BOARD.square[0][4]=king;			//placing pieces in intial position
			BOARD.square[0][2]=bishop[0];
			BOARD.square[0][5]=bishop[1];
			BOARD.square[0][0]=rook[0];
			BOARD.square[0][7]=rook[1];
			BOARD.square[0][1]=knight[0];
			BOARD.square[0][6]=knight[1];
			BOARD.square[0][3]=queen;
			for(i=0;i<8;++i)
				BOARD.square[1][i]=pawn[i];
			int j;
			for(i=0;i<8;++i)
			{
				for(j=0;j<8;++j)
					empty[i][j]=new EMPTY(i,j,'n');
			}
			for(i=2;i<6;++i)
			{
				for(j=0;j<8;++j)
				{
					BOARD.square[i][j]=empty[i][j];
				}
			}
		}
		else
		{//for white pieces
			king=new KING(7,4,'w');			//constructor calling
			bishop[0]=new BISHOP(7,2,'w');
			bishop[1]=new BISHOP(7,5,'w');
			rook[0]=new ROOK(7,0,'w');
			rook[1]=new ROOK(7,7,'w');
			knight[0]=new KNIGHT(7,1,'w');
			knight[1]=new KNIGHT(7,6,'w');
			queen=new QUEEN(7,3,'w');
			for(i=0;i<8;++i)
				pawn[i]=new PAWN(6,i,'w');
			BOARD.square[7][4]=king;			//placing pieces in intial position
			BOARD.square[7][2]=bishop[0];
			BOARD.square[7][5]=bishop[1];
			BOARD.square[7][0]=rook[0];
			BOARD.square[7][7]=rook[1];
			BOARD.square[7][1]=knight[0];
			BOARD.square[7][6]=knight[1];
			BOARD.square[7][3]=queen;
			for(i=0;i<8;++i)
				BOARD.square[6][i]=pawn[i];
		}
	}
}
