package com.example.step08gameview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class BeerView extends View {
    Context context;
    int viewWidth,viewHeight;
    int centerX, centerY;
    int bottleW, bottleH;
    Bitmap bottleImg;
    int thisAngle;
    int angleSpeed;

    final int READY_STATE=0;
    final int ROTATE_STATE=1;

    int state=READY_STATE;

    int postX, postY;

    long postTime;

    boolean isTrick=false;

    Rect trickRect;

    int trickCount=0;


    public BeerView(Context context){
        super(context);
        this.context=context;
    }


    public BeerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        calcThisAngle();

        canvas.rotate(thisAngle, centerX, centerY);

        canvas.drawBitmap(bottleImg, centerX-bottleW, centerY-bottleH, null);
    }

    public void calcThisAngle(){
        if(state==READY_STATE)return;
        thisAngle = thisAngle+angleSpeed;
        if(angleSpeed==0){
            state=READY_STATE;
        }
        if(angleSpeed==38 && isTrick){
            thisAngle=10 + 90*trickCount;
            isTrick=false;
        }
        angleSpeed--;
    }


    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        viewWidth=w;
        viewHeight=h;
        init();
    }

    public void init(){

        centerX=viewWidth/2;
        centerY=viewHeight/2;
        bottleImg= BitmapFactory.decodeResource(getResources(), R.drawable.bottle);
        bottleW=bottleImg.getWidth()/2;
        bottleH=bottleImg.getHeight()/2;

        int line=viewWidth/4;

        trickRect=new Rect(0, 0, line, line);

        handler.sendEmptyMessageDelayed(0, 10);
    }

    public boolean onTouchEvent(android.view.MotionEvent event) {

        if(state==ROTATE_STATE){

            return true;
        }

        int eventX=(int)event.getX();
        int eventY=(int)event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(isTrick==false){

                    isTrick=trickRect.contains(eventX, eventY);
                    if(isTrick){
                        trickCount++;
                    }
                }

                postX=eventX;
                postY=eventY;

                postTime=System.currentTimeMillis();
                break;
            case MotionEvent.ACTION_UP:

                double d1=Math.sqrt(Math.pow(eventX-postX, 2)+Math.pow(eventY-postY, 2));

                long deltaT=System.currentTimeMillis()-postTime;

                double speedFinger=d1/deltaT;
                Toast.makeText(context, Double.toString(speedFinger), 0).show();

                angleSpeed=(int)(speedFinger*100);

                state=ROTATE_STATE;
                break;
        }
        return true;
    };


    Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            invalidate();
            handler.sendEmptyMessageDelayed(0, 10);
        }
    };
}
