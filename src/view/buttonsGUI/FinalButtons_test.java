package view.buttonsGUI;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import model.CountDown;
import view.SingleGameFrame;
import view.numberGUI.NumberGUI;
import view.sounds.PlayBGM;

public class FinalButtons_test extends JFrame{
	ImageIcon GameOver = new ImageIcon("../LineNo5/src/finalIN/gameover.png");
	Image img = GameOver.getImage();
	Image changeImg = img.getScaledInstance(400, 100, Image.SCALE_SMOOTH);
	ImageIcon changeIcon = new ImageIcon(changeImg);
	JLabel GameOverLB = new JLabel(changeIcon);
	JLabel score_BackGround = new JLabel(new ImageIcon("../LineNo5/src/finalIN/jumReal.gif"));
	JLabel ScoreLabel = new JLabel(new ImageIcon("../LineNo5/src/finalIN/ok2.png"));
	JLabel result,PlayList;
	JButton ExitButton, ReGameButton;
	JScrollPane ListScroll;
	JLabel Jumsu;
	int index;
	JList MusicList;
	public FinalButtons_test() {
		
	}
	public FinalButtons_test(JFrame jFrame) {
				
		ReGameButton = new JButton("다시하기");
		ReGameButton.setBounds(200, 650, 100, 50);
		jFrame.add(ReGameButton);
		
		ReGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			SingleGameButtons.LastV.clear();  
			NumberGUI.n = 0;
			SingleGameButtons.i = 0;
			CountDown com = new CountDown(3,SingleGameFrame.num, jFrame);
			Thread thcom = new Thread(com);
			thcom.start();
			PlayBGM.clip.stop();
			
			// 창 닫는 명령어 없는데 왜 닫히는지는 모르겠음..
//			new SingleGameFrame(SingleGameFrame.num);
			}
		});
		
		GameOverLB.setBounds(425, 50, 400, 100);           //  GameOver 라벨
		jFrame.add(GameOverLB);
		
		score_BackGround.setBounds(80, 200, 600, 400);     //  점수판 뒷배경
		score_BackGround.setBorder(null);
		score_BackGround.setOpaque(true);
		score_BackGround.setBackground(new Color(0, 0, 0, 100));
		jFrame.add(score_BackGround);
		
		ScoreLabel.setBounds(90, 165, 600, 100);           //  score 라벨
		jFrame.add(ScoreLabel);
		
		Jumsu = SingleGameButtons.NGUI;                    //  정답갯수 표시
		Jumsu.setBounds(330, 315, SingleGameButtons.NGUI.getWidth(), SingleGameButtons.NGUI.getHeight());
		jFrame.add(Jumsu);

		
		
		
		PlayList = new JLabel("Play List");                // 재생음악목록 라벨
		PlayList.setBounds(700, 200, 300, 50);
		PlayList.setFont(new Font("굴림", Font.BOLD, 30));
		PlayList.setForeground(Color.white);
		jFrame.add(PlayList);

		MusicList = new JList(SingleGameButtons.LastV.toArray());   // 재생음악목록
		MusicList.setFont(new Font("굴림", Font.PLAIN, 20));
		MusicList.setForeground(Color.white);
		MusicList.setOpaque(true);
		MusicList.setBackground(new Color(0, 0, 0, 100));
		
		ListScroll = new JScrollPane(MusicList);
		ListScroll.setBounds(700, 250, 500, 350);
		ListScroll.setOpaque(true);
		ListScroll.setBackground(new Color(0, 0, 0, 100));
		ListScroll.getHorizontalScrollBar().setOpaque(true);
		ListScroll.getHorizontalScrollBar().setBackground(new Color(0, 0, 0, 100));
		ListScroll.setBorder(null);
		ListScroll.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
			@Override // 스크롤 휠 색상
			protected void configureScrollBarColors() {
				this.thumbColor = new Color(255, 255, 255, 100);
			}

			@Override // 스크롤 버튼 색상
			protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
				c.setBackground(new Color(255, 255, 255, 100));
			}
		});
		jFrame.add(ListScroll);
		
		
		ExitButton = new JButton("종료하기");
		ExitButton.setBounds(80, 650, 100, 50);
		jFrame.add(ExitButton);
		
		
		
		
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
		
		ExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			  }
	 	 });

		
	
		
		
//		result = new JLabel();
//		result.setText(UserName.user +"    "+NumberGUI.n+"  점");
//		result.setBounds(100, 100, 200, 50);
//		result.setForeground(Color.green);
//		result.setFont(new Font("굴림", Font.PLAIN, 20));
		// add(result);

		
	
		
		
	}

}
