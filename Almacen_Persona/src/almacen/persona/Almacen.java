package almacen.persona;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Almacen {
	
	public void Almacen(){
		
	}

	public void guardar(Persona p,String f){
		
		ObjectOutputStream out=null;
		
		try {
			out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(p);
		} catch (IOException e) {			
			e.printStackTrace();
		}finally{
			intentarCerrar(out);
		}
		
	}
	
	public Persona recuperar(String f) {
		Persona p = null;
        ObjectInputStream in=null;
        try {
            in = new ObjectInputStream(new FileInputStream(f));
            p = (Persona) in.readObject();            
        } catch (ClassNotFoundException ex) {
            System.err.println("Error de fichero");
        } catch (IOException ex) {
        	System.err.println("Error IO");
        }finally{
            intentarCerrar(in);
        }
        return p;
	}

	
	public void intentarCerrar(Closeable aCerrar) {
		try {
			if (aCerrar != null) {
				aCerrar.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
	
}
