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
public class FragBottom extends Fragment {


    public FragBottom() {
        // Required empty public constructor
    }

    public static FragBottom getInstance() {
        FragBottom fragBottom = new FragBottom();

        return  fragBottom;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View viewRoot = inflater.inflate(R.layout.fragment_frag_bottom, container, false);
        viewRoot.findViewById(R.id.btnBottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).loadFragments(R.id.frag_Container,FragContainer.getInstance(R.drawable.ic_likegray));
            }
        });
        return viewRoot;
    }




}
