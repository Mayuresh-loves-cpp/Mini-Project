package com.example.healthmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HealthIssues#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HealthIssues extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HealthIssues() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HealthIssues.
     */
    // TODO: Rename and change types and number of parameters
    public static HealthIssues newInstance(String param1, String param2) {
        HealthIssues fragment = new HealthIssues();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_health_issues, container, false);

        /*Bundle bundle = getArguments();
        assert bundle != null;
        String firstSymptom = bundle.getString("s1");
        String secondSymptom = bundle.getString("s2");
        String thirdSymptom = bundle.getString("s3");
        String fourthSymptom = bundle.getString("s4");

        Search s = new Search();
        if (firstSymptom != null){
            s.clearSymptomList();
            s.searchDisease(firstSymptom);
        }
        if (secondSymptom != null){
            s.clearSymptomList();
            s.searchDisease(secondSymptom);
        }
        if (thirdSymptom != null){
            s.clearSymptomList();
            s.searchDisease(thirdSymptom);
        }
        if (firstSymptom != null){
            s.clearSymptomList();
            s.searchDisease(fourthSymptom);
        }*/

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("surveyData", Context.MODE_PRIVATE);
        String firstSymptom = sharedPreferences.getString("symptom1", "");
        String secondSymptom = sharedPreferences.getString("symptom2", "");
        String thirdSymptom = sharedPreferences.getString("symptom3", "");
        String fourthSymptom = sharedPreferences.getString("symptom4", "");
        Search s = new Search();
        if (firstSymptom != null && !firstSymptom.equals("")){
            System.out.println("1st symptom was: " + firstSymptom);
            s.clearSymptomList();
            s.searchDisease(firstSymptom);
        }
        if (secondSymptom != null && !secondSymptom.equals("")){
            System.out.println("2nd symptom was: " + secondSymptom);
            s.clearSymptomList();
            s.searchDisease(secondSymptom);
        }
        if (thirdSymptom != null && !thirdSymptom.equals("")){
            System.out.println("3rd symptom was: " + thirdSymptom);
            s.clearSymptomList();
            s.searchDisease(thirdSymptom);
        }
        if (firstSymptom != null && !fourthSymptom.equals("")){
            System.out.println("4th symptom was: " + fourthSymptom);
            s.clearSymptomList();
            s.searchDisease(fourthSymptom);
        }
        String[] st;
        if (s.givenSymptomList != null){
            st = s.initialDiseaseList;
        }
        else {
            st = new String[1];
            st[0] = "No Data";
        }
        ListView listView = (ListView) view.findViewById(R.id.predictedDiseasesList);
        ArrayAdapter <String> predictedListAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                st
        );
        listView.setAdapter(predictedListAdapter);
        System.out.println(Arrays.toString(st));
        return view;
    }
}