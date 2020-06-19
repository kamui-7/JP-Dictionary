package com.example.dictionaryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WordDetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        String kanji = intent.getStringExtra("word");
        String reading = intent.getStringExtra("reading");
        String meaning = intent.getStringExtra("meaning");
        TextView wordTextView = findViewById(R.id.wordTextView);
        TextView meaningTextView = findViewById(R.id.meaningTextView);
        TextView readingTextView = findViewById(R.id.secondaryTextCard);
        toolbar.setTitle(kanji);
        readingTextView.setText(reading);
        wordTextView.setText(kanji);
        meaningTextView.setText(meaning);

        BottomNavigationView btmNavView = findViewById(R.id.bottom_navigation);
        btmNavView.setSelectedItemId(R.id.search_page);


        btmNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
//                    case R.id.word_page:
//                        Intent intent_word = new Intent(WordDetailActivity.this, WordsActivity.class);
//                        startActivity(intent_word);
//                        return true;
                    case R.id.setting_page:
                        Intent intent_settings = new Intent(WordDetailActivity.this, SettingsActivity.class);
                        startActivity(intent_settings);
                        return true;
                    case R.id.search_page:
                        Intent intent_search = new Intent(WordDetailActivity.this, MainActivity.class);
                        startActivity(intent_search);
                        return true;
                }
                return true;
            }
        });
    }



}