package ver2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Run implements Runnable {
	Model model;
	GUI gui;
	Controller ctrl;
	readyCoords coords;
	JFrame frame;
	JButton btn;
	int sideLength;
	int speed;
	boolean running;
	double frameRate;

	public Run() {
		
		sideLength = 5;
		//speed = 1000;
		frameRate = 144;
		running = true;
		coords = new readyCoords();		
		model = new Model();
		int p = 4;
		for(int i = 0; i< 16*p; i++) {
			for(int j= 0; j< 9*p; j++) {
				model.addModel(coords.u, new int[] {5*i,5*j});
			}
			
			
			
		}
		
//		model.addModel(coords.cannon, new int[] {10,10});
//		model.addModel(coords.cannon, new int[] {60,10});
//		model.addModel(coords.cannon, new int[] {110,10});
//		model.addModel(coords.cannon, new int[] {160,10});
		ctrl = new Controller(model);
		gui = new GUI(model, sideLength);
		model.addObserver(gui);
		gui.setDoubleBuffered(true);
		
		frame = new JFrame("THE FRAME");
		frame.add(gui);
		frame.setSize(new Dimension(1200,800));
		
		btn = new JButton("Pause");
		gui.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(running) {
					running = false;
					btn.setText("Play");
				}else {
					running = true;
					btn.setText("Pause");
				}
				
			}
			
			
		});
		
		gui.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int x = arg0.getX()/sideLength;
				int y = arg0.getY()/sideLength;
				if(model.contains(new Pair(x,y))) {
					ctrl.dropPos(x, y);
				}
				else {
					ctrl.fillPos(x, y);
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    frame.setVisible(true);  
		
		
		
		
	}
	
	
	@Override
	public void run() {
		double oldTime = System.nanoTime();
		double newTime;
		
		double interval = 1000000000/frameRate;
		
		while(true) {
			
				newTime = System.nanoTime();
				double delta = newTime - oldTime;
				
				if(running && (delta >= interval)) {
					System.out.println("Delta time: " +delta/1000000000 + " seconds" );
					ctrl.calcNextRound();
					oldTime = newTime;
					
				}
				
		}
		
		
	
	}

}
