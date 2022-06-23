package yamlWriteOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;  //Using SnakeYAML as Yaml Parsing library.

public class YamlWrite {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//creating a map object to a Yaml file
		Map<String, Object> inputfile=new LinkedHashMap<>();
		inputfile.put("name", "Rahul");
		inputfile.put("address", "Gnoida");
		inputfile.put("Age", 30);
		
		//creating printwriter object to provide outputdirectry/location
		PrintWriter writer =new PrintWriter(new File("/Users/luv/eclipse-workspace/yamlReadAndWriteOperation/Write.yml"));
		
		///Instance of Yaml has been created with below command
		Yaml yaml=new Yaml();
		
		//using dump method to dump the input file to writer location
		yaml.dump(inputfile, writer);
		
		//file has been written in write.yaml file
		
	}

}
