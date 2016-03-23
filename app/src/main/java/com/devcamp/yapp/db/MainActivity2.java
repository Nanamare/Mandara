package com.devcamp.yapp.db;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import uk.co.senab.photoview.PhotoViewAttacher;


public class MainActivity2 extends AppCompatActivity {

    Button btn;
    LinearLayout v;
    Bitmap b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        v = (LinearLayout) findViewById (R.id.Linear);
        v.setDrawingCacheEnabled(true);
        v.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        v.buildDrawingCache(true);
        b = Bitmap.createBitmap(v.getDrawingCache());
//                b = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        Intent it = new Intent(getApplicationContext(),NewActivity.class);
        it.putExtra("layout",byteArray);
        it.putExtra("myactivity","main");
        startActivity(it);
        finish();


    }

    public void OnClickEvent(View v){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
