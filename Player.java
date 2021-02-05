import java.util.ArrayList;

public class Player {
		private int health;
		private int level;
		private int experience;
		private int WDamage;
		private Weapons WName;
		private Weapons currentWeapon = null;
		private ArrayList<Weapons> inventory;
		private ArrayList<Integer> potions; 
		
		// Advanced features
		//int Mana = 20;
		//int Potion = 50;
		//int Potion = 10;
		//int Armor = 0;
		//int Level = 1;
		
		
		
		
		public Player() {
			potions = new ArrayList<Integer>();
			inventory = new ArrayList<Weapons>();
			currentWeapon = new Weapons("fist", 1);
			inventory.add(currentWeapon);
		}
		
		public void clearInvenortory() {
			for (int i = 0; i < inventory.size(); i++) {
				inventory.remove(i);
			}
		}
		
		public Weapons getWeapon() {return this.currentWeapon; }
		public int getHealth() {return this.health;}
		
		public void addToInventory(Weapons weapon) {
			if (!(weapon == null)) {this.inventory.add(weapon);}
		}
		
		
		public void chooseWeapon(String name) {
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.get(i).getName().toUpperCase().equals(name.toUpperCase())) {
					this.currentWeapon = inventory.get(i);
				}
			}
		}
		
		public int setHealth() {
			return this.health;
		}
		
		public int getDamage() {
			for (int i = 0; i < inventory.size(); i++) {
				if (!currentWeapon.getName().equals(inventory.get(i).getName())) {
					WDamage = inventory.get(i).getDamage();
				}
			}
			return WDamage;
		}

		public void showInventory() {
			for (int i=0; i< this.inventory.size(); i++) {
				System.out.println(this.inventory.get(i).getName());
			}
		
		
		
	}
}

