package yamlReadOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;  //Using SnakeYAML as Yaml Parsing library.

public class YamlRead {
	public static void main(String[] args) throws FileNotFoundException {
		
		// Using InputStream to load the file
		InputStream input=new FileInputStream(new File("/Users/luv/eclipse-workspace/yamlReadAndWriteOperation/Read.yml"));
		
		//Instance of Yaml has been created with below command
		Yaml yaml =new Yaml();
		
		// using Load method to read/parse InputStream
		Map<String, Object>data=yaml.load(input);
		
		//Returning the data with system.out.println command
		System.out.println(data);
		
		
	}


}
