package Libreria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	private static Document dom = null;
	private ArrayList<Libro> libroArray;
	
	public Parser() {
		libroArray = new ArrayList<Libro>();
	}
	
	public void parseXML(String identificador) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
		dom= dBuilder.parse(identificador);
	}
	
	public void parseDocument() {
		Element docEle = dom.getDocumentElement();
		NodeList nl = docEle.getElementsByTagName("libro");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				Element el = (Element) nl.item(i);
				Libro l = getLibro(el);
				libroArray.add(l);
			}
		}
	}

	private Libro getLibro(Element libro) {
		String Titulo = getTextValue(libro,"titulo");
		String Autor = getTextValue(libro,"nombre");
		int NumPag = getIntValue(libro,"paginas");
		int Anyo = Integer.parseInt(getAtrValue(libro,"titulo","anyo" ));
		String Editor = getTextValue(libro,"editor");
		
		Libro lib = new Libro(Titulo, Autor,NumPag, Anyo,Editor);
		return lib;
	}
	

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}	
		return textVal;
	}
	
	
	private String getAtrValue(Element ele, String tagName, String atributeName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getAttribute(atributeName);
		}	
		return textVal;
	}
	
	
	private int getIntValue(Element ele, String tagName) {				
		return Integer.parseInt(getTextValue(ele,tagName).split(" ")[0]);
	}

	public void print(){
		Iterator it = libroArray.iterator();
		while(it.hasNext()) {
			Libro l=(Libro) it.next();
			System.out.println(l.toString());
		}
	}
	
}
