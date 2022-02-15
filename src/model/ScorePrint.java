package model;

public class ScorePrint {
	
	private String name;
	private String time;
	private int score;
	
	public ScorePrint(String name, String time, int score) {
		this.name = name;
		this.time = time;
		this.score = score;
		
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


}
