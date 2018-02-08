package Characters;

public class Player extends Character{
	private int hp,x,y,lvl,gold;
	public Player(int hp, double x, double y, double a, int w, int lvl, int gold)
	{
		super(x, y, a, w, hp);
		this.lvl = lvl;
		this.gold = gold;
	}
	public int takeDamage(int num)
	{
		return hp - num;
	}
	public int nextLvl()
	{
		lvl += 1;
		return lvl;
	}
	public int increaseGold(int num)
	{
		return gold += num;
	}
	@Override
	public int gethp() {
		// TODO Auto-generated method stub
		return this.hp;
	}
	//aaa
	@Override
	public int[] getposition() {
		// TODO Auto-generated method stub
		int[]position = new int[2];
		position[0] = this.x;
		position[1] = this.y;
		return position;
	}
}
