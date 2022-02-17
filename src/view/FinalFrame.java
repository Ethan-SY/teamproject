package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import main.Main;
import model.CountDownFinal;
import model.ScorePrint;
import view.buttonsGUI.SingleGameButtons;
import view.login.UserName;
import view.numberGUI.NumberGUI;
import view.sounds.PlayBGM;

public class FinalFrame extends JFrame {

	private Image SCI;
	private Graphics SCG;
	private Image FinalBackGround = new ImageIcon("../LineNo5/src/finalIN/finalBackground.jpg").getImage();
	private JLabel menuB = new JLabel(new ImageIcon("../LineNo5/src/view/menuGUI/MenuBar.png"));
	private ImageIcon exitover = new ImageIcon(
			"C:\\Users\\Yeop\\Desktop\\LineNo5\\src\\finalIN\\ExitButtonMouseOver.png");
	private ImageIcon exitBasic = new ImageIcon("C:\\Users\\Yeop\\Desktop\\LineNo5\\src\\finalIN\\ExitButton.png");
	private JButton exit = new JButton(exitBasic);
	private int mouseX, mouseY;
	private JLabel gameoverLB = new JLabel(new ImageIcon("../LineNo5/src/finalIN/GameOverLB.png"));
	private JLabel ScoreBackGround = new JLabel(new ImageIcon("../LineNo5/src/finalIN/jumReal.gif"));
	private JLabel ScoreLabel = new JLabel(new ImageIcon("../LineNo5/src/finalIN/ok2.png"));
	private JLabel PlayerName = new JLabel(UserName.user);
	public static JLabel FinalCountDown = new JLabel("카운트 다운 시작 준비...");
	int index;
	public static int sc = 3, n;
	JList MusicList;
	JLabel PlayList;
	JButton finalExit, reGame, reStart;

//		public static ArrayList<ScorePrint> ScorePrintArr = null; //new ArrayList<ScorePrint>();

	public FinalFrame() {
		File file = null;
		FileWriter fw = null;
		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

		new PlayBGM();
		setUndecorated(true); // 기본메뉴바 숨기기
		setBackground(new Color(0, 0, 0, 0)); // paintcomponect 했을때 배경이 회색이 아니라 흰색으로 바뀜
		setSize(1280, 720);
		setResizable(false); // 사이즈 변경불가
		setLocationRelativeTo(null); // 화면 중앙에 뜸
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		FinalCountDown.setBounds(310, 100, 660, 160);
		FinalCountDown.setHorizontalAlignment(JLabel.CENTER);
		FinalCountDown.setOpaque(true);
		FinalCountDown.setBackground(new Color(0, 0, 0, 250));
		FinalCountDown.setForeground(Color.WHITE);
		FinalCountDown.setFont(new Font("Serif", Font.BOLD, 60));
		FinalCountDown.setVisible(false);
		add(FinalCountDown);

		JLabel Score = SingleGameButtons.NGUI;
		Score.setBounds(330, 315, SingleGameButtons.NGUI.getWidth(), SingleGameButtons.NGUI.getHeight());
		add(Score);

		ArrayList<ScorePrint> input_Ten = new ArrayList<ScorePrint>();
		String Info = UserName.user + "\t" + formatedNow + "\t" + SingleGameButtons.i;
		String fileName = "C:\\Users\\Yeop\\Desktop\\WO.txt";

		try {
			// 파일 객체 생성
			file = new File(fileName);
			// true 지정시 파일의 기존 내용에 이어서 작성
			fw = new FileWriter(file, true);
			// 파일안에 문자열 쓰기
			fw.append(Info);
			fw.flush();
			// 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}

		ArrayList<ScorePrint> input_all = new ArrayList<ScorePrint>();

		try {
			FileReader filereader = new FileReader(fileName);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";

			while ((line = bufReader.readLine()) != null) {
				String[] arry = line.split("\t");
				String name = arry[0];
				String time = arry[1];
				int score = Integer.valueOf(arry[2]);
				input_all.add(new ScorePrint(name, time, score));
			}
			input_all.sort(new Comparator<ScorePrint>() {

				@Override
				public int compare(ScorePrint o1, ScorePrint o2) {
					long score0 = o1.getScore();
					long score1 = o2.getScore();

					if (score0 == score1) {
						return 0;
					} else if (score1 > score0) {
						return 1;
					} else {
						return -1;
					}

				}

			});
			/// 추가종료

			PrintWriter writer = new PrintWriter(file);
			writer.print("");
			writer.close();

			if (input_all.size() < 10) {
				for (int i = 0; i < input_all.size(); i++) {
					if (i == 0) {
						fw.append(input_all.get(i).toString());
						fw.flush();
					} else {
						fw.append("\n" + input_all.get(i).toString());
						fw.flush();
					}
					System.out.println(input_all.get(i).toString());
				}
			} else {
				for (int i = 0; i < 10; i++) {
					if (i == 0) {
						fw.append(input_all.get(i).toString());
						fw.flush();
					} else {
						fw.append("\n" + input_all.get(i).toString());
						fw.flush();
					}
					System.out.println(input_all.get(i).toString());
				}

			}
			fw.append("\n");
			fw.flush();

			bufReader.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		ScoreLabel.setBounds(90, 165, 600, 100);
		add(ScoreLabel);

		PlayerName.setBounds(330, 500, 100, 50);
		PlayerName.setFont(new Font("굴림", Font.BOLD, 30));
		PlayerName.setForeground(Color.white);
		add(PlayerName);

		ScoreBackGround.setBounds(80, 200, 600, 400);
		ScoreBackGround.setBorder(null);
		ScoreBackGround.setOpaque(true);
		ScoreBackGround.setBackground(new Color(0, 0, 0, 100));
		add(ScoreBackGround);

		finalExit = new JButton("종료하기");
		finalExit.setBounds(80, 650, 100, 50);
		add(finalExit);

		finalExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		reGame = new JButton("다시하기");
		reGame.setBounds(200, 650, 100, 50);
		add(reGame);

		reGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				SingleGameButtons.LastV.clear();
				NumberGUI.n = 0;
				SingleGameButtons.i = 0;

				CountDownFinal com2 = new CountDownFinal(3, SingleGameFrame.num, Main.MA);
				Thread thcom2 = new Thread(com2);
				thcom2.start();
				PlayBGM.clip.stop();
				dispose();

//				new SingleGameFrame(SingleGameFrame.num);

			}

		});

