package cl.unab.CLRPWeb.WebService;


import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;

import cl.unab.CLRPWeb.Controller.EjecutaCpp;

 
@Path("/ws/runclrp/{Instancia}")
public class RunClrp{

	@GET
	@Produces("application/json")
	public Response execute(@PathParam("Instancia") String NombreInstancia) {
	
		long startTime = System.currentTimeMillis();
		String i="";
	    	EjecutaCpp cpp = new EjecutaCpp();
	    	//cpp.setInstancia(getNombre());
	    	cpp.EjecutaCLRP(NombreInstancia);
	    	String temp= cpp.toString();
	         System.out.println(temp);
	     	long endTime   = System.currentTimeMillis();
	     	NumberFormat formatter = new DecimalFormat("#0.00");
	     	
	     	
			String total=formatter.format((endTime - startTime) / 1000d);
			System.out.println("tiempo total de ejecucion fue: "+total+ " segundos");
			
			Gson gson = new Gson();
			String json = gson.toJson(i);
			ResponseBuilder builder = Response.ok(json);
			builder.header("Access-Control-Allow-Origin", "*");
			return builder.build();
	    	}
	 
	}


