class QUEEN extends PIECES
{
	//-----------------------------------------------------------------------------------------------------------------
	public boolean valid_move(int x,int y)
	{
		
			int f=0,i,j;
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
				else return false;
			}
			else if(y==pos_y)										//vertical 
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
				if(check_piece(x,y)==true || BOARD.square[x][y].liv_status==0)//if postion is empty or piece of opp. player
					return true;
				else
					return false;
			}
			else
			{
				//diagonal moves
				int cnsnt;
				if(x>pos_x)
					cnsnt=x-pos_x;
				else
					cnsnt=pos_x-x;
				if(pos_y+cnsnt!=y && pos_y-cnsnt!=y)	//if positions are not dioganally wrt intial position 
				return false;
				if(pos_x<x)						//forward dioganal left or right
				{
					if(y>pos_y)//
					{
						for(i=pos_x+1,j=pos_y+1;i<x && j<y;++i,++j)		//right dioganal checking
						{
							if(BOARD.square[i][j].liv_status==1)
								return false;
						}
					}
					else
					{	
						for(i=pos_x+1,j=pos_y-1;i<x &&j>y;++i,--j)		//left dioganal checking
						{
							if(BOARD.square[i][j].liv_status==1)
								return false;
						}	
					}
					if(check_piece(x,y)==true)
						return true;
				}
				else if(x<pos_x)												//backward left or right
				{
					if(pos_y+cnsnt!=y && pos_y-cnsnt!=y)	//if positions are not dioganally wrt intial position 
						return false;
					if(y>pos_y)
					{
						for(i=pos_x-1,j=pos_y+1;i>x && j<y;--i,++j)		//right dioganal checking
						{
							if(BOARD.square[i][j].liv_status==1)
								return false;
						}
					}
					else
					{
						for(i=pos_x-1,j=pos_y-1;i>x &&j>y;++i,--j)		//left dioganal checking
						{
							if(BOARD.square[i][j].liv_status==1)
								return false;
						}
					}
					if(check_piece(x,y)==true)
						return true;
				}
				else
					return false;
			}
					return false;
		}
	//----------------------------------------------------------------------------------------------------------------
	QUEEN()
	{
		
	}
	public QUEEN(int x,int y, char c)
	{
		this.pos_x=x;
		this.pos_y=y;
		this.colour=c;
		this.liv_status=1;
	}
}