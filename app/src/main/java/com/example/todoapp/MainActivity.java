package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mShowDialog = (Button) findViewById(R.id.btnShowDialog);
        mShowDialog.setOnClickListener(view -> {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
            final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
            final EditText mPassword = (EditText) mView.findViewById(R.id.etPassword);
            Button mLogin = (Button) mView.findViewById(R.id.btnLogin);

            mLogin.setOnClickListener(view1 -> {
                if (!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.success_login_msg, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, R.string.error_login_msg, Toast.LENGTH_SHORT).show();
                }
            });

            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();

            Button mDissmiss= (Button) mView.findViewById(R.id.btnDissmiss);

            mDissmiss.setOnClickListener(view12 -> dialog.dismiss());

        });

        Button btn = findViewById(R.id.btn);
        registerForContextMenu(btn);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "Liste de tâches");
        menu.add(0, v.getId(), 0, "Nombres totale");
        menu.add(0, v.getId(), 0, "plus ...");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem  item) {
        if (item.getTitle() == "Liste de tâches"){
            Intent in = new Intent(MainActivity.this,ListeTache.class);
            startActivity(in);
        }else if (item.getTitle() == "Nombres totale") {
            Toast.makeText(MainActivity.this, "0 Rien", Toast.LENGTH_LONG).show();
        }else if (item.getTitle() == "plus ..."){
            Uri webpage = Uri.parse("www.google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            else {
                Log.d("ImplicitIntents","can't handle this intent !") ;
            }

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu,menu);
        return true;
    }


    public boolean onOptionItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "You have selected item 1 ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "You have selected item 2 ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "You have selected item 2.1 ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item4:
                Toast.makeText(this, "You have selected item 2.2 ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item5:
                Toast.makeText(this, "You have selected item 3 ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item6:
                Toast.makeText(this, "You have selected item 4 ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item7:
                Toast.makeText(this, "You have selected item 4.1 ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item8:
                Toast.makeText(this, "You have selected item 4.2 ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item9:
                Toast.makeText(this, "You have selected item 5.1 ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item10:
                Toast.makeText(this, "You have selected item 5.2 ", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}