package com.example.healthmanager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

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
                "Clean hands, healthy space.",
                "Regularly and thoroughly clean your hands with an alcohol-based hand rub or wash them with soap and water. This eliminates germs including viruses that may be on your hands."
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Safe food, good life.",
                "Eat a variety of nutrient-rich foods. Your body needs more than 40 different nutrients for good health."
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Take a Vitamin D3 if you don't get much Sun exposure",
                "Sunlight is a great source of vitamin D most people don't get enough Sun exposure in fact about 41.6 % of the US population is a deficient in this critical vitamin.  if you are unable to get adequate Sun exposure vitamin D supplement are a good alternative. \n" +
                        "\n" +
                        "Benefits include improve bone health increase strength reduce symptoms of a depression and lower risk of Cancer vitamin D may also help you to live longer"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Avoid Bright light before sleep",
                "When you're  exposed  to bright light in the evening,  it may disrupt your production of the sleep hormones  melatonin.\n" +
                        "\n" +
                        "One strategy is to use a pair of armed Titan Glass that block blue light rays from entering your eyes in the evening."
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Breath in, breath out",
                "Deep breathing is body's one of the strongest self-healing tools. It lowers blood pressure, reduces heart rate, decreases stress hormones, oxygenates blood, exercises the lungs and improves immunity."
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Cardamom tea",
                "If you are suffering from stress, eating cardamom or making tea and drinking it completely changes your brain hormones and makes you feel refreshed."
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Make sure to eat enough protein!",
                "Eating enough protein is a vital for optimal health , what's more , this nutrient is a particularly important for weight loss high protein intake can boost the metabolism significantly while making you feel full  enough to automatically it fewer calories. It can also reduce the craving and your desire to snack late at night sufficient protein intake has also been through to shown to lower blood sugar and blood pressure levels"
        ));
        homeScreenContentList.add(new HomeScreenContent(
                "Don't go on long term diet !",
                "Diet are the rarely work well in the long term. Dieting is one of the strongest predictors for a future weight gain.\n" +
                        "\n" +
                        "Instead of going on diet , try adopting a Healthy lifestyle focus on the nourishing your body instead of depriving it. \n" +
                        "Weight loss should follow as you transition to whole, nutrition foods"
        ));

        Toast.makeText(getActivity(), "Some Health Tips for you!", Toast.LENGTH_LONG).show();
    }
}