package cl.unab.CLRPWeb.Controller;
import java.io.*;

public class EjecutaCpp { 
	
	public String instancia;

	public void EjecutaCLRP(String nombreinstancia){

    	
        try {  	
        	///home/waclrp/
        	String command="/opt/jboss-as-7.1.1.Final/bin/clrp_pre.sh "+nombreinstancia+"";
        	
        	Process p=Runtime.getRuntime().exec(command); 
            InputStream is = p.getInputStream(); 
            BufferedReader br = new BufferedReader (new InputStreamReader (is)); 
   
            String aux = br.readLine(); 
            while (aux!=null) { 
                System.out.println (aux);
                aux = br.readLine(); 
            } 
        }  
        catch (IOException e) { 
        	System.out.println("Error de ejecucion : ");
            e.printStackTrace();
            System.out.println("Fin de errores de ejecucion");
        }
        

    }
	
	
	public String getInstancia() {
		return instancia;
		}
	public void setInstancia(String instancia) {
	this.instancia = instancia;
	}
		
     
}