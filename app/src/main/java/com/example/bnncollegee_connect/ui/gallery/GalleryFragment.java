package com.example.bnncollegee_connect.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bnncollegee_connect.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView republicDay, independenceDay, convocation, anualGathering, otherEvents;
    GalleryAdapter adapter;

    DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);

        republicDay = view.findViewById(R.id.republicDay);
        independenceDay = view.findViewById(R.id.independenceDay);
        convocation = view.findViewById(R.id.convocation);
        anualGathering = view.findViewById(R.id.annualGathering);
        otherEvents = view.findViewById(R.id.otherEvents);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getRepublicDayImg();
        getIndependenceDayImg();
        getConvocationImg();
        getAnnualgatheringImg();
        getotherEvents();
        return view;
    }


    private void getRepublicDayImg() {
        reference.child("Republic Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                // setting layout in recycler View

                republicDay.setLayoutManager(new GridLayoutManager(getContext(),3));
                republicDay.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Data not found", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getIndependenceDayImg() {
        // REMAINING
    }

    private void getConvocationImg() {
        reference.child("Convocations").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                // setting layout in recycler View

                convocation.setLayoutManager(new GridLayoutManager(getContext(),3));
                convocation.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Data not found", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAnnualgatheringImg() {

        reference.child("Annual Social Gathering").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                // setting layout in recycler View

                anualGathering.setLayoutManager(new GridLayoutManager(getContext(),3));
                anualGathering.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Data not found", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getotherEvents() {

        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);

                // setting layout in recycler View
                otherEvents.setLayoutManager(new GridLayoutManager(getContext(),3));
                otherEvents.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Data not found", Toast.LENGTH_SHORT).show();
            }
        });


    }
}