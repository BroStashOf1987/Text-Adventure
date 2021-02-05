public class Weapons {

	private String Name;
	private int Damage = 0;
	public int Number;
	
	public Weapons(String n, int d) {
		this.Name = n;
		this.Damage = d;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public int getDamage() {
		return this.Damage;
	}
}

