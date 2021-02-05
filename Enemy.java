public class Enemy {
		
		public String[] possibleEnemies = {"goblin,10,50", "ork,10,100"};
		
		private int strength;
		private int health;
		private String name;
		
		public Enemy(int s, int h, String n) {
			this.strength = s;
			this.health = h;
			this.name = n;
		}
		
		public Enemy() {
			int rando = (int)Math.floor((Math.random() * possibleEnemies.length-1)+1);
			
			String[] pieces = possibleEnemies[rando].split(",");
			this.name = pieces[0];
			this.strength = Integer.parseInt(pieces[1]);
			this.health = Integer.parseInt(pieces[2]);
		}
		
		public String getType() {
			return "Test";
		}
		
		public int getAttack() {
			return this.strength;
			
		}
		
		public int getHealth() {
			return this.health;
			
		}
		
		public int attack(int attackValue) {
			this.health -= attackValue;
			return this.health;
		}
		
		public String getName() {
			return this.name;
		}
		public void display() {
			System.out.print(this.name + " has an attack strength of ");
			System.out.print(this.strength + " and a health of ");
			System.out.println(this.health);
		}
	}

