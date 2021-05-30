package ver2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GUI extends JPanel implements Observer {

	Dimension dim;
	JPanel panel;
	Model model;

	int sideLength;

	public GUI(Model model, int sideLength) {
		setBackground(Color.white);
		this.sideLength = sideLength;
		this.model = model;

	}

	public void setSideLength(int length) {
		this.sideLength = length;
	}

	private void drawGrid(Graphics g) {

		g.setColor(Color.black);
		int i = 0;
		int j = 0;
		while (i < this.getHeight() || i < this.getWidth()) {

			g.drawLine(0, j * sideLength, this.getWidth(), j * sideLength);
			g.drawLine(j * sideLength, 0, j * sideLength, this.getHeight());

			i = i + sideLength;
			j++;
		}

	}

	private void drawSidedSquare(Graphics g, int x, int y) {
		g.setColor(Color.red);
		g.fillRect(x, y, sideLength, sideLength);
		g.setColor(Color.black);
		g.drawRect(x, y, sideLength, sideLength);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawGrid(g);
		Iterator it = model.getField().entrySet().iterator();
		while (it.hasNext()) {

			Map.Entry p = (Map.Entry) it.next();
			int x, y;
			x = ((Pair) p.getKey()).getFirst() * sideLength;
			y = ((Pair) p.getKey()).getSecond() * sideLength;
			drawSidedSquare(g, x, y);

		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

		repaint();

	}

}
