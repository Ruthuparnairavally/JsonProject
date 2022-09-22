package jasonproject;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestJason {

	
	public static void main(String args[]) throws IOException, ParseException {
		
		//Read the jason file
		FileReader reader = new FileReader("./jsonfile/team.json");
		
		JSONParser js = new JSONParser();
		Object obj = js.parse(reader); 
	
		//Downcasting object type to JSONobject
		JSONObject jo = (JSONObject)obj;
		
		//DownCasting Object to String
		String teamname=(String) jo.get("name");
		String location=(String) jo.get("location");
		
		System.out.println(teamname);
		System.out.println(location);
		
		//DownCasting Object to array
		JSONArray array = (JSONArray)jo.get("player");
		
		//System.out.println(array);
		//System.out.println(array.size());

		int foreign=0;
		int keeper=0;
		for (int i = 0; i < array.size(); i++) 
		{
			JSONObject ob = (JSONObject) array.get(i);
			String country =(String) ob.get("country");
			String role =(String) ob.get("role");
			
			if(!country.equalsIgnoreCase("India"))
			{
				foreign++;
				
			}
			if(role.equalsIgnoreCase("Wicket-keeper"))
			{
				keeper++;
			}
		}
		
		//Validation
		if( foreign == 4 && keeper >=1)
		{
			System.out.println("Eleven has "+foreign+" foreign players and "+keeper+" wicket keeper");
		}
		else 
		{
			System.out.println("There should be atleast one keeper");
		}
		
	}
}
