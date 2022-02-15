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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import org.json.simple.JSONObject;

import main.Main;
import model.CountDown;
import model.CountDownFinal;
import model.ScorePrint;
import view.buttonsGUI.SingleGameButtons;
import view.login.UserName;
import view.numberGUI.NumberGUI;
import view.sounds.MusicBackGround;
import view.sounds.PlayBGM;

public class FinalFrame extends JFrame{
	   
		private Image SCI;
		private Graphics SCG;
		private Image FinalBackGround = new ImageIcon("../LineNo5/src/finalIN/finalBackground.jpg").getImage();
		private JLabel menuB = new JLabel(new ImageIcon("../LineNo5/src/view/menuGUI/MenuBar.png"));
		private ImageIcon exitover = new ImageIcon("C:\\Users\\Yeop\\Desktop\\LineNo5\\src\\finalIN\\ExitButtonMouseOver.png");
		private ImageIcon exitBasic = new ImageIcon("C:\\Users\\Yeop\\Desktop\\LineNo5\\src\\finalIN\\ExitButton.png");
		private JButton exit = new JButton(exitBasic);
		private int mouseX, mouseY;
		private JLabel gameoverLB = new JLabel(new ImageIcon("../LineNo5/src/finalIN/GameOverLB.png"));
		private JLabel ScoreBackGround = new JLabel(new ImageIcon("../LineNo5/src/finalIN/jumReal.gif"));
		private JLabel ScoreLabel = new JLabel(new ImageIcon("../LineNo5/src/finalIN/ok2.png"));
		private JLabel PlayerName = new JLabel(UserName.user);
		public static JLabel FinalCountDown = new JLabel("카운트 다운 시작 준비...");
		int index;
		public static int sc=3, n;
		JList MusicList;
		JLabel PlayList;
		JButton finalExit, reGame, reStart;
//		public ArrayList<ScorePrint> ScorePrintArr;
//		public static int Key = 0;
//		public static Map<Integer,ScorePrint> Score_Info_Map = new HashMap<>();  // 스코어 출력정보 저장
		
		
		
		
		public FinalFrame() {
			
//			ScorePrintArr.add(new ScorePrint(UserName.user, "20시30분", SingleGameButtons.i));
//			Score_Info_Map.put(Key, );
//			Key++;
//				
//			JSONObject jo = new JSONObject();
//			jo.putAll(Score_Info_Map);
			
			
			new PlayBGM();
			setUndecorated(true); // 기본메뉴바 숨기기
			setBackground(new Color(0, 0, 0, 0)); // paintcomponect 했을때 배경이 회색이 아니라 흰색으로 바뀜
			setSize(1280, 720);
			setResizable(false);  // 사이즈 변경불가
			setLocationRelativeTo(null);    // 화면 중앙에 뜸
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(null);
			
		
			
			FinalCountDown.setBounds(310, 100, 660, 160);
			FinalCountDown.setHorizontalAlignment(JLabel.CENTER);
			FinalCountDown.setOpaque(true);
			FinalCountDown.setBackground(new Color(0,0,0,250));
			FinalCountDown.setForeground(Color.WHITE);
			FinalCountDown.setFont(new Font("Serif",Font.BOLD,60));
			FinalCountDown.setVisible(false);
			add(FinalCountDown);
			
			JLabel Score = SingleGameButtons.NGUI;
			Score.setBounds(330, 315, SingleGameButtons.NGUI.getWidth(), SingleGameButtons.NGUI.getHeight());
			add(Score);

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
							
				CountDownFinal com2 = new CountDownFinal(3,SingleGameFrame.num,Main.MA);
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
		
		

	}

