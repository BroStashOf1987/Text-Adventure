import java.util.ArrayList;
import java.util.Scanner;

public class TextAdventureCode {
	
	private Player p;
		
	public void startGame(Room[][] map) {
		Scanner userInput = new Scanner(System.in); 
		String action = null; 
		boolean gameFinished = false;
		int[] coordinates = new int[2];
		
		// Start the user in the upper Left of the map
		Room r = map[0][0];
		
		System.out.println("Welcome to the Junior class Text Adventure Game");
		
		Player p = new Player();
		Chest c = new Chest();
		
		
		while (!gameFinished) {
			action = userInput.nextLine().toUpperCase();
			if (action.equals("Exit")) {
				System.out.println("Thanks for Playing");
				gameFinished = true;
			}
			else {
				switch (action) {
					case "NORTH": 
					case "SOUTH": 
					case "EAST": 
					case "WEST": 
						r = r.nextRoom(map, r, action.substring(0,1));
						break;
					case "ATTACK":
						r.Combat();
						break;
					case "OPEN CHEST":
						r.openChest();
						p.addToInventory(c.weapon);
						break;
					case "CHOOSE":
						System.out.println("Equipted: " + p.getWeapon().getName() + " With an Attack of :" + p.getWeapon().getDamage());import java.util.ArrayList;
import java.util.Scanner;

public class TextAdventureCode {
	
	private Player p;
		
	public void startGame(Room[][] map) {
		Scanner userInput = new Scanner(System.in); 
		String action = null; 
		boolean gameFinished = false;
		int[] coordinates = new int[2];
		
		// Start the user in the upper Left of the map
		Room r = map[0][0];
		
		System.out.println("Welcome to the Junior class Text Adventure Game");
		System.out.println("Start by typing: Observe");
		
		Player p = new Player();
		Chest c = new Chest();
		
		
		while (!gameFinished) {
			action = userInput.nextLine().toUpperCase();
			if (action.equals("Exit")) {
				System.out.println("Thanks for Playing");
				gameFinished = true;
			}
			else {
				switch (action) {
					case "NORTH": 
					case "SOUTH": 
					case "EAST": 
					case "WEST": 
						r = r.nextRoom(map, r, action.substring(0,1));
						System.out.print("You are in: Row: " + coordinates[0] + " ");
						System.out.println("Col: " + coordinates[1]);
						break;
					case "ATTACK":
						r.Combat();
						break;
					case "OPEN CHEST":
						r.openChest();
						p.addToInventory(c.weapon);
						System.out.println("Type 'choose' to equipt that weapon if you want");
						break;
					case "CHOOSE":
						System.out.println("Equipted: " + p.getWeapon().getName() + " With an Attack of :" + p.getWeapon().getDamage());
						p.showInventory();
						System.out.println("Type which weapon you want to equipt");
						action = userInput.nextLine().toUpperCase();
						p.chooseWeapon(action);
						System.out.println("You now have that equipted");
						System.out.println("Now type 'attack' to attack the enemy");
						break;
					case "OBSERVE":
						r.displayWhatsInTheRoom();
						System.out.println("Type 'open chest' to open the chest");
						System.out.println("Or type 'attack' to attack the Enemy");
						break;
					case "WHERE AM I":
						coordinates = findCoordinates(map, r);
						System.out.print("Row: " + coordinates[0] + " ");
						System.out.println("Col: " + coordinates[1]);
						break;
					case "EXIT":
						System.out.println("Thanks for Playing");
						p.clearInvenortory();
						gameFinished = true;
						break;
					case "?":
						System.out.println("NORTH, SOUTH, EAST, WEST");
				}
			}
		}
		userInput.close();
	}
	
	// Function to find which room we are in (just for debugging)
	private static int[] findCoordinates(Room[][] board, Room r) {
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
}

						p.showInventory();
						action = userInput.nextLine().toUpperCase();
						p.chooseWeapon(action);
						break;
					case "OBSERVE":
						r.displayWhatsInTheRoom();
						break;
					case "WHERE AM I":
						coordinates = findCoordinates(map, r);
						System.out.print("Row: " + coordinates[0] + " ");
						System.out.println("Col: " + coordinates[1]);
						break;
					case "EXIT":
						System.out.println("Thanks for Playing");
						p.clearInvenortory();
						gameFinished = true;
						break;
					case "?":
						System.out.println("NORTH, SOUTH, EAST, WEST");
				}
			}
		}
		userInput.close();
	}
	
	// Function to find which room we are in (just for debugging)
	private static int[] findCoordinates(Room[][] board, Room r) {
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
}
