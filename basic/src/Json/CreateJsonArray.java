package Json;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class CreateJsonArray {

	public static void main(String[] args) {
		JsonObjectBuilder person = Json.createObjectBuilder();
		person.add("name","Harikesh");
		person.add("Occupation","Student");
		JsonArrayBuilder emails=Json.createArrayBuilder();
		emails.add("p.harikesh409@gmail.com");
		emails.add("harikesh.pallantla@gmail.com");
		person.add("emails", emails);
		System.out.print(person.build());
		
		
	}

}
