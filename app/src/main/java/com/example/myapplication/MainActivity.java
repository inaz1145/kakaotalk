package com.example.myapplication;

//프로젝트 업데이트 -> add(올라간게 아님) -> commit(여기까지 취소가됨) -> push(서버에 올라감,취소는 할수 있으나 불편함)

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button imageButton = (Button) findViewById(R.id.btn_activity);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
            startActivity(intent);
            }
        });

        ArrayList<String> arr = new ArrayList<>();


    }

}