import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecteurDuJson {
	private final String FILENAME = "restaurant_exemple_commande.json";
	private ArrayList<Plat> entrees;
	private ArrayList<Plat> plats;
	private ArrayList<Plat> desserts;
	public LecteurDuJson() {
	}

	// ENTREES
	public ArrayList<Plat> lireEntrées() throws FileNotFoundException, IOException, ParseException {
		entrees = new ArrayList<Plat>();
		JSONParser jsonP = new JSONParser(); // outil pour lire le fichier

		// creer objet json avec ce que le parser à lu
		JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(FILENAME));

		JSONArray starters = (JSONArray) jsonObject.get("starters");

		Iterator<JSONObject> entreelist = starters.iterator();
		while (entreelist.hasNext()) {
			JSONObject entree = entreelist.next();
			long id= Long.parseLong((String)entree.get("id"));
			int qty = Integer.valueOf((String)entree.get("qty")) ;
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
			int id =  Integer.valueOf((String)plat.get("id"));
			int qty = Integer.valueOf((String)plat.get("qty")) ;
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
			int id =  Integer.valueOf((String)dessert.get("id"));
			int qty = Integer.valueOf((String)dessert.get("qty")) ;
			desserts.add(new MainCourse(qty, id));
		}


		return desserts;
	}
}
