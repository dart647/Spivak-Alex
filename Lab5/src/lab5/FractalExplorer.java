package lab5;
import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;
//import javax.imageio.ImageIO;
//import javax.swing.filechooser.FileNameExtensionFilter;

//import java.io.*;
import javax.swing.*;

public class FractalExplorer {

    private int display_size;
    private JImageDisplay mImage;
    private JButton reset_button;
    private FractalGenerator generate;
    private Rectangle2D.Double range;

	public static void main(String[] args) {
		FractalExplorer explorer = new FractalExplorer(800);
		explorer.createAndShowGUI();
		explorer.drawFractal();
	}

    private class FractalWorker extends SwingWorker<Object, Object> {

		 private int mY;
		 private int[] RGBValue;

		 public FractalWorker(int y) {
			 mY = y;
		 }

		public Object doInBackground() {
			RGBValue = new int[display_size];
			double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, display_size, mY);
			for (int x = 0; x < display_size; x++) {

				double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, display_size, x);
				int n_iters, colors = 0;;
			
				float temp;

				n_iters = generate.numIterations(xCoord, yCoord);
				if (n_iters >= 0) {
					temp = 0.7f + n_iters / 20f;
					colors = Color.HSBtoRGB(temp, 1f, 1f);
				}

				RGBValue[x] = colors;
			}
			return null;
		}

		public void done() {
			for (int x = 0; x < display_size; x++) {
				mImage.drawPixel(x, mY, RGBValue[x]);
			}
			mImage.repaint(0, 0, mY, display_size, 1);
		}
	 }

	public void drawFractal() {
		reset_button.setEnabled(true);
		for (int y = 0; y < display_size; y++) {
			FractalWorker worker = new FractalWorker(y);
			worker.execute();
		}
		mImage.repaint();
	}


    private class actListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("reset")) {
				range = new Rectangle2D.Double();
				generate.getInitialRange(range);

				drawFractal();
			}
		}
    }

    private class mouseListener extends MouseAdapter {
	
		public void mouseClicked(MouseEvent e) {
			double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, display_size, e.getX());
			double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, display_size, e.getY());
			generate.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
			drawFractal();
		}

    }

    public FractalExplorer(int size) {
		display_size = size;
		generate = new Mandelbrot();
		range = new Rectangle2D.Double();
		generate.getInitialRange(range);
    }

    public void createAndShowGUI() {
    	
		JFrame frame  = new JFrame("Fractal");
		actListener handler = new actListener();
		mImage = new JImageDisplay(display_size, display_size);
		frame.getContentPane().add(mImage, BorderLayout.CENTER);
		
		JPanel buttonsPanel = new JPanel();
		reset_button = new JButton("Обновить");
		reset_button.setActionCommand("reset");
		reset_button.addActionListener(handler);
		buttonsPanel.add(reset_button);

		frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		frame.getContentPane().addMouseListener(new mouseListener());
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
    }
}