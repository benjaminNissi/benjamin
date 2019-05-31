package com.example.realm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.realm.model.Modelclass;

import io.realm.Realm;
import io.realm.RealmResults;

import com.example.realm.model.Modelclass;

import io.realm.Realm;
import io.realm.RealmResults;
public class User_Registration extends AppCompatActivity {
    private static final String TAG="User_Registration";
    EditText Username;
    EditText Password;
    Button Register;
    TextView display;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__registration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        Register = (Button) findViewById(R.id.Register);
        display = (TextView) findViewById(R.id.display);
        Register.setOnClickListener((View.OnClickListener) this);
        Log.d(TAG, "onCreate:View initialazation dane");
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          regesterdata();
          readdata();
            }
        });
    }
 private void regesterdata() {
                    realm.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm bgRealm) {
                            Modelclass user = bgRealm.createObject(Modelclass.class);
                            user.setUsername(Username.getText().toString().trim());
                            user.setPassword(Integer.parseInt(Password.getText().toString().trim()));
                        }
                    }, new Realm.Transaction.OnSuccess() {
                        @Override
                        public void onSuccess() {
                            // Transaction was a success.
                            Log.d(TAG, "on success:data store successfully");
                        }
                    }, new Realm.Transaction.OnError() {
                        @Override
                        public void onError(Throwable error) {
                            // Transaction failed and was automatically canceled.
                            Log.d(TAG, "on success :data is not store");
                        }
                    });
                }
                private void readdata() {
                    RealmResults<Modelclass> Modelclass = realm.where(Modelclass.class).findAll();
                    display.setText("");
                    String data = "";
                    for (Modelclass User: Modelclass) {
                        try {
                            Log.d(TAG, "insect data");
                            data = data + "\n" + Modelclass.toString();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
        display.setText(data);
                }

    @Override
    prote