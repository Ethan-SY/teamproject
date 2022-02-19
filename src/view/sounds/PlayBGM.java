package view.sounds;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayBGM extends Thread {
	public static Clip clip;
	public PlayBGM() {
		try {

			File file = new File("../LineNo5/src/finalIN/nawhij - loud nine.wav");
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));

			clip.loop(0);
			// clip.loop(Clip.LOOP_CONTINUOUSLY); //무한 반복
			clip.start();

		} catch (Exception e) {
			System.err.println(
					"Put the music.wav file in the sound folder if you want to play background music, only optional!");
		}

	}
	
	public void close() {
		clip.close();
	}
}
