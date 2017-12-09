package arAristotleRegimeClasses;

public abstract class Democracy  {
	
	//fields
	private int freedomscore;
	private int giniupper;
	private int ginilower;
	private int[] democracy = {freedomscore, giniupper, ginilower};
	
	public Democracy(int freedomscore, int giniupper, int ginilower) {
		this.democracy = new int[3];
		democracy[0] = freedomscore;
		democracy[1] = giniupper;
		democracy[2] = ginilower;
		
	}
	
	public Democracy() {
		this.democracy = new int[3];
	}
	
	public void setDemocracy(int[] democracy) {
		
	}
	public int[] getDemocracy() {
		return democracy;
	}
	

}
/*
private String name;
private String salutation;

public void createSalutation() {
    this.salutation = greeting.greet(name);
}

public String getSalutation() {
    return salutation;
}

public void setName(String name) {
   this.name = name;
}

public String getName() {
   return name;
}
*/