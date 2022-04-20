package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_id; //객체선언
    private EditText et_pw; //객체선언
    private Button btn_login; //객체선언
    private String ID = "ABC";
    private String PW = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();//호출
        initListener();//호출
    }

    private void init(){
        et_id = findViewById(R.id.et_id); //아이디속성을 가져와서 객체에 넣어줌,선언
        et_pw = findViewById(R.id.et_pw); //아이디속성을 가져와서 객체에 넣어줌,선언
        btn_login = findViewById(R.id.btn_login); //아이디속성을 가져와서 객체에 넣어줌,선언
    }
    private void initListener(){
        btn_login.setOnClickListener(new View.OnClickListener() {  // 인터페이스
            @Override
            public void onClick(View view) {//인터페이스 구현
                checkLoginInfo();
            }
        });

    }

    //아이디 비밀번호를 확인해서 화면전환,실패메세지를 띄운다.
    private void checkLoginInfo(){
        String id = et_id.getText().toString(); //editText에 들어있는 텍스트를 가져와서 문자열로 변환. 오브젝트를 문자열
        String pw = et_pw.getText().toString(); //editText에 들어있는 텍스트를 가져와서 문자열로 변환. 오브젝트를 문자열

        if(id.equals(ID) && pw.equals(PW)){
            Toast.makeText(this,"로그인 성공했습니다.",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"로그인 실패했습니다.",Toast.LENGTH_SHORT).show();
        }

    }


    // 해야될것/*
    // 1. 아무것도(아이디,비밀번호) 안쳤을때 문구뜨게*/
    // 2. 키보드내리기 , 함수새로 만들기
    // 3. 비밀번호가 8자 미만 실패 "8자리 미만입니다" pw.length 글자수를 가져옴


}