package us.mifeng.rippledrawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn06);
        RippleDrawable drawable = new RippleDrawable(
                ColorStateList.valueOf(Color.GRAY),
                ContextCompat.getDrawable(this,R.mipmap.ic_launcher),
                getShapeDrawable()
        );
        btn.setBackground(drawable);
    }
    //自己绘画Drawable图形
    private ShapeDrawable getShapeDrawable(){
        ShapeDrawable drawable = new ShapeDrawable(new Shape() {
           //在此你可以绘画各种好玩的三角形
            @Override
            public void draw(Canvas canvas, Paint paint) {
                paint.setColor(Color.GRAY);
                int width = (int) this.getWidth();
                int height = (int) this.getHeight();
                Path path = new Path();
                path.moveTo(width/2,0);
                path.lineTo(0,height);
                path.lineTo(width,height);
                canvas.drawPath(path,paint);
            }
        });
        return drawable;
    }

}
