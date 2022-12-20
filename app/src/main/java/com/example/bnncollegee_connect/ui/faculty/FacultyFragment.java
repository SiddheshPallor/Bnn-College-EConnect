package com.example.bnncollegee_connect.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bnncollegee_connect.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView artsDepartment, scienceDepartment, commerceDepartment, selfFinanceDepartment, ruralDevelopment;
    private LinearLayout artsNoData, scienceNoData, commerceNoData, selfFinanceNoData, ruralNoData;
    private List<TeachersData> list1, list2, list5, list4, list3;
    private DatabaseReference reference, dbRef;
    private TeacherAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);


        artsDepartment =view.findViewById(R.id.artsDepartment);
        scienceDepartment = view.findViewById(R.id.scienceDepartment);
        commerceDepartment = view.findViewById(R.id.commerceDepartment);
        selfFinanceDepartment=view.findViewById(R.id.selfFinanceDepartment);
        ruralDevelopment = view.findViewById(R.id.ruralDevelopment);

        artsNoData = view.findViewById(R.id.artsNoData);
        scienceNoData = view.findViewById(R.id.scienceNoData);
        commerceNoData = view.findViewById(R.id.commerceNoData);
        selfFinanceNoData = view.findViewById(R.id.selfFinanceNoData);
        ruralNoData = view.findViewById(R.id.ruralNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        artsDepartment();
        scienceDepartment();
        commerceDepartment();
        selfFinanceDepartment();
        ruralDevelopment();


        return view;

    }




    private void artsDepartment() {
        dbRef = reference.child("Arts");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    artsNoData.setVisibility(View.VISIBLE);
                    scienceDepartment.setVisibility(View.GONE);
                }else {
                    artsNoData.setVisibility(View.GONE);
                    artsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot2: snapshot.getChildren()){
                        TeachersData data = snapshot2.getValue(TeachersData.class);
                        list1.add(data);
                    }
                    artsDepartment.setHasFixedSize(true);
                    artsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    artsDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void scienceDepartment() {
        dbRef = reference.child("Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scienceNoData.setVisibility(View.VISIBLE);
                    scienceDepartment.setVisibility(View.GONE);
                }else {
                    scienceNoData.setVisibility(View.GONE);
                    scienceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list2.add(data);
                    }
                    scienceDepartment.setHasFixedSize(true);
                    scienceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    scienceDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void commerceDepartment() {
        dbRef = reference.child("Commerce");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    commerceNoData.setVisibility(View.VISIBLE);
                    commerceDepartment.setVisibility(View.GONE);
                }else {
                    commerceNoData.setVisibility(View.GONE);
                    commerceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list5.add(data);
                    }
                    commerceDepartment.setHasFixedSize(true);
                    commerceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    commerceDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void selfFinanceDepartment() {

        dbRef = reference.child("Self Finance");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    selfFinanceNoData.setVisibility(View.VISIBLE);
                    selfFinanceDepartment.setVisibility(View.GONE);
                }else {
                    selfFinanceNoData.setVisibility(View.GONE);
                    selfFinanceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list5.add(data);
                    }
                    selfFinanceDepartment.setHasFixedSize(true);
                    selfFinanceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    selfFinanceDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void ruralDevelopment() {

        dbRef = reference.child("Rural Development");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ruralNoData.setVisibility(View.VISIBLE);
                    ruralDevelopment.setVisibility(View.GONE);
                }else {
                    ruralNoData.setVisibility(View.GONE);
                    ruralDevelopment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list5.add(data);
                    }
                    ruralDevelopment.setHasFixedSize(true);
                    ruralDevelopment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    ruralDevelopment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}