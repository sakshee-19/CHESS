class KING extends PIECES
{
	public  int firstmove;
	public  boolean valid_move(int x,int y)
	{
		//checking all surounding conditions
		if((pos_x==x && (pos_y+1==y || pos_y-1==y)) || (pos_y==y && (pos_x+1==x || pos_x-1==x)) ||(pos_x+1==x && (pos_y+1==y || pos_y-1==y)) || (pos_x-1==x &&(pos_y+1==y || pos_y-1==y)))
		{
			if(check_piece(x,y)==true || BOARD.square[x][y].liv_status==0)
			return true;
			else
				return false;
		}
		else
			return false;
	}
	KING()
	{
		
	}
	public KING(int x,int y,char c)
	{
		this.pos_x=x;
		this.pos_y=y;
		this.colour=c;
		this.firstmove=0;
		this.liv_status=1;
	}
	public void castling()
	{
		
	}
}