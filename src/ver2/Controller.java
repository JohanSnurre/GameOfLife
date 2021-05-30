package ver2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Controller {
	
	Model model;
	
	public Controller(Model model) {
		this.model = model;
		
		
	}
	
	public synchronized void fillPos(int x, int y) {
		
		this.model.fillPos(x, y);
		
	}
	
	public synchronized void dropPos(int x, int y) {
		
		this.model.dropPos(x, y);
		
	}
	
	public synchronized void calcNextRound() {
		
		Iterator it;
		HashMap<Pair, Integer> temp = new HashMap<Pair, Integer>();
		
		
		//For every filled in position in the field, add 1 to every neighbouring square in a temporary field(the temp hashmap)
		it = model.getField().entrySet().iterator();
		while(it.hasNext()) {
			
			Map.Entry p = (Map.Entry)it.next();
			int x = ((Pair) p.getKey()).getFirst();
			int y = ((Pair) p.getKey()).getSecond();
			
			int range = 2;
			
			for(int i = -1 ; i < range; i++) {
				
				for(int j = -1; j < range; j++) {
					if(i == 0 && j == 0) {
						continue;
					}
					
					Pair a = new Pair(x+i,y+j);
					
					if(temp.get(a) != null) {
						temp.replace(a, temp.get(a) + new Integer(1));
						
					}
					else {
						temp.put(a, new Integer(1));
					}					
				}
			}
		}
		
		
		//for every filled in position in the temporary field(temp hashmap) decide wether it lives or not
		it = temp.entrySet().iterator();
		while(it.hasNext()) {
			
			Map.Entry p = (Map.Entry)it.next();
			Pair a = (Pair) p.getKey();
			
			if(temp.get(a).equals(3)) {
				temp.replace(a, new Integer(1));
				
			}
			else if(temp.get(a).equals(2) && model.contains(a)) {
				temp.replace(a, new Integer(1));
				
			}
			else {
				it.remove();
			}
			
		}
		
		model.setField(temp);
		
		
	}
	
	
	

}
