package clases;

import java.util.HashMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import main.Principal;

public class JugadorAnimado {
	protected int x;
	protected int y;
	protected String indiceImagen;
	private int velocidad;
	public int contadorVida=3;
	private HashMap<String, Animacion> animaciones;
	protected String animacionActual;
	protected int puntuacion = 0;
	
	//Coordenadas para el fragmento de la imagen a pintar
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	
	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, int contadorVida, int puntuacion, String animacionActual) {
		super();
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.contadorVida= contadorVida;
		this.puntuacion= puntuacion;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getX() {
		return x;
	}
	
	public int getContadorVida() {
		return contadorVida;
	}

	public void setContadorVida(int contadorVida) {
		this.contadorVida = contadorVida;
	}

	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	public String getAnimacionActual() {
		return animacionActual;
	}

	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}

	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public void mover(){
		if (this.y<=230)
			this.y =230;
		
		if(this.x<=10)
			this.x=10;
		
		if(this.x>=640)
			this.x=640;
		
		if(this.y>=380)
			this.y=380;
		
		if (Principal.derecha)
			this.x+=velocidad;
		
		if (Principal.izquierda)
			this.x-=velocidad;
		
		if (Principal.arriba)
			this.y-=velocidad;
		
		if (Principal.abajo)
			this.y+=velocidad;
	}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Principal.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		Text puntuacionTexto= new Text("Puntuación: ");
		puntuacionTexto.setFill(Color.WHITE);
		graficos.fillText( puntuacionTexto.getText() + puntuacion, 15, 21);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, 40, 32);
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
			Rectangle coordenadasCorrer[]= {
					new Rectangle(465,41, 46,37),
					new Rectangle(418,43, 47,31),
					new Rectangle(373,40, 45,37),
					new Rectangle(328,40, 45,37),
					new Rectangle(282,44, 46,33),
					new Rectangle(235, 44, 47,33),	
			};
			
			
			Animacion animacionCorrer = new Animacion("correr",coordenadasCorrer,0.08);
			animaciones.put("correr",animacionCorrer);
			
			/*Rectangle coordenadasDescanso[] = {
					new Rectangle(241, 0, 38,40),
					new Rectangle(282,0, 38,40),
					new Rectangle(320,0, 37,40),
					new Rectangle(357,0, 37,40),
					new Rectangle(394,0, 40,40),
					new Rectangle(434,0, 39,40),
					new Rectangle(473,0, 38,40),
			};
			Animacion animacionDescanso = new Animacion("descanso",coordenadasDescanso,0.20);
			animaciones.put("descanso",animacionDescanso);*/
	}
	
	
	public void verificarColisiones(ItemAnimado monedaAnimada) {
		if (this.obtenerRectangulo().intersects(monedaAnimada.obtenerRectangulo().getBoundsInLocal())) {
				if (!monedaAnimada.isCapturado())
					this.puntuacion++;
				monedaAnimada.setCapturado(true);
		}
	}	
	
	public void verificarColisionesAgua(ItemAnimado aguaAnimada) {
		if (this.obtenerRectangulo().intersects(aguaAnimada.obtenerRectangulo().getBoundsInLocal())) {
				if (!aguaAnimada.isCapturado()) {
					this.contadorVida++;
					this.puntuacion+=2;
				}
				aguaAnimada.setCapturado(true);
		}
	}
	
	public void verificarColisiones(EnemigoAnimado enemigoAnimado) {
		if (this.obtenerRectangulo().intersects(enemigoAnimado.obtenerRectangulo().getBoundsInLocal())) {
				if (!enemigoAnimado.isCapturado()) 
					this.contadorVida-=1;	
				enemigoAnimado.setCapturado(true);
		}
	}


	/*
	public void verificarColisiones(Item item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!item.isCapturado())
					this.puntuacion++;
				item.setCapturado(true);				
		}
	}*/
	
}
