package clases;

import java.util.HashMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import main.Principal;

public class EnemigoAnimado extends JugadorAnimado{

	private HashMap<String, Animacion> animacionesEnemigo;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private boolean capturado;
	

	public EnemigoAnimado(int x, int y, String indiceImagen, int velocidad, int contadorVida,int puntuacion, String animacionActual) {
		super(x, y, indiceImagen, velocidad, contadorVida, puntuacion, animacionActual);
		inicializarAnimacionesEnemigo();
	}
	
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animacionesEnemigo.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public boolean isCapturado() {
		return capturado;
	}				
	
	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
	public void pintar(GraphicsContext graficos) {
			graficos.drawImage(
				Principal.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
	}
	public void moverEnemigo() {
		this.x= x-2;
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, 25, 30);
	}
	
	
	public void inicializarAnimacionesEnemigo() {
		animacionesEnemigo = new HashMap<String, Animacion>();
		Rectangle coordenadasGengar[]= {
				new Rectangle(0,183, 43,49),
				new Rectangle(43,183, 48,49),
				new Rectangle(91, 183, 53,49),	
				new Rectangle(148, 183, 53,49),
		};
		
		Animacion animacionGengar = new Animacion("gengar",coordenadasGengar,0.20);
		animacionesEnemigo.put("gengar",animacionGengar);

		Rectangle coordenadasIvysaur[]= {
			new Rectangle(185,123, 46,43),
			new Rectangle(138,123, 46,43),
			new Rectangle(92,123, 46,43),
			new Rectangle(46,123, 46,43),	
			new Rectangle(0,123, 46,43)
		};		
		Animacion animacionIvysaur = new Animacion("ivysaur",coordenadasIvysaur,0.20);
		animacionesEnemigo.put("ivysaur",animacionIvysaur);

		Rectangle coordenadasGloom[]= {
			new Rectangle(204,173, 52,42),
			new Rectangle(153,173, 51,42),
			new Rectangle(102,173, 51,42),
			new Rectangle(51,173, 51,42),	
			new Rectangle(0,173, 51,42)		
		};
		
		Animacion animacionGloom = new Animacion("gloom",coordenadasGloom,0.20);
		animacionesEnemigo.put("gloom",animacionGloom);


	}


}
	
