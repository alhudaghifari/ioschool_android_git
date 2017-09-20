package com.alhudaghifari.ioschool.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;
import com.alhudaghifari.ioschool.app.AppConfig;
import com.alhudaghifari.ioschool.app.AppController;
import com.alhudaghifari.ioschool.helper.SessionManager;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class SettingPage extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private ActionBar aksibar;
    private ProgressDialog pDialog;

    private EditText editTextUsername;
    private EditText editTextPwdLama;
    private EditText editTextPwdBaru;
    private EditText editTextPwdKonfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);

        aksibar = SettingPage.this.getSupportActionBar();
        assert aksibar != null;
        aksibar.setDisplayHomeAsUpEnabled(true);
        aksibar.setHomeAsUpIndicator(R.drawable.file_button_back);
        aksibar.setTitle(R.string.setting);

        initializeView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting_profil, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                SettingPage.this.finish();
                return true;

            case R.id.action_change_password:
                showToast("Password Changed");
//                showConfirmationChangePwd();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeView() {
        editTextUsername = (EditText) findViewById(R.id.txtUsername);
        editTextPwdLama = (EditText) findViewById(R.id.txtOldPassword);
        editTextPwdBaru = (EditText) findViewById(R.id.txtNewPassword);
        editTextPwdKonfirm = (EditText) findViewById(R.id.txtConfirmPassword);

        Bundle bundeldata = SettingPage.this.getIntent().getExtras();
        String username = bundeldata.getString(Constant.TAG_USERNAME);

        editTextUsername.setText(username);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
    }

    private void showConfirmationChangePwd() {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.text_ubahpwd)
                .setTitle(R.string.judul_ubahpwd)
                .setPositiveButton(R.string.ubah, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String usrnm = editTextUsername.getText().toString().trim();
                        String pwdlm = editTextPwdLama.getText().toString().trim();
                        String pwdbr = editTextPwdBaru.getText().toString().trim();
                        String pwdknfrm = editTextPwdKonfirm.getText().toString().trim();

                        if (pwdbr.equals(pwdknfrm)) {
                            changePassword(usrnm, pwdlm, pwdknfrm);
                        } else {
                            showToast(getResources().getString(R.string.false_pwd_konfirm));
                        }
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

    /**
     * function to verify login details in mysql db
     * */
    private void changePassword(final String usernameku, final String Oldpassword,
                                final String Newpassword) {
        // Tag used to cancel the request
        String tag_string_req = "req_pwd";

        pDialog.setMessage("Sedang mengubah password ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_UBAH_PWD, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Change Password response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        String msg = jObj.getString("msg");
                        showToast(msg);

                        // Launch main to profile
                        Intent intent = new Intent(SettingPage.this,
                                Profile.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {

                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                String oldPwd = md5(Oldpassword);
                String oldPwd1 = md5(oldPwd);
                String newPwd = md5(Newpassword);
                String newPwd1 = md5(newPwd);

                params.put("Username", usernameku);
                params.put("OldPassword", oldPwd1);
                params.put("NewPassword", newPwd1);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    /**
     * method ini untuk menampilkan toast agar pemanggilan lebih sederhana
     * @param s pesan
     */
    private void showToast(String s) {
        Toast.makeText(SettingPage.this,s,Toast.LENGTH_LONG).show();
    }
}
