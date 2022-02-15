
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class ScoreInfo {
	public ScoreInfo() throws Exception {

		JSONObject jo = new JSONObject();

//		jo.put("name", "Jone");
//	    jo.put("city", "Seoul");

		String jsonStr = jo.toString();
		File jsonFile = new File("../LineNo5/src/model/Info_Score.json");

		writeStringToFile(jsonStr, jsonFile);
	}

	public static void writeStringToFile(String str, File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(str);
		writer.close();
	}

}
