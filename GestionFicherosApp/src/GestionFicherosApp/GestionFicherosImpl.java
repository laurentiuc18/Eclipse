package GestionFicherosApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import gestionficheros.FormatoVistas;
import gestionficheros.GestionFicheros;
import gestionficheros.GestionFicherosException;
import gestionficheros.TipoOrden;

public class GestionFicherosImpl implements GestionFicheros {

	private File carpetaDeTrabajo = null;
	private Object[][] contenido;
	private int columnas = 3;
	private int filas = 0;
	private FormatoVistas formatoVistas = FormatoVistas.NOMBRES;
	private TipoOrden ordenado = TipoOrden.DESORDENADO;

	public GestionFicherosImpl() {

		carpetaDeTrabajo = File.listRoots()[0];
		actualiza();
	}

	private void actualiza() {
		// TODO Auto-generated method stub
		String[] ficheros = carpetaDeTrabajo.list(); // obtener los nombres
		// calcular el número de filas necesario
		filas = ficheros.length / columnas;
		if (filas * columnas < ficheros.length) {
			filas++; // si hay resto necesitamos una fila más
		}

		// dimensionar la matriz contenido según los resultados

		contenido = new String[filas][columnas];
		// Rellenar contenido con los nombres obtenidos
		for (int i = 0; i < columnas; i++) {
			for (int j = 0; j < filas; j++) {
				int ind = j * columnas + i;
				if (ind < ficheros.length) {
					contenido[j][i] = ficheros[ind];
				} else {
					contenido[j][i] = "";
				}
			}
		}
	}

	@Override
	public void arriba() {
		if(carpetaDeTrabajo.getParentFile()!= null) {
			
			carpetaDeTrabajo=carpetaDeTrabajo.getParentFile();
					actualiza();
		}
		
	}

	@Override
	public void creaCarpeta(String arg0) throws GestionFicherosException {
		
		File directorio = new File(carpetaDeTrabajo,arg0);
		
		if(!directorio.exists()&&carpetaDeTrabajo.canWrite()) {
		directorio.mkdir();
		}else {throw new GestionFicherosException("La carpeta "+arg0+" existe");}
		
	}

	@Override
	public void creaFichero(String arg0) throws GestionFicherosException {
		File fichero = new File(carpetaDeTrabajo, arg0);

		if (!fichero.exists() && carpetaDeTrabajo.canWrite()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			throw new GestionFicherosException("El fichero " + arg0 + " existe");
		}

	}

	@Override
	public void elimina(String arg0) throws GestionFicherosException {
		File eliminar = new File(carpetaDeTrabajo, arg0);

		if (eliminar.exists() && carpetaDeTrabajo.canWrite()) {
			if (eliminar.delete()) {

				System.out.println("Se ha eliminado");
			} else {
				System.out.println("No se a aliminado");
			}
		} else {
			throw new GestionFicherosException("El fichero seleccionado no existe");
		}
	}

	@Override
	public void entraA(String arg0) throws GestionFicherosException {
		File file = new File(carpetaDeTrabajo, arg0);

		if (!file.exists()) {
			throw new GestionFicherosException(file + " no existe");
		}

		if (!file.isDirectory()) {
			throw new GestionFicherosException(file + " no es un directorio");
		}

		if (!file.canRead()) {
			throw new GestionFicherosException(file + " no tiene permisos de letra");
		}

		carpetaDeTrabajo = file;
		actualiza();
		
	}

	@Override
	public int getColumnas() {
		// TODO Auto-generated method stub
		return columnas;
	}

	@Override
	public Object[][] getContenido() {
		// TODO Auto-generated method stub
		return contenido;
	}

	@Override
	public String getDireccionCarpeta() {
		// TODO Auto-generated method stub
		return carpetaDeTrabajo.getAbsolutePath();
	}

	@Override
	public String getEspacioDisponibleCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEspacioTotalCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFilas() {
		// TODO Auto-generated method stub
		return filas;
	}

