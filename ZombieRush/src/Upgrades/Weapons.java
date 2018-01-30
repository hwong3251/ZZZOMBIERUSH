package Upgrades;

public abstract class Weapons {
	private int dmg;
	private int price;
	private boolean equipped;
	
	public Weapons(int dmg, int price, boolean equipped)
	{
		this.dmg = dmg;
		this.price = price;
		this.equipped = equipped;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
}
