package com.devcamp.yapp.db;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import uk.co.senab.photoview.PhotoViewAttacher;

public class NewActivity extends AppCompatActivity {
    ImageView mImageView;
    PhotoViewAttacher mAttacher;
    LinearLayout view;
    ImageView bmImage;
    ImageButton inputpc;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        inputpc = (ImageButton) findViewById(R.id.inputbutton);
        //더보기 삭제
 //       View actionbutton = getLayoutInflater().inflate(R.layout.actionbutton, null);
 //       ActionBar ab = getSupportActionBar();
 //       ab.setCustomView(actionbutton);
  //      ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_SHOW_CUSTOM);
        view = (LinearLayout) findViewById(R.id.abcdefg);


//        view = (LinearLayout) findViewById(R.id.linearLayout);


//        view.setDrawingCacheEnabled(true);
//        // this is the important code :)
//        // Without it the view will have a dimension of 0,0 and the bitmap will be null
//
//        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//
//        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
//
//        view.buildDrawingCache(true);
//        Bitmap b = Bitmap.createBitmap(view.getDrawingCache());
//
//        // Any implementation of ImageView can be used!
        mImageView = (ImageView) findViewById(R.id.image1);
        Intent intent = getIntent();
        if (intent.getStringExtra("myactivity").equals("main")) {
            byte[] arr = getIntent().getByteArrayExtra("layout");
            Bitmap bitmap = BitmapFactory.decodeByteArray(arr, 0, arr.length);
            // Set the Drawable displayed
            Drawable bitmap2 = getDrawableFromBitmap(bitmap);
            mImageView.setImageDrawable(bitmap2);
            bmImage = (ImageView) findViewById(R.id.image2);
            bmImage.setImageBitmap(bitmap);
            // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
            mAttacher = new PhotoViewAttacher(mImageView);
//            mAttacher.update();
        }

        //       view.setDrawingCacheEnabled(false); // clear drawing cache

        //       bmImage.setImageBitmap(b);

        inputpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "짧게 누름", Toast.LENGTH_LONG).show();


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment newFragment = new NewActivityFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();


                transaction.replace(R.id.abcdefg, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                //          NewActivityFragment fragment = (NewActivityFragment) getFragmentManager().findFragmentById(R.id.inputbutton);
            }
        });

        inputpc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "길게 누름", Toast.LENGTH_LONG).show();


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment newFragment = new NewActivityFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment ab = new NewActivityFragment();
                transaction.replace(R.id.abcdefg, ab);

                //transaction.hide(newFragment);
//                transaction.remove(newFragment);
                transaction.commit();
                //          NewActivityFragment fragment = (NewActivityFragment) getFragmentManager().findFragmentById(R.id.inputbutton);
                return false;
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


    }

    public Drawable getDrawableFromBitmap(Bitmap bitmap) {
        Drawable d = new BitmapDrawable(bitmap);
        return d;
    }


    public void onBtnClicked(View v) {
        Button ll = (Button) findViewById(R.id.actionbutton);
        ll.setBackgroundColor(Color.GREEN);
        //여기 삽입했다
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        Fragment newFragment = new NewActivityFragment_2();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//
//        transaction.replace(R.id.morebutton, newFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();

    }
    //8시17분 추가


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.moreview, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.morebutton) {
            Toast.makeText(getApplicationContext(), "세팅 클릭", Toast.LENGTH_LONG).show();

            return true;
        }
        if (id == R.id.morebutton2) {
            Toast.makeText(getApplicationContext(), "세팅 클릭2", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);



            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void OnPicClick(View v) {
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);

            }


        });
    }

    public void basicOnClicked(View v) {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });

    }

    final int REQ_CODE_SELECT_IMAGE = 100;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        Toast.makeText(getBaseContext(), "resultCode : " + resultCode, Toast.LENGTH_SHORT).show();

        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                try {

                    //String name_Str = getImageNameToUri(data.getData());


                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    LinearLayout image = (LinearLayout) findViewById(R.id.iv);
                    Drawable ab = getDrawableFromBitmap(image_bitmap);

//                    image.setImageBitmap(image_bitmap);
                    image.setBackground(ab);

                    //Toast.makeText(getBaseContext(), "name_Str : "+name_Str , Toast.LENGTH_SHORT).show();


                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "New Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.devcamp.yapp.db/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "New Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.devcamp.yapp.db/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}


//// Any implementation of ImageView can be used!
//mImageView = (ImageView) findViewById(R.id.image1);
//
//        // Set the Drawable displayed
//        Drawable bitmap = getResources().getDrawable(R.drawable.wallpaper);
//        mImageView.setImageDrawable(bitmap);
//
//        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
//        mAttacher = new PhotoViewAttacher(mImageView);
//


////        mImageView = (ImageView) findViewById(R.id.image1);
//view.setDrawingCacheEnabled(true);
//        view.buildDrawingCache();
//        //       Bitmap bitmap = view.getDrawingCache();
////        Bitmap bitmap2 = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
////view.getWidth()
//        //view.getHeight()
////       Canvas canvas = new Canvas(bitmap2);
////       view.draw(canvas);
////        Drawable bitmap = getResources().getDrawable(R.drawable.web_3067300805_4ff350f2);
////        Drawable bitmap3 = getDrawableFromBitmap(bitmap);
////        mImageView.setImageDrawable(bitmap2);
////        mAttacher = new PhotoViewAttacher(mImageView);
//
////         Any implementation of ImageView can be used!
//        mImageView = (ImageView) findViewById(R.id.image1);
//        Drawable bitmap = getResources().getDrawable(R.mipmap.ic_launcher);
////        Drawable bitmap2 = getDrawableFromBitmap(bitmap);
//        mImageView.setImageDrawable(bitmap);
//        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
//        mAttacher = new PhotoViewAttacher(mImageView);
//        mAttacher.update();
////        view.draw(canvas);
////        view.setDrawingCacheEnabled(true);
////        view.buildDrawingCache();
////        Bitmap bm = view.getDrawingCache();
