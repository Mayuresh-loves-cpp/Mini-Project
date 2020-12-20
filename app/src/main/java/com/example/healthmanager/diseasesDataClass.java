package com.example.healthmanager;

public class diseasesDataClass extends dataClass{
    public static String[] diseases = {
            /*Headache related*/ "Migraine", "Tention-type Headaches", "Infection",
            /*stomach ache related*/ "Stomach flu", "Appendicitis", "Diverticulitis", "Gastritis",
            /*muscle pain related*/ "Muscle strain", "Myositis", "Infection",
            /*sore throat related*/ "Common cold", "Flu", "Covid" , "Strep throat", "Tonsillitis", "Upper respiratory infection",
            /*back pain related*/ "Muscle strain", "Obesity", "Slipped disc",
            /*pain in chest related*/ "Heart Attack", "Cardiovascular disease",
            /*cough related*/ "Upper respiratory infection", "Asthma", "Common cold", "Covid",
            /*fever related*/ "Flu", "Covid", "Stomach flu", "Heat exhaustion and heatstroke", "Strep throat",
            /*cold related*/ "Common cold"
    };

    public static String[] diseasesIncludingHeadache = {"Migraine", "Tention-type Headaches", "Infection"};

    public static String[] diseasesIncludingStomachache = {"Stomach flu", "Appendicitis", "Diverticulitis", "Gastritis"};

    public static String[] diseasesIncludingMusclePain = {"Muscle strain", "Myositis", "Infection"};

    public static String[] diseasesIncludingSoreThroat = {"Common cold", "Flu", "Covid" , "Strep throat", "Tonsillitis", "Upper respiratory infection"};

    public static String[] diseasesIncludingBackPain = {"Muscle strain", "Obesity", "Slipped disc"};

    public static String[] diseasesIncludingPainInChest = {"Heart Attack", "Cardiovascular disease"};

    public static String[] diseasesIncludingCough = {"Upper respiratory infection", "Asthma", "Common cold", "Covid"};

    public static String[] diseasesIncludingFever = {"Flu", "Covid", "Stomach flu", "Heat exhaustion and heatstroke", "Strep throat"};

    public static String[] diseasesIncludingCold = {"Common cold"};
}
