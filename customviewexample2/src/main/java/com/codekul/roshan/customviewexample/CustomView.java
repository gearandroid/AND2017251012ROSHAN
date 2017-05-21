package com.codekul.roshan.customviewexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * Created by rtb on 21/5/17.
 */

public class CustomView extends AppCompatEditText{

    private Paint paint;

    public CustomView(Context context) {
        super(context);
        initpaint();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initpaint();
    }

    private void initpaint(){
        paint = new Paint();
        paint.setStrokeWidth(2.5f);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.YELLOW);
        canvas.drawLine(55,1,55,getHeight(),paint);
        canvas.drawLine(60,1,60,getHeight(),paint);

        canvas.drawLine(0,50,getWidth(),50,paint);
        canvas.drawLine(0,57,getWidth(),57,paint);

        canvas.drawLine(655,1,655,getHeight(),paint);
        canvas.drawLine(660,1,660,getHeight(),paint);

        //very imp line
        setGravity(Gravity.TOP | Gravity.LEFT);

        paint.setColor(Color.BLACK);
        for(int i=110;i<=getHeight();i += 40) {
            canvas.drawLine(60, i, 650, i, paint);
        }
    }
}
