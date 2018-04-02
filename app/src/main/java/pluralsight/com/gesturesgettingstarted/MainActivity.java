package pluralsight.com.gesturesgettingstarted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    //widgets
    private ImageView mImageView1,mImageView2;


    //vars


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView1 = findViewById(R.id.image1);
        mImageView2 = findViewById(R.id.image2);

        setImage();
    }

    private void setImage(){
        Glide.with(this)
                .load(R.drawable.france_mtn)
                .into(mImageView1);

        Glide.with(this)
                .load(R.drawable.oregon_beach)
                .into(mImageView2);
    }
}





















