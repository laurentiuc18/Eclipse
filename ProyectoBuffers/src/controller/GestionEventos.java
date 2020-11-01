//Lauren
package controller;
//Juanan no tinc ni idea de com fer que el programa me torne en buscar palabra  totes les linieson se trobe la paraula. Soles me torna la 1ra que troba i prou
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;

import model.*;
import view.*;
//m'he quedat sense temps i tel entregue sense aixo * srry *
public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
					try {
						call_compararContenido();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_buscarPalabra();
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
	}

	private int call_compararContenido() throws IOException {

		try {
			if (GestionDatos.compararContenido(view.getFichero1().getText(), view.getFichero2().getText())) {

				view.getTextArea().setText("Los Textos son iguales");
			} else {
				view.getTextArea().setText("Los Textos son diferentes");
			}
		} catch (Exception e) {
			view.getTextArea().setText("");
			view.showError("Los Textos no se han podido comparar");
		}
	
	
		return 1;
	}

	private int call_buscarPalabra() {
		

		try {
		
			
			if(GestionDatos.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected()) == -1) {
				
				view.getTextArea().setText("La palabra " + view.getPalabra().getText() + " no existe");
				
				
			} else { 
				
		
				
				view.getTextArea().setText("La palabra " + view.getPalabra().getText() +" esta en la linea " + GestionDatos.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected())); 
			
			}
				
		
		} catch (Exception e) {
			view.getTextArea().setText("");
			view.showError("Un error ha ocurrido al intentar buscar la palabra requerida");
		}
		return 1;
	}

}
