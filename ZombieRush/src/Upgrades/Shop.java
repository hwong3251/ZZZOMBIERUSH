package Upgrades;

public class Shop extends Weapons {

	public Shop(int dmg, int price, boolean equipped) {
		super(dmg, price, equipped);
	}
	
	Weapons Auto = new Shop(20,100,false);
	Weapons Boomerang = new Shop(40,150,false);
	Weapons Poison = new Shop(10,300,false);
	Weapons Spear = new Shop(50,350,false);
	Weapons Click = new Shop(100,500,false);
	Weapons Best= new Shop(9999,99999,false);
	
}
