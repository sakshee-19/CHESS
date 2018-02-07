public abstract class PIECES
{
	public  char colour;
	public  int pos_x;
	public  int pos_y;
	public  int liv_status;
	public  void kill(int x,int y)
	{
		BOARD.square[x][y].liv_status=0;
	}
	public String class_name()
	{
		return this.getClass().getSimpleName();
	}
	public  boolean has_piece(int x,int y)		//to check if there is piece or not
	{
		if(BOARD.square[x][y].liv_status==1)
		return true;
		else
		return false;
	}
	public  boolean check_piece(int x,int y)
	{
		if(BOARD.square[x][y].liv_status==1)
		{
			if(BOARD.square[x][y].colour==colour)
			return false;							//if colour is same you cant kill that pieces hence return false
			else
			return true;
		}
		else
			return true;							//if there is no piece it can move there
		
	}
	public  void move(int x,int y)
	{
		if(BOARD.square[x][y].liv_status==1)
			kill(x,y);
		BOARD.square[x][y]=BOARD.square[pos_x][pos_y];
		BOARD.square[pos_x][pos_y]=PLAYER.empty[pos_x][pos_y];
		pos_x=x;
		pos_y=y;
	}
}