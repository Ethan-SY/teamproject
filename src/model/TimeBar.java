package model;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import view.FinalFrame;

public class TimeBar extends JLabel implements Runnable {
	
	int width = 450, height = 50, gow =450;
	int x = 400, y = 40;
	Color color = new Color(255, 0, 0);
	int second;
	JFrame getFrame;
//	JFrame FinalFrame = new JFrame();
	public int getGow() {
		return gow;
	}

	public TimeBar(int second, JFrame jFrame) {
		setBackground(color);
		setOpaque(true);
		setBounds(x, y, width, height);
		
		this.second = second;
		this.getFrame = jFrame;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000 / (width / second));
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (getWidth() > 0) {
				gow -= 1;
				
				setBounds(x, y, gow, height);
			} else {
				
				break;
			}
			
			if (gow == 0) {
				getFrame.dispose();
				new FinalFrame();
			}
			
		}
		
	}
}
