package Characters;

public class Zombie extends Character{
	private int lvl;
	private int dmg;
	private int hp;
	private int x,y;
	public Zombie(int lvl, int dmg, int hp, int x, int y)
	{
		super(hp,x,y);
		this.lvl = lvl;
		this.dmg = dmg;
	}

	@Override
	public int gethp() {
		// TODO Auto-generated method stub
		return this.hp;
	}
	
	@Override
	public int[]getposition() {
		// TODO Auto-generated method stub
		int[]position = new int[2];
		position[0] = this.x;
		position[1] = this.y;
		return position;
	}
}
