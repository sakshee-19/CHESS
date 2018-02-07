class KNIGHT extends PIECES
{
	public boolean valid_move(int x,int y)
	{
		if(check_piece(x,y)==false)				//checking for piece of opposite colour
			return false;
		if((pos_x+1==x || pos_x-1==x) && (pos_y+2==y || pos_y-2==y))    //move of knight two step horizontal 1 vertical 
			return true;
		else if((pos_x+2==x || pos_x-2==x) && (pos_y-1==y || pos_y+1==y)) 		// two step vertical one horizontal
			return true;
		else
			return false;
	}
	public KNIGHT(int x,int y,char c)
	{
		this.pos_x=x;
		this.pos_y=y;
		this.colour=c;
		this.liv_status=1;
	}
	
}