package org.mule.modules.restroomfinder;


import org.mule.modules.restroomfinder.config.ConnectorConfig;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import org.mule.modules.restroomfinder.config.ConnectorConfig;


@Connector(name="restroom-finder", friendlyName="RestroomFinder")
public class RestroomFinderConnector {

    @Config
    ConnectorConfig config;

private final String FINDBYLOCATION  = "https://www.refugerestrooms.org/api/v1/restrooms/by_location.json?";
	
	private  URL url;


	HttpURLConnection con ;
	
	   

    @Processor
    public String findbyLoc(String lat,String lng) {
        String response;
    	try {
    		url  = new URL(FINDBYLOCATION+"lat="+lat+"&lng="+lng);
			response=processConnection(url);
		} catch (MalformedURLException e) {
			response="Error connecting to endpoint Please retry";
			e.printStackTrace();
		}
    	catch (Exception e) {
    		response="Error connecting to endpoint Please retry" ;  				
			e.printStackTrace();
		}
    	return response;
  

    }
    
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }
   
    private String processConnection(URL url){
    	
    	StringBuffer response = new StringBuffer();
    	
    	try {
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");

			// add request header
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		}  catch (Exception e) {
			response=new StringBuffer("Error getting Yoda Speak");
			e.printStackTrace();
		}

		// print result
		return response.toString();
    }


}