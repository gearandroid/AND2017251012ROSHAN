package com.codekul.roshan.customviewsdemo1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by rtb on 18/5/17.
 */
//1..Create a new Package
    //2..create a vclass inside it
    //3..Extend View class to this class and activate the constructors
    //4..put init() individual with @Nullable AttributeSet set
    // and inside all constructors with attribute as attr(visible there)
    //5..in java file, call onDraw(Canvas canvas) creating object of Canvas Class
    //6..In xml file you can make tag for this Canvas Class
    //7..to make changes in this Custom view, make changes accordingly in onDraw()
public class CustomView extends View {
    private static final int RECT_LEN = 100;
    private static final int RECT_BREADTH = 90;

    private Rect mRect;
    private Paint mPaint;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

        mRect=new Rect();
        mPaint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.YELLOW);

        mRect.left=10;
        mRect.top=10;
        mRect.right=mRect.left+RECT_LEN;
        mRect.bottom=mRect.top+RECT_BREADTH;

        mPaint.setColor(Color.MAGENTA);

        canvas.drawRect(mRect,mPaint);
    }
}
