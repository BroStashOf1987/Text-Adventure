import java.util.ArrayList;
import java.util.Objects;

public class Room {
	public Enemy e = null;
	public Chest c = null;
	public Player p = null;
	private static int roomsVisited=0;
	private int WDamage;
	
	// Create a new room where we define what's in the room
	public Room() {
		this.e = new Enemy();
		this.c = new Chest();
		this.p = new Player();
		roomsVisited++;
	}
		
	public Room(boolean required) {
		if (required) {
			this.e = new Enemy();
			this.c = new Chest();
			this.p = new Player();
		}	
	}
	
	public void Combat() {
		int damage = p.getDamage();
		int EHealth = e.getHealth();
		boolean attackPhase = true;
		while (attackPhase) {
			while (EHealth != 0) {
				System.out.println("The Enemy has " + EHealth + " Health left");
				int taken = EHealth - damage;
				System.out.println("The Enemy has taken " + damage + " Damage!");
				EHealth = taken;
				System.out.println("The Enemy now has " + EHealth + " Health left");
				}
			if (EHealth == 0) {
				System.out.println("Horay! You Defeated the Enemy");
				attackPhase = false;
			}
		}
	}
	
	// Set whether or not you can go into another room in each direction
	private int[] findCoordinates(Room[][] board, Room r) {
		int[] coordinates = new int[2];		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if (board[i][j].equals(r)) {
					coordinates[0] = i;
					coordinates[1] = j;
				}
			}
		}		
		return coordinates;	
	}
	
	public Room nextRoom(Room[][] board, Room r, String exit) {	
		int maxRow = board.length - 1;
		int maxCol = board[0].length - 1;
		
		int coordinates[] = findCoordinates(board, r);
		int row = coordinates[0];
		int col = coordinates[1];
		
		exit = exit.toUpperCase();
		switch (exit) {
	        case "N": if (row < maxRow) { row++; } break;
	        case "S": if (row > 0) { row--; } break;
	        case "E": if (col < maxCol) { col++; } break;
	        case "W": if (col > 0) { col--; } break;
	    }
		return board[row][col];	
	}

	public Weapons openChest() {
		Weapons theweapon = null;
		if (Objects.nonNull(this.c)) {
			if (c.openSesame()) {
				theweapon = c.getWeapon();
			}
		}
		p.addToInventory(c.weapon);
		System.out.println("You now have a :" + theweapon.getName() + " With an Attack of " + theweapon.getDamage());
		return theweapon;
	}
	
	public void displayWhatsInTheRoom() {
		if (Objects.nonNull(this.e)) {
			e.display();
		}
		if (Objects.nonNull(this.c)) {
			this.c.getContents();
			System.out.println(c.getContents());
		}
	}
	
	private boolean checkForHealth() {
		return true;
	}
	
	private int getHealth() {
		return 0;
	}
}










