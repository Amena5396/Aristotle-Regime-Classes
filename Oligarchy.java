package arAristotleRegimeClasses;

public abstract class Oligarchy  {
	
	//fields
	private int freedomscore;
	private int giniupper;
	private int ginilower;
	private int[] oligarchy = {freedomscore, giniupper, ginilower};
	
	public Oligarchy(int freedomscore, int giniupper, int ginilower) {
		this.oligarchy = new int[3];
		oligarchy[0] = freedomscore;
		oligarchy[1] = giniupper;
		oligarchy[2] = ginilower;
		
	}
	
	public Oligarchy() {
		this.oligarchy = new int[3];
	}
	
	public void setOligarchy(int[] oligarchy) {
		
	}
	public int[] getOligarchy() {
		return oligarchy;
	}
	
}