package arAristotleRegimeClasses;

public abstract class RangeofValues {

	private int[] RangeofValues;
	
	public RangeofValues(int upper, int lower, int[] RangeofValues) {
		RangeofValues[0] = upper;
		RangeofValues[1] = lower;
		this.setRangeofValues(RangeofValues); 
	}

	public int[] getRangeofValues() {
		return RangeofValues;
	}

	public void setRangeofValues(int[] rangeofValues) {
		RangeofValues = rangeofValues;
	}

}
