package com.google.qlthuoctay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ThuocTayAdapter adapter;
    List<ThuocTay> thuocTayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        BatSuKien();
    }

    public void AnhXa(){
        recyclerView = findViewById(R.id.rcv_thuoctay);
        LinearLayoutManager manager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        thuocTayList = new ArrayList<>();
        adapter = new ThuocTayAdapter(thuocTayList);

        recyclerView.setAdapter(adapter);
    }

    public void BatSuKien(){
        getListUserFromRealtimeDatabase();
    }

    public void onClickAdduser(ThuocTay thuocTay){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("list-user");

        String pathObject = String.valueOf(thuocTay.getTen());
        myref.child(pathObject).setValue(thuocTay);
    }

    public void getListUserFromRealtimeDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("list-thuoctay");

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ThuocTay thuocTay = dataSnapshot.getValue(ThuocTay.class);
                    thuocTayList.add(thuocTay);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}