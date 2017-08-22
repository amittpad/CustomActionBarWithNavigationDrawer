package com.amittpad.info.nav;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Search extends AppCompatActivity {
    private EditText etSearchView;
    private ImageView backArrow,btnCancel;
    String contents="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initializeSearchView();
        setOnClickAction();
        cancelSetOnClickAction();
        searchActionListener();



    }
    private void initializeSearchView(){
        backArrow =(ImageView)findViewById(R.id.back_arrow);
        btnCancel = (ImageView) findViewById(R.id.btn_cancel);
        etSearchView = (EditText) findViewById(R.id.etSearchView);
        btnCancel.setVisibility(View.INVISIBLE);

    }
    private void setOnClickAction(){
        etSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearchView.setText("");
            }
        });
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void cancelSetOnClickAction(){
        etSearchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0){
                    btnCancel.setVisibility(View.VISIBLE);
                }
                else {
                    btnCancel.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etSearchView.setText("");
                    }
                });

            }
        });
    }
    private void searchActionListener(){
        etSearchView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    contents = etSearchView.getText().toString().trim();
                    if(contents.length() > 0){
                        //do search
                    }
                    else{
                        //if something to do for empty edittext
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /*@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                etSearchView.clearFocus();

            }
        });
    }*/

}
