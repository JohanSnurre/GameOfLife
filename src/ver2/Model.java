package ver2;

import java.util.HashMap;
import java.util.Observable;

public class Model extends Observable {
	
	private HashMap positions;
	
	
	public Model(int[][] filledCoords) {
		positions = new HashMap<Pair, Integer>();		
		
		for(int i = 0; i<filledCoords.length; i++) {
			for(int j = 0; j <2; j++) {
				int x = filledCoords[i][0];
				int y = filledCoords[i][1];
				
				fillPos(x,y);
				
			}
			
		}
		
		
	}
	public Model() {
		positions = new HashMap<Pair, Integer>();		
		
		
		
	}
	
	public boolean addModel(int[][] coords, int[] offset) {
		
		for(int i = 0; i<coords.length; i++) {
			for(int j = 0; j <2; j++) {
				int x = coords[i][0] + offset[0];
				int y = coords[i][1] + offset[1];
				
				fillPos(x,y);
				
			}
			
		}
		
		
		
		
		
		return false;
	}
	
	public HashMap<Pair, Integer> getField() {
		return this.positions;
	}
	
	public void setField(HashMap<Pair, Integer>field) {
		this.positions = field;
		setChanged();
		notifyObservers();
		
	}
	
	public void dropPos(int x, int y) {
		
		Pair a = new Pair(x,y);
		positions.remove(a);
		setChanged();
		notifyObservers();
	}
	public void fillPos(int x, int y) {
		Pair a = new Pair(x,y);
		Integer b = new Integer(1);
		positions.put(a, b);
		setChanged();
		notifyObservers();
	}	
	
	public boolean contains(Pair p) {
		return this.positions.containsKey(p);
	}

	
}
