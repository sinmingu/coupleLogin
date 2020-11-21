package com.mglj.couplelogin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

class ScratchView extends View{
    private int radius=60;
    private int pixelArray[];
    private int currentPixelArray[];

    private Bitmap currentBitmap;
    private Bitmap newBitmap;
    private Bitmap maskBitmap;
    private Paint  currentBitmapPaint;

    int LottoImage[] ={R.drawable.tto1,R.drawable.tto2,R.drawable.tto3,R.drawable.tto4,R.drawable.tto5,R.drawable.tto6,R.drawable.tto7,R.drawable.tto8,R.drawable.tto9,R.drawable.tto10,
            R.drawable.tto11,R.drawable.tto12,R.drawable.tto13,R.drawable.tto14,R.drawable.tto15,R.drawable.tto16,R.drawable.tto17,R.drawable.tto18,R.drawable.tto19,R.drawable.tto20,
            R.drawable.tto21,R.drawable.tto22,R.drawable.tto23,R.drawable.tto24,R.drawable.tto25,R.drawable.tto26,R.drawable.tto27,R.drawable.tto28,R.drawable.tto29,R.drawable.tto30,
            R.drawable.tto31,R.drawable.tto32,R.drawable.tto33,R.drawable.tto34,R.drawable.tto35,R.drawable.tto36,R.drawable.tto37,R.drawable.tto38,R.drawable.tto39,R.drawable.tto40,
            R.drawable.tto41,R.drawable.tto42,R.drawable.tto43,R.drawable.tto44,R.drawable.tto45,R.drawable.tto46,R.drawable.tto47,R.drawable.tto48,R.drawable.tto49,R.drawable.tto50,
            R.drawable.tto51,R.drawable.tto52,R.drawable.tto53,R.drawable.tto54,R.drawable.tto55,R.drawable.tto56,R.drawable.tto57,R.drawable.tto58,R.drawable.tto59,R.drawable.tto60,
            R.drawable.tto61,R.drawable.tto62,R.drawable.tto63,R.drawable.tto64,R.drawable.tto65,R.drawable.tto66,R.drawable.tto67,R.drawable.tto68,R.drawable.tto69,R.drawable.tto70,
            R.drawable.tto71,R.drawable.tto72,R.drawable.tto73,R.drawable.tto74,R.drawable.tto75,R.drawable.tto76,R.drawable.tto77,R.drawable.tto78,R.drawable.tto79,R.drawable.tto80};

    private boolean isFirst;

    public ScratchView(Context context) {
        super(context);
        pixelArray = new int[radius * radius];
        currentPixelArray = new int[radius * radius];
        isFirst = true;
    }


    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if(isFirst)
            initSource();
    }


    public void initSource() {
        isFirst = false;

        int w = getWidth();
        int h = getHeight();

        Options opts = new Options();
        opts.inPurgeable = true;

        //랜덤함수 생성
        Random random = new Random();
        int rand = random.nextInt(80)+1;

        Bitmap temp = BitmapFactory.decodeResource(getResources(), R.drawable.lotto_off, opts);
        currentBitmap = Bitmap.createScaledBitmap(temp, w, h, true);

        temp = BitmapFactory.decodeResource(getResources(), LottoImage[rand], opts);
        newBitmap = Bitmap.createScaledBitmap(temp, w, h, true);

        Paint p = new Paint();
        p.setStyle(Style.FILL);
        p.setColor(Color.BLACK);

        maskBitmap = Bitmap.createBitmap(radius, radius, Config.ARGB_8888);
        Canvas c = new Canvas(maskBitmap);

        c.drawRect(0, 0, radius, radius, p);
        p.setColor(Color.WHITE);
        c.drawCircle(radius/2, radius/2, radius/2, p);

        currentBitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private void scratchBitmap(float x, float y) {
        newBitmap.getPixels(pixelArray, 0, radius, (int)x-radius/2, (int)y-radius/2, radius, radius);
        currentBitmap.getPixels(currentPixelArray, 0, radius, (int)x-radius/2, (int)y-radius/2, radius, radius);

        setRoundArea();

        currentBitmap.setPixels(pixelArray, 0, radius, (int)x-radius/2, (int)y-radius/2, radius, radius);
        invalidate();
    }

    private void setRoundArea() {
        for(int i=0; i<pixelArray.length; i++) {
            int maskColor = maskBitmap.getPixel(i%radius, i/radius);
            if(maskColor == Color.BLACK) {
                pixelArray[i] = currentPixelArray[i];
            }
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        try {
            canvas.drawBitmap(currentBitmap, 0, 0, currentBitmapPaint);
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
            return true;
        else if(event.getAction() == MotionEvent.ACTION_MOVE) {
            float x = event.getX();
            float y = event.getY();


            if(x < radius/2) x = radius/2;
            else if(x > getWidth()-radius/2) x= getWidth()-radius/2;

            if(y < radius/2) y = radius/2;
            else if(y > getHeight()-radius/2) y = getHeight()-radius/2;

            scratchBitmap(x, y);
        }
        return super.onTouchEvent(event);
    }
}