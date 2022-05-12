package com.example.myapplication;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText et_id; //객체선언
    private EditText et_pw; //객체선언
    private Button btn_login; //객체선언
    private String ID = "ABC";
    private String PW = "12341234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();//호출
        initListener();//호출
        dispatchTouchEvent();// edittext 이외의 것을 터치할때 키보드창 사라지게하는 함수 호출
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
    private void dispatchTouchEvent() {
    }


    //edittext 이외의 배경 터치시 로그인창이 사라진다.
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View focusView = getCurrentFocus();
        if (focusView != null) {
            Rect rect = new Rect();
            focusView.getGlobalVisibleRect(rect);
            int x = (int) ev.getX(), y = (int) ev.getY();
            if (!rect.contains(x, y)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
                focusView.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }




    //아이디 비밀번호를 확인해서 화면전환,실패메세지를 띄운다.
    private void checkLoginInfo(){
        String id = et_id.getText().toString(); //editText에 들어있는 텍스트를 가져와서 문자열로 변환. 오브젝트를 문자열
        String pw = et_pw.getText().toString(); //editText에 들어있는 텍스트를 가져와서 문자열로 변환. 오브젝트를 문자열

        if(id.length() == 0){  //아이디 따로 //STRING 파일에서 가져옴 (R.string.id_empty)
            Toast.makeText(this,R.string.id_empty,Toast.LENGTH_SHORT).show();
        }
        else if(pw.length() == 0){  //비밀번호 따로
            Toast.makeText(this,R.string.login_fail,Toast.LENGTH_SHORT).show();
        }
        else if(pw.length()<8){
            Toast.makeText(this,R.string.pw_length,Toast.LENGTH_SHORT).show();
        }
        else if(!id.equals(ID) || !pw.equals(PW)){ //not !붙임(eq
            Toast.makeText(this,R.string.login_fail,Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,R.string.login_success,Toast.LENGTH_SHORT).show();
            goToMain();
        }//아이디나 비밀번호가 둘중하나 틀리면 '로그인 실패'
    }

    public void goToMain() {
        Intent intent = new Intent(this, MainActivity.class); //현재 엑티비티 컨테스트 가져올수 있음.
        startActivity(intent);
    }



    //https://shmg92.atlassian.net/wiki/spaces/ANIMALCARE/pages/7471164/Intent



    // 해야될것/*
    // 1. 아무것도(아이디,비밀번호) 안쳤을때 문구뜨게*/
    // 2. 키보드내리기 , 함수새로 만들기
    // 3. 비밀번호가 8자 미만 실패 "8자리 미만입니다" pw.length 글자수를 가져옴

    // 해야될것2 (22.04.26)
    // 1. 화면 전환하는데 입력한 아이디값 넘기기 -> 메인화면에서 "xxx"님 환영합니다. (메인화면 중간 텍스트뷰)
    // 2. 메인화면에서 채팅방 버튼 만들어서 화면 전환하기 -> ChatActivity 전환하기

    //ctrl + shift + f = 프로젝트내 전체검사

    //fast campus
}
