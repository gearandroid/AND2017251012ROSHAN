package com.codekul.roshan.fragmentation2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragMain extends Fragment {


    public static final String KEY_IMG = "keyImage";

    public FragMain() {
        // Required empty public constructor
    }

    public static FragMain getInstance(int image){

        FragMain fragMain = new FragMain();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_IMG,image);

        fragMain.setArguments(bundle);

        return fragMain;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frag_main, container, false);

        Bundle bundlelocal = getArguments();
        bundlelocal.getInt(KEY_IMG);

        ((ImageView)rootView.findViewById(R.id.imgMain)).setImageResource(bundlelocal.getInt(KEY_IMG));
        return rootView;
    }

}
