class ROOK extends PIECES
{
	public int firstmove;
	//----------------------------------------------------------------------------------------------
	public boolean valid_move(int x,int y)
	{
		int f=0,i;
		if(pos_x!=x && pos_y!=y)		//can move either horizontal or vertical
			return false;
		if(pos_x==x)					//move horizontally
		{
			if(y>pos_y)						//forward
			{
				for(i=pos_y+1;i<y;++i)			// if there is piece in between it cant cross
				{	
					if(BOARD.square[pos_x][i].liv_status==1)
						return false;
				}
			}
			else if(y<pos_y)				//backward
			{
				for(i=pos_y-1;i>y;--i)
				{
					if(BOARD.square[pos_x][i].liv_status==1)
						return false;
				}
			}
			if(check_piece(x,y)==true || BOARD.square[x][y].liv_status==0)//if postion is empty or piece of opp. player
				return true;
			else 
				return false;
		}
		else if(pos_y==y)										//vertical 
		{
			if(x>pos_x)
			{
				for(i=pos_x+1;i<x;++i)
				{
					if(BOARD.square[i][pos_y].liv_status==1)
						
						return false;
				}
			}
			else if(x<pos_x)
			{
				for(i=pos_x-1;i>x;--i)
				{
					if(BOARD.square[i][pos_y].liv_status==1)
						return false;
				}
			}
			if(check_piece(x,y)==true)//if postion is empty or piece of opp. player
				return true;
			else 
				return false;
		}
		else
			return false;
	}
	//-------------------------------------------------------------------------------
	public ROOK(int x,int y,char c)
	{
		this.pos_x=x;
		this.pos_y=y;
		this.colour=c;
		this.firstmove=0;
		this.liv_status=1;
	}
	void castling(char c)	{}
}