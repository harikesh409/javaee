package Json;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class CreateJsonArrayWithGenerator {

	public static void main(String[] args) {
		StringWriter sw = new StringWriter();
		JsonGenerator gen = Json.createGenerator(sw);
		gen.writeStartObject();
		gen.write("name", "Harikesh");
		gen.write("Occupation", "student");
		gen.writeStartArray("emails");
			gen.write("p.harikesh409@gmail.com");
			gen.write("harikesh.pallantla@gmail.com");
		gen.writeEnd();
		gen.writeEnd();
		gen.close();
		System.out.println(sw);
	}

}
