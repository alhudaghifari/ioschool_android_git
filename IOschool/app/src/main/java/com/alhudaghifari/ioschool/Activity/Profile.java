package com.alhudaghifari.ioschool.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;
import com.alhudaghifari.ioschool.helper.ImageConverter;
import com.alhudaghifari.ioschool.helper.SQLiteHandler;
import com.alhudaghifari.ioschool.helper.SessionManager;

import java.util.HashMap;

/**
 * Created by Alhudaghifari on 9/3/2017.
 */

public class Profile extends AppCompatActivity {

    private ActionBar aksibar;

    private ImageView imageViewProfil;
    private ImageButton imgBtnSelectPhotoProfil;
    private ImageButton imgBtnLogout;

    private TextView txtNamaSiswa;
    private TextView txtNisn;
    private TextView txtKelas;
    private TextView txtAngkatan;
    private TextView txtNamaSekolah;
    private TextView txtUsername;
    private TextView txtTagNama;
    private TextView txtTagNisn;
    private TextView txtTagKelas;
    private TextView txtTagAngkatan;

    private SQLiteHandler db;

    private static final int PICK_IMAGE = 100;
    private Uri imageUri;

    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    private SessionManager session;

    // Shared preferences file name
    private static final String PREF_NAME = Constant.this_app;
    private static final String KEY_IS_PROFPIC_SELECTED = "isProfpicSelected";
    private static final String KEY_URI_IMAGE = "uriImage";

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this._context = Profile.this;
        pref = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        aksibar = Profile.this.getSupportActionBar();
        assert aksibar != null;
        aksibar.setDisplayHomeAsUpEnabled(true);
        aksibar.setHomeAsUpIndicator(R.drawable.file_button_back);
        aksibar.setTitle(R.string.profil);

        initializeView();
        initalizeListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                Profile.this.finish();
                return true;

            case R.id.action_setting:

                gotoSettingPage();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void gotoSettingPage() {
        Intent intentSetting = new Intent(Profile.this, SettingPage.class);
        intentSetting.putExtra(Constant.TAG_USERNAME,  username);

        Profile.this.startActivity(intentSetting);
    }

    private void initializeView() {
        imageViewProfil = (ImageView) findViewById(R.id.imgProfil);
        imgBtnSelectPhotoProfil = (ImageButton) findViewById(R.id.imgBtnProfil);
        imgBtnLogout = (ImageButton) findViewById(R.id.imgBtnLogout);

        txtNamaSiswa = (TextView) findViewById(R.id.txtNamaSiswa);
        txtNisn = (TextView) findViewById(R.id.txtNisn);
        txtKelas = (TextView) findViewById(R.id.txtKelas);
        txtAngkatan = (TextView) findViewById(R.id.txtAngkatan);
        txtNamaSekolah = (TextView) findViewById(R.id.txtNamaSekolah);
        txtUsername = (TextView) findViewById(R.id.txtUsername);

        txtTagNama = (TextView) findViewById(R.id.txtTagNama);
        txtTagNisn = (TextView) findViewById(R.id.txtTagNisn);
        txtTagKelas = (TextView) findViewById(R.id.txtTagKelas);
        txtTagAngkatan = (TextView) findViewById(R.id.txtTagAngkatan);


        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Raleway-Medium.ttf");
        Typeface custom_font_ArimaMadurai = Typeface.createFromAsset(getAssets(),  "fonts/ArimaMadurai-ExtraBold.ttf");
        txtNamaSiswa.setTypeface(custom_font);
        txtNisn.setTypeface(custom_font);
        txtKelas.setTypeface(custom_font);
        txtAngkatan.setTypeface(custom_font);
        txtNamaSekolah.setTypeface(custom_font_ArimaMadurai);
        txtUsername.setTypeface(custom_font);

        txtTagNama.setTypeface(custom_font);
        txtTagNisn.setTypeface(custom_font);
        txtTagKelas.setTypeface(custom_font);
        txtTagAngkatan.setTypeface(custom_font);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.icon_white_clicked_11);
        Bitmap circularBitmap = ImageConverter.getCircleImage(bitmap);
        imgBtnSelectPhotoProfil.setImageBitmap(circularBitmap);

        if (isProfPicSet()) {
            setProfPic();
        }

        setDataStudent();
    }

    private void initalizeListener() {
        imgBtnSelectPhotoProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        imgBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialogToLogout();
            }
        });
    }

    private void setDataStudent() {
        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());
        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetails();

        String nis = user.get("NIS");
        String namasiswa = user.get("Namalengkap");
        username = user.get("Username");
        String angkatan = user.get("Angkatan");
        String namasekolah = user.get("nama_sekolah");

        txtNisn.setText(nis);
        txtNamaSiswa.setText(namasiswa);
        txtUsername.setText("@" + username);
        txtAngkatan.setText(angkatan);
        txtNamaSekolah.setText(namasekolah);

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


    private void showConfirmationDialogToLogout() {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.logout_question)
                .setTitle(R.string.logout_title)
                .setPositiveButton(R.string.menu_logout, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Session manager
                        session = new SessionManager(getApplicationContext());
                        session.setLogin(false);

                        Intent intent = new Intent(Profile.this, LoginActivity.class);
                        startActivity(intent);
                        Profile.this.finish();

                        showToast(getResources().getString(R.string.sudah_logout));
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                });
        // Create the AlertDialog object and return it
        AlertDialog dialog = builder.create();
        dialog.show();
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
