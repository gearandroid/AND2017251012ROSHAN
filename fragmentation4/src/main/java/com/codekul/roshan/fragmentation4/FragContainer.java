package com.codekul.roshan.fragmentation4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragContainer extends Fragment {


    public static final String KEY_CENTER_IMAGE = "imageCenter";

    public FragContainer() {
        // Required empty public constructor
    }

    public static FragContainer getInstance(int image) {
        FragContainer fragCont=new FragContainer();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_CENTER_IMAGE,image);

        fragCont.setArguments(bundle);
        return fragCont;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_frag_container, container, false);

        Bundle bundleCenter = getArguments();

        ((ImageView) viewRoot.findViewById(R.id.img_Container)).setImageResource(bundleCenter.getInt(KEY_CENTER_IMAGE));

        return viewRoot;
    }
}
