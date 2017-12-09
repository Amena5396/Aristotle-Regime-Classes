package arAristotleRegimeClasses;

public class Regime  {
	
	//fields
	protected String regimename;
	protected int freedomscore;
	protected int giniupper;
	protected int ginilower;
	private int[] regime = {freedomscore, giniupper, ginilower};
	
	public Regime(String regimename, int freedomscore, int giniupper, int ginilower) {
		this.regime = new int[3];
		this.regimename = regimename;
		regime[0] = freedomscore;
		regime[1] = giniupper;
		regime[2] = ginilower;
		
	}
	
	public Regime() {
		this.regime = new int[3];
	}
	
	public void setRegime(int[] democracy) {
		
	}
	public int[] getDemocracy() {
		return regime;
	}

	

}