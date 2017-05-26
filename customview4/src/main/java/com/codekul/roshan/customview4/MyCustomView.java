package com.codekul.roshan.customview4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by rtb on 26/5/17.
 */

public class MyCustomView extends AppCompatEditText {

    private Paint paint;
    AppCompatEditText Edittext;

    public MyCustomView(Context context) {
        super(context);
        initpaint();
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initpaint();
    }



    private void initpaint(){
        paint=new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(2.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawRect(100,100,300,300,paint);

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(400,400,50,paint);

        paint.setColor(Color.BLACK);
        canvas.drawLine(400,400,600,600,paint);

        for(int i=600;i>=200;i-=20){
            canvas.drawLine(400,400,i,200,paint);
        }
    }


}
