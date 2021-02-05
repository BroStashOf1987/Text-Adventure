import java.util.ArrayList;

public class WeaponsList {

	private ArrayList<Weapons> list = new ArrayList<Weapons>();
	
	public WeaponsList() {
		list.add(new Weapons("sword", 5));
		list.add(new Weapons("magic", 15));
		list.add(new Weapons("mace", 10));
	}
	
	public Weapons getRandom() {
		return (list.get((int)Math.floor(Math.random() * (list.size() -1))+1));
	}
}

