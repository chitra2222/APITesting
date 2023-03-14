package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Constants.SourcePath;

public class PropertiesUtility {
	private FileInputStream file = null;
	private Properties ob = null;

public Properties loadFile() {
	// TODO Auto-generated method stub
	ob = new Properties();
	String PropertyFilePath = SourcePath.CONFIG_PROPERTIES_PATH;
	/*switch(filename) {
	case "ConfigProperties":
		PropertyFilePath =SourcePath.CONFIG_PROPERTIES_PATH;
		break;
		
	}*/	
		try {
			file = new FileInputStream(PropertyFilePath);
			ob.load(file);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
  return ob;

}

public String getPropertyValue(String key) {
	String value= ob.getProperty(key);
	System.out.println("Property from the file is : "+value);
	
	try {
		file.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return value;
}



}

