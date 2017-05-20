package com.codekul.roshan.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by rtb on 19/5/17.
 */

//extend (typecasted AppCompat) children control classes..
public class MyView extends AppCompatEditText {

    private Paint paint; //keep one Paint class reference always
    AppCompatEditText edtText;

    //add constructors
    public MyView(Context context) {
        super(context); //generated java code
        initPaint();

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs); //generated java code
        initPaint();
    }

    private void initPaint(){
        paint = new Paint();
        paint.setStrokeWidth(3f);
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawCircle(200,200,100,paint);

        for (int i = 1; i <= getHeight(); i += 70) {
            canvas.drawLine(10, i, 800, i, paint);
        }

        canvas.drawLine(150,1,150,getHeight(),paint);
    }
}