	@Override
	public FormatoVistas getFormatoContenido() {
		// TODO Auto-generated method stub
		return formatoVistas;
	}

	@Override
	public String getInformacion(String arg0) throws GestionFicherosException {
		
		

		File file = new File(carpetaDeTrabajo, arg0);
		if (!file.canRead()) {throw new GestionFicherosException("La informacion de "+file + " no puede ser visualizada");}
		if (!file.exists()) {throw new GestionFicherosException(file + " no existe");}
		if(file.getName()==" "|| file.getName()==null){throw new GestionFicherosException(file + " no tiene nombre");}
		Date data = new Date();
		SimpleDateFormat data1 = new SimpleDateFormat("yyyy.MM.dd G 'a las ' HH:mm:ss z");

		StringBuilder sb = new StringBuilder();
		
	

		sb.append("--------------------------INFORMACION DEL FICHERO-------------------------------");
		sb.append("\n\n");
		sb.append("Nombre: " + file.getName() + "\n");

		if (file.isDirectory()) {
			sb.append("Directorio: SI" + "\n");
			sb.append("Contiene: "+file.list().length + " archivos"+ "\n");
			sb.append("Espacio libre: "+file.getFreeSpace() +  "\n");
			sb.append("Espacio Disponible: "+file.getUsableSpace() +  "\n");
			sb.append("Espacio Total: "+file.getTotalSpace() +  "\n");
			
			
		} else {

			sb.append("Directorio: NO" + "\n");
			sb.append("Tamanyo: "+file.length() + " bytes"+ "\n");
		}

		sb.append("Ubicacion: " + file.getAbsolutePath() + "\n");

		sb.append("Fue modificado el :" + data1.format(data) + "\n");
		
		if(file.isHidden()) {
			sb.append("Esta oculto: SI"+ "\n");
		}else {
			sb.append("Esta oculto: NO"+ "\n");
		}
		
		String cadena = sb.toString();
		return cadena;
	}

	@Override
	public boolean getMostrarOcultos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNombreCarpeta() {
		// TODO Auto-generated method stub
		return carpetaDeTrabajo.getName();
	}

	@Override
	public TipoOrden getOrdenado() {
		// TODO Auto-generated method stub
		return ordenado;
	}

	@Override
	public String[] getTituloColumnas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUltimaModificacion(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String nomRaiz(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numRaices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void renombra(String arg0, String arg1) throws GestionFicherosException {
		
		
		
		
		File directorio = new File(carpetaDeTrabajo,arg0);
		File renombre = new File(carpetaDeTrabajo,arg1);
		
		if(!renombre.exists()&&carpetaDeTrabajo.canWrite()) {
		directorio.renameTo(renombre);
		}else throw new GestionFicherosException("El nombre elegido ya existe");
	}

	@Override
	public boolean sePuedeEjecutar(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeEscribir(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeLeer(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColumnas(int arg0) {
		// TODO Auto-generated method stub
		columnas = arg0;
	}

	@Override
	public void setDirCarpeta(String arg0) throws GestionFicherosException {
		File file = new File(arg0);

		if (!file.exists()) {throw new GestionFicherosException(file + " no existe");}
			
		if (!file.isDirectory()) {throw new GestionFicherosException(file + " no es un directorio");}
			
		if (!file.canRead()) {throw new GestionFicherosException(file + " no tiene permisos de letra");}
		
		carpetaDeTrabajo = file;
		actualiza();

	

	}

	@Override
	public void setFormatoContenido(FormatoVistas arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMostrarOcultos(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrdenado(TipoOrden arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSePuedeEjecutar(String arg0, boolean arg1) throws GestionFicherosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSePuedeEscribir(String arg0, boolean arg1) throws GestionFicherosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSePuedeLeer(String arg0, boolean arg1) throws GestionFicherosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUltimaModificacion(String arg0, long arg1) throws GestionFicherosException {
		// TODO Auto-generated method stub
		
	}

}
