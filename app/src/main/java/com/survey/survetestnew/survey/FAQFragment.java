package com.survey.survetestnew.survey;


import android.content.Context;
import android.os.Bundle;
/*import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;*/
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*import com.cs.nks.easycouriers.R;
import com.cs.nks.easycouriers.util.UTIL;*/

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.survey.survetestnew.R;
import com.survey.survetestnew.util.UTIL;

import java.util.Timer;

/**
 * A simple {@link Fragment} subclass.
 */
public class FAQFragment extends Fragment {

    Context myContext;
    UTIL utill;
    Timer timer;
    private int currentPage = 0;
    private ViewPager mViewPager;

    public FAQFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.activity_about_us, container, false);
        getActivity().setTitle("FAQ");
        myContext = getActivity();


        return rootView;

    }


}
