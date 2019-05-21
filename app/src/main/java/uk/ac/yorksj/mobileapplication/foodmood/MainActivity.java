package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements OnClickListener {

        TextView t;
        private static final String KEY_STATUS = "status";
        private static final String KEY_MESSAGE = "message";        // need to add name category
        private static final String KEY_EMAIL = "email";
        private static final String KEY_USERNAME = "username";
        private static final String KEY_PASSWORD = "password";
        private static final String KEY_EMPTY = "";
        private EditText etUsername;
        private EditText etPassword;
        private String username;
        private String password;
        private ProgressDialog pDialog;
        private String login_url = "cs2s.yorkdc.net/8888/api/member/login.php"; // edit to change cs2s url
        private SessionHandler session;
        @Override

    public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            t = (TextView)findViewById(R.id.textView3);
            t.setOnClickListener(this);

            super.onCreate(savedInstanceState);
            session = new SessionHandler(getApplicationContext());

            if (session.isLoggedIn()){
                loadHome();
            }
            setContentView(R.layout.activity_main);

            etUsername = findViewById(R.id.etLoginUsername);
            etPassword = findViewById(R.id.etLoginPassword);

            Button login = findViewById(findViewById(R.id.button));

            login.setOnClickListener(new View.OnClickListener() {
                @Override

        public void onClick(View v) {

            username = etUsername.getText().toString().toLowerCase().trim();
            password = etPassword.getText().toString().trim();

            if (validateInputs)) {
                    login();
                    }
                }
            });
        }

    private void loadHome() {
            Intent i = new Intent(getApplicationContext(), homeActivity.class);
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Logging In.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    private void login() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            request.put(KEY_USERNAME, username);
            request.put(KEY_PASSWORD, password);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, login_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();
                        try {

                            if (response.getInt(KEY_STATUS) == 0) {
                                session.loginUser(username,response.getString(KEY_EMAIL));
                                loadHome();

                            }else{
                                Toast.makeText(getApplicationContext(),
                                        response.getString(KEY_MESSAGE), Toast.LENGTH_SHORT).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();

                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
        }

    private boolean validateInputs() {
            if(KEY_EMPTY.equals(username)){
                etUsername.setError("Username cannot be empty");
                etUsername.requestFocus();
                return false;
            }
    if (KEY_EMPTY.equals(password)){
        etPassword.setError("Password cannot be empty");
        etPassword.requestFocus();
        return false;
    }

        return true;

    }

    public void onClick(View arg0) {
        Intent myintent = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(myintent);
        }
    }

