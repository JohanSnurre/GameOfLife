package ver2;

public class Pair {
	
	private int first;
	private int second;
	
	public Pair(int first, int second){
		this.first = first;
		this.second = second;
		
		
		
	}
	
	@Override
	public boolean equals(Object other) {
		try {
					
				if (other instanceof Pair) {
					if(((Pair) other).getFirst() == this.first && ((Pair) other).getSecond() ==  this.second){
						
						return true;
						
					}
					
				};
				return false;
				
				
			}
		catch (Exception e) {
			return false;
			
		}

	}
	
	@Override
	public String toString() {
		String a = first + ":" + second;
		return a;
	}
	
	@Override
	public int hashCode() {
		int tmp = ( this.first +  ((this.second+1)/2));
        return this.second +  ( tmp * tmp);
		
		
	}
	
	public int getFirst() {
		return this.first;
		
	}
	public int getSecond() {
		return this.second;
		
	}
	
}
