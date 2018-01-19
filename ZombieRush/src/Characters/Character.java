package Characters;

public abstract class Character {
	int hp;
	int x, y;
	public Character(int hp, int x, int y) {
		// TODO Auto-generated constructor stub
		this.hp = hp;
		this.x = x;
		this.y = y;
	}
	public abstract int gethp();
	public abstract int[] getposition();
}
