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
public class Frag_Top extends Fragment {


    public Frag_Top() {
        // Required empty public constructor
    }

    public static Frag_Top getInstance() {
        Frag_Top fragTop = new Frag_Top();

        return fragTop;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View viewRoot =inflater.inflate(R.layout.fragment_frag__top, container, false);
        viewRoot.findViewById(R.id.btnTop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).loadFragments(R.id.frag_Container,FragContainer.getInstance(R.drawable.ic_owl));
            }
        });
        return viewRoot;
    }

}
