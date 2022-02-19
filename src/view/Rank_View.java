package view;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.stage.Window;
import view.login.UserName;

public class Rank_View extends Application{
		
	   public static Stage Stage;
	   final static String Score_1 = "ㅁㅁ";   //플레이어 이름
	    
	   public static ArrayList<XYChart.Series> fuck; //= new ArrayList<XYChart.Series>();
	   
	  
		@Override
		public void start(Stage Stage) throws Exception {
			this.Stage = Stage;
	    	fuck = new ArrayList<XYChart.Series>();
	    	Stage.setTitle("가보자고!");
	        
	        final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        final BarChart<String,Number> bc = 
	            new BarChart<>(xAxis,yAxis);
	        bc.setTitle("Top10 점수차트");
	        xAxis.setLabel("Player");       
	        yAxis.setLabel("점수");
	 
	        
	        for(int i=0;i<FinalFrame.Chart_Day.size();i++) {
	           fuck.add(new XYChart.Series());
	           fuck.get(i).setName(FinalFrame.Chart_Day.get(i));
	           fuck.get(i).getData().add(new XYChart.Data(Score_1, FinalFrame.Chart_Score.get(i)));
	           bc.getData().add(fuck.get(i));
	        }
	       
	        
//	        XYChart.Series series10 = new XYChart.Series();
//	        series10.setName(FinalFrame.Chart_Day.get(9));       
//	        series10.getData().add(new XYChart.Data(Score_1, FinalFrame.Chart_Score.get(9)));
	        
	       
	        
	        
	        
	        bc.setLegendSide(Side.LEFT);
	        Scene scene  = new Scene(bc,800,600);
//	        bc.getData().addAll(fuck.get(0));
	        Stage.setScene(scene);
	        Stage.show();
		}
	    
//	public static void main(String[] args) {
//		launch();
//	}
	
	   
	}

