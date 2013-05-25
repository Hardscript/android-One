package au.com.advproj.testapp;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class Splash extends Activity{

    //gLocals
    MediaPlayer ourSong;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        //BackGround Music
        ourSong = MediaPlayer.create(Splash.this, R.raw.kalimba);
        ourSong.start();

        //Timer Thread.
        Thread timer = new Thread(){
          public void run(){
              try{
                sleep(5000); //Pauses Splash screen for 5 seconds.
              }catch(InterruptedException e){
                e.printStackTrace();
              }finally {
                  //Creates Intent Object for MainActivity and Starts it.
                  Intent openMainActivity = new Intent("android.intent.action.Menu");
                  startActivity(openMainActivity);
              }
          }
        };
        timer.start();
    }

    protected void onPause(){
        super.onPause();
        ourSong.release(); //Releases Music
        finish(); //Closes Activity.
    }
}
