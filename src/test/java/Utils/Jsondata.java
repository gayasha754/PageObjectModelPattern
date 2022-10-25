package Utils;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Jsondata {
	InputStream data;
	JSONObject testData;
	public JSONObject json(String dataFileName) throws Exception {
		 
		try { 
//			String dataFileName = "testData/Register.json";
			data = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(data);
			testData = new JSONObject(tokener);			
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if(data != null) {
				data.close();
			}
		}
		return testData;
	}	
}
