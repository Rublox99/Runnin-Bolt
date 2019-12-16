package clases;

import java.util.HashMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import main.Principal;

public class ItemAnimado extends JugadorAnimado {

	private HashMap<String, Animacion> animacionesObjetos;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private boolean capturado;

	public ItemAnimado(int x, int y, String indiceImagen, int velocidad, int contadorVida, int puntuacion, String animacionActual) {
		super(x, y, indiceImagen, velocidad, contadorVida, puntuacion, animacionActual);
		inicializarAnimacionesObjeto();
	}
	
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animacionesObjetos.get(animacionActual).calcularFrame(t);
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
		if(!capturado)
			graficos.drawImage(
				Principal.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
	}
	
	public void moverObjeto() {
		this.x=x-2;
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, 9, 9);
	}
	
	public void inicializarAnimacionesObjeto() {
		animacionesObjetos = new HashMap<String, Animacion>();
		Rectangle coordenadasMoneda[]= {
				new Rectangle(9,0, 13,31),
				new Rectangle(40,0, 15,31),
				new Rectangle(70, 0, 19,31),	
				new Rectangle(102, 0, 19,31),
				new Rectangle(134,0, 19,31),
				new Rectangle(167,0, 17,31),
				new Rectangle(201, 0, 13,31),	
				new Rectangle(233, 0, 13,31),
		};
		
		Animacion animacionMoneda = new Animacion("moneda",coordenadasMoneda,0.13);
		animacionesObjetos.put("moneda",animacionMoneda);
		
		Rectangle coordenadasAgua[]= {
				new Rectangle(66,0, 25,39),
				new Rectangle(34,0, 26,39),
				new Rectangle(1,0, 28,39),
		};
		
		Animacion animacionAgua = new Animacion("agua",coordenadasAgua,0.45);
		animacionesObjetos.put("agua",animacionAgua);
		}
	
}
		

