package com.example.epidemicsimulator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankSorting {
    public static void sortRank(List<MainData> data){
        Collections.sort(data, new Comparator<MainData>() {
            @Override
            public int compare(MainData mainData, MainData t1) {
                return -mainData.getPoint()+t1.getPoint();
            }
        });
    }
}
