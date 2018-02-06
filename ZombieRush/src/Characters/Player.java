package Characters;

public class Player extends Character{
	private int hp,x,y,stage,gold;
	private String name;
	public Player(int hp, int x, int y, int stage, int gold, String name)
	{
		super(x,y,hp, gold, gold);
		this.name = name;
	}
	
	@Override
	public int gethp() {
		// TODO Auto-generated method stub
		return this.hp;
	}
	
	@Override
	public int[] getposition() {
		// TODO Auto-generated method stub
		int[]position = new int[2];
		position[0] = this.x;
		position[1] = this.y;
		return position;
	}
}
