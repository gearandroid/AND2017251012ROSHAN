package com.codekul.roshan.fragmentation3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class frameContainer extends Fragment {


    private static final String KEY_IMAGE = "imageToBeLoaded" ;

    public frameContainer() {
        // Required empty public constructor
    }

    public static frameContainer getInstance(int image){
        frameContainer fragCont = new frameContainer();

        Bundle bundle=new Bundle();
        bundle.putInt(KEY_IMAGE,image);
        fragCont.setArguments(bundle);

        return fragCont;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frame_container, container, false);

        Bundle bundleLocal = getArguments();
        bundleLocal.getInt(KEY_IMAGE);

        ((ImageView)rootView.findViewById(R.id.imgMain)).setImageResource(bundleLocal.getInt(KEY_IMAGE));
        return rootView;
    }

}
