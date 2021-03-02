package leerDOM;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dominio.Cielo;
import dominio.Poblacion;

public class LeerXML {

	public static Poblacion almacenarInformacion(String codigo) {

		String ruta = "http://www.aemet.es/xml/municipios/localidad_" + codigo + ".xml";

		Poblacion poblacion = new Poblacion(codigo);

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			URL url = new URL(ruta);
			InputStream stream = url.openStream();
			
			Document doc = db.parse(stream);
			doc.getDocumentElement().normalize();

			// Leer nombre
			NodeList listaNombres = doc.getElementsByTagName("nombre");
			String nombre = listaNombres.item(0).getTextContent();
			poblacion.setNombre(nombre);
			
			//TODO eliminar
			System.out.println("Nombre ciudad: " + nombre);

			// Dias
			NodeList listaDias = doc.getElementsByTagName("dia");
			int cont=0;
			for (int i = 0; i < listaDias.getLength(); i++) {
				
				Node nDias = listaDias.item(i);
				Element elem = (Element) listaDias.item(i);

				// Leer Atributo fecha="2018-04-06" en etiqueta <dia/>
				Element diaElement = (Element) nDias;
				String fecha = diaElement.getAttribute("fecha");
				
				
				//------------------
				
				
				NodeList elementosCielo =elem.getElementsByTagName("estado_cielo");
				
				Element elemento =(Element)elementosCielo.item(1);
				
				
				if(i>=4) {
					elemento =(Element)elementosCielo.item(0);
				}
				
				String periodo =elemento.getAttribute("periodo");
				String estado =elemento.getTextContent();
				String descripcion =elemento.getAttribute("descripcion");
				
				
				NodeList temperaturaMaxima =elem.getElementsByTagName("maxima");

				Element elementMaxima =(Element)temperaturaMaxima.item(0);
				
				String estadoMaxima =elementMaxima.getTextContent();
				
				NodeList temperaturaMinima =elem.getElementsByTagName("minima");

				Element elementMinima =(Element)temperaturaMinima.item(0);
				String estadoMinima=elementMinima.getTextContent();
				
				//Cielo cielo =new Cielo(periodo,descripcion,estado);
				
				
				/*NodeList estado = elem.getElementsByTagName("estado_cielo");
				Node est =estado.item(0);
				Element esta= (Element)est;
				String cielo = esta.getAttribute("descripcion");*/
				//TODO eliminar
				System.out.println("Fecha: " + fecha+" \nPeriodod de Tiempo :"+periodo +" \nDescripcion del dia :"+descripcion+" \nTemperatura :"+estadoMinima +" ~ "+estadoMaxima+"\n\n\n");
				
			}
			
			//TODO leer toda la información del XML 
			
			
			
			
			
			
			
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return poblacion;
	}

}