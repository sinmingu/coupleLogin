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

class ScratchView extends View{
    private int radius=60;
    private int pixelArray[];
    private int currentPixelArray[];

    private Bitmap currentBitmap;
    private Bitmap newBitmap;
    private Bitmap maskBitmap;
    private Paint  currentBitmapPaint;

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


        Bitmap temp = BitmapFactory.decodeResource(getResources(), R.drawable.lotto_off, opts);
        currentBitmap = Bitmap.createScaledBitmap(temp, w, h, true);


        temp = BitmapFactory.decodeResource(getResources(), R.drawable.lotto_on, opts);
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