package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import view.buttonsGUI.FinalButtons_test;
import view.menuGUI.MenuBar;
import view.sounds.PlayBGM;

public class FinalFrame_test extends JFrame {
	private Image screenIm;
	private Graphics screenGr;
	private Image background = new ImageIcon("../LineNo5/src/finalIN/finalBackground.jpg").getImage();
	
	
	public FinalFrame_test() {
		Default.DefaultFrame(this, 1280, 720);
		MenuBar.MainMenuBar(this);
		new PlayBGM();
		new FinalButtons_test(this);
	}
		
	

	public void paint(Graphics g) {
		screenIm = createImage(1280, 720);
		screenGr = screenIm.getGraphics();
		screenDraw(screenGr);
		g.drawImage(screenIm, 0, 0, null);
		
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	

}
