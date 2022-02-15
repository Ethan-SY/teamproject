package view.buttonsGUI;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import User.MusicInfo;
import main.Main;
import model.AutoLabel;
import model.MusicList;
import model.Photo;
import model.ReadTxt;
import model.TimeBar;
import view.SingleGameFrame;
import view.countGUI.HintCount;
import view.countGUI.NextCount;
import view.numberGUI.NumberGUI;
import view.sounds.MusicBackGround;

public class SingleGameButtons extends JFrame {
	public static List<String> LastV  = new ArrayList<String>();
	public static String[] LastIp = new String[30];
	public static Random random = new Random();
	public static int N = 0;
	public static int i = 0;
	public static Photo photo;
	public static JButton photoButton;
	public static int[] RandArray = RandN(30);
	public static int Nextnum = 0;
	public static JLabel NGUI = null;
	public static void AddSingleGameButtons(JFrame jFrame) throws IOException, InterruptedException {
		N = RandArray[Nextnum];
	
		ImageIcon NextBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/NextButton.png"));
		ImageIcon NextBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/NextButtonMouseOver.png"));
		ImageIcon PlayMusicBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayMusicBtn.png"));
		ImageIcon PlayMusicBtnMouseOver = new ImageIcon(
				Main.class.getResource("/view/buttonsGUI/PlayMusicBtnMouseOver.png"));
		ImageIcon SingerHintBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SingerHintBtn.png"));
		ImageIcon SingerHintBtnMouseOver = new ImageIcon(
				Main.class.getResource("/view/buttonsGUI/SingerHintBtnMouseOver.png"));
		ImageIcon SongHintBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SongHintBtn.png"));
		ImageIcon SongHintBtnMouseOver = new ImageIcon(
				Main.class.getResource("/view/buttonsGUI/SongHintBtnMouseOver.png"));
		ImageIcon SubmitBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SubmitBtn.png"));
		ImageIcon SubmitBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SubmitBtnMouseOver.png"));

		NumberGUI numbergui = new NumberGUI();
		NGUI = new JLabel(numbergui.Numbergui(i));

		JButton NextButton = new JButton(NextBtn);
		JButton PlayMusicButton = new JButton(PlayMusicBtn);
		JButton SingerHintButton = new JButton(SingerHintBtn);
		JButton SongHintButton = new JButton(SongHintBtn);
		JButton SubmitButton = new JButton(SubmitBtn);

		JTextField Enter = new JTextField(10);
		JLabel label = new JLabel();

		ArrayList MList = MusicList.musiclist();

		AutoLabel HintLabel = new AutoLabel("힌트 없음");

		HintCount hintcount = new HintCount();
		for (int i = 0; i < 6; i++) {
			hintcount.setCount(i);
			hintcount.Remain().setVisible(true);
		}

		NextCount nextcount = new NextCount();
		for (int i = 0; i < 6; i++) {
			nextcount.setCount(i);
			nextcount.Remain().setVisible(true);
		}
		ReadTxt readtxt = new ReadTxt();
		
		MusicInfo musicinfo = (MusicInfo) MList.get(N);
//		LastView[Nextnum] =  musicinfo.getSingerHint() +"  -  "+ musicinfo.getSong() ;
		LastV.add((musicinfo.getSingerHint() +"  -  "+ musicinfo.getSong()));
		LastIp[Nextnum] = musicinfo.getIp();
		
		
		photo = new Photo(N);
		photoButton = new JButton(photo.getPhoto());
		photoButton.setBounds(370, 90, 500, 500);
		photoButton.setBorderPainted(false);
		photoButton.setContentAreaFilled(false);
		photoButton.setFocusPainted(false);

		
		NextButton.setBounds(1000, 570, 120, 120);
		NextButton.setBorderPainted(false);
		NextButton.setContentAreaFilled(false);
		NextButton.setFocusPainted(false);
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (nextcount.getCount() > 0) {
					nextcount.Remain().setVisible(false);
					nextcount.setCount(nextcount.getCount() - 1);
					jFrame.add(nextcount.Remain());
					Nextnum++;
					N = RandArray[Nextnum];
					MusicInfo musicinfo = (MusicInfo) MList.get(N);
//					LastView[Nextnum] =  (musicinfo.getSingerHint() +"  -  "+ musicinfo.getSong()) ;
					LastV.add((musicinfo.getSingerHint() +"  -  "+ musicinfo.getSong()));
					LastIp[Nextnum] = musicinfo.getIp();
					
					SingleGameFrame.playMusic(N);
					photo.setFileName();
					photo.setOriginfileName(N);
					photoButton.setIcon(photo.getPhoto());
					HintLabel.setText("힌트 없음");
					HintLabel.resize();
				} else {
					System.out.println("다음없음");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				NextButton.setIcon(NextBtnMouseOver);
				NextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				NextButton.setIcon(NextBtn);
				NextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		PlayMusicButton.setBounds(80, 60, 120, 120);
		PlayMusicButton.setBorderPainted(false);
		PlayMusicButton.setContentAreaFilled(false);
		PlayMusicButton.setFocusPainted(false);
		PlayMusicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				SingleGameFrame.playMusic(N);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				PlayMusicButton.setIcon(PlayMusicBtnMouseOver);
				PlayMusicButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				PlayMusicButton.setIcon(PlayMusicBtn);
				PlayMusicButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		NGUI.setBounds(210, 60, 120, 120);

		SingerHintButton.setBounds(50, 310, 300, 81);
		SingerHintButton.setBorderPainted(false);
		SingerHintButton.setContentAreaFilled(false);
		SingerHintButton.setFocusPainted(false);
		SingerHintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (hintcount.getCount() > 0) {
					hintcount.Remain().setVisible(false);
					hintcount.setCount(hintcount.getCount() - 1);
					jFrame.add(hintcount.Remain());
					MusicInfo musicinfo = (MusicInfo) MList.get(N);
					HintLabel.setText("가수 : " + musicinfo.getSingerHint());
					HintLabel.resize();
				} else {
					HintLabel.setText("힌트 없음");
					HintLabel.resize();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SingerHintButton.setIcon(SingerHintBtnMouseOver);
				SingerHintButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SingerHintButton.setIcon(SingerHintBtn);
				SingerHintButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		
		
		
		SongHintButton.setBounds(50, 398, 300, 81);
		SongHintButton.setBorderPainted(false);
		SongHintButton.setContentAreaFilled(false);
		SongHintButton.setFocusPainted(false);
		SongHintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (hintcount.getCount() > 0) {
					hintcount.Remain().setVisible(false);
					hintcount.setCount(hintcount.getCount() - 1);
					jFrame.add(hintcount.Remain());
					MusicInfo musicinfo = (MusicInfo) MList.get(N);
					HintLabel.setText("제목 초성 : " + musicinfo.getSongHint());
					HintLabel.resize();
				} else {
					HintLabel.setText("힌트 없음");
					HintLabel.resize();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SongHintButton.setIcon(SongHintBtnMouseOver);
				SongHintButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SongHintButton.setIcon(SongHintBtn);
				SongHintButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		HintLabel.setBounds(50, 398 + 90, 300, 81);

		Enter.setBounds(430, 590, 300, 81);
		Font font = new Font("Courier", Font.BOLD, 25);
		Enter.setFont(font);
		Action action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean answer = Answer(Enter.getText(), N);
					MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
					if (answer == true) {
						buttonSound.start(); // 임시음
						i++;
						NGUI.setIcon(numbergui.Numbergui(i));
						Nextnum++;
						N = RandArray[Nextnum];
						MusicInfo musicinfo = (MusicInfo) MList.get(N);
//						LastView[Nextnum] =  (musicinfo.getSingerHint() +"  -  "+ musicinfo.getSong()) ;
						LastV.add((musicinfo.getSingerHint() +"  -  "+ musicinfo.getSong()));
						LastIp[Nextnum] = musicinfo.getIp();
												
						SingleGameFrame.playMusic(N);
						photo.setFileName();
						photo.setOriginfileName(N);
						photoButton.setIcon(photo.getPhoto());
						Enter.setText(null);
						HintLabel.setText("힌트 없음");
						HintLabel.resize();
					} else if (answer == false && !Enter.getText().equals("LineNo5")) {
						Enter.setText(null);
					} else if (Enter.getText().equals("LineNo5")) {
						photoButton.setIcon(photo.getPhotoOn());
						MusicInfo musicinfo = (MusicInfo) MList.get(N);
						Enter.setText(musicinfo.getSong());
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};

		Enter.addActionListener(action);

		SubmitButton.setBounds(740, 590, 81, 81);
		SubmitButton.setBorderPainted(false);
		SubmitButton.setContentAreaFilled(false);
		SubmitButton.setFocusPainted(false);
		SubmitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					boolean answer = Answer(Enter.getText(), N);
					MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
					if (answer == true) {
						buttonSound.start(); // 임시음
						i++;
						NGUI.setIcon(numbergui.Numbergui(i));
						Nextnum++;
						N = RandArray[Nextnum];
						SingleGameFrame.playMusic(N);
						photo.setFileName();
						photo.setOriginfileName(N);
						photoButton.setIcon(photo.getPhoto());
						Enter.setText(null);
						HintLabel.setText("힌트 없음");
						HintLabel.resize();
					} else if (answer == false && !Enter.getText().equals("LineNo5")) {
						Enter.setText(null);
					} else if (Enter.getText().equals("LineNo5")) {
						photoButton.setIcon(photo.getPhotoOn());
						MusicInfo musicinfo = (MusicInfo) MList.get(N);
						Enter.setText(musicinfo.getSong());
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SubmitButton.setIcon(SubmitBtnMouseOver);
				SubmitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SubmitButton.setIcon(SubmitBtn);
				SubmitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		

		jFrame.add(NextButton);
		jFrame.add(PlayMusicButton);
		jFrame.add(NGUI);
		jFrame.add(SongHintButton);
		jFrame.add(SingerHintButton);
		jFrame.add(HintLabel);
		jFrame.add(label);
		jFrame.add(Enter);
		jFrame.add(hintcount.Remain());
		jFrame.add(nextcount.Remain());
		jFrame.add(photoButton);
		jFrame.add(SubmitButton);

		TimeBar timeBar;
		Thread threadBar;
		timeBar = new TimeBar(5,jFrame);
		threadBar = new Thread(timeBar);
		threadBar.start();
		jFrame.add(timeBar);

		// 처음 게임 시작
		SingleGameFrame.playMusic(N);
	}

	private static boolean Answer(String text, int num) throws IOException {
		ArrayList MList = MusicList.musiclist();
		MusicInfo musicinfo = (MusicInfo) MList.get(num);
		System.out.println(musicinfo.getSong());
		boolean check = false;
		for (int i = 0; i < MList.size(); i++) {
			if (musicinfo.getSong().equals(text)) {
				System.out.println("정답!");
				check = true;
				break;
			}
		}
		return check;
	}

	private static int[] RandN(int num) {
		int[] a = new int[num];
		Random r = new Random();
		int randnum = 0;
		for (int i = 0; i < num; i++) {
			a[i] = r.nextInt(30);
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
				}
			}
		}
		return a;
	}


}
