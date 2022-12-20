package com.example.bnncollegee_connect.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bnncollegee_connect.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private StreamAdapter adapter;
    private List<StreamModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();

        // All Stream Initialization in View Pager In About us

        list.add(new StreamModel(R.drawable.ic_cs,"Computer Science","The University Department of Computer Science established in 2008.\n" +
                "Students will demonstrate in-depth knowledge in one of the offered concentration areas."));

        list.add(new StreamModel(R.drawable.ic_cs,"Information Technology","The University Department of Information Technology established in 2003.\n" +
                "To inculcate among students variant ways to gain knowledge and understanding of new developments in Information Technology."));

        list.add(new StreamModel(R.drawable.ic_cs,"Biotechnology And Microbiology","Our college was affiliated to university of Pune up to 1973 since 1974 it is affiliated to University of Mumbai.\n" +
                "To make students aware recent trends in Microbiology and Biotechnology."));

        list.add(new StreamModel(R.drawable.ic_cs,"BAF – B.COM","Department of BAF was established in June 2003-2004.\n" +
                "To guide the students to learn analytical skills in the areas of finance, accounting or other areas of commerce."));

        list.add(new StreamModel(R.drawable.ic_cs,"Bachelor of Management Studies","Department of BMS was established in June 1999-2000.\n" +
                "To give and adequate exposure to operational environment in the field of Banking Insurance & other related financial services."));


        list.add(new StreamModel(R.drawable.ic_cs,"Bachelor of Banking Insurance","Department of BBI was established in  2004-2005.\n" +
                "To prepare student to explore opportunities, being newly created, in the field of Banking & Insurance due to Globalisation, Privatisation & Liberalisation."));

        list.add(new StreamModel(R.drawable.ic_cs,"Bachelor of Financial Marketing","Department of BFM was established in  2010-2011.\n" +
                "To provide adequate basic understanding about financial services among the student."));

        list.add(new StreamModel(R.drawable.ic_cs,"Bachelor of Mass Media ","Department of BMM was established in  2011-2012\n" +
                "To produce graduates to be leaders of the society with a sense of high morality, advanced skills and insightful attitudes."));

        list.add(new StreamModel(R.drawable.ic_cs," M.Com in Management","Department of BMM was established in  2011-2012\n"));



        adapter = new StreamAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.streamViewPager);
        viewPager.setAdapter(adapter);


        return view;
    }
}