		reStart = new JButton("처음으로");
		reStart.setBounds(320, 650, 100, 50);
		add(reStart);

		reStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SingleGameButtons.LastV.clear();
				NumberGUI.n = 0;
				SingleGameButtons.i = 0;
				SingleGameFrame.num = 0;
				PlayBGM.clip.stop();
				new MainFrame();
				dispose();

			}
		});

		PlayList = new JLabel("Play List");
		PlayList.setBounds(700, 200, 300, 50);
		PlayList.setFont(new Font("굴림", Font.BOLD, 30));
		PlayList.setForeground(Color.white);
		add(PlayList);

		MusicList = new JList(SingleGameButtons.LastV.toArray());
		MusicList.setFont(new Font("굴림", Font.PLAIN, 20));
		MusicList.setForeground(Color.white);
		MusicList.setOpaque(true);
		MusicList.setBackground(new Color(0, 0, 0, 100));
		JScrollPane JS = new JScrollPane(MusicList);
		JS.setBounds(700, 250, 500, 350);
		JS.setOpaque(true);
		JS.setBackground(new Color(0, 0, 0, 100));
		JS.getHorizontalScrollBar().setOpaque(true);
		JS.getHorizontalScrollBar().setBackground(new Color(0, 0, 0, 100));
		JS.setBorder(null);
		JS.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
			@Override // 스크롤 휠 색상
			protected void configureScrollBarColors() {
				this.thumbColor = new Color(255, 255, 255, 100);
			}

			@Override // 스크롤 버튼 색상
			protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
				c.setBackground(new Color(255, 255, 255, 100));
			}
		});

		add(JS);

		MusicList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				index = MusicList.locationToIndex(evt.getPoint());
				MusicList = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {
					String url = SingleGameButtons.LastIp[index];
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}

				// int index = list.locationToIndex(evt.getPoint());

			}
		});

		exit.setBounds(1245, 0, 30, 30);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setIcon(exitover);
				exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit.setIcon(exitBasic);
				exit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exit);

		gameoverLB.setBounds(425, 50, 400, 100);
		add(gameoverLB);

		menuB.setBounds(0, 0, 1280, 30);
		menuB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuB.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); // 메뉴바 이동하게해줌
			}

		});
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(menuB);

		setVisible(true);
	}

	public void paint(Graphics g) {
		SCI = createImage(1280, 720);
		SCG = SCI.getGraphics();
		screenDraw(SCG);
		g.drawImage(SCI, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(FinalBackGround, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

//		public void inputJson() {
//			
//			String jsonStr = univ.toString();
//			File jsonFile = new File("../LineNo5/src/model/Info_Score.json");
//
//			try {
//				writeStringToFile(jsonStr, jsonFile);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		public static void writeStringToFile(String str, File file) throws IOException {
//			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//			writer.write(str);
//			writer.close();
//		}

}
