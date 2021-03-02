package archivos;



import javax.swing.text.Document;

import org.jsoup.Jsoup;


public class Parser {

	public static void main(String[] args) {
		
		Document doc = null;
		
		try {
			doc = (Document) Jsoup.connect("https://en.wikipedia.org/").get();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		//String Title = doc.
	}

}
