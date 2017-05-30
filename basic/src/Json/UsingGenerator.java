package Json;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class UsingGenerator {

	public static void main(String[] args) {
		StringWriter sw = new StringWriter();
		JsonGenerator gen = Json.createGenerator(sw);
		gen.writeStartObject();
		gen.write("name", "Harikesh");
		gen.write("email", "p.harikesh409@gmail.com");
		gen.writeEnd();
		gen.close();
		System.out.println(sw);
	}

}
