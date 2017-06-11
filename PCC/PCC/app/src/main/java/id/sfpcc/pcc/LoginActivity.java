/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.sfpcc.pcc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import id.sfpcc.pcc.apihelper.BaseApiService;
import id.sfpcc.pcc.apihelper.UtilsApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    UtilsApi utilsApi;
    Button btnLogin;
    TextView btnRegister;
    EditText edEmai, edPassword;
    String email, password;
    ProgressDialog progressDialog;
    BaseApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        utilsApi = new UtilsApi(getApplicationContext());
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (TextView) findViewById(R.id.link_signup);
        edEmai = (EditText) findViewById(R.id.input_email);
        edPassword = (EditText) findViewById(R.id.input_password);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edEmai.getText().toString();
                password = edPassword.getText().toString();
                edEmai.setError(null);
                edPassword.setError(null);
                if (email.matches("")) {
                    edEmai.setError("Email masih kosong");
                } else if (password.matches("")) {
                    edPassword.setError("Password masih ksong");
                } else {
                    progressDialog = ProgressDialog.show(LoginActivity.this, null, "Loading", true, false);
                    RequestLogin();
                }
            }
        });
    }

    private void RequestLogin() {
        apiService = UtilsApi.getApiService();
        apiService.login(email, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    try {
                        JSONObject object = new JSONObject(response.body().string());
                        if (object.getString("sukses").equals("true")) {
                            JSONArray jsonArray = object.getJSONArray("user");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String mnama =  jsonObject.getString(utilsApi.NAMA_USER);
                                String memail = jsonObject.getString(utilsApi.EMAIL_USER);
                                String mpass = jsonObject.getString(utilsApi.PASS_USER);
                                String mno =jsonObject.getString(utilsApi.NO_USER);
                                String malamat = jsonObject.getString(utilsApi.ALAMAT_USER);
                                String mjabatan = jsonObject.getString(utilsApi.JABATAN_USER);
                                utilsApi.CreateLoginSession(mnama, memail, mpass, mno, malamat, mjabatan);
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        } else {
                            String error = object.getString("pesan");
                            Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("error", t.toString());
                progressDialog.dismiss();
            }
        });

    }
}
