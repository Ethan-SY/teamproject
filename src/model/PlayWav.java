package model;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.*;

// 랜덤으로 wav 파일 한곡 재생 클래스
public class PlayWav {
	public static boolean isplayed = false;
	public static Clip clip = null;
	String dir;
	// 경로를 인자로 받음
	public PlayWav(String dir, int N) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		String number = Integer.toString(N); // 랜덤 숫자 문자로 변환
		String filename = dir + number+".wav"; 
		File file = new File(filename); // 경로에 있는 파일 선택
		// 재생
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
}
