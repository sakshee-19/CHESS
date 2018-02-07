class BISHOP extends PIECES
{
	//------------------------------------------------------------------------------------------------------
	public boolean valid_move(int x,int y)
	{
		int cnsnt,i,j;
		if(x>pos_x)
			cnsnt=x-pos_x;
		else
			cnsnt=pos_x-x;
		if(pos_x<x)						//forward dioganal left or right
		{
			if(pos_y+cnsnt!=y && pos_y-cnsnt!=y)//	//if positions are not dioganally wrt intial position 
				return false;
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
		return false;
	}
	//------------------------------------------------------------------------------------------------------------
	public BISHOP(int x,int y,char c)
	{
		this.pos_x=x;
		this.pos_y=y;
		this.colour=c;
		this.liv_status=1;
	}
	
}