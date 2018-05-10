package io.github.tlaabs.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawClass(this));
    }


    class DrawClass extends View {
        Path path;
        Paint mPaint;
        float prePosX, prePosY; //save pre mouse position

        public DrawClass(Context context){
            super(context);
            path = new Path();
            mPaint = new Paint();

            //setting paint option
            mPaint.setColor(Color.BLUE);
            mPaint.setStrokeWidth(15);
            mPaint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            canvas.drawPath(path,mPaint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    prePosX = x;
                    prePosY = y;
                    break;
                case MotionEvent.ACTION_MOVE:
                    path.moveTo(prePosX,prePosY);
                    path.lineTo(x,y);
                    prePosX =x;
                    prePosY =y;
                    break;

                case MotionEvent.ACTION_UP:
                    break;

            }
            //redraw
            invalidate();

            return true;
        }
    }
}
