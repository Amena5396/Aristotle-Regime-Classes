package arAristotleRegimeClasses;

public abstract class Tyranny  {
	
	//fields
	private int freedomscore;
	private int giniupper;
	private int ginilower;
	private int[] tyranny = {freedomscore, giniupper, ginilower};
	
	public Tyranny(int freedomscore, int giniupper, int ginilower) {
		this.tyranny = new int[3];
		tyranny[0] = freedomscore;
		tyranny[1] = giniupper;
		tyranny[2] = ginilower;
		
	}
	
	public Tyranny() {
		this.tyranny = new int[3];
	}
	
	public void setTyranny(int[] tyranny) {
		
	}
	public int[] getTyranny() {
		return tyranny;
	}
	
}