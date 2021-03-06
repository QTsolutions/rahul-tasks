package yamlReadAndWriteOperation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

// Modular approach to update read write operation in yaml file
public class YamlFileWriteAndReadOperations {

	static File newfile2 = new File(System.getProperty("user.dir") + File.separator + "Writeyamlfile.yml");
	static YAMLGenerator yamlgenerator;

	
	// Method used to create Yamlgenerator
	public static YAMLGenerator getYmlGenerator() throws IOException {
		YAMLFactory yf = new YAMLFactory();
		FileWriter fw = new FileWriter(newfile2);
		yamlgenerator = yf.createGenerator(fw);
		return yamlgenerator;

	}

	//Method used to start writting process
	public static void StartWritting() throws IOException {
		yamlgenerator = getYmlGenerator();
		yamlgenerator.writeStartObject();

	}
    
	//Method used to write data in Yaml file
	public static void writeData(String key, String value) throws IOException {
		yamlgenerator.writeObjectField(key, value);

	}

	//Method used to create Field name (to create object field for child members)
	public static void writeFieldName(String key) throws IOException {
		yamlgenerator.writeFieldName(key);

	}

	//Method used to write child data in yaml file
	public static void writeChildName(String key, String value) throws IOException {
		yamlgenerator.writeStartArray();
		yamlgenerator.writeStartObject();
		writeData(key, value);

	}

	//Method used to end the writting process
	public static void endWritting() throws IOException {
		yamlgenerator.writeEndObject();
		yamlgenerator.writeEndArray();
		yamlgenerator.writeEndObject();
		yamlgenerator.close();
	}

	// Method used to append the data
	public static void append(String key, String value) throws IOException {
		FileWriter fw = new FileWriter(newfile2, true);
		StartWritting();
		writeData(key, value);

	}

	public static void main(String[] args) throws IOException {

		StartWritting();
		append("hobby", "cricket");
		writeData("Name", "Rahul");
		writeData("Age", "30");
		writeData("Location", "Gnoida");

		writeFieldName("Otherdetails");
		writeChildName("mobileno", "1234567890");
		writeData("Marritalstatus", "Married");

		endWritting();

		// YAML writting operation closed

		
		
		// YAML reading operation start

		YAMLFactory yamlfactory = new YAMLFactory();
		
		//used to parse Yaml file 
		YAMLParser yamlparser = yamlfactory.createParser(newfile2);
		//used to perform all switch operations
		JsonToken jsontoken = yamlparser.nextToken();

		while (jsontoken != null) {

			switch (jsontoken) {
			case START_OBJECT:
				break;
			case END_OBJECT:
				break;
			case START_ARRAY:
				break;
			case END_ARRAY:
				break;
			case FIELD_NAME:
				System.out.println("Keyfield: " + yamlparser.getText());
				break;
			case VALUE_FALSE:
			case VALUE_NULL:
			case VALUE_NUMBER_FLOAT:
			case VALUE_NUMBER_INT:
			case VALUE_STRING:
			case VALUE_TRUE:
				Default: System.out.println("keyvalue: " + yamlparser.getText());
				break;

			}
			jsontoken = yamlparser.nextToken();
		}
		yamlparser.close();

	}

	// YAML read operation closed

}
