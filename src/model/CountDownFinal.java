package model;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import view.FinalFrame;
import view.MultiGameFrame;
import view.SingleGameFrame;

public class CountDownFinal extends JLabel implements Runnable{
	
	int sc, n;

	public CountDownFinal(int sc, int n) {
		this.sc = sc;
		this.n = n;
		FinalFrame.FinalCountDown.setVisible(true);
	}

	
	@Override
	public void run() {
		while (true) {
			try {
				if (sc != 3) {
					Thread.sleep(1000); // 1초
				 }
			 }catch (Exception e) {
				 e.printStackTrace();
			   }
			
			if (sc > 0) {
				FinalFrame.FinalCountDown.setText(sc + "초후에 시작합니다.\n준비하세요");
				sc--;
			} else {
				try {
					if(n==1) {
						new SingleGameFrame(1);
					} else if(n==5) {
						new SingleGameFrame(5);
					} else if(n==10) {
						new SingleGameFrame(10);
					} else {
						new MultiGameFrame();
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FinalFrame.FinalCountDown.setVisible(false);
//				FinalFrame.
				return;
			  }
        }
	}
}
