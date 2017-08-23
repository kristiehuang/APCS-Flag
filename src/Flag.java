// Flag starter kit


/*
 * Kristie Huang
 * 
 * Arjun Srivastava
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

public class Flag extends JApplet {
	private final int STRIPES = 13;

	// SCALE FACTORS (A through L)
	//
	// Note: Constants in Java should always be ALL_CAPS, even
	// if we are using single letters to represent them

	private final double A = 1.0;  // Hoist (width) of flag
	private final double B = 1.9;  // Fly (length) of flag
	private final double C = 0.5385;  // Hoist of Union
	private final double D = 0.76;  // Fly of Union
	private final double E = 0.054;  // See flag specification
	private final double F = 0.054;  // See flag specification
	private final double G = 0.063;  // See flag specification
	private final double H = 0.063;  // See flag specification
	private final double K = 0.0616;  // Diameter of star
	private final double L = 0.0769;  // Width of stripe
	private int width;           // width of flag in pixels
	private int height;          // height of flag in pixels
	private int stripe_height;   // height of an individual stripe in pixels

	public void init() {
		// Choice of width = 1.9 * height to start off
		// Gets ratio of FLY : HOIST


		//		
		setSize(760, 400);

		//        setBackground(Color.BLACK);

		repaint();
	}

	public void paint(Graphics g) {

		height = getHeight();
		width = (int) (height * 1.9);

		g.clearRect(0, 0, getWidth(), getHeight());

		drawBackground(g);

		drawStripes(g);
		drawField(g);
		drawStars(g);


	}

	private void drawBackground(Graphics g) {


		g.setColor(Color.RED);
		g.fillRect(0, 0, width, height);

	}

	public void drawStripes(Graphics g) {
		stripe_height = height / 13;
		g.setColor(Color.WHITE);
		g.fillRect(0, stripe_height, width, stripe_height);

		g.fillRect(0, 3*stripe_height, width, stripe_height);

		g.fillRect(0, 5*stripe_height, width, stripe_height);

		g.fillRect(0, 7*stripe_height, width, stripe_height);

		g.fillRect(0, 9*stripe_height, width, stripe_height);

		g.fillRect(0, 11*stripe_height, width, stripe_height);
		g.fillRect(0, 13*stripe_height, width, stripe_height);




	}

	public void drawField(Graphics g) {

		int fieldHeight = (int) (stripe_height * 7);
		int fieldWidth = (int) (width * D / 1.9);
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, fieldWidth, fieldHeight);
	}

	public void drawStars(Graphics g) {
		//		Star star = new Star();



		g.setColor(Color.WHITE);


		int starDiameter = (int) (K * height / 2);


		int g1 = (int) (G * height);
		int e1 = (int) (E * height);
		int starWidth = (int) (K * height);



		double pi = Math.PI;
		double h = Math.sin(pi/10);
		double r = starDiameter / 2;
		double r2 = h * Math.sin(54*pi/180);
		//		double x1 = Math.cos(pi/10);
		//		double x2 = h / (Math.tan(3*pi/10));
		//		double g2 = 100;
		//		double i2 = 123;
		//		double j2 = 234;

		double aX1 = r*Math.cos(pi/10);
		double bX1 = r2*Math.cos(2*pi/10);
		double cX1 = r*Math.cos(3*pi/10);
		double dX1 = r2*Math.cos(4*pi/10);
		double eX1 = r*Math.cos(5*pi/10);
		double fX1 = r2*Math.cos(6*pi/10);
		double gX1 = r*Math.cos(7*pi/10);
		double hX1 = r2*Math.cos(8*pi/10);
		double iX1 = r*Math.cos(9*pi/10);
		double jX1 = r2*Math.cos(pi);


		double aY1 = -r*Math.sin(pi/10);
		double bY1 = -r2*Math.sin(2*pi/10);
		double cY1 = -r*Math.sin(3*pi/10);
		double dY1 = -r2*Math.sin(4*pi/10);
		double eY1 = -r*Math.sin(5*pi/10);
		double fY1 = -r2*Math.sin(6*pi/10);
		double gY1 = -r*Math.sin(7*pi/10);
		double hY1 = -r2*Math.sin(8*pi/10);
		double iY1 = -r*Math.sin(9*pi/10);
		double jY1 = -r2*Math.sin(pi);




		for(int j = 1; j <= 9; j = j+2) {
			for(int i = 1; i <= 11; i = i+2) {
				//if i is even, vs if i is odd

				int [ ] x = {
						(int) (aX1 + (2*h*i)), 
						(int) (bX1 + (2*h*i)), 
						(int) (cX1 +(2*h*i)), 
						(int) (dX1 +(2*h*i)), 
						(int) (eX1 +(2*h*i)) , 
						(int) (fX1+(2*h*i)), 
						(int) (gX1 +(2*h*i)), 
						(int) (hX1 +(2*h*i)), 
						(int) (iX1 +(2*h*i)), 
						(int) (jX1 +(2*h*i)) 
				};


				
				//				int [ ] y = {h +(2*h*j), h +(2*h*j), 1 +(2*h*j), h +(2*h*j), h +(2*h*j), 95 +(2*h*j), g2 +(2*h*j), h +(2*h*j), i2 +(2*h*j), j2 +(2*h*j)};

				int [] y = {

						(int) (aY1 + (2*h*i)), 
						(int) (bY1 + (2*h*i)), 
						(int) (cY1 +(2*h*i)), 
						(int) (dY1 +(2*h*i)), 
						(int) (eY1 +(2*h*i)) , 
						(int) (fY1+(2*h*i)), 
						(int) (gY1 +(2*h*i)), 
						(int) (hY1 +(2*h*i)), 
						(int) (iY1 +(2*h*i)), 
						(int) (jY1 +(2*h*i)) 
				};

				g.drawPolygon(x, y, 10);


								g.drawOval(i*g1 - starWidth/2, j*e1, starDiameter, starDiameter);
			}
		}
		for(int j = 2; j <= 8; j = j+2) {
			for(int i = 2; i <= 10; i = i+2) { 
				g.drawOval(i*g1 - starWidth/2, j* e1, starDiameter, starDiameter);
			}
		}

	}
}
