package arAristotleRegimeClasses;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class WorldRegimes extends Regime {
	public HashMap <String, ArrayList<Integer>> worldregimes;

	public static void main(String[] args) {
		WorldRegimes ar = new WorldRegimes();
		Regime democracy; 
		Regime oligarchy;
		Regime tyranny;
		
		//democracy.ginilower = ##;

		/*try {
			ar.CountryData();
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		Scanner scanner = new Scanner(System.in);
		String entered = scanner.next();
		//String entered2 = scanner.next();
		//String entered3 = scanner.next();
		//String entered4 = scanner.next();
		
		if(entered.equals("d")) {
			int f = Integer.valueOf(entered);
			int gu = Integer.valueOf(entered);
			int gl = Integer.valueOf(entered);
			democracy = new Regime("democracy", f, gu, gl);
		}

		if(entered.equals("o")) {
			int f = Integer.valueOf(entered);
			int gu = Integer.valueOf(entered);
			int gl = Integer.valueOf(entered);
			oligarchy = new Regime("oligarchy", f, gu, gl);
		}

		if(entered.equals("t")) {
			int f = Integer.valueOf(entered);
			int gu = Integer.valueOf(entered);
			int gl = Integer.valueOf(entered);
			tyranny = new Regime("tyranny", f, gu, gl);
		}
		
		if(ar.get(entered) != null) {
			RegimeSort(ar.get(entered).get(0), democracy);
			System.out.print(entered + " :" + ar.get(entered).get(0) + ", " + ar.get(entered).get(1));
		}
		
		
		//create objects with 4 fields
		//scanner to enter in fields - name of regime, that calls the constructor (call which ones you want)
		//scanner to enter in name of country
			// country, w. 2 data pts shows up
			//tests which regime object the gini score lands b/t
		// tests whether freedom house score is same
		//take keyset of hashmap and run it through the sort method in the last three comments ---> if statement

		scanner.close();
	}

	public WorldRegimes() {
		this.worldregimes = new HashMap<String, ArrayList<Integer>>();
	}

	public void CountryData() throws ParseException {

		try {
			FileReader readert = new FileReader("C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\FreedomHouseScorestabdelimited.txt");
			BufferedReader br = new BufferedReader(readert);
			String line = null;
			while ((line = br.readLine()) != null) {
				String name = "";
				String[] eachline = line.split("	"); 
				String fscore = eachline[eachline.length - 1];
				int value = ScoretoValue(fscore);
				for(int i = 0; i < (eachline.length - 1); i++) {
					name = name + eachline[i] ;
				}
				worldregimes.put(name, new ArrayList<Integer>());
				worldregimes.get(name).add(value);
				//System.out.println(name);
				//System.out.println(value);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		JsonParser parser = new JsonParser(); 

		FileReader reader = null;

		String[] allfolders = { "C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\australia-oceania",
				"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\central-america-n-caribbean",
				"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\central-asia",
				"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\east-n-southeast-asia",
				"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\middle-east",
				"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\north-america",
				"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\south-america",
				"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\south-asia",
				"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\africa",
				//"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\antarctica",
				"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\europe",
		//"C:\\Users\\Amena\\eclipse-workspace\\AristotleRegimeClasses\\src\\data\\oceans" 
				};
		for(String folder : allfolders) {
			File directory = new File(folder);
			File[] contents = directory.listFiles();
			for(File filename : contents) {
				try {
					String namec = "";
					String ginistuff = "";
					int gini = 0;
					double genie = 0;
					reader = new FileReader(filename);
					Object obj = parser.parse(reader);
					JsonObject jobj = (JsonObject) obj;
					JsonObject govt = (JsonObject) jobj.get("Government");
					if(! (govt == null)) {
						JsonObject coname = (JsonObject) govt.get("Country name");
						if(! (coname == null)) {
							JsonObject shortformname = (JsonObject) coname.get("conventional short form");
							if(! (shortformname == null)) {
								JsonElement actname = shortformname.get("text");
								//System.out.println(actname);

								if(! (actname == null)) {
									namec = actname.toString();
									namec = namec + " ";
									namec = namec.substring(1, namec.length() - 2);
									//System.out.println(namec);
									if(worldregimes.get(namec) != null) {
										JsonObject ec = (JsonObject) jobj.get("Economy");
										if(! (ec == null)) {
										
										
										JsonObject giniindexnumber = (JsonObject) ec.get("Distribution of family income - Gini index");
										if(! (giniindexnumber == null)) {
											//JsonArray ginipre = giniindexnumber.get("text").getAsJsonArray();
											 ginistuff = giniindexnumber.get("text").getAsString();

										//ginistuff = ginipre.get(0).toString();
										String[] eachline = ginistuff.split(" ");
										genie = Double.parseDouble(eachline[0]);
										gini = (int) genie * 10; 
										//gini = Integer.valueOf(eachline[0]) * 10;
										//System.out.println(gini);
										worldregimes.get(namec).add(gini);
									} 
										}
									}
								}
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private int ScoretoValue(String fscore) {
		int democraticfreedom = -1;
		if(fscore.equals("NF")) {
			democraticfreedom = 0;
		}
		if(fscore.equals("PF")) {
			democraticfreedom = 1;
		}
		if(fscore.equals("F")) {
			democraticfreedom = 2;
		}
		return democraticfreedom;
	}
		
	public String RegimeSort(int fscore, int giniscore, Regime regime) {
		if(giniscore > regime.ginilower) {
			if(giniscore < regime.giniupper) {
				if(fscore == regime.freedomscore) {
					return regime.regimename;
				}
			}
		}
		
		return null;		
	}
}