package main;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clases.EnemigoAnimado;
import clases.ItemAnimado;
import clases.JugadorAnimado;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Principal extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	
	private JugadorAnimado jugadorAnimado;
	private EnemigoAnimado enemigoAnimado;
	private EnemigoAnimado enemigoAnimado1;
	private EnemigoAnimado enemigoAnimado2;
	private EnemigoAnimado enemigoAnimado3;
	private EnemigoAnimado enemigoAnimado4;
	private EnemigoAnimado enemigoAnimado5;
	private EnemigoAnimado enemigoAnimado6;
	private EnemigoAnimado enemigoAnimado7;
	private EnemigoAnimado enemigoAnimado8;
	private EnemigoAnimado enemigoAnimado9;
	private EnemigoAnimado enemigoAnimado10;
	private EnemigoAnimado enemigoAnimado11;
	
	private ItemAnimado monedaAnimada;
	private ItemAnimado aguaAnimada;
	private ItemAnimado monedaAnimada1;
	private ItemAnimado aguaAnimada1;
	private ItemAnimado monedaAnimada2;
	private ItemAnimado aguaAnimada2;
	private ItemAnimado monedaAnimada3;
	private ItemAnimado aguaAnimada3;
	private ItemAnimado monedaAnimada4;
	private ItemAnimado aguaAnimada4;
	private ItemAnimado monedaAnimada5;
	private ItemAnimado aguaAnimada5;
	private ItemAnimado monedaAnimada6;
	private ItemAnimado aguaAnimada6;
	private ItemAnimado monedaAnimada7;
	private ItemAnimado aguaAnimada7;
	private ItemAnimado monedaAnimada8;
	private ItemAnimado aguaAnimada8;
	
	private int i=0;

	//int numero = (int)(Math.random()*(X-Y+1)+Y; para intervarlo entre X y Y
	
	public static HashMap<String, Image> imagenes; 
	private ArrayList<Tile> tiles;
	private ArrayList<Tile> tilesBackground;
	
	private int[][] mapa= {
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},

	};
	
	private int[][] background= {
			{2},
			{2},
			{2},
			{2},
			{2},
			{2},
			{2},
			{2},
			{2},
			{2},
			{2},
			{2},
			{2},
			{2},
	};
	
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	
	private int x= 700;
	private int y= 425;
	

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos= canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("Runnin Bolt");
		gestionarEventos();
		ventana.show();
		cicloJuego();
	}
	
	public void inicializarComponentes() {
		jugadorAnimado= new JugadorAnimado(0, 300, "pikachu", 3, 3, 0,"correr");
		inicializarItems();
		
		root= new Group();
		escena= new Scene(root, x, y);
		canvas= new Canvas(x, y);
		imagenes= new HashMap<String, Image>();
		
		cargarImagenes();
		cargarTiles();
		
	}
	public void inicializarItems() {

		//int numero = (int)(Math.random()*(X-Y+1)+Y; para intervarlo entre X y Y
		enemigoAnimado= new EnemigoAnimado(70, 215,"gengar", 0, 0, 0, "gengar");
		enemigoAnimado1= new EnemigoAnimado(170, 290 ,"ivysaur", 0, 0, 0, "ivysaur");
		enemigoAnimado2= new EnemigoAnimado(70, 370,"gengar", 0, 0, 0, "gengar");
		
		enemigoAnimado3= new EnemigoAnimado(360, 215,"ivysaur", 0, 0, 0, "ivysaur");
		enemigoAnimado4= new EnemigoAnimado(460, 290,"gengar", 0, 0, 0, "gengar");
		enemigoAnimado5= new EnemigoAnimado(360, 370,"gloom", 0, 0, 0, "gloom");
		
		enemigoAnimado6= new EnemigoAnimado(590, 215,"gloom", 0, 0, 0, "gloom");
		enemigoAnimado7= new EnemigoAnimado(690, 290,"gengar", 0, 0, 0, "gengar");
		enemigoAnimado8= new EnemigoAnimado(590, 370,"ivysaur", 0, 0, 0, "ivysaur");

		enemigoAnimado9= new EnemigoAnimado(900, 215,"ivysaur", 0, 0, 0, "ivysaur");
		enemigoAnimado10= new EnemigoAnimado(1000, 290,"gengar", 0, 0, 0, "gengar");
		enemigoAnimado11= new EnemigoAnimado(900, 370,"gloom", 0, 0, 0, "gloom");
		
		monedaAnimada= new ItemAnimado(250, 300,"moneda", 0, 0, 0, "moneda");
		aguaAnimada= new ItemAnimado(220, 225,"agua", 0, 0, 0, "agua");
		monedaAnimada1= new ItemAnimado(220, 370,"moneda", 0, 0, 0, "moneda");
		
		aguaAnimada1= new ItemAnimado(450, 370,"agua", 0, 0, 0, "agua");
		monedaAnimada2= new ItemAnimado(450, 2250,"moneda", 0, 0, 0, "moneda");
		aguaAnimada2= new ItemAnimado(350, 290,"agua", 0, 0, 0, "agua");

		aguaAnimada3= new ItemAnimado(700, 225,"agua", 0, 0, 0, "agua");
		monedaAnimada3= new ItemAnimado(600, 290,"moneda", 0, 0, 0, "moneda");
		aguaAnimada4= new ItemAnimado(700, 370,"agua", 0, 0, 0, "agua");

		monedaAnimada4= new ItemAnimado(950, 225,"agua", 0, 0, 0, "agua");
		monedaAnimada5= new ItemAnimado(950, 370,"moneda", 0, 0, 0, "moneda");
		aguaAnimada5= new ItemAnimado(850, 290,"agua", 0, 0, 0, "agua");

		aguaAnimada6= new ItemAnimado(1200, 225,"agua", 0, 0, 0, "agua");
		monedaAnimada6= new ItemAnimado(1100, 290,"moneda", 0, 0, 0, "moneda");
		aguaAnimada7= new ItemAnimado(1200, 370,"agua", 0, 0, 0, "agua");

		monedaAnimada7= new ItemAnimado(1600, 225,"agua", 0, 0, 0, "agua");
		aguaAnimada8= new ItemAnimado(1800, 300,"moneda", 0, 0, 0, "moneda");
		monedaAnimada8= new ItemAnimado(1900, 370,"agua", 0, 0, 0, "agua");
	}
	
	public void definirBarraVida() {
		if(jugadorAnimado.getContadorVida()>3) {
			graficos.drawImage(new Image("3corazones.png"), 4, 10);
		}
		if(jugadorAnimado.getContadorVida()==3) {
			graficos.drawImage(new Image("3corazones.png"), 4, 10);
		}
		if(jugadorAnimado.getContadorVida()==2) {
			graficos.drawImage(new Image("2corazones.png"), 4, 10);
		}
		if(jugadorAnimado.getContadorVida()==1) {
			graficos.drawImage(new Image("1corazon.png"), 4, 10);
		}
		if(jugadorAnimado.getContadorVida()==0) {
			JOptionPane.showMessageDialog(null, "Puntuación: " + jugadorAnimado.getPuntuacion());
			System.exit(0);
		}
	}
	
	public void cargarImagenes() {
		imagenes.put("pikachu", new Image("pikachu.png"));
		imagenes.put("terreno", new Image("terreno.png"));
		imagenes.put("fondo", new Image("fondo.png"));
		imagenes.put("arboles", new Image("arboles.png"));
		imagenes.put("moneda", new Image("moneda.png"));
		imagenes.put("agua", new Image("agua.png"));
		imagenes.put("puntos", new Image("puntos.png"));
		imagenes.put("gengar", new Image("gengar.png"));;
		imagenes.put("1corazon", new Image("1corazon.png"));
		imagenes.put("2corazones", new Image("2corazones.png"));
		imagenes.put("3corazones", new Image("3corazones.png"));
		imagenes.put("ivysaur", new Image("ivysaur.png"));
		imagenes.put("gloom", new Image("gloom.png"));
	}
	
	public void cargarTiles() {
		tiles= new ArrayList<Tile>();
		tilesBackground= new ArrayList<Tile>();
		

		for(int i=0; i<background.length; i++) {
			for(int j=0; j<background[i].length; j++) {
				if(background[i][j]!=0)
					tilesBackground.add(new Tile(background[i][0], i*719, 0, "fondo"));
			}
		}
		
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*72, j*71, "terreno"));
			}
		}
			
	}
	
	public void pintarFondo() {
		graficos.setFill(Color.WHITE);
		graficos.fillRect(0, 0, x, y);
		graficos.setFill(Color.BLACK);
		
		for (int i=0;i<tilesBackground.size();i++) 
			tilesBackground.get(i).pintarGraficos(graficos);
		
		for (int i=0;i<tiles.size();i++) 
			tiles.get(i).pintarGraficos(graficos);
		
		graficos.drawImage(imagenes.get("puntos"), 10, 5);
		definirBarraVida();
		
		i-=2;
		graficos.drawImage(imagenes.get("arboles"), i, 160);

		pintarItems();
		jugadorAnimado.pintar(graficos);
		
	}

	public void pintarItems() {
		enemigoAnimado.pintar(graficos);
		enemigoAnimado1.pintar(graficos);
		enemigoAnimado2.pintar(graficos);
		enemigoAnimado3.pintar(graficos);
		enemigoAnimado4.pintar(graficos);
		enemigoAnimado5.pintar(graficos);
		enemigoAnimado6.pintar(graficos);
		enemigoAnimado7.pintar(graficos);
		enemigoAnimado8.pintar(graficos);
		enemigoAnimado9.pintar(graficos);
		enemigoAnimado10.pintar(graficos);
		enemigoAnimado11.pintar(graficos);
		
		monedaAnimada.pintar(graficos);
		aguaAnimada.pintar(graficos);
		monedaAnimada1.pintar(graficos);
		aguaAnimada1.pintar(graficos);
		monedaAnimada2.pintar(graficos);
		aguaAnimada2.pintar(graficos);
		monedaAnimada3.pintar(graficos);
		aguaAnimada3.pintar(graficos);
		monedaAnimada4.pintar(graficos);
		aguaAnimada4.pintar(graficos);
		monedaAnimada5.pintar(graficos);
		aguaAnimada5.pintar(graficos);
		monedaAnimada6.pintar(graficos);
		aguaAnimada6.pintar(graficos);
		monedaAnimada7.pintar(graficos);
		aguaAnimada7.pintar(graficos);
		monedaAnimada8.pintar(graficos);
		aguaAnimada8.pintar(graficos);

	}

	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "D": //derecha
							/*jugadorAnimado.setAnimacionActual("correr");*/
							derecha=true;
							break;
						case "A": //izquierda
							/*jugadorAnimado.setAnimacionActual("correr");*/
							jugadorAnimado.setVelocidad(3);		
							izquierda=true;
						break;
						case "W":
							/*jugadorAnimado.setAnimacionActual("correr");*/
							arriba=true;
							break;
						case "S":
							/*jugadorAnimado.setAnimacionActual("correr");*/
							abajo=true;
							break;
						case "SPACE":
							if(izquierda) {
							jugadorAnimado.setVelocidad(3);
							}
							else {
							jugadorAnimado.setVelocidad(4);
								}
							break;
					}
			}			
		});
		
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "D": //derecha
					/*if(izquierda|| arriba || abajo){
						jugadorAnimado.setAnimacionActual("correr");
					}
					else
						jugadorAnimado.setAnimacionActual("descanso");*/
					derecha=false;
					break;
				case "A": //izquierda
					/*if(derecha || arriba || abajo){
						jugadorAnimado.setAnimacionActual("correr");
					}
					else
						jugadorAnimado.setAnimacionActual("descanso");*/
					izquierda=false;
				break;
				case "W":
					/*if(izquierda || derecha || abajo)
						jugadorAnimado.setAnimacionActual("correr");
					else
						jugadorAnimado.setAnimacionActual("descanso");*/
					arriba=false;
					break;
				case "S":
					/*if(derecha || izquierda || arriba)
						jugadorAnimado.setAnimacionActual("correr");
					else
						jugadorAnimado.setAnimacionActual("descanso");*/
					abajo=false;
					break;
				case "SPACE":
					if(izquierda) 
						jugadorAnimado.setVelocidad(3);
					
					else 
						jugadorAnimado.setVelocidad(3);
					
					break;
			}
				
			}
			
		});
		
	
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				
				for(int i=0; i<tilesBackground.size(); i++)
					tilesBackground.get(i).moverTilesBg();
						
				for(int i=0; i<tiles.size(); i++)
					tiles.get(i).moverTiles();
				
				pintarFondo();
				
				
				jugadorAnimado.pintar(graficos);
				
				actualizar(t);
			}
			
		};
		animationTimer.start(); //Inicia el ciclo
	}
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		moverItems(t);
		actualizarItems(t);

	}
	
	public void moverItems(double t) {
		enemigoAnimado.moverEnemigo();
		enemigoAnimado1.moverEnemigo();
		enemigoAnimado2.moverEnemigo();
		enemigoAnimado3.moverEnemigo();
		enemigoAnimado4.moverEnemigo();
		enemigoAnimado5.moverEnemigo();
		enemigoAnimado6.moverEnemigo();
		enemigoAnimado7.moverEnemigo();
		enemigoAnimado8.moverEnemigo();
		enemigoAnimado9.moverEnemigo();
		enemigoAnimado10.moverEnemigo();
		enemigoAnimado11.moverEnemigo();
		monedaAnimada.moverObjeto();
		aguaAnimada.moverObjeto();
		monedaAnimada1.moverObjeto();
		aguaAnimada1.moverObjeto();
		monedaAnimada2.moverObjeto();
		aguaAnimada2.moverObjeto();
		monedaAnimada3.moverObjeto();
		aguaAnimada3.moverObjeto();
		monedaAnimada4.moverObjeto();
		aguaAnimada4.moverObjeto();
		monedaAnimada5.moverObjeto();
		aguaAnimada5.moverObjeto();
		
	}
	public void actualizarItems(double t) {
		jugadorAnimado.actualizarAnimacion(t);
		

		
		enemigoAnimado.actualizarAnimacion(t);
		enemigoAnimado1.actualizarAnimacion(t);
		enemigoAnimado2.actualizarAnimacion(t);
		enemigoAnimado3.actualizarAnimacion(t);
		enemigoAnimado4.actualizarAnimacion(t);
		enemigoAnimado5.actualizarAnimacion(t);
		enemigoAnimado6.actualizarAnimacion(t);
		enemigoAnimado7.actualizarAnimacion(t);
		enemigoAnimado8.actualizarAnimacion(t);
		enemigoAnimado9.actualizarAnimacion(t);
		enemigoAnimado10.actualizarAnimacion(t);
		enemigoAnimado11.actualizarAnimacion(t);
		
		monedaAnimada.actualizarAnimacion(t);
		aguaAnimada.actualizarAnimacion(t);
		monedaAnimada1.actualizarAnimacion(t);
		aguaAnimada1.actualizarAnimacion(t);
		monedaAnimada2.actualizarAnimacion(t);
		aguaAnimada2.actualizarAnimacion(t);
		monedaAnimada3.actualizarAnimacion(t);
		aguaAnimada3.actualizarAnimacion(t);
		monedaAnimada4.actualizarAnimacion(t);
		aguaAnimada4.actualizarAnimacion(t);
		monedaAnimada5.actualizarAnimacion(t);
		aguaAnimada5.actualizarAnimacion(t);
		monedaAnimada6.actualizarAnimacion(t);
		aguaAnimada6.actualizarAnimacion(t);
		monedaAnimada7.actualizarAnimacion(t);
		aguaAnimada7.actualizarAnimacion(t);
		monedaAnimada8.actualizarAnimacion(t);
		aguaAnimada8.actualizarAnimacion(t);
		
		jugadorAnimado.verificarColisionesAgua(aguaAnimada);
		jugadorAnimado.verificarColisiones(monedaAnimada);
		jugadorAnimado.verificarColisionesAgua(aguaAnimada1);
		jugadorAnimado.verificarColisiones(monedaAnimada1);
		jugadorAnimado.verificarColisionesAgua(aguaAnimada2);
		jugadorAnimado.verificarColisiones(monedaAnimada2);
		jugadorAnimado.verificarColisionesAgua(aguaAnimada3);
		jugadorAnimado.verificarColisiones(monedaAnimada3);
		jugadorAnimado.verificarColisionesAgua(aguaAnimada4);
		jugadorAnimado.verificarColisiones(monedaAnimada4);
		jugadorAnimado.verificarColisionesAgua(aguaAnimada5);
		jugadorAnimado.verificarColisiones(monedaAnimada5);
		jugadorAnimado.verificarColisionesAgua(aguaAnimada6);
		jugadorAnimado.verificarColisiones(monedaAnimada6);
		jugadorAnimado.verificarColisionesAgua(aguaAnimada7);
		jugadorAnimado.verificarColisiones(monedaAnimada7);
		jugadorAnimado.verificarColisionesAgua(aguaAnimada8);
		jugadorAnimado.verificarColisiones(monedaAnimada8);
		
		jugadorAnimado.verificarColisiones(enemigoAnimado);
		jugadorAnimado.verificarColisiones(enemigoAnimado1);
		jugadorAnimado.verificarColisiones(enemigoAnimado2);
		jugadorAnimado.verificarColisiones(enemigoAnimado3);
		jugadorAnimado.verificarColisiones(enemigoAnimado4);
		jugadorAnimado.verificarColisiones(enemigoAnimado5);
		jugadorAnimado.verificarColisiones(enemigoAnimado6);
		jugadorAnimado.verificarColisiones(enemigoAnimado7);
		jugadorAnimado.verificarColisiones(enemigoAnimado8);
		jugadorAnimado.verificarColisiones(enemigoAnimado9);
		jugadorAnimado.verificarColisiones(enemigoAnimado10);
		jugadorAnimado.verificarColisiones(enemigoAnimado11);
		
	}
	
	
}
