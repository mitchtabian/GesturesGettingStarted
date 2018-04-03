package pluralsight.com.gesturesgettingstarted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements
        View.OnTouchListener,
        GestureDetector.OnGestureListener,
        View.OnDragListener,
        GestureDetector.OnDoubleTapListener{

    private static final String TAG = "MainActivity";


    //widgets
    private ImageView mImageView1,mImageView2;


    //vars
    private GestureDetector mGestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView1 = findViewById(R.id.image1);
        mImageView2 = findViewById(R.id.image2);

        mImageView1.setOnTouchListener(this);
        mImageView2.setOnTouchListener(this);
        mGestureDetector = new GestureDetector(this, this);

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

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

//        int action = motionEvent.getAction();
//        switch(action) {
//            case (MotionEvent.ACTION_DOWN) :
//                Log.d(TAG,"Action was DOWN");
//                return true;
//            case (MotionEvent.ACTION_MOVE) :
//                Log.d(TAG,"Action was MOVE");
//                Log.d(TAG, "onTouch: (x,y): (" + motionEvent.getX() + " , " + motionEvent.getY() + ")");
//                return true;
//            case (MotionEvent.ACTION_UP) :
//                Log.d(TAG,"Action was UP");
//                return true;
//            case (MotionEvent.ACTION_CANCEL) :
//                Log.d(TAG,"Action was CANCEL");
//                return true;
//            case (MotionEvent.ACTION_OUTSIDE) :
//                Log.d(TAG,"Movement occurred outside bounds " +
//                        "of current screen element");
//                return true;
//            default :
//                return super.onTouchEvent(motionEvent);
//        }

        if(view.getId() == R.id.image1){
            //methods for touching image1
            mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        if(view.getId() == R.id.image2){
            //methods for touching image2
            return false;
        }

        return true;
    }

    /*
        GestureDetector
     */
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.d(TAG, "onDown: called.");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.d(TAG, "onShowPress: called.");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Log.d(TAG, "onSingleTapUp: called.");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.d(TAG, "onScroll: called.");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.d(TAG, "onLongPress: called.");

        View.DragShadowBuilder builder = new View.DragShadowBuilder(mImageView1);

        mImageView1.startDrag(null,
                builder,
                null,
                0);

        builder.getView().setOnDragListener(this);
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.d(TAG, "onFling: called.");
        return false;
    }

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {

        switch(dragEvent.getAction()) {

            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(TAG, "onDrag: drag started.");

                return true;

            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(TAG, "onDrag: drag entered.");
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                Log.d(TAG, "onDrag: current point: ( " + dragEvent.getX() + " , " + dragEvent.getY() + " )"  );

                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(TAG, "onDrag: exited.");
                return true;

            case DragEvent.ACTION_DROP:

                Log.d(TAG, "onDrag: dropped.");

                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(TAG, "onDrag: ended.");


                return true;

            // An unknown action type was received.
            default:
                Log.e(TAG,"Unknown action type received by OnStartDragListener.");
                break;

        }

        return false;
    }

    /*
        DoubleTap
     */

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Log.d(TAG, "onSingleTapConfirmed: called.");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTap: called.");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTapEvent: called.");
        return false;
    }
}





















