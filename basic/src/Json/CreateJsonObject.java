package Json;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class CreateJsonObject {
	public static void main(String[] args) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("name", "harikesh");
		builder.add("occupation", "Student");
		builder.add("age", "18");
		JsonObject person = builder.build();
		System.out.println(person);

	}

}
