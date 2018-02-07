class PAWN extends PIECES
{	
	int first_move;
	//-----------------------------------------------------------------------------------------------------------------
	public boolean valid_move(int x,int y)				//piece will move if fuction valid_move returns true
	{
		if(this.colour=='b')		
		{
			if(first_move==0)		//if it is moving first time it can move differently
			{
				if((x==pos_x+1 || x==pos_x+2) && y==pos_y)
				{
					if(x==pos_x+2)
					{
						if(has_piece(x,y)==true || has_piece(x-1,y)==true)
							return false;
						else 
							return true;
					}
					else
					{
						if(has_piece(x,y)==true)
							return false;
						else
							return true;
					}
				}
				else if(check_piece(x,y)==true && has_piece(x,y)==true)		//function to check wheather it can kill (x,y) piece or not
				{
					if(x==pos_x+1 && (y==pos_y+1 || y==pos_y-1))
						return true;
					else 
						return false;
				}
				else
					return false;
			}
			else
			{
				if(x==pos_x+1 && y==pos_y)
				{
					if(has_piece(x,y)==true)
						return false;
					else		
						return true;
				}
				else if(check_piece(x,y)==true && has_piece(x,y)==true)
				{
					if(x==pos_x+1 && (y==pos_y+1 || y==pos_y-1))
						return true;
					else
						return false;
				}
				else	
					return false;
			}
		}
		else				//pawn of white piece's player move in opposite direction
		{
			if(first_move==0)
			{
				if((x==pos_x-1 || x==pos_x-2) && y==pos_y)
				{
					if(x==pos_x-2)
					{
						if(has_piece(x,y)==true || has_piece(x+1,y)==true)
							return false;
						else
							return true;
					}
					else
					{
						if(has_piece(x,y)==true)
							return false;
						else
							return true;
					}
				}
				else if(check_piece(x,y)==true && has_piece(x,y)==true)		//function to check wheather it can kill (x,y) piece or not
				{
					if(x==pos_x-1 && (y==pos_y+1 || y==pos_y-1))
						return true;
					else 
						return false;
				}
				else
					return false;
			}
			else
			{
				if(x==pos_x-1 && y==pos_y)
				{
					if(has_piece(x,y)==true)
						return false;
					else
						return true;
				}
				else if(check_piece(x,y)==true && has_piece(x,y)==true)
				{
					if(x==pos_x-1 && (y==pos_y+1 || y==pos_y-1))
						return true;
					else
						return false;
				}
				else	
					return false;
			}
		}
	}
	//-----------------------------------------------------------------------------------------------------------
	public PAWN(int x,int y,char c)
	{	
		this.first_move=0;			//as it can move 2 squares ahead in its 1st move
		this.pos_x=x;
		this.pos_y=y;
		this.colour=c;
		this.liv_status=1;
	}
}