package ver2;


public class Pair {

	private int first;
	private int second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;

	}

	@Override
	public boolean equals(Object other) {
			if (other instanceof Pair) {
				if (((Pair) other).getFirst() == this.first && ((Pair) other).getSecond() == this.second) {
					return true;
				}
			}
			return false;
	}

	@Override
	public String toString() {
		String a = first + ":" + second;
		return a;
	}

	/**
	 * Overrides the Object.hashCode() function to better suit this task. 
	 * This function returns an integer that is generated with Szudziks pairing function
	 * that maps a pair of 2 non-negative integers to 1 non-negative integer.
	 * To allow for negative integers in the pair, a new pair is created from the original pair.
	 * The integers of the original pair are transformed like x -> (-2x) - 1, making
	 * every negative integer into a postive, odd integer and every positive integer
	 *  into a even, positive integer.
	 */
	@Override
	public int hashCode() {

		int a, b;
		a = (this.first < 0) ? ((2 * this.first) * (-1)) - 1 : 2 * this.first;

		b = (this.second < 0) ? ((2 * this.second) * (-1)) - 1 : 2 * this.second;

		if (a < b) {
			return b * b + a;

		}
		return a * a + a + b;

	}

	public int getFirst() {
		return this.first;

	}

	public int getSecond() {
		return this.second;

	}

}
