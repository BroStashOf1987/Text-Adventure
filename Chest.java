public class Chest {
	
	Weapons weapon = null;
	int special=0;
	int PStrength=10;
	static WeaponsList list;
	private Chest c;
	
	public Chest() {
		list = new WeaponsList();
		this.weapon = list.getRandom();
	}
	
	public boolean openSesame() {
		return true;
	}
	
	public int getPotion() {
		return this.PStrength;
	}
	
	public Weapons getWeapon() {
		return this.weapon;
	}
	
	public int getDamage() {
		return this.weapon.getDamage();
	}
	

	public String getContents() {
		return "Chest Contains This: Health potion :" + this.PStrength + " And a weapon of :" + this.weapon.getName();
	}
	
}
