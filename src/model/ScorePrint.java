package model;

public class ScorePrint {
	
	private String name;
	private String time;
	private int score;
	
		
	public ScorePrint(String name, String time,  int score) {
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
	
//    public int compareTo(ScorePrint comparestu) {
//        int compareage=((ScorePrint)comparestu).getScore();
//        /* For Ascending order*/
//        return this.score-compareage;
//
//        /* For Descending order do like this */
//       // return compareage-this.score;
//    }
	
	@Override

	public String toString() {
		
		return name +"	" +time +"	" +score;
	}
//	@Override
//	public int compareTo(Object o) {
//		return 0;
//	}

}
