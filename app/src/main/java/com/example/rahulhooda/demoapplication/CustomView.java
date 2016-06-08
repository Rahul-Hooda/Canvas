package com.example.rahulhooda.demoapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by rahul.hooda on 6/2/16.
 */
public class CustomView extends View {
    private Context context;
    private int w, h;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        getScreenResolution();

        PointF mPoint1 = new PointF(0,0);
        PointF mPoint2 = new PointF(w,100);
        PointF mPoint3 = new PointF(w,200);

        Path myPath1 = new Path();
        Paint paint  = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.RED);

        myPath1 = drawCurve(canvas, paint, mPoint1, mPoint2);
        canvas.drawPath(myPath1, paint);

        //fill color of top segment
        myPath1.lineTo(w,0);
        myPath1.lineTo(mPoint1.x,mPoint1.y);
        Paint red = new Paint();
        red.setColor(android.graphics.Color.RED);
        red.setStyle(Paint.Style.FILL);
        canvas.drawPath(myPath1,red);

        //fill color in bottom segment
        Path myPath2 = new Path();
        myPath2 = drawCurve(canvas, paint, mPoint1, mPoint3);
        canvas.drawPath(myPath2, paint);
        myPath2.lineTo(w,h);
        myPath2.lineTo(0,h);
        myPath2.lineTo(mPoint1.x,mPoint1.y);
        Paint Grey = new Paint();
        red.setColor(Color.DKGRAY);
        red.setStyle(Paint.Style.FILL);
        canvas.drawPath(myPath2,red);
    }

    private void getScreenResolution() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        w = metrics.widthPixels;
        h = metrics.heightPixels;

    }
    private Path drawCurve(Canvas canvas, Paint paint, PointF mPointa, PointF mPointb) {

        Path myPath = new Path();
        //myPath.moveTo(63*w/64, h/10);
        myPath.cubicTo(mPointa.x,mPointa.y,w/2,300,mPointb.x,mPointb.y);
        //myPath.quadTo(mPointa.x, mPointa.y, mPointb.x, mPointb.y);
        return myPath;
    }
}
