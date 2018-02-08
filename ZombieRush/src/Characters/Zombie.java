package Characters;

public class Zombie{

	private int dmg;
	private int hp;
	private int x;
	private int y;
	public Zombie(int dmg, int hp, int x, int y)
	{
		this.x = x;
		this.y = x;
		this.dmg = dmg;
		this.hp = hp;
	}
	public int takeDamage(int num)
	{
		return hp - num;
	}
	public int gethp() {
		// TODO Auto-generated method stub
		return this.hp;
	}
	public int getDmg()
	{
		return this.dmg;
	}
	public int[]getposition() {
		// TODO Auto-generated method stub
		int[]position = new int[2];
		position[0] = this.x;
		position[1] = this.y;
		return position;
	}
}
