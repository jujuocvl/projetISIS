import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecteurDuJson {
	private final String FILENAME = "restaurant_exemple_commande.json";

	public LecteurDuJson() {

	}

	// ENTREES
	public ArrayList<Order> lireEntrées(String file) throws FileNotFoundException, IOException, ParseException {
		ArrayList<Order> listOrder = new ArrayList<Order>();
		JSONParser jsonP = new JSONParser(); // outil pour lire le fichier

		// creer objet json avec ce que le parser à lu
		JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(FILENAME));

		JSONArray starters = (JSONArray) jsonObject.get("starters");

		Iterator<JSONObject> entreelist = starters.iterator();
		while (entreelist.hasNext()) {
			JSONObject entree = entreelist.next();
			int id =  Integer.valueOf((String)platsOb.get("id"));
			int qty = Integer.valueOf((String)platsOb.get("qty")) ;
			plats.add(new MainCourse(qty, id));
		}

		return listOrder;
	}

	// MAIN COURSES
	public ArrayList<Order> lirePlats(String file) throws FileNotFoundException, IOException, ParseException {
		ArrayList<Order> listOrder = new ArrayList<Order>();
		JSONParser jsonP = new JSONParser();

		JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(FILENAME));

		JSONArray courses = (JSONArray) jsonObject.get("main_courses");

		Iterator<JSONObject> entreelist = courses.iterator();
		while (entreelist.hasNext()) {
			JSONObject entree = entreelist.next();
			Long id = (Long) entree.get("id");
			String description = (String) entree.get("description");
			listOrder.add(new Order(id, description));
		}

		return listOrder;
	}

	// DESSERTS
	public ArrayList<Order> lireDesserts(String file) throws FileNotFoundException, IOException, ParseException {
		ArrayList<Order> listOrder = new ArrayList<Order>();
		JSONParser jsonP = new JSONParser(); 

		JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(FILENAME));

		JSONArray desserts = (JSONArray) jsonObject.get("main_courses");

		Iterator<JSONObject> entreelist = desserts.iterator();
		while (entreelist.hasNext()) {
			JSONObject entree=entreelist.next();
			Long id = (Long) entree.get("id");
			String description = (String) entree.get("description");
			listOrder.add(new Order(id,description));
		}


		return listOrder;
	}
}
