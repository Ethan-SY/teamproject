package main;

import javax.swing.JFrame;

import view.MainFrame;
import view.login.LoginView;

public class Main {
	LoginView loginView;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.loginView = new LoginView(); // 로그인창 보이기
		main.loginView.setMain(main); // 로그인창에게 메인 클래스보내기
	}

	// 테스트프레임창
	public void showFrameTest() {
		loginView.dispose(); // 로그인창닫기
		new MainFrame(); // 클라이언트 게임 실행
	}
}
