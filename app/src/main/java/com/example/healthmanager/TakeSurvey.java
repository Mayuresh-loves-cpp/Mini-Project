package com.example.healthmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

import static com.example.healthmanager.R.array.contactTypes;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TakeSurvey#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TakeSurvey extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText Symptom1, Symptom2,Symptom3, Symptom4;
    public TakeSurvey() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TakeSurvey.
     */
    // TODO: Rename and change types and number of parameters
    public static TakeSurvey newInstance(String param1, String param2) {
        TakeSurvey fragment = new TakeSurvey();
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

        View v = inflater.inflate(R.layout.fragment_take_survey, container, false);

        Spinner contactSpinnerView = (Spinner) v.findViewById(R.id.contactSpinner);

        String[] contactsItem = getResources().getStringArray(contactTypes);

        ArrayAdapter<String> contactTypesAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, contactsItem
        );
        contactTypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contactSpinnerView.setAdapter(contactTypesAdapter);

        //TextView Symptom1, Symptom2, Symptom3, Symptom4;
        Symptom1 = v.findViewById(R.id.symptom1);
        Symptom2 = v.findViewById(R.id.symptom2);
        Symptom3 = v.findViewById(R.id.symptom3);
        Symptom4 = v.findViewById(R.id.symptom4);
        Button savedataButton = (Button) v.findViewById(R.id.save_data);

        savedataButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public void onClick(View v) {
                /*Bundle bundle = new Bundle();
                bundle.putString("s1", firstSymptom);
                bundle.putString("s2", secondSymptom);
                bundle.putString("s3", thirdSymptom);
                bundle.putString("s4", fourthSymptom);

                FragmentManager fragmentManager;
                fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                HealthIssues healthIssues = new HealthIssues();
                healthIssues.setArguments(bundle);
                fragmentTransaction.replace(R.id.healthIssueFragment, healthIssues);
                fragmentTransaction.commit();*/
                String firstSymptom = Symptom1.getText().toString();
                String secondSymptom = Symptom2.getText().toString();
                String thirdSymptom = Symptom3.getText().toString();
                String fourthSymptom = Symptom4.getText().toString();

                SharedPreferences sp = getActivity().getSharedPreferences("surveyData", Context.MODE_PRIVATE);
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor;
                editor = sp.edit();
                editor.putString("symptom1", firstSymptom);
                editor.putString("symptom2", secondSymptom);
                editor.putString("symptom3", thirdSymptom);
                editor.putString("symptom4", fourthSymptom);
                editor.commit();
                Toast.makeText(getActivity(), "Data Saved!", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Go and find your results in health issues section", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}