package com.example.healthmanager;

import java.util.Arrays;

public class Search extends diseasesDataClass{
    int listLength = 0;
    String[] givenSymptomList = new String[listLength];
    boolean statusFlag;

    public void clearSymptomList(){
        givenSymptomList = new String[0];
    }

    public void addSymptom(String ele) {
        int i;
        String[] newArray = new String[listLength + 1];
        for (i = 0; i < listLength; i++) {
            newArray[i] = givenSymptomList[i];
        }
        newArray[listLength] = ele;
        givenSymptomList = newArray;
    }

    public void searchDisease(String givenSymptom) {
        for(String symptom:symptoms) {
            if(givenSymptom.contains(symptom)) {
                addSymptom(symptom);
            }
        }
        checkDisease();
    }

    String[] initialDiseaseList = new String[0];

    public String[] mergeArray(String[] arr1, String[] arr2) {
        int newArrayLength = arr1.length + arr2.length;
        int index = 0;
        String[] mergeArray = new String[newArrayLength];
        for (String element : arr1) {
            mergeArray[index] = element;
            index++;
        }
        for (String element : arr2) {
            mergeArray[index] = element;
            index++;
        }
        return mergeArray;
    }

    public void checkDisease() {
        //int storeIndex = 0;
        System.out.println("Predicted diseases according to given symptoms: -");
        for(String disease:givenSymptomList) {

            switch (disease){
                case "headache" :
                    initialDiseaseList = mergeArray(diseasesIncludingHeadache, initialDiseaseList);
                    break;
                case "stomach ache" :
                    initialDiseaseList = mergeArray(diseasesIncludingStomachache, initialDiseaseList);
                    break;
                case "muscle pain" :
                    initialDiseaseList = mergeArray(diseasesIncludingMusclePain, initialDiseaseList);
                    break;
                case "sore throat" :
                    initialDiseaseList = mergeArray(diseasesIncludingSoreThroat, initialDiseaseList);
                    break;
                case "back pain" :
                    initialDiseaseList = mergeArray(diseasesIncludingBackPain, initialDiseaseList);
                    break;
                case "pain in chest" :
                    initialDiseaseList = mergeArray(diseasesIncludingPainInChest, initialDiseaseList);
                    break;
                case "cough" :
                    initialDiseaseList = mergeArray(diseasesIncludingCough, initialDiseaseList);
                    break;
                case "fever" :
                    System.out.println("in fever condition");
                    initialDiseaseList = mergeArray(diseasesIncludingFever, initialDiseaseList);
                    break;
                case "cold" :
                    initialDiseaseList = mergeArray(diseasesIncludingCold, initialDiseaseList);
                    break;
                default:
                    statusFlag = false;
                    break;
            }
        }
        System.out.println("printing initial list " + Arrays.toString(initialDiseaseList));
        System.out.println("symptom list: "+ Arrays.toString(givenSymptomList));
    } // method checkDisease ends here
}
