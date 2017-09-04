package com.alhudaghifari.ioschool.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;
import com.alhudaghifari.ioschool.helper.ImageConverter;

/**
 * Created by Alhudaghifari on 9/3/2017.
 */

public class Profile extends AppCompatActivity {

    private ImageView imageViewProfil;
    private ImageButton imgBtnSelectPhotoProfil;

    private static final int PICK_IMAGE = 100;
    private Uri imageUri;

    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // Shared preferences file name
    private static final String PREF_NAME = Constant.this_app;
    private static final String KEY_IS_PROFPIC_SELECTED = "isProfpicSelected";
    private static final String KEY_URI_IMAGE = "uriImage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this._context = Profile.this;
        pref = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        initializeView();
        initalizeListener();

    }

    private void initializeView() {
        imageViewProfil = (ImageView) findViewById(R.id.imgProfil);
        imgBtnSelectPhotoProfil = (ImageButton) findViewById(R.id.imgBtnProfil);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.icon_white_3);
        Bitmap circularBitmap = ImageConverter.getCircleImage(bitmap);
        imgBtnSelectPhotoProfil.setImageBitmap(circularBitmap);

        if (isProfPicSet()) {
            setProfPic();
        }
    }

    private void initalizeListener() {
        imgBtnSelectPhotoProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void setProfPic() {
        String imgUriString = pref.getString(KEY_URI_IMAGE,null);
        imageUri = Uri.parse(imgUriString);
        imageViewProfil.setImageURI(imageUri);
        if (imageViewProfil.getDrawable() == null) {
            showToast("image ga ada");
            imageViewProfil.setImageResource(R.mipmap.ic_launcher);
        }
    }

    private boolean isProfPicSet() {
        return pref.getBoolean(KEY_IS_PROFPIC_SELECTED, false);
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageViewProfil.setImageURI(imageUri);

            Log.d(KEY_URI_IMAGE,": " + imageUri.toString());

            editor = pref.edit();
            editor.putString(KEY_URI_IMAGE, imageUri.toString());
            editor.putBoolean(KEY_IS_PROFPIC_SELECTED, true);
            editor.commit();
        }
    }

    /**
     * method ini untuk menampilkan toast agar pemanggilan lebih sederhana
     * @param s pesan
     */
    private void showToast(String s) {
        Toast.makeText(Profile.this,s,Toast.LENGTH_LONG).show();
    }

}
