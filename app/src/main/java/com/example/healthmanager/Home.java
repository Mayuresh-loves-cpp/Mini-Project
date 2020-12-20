package com.example.healthmanager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    RecyclerView recyclerView;
    List<HomeScreenContent> homeScreenContentList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.homeScreenRecyclerView);
        
        initData();
        setRecyclerView();
        
        return view;
    }

    private void setRecyclerView() {
        HomeScreenContentAdapter homeScreenContentAdapter = new HomeScreenContentAdapter(homeScreenContentList);
        recyclerView.setAdapter(homeScreenContentAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        homeScreenContentList = new ArrayList<>();
        homeScreenContentList.add(new HomeScreenContent(
                "Welcome to Health Manager",
                "this is health manager"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Tip1",
                "Tip1 Description"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Tip2",
                "Tip2 Description"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Tip3",
                "Tip3 Description"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Tip4",
                "Tip4 Description"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Tip5",
                "Tip5 Description"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Tip6",
                "Tip6 Description"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Tip7",
                "Tip7 Description"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Tip8",
                "Tip8 Description"
        ));
    }
}