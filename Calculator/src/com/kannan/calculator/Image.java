package com.kannan.calculator;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
//import android.view.Menu;

public class Image extends Activity{
	
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		ourSong = MediaPlayer.create(Image.this,R.raw.speaking);
		ourSong.start();
		Thread timer = new Thread(){
		 public void run(){
			 try{
				 sleep(1000);	 
				 
			 } catch(InterruptedException e){
				e.printStackTrace(); 
			 }finally{
				 Intent openStartingPoint = new Intent("com.kannan.calculator.MainActivity");
				 startActivity(openStartingPoint);
			 }
		 }
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	



	
	

}
