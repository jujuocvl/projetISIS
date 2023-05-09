import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecteurDuJson {
	private String FILENAME ;
	private ArrayList<Plat> entrees;
	private ArrayList<Plat> plats;
	private ArrayList<Plat> desserts;
	public LecteurDuJson() {
	}

	// ENTREES
	public ArrayList<Plat> lireEntrées() throws FileNotFoundException, IOException, ParseException {
		String directoryPath = "/Users/julieorcival/git/repository2/isis";

		// liste pour stocker les noms des fichiers qui correspondent au critère 
		ArrayList<String> matchingFiles = new ArrayList<>();
		File directory = new File(directoryPath);
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().startsWith("order_") && file.getName().endsWith(".json")) {
				matchingFiles.add(file.getName());
				FILENAME = file.getName();
			}
		}

		entrees = new ArrayList<Plat>();
		JSONParser jsonP = new JSONParser(); // outil pour lire le fichier

		// creer objet json avec ce que le parser à lu
		JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(FILENAME));

		JSONArray starters = (JSONArray) jsonObject.get("starters");

		Iterator<JSONObject> entreelist = starters.iterator();
		while (entreelist.hasNext()) {
			JSONObject entree = entreelist.next();
			//System.out.println(entree);
			//System.out.println(entree.get("id"));
			long id= (long)entree.get("id");
			int qty = Long.valueOf((long)entree.get("qty")).intValue() ;
			entrees.add(new MainCourse(qty, id));
		}

		return entrees;
	}

	// MAIN COURSES
	public ArrayList<Plat> lirePlats() throws FileNotFoundException, IOException, ParseException {
		plats = new ArrayList<Plat>();
		JSONParser jsonP = new JSONParser();

		JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(FILENAME));

		JSONArray courses = (JSONArray) jsonObject.get("main_courses");

		Iterator<JSONObject> platlist = courses.iterator();
		while (platlist.hasNext()) {
			JSONObject plat = platlist.next();
			long id= (long)plat.get("id");
			int qty = Long.valueOf((long)plat.get("qty")).intValue() ;
			plats.add(new MainCourse(qty, id));
		}

		return plats;
	}

	// DESSERTS
	public ArrayList<Plat> lireDesserts() throws FileNotFoundException, IOException, ParseException {
		desserts = new ArrayList<Plat>();
		JSONParser jsonP = new JSONParser(); 

		JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(FILENAME));

		JSONArray sucree = (JSONArray) jsonObject.get("main_courses");

		Iterator<JSONObject> dessertlist = sucree.iterator();
		while (dessertlist.hasNext()) {
			JSONObject dessert=dessertlist.next();
			long id= (long)dessert.get("id");
			int qty = Long.valueOf((long)dessert.get("qty")).intValue() ;
			desserts.add(new MainCourse(qty, id));
		}


		return desserts;
	}
}
