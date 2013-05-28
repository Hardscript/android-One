package au.com.advproj.testapp;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;


public class Camera extends Activity implements View.OnClickListener {

    Button bTakePic;
    Button bSetWall;
    ImageView iv;
    Intent i;
    final static int cameraData = 0;
    Bitmap bmp;
    WallpaperManager myWallpaperManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();

        InputStream is = getResources().openRawResource(R.drawable.alphones);
        bmp = BitmapFactory.decodeStream(is);

    }

    private void initialize() {
        iv = (ImageView) findViewById(R.id.ivReturnedPic);
        bTakePic = (Button) findViewById(R.id.bTakePic);
        bSetWall = (Button) findViewById(R.id.bSetWallpaper);
        bSetWall.setOnClickListener(this);
        bTakePic.setOnClickListener(this);
        myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bSetWallpaper:
                try{
                    myWallpaperManager.setBitmap(bmp);
                }catch (IOException e){
                    e.printStackTrace();
                }
            break;
            case R.id.bTakePic:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cameraData); //Starts Activity and Accepts Return Data. (onActivityResult)
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bmp =(Bitmap) extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}

