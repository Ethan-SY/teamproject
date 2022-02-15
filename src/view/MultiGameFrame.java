package view;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Main;
import model.PlayWav;
import view.buttonsGUI.MultiGameButtons;
import view.menuGUI.MenuBar;

public class MultiGameFrame extends JFrame{
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("/view/playBackground.jpg")).getImage();
	
	public MultiGameFrame() {
		Default.DefaultFrame(this, 1200, 700); // 프레임 디폴트
		MenuBar.GameMenubar(this); // 상단 메뉴바 추가 메소드
		MultiGameButtons.AddMultiGameButtons(this); // 멀티 게임 버튼 추가 메소드
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(1200, 900);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	
	public static void playMusic() {
		try {
			new PlayWav("/python_MH/audio/OneSecond/",1);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
}
