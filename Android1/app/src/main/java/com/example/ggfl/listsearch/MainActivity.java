package com.example.ggfl.listsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<RecyclerListItem> itemList;

    private Button button;
    private EditText editText;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();
        fillList();

        recyclerView = findViewById(R.id.recycler_list);
        myAdapter = new MyAdapter(this, itemList);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);

        button = findViewById(R.id.search_button);
        button.setOnClickListener(this);
        editText = findViewById(R.id.search_bar);
    }

    private void fillList() {
        RecyclerListItem r1  = new RecyclerListItem("Check this out", 0, "New offers from amazon to you");
        RecyclerListItem r3  = new RecyclerListItem("Check this out", 0, "New offers from amazon to you");
        RecyclerListItem r4  = new RecyclerListItem("Check this out", 0, "New offers from amazon to you");
        RecyclerListItem r2  = new RecyclerListItem("Check this out", 0, "New offers from amazon to you");
        RecyclerListItem r6  = new RecyclerListItem("Check this out", 0, "New offers from amazon to you");
        RecyclerListItem r5  = new RecyclerListItem("Check this out", 0, "New offers from amazon to you");
        RecyclerListItem r7  = new RecyclerListItem("You woudn't believe", 0, "I'm the different one!");

        this.itemList.add(r1);
        this.itemList.add(r2);
        this.itemList.add(r3);
        this.itemList.add(r4);
        this.itemList.add(r5);
        this.itemList.add(r6);
        this.itemList.add(r7);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_button:
                input = editText.getText().toString();
                this.myAdapter.filter(input);
                break;
        }
    }
}
