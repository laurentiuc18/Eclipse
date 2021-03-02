
package Libreria;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Parser_Libro {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Parser parser=new Parser();
		
		parser.parseXML("biblioteca.xml");
		parser.parseDocument();
		parser.print();
	}
}